package com.pama.bbs.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "messageCategorySearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategorySearchVO extends SearchVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2555905557929415901L;

	@XmlElement(name = "messageCategoryId")
	private String messageCategoryId;

	@XmlElement(name = "boardId")
	private String boardId;

	/**
	 * @return the messageCategoryId
	 */
	public String getMessageCategoryId() {
		return messageCategoryId;
	}

	/**
	 * @param messageCategoryId the messageCategoryId to set
	 */
	public void setMessageCategoryId(String messageCategoryId) {
		this.messageCategoryId = messageCategoryId;
	}

	/**
	 * @return the boardId
	 */
	public String getBoardId() {
		return boardId;
	}

	/**
	 * @param boardId the boardId to set
	 */
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

}
