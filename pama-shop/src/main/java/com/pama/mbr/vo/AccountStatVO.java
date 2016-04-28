package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accountInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountStatVO implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -3553264823714970897L;

	/**
     * 회원정보
     */
    @XmlElement(name = "mbrId")
	private String mbrId;

    @XmlElement(name = "messageCount")
    private int messageCount;

    @XmlElement(name = "commentCount")
    private int commentCount;

	/**
	 * @return the mbrId
	 */
	public String getMbrId() {
		return mbrId;
	}

	/**
	 * @param mbrId the mbrId to set
	 */
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	/**
	 * @return the messageCount
	 */
	public int getMessageCount() {
		return messageCount;
	}

	/**
	 * @param messageCount the messageCount to set
	 */
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	/**
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
