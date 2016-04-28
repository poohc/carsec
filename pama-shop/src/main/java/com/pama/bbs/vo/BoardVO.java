package com.pama.bbs.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "board")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2358849805793771925L;

    @XmlElement(name = "boardId")
    private Integer boardId;//아이디

    @XmlElement(name = "boardKey")
    private String boardKey;//키(front에서 사용할때 유용함)

    @XmlElement(name = "boardType")
    private String boardType; //bbsContants 참조

    @XmlElement(name = "title")
    private String title;//제목

    @XmlElement(name = "description")
    private String description;//설명

    @XmlElement(name = "listLines")
    private String listLines;//리스트라인수

    @XmlElement(name = "listLinesAdmin")
    private String listLinesAdmin;//관리자리스트라인수

    @XmlElement(name = "messageCategoryFlag")
    private String messageCategoryFlag;//카테고리사용여부

    @XmlElement(name = "consultFlag")
    private String consultFlag;// 상담기능 사용여부

    @XmlElement(name = "replyFlag")
    private String replyFlag;//답변글사용여부

    @XmlElement(name = "commentFlag")
    private String commentFlag;//코멘트사용여부

    @XmlElement(name = "attachmentFlag")
    private String attachmentFlag;//첨부사용여부

    @XmlElement(name = "recommendFlag")
    private String recommendFlag;//추천사용여부

    @XmlElement(name = "listImageFlag")
    private String listImageFlag;//리스트이미지사용여부

    @XmlElement(name = "topMessageFlag")
    private String topMessageFlag;//공지글 사용여부

    @XmlElement(name = "expirationFlag")
    private String expirationFlag;//유효기간 사용여부

    @XmlElement(name = "summaryFlag")
    private String summaryFlag;//요약사용여부

    @XmlElement(name = "contentsFlag")
    private String contentsFlag;//컨텐츠출력여부

    @XmlElement(name = "tagsFlag")
    private String tagsFlag;//태그사용여부

    @XmlElement(name = "secretFlag")
    private String secretFlag;//비밀글사용여부

    @XmlElement(name = "licenseFlag")
    private String licenseFlag;//라이센스여부(포인트 사용여부) 라이센트 획득한 사람만 가능하게 설계.

    @XmlElement(name = "listIndexNum")
    private String listIndexNum;

    /**
     * 나중에 디비화할 예정입 보드 권한
     * admin:90-100 user:10-89 guest:0 라는 값이 각각 들어간다.
     */
    @XmlElement(name = "authAccess")
    private String authAccess;//접근권한

    @XmlElement(name = "authList")
    private String authList;//리스트권한

    @XmlElement(name = "authView")
    private String authView;//열람권한

    @XmlElement(name = "authWrite")
    private String authWrite;//글작성권한

    @XmlElement(name = "authManager")
    private String authManager;//관리권한

    @XmlElement(name = "registerId")
    private String registerId;//등록자

    @XmlElement(name = "registerIp")
    private String registerIp;//등록자

    @XmlElement(name = "registerDate")
    private String registerDate;//등록일자

    @XmlElement(name = "updateId")
    private String updateId;

    @XmlElement(name = "updateIp")
    private String updateIp;

    @XmlElement(name = "updateDate")
    private String updateDate;

    @XmlElement(name = "statusType")
    private String statusType;//보드상태 0:삭제 1:대기 2:게시 3:잠김

	/**
	 * @return the boardId
	 */
	public Integer getBoardId() {
		return boardId;
	}

	/**
	 * @param boardId the boardId to set
	 */
	public void setBoardId(Integer boardId) {
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
	 * @return the boardType
	 */
	public String getBoardType() {
		return boardType;
	}

	/**
	 * @param boardType the boardType to set
	 */
	public void setBoardType(String boardType) {
		this.boardType = boardType;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the listLines
	 */
	public String getListLines() {
		return listLines;
	}

	/**
	 * @param listLines the listLines to set
	 */
	public void setListLines(String listLines) {
		this.listLines = listLines;
	}

	/**
	 * @return the messageCategoryFlag
	 */
	public String getMessageCategoryFlag() {
		return messageCategoryFlag;
	}

	/**
	 * @param messageCategoryFlag the messageCategoryFlag to set
	 */
	public void setMessageCategoryFlag(String messageCategoryFlag) {
		this.messageCategoryFlag = messageCategoryFlag;
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
	 * @return the commentFlag
	 */
	public String getCommentFlag() {
		return commentFlag;
	}

	/**
	 * @param commentFlag the commentFlag to set
	 */
	public void setCommentFlag(String commentFlag) {
		this.commentFlag = commentFlag;
	}

	/**
	 * @return the attachmentFlag
	 */
	public String getAttachmentFlag() {
		return attachmentFlag;
	}

	/**
	 * @param attachmentFlag the attachmentFlag to set
	 */
	public void setAttachmentFlag(String attachmentFlag) {
		this.attachmentFlag = attachmentFlag;
	}

	/**
	 * @return the recommendFlag
	 */
	public String getRecommendFlag() {
		return recommendFlag;
	}

	/**
	 * @param recommendFlag the recommendFlag to set
	 */
	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	/**
	 * @return the listImageFlag
	 */
	public String getListImageFlag() {
		return listImageFlag;
	}

	/**
	 * @param listImageFlag the listImageFlag to set
	 */
	public void setListImageFlag(String listImageFlag) {
		this.listImageFlag = listImageFlag;
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
	 * @return the expirationFlag
	 */
	public String getExpirationFlag() {
		return expirationFlag;
	}

	/**
	 * @param expirationFlag the expirationFlag to set
	 */
	public void setExpirationFlag(String expirationFlag) {
		this.expirationFlag = expirationFlag;
	}

	/**
	 * @return the summaryFlag
	 */
	public String getSummaryFlag() {
		return summaryFlag;
	}

	/**
	 * @param summaryFlag the summaryFlag to set
	 */
	public void setSummaryFlag(String summaryFlag) {
		this.summaryFlag = summaryFlag;
	}

	/**
	 * @return the contentsFlag
	 */
	public String getContentsFlag() {
		return contentsFlag;
	}

	/**
	 * @param contentsFlag the contentsFlag to set
	 */
	public void setContentsFlag(String contentsFlag) {
		this.contentsFlag = contentsFlag;
	}

	/**
	 * @return the tagsFlag
	 */
	public String getTagsFlag() {
		return tagsFlag;
	}

	/**
	 * @param tagsFlag the tagsFlag to set
	 */
	public void setTagsFlag(String tagsFlag) {
		this.tagsFlag = tagsFlag;
	}

	/**
	 * @return the secretFlag
	 */
	public String getSecretFlag() {
		return secretFlag;
	}

	/**
	 * @param secretFlag the secretFlag to set
	 */
	public void setSecretFlag(String secretFlag) {
		this.secretFlag = secretFlag;
	}

	/**
	 * @return the listIndexNum
	 */
	public String getListIndexNum() {
		return listIndexNum;
	}

	/**
	 * @param listIndexNum the listIndexNum to set
	 */
	public void setListIndexNum(String listIndexNum) {
		this.listIndexNum = listIndexNum;
	}

	/**
	 * @return the authAccess
	 */
	public String getAuthAccess() {
		return authAccess;
	}

	/**
	 * @param authAccess the authAccess to set
	 */
	public void setAuthAccess(String authAccess) {
		this.authAccess = authAccess;
	}

	/**
	 * @return the authList
	 */
	public String getAuthList() {
		return authList;
	}

	/**
	 * @param authList the authList to set
	 */
	public void setAuthList(String authList) {
		this.authList = authList;
	}

	/**
	 * @return the authView
	 */
	public String getAuthView() {
		return authView;
	}

	/**
	 * @param authView the authView to set
	 */
	public void setAuthView(String authView) {
		this.authView = authView;
	}

	/**
	 * @return the authWrite
	 */
	public String getAuthWrite() {
		return authWrite;
	}

	/**
	 * @param authWrite the authWrite to set
	 */
	public void setAuthWrite(String authWrite) {
		this.authWrite = authWrite;
	}

	/**
	 * @return the authManager
	 */
	public String getAuthManager() {
		return authManager;
	}

	/**
	 * @param authManager the authManager to set
	 */
	public void setAuthManager(String authManager) {
		this.authManager = authManager;
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

	/**
	 * @return the licenseFlag
	 */
	public String getLicenseFlag() {
		return licenseFlag;
	}

	/**
	 * @param licenseFlag the licenseFlag to set
	 */
	public void setLicenseFlag(String licenseFlag) {
		this.licenseFlag = licenseFlag;
	}

	/**
	 * @return the listLinesAdmin
	 */
	public String getListLinesAdmin() {
		return listLinesAdmin;
	}

	/**
	 * @param listLinesAdmin the listLinesAdmin to set
	 */
	public void setListLinesAdmin(String listLinesAdmin) {
		this.listLinesAdmin = listLinesAdmin;
	}

}
