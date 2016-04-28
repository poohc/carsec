package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8304736601751105490L;

    /**
     * 게사판 리스트
     */
    @XmlElement(name = "boardList")
	private List<BoardVO> boardList;

    /**
     * 게시판 검색조건
     */
    private BoardSearchVO boardSearchVO;

	/**
	 * @return the boardList
	 */
	public List<BoardVO> getBoardList() {
		return boardList;
	}

	/**
	 * @param boardList the boardList to set
	 */
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}

	/**
	 * @return the boardSearchVO
	 */
	public BoardSearchVO getBoardSearchVO() {
		return boardSearchVO;
	}

	/**
	 * @param boardSearchVO the boardSearchVO to set
	 */
	public void setBoardSearchVO(BoardSearchVO boardSearchVO) {
		this.boardSearchVO = boardSearchVO;
	}
}
