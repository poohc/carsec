package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6975080231408730707L;

	@XmlElement(name = "messageList")
	private List<MessageVO> messageList;

	@XmlElement(name = "messageTopList")
	private List<MessageVO> messageTopList;

    private MessageSearchVO messageSearchVO;

	/**
	 * @return the messageList
	 */
	public List<MessageVO> getMessageList() {
		return messageList;
	}

	/**
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List<MessageVO> messageList) {
		this.messageList = messageList;
	}

	/**
	 * @return the messageTopList
	 */
	public List<MessageVO> getMessageTopList() {
		return messageTopList;
	}

	/**
	 * @param messageTopList the messageTopList to set
	 */
	public void setMessageTopList(List<MessageVO> messageTopList) {
		this.messageTopList = messageTopList;
	}

	/**
	 * @return the messageSearchVO
	 */
	public MessageSearchVO getMessageSearchVO() {
		return messageSearchVO;
	}

	/**
	 * @param messageSearchVO the messageSearchVO to set
	 */
	public void setMessageSearchVO(MessageSearchVO messageSearchVO) {
		this.messageSearchVO = messageSearchVO;
	}

}
