package com.pama.admin.bbs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageCategoryService;
import com.pama.bbs.service.MessageCommentService;
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageAttachmentVO;
import com.pama.bbs.vo.MessageCommentFormVO;
import com.pama.bbs.vo.MessageCommentListVO;
import com.pama.bbs.vo.MessageCommentSearchVO;
import com.pama.bbs.vo.MessageFormVO;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.bbs.vo.MessageVarFiledsVO;
import com.pama.common.Constants;
import com.pama.common.util.ConvertUtil;
import com.pama.common.util.SessionUtil;
import com.pama.common.util.StringUtil;
import com.pama.mbrpoint.service.PointService;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/message/*")
public class MessageController {
	private static final Log LOG = LogFactory.getLog(MessageController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageCategoryService messageCategoryService;

	@Autowired
	private MessageCommentService messageCommentService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

	@Autowired
	private BoardService boardService;

	@Autowired
	private PointService pointService;

	@RequestMapping("/{boardKey}/messageList")
	public ModelAndView getMessageList(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageList' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		if ("1".equals(boardVO.getTopMessageFlag())) {	// 공지사항 사용여부 체크
			messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
		}
		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		messageSearchVO.setRow(Integer.parseInt(boardVO.getListLinesAdmin())); //listLinesAdmin
		MessageListVO messageList = messageService.getMessageList(messageSearchVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageList", messageList);
		mav.setViewName("/admin/message/"+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageList");

		return mav;
	}

	@RequestMapping("/{boardKey}/messageDetail")
	public ModelAndView getMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessage' controller...");
		}

		String loginId = null;
		if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
			loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageVO = messageService.getMessageOne(messageSearchVO);


		MessageFormVO messageFormVO = new MessageFormVO();
		messageFormVO.setMessageId(String.valueOf(messageVO.getMessageId()));
		if ("".equals(loginId)) {
			messageFormVO.setRegisterId("");
		} else {
			messageFormVO.setRegisterId(loginId);
		}
		//messageService.modifyMessageAddViewCount(messageFormVO);

		ModelAndView mav = new ModelAndView();

		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageVO);
		mav.addObject("loginId", loginId);
		mav.setViewName("/admin/message/"+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageDetail");

		return mav;
	}

	@RequestMapping("/{boardKey}/messageForm")
	public ModelAndView getMessageForm(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageForm' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);


		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageInfoVO = null;

		if (!"".equals(messageSearchVO.getMessageId())) {
			messageInfoVO = messageService.getMessageOne(messageSearchVO);
		}

		ModelAndView mav = new ModelAndView();

		if ("1".equals(boardVO.getMessageCategoryFlag())) {
			mav.addObject("messageCategoryList", messageCategoryService.getMessageCategorySelectList(messageSearchVO.getBoardId()) );
		}

		MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
		messageCommentSearchVO.setMessageId(messageSearchVO.getMessageId());
		MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);
		mav.addObject("messageCommentList", messageCommentListVO);

		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageInfoVO);
		mav.setViewName("/admin/message/"+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageForm");

		return mav;
	}

	@RequestMapping("/{boardKey}/messageReplyForm")
	public ModelAndView getMessageReplyForm(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageReplyForm' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		MessageVO messageQuestionVO = messageService.getMessageOne(messageSearchVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageVO", messageQuestionVO);
		mav.setViewName("/admin/message/"+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageReplyForm");

		return mav;
	}

	/**
	 * 글쓰기(답변쓰기)
	 * @param boardKey
	 * @param request
	 * @param response
	 * @param messageFormVO
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping("/{boardKey}/messageRegister")
	public ModelAndView addMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO,
			MessageVarFiledsVO messageVarFiledsVO
			) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'addMessage' controller...");
			LOG.debug(messageFormVO.toString());
		}

		if (messageFormVO == null) return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageForm.do");

		if( !SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)) {  //로그인체크
			return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageForm.do");
		}

		String loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		String loginNm = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMemberNm();  //
		String loginEmail = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getEmail();
		String loginNickname = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getNickNm();

		BoardVO boardVO = boardService.getBoard(boardKey);

		messageFormVO.setBoardId(String.valueOf(boardVO.getBoardId())); //게시판이이디

		if (StringUtils.isEmpty(messageFormVO.getParentMessageId())) messageFormVO.setParentMessageId("0");

		String comma = "";
		if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageFormVO.getTags())) {
			comma = ",";
		}

		messageFormVO.setTags( (messageFormVO.getOtags()==null?"":messageFormVO.getOtags() + comma) + messageFormVO.getTags() ); // 기존태그 와 신규태그 결합
		String topFlag = StringUtils.defaultIfEmpty(messageFormVO.getTopFlag(),"0");
		messageFormVO.setTopFlag(topFlag);

		messageFormVO.setRegisterId(loginId);
		messageFormVO.setRegisterName(loginNm);
		messageFormVO.setRegisterNickname(loginNickname);
		messageFormVO.setRegisterEmail(loginEmail);
		messageFormVO.setRegisterIp(request.getRemoteAddr());
		messageFormVO.setUpdateId(loginId);
		messageFormVO.setUpdateIp(request.getRemoteAddr());

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

			messageFormVO.setRegisterDate(dateString);
		}

		messageFormVO.setProgressStatus(Constants.CONTENTS_PROGRESS_PROG); // 진행
		messageFormVO.setThumbnailUrl("");
		if (messageFormVO.getFiles()!=null) { // 첨부파일 정보 입력
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			for (String arrFile : messageFormVO.getFiles()) {
				if (arrFile.startsWith("new")) {
					AttachmentVO attachmentVO = attachmentProcessor.getThumbnailFile(Constants.SERVICE_ID_BBS, arrFile);
					messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageFormVO.getBoardId()));
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

		if (messageFormVO.getFile()!=null) {  // 첨부파일이 있으면
			AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getFile());
			List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
			if(attachmentVO!=null){
				messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageFormVO.getBoardId()));
			}
			messageFormVO.setAttachmentList(messageAttachmentList);
			messageFormVO.setAttachmentCount( messageFormVO.getAttachmentCount() + messageAttachmentList.size());
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


		try {
			//TODO : tag말고 쓴는 방법을 확인하자.
			ObjectMapper objectMapper = new ObjectMapper();
			String varFileds =  objectMapper.writeValueAsString(messageVarFiledsVO);
			messageFormVO.setVarFileds(varFileds);
		} catch (Exception e) {
			LOG.error("JSON ERROR[varFileds]" + e.getMessage());
		}


		messageService.addMessage(messageFormVO);

		MessageVO parentMessageVO = messageService.getMessageOne2(messageFormVO.getParentMessageId());


		if(StringUtils.isNotEmpty(messageFormVO.getPointInit()) ){
			pointService.trxUsePoint(parentMessageVO.getRegisterId(), Integer.parseInt(messageFormVO.getPointInit()), "PointUse:워셔액지급", parentMessageVO.getMessageId(), parentMessageVO.getRegisterId(), messageFormVO.getRegisterId(), messageFormVO.getRegisterIp());

			MessageVO messageVarFiled1VO = new MessageVO();
			messageVarFiled1VO.setMessageId(parentMessageVO.getMessageId());
			messageVarFiled1VO.setVarFiled1("0");
			messageService.modifyVarFiled1(messageVarFiled1VO);



		}

		return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageList.do");

	}

	@RequestMapping("/{boardKey}/messageModify")
	public ModelAndView modifyMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO,
			MessageVarFiledsVO messageVarFiledsVO
			) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'modifyMessage' controller...");
		}

		if (messageFormVO == null) return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageForm.do");

		if( !SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)) {  //로그인체크
			return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageForm.do");
		}

		String loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		String loginNm = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMemberNm();  //
		String loginEmail = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getEmail();
		String loginNickname = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getNickNm();

		BoardVO boardVO = boardService.getBoard(boardKey);

		MessageVO messageVO = new MessageVO();
		BeanUtils.copyProperties(messageVO, messageFormVO);

		messageVO.setBoardId(String.valueOf(boardVO.getBoardId())); //게시판이이디

		messageVO.setMessageId(Integer.parseInt(messageFormVO.getMessageId()));   // 게시물 코드

		if (StringUtils.isEmpty(messageFormVO.getParentMessageId())) messageVO.setParentMessageId("0");

		String comma = "";
		if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageVO.getTags())) comma = ",";

		messageVO.setTags( (messageFormVO.getOtags()==null?"":messageFormVO.getOtags() + comma) + messageVO.getTags() ); // 기존태그 와 신규태그 결합

		if( !StringUtil.equals(messageVO.getTopFlag(),"0") ){
			messageVO.setTopFlag("1");
		}

		messageVO.setRegisterId(loginId);
		messageVO.setRegisterName(loginNm);
		messageVO.setRegisterNickname(loginNickname);
		messageVO.setRegisterEmail(loginEmail);
		messageVO.setRegisterIp(request.getRemoteAddr());
		messageVO.setUpdateId(loginId);
		messageVO.setUpdateIp(request.getRemoteAddr());

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

		    messageVO.setAttachmentList(messageAttachmentList);
		    messageVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());
		}


		try {
			//TODO : tag말고 쓴는 방법을 확인하자.
			ObjectMapper objectMapper = new ObjectMapper();
			String varFileds =  objectMapper.writeValueAsString(messageVarFiledsVO);
			messageVO.setVarFileds(varFileds);
		} catch (Exception e) {
			LOG.error("JSON ERROR[varFileds]" + e.getMessage());
		}


		messageService.modifyMessage(messageVO);

		return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageForm.do?messageId="+messageVO.getMessageId());

	}

	@RequestMapping("/{boardKey}/messageRemoveProc")
	public ModelAndView removeMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageVO messageVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeMessage' controller...");
		}

		//TODO : 관리자가 세분화
		String updateId = "";
		if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
			updateId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}

		BoardVO boardVO = boardService.getBoard(boardKey);
		messageVO.setUpdateId(updateId);
		if (boardVO != null) { // 게시판이 있으면
			messageService.removeMessage(messageVO);
		}

		return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageList.do");
	}

	@RequestMapping("/{boardKey}/messageErasureProc")
	public ModelAndView removeAllMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageVO messageVO) {

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeAllMessage' controller...");
		}
		messageService.removeAllMessage(messageVO); // 게시물에 관련된 파일 및 컨텐츠를 모두 삭제한다.

		return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageList.do");
	}

	@RequestMapping("/{boardKey}/messageRemoveSelectProc")
	public ModelAndView removeSelectMessage(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageFormVO messageFormVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeSelecMessage' controller...");
		}

		messageService.removeSelectMessage(messageFormVO);

		return new ModelAndView("redirect:/admin/message/"+boardKey+"/messageList.do");
	}

	@RequestMapping(value="/{boardKey}/messageAttachmentDelete.json", method = RequestMethod.GET)
	public ModelAndView removeMessageAttachment(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			String imageId
			) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeMessageAttachment' controller...");
		}

		ModelAndView mav = new ModelAndView("jsonView");
		messageService.removeMessageAttachment(imageId);
		AttachmentVO attachmentVO = attachmentProcessor.getImage(imageId);
		File file = new File(attachmentVO.getFilePath(),attachmentVO.getOriginalFilename());
		file.delete();

		mav.addObject("msgCode", "100");


		return mav;
	}

	@RequestMapping("/search/{boardKey}/messageSearch")
	public ModelAndView searchMessageList(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageSearchVO messageSearchVO){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'searchMessageList' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		if ("1".equals(boardVO.getTopMessageFlag())) {	// 공지사항 사용여부 체크
			messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
		}
		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		messageSearchVO.setRow(Integer.parseInt(boardVO.getListLines())); //listLines
		MessageListVO messageList = messageService.getMessageList(messageSearchVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageList", messageList);
		mav.setViewName("/modules/search/messageSearch");

		return mav;

	}

	@RequestMapping(value="/{boardKey}/removeMmessageComment.json", method = RequestMethod.GET)
	public ModelAndView removeMmessageComment(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			MessageCommentFormVO messageCommentFormVO
			) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeMessageAttachment' controller...");
		}

		ModelAndView mav = new ModelAndView("jsonView");

		int successInt = messageCommentService.deleteSelectComment(messageCommentFormVO);
		if(successInt>0){
			mav.addObject("msgCode", "100");
		}else{
			mav.addObject("msgCode", "-1");
		}
		return mav;
	}

	@RequestMapping("{boardKey}/{messageId}/download")
	public void attachmentDownload(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam String fileName
			) throws IOException {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'attachmentDownload' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);
		//Message 정보 취득
		MessageVO messageVO = messageService.getMessageLicenseAttachment(boardVO.getBoardId(), fileName);

		AttachmentVO attachmentVO = attachmentProcessor.getImage(messageVO.getDownloadAttachment().getFileName()); //실제 다운로드
		File file = null;
		OutputStream out = null;
		FileInputStream fis = null;
		if(attachmentVO != null){//no 이미지 처리
			file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
		}
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(messageVO.getDownloadAttachment().getDisplayName(), "UTF-8") +";");
		response.setContentLength( (int)attachmentVO.getFileSize() );
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

	}

}
