package com.pama.admin.bbs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.vo.BoardListVO;
import com.pama.bbs.vo.BoardSearchVO;
import com.pama.bbs.vo.BoardVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {
	private static final Log LOG = LogFactory.getLog(BoardController.class);

	@Autowired
	private BoardService boardService;

    @RequestMapping("boardList")
    public ModelAndView getBoardList(HttpServletRequest request,
    							HttpServletResponse response,
    							BoardSearchVO boardSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBoardList' controller...");
        }

        BoardListVO boardList = boardService.getBoardList(boardSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardList);

        return mav;
    }

    @RequestMapping("boardListJS")
    public ModelAndView getBoardListJS(HttpServletRequest request,
    		HttpServletResponse response,
    		BoardSearchVO boardSearchVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'getUccListJS' controller...");
    	}

    	BoardListVO boardList = boardService.getBoardList(boardSearchVO);

    	ModelAndView mav = new ModelAndView("jsonView");
    	mav.addObject("boardList", boardList);

    	return mav;
    }

    @RequestMapping("boardDetail")
    public ModelAndView getBoard(HttpServletRequest request,
			HttpServletResponse response,
			BoardVO boardVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBoard' controller...");
        }

        BoardVO boardInfoVO = boardService.getBoard(boardVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardInfoVO);

        return mav;
    }

    @RequestMapping("boardForm")
    public ModelAndView getBoardForm(HttpServletRequest request,
			HttpServletResponse response,
			BoardVO boardVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBoardForm' controller...");
        }

        ArrayList<String> boardTypeList = new ArrayList<String>() ;

        boardTypeList.add(Constants.BBS_BOARD_TYPE_NOTICE);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_QNA);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_GENERAL);
        boardTypeList.add(Constants.BBS_BOARD_TYPE_IMAGECONTENT);

        BoardVO boardInfoVO = null;
        if (boardVO.getBoardId()!=null) {
        	boardInfoVO = boardService.getBoard(boardVO);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardTypeList", boardTypeList);
        mav.addObject("boardVO", boardInfoVO);

        return mav;
    }

    @RequestMapping("boardRegister")
    public ModelAndView addBoard(HttpServletRequest request,
			HttpServletResponse response,
			BoardVO boardVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addBoard' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        boardVO.setRegisterId(loginId);

        boardService.addBoard(boardVO);

        ModelAndView mav = new ModelAndView(new RedirectView("boardList.do"));

        return mav;

    }

    @RequestMapping("boardModify")
    public ModelAndView modifyBoard(HttpServletRequest request,
			HttpServletResponse response,
			BoardVO boardVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyBoard' controller...");
        }
        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }
        boardVO.setUpdateId(loginId);

    	boardService.modifyBoard(boardVO);

    	ModelAndView mav = new ModelAndView(new RedirectView("boardForm.do"));
    	mav.addObject("boardId",boardVO.getBoardId());

    	return mav;
    }

}
