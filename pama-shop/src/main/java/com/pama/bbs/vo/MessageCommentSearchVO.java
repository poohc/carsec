package com.pama.bbs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "messageSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCommentSearchVO extends SearchVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8779339078925622608L;
	private String commentId;
    private String messageId;
    private String registerId;
    private String registerPwd;
    private String registerName;
    private String title;

	/**
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
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
	 * @return the registerId
	 */
	public String getRegisterId() {
		return registerId;
	}
	/**
	 * @param registerId the registerId to set
	 */
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	/**
	 * @return the registerPwd
	 */
	public String getRegisterPwd() {
		return registerPwd;
	}
	/**
	 * @param registerPwd the registerPwd to set
	 */
	public void setRegisterPwd(String registerPwd) {
		this.registerPwd = registerPwd;
	}
	/**
	 * @return the registerName
	 */
	public String getRegisterName() {
		return registerName;
	}
	/**
	 * @param registerName the registerName to set
	 */
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
