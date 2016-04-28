package com.pama.bbs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "messageSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageSearchVO extends SearchVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5438417094849855083L;

	@XmlElement(name = "myListId")
	private String myListId;

	@XmlElement(name = "messageId")
	private String messageId;

	@XmlElement(name = "boardId")
	private String boardId;

	@XmlElement(name = "boardKey")
	private String boardKey;

	@XmlElement(name = "messageCategoryId")
	private String messageCategoryId;

	@XmlElement(name = "topFlag")
	private String topFlag;

	@XmlElement(name = "topMessageFlag")
	private String topMessageFlag;

	@XmlElement(name = "registerId")
	private String registerId;

	@XmlElement(name = "sortTab")
	private String sortTab;

    @XmlElement(name = "replyFlag")
    private String replyFlag;//답변글사용여부

    @XmlElement(name = "displayFlag")
    private String displayFlag; // 동영상태그 노출여부

    @XmlElement(name = "statusType")
    private String statusType;

    @XmlElement(name = "consultFlag")
    private String consultFlag;

    @XmlElement(name = "varFiled1")
    private String varFiled1;

    @XmlElement(name = "varFiled2")
    private String varFiled2;

    @XmlElement(name = "varFiled3")
    private String varFiled3;

    @XmlElement(name = "varFiled4")
    private String varFiled4;

    @XmlElement(name = "varFiled5")
    private String varFiled5;

    @XmlElement(name = "varFiled6")
    private String varFiled6;

    @XmlElement(name = "varFiled7")
    private String varFiled7;

    @XmlElement(name = "varFiled8")
    private String varFiled8;

    private String[] tags;

    private String mbrLevel;

	public String getMbrLevel() {
		return mbrLevel;
	}

	public void setMbrLevel(String mbrLevel) {
		this.mbrLevel = mbrLevel;
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

	/**
	 * @return the boardKey
	 */
	public String getBoardKey() {
		return boardKey;
	}

	/**
	 * @param boardKey the boardKey to set
	 */
	public void setBoardKey(String boardKey) {
		this.boardKey = boardKey;
	}

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
	 * @return the topFlag
	 */
	public String getTopFlag() {
		return topFlag;
	}

	/**
	 * @param topFlag the topFlag to set
	 */
	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}

	/**
	 * @return the topMessageFlag
	 */
	public String getTopMessageFlag() {
		return topMessageFlag;
	}

	/**
	 * @param topMessageFlag the topMessageFlag to set
	 */
	public void setTopMessageFlag(String topMessageFlag) {
		this.topMessageFlag = topMessageFlag;
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
	 * @return the sortTab
	 */
	public String getSortTab() {
		return sortTab;
	}

	/**
	 * @param sortTab the sortTab to set
	 */
	public void setSortTab(String sortTab) {
		this.sortTab = sortTab;
	}

	/**
	 * @return the replyFlag
	 */
	public String getReplyFlag() {
		return replyFlag;
	}

	/**
	 * @param replyFlag the replyFlag to set
	 */
	public void setReplyFlag(String replyFlag) {
		this.replyFlag = replyFlag;
	}

	/**
	 * @return the displayFlag
	 */
	public String getDisplayFlag() {
		return displayFlag;
	}

	/**
	 * @param displayFlag the displayFlag to set
	 */
	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	/**
	 * @return the statusType
	 */
	public String getStatusType() {
		return statusType;
	}

	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	/**
	 * @return the consultFlag
	 */
	public String getConsultFlag() {
		return consultFlag;
	}

	/**
	 * @param consultFlag the consultFlag to set
	 */
	public void setConsultFlag(String consultFlag) {
		this.consultFlag = consultFlag;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getVarFiled1() {
		return varFiled1;
	}

	public void setVarFiled1(String varFiled1) {
		this.varFiled1 = varFiled1;
	}

	public String getVarFiled2() {
		return varFiled2;
	}

	public void setVarFiled2(String varFiled2) {
		this.varFiled2 = varFiled2;
	}

	public String getVarFiled3() {
		return varFiled3;
	}

	public void setVarFiled3(String varFiled3) {
		this.varFiled3 = varFiled3;
	}

	public String getVarFiled4() {
		return varFiled4;
	}

	public void setVarFiled4(String varFiled4) {
		this.varFiled4 = varFiled4;
	}

	public String getVarFiled5() {
		return varFiled5;
	}

	public void setVarFiled5(String varFiled5) {
		this.varFiled5 = varFiled5;
	}

	public String getVarFiled6() {
		return varFiled6;
	}

	public void setVarFiled6(String varFiled6) {
		this.varFiled6 = varFiled6;
	}

	public String getVarFiled7() {
		return varFiled7;
	}

	public void setVarFiled7(String varFiled7) {
		this.varFiled7 = varFiled7;
	}

	public String getVarFiled8() {
		return varFiled8;
	}

	public void setVarFiled8(String varFiled8) {
		this.varFiled8 = varFiled8;
	}

	public String getMyListId() {
		return myListId;
	}

	public void setMyListId(String myListId) {
		this.myListId = myListId;
	}


}
