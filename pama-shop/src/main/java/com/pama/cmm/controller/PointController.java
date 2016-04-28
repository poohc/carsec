package com.pama.cmm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

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
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageAttachmentVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbrpoint.service.PointService;
import com.pama.mbrpoint.vo.PointVO;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/common/point/*")
public class PointController {

	private static final Log LOG = LogFactory.getLog(PointController.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

	@Autowired
	private PointService pointService;

	@Autowired
	private AccountService accountService;

	/**
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("{boardKey}/{messageId}/pointUse")
	public ModelAndView pointUse(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("messageId") String paramMessageId,
			HttpServletRequest request,
			HttpServletResponse response

			){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointUse' controller...");
		}

		if(!SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){
			return null;
		}

		//현재 로그인 한 사용자 정보취득 포인트 정보
		SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
		AccountVO accountVO = new AccountVO();
		accountVO.setMbrId(sessionVO.getMbrId());
		accountVO = accountService.getAccount(accountVO);

		BoardVO boardVO = boardService.getBoard(boardKey);
		MessageVO messageVO = messageService.getMessageOne(String.valueOf(boardVO.getBoardId()), paramMessageId);

		ModelAndView mav = new ModelAndView();
		//이미 구입한 부분여부
		PointVO pointVO = pointService.getPointUse(messageVO.getMessageId(), accountVO.getMbrId(), Constants.MBR_POINT_FLAG_USE);
		if(pointVO==null && StringUtils.equals(messageVO.getLicenseType(),"1")){//구입한적없구 유료인경우
			mav.setViewName("/modules/point/pointUse");
		}else{//구입했거나 무료인경우

			mav.setViewName("/modules/point/pointUseDownload");
			mav.addObject("pointVO", pointVO);
			mav.addObject("boardVO", boardVO);
		}

		mav.addObject("accountVO", accountVO);
		mav.addObject("messageVO", messageVO);

		return mav;
	}

	/**
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("{boardKey}/{messageId}/pointUseProc")
	public ModelAndView pointUseProc(
			@PathVariable("boardKey") String boardKey,
			@PathVariable("messageId") String paramMessageId,
			HttpServletRequest request,
			HttpServletResponse response

			){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointUse' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);
		MessageVO messageVO = messageService.getMessageOne(String.valueOf(boardVO.getBoardId()), paramMessageId);

		//현재 로그인 한 사용자 정보취득 포인트 정보
		SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
		AccountVO accountVO = new AccountVO();
		accountVO.setMbrId(sessionVO.getMbrId());
		accountVO = accountService.getAccount(accountVO);

		String mbrId=accountVO.getMbrId();
		int point=messageVO.getLicensePoint();
		String pointTitle=messageVO.getTitle();
		int messageId=messageVO.getMessageId();
		String messageRegisterId=messageVO.getRegisterId();
		String registerId=mbrId;
		String registerIp=request.getRemoteAddr();

		int returnInt = pointService.trxUsePoint(mbrId, point, pointTitle, messageId, messageRegisterId, registerId, registerIp);

		ModelAndView mav = new ModelAndView();
		//Constants.MBR_POINT_USE_POINT_SUCCESS
		mav.setViewName("redirect:./pointUse.do");

		return mav;
	}

	@RequestMapping("{boardKey}/{messageId}/stockDownload")
	public void stockDownload(@PathVariable("boardKey") String boardKey,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam String fileName
			) throws IOException {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'stockDownload' controller...");
		}

		boolean isDownload=false;

		//현재 로그인 한 사용자 정보취득 포인트 정보
		SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
		AccountVO accountVO = new AccountVO();
		accountVO.setMbrId(sessionVO.getMbrId());

		BoardVO boardVO = boardService.getBoard(boardKey);
		//Message 정보 취득
		MessageVO messageVO = messageService.getMessageLicenseAttachment(boardVO.getBoardId(), fileName);

		if( StringUtils.equals("stock",boardVO.getBoardType()) ){//stock type만 허용
			//포인트 차감
			if( StringUtils.equals("1", messageVO.getLicenseType()) ){//유료일경우
				PointVO pointVO = pointService.getPointUse(messageVO.getMessageId(), accountVO.getMbrId(), Constants.MBR_POINT_FLAG_USE);
				if(pointVO==null){//구입한적 없음
					isDownload=false;
				}else{
					isDownload=true;
				}
			}else{
				isDownload=true;
			}

		}

		if(isDownload){

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
