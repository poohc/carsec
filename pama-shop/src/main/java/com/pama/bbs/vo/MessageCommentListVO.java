package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCommentListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7462754610262663717L;

	@XmlElement(name = "messageCommentList")
	private List<MessageCommentVO> messageCommentList;

	private MessageCommentSearchVO messageCommentSearchVO;

	/**
	 * @return the messageCommentList
	 */
	public List<MessageCommentVO> getMessageCommentList() {
		return messageCommentList;
	}

	/**
	 * @param messageCommentList the messageCommentList to set
	 */
	public void setMessageCommentList(List<MessageCommentVO> messageCommentList) {
		this.messageCommentList = messageCommentList;
	}

	/**
	 * @return the messageCommentSearchVO
	 */
	public MessageCommentSearchVO getMessageCommentSearchVO() {
		return messageCommentSearchVO;
	}

	/**
	 * @param messageCommentSearchVO the messageCommentSearchVO to set
	 */
	public void setMessageCommentSearchVO(MessageCommentSearchVO messageCommentSearchVO) {
		this.messageCommentSearchVO = messageCommentSearchVO;
	}

}
