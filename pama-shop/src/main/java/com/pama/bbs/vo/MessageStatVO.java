package com.pama.bbs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageStat")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageStatVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6116224106576306177L;

	private int messageCount;//총게시글수
	private int attachDownloadCount;//총다운로드갯수
	private int messageRank;//게실물 총갯수 순위
	private int attachDownloadRank;//총다운로드 순위

	public int getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	public int getAttachDownloadCount() {
		return attachDownloadCount;
	}
	public void setAttachDownloadCount(int attachDownloadCount) {
		this.attachDownloadCount = attachDownloadCount;
	}
	public int getMessageRank() {
		return messageRank;
	}
	public void setMessageRank(int messageRank) {
		this.messageRank = messageRank;
	}
	public int getAttachDownloadRank() {
		return attachDownloadRank;
	}
	public void setAttachDownloadRank(int attachDownloadRank) {
		this.attachDownloadRank = attachDownloadRank;
	}

}
