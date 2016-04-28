package com.pama.bbs.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.BoardSearchVO;
import com.pama.bbs.vo.BoardVO;

@Repository
public class BoardDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(BoardDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.BoardDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 게시판 겟수
     * @param boardSearchVO
     * @return
     */
	public int getListTotalCount(BoardSearchVO boardSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"),boardSearchVO);
	}

	/**
     * 게시판 목록
     * @param boardSearchVO
     * @return
     */
	public List<BoardVO> getBoardList(BoardSearchVO boardSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoardList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBoardList"), boardSearchVO);
	}

	/**
     * 게시판 오픈 목록
     * @param boardSearchVO
     * @return
     */
	public List<BoardVO> getBoardOpenList(BoardSearchVO boardSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoardOpenList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBoardOpenList"), boardSearchVO);
	}

	/**
     * 게시판 내용
     * @param boardVO
     * @return
     */
	public BoardVO getBoard(BoardVO boardVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBoard' method...");
        }
        return (BoardVO)sqlSessionTemplate.selectOne(getSqlId("getBoard"), boardVO);
	}

	/**
     * 게시판 추가
     * @param boardVO
     * @return
     */
	public int insertBoard(BoardVO boardVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertBoard' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertBoard"), boardVO);
	}

	/**
     * 게시판 수정
     * @param boardVO
     * @return
     */
	public int updateBoard(BoardVO boardVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBoard' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBoard"), boardVO);
	}

	/**
     * 게시판 수정
     * @param boardVO
     * @return
     */
	public int updateBoardStatus(BoardVO boardVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBoardStatus' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBoardStatus"), boardVO);
	}

    /**
     * SqlMap Namespace를 생성한다.
     * @param methodName
     * @return
     */
    private String getSqlId(String methodName) {
        return SQLMAP_NAMESPACE + "." + methodName;
    }

}
