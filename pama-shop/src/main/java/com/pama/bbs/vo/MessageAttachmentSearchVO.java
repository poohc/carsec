package com.pama.bbs.vo;

import javax.xml.bind.annotation.XmlElement;

import com.pama.common.vo.SearchVO;

public class MessageAttachmentSearchVO extends SearchVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 2126190014529891994L;


    @XmlElement(name = "messageId")
    private String messageId;

    @XmlElement(name = "showIndex")
    private int showIndex;

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the showIndex
	 */
	public int getShowIndex() {
		return showIndex;
	}

	/**
	 * @param showIndex the showIndex to set
	 */
	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}



}
