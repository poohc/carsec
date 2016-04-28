package com.pama.front.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageCategoryService;
import com.pama.bbs.service.MessageCommentService;
import com.pama.bbs.service.MessageRecommendService;
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageAttachmentVO;
import com.pama.bbs.vo.MessageCommentFormVO;
import com.pama.bbs.vo.MessageCommentListVO;
import com.pama.bbs.vo.MessageCommentSearchVO;
import com.pama.bbs.vo.MessageFormVO;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageRecommendVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageStatVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.common.Constants;
import com.pama.common.util.BeenUtil;
import com.pama.common.util.ConvertUtil;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbrpoint.service.PointService;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/bbs/*")
public class FrontMessageController {

	private static final Log LOG = LogFactory.getLog(FrontMessageController.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageCommentService messageCommentService;

	@Autowired
	private MessageCategoryService messageCategoryService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private MessageRecommendService messageRecommendService;

	@Autowired
	private PointService pointService;

	private final static String FRONT_SKIN_PREFIX="/front/boardType/";

	@RequestMapping("/{boardKey}/{viewSkin}messageList")
	public ModelAndView getMessageList(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageList' controller...");
		}
		String loginId = "";
		if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}

		ModelAndView mav = new ModelAndView();
		messageSearchVO.setStatusType("2");//게재만
		if( StringUtils.startsWith(viewSkin,"cafe") ){//정보홈페이지
			String mbrInfoId = request.getParameter("infoid");
			if(StringUtils.isNotEmpty(mbrInfoId) ){
				AccountVO  accountVO = accountInfoService.getAccountInfo(mbrInfoId);
				mav.addObject("ACCOUNTVO", accountVO);
				messageSearchVO.setRegisterId(accountVO.getMbrId());

				MessageStatVO messageStatVO = messageService.getMessageStat(messageSearchVO);
				mav.addObject("messageStatVO", messageStatVO);

				if( StringUtils.equals(accountVO.getMbrId(), loginId) ){ //현재 나의 페이지인경우
					messageSearchVO.setStatusType("12");//게재만 나오게
				}

			}
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		if ("1".equals(boardVO.getTopMessageFlag())) {	// 공지사항 사용여부 체크
			messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
		}
		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		messageSearchVO.setRow(Integer.parseInt(boardVO.getListLines())); //listLines
		if(SessionUtil.isFrontLogin() && StringUtils.equals(boardKey, "qna")){
			messageSearchVO.setMyListId(loginId);
			messageSearchVO.setStatusType("me");
		}

		MessageListVO messageList = messageService.getMessageList(messageSearchVO);


		mav.addObject("boardVO", boardVO);
		mav.addObject("messageList", messageList);
		//TODO : 삭제예정 : front/skin/board/ + notice + /messageList

		///WEB-INF/jsp/   .jsp
		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+viewSkin+"messageList");
		return mav;
	}

	@RequestMapping("/{boardKey}/{viewSkin}messageDetail")
	public ModelAndView getMessageDetail(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessage' controller...");
		}


		String loginId = "";
		if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}

		ModelAndView mav = new ModelAndView();

		if( StringUtils.startsWith(viewSkin,"cafe") ){
			String mbrInfoId = request.getParameter("infoid");
			if(StringUtils.isNotEmpty(mbrInfoId) ){
				AccountVO  accountVO = accountInfoService.getAccountInfo(mbrInfoId);
				mav.addObject("ACCOUNTVO", accountVO);
				messageSearchVO.setRegisterId(accountVO.getMbrId());

				MessageStatVO messageStatVO = messageService.getMessageStat(messageSearchVO);
				mav.addObject("messageStatVO", messageStatVO);
			}
		}

		String registerIp = request.getRemoteAddr();

		BoardVO boardVO = boardService.getBoard(boardKey);

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageVO = messageService.getMessageOne(messageSearchVO);
		if(StringUtils.isNotEmpty(messageVO.getContents())){
			messageVO.setContents(ConvertUtil.getImageTagChange(messageVO.getContents(), 700, 0));
		}

		MessageVO messagePrevVO = messageService.getMessageViewPrev(messageSearchVO);
		MessageVO messageNextVO = messageService.getMessageViewNext(messageSearchVO);

		MessageFormVO messageFormVO = new MessageFormVO();
		messageFormVO.setMessageId(String.valueOf(messageVO.getMessageId()));
		if ("".equals(loginId)) {
			messageFormVO.setRegisterId("");
		} else {
			messageFormVO.setRegisterId(loginId);
		}
		messageService.modifyMessageAddViewCount(messageFormVO);


		MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
		messageCommentSearchVO.setMessageId(messageSearchVO.getMessageId());
		MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);

		messageCommentSearchVO.setTitle("AA");
		MessageCommentListVO messageCommentListEventAA = messageCommentService.getMessageCommentEventList(messageCommentSearchVO);

		messageCommentSearchVO.setTitle("BB");
		MessageCommentListVO messageCommentListEventBB = messageCommentService.getMessageCommentEventList(messageCommentSearchVO);

		messageCommentSearchVO.setRegisterId(loginId);
		int messageCommentRegisterIdCount = messageCommentService.getMessageCommentRegisterIdCount(messageCommentSearchVO);

		//getMessageRecommendRegisterId 추천했냐 안했냐? messageRecommendService
		MessageRecommendVO messageRecommendVO = messageRecommendService.getMessageRecommendRegisterId(Integer.parseInt(messageSearchVO.getMessageId()), loginId);
		if( messageRecommendVO != null ){
			mav.addObject("recommendYN", "Y");
		}

		mav.addObject("messageCommentListEventAA", messageCommentListEventAA);
		mav.addObject("messageCommentListEventBB", messageCommentListEventBB);
		mav.addObject("messageCommentList", messageCommentListVO);
		mav.addObject("loginId", loginId);
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageVO);
		mav.addObject("messagePrevVO", messagePrevVO);
		mav.addObject("messageCommentRegisterIdCount", messageCommentRegisterIdCount);

		mav.addObject("messageNextVO", messageNextVO);
		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+viewSkin+"messageDetail");

		return mav;
	}

	@RequestMapping("/{boardKey}/{messageId}/message")
	public ModelAndView getMessageContent(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("messageId") String messageId,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageView' controller...");
		}

		String loginId = "";
		if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}

		BoardVO boardVO = boardService.getBoard("content");
		messageSearchVO.setMessageId(messageId);
		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageVO = messageService.getMessageOne(messageSearchVO);

		MessageFormVO messageFormVO = new MessageFormVO();
		messageFormVO.setMessageId(String.valueOf(messageVO.getMessageId()));
		if ("".equals(loginId)) {
			messageFormVO.setRegisterId("");
		} else {
			messageFormVO.setRegisterId(loginId);
		}

		messageService.modifyMessageAddViewCount(messageFormVO);

		ModelAndView mav = new ModelAndView();

		MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
		messageCommentSearchVO.setMessageId(messageId);
		MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);
		mav.addObject("messageCommentList", messageCommentListVO);

		mav.addObject("loginId", loginId);
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageVO);
		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageDetail");

		return mav;
	}

	/**
	 * Forward 전용 MessageId로만 처리됩니다.그리고 보안상 보드키만 가져옴
	 * @param messageId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/{messageId}/forwardDetail")
	public ModelAndView getForwardDetail(
			@PathVariable("messageId") String messageId,
			HttpServletRequest request,
			HttpServletResponse response){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageFoward' controller...");
		}

		MessageVO messageVO = messageService.getMessageOne2(messageId);
		BoardVO boardVO = boardService.getBoard2( Integer.parseInt(messageVO.getBoardId()) );

		String forwordURI = "/bbs/"+boardVO.getBoardKey()+"/messageDetail.do?messageId="+messageVO.getMessageId();


		return new ModelAndView("redirect:" + forwordURI);
	}

	@RequestMapping("/{boardKey}/{viewSkin}messageForm")
	public ModelAndView getMessageForm(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageForm' controller...");
		}

		if(SessionUtil.isFrontNotLogin()){
			return new ModelAndView("redirect:" + request.getAttribute("loginFormReturnURL"));
		}

		List<BoardVO> boardList = boardService.getMenuList("2").getBoardList();
		BoardVO boardVO = boardService.getBoard(boardKey);

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageInfoVO = null;

		if (!"".equals(messageSearchVO.getMessageId())) {
			messageInfoVO = messageService.getMessageOne(messageSearchVO);
		}


		ModelAndView mav = new ModelAndView();

		if( StringUtils.startsWith(viewSkin,"cafe") ){
			String mbrInfoId = request.getParameter("infoid");
			if(StringUtils.isNotEmpty(mbrInfoId) ){
				AccountVO  accountVO = accountInfoService.getAccountInfo(mbrInfoId);
				mav.addObject("ACCOUNTVO", accountVO);
				messageSearchVO.setRegisterId(accountVO.getMbrId());

				MessageStatVO messageStatVO = messageService.getMessageStat(messageSearchVO);
				mav.addObject("messageStatVO", messageStatVO);
			}
		}

		if ("1".equals(boardVO.getMessageCategoryFlag())) {
			mav.addObject("messageCategoryList", messageCategoryService.getMessageCategorySelectList(messageSearchVO.getBoardId()) );
		}

		mav.addObject("boardCate", boardList);
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageInfoVO);
		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+viewSkin+"messageForm");

		return mav;
	}

	@RequestMapping("/{boardKey}/messageCommentRegister")
	public ModelAndView addMessageComment(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageCommentFormVO messageCommentFormVO
			) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'messageCommentRegister' controller...");
		}

		String loginId = "";
		String loginNm = "";
		String loginEmail = "";
		String loginNickname = "";

		if(SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
			loginNm = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
			loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
			loginNickname = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getNickNm();
			messageCommentFormVO.setRegisterId(loginId);
			messageCommentFormVO.setRegisterName(loginNm);
			messageCommentFormVO.setRegisterEmail(loginEmail);
			messageCommentFormVO.setRegisterNickname(loginNickname);
			messageCommentFormVO.setRegisterIp(request.getRemoteAddr());
			messageCommentService.insertMessageComment(messageCommentFormVO);
			if(SessionUtil.isFrontLogin()){

				pointService.trxAddPoint(loginId, 5, "messageComment", Integer.parseInt(messageCommentFormVO.getCommentId())
						, loginId, loginId, messageCommentFormVO.getRegisterIp());

			}
		}

		return new ModelAndView("redirect:"+messageCommentFormVO.getReturnUrl());
	}

	@RequestMapping("/{boardKey}/messageCommentRecommend")
	public ModelAndView updateMessageCommentRecommendCount(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageCommentFormVO messageCommentFormVO
			) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'messageCommentRegister' controller...");
		}

		String loginId = "";
		String loginNm = "";
		String loginEmail = "";
		String loginNickname = "";
		int row=0;
		if(SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
			loginNm = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
			loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
			loginNickname = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getNickNm();
			messageCommentFormVO.setRegisterId(loginId);
			messageCommentFormVO.setRegisterName(loginNm);
			messageCommentFormVO.setRegisterEmail(loginEmail);
			messageCommentFormVO.setRegisterNickname(loginNickname);
			row=messageCommentService.updateMessageCommentRecommendCount(messageCommentFormVO);
		}

		return new ModelAndView("redirect:"+messageCommentFormVO.getReturnUrl()+"&comment="+row);
	}

	/**
	 * 글쓰기 등록처리
	 * @param boardKey
	 * @param viewSkin
	 * @param request
	 * @param response
	 * @param messageFormVO
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping("/{boardKey}/{viewSkin}messageRegister")
	public ModelAndView addMessage(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'addMessage' controller...");
		}
		BoardVO boardVO = boardService.getBoard(boardKey);
		if (messageFormVO == null) return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageForm.do");

		if( !"qna".equals(boardKey) && !SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크
		}

		String loginId = "";
		String loginNm = "";
		String loginEmail = "";
		String loginNickname = "";
		SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);

		if(sessionVO != null){
			loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
			loginNm = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
			loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
			loginNickname = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getNickNm();
		}else{
			loginId = "guest";
			loginNm = "guest";
			loginEmail = messageFormVO.getVarFiled2();
			loginNickname = "guest";
		}

		if( "online".equals(boardVO.getBoardType()) ) {
			loginNm = messageFormVO.getRegisterName();
			loginEmail = messageFormVO.getVarFiled2();
			loginNickname = "guest";
		}


		messageFormVO.setBoardId(String.valueOf(boardVO.getBoardId())); //게시판이이디

		if (StringUtils.isEmpty(messageFormVO.getParentMessageId())) messageFormVO.setParentMessageId("0");

		String comma = "";

		if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageFormVO.getTags())) comma = ",";

		if (messageFormVO.getTags()==null) messageFormVO.setTags("");
		messageFormVO.setTags( (messageFormVO.getOtags()==null || "".equals(messageFormVO.getOtags())?"":messageFormVO.getOtags() + comma) + messageFormVO.getTags() ); // 기존태그 와 신규태그 결합

		//String topFlag = StringUtils.defaultIfEmpty(messageFormVO.getTopFlag(),"0");
		messageFormVO.setTopFlag("0");
		messageFormVO.setRegisterId(loginId);
		messageFormVO.setRegisterName(loginNm);
		messageFormVO.setRegisterNickname(loginNickname);
		messageFormVO.setRegisterEmail(loginEmail);
		messageFormVO.setRegisterIp(request.getRemoteAddr());
		messageFormVO.setUpdateId(loginId);
		messageFormVO.setUpdateIp(request.getRemoteAddr());
		messageFormVO.setStatusType("2");


		messageFormVO.setProgressStatus(Constants.CONTENTS_PROGRESS_PROG); // 진행
		messageFormVO.setThumbnailUrl("");


		// String 기반의 파일 업로드(미리 업로드하고 처리하는 방식)
		if (messageFormVO.getFiles()!=null) {
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			for (String arrFile : messageFormVO.getFiles()) {
				if (arrFile.startsWith("new")) {
					AttachmentVO attachmentVO = attachmentProcessor.getThumbnailFile(Constants.SERVICE_ID_BBS, arrFile);
					messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId())));
					if (messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
						messageFormVO.setThumbnailUrl("/media/" + attachmentVO.getFileName() + ".image");
					}
				} else {
					if (messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
						messageFormVO.setThumbnailUrl(messageFormVO.getThumbnailUrl());
					}
				}
			}
			messageFormVO.setAttachmentList(messageAttachmentList);
			messageFormVO.setAttachmentCount(messageFormVO.getFiles().length);
		}

		// 멀티파트 기반의 파일 업로드(실제 파일업로드 방식) :: 단일 한개일경우만 처리한다.
		if (messageFormVO.getFile()!=null) {  // 첨부파일이 있으면
			AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getFile());
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId())  ));
			}
			messageFormVO.setAttachmentList(messageAttachmentList);
			messageFormVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());
		}else{

			//showindex 처리 파일들
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			AttachmentVO attachmentVO = null;
			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile1());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 1));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile2());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 2));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile3());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 3));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile4());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 4));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile5());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 5));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile6());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 6));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile7());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 7));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile8());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 8));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile9());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 9));
			}

			messageFormVO.setAttachmentList(messageAttachmentList);
			messageFormVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());

		}

		int messageId = messageService.addMessage(messageFormVO);
		String cafeparam="";
		if( StringUtils.startsWith(viewSkin,"cafe") ){
			String mbrInfoId = messageFormVO.getInfoid();
			cafeparam="?infoid="+mbrInfoId;
		}
		if(StringUtils.equals(boardVO.getBoardType(), "online")  ){
			return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageComplete.do"+cafeparam);
		}else{
			return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageList.do"+cafeparam);
		}
	}

	@RequestMapping("/{boardKey}/{viewSkin}messageComplete")
	public ModelAndView messageComplete(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'messageComplete' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		ModelAndView mav =  new ModelAndView();
		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+viewSkin+"messageComplete");

		return mav;

	}

	@RequestMapping("/{boardKey}/{viewSkin}messageModify")
	public ModelAndView modifyMessage(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'modifyMessage' controller...");
		}

		if (messageFormVO == null) return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageForm.do");

		if( !SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크
			return new ModelAndView("redirect:/bbs/"+boardKey+"/messageForm.do");
		}

		String loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		String loginNm = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
		String loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
		String loginNickname = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getNickNm();

		BoardVO boardVO = boardService.getBoard(boardKey);

		MessageVO messageVO = new MessageVO();
		messageVO = (MessageVO)BeenUtil.load(messageVO, messageFormVO);

		messageVO.setBoardId(String.valueOf(boardVO.getBoardId())); //게시판이이디

		messageVO.setMessageId(Integer.parseInt(messageFormVO.getMessageId()));   // 게시물 코드

		if (StringUtils.isEmpty(messageFormVO.getParentMessageId())) messageVO.setParentMessageId("0");

		String comma = "";
		if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageVO.getTags())) comma = ",";

		messageVO.setTags( (messageFormVO.getOtags()==null?"":messageFormVO.getOtags() + comma) + messageVO.getTags() ); // 기존태그 와 신규태그 결합

		messageVO.setTopFlag("0");
		messageVO.setRegisterId(loginId);
		messageVO.setRegisterName(loginNm);
		messageVO.setRegisterNickname(loginNickname);
		messageVO.setRegisterEmail(loginEmail);
		messageVO.setRegisterIp(request.getRemoteAddr());
		messageVO.setUpdateId(loginId);
		messageVO.setUpdateIp(request.getRemoteAddr());
		messageVO.setStatusType("2");

		if (messageFormVO.getRegisterDateType()!=null) {
			SimpleDateFormat formatter;
			String dateString;
			if ("".equals(messageFormVO.getRegisterDateType())) {
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar now = Calendar.getInstance();
				int hh = now.get(Calendar.HOUR_OF_DAY);
				int mm = now.get(Calendar.MINUTE);
				int ss = now.get(Calendar.SECOND);
				now.setTime(formatter.parse(messageFormVO.getRegisterDate()));
				now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), hh, mm, ss);
				dateString = formatter.format(now.getTime());
			} else if ("0".equals(messageFormVO.getRegisterDateType())) {
				dateString = null;
			} else {
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar now = Calendar.getInstance();
				now.add(Calendar.HOUR_OF_DAY, -Integer.parseInt(messageFormVO.getRegisterDateType()));
				dateString = formatter.format(now.getTime());
			}
			messageVO.setRegisterDate(dateString);
		}

		messageVO.setProgressStatus(Constants.CONTENTS_PROGRESS_PROG); // 진행
		if (messageFormVO.getFiles()!=null) { // 첨부파일 정보 입력
			messageVO.setThumbnailUrl("");
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			for (String arrFile : messageFormVO.getFiles()) {
				if (arrFile.startsWith("new")) {
					AttachmentVO attachmentVO = attachmentProcessor.getThumbnailFile(Constants.SERVICE_ID_BBS, arrFile);
					messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageVO.getBoardId()));
					if (messageFormVO.getThumbnailUrl().indexOf("http") < 0 &&
							messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
						messageVO.setThumbnailUrl("/media/" + attachmentVO.getFileName() + ".image");
					}
				} else {
					if (messageFormVO.getThumbnailUrl().indexOf("http") < 0 &&
							messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
						messageVO.setThumbnailUrl(messageFormVO.getThumbnailUrl());
					}
				}
			}
			messageVO.setAttachmentList(messageAttachmentList);
			messageVO.setAttachmentCount(messageFormVO.getFiles().length);
		}

		if (messageFormVO.getFile()!=null) {  // 첨부파일이 있으면
			AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getFile());
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageVO.getBoardId()));
			}
			messageVO.setAttachmentList(messageAttachmentList);

			if(messageVO.getAttachmentCount() == null){
				messageVO.setAttachmentCount(0);
			}

			messageVO.setAttachmentCount(messageVO.getAttachmentCount() + messageAttachmentList.size());
		}else{

			//showindex 처리 파일들
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			AttachmentVO attachmentVO = null;
			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile1());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 1));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile2());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 2));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile3());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 3));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile4());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 4));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile5());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 5));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile6());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 6));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile7());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 7));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile8());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 8));
			}

			attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile9());
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 9));
			}

			messageFormVO.setAttachmentList(messageAttachmentList);
			messageFormVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());

		}


		if(StringUtils.equals(messageFormVO.getStatusType(), "1")){//대기
			messageVO.setStatusType("1");
		}else{//게재
			messageVO.setStatusType("2");
		}

		String cafeparam="";
		if( StringUtils.startsWith(viewSkin,"cafe") ){
			String mbrInfoId = messageFormVO.getInfoid();
			cafeparam="&infoid="+mbrInfoId;
		}

		MessageVO messageDBVO = messageService.getMessageOne( String.valueOf(boardVO.getBoardId()),  String.valueOf( messageVO.getMessageId()) );

		if( StringUtils.equals(messageDBVO.getRegisterId(),loginId) ){
			messageService.modifyMessage(messageVO);
		}else {
			//TODO : 권한처리
		}

		return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageDetail.do?messageId="+messageVO.getMessageId()+cafeparam);

	}

	@RequestMapping("/{boardKey}/{viewSkin}messageRemoveProc")
	public ModelAndView removeMessage(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageVO messageVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeMessage' controller...");
		}


		String cafeparam="";
		if( StringUtils.startsWith(viewSkin,"cafe") ){
			String mbrInfoId = request.getParameter("infoid");
			cafeparam="infoid="+mbrInfoId;
		}

		if( !SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)) {  //로그인체크

			return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageDetail.do?messageId="+messageVO.getMessageId()+"&"+cafeparam);

		}

		String loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디

		BoardVO boardVO = boardService.getBoard(boardKey);

		if (boardVO != null) { // 시판이 있으면


			MessageVO messageDBVO = messageService.getMessageOne(String.valueOf(boardVO.getBoardId()), String.valueOf( messageVO.getMessageId()) );

			if( StringUtils.equals(messageDBVO.getRegisterId(), loginId) ){
				messageService.removeMessage(messageVO); // 게시물 상태를 변경한다(삭제게시물코드)
			}

		}

		if(StringUtils.isNotEmpty(cafeparam)){
			cafeparam="?"+cafeparam;
		}

		return new ModelAndView("redirect:/bbs/"+boardKey+"/"+viewSkin+"messageList.do"+cafeparam);
	}

	@RequestMapping("/{boardKey}/{viewSkin}messageFinish")
	public ModelAndView getMessageFinish(@PathVariable("boardKey") String boardKey,
			@PathVariable("viewSkin") String viewSkin,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageFinish' controller...");
		}
		BoardVO boardVO = boardService.getBoard(boardKey);
		ModelAndView mav = new ModelAndView();

		mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"/"+viewSkin+"messageFinish");

		return mav;
	}

	/**
	 * messageFileDown
	 * @param boardKey
	 * @param request
	 * @param response
	 * @param fileName
	 * @throws IOException
	 */
	@RequestMapping("{boardKey}/{messageId}/download")
	public void getDownload(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("messageId") String messageId,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam String fileName
			) throws IOException {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getDownload' controller...");
		}

		//현재 로그인 한 사용자 정보취득 포인트 정보
		SessionVO sessionVO = SessionUtil.getFrontSession();

		if(sessionVO !=null ){

			BoardVO boardVO = boardService.getBoard(boardKey);
			//TODO : boardVO 파일다운로드 타입인경우 할건지.

			//Message 정보 취득
			MessageVO messageVO = messageService.getMessageLicenseAttachment(boardVO.getBoardId(), fileName);

			MessageAttachmentVO messageAttachmentVO = messageVO.getDownloadAttachment();
			AttachmentVO attachmentVO = attachmentProcessor.getImage(messageAttachmentVO.getFileName()); //실제 다운로드
			File file = null;
			OutputStream out = null;
			FileInputStream fis = null;
			if(attachmentVO != null){//no 이미지 처리
				file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
			}
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(messageAttachmentVO.getDisplayName(), "UTF-8") +";");
			response.setContentLength( Integer.parseInt(messageAttachmentVO.getFileSize()) );
			response.setHeader("Content-Transfer-Encoding", "binary");
			try {
				out = response.getOutputStream();
				try {
					fis = new FileInputStream(file);
					FileCopyUtils.copy(fis, out);

				} finally {
					if (fis != null){
						try {fis.close();} catch (IOException ex) {}
					}
				}
				out.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
			messageService.modifyMessageAttachmentDownload(fileName);//다운로드수 증가

		}else{
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"잘못된 호출입니다.\");");
			out.println("</script>");
			out.flush();
		}



	}
}

