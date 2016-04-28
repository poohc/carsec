package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageCategoryAllList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategoryListVO implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 8638797612254186041L;

	/**
     * 게사판 리스트
     */
    @XmlElement(name = "messageCategoryList")
	private List<MessageCategoryVO> messageCategoryList;

    private MessageCategorySearchVO messageCategorySearchVO;

	/**
	 * @return the messageCategoryList
	 */
	public List<MessageCategoryVO> getMessageCategoryList() {
		return messageCategoryList;
	}

	/**
	 * @param messageCategoryList the messageCategoryList to set
	 */
	public void setMessageCategoryList(List<MessageCategoryVO> messageCategoryList) {
		this.messageCategoryList = messageCategoryList;
	}

	/**
	 * @return the messageCategorySearchVO
	 */
	public MessageCategorySearchVO getMessageCategorySearchVO() {
		return messageCategorySearchVO;
	}

	/**
	 * @param messageCategorySearchVO the messageCategorySearchVO to set
	 */
	public void setMessageCategorySearchVO(
			MessageCategorySearchVO messageCategorySearchVO) {
		this.messageCategorySearchVO = messageCategorySearchVO;
	}

}
