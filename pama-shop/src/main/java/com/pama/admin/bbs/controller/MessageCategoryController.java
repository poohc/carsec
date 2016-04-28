package com.pama.admin.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageCategoryService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageCategoryListVO;
import com.pama.bbs.vo.MessageCategorySearchVO;
import com.pama.bbs.vo.MessageCategoryVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;

@Controller
@RequestMapping("/admin/board/category/*")
public class MessageCategoryController {
	private static final Log LOG = LogFactory.getLog(MessageCategoryController.class);

	@Autowired
	private MessageCategoryService messageCategoryService;

	@Autowired
	private BoardService boardService;

	@RequestMapping("messageCategoryList")
	public ModelAndView getMessageCategoryList(HttpServletRequest request,
            								HttpServletResponse response,
            								MessageCategorySearchVO messageCategorySearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getMessageCategoryList' controller...");
        }

        List<BoardVO> boardList = boardService.getMenuList("2").getBoardList(); // 사용중인 게시판 가져오기

        BoardVO boardVO = boardService.getBoard(messageCategorySearchVO.getBoardId());

		MessageCategoryListVO boardCategoryList = messageCategoryService.getMessageCategoryList(messageCategorySearchVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardCate", boardList);
        mav.addObject("boardVO", boardVO);
        mav.addObject("boardCategoryList", boardCategoryList);

        mav.setViewName("/admin/board/category/messageCategoryList");

        return mav;
	}

	@RequestMapping("messageCategoryForm")
	public ModelAndView getMessageCategory(HttpServletRequest request,
            HttpServletResponse response,
            MessageCategoryVO messageCategoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getMessageCategory' controller...");
        }
        List<BoardVO> boardList = boardService.getMenuList("2").getBoardList();  // 사용중인 게시판 가져오기

        BoardVO boardVO = boardService.getBoard(messageCategoryVO.getBoardId());

        MessageCategoryVO messageCategoryInfoVO = messageCategoryService.getMessageCategory(messageCategoryVO);

		ModelAndView mav = new ModelAndView();
		mav.addObject("boardCate", boardList);
		mav.addObject("boardVO", boardVO);
        mav.addObject("messageCategoryVO", messageCategoryInfoVO);

        return mav;
	}

    @RequestMapping("messageCategoryFormProc")
    public ModelAndView addMessageCategory(HttpServletRequest request,
			HttpServletResponse response,
			MessageCategoryVO messageCategoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addMessageCategory' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        if (StringUtils.isEmpty(messageCategoryVO.getParentMessageCategoryId())) messageCategoryVO.setParentMessageCategoryId("0");
        if (StringUtils.isEmpty(messageCategoryVO.getMessageCategoryLevel())) messageCategoryVO.setMessageCategoryLevel("0");

        messageCategoryVO.setRegisterId(loginId);
        messageCategoryVO.setUpdateId(loginId);
        messageCategoryVO.setRegisterIp(request.getRemoteAddr());
        messageCategoryVO.setUpdateIp(request.getRemoteAddr());

        if(messageCategoryVO.getMessageCategoryId() != null){//수정처리
            messageCategoryService.modifyMessageCategory(messageCategoryVO);
            return new ModelAndView("redirect:messageCategoryForm.do?boardId="+messageCategoryVO.getBoardId()+"&messageCategoryId="+messageCategoryVO.getMessageCategoryId());
        }else{//등록시 리스트로
            messageCategoryService.addMessageCategory(messageCategoryVO);
            return new ModelAndView("redirect:messageCategoryList.do?boardId="+messageCategoryVO.getBoardId());
        }

    }

    @RequestMapping("messageCategoryRemoveProc")
    public ModelAndView removeMessageCategory(HttpServletRequest request,
            HttpServletResponse response,
            MessageCategoryVO messageCategoryVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeMessageCategory' controller...");
        }

        messageCategoryService.removeMessageCategory(messageCategoryVO);

        return new ModelAndView("redirect:messageCategoryList.do?boardId="+messageCategoryVO.getBoardId());
    }
}
