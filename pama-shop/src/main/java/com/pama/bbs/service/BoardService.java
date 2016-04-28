package com.pama.bbs.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.bbs.dao.BoardDAO;
import com.pama.bbs.vo.BoardListVO;
import com.pama.bbs.vo.BoardSearchVO;
import com.pama.bbs.vo.BoardVO;

@Service
public class BoardService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(BoardService.class);

    @Autowired
    private BoardDAO boardDAO;

	/**
	 * 게시판 리스트
	 * @param boardSearchVO
	 * @return
	 */
	public BoardListVO getBoardList(BoardSearchVO boardSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoardList' method...");
        }

		BoardListVO boardListVO = new BoardListVO();

		// 게시판 정보 리스트 갯수
		int totalCount = boardDAO.getListTotalCount(boardSearchVO);

		List<BoardVO> uccList = boardDAO.getBoardList(boardSearchVO);

		// 게시판 리스트 정보 셋팅
		boardListVO.setBoardList(uccList);
		boardListVO.setBoardSearchVO(boardSearchVO);
		boardListVO.getBoardSearchVO().setTotalCount(totalCount);

		return boardListVO;
	}

	/**
	 * 게시판 메뉴
	 * @param statusType
	 * @return
	 */
	public BoardListVO getMenuList(String statusType) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoardMenuList' method...");
        }
        BoardSearchVO boardSearchVO = new BoardSearchVO();
        boardSearchVO.setStatusType(statusType);

        BoardListVO boardListVO = new BoardListVO();
        boardListVO.setBoardList(boardDAO.getBoardOpenList(boardSearchVO));

		return boardListVO;
	}

	/**
	 * 게시판 상세정보
	 * @param boardSearchVO
	 * @return
	 */
	public BoardVO getBoard(BoardVO boardVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoard' method...");
        }
		return boardDAO.getBoard(boardVO);
	}

	/**
	 * 게시판 상세정보
	 * @param boardKey
	 * @return
	 */
	public BoardVO getBoard(String boardKey) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoard' method...");
        }
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardKey(boardKey);

		return boardDAO.getBoard(boardVO);
	}

	/**
	 * 게시판 상세정보
	 * @param boardKey
	 * @return
	 */
	public BoardVO getBoard2(int boardId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getBoard' method...");
		}
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);

		return boardDAO.getBoard(boardVO);
	}

	/**
	 * 게시판 정보 등록
	 * @param boardVO
	 * @return
	 */
	public int addBoard(BoardVO boardVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addBoard' method...");
        }
		return boardDAO.insertBoard(boardVO);
	}

	/**
	 * 게시판 정보 수정
	 * @param boardVO
	 * @return
	 */
	public int modifyBoard(BoardVO boardVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBoard' method...");
        }
		return boardDAO.updateBoard(boardVO);
	}

	/**
	 * 게시판 상태 변경
	 * @param boardVO
	 * @return
	 */
	public int modifyBoardStatus(BoardVO boardVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBoardStatus' method...");
        }
		return boardDAO.updateBoardStatus(boardVO);
	}

}
