package com.pama.admin.sitecontents.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.vo.MessageFormVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.sitecontents.service.SitecontentsService;
import com.pama.sitecontents.vo.SiteContentListVO;
import com.pama.sitecontents.vo.SiteContentVO;

@Controller
@RequestMapping("/admin/sitecontents/*")
public class SiteContentsController {


	/**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(SiteContentsController.class);

	@Autowired
    private SitecontentsService sitecontentsService;

    /**
     * siteContentList 게시글 리스트
     * @param request
     * @param response
     * @param siteContentVO
     * @return
     */
    @RequestMapping("/messageList")
    public ModelAndView getSiteContentsList(HttpServletRequest request,
			HttpServletResponse response, SiteContentVO siteContentVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getSiteContentsList' controller...");
        }


        SiteContentListVO siteContentListVO = sitecontentsService.getSiteContentList(siteContentVO);
        for(int i=0; i < siteContentListVO.getSiteContentList().size(); i++){
        	System.out.println("============="+ siteContentListVO.getSiteContentList().get(i));
        }
        System.out.println("toString=============="+siteContentListVO.toString());

        ModelAndView mav = new ModelAndView();

        mav.addObject("siteContentListVO", siteContentListVO);
        mav.setViewName("/admin/sitecontents/messageList");
        return mav;


       /* if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageList' controller...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		messageSearchVO.setRow(Integer.parseInt(boardVO.getListLinesAdmin())); //listLinesAdmin
		MessageListVO messageList = messageService.getMessageList(messageSearchVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardVO", boardVO);
		mav.addObject("messageList", messageList);
		mav.setViewName("/admin/message/"+ConvertUtil.getBoardTypePath(boardVO.getBoardType())+"messageList");

		return mav;*/

    }

    /**
     * siteContentList 게시글 상세보기
     * @param request
     * @param response
     * @param siteContentVO
     * @return
     */
    @RequestMapping("/messageDetail")
	public ModelAndView getMessage(HttpServletRequest request, HttpServletResponse response, SiteContentVO siteContentVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessage' controller...");
		}

		String loginId = null;
		if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
			loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
		}


		SiteContentVO vo = sitecontentsService.getMessage(siteContentVO);


		MessageFormVO messageFormVO = new MessageFormVO();
		messageFormVO.setMessageId(String.valueOf(siteContentVO.getContentId()));
		if ("".equals(loginId)) {
			messageFormVO.setRegisterId("");
		} else {
			messageFormVO.setRegisterId(loginId);
		}
		//messageService.modifyMessageAddViewCount(messageFormVO);

		ModelAndView mav = new ModelAndView();

		mav.addObject("siteContentVO", vo);
		mav.addObject("loginId", loginId);
		mav.setViewName("/admin/sitecontents/messageDetail");

		return mav;
	}

	@RequestMapping("/messageForm")
	public ModelAndView getMessageForm(HttpServletRequest request, HttpServletResponse response, SiteContentVO siteContentVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMessageForm' controller...");
		}

		if (!"".equals(siteContentVO.getContentId())) {
			SiteContentVO vo = sitecontentsService.getMessage(siteContentVO);
		}
		SiteContentVO vo = sitecontentsService.getMessage(siteContentVO);

		ModelAndView mav = new ModelAndView();


		mav.addObject("siteContentVO", vo);
		mav.setViewName("/admin/sitecontents/messageForm");

		return mav;
	}

	/**
	 * siteContentList 게시글 수정
	 * @param request
	 * @param response
	 * @param siteContentVO
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws Exception
	 */
	@RequestMapping("/messageModify")
	public ModelAndView modifyMessage(HttpServletRequest request,
			HttpServletResponse response,
			SiteContentVO siteContentVO) throws IllegalStateException, IOException, Exception {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'modifyMessage' controller...");
		}

		if (siteContentVO == null) return new ModelAndView("redirect:/admin/sitecontents/messageForm.do");

		if( !SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)) {  //로그인체크
			return new ModelAndView("redirect:/admin/sitecontents/messageForm.do");
		}





		sitecontentsService.modifyMessage(siteContentVO);

		return new ModelAndView("redirect:/admin/sitecontents/messageForm.do?contentId="+siteContentVO.getContentId());

	}

	/**
	 * siteContentList 게시글 삭제
	 * @param request
	 * @param response
	 * @param siteContentVO
	 * @return
	 */
	@RequestMapping("/messageRemoveSelectProc")
	public ModelAndView removeSelectMessage(HttpServletRequest request,
			HttpServletResponse response,
			SiteContentVO siteContentVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'removeSelecMessage' controller...");
		}

		sitecontentsService.removeSelectMessage(siteContentVO);

		return new ModelAndView("redirect:/admin/sitecontents/messageList.do");
	}

	@RequestMapping("/messageRegister")
	public ModelAndView insertMessage(HttpServletRequest request,
			HttpServletResponse response,
			SiteContentVO siteContentVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'insertMessage' controller...");
		}

		sitecontentsService.insertMessage(siteContentVO);

		return new ModelAndView("redirect:/admin/sitecontents/messageList.do");
	}


}
