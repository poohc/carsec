/**
 * 이소스는 저작권은 개발자  pama게시판 개발자에게 있습니다.
 * 납품한 홈페이지에서는 자유롭게 수정 및 편집이 가능하나 다른 홈페이지에
 * 게재시 지적 재산권에 문제있음을 공지합니다.
 * 개발자 : pama
 * 이메일 : sycop78@gmail.com
 */
package com.pama.bbs.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageCategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageCategoryVO implements java.io.Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 184693870515815392L;

	@XmlElement(name = "messageCategoryId")
    private String messageCategoryId;		// 카테고리 코드

    @XmlElement(name = "boardId")
    private String boardId;					// 게시판 코드

    @XmlElement(name = "parentMessageCategoryId")
    private String parentMessageCategoryId;			// 계층 최상위 게시판 코드

    @XmlElement(name = "messageCategoryName")
    private String messageCategoryName;				// 카테고리(분류)명

    @XmlElement(name = "sortTree")
    private String sortTree;

    @XmlElement(name = "messageCategoryLevel")
    private String messageCategoryLevel;

    @XmlElement(name = "registerId")
    private String registerId;//등록자

    @XmlElement(name = "registerIp")
    private String registerIp;

    @XmlElement(name = "registerDate")
    private String registerDate;//등록일자

    @XmlElement(name = "updateId")
    private String updateId;

    @XmlElement(name = "updateIp")
    private String updateIp;

    @XmlElement(name = "updateDate")
    private String updateDate;

    @XmlElement(name = "statusType")
    private String statusType;

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

	/**
	 * @return the parentMessageCategoryId
	 */
	public String getParentMessageCategoryId() {
		return parentMessageCategoryId;
	}

	/**
	 * @param parentMessageCategoryId the parentMessageCategoryId to set
	 */
	public void setParentMessageCategoryId(String parentMessageCategoryId) {
		this.parentMessageCategoryId = parentMessageCategoryId;
	}

	/**
	 * @return the messageCategoryName
	 */
	public String getMessageCategoryName() {
		return messageCategoryName;
	}

	/**
	 * @param messageCategoryName the messageCategoryName to set
	 */
	public void setMessageCategoryName(String messageCategoryName) {
		this.messageCategoryName = messageCategoryName;
	}

	/**
	 * @return the sortTree
	 */
	public String getSortTree() {
		return sortTree;
	}

	/**
	 * @param sortTree the sortTree to set
	 */
	public void setSortTree(String sortTree) {
		this.sortTree = sortTree;
	}

	/**
	 * @return the messageCategoryLevel
	 */
	public String getMessageCategoryLevel() {
		return messageCategoryLevel;
	}

	/**
	 * @param messageCategoryLevel the messageCategoryLevel to set
	 */
	public void setMessageCategoryLevel(String messageCategoryLevel) {
		this.messageCategoryLevel = messageCategoryLevel;
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
	 * @return the registerIp
	 */
	public String getRegisterIp() {
		return registerIp;
	}

	/**
	 * @param registerIp the registerIp to set
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the updateId
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * @param updateId the updateId to set
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * @return the updateIp
	 */
	public String getUpdateIp() {
		return updateIp;
	}

	/**
	 * @param updateIp the updateIp to set
	 */
	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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

}
