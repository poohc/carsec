package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7461177195490809210L;

    @XmlElement(name = "messageId")
    private Integer messageId;	// 게시물 번호

    @XmlElement(name = "boardKey")
    private String boardKey;		// 게시판 아이디

	@XmlElement(name = "boardId")
    private String boardId;		// 게시판 아이디

    @XmlElement(name = "messageCategoryId")
    private String messageCategoryId;		// 게시물 분류 번호

    @XmlElement(name = "messageCategoryName")
    private String messageCategoryName;		// 게시물 분류명

    @XmlElement(name = "parentMessageId")
    private String parentMessageId;		// 부모 게시물 번호

    @XmlElement(name = "messageLevel")
    private String messageLevel;		// 게시물 레벨

    @XmlElement(name = "tags")
    private String tags;			// 태그

    @XmlElement(name = "topFlag")
    private String topFlag;			// 공지사항 1:공지, 2:일반

    @XmlElement(name = "title")
    private String title;			//제목

    @XmlElement(name = "subTitle") //부제목
    private String subTitle;

    @XmlElement(name = "summaryContents") //요약내용
    private String summaryContents;

    @XmlElement(name = "viewCount") //조회수
    private Integer viewCount;

    @XmlElement(name = "replyCount") //리플수
    private Integer replyCount;

    @XmlElement(name = "commentCount") //커멘트수
    private Integer commentCount;

    @XmlElement(name = "attachmentCount") //첨부파일수
    private Integer attachmentCount;

    @XmlElement(name = "scrapCount") //스크랩수
    private Integer scrapCount;

    @XmlElement(name = "recommendCount") //추천수
    private Integer recommendCount;

    @XmlElement(name = "recommendPoint") //추천점수
    private Integer recommendPoint;

    @XmlElement(name = "thumbnailUrl") //썹네일 URL
    private String thumbnailUrl;

    @XmlElement(name = "homeUrl") //홈페이지 URL
    private String homeUrl;

    @XmlElement(name = "startDate") //시작일자
    private String startDate;

    @XmlElement(name = "endDate") //종료일자
    private String endDate;

    @XmlElement(name = "progressStatus")
    private String progressStatus;//0취소  1미진행 2진행 3완료 4보류

    @XmlElement(name = "sortTree")
    private String sortTree;

    @XmlElement(name = "licenseType")
    private String licenseType;

    @XmlElement(name = "licensePoint")
    private int licensePoint;

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

    @XmlElement(name = "varFileds")
    private String varFileds;

    @XmlElement(name = "registerId")
    private String registerId;

    @XmlElement(name = "registerPwd")
    private String registerPwd;

    @XmlElement(name = "registerName")
    private String registerName;

    @XmlElement(name = "registerNickname")
    private String registerNickname;

    @XmlElement(name = "registerEmail")
    private String registerEmail;

    @XmlElement(name = "registerIp")
    private String registerIp;

    @XmlElement(name = "registerDate")
    private String registerDate;

    @XmlElement(name = "updateId")
    private String updateId;

    @XmlElement(name = "updateDate")
    private String updateDate;

    @XmlElement(name = "updateIp")
    private String updateIp;

    @XmlElement(name = "statusType")
    private String statusType;  // 게시물 상태  0:삭제 1:대기 2:게재

    @XmlElement(name = "registerAfterHour")
    private String registerAfterHour;//등록후 지난시간

    @XmlElement(name = "updateAfterHour")
    private String updateAfterHour;//수정후 지난시간

    @XmlElement(name = "listImgInfo")
    private String listImgInfo;//리스트이미지정보

    @XmlElement(name = "listImgPath")
    private String listImgPath;//리스트이미지정보 Path

    @XmlElement(name = "listAttachInfo")
    private String listAttachInfo;//리스트파일정보

    @XmlElement(name = "contents")
    private String contents;//메세지내용

    @XmlElement(name = "newFlag")
    private String newFlag;

    @XmlElement(name = "messageConId")
    private Integer messageConId;

    @XmlElement(name = "showFile1")
    private String showFile1;

    @XmlElement(name = "showFile2")
    private String showFile2;

    private List<MessageAttachmentVO> attachmentList;

    private MessageAttachmentVO lastAttachment;//마지막 첨부파일

    private MessageAttachmentVO firstAttachment;//처음 첨부파일

    private MessageAttachmentVO downloadAttachment;//처음 첨부파일

    /**
     * Var_Fields를 사용한다..
     */
    private MessageVarFiledsVO messageVarFiledsVO;

	/**
	 * @return the messageId
	 */
	public Integer getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(Integer messageId) {
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
	 * @return the parentMessageId
	 */
	public String getParentMessageId() {
		return parentMessageId;
	}

	/**
	 * @param parentMessageId the parentMessageId to set
	 */
	public void setParentMessageId(String parentMessageId) {
		this.parentMessageId = parentMessageId;
	}

	/**
	 * @return the messageLevel
	 */
	public String getMessageLevel() {
		return messageLevel;
	}

	/**
	 * @param messageLevel the messageLevel to set
	 */
	public void setMessageLevel(String messageLevel) {
		this.messageLevel = messageLevel;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
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
	 * @return the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * @return the summaryContents
	 */
	public String getSummaryContents() {
		return summaryContents;
	}

	/**
	 * @param summaryContents the summaryContents to set
	 */
	public void setSummaryContents(String summaryContents) {
		this.summaryContents = summaryContents;
	}

	/**
	 * @return the viewCount
	 */
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @return the replyCount
	 */
	public Integer getReplyCount() {
		return replyCount;
	}

	/**
	 * @param replyCount the replyCount to set
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * @return the commentCount
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the attachmentCount
	 */
	public Integer getAttachmentCount() {
		return attachmentCount;
	}

	/**
	 * @param attachmentCount the attachmentCount to set
	 */
	public void setAttachmentCount(Integer attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	/**
	 * @return the scrapCount
	 */
	public Integer getScrapCount() {
		return scrapCount;
	}

	/**
	 * @param scrapCount the scrapCount to set
	 */
	public void setScrapCount(Integer scrapCount) {
		this.scrapCount = scrapCount;
	}

	/**
	 * @return the recommendCount
	 */
	public Integer getRecommendCount() {
		return recommendCount;
	}

	/**
	 * @param recommendCount the recommendCount to set
	 */
	public void setRecommendCount(Integer recommendCount) {
		this.recommendCount = recommendCount;
	}

	/**
	 * @return the recommendPoint
	 */
	public Integer getRecommendPoint() {
		return recommendPoint;
	}

	/**
	 * @param recommendPoint the recommendPoint to set
	 */
	public void setRecommendPoint(Integer recommendPoint) {
		this.recommendPoint = recommendPoint;
	}

	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * @return the homeUrl
	 */
	public String getHomeUrl() {
		return homeUrl;
	}

	/**
	 * @param homeUrl the homeUrl to set
	 */
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the progressStatus
	 */
	public String getProgressStatus() {
		return progressStatus;
	}

	/**
	 * @param progressStatus the progressStatus to set
	 */
	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
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
	 * @return the licenseType
	 */
	public String getLicenseType() {
		return licenseType;
	}

	/**
	 * @param licenseType the licenseType to set
	 */
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	/**
	 * @return the licensePoint
	 */
	public int getLicensePoint() {
		return licensePoint;
	}

	/**
	 * @param licensePoint the licensePoint to set
	 */
	public void setLicensePoint(int licensePoint) {
		this.licensePoint = licensePoint;
	}

	/**
	 * @return the varFiled1
	 */
	public String getVarFiled1() {
		return varFiled1;
	}

	/**
	 * @param varFiled1 the varFiled1 to set
	 */
	public void setVarFiled1(String varFiled1) {
		this.varFiled1 = varFiled1;
	}

	/**
	 * @return the varFiled2
	 */
	public String getVarFiled2() {
		return varFiled2;
	}

	/**
	 * @param varFiled2 the varFiled2 to set
	 */
	public void setVarFiled2(String varFiled2) {
		this.varFiled2 = varFiled2;
	}

	/**
	 * @return the varFiled3
	 */
	public String getVarFiled3() {
		return varFiled3;
	}

	/**
	 * @param varFiled3 the varFiled3 to set
	 */
	public void setVarFiled3(String varFiled3) {
		this.varFiled3 = varFiled3;
	}

	/**
	 * @return the varFiled4
	 */
	public String getVarFiled4() {
		return varFiled4;
	}

	/**
	 * @param varFiled4 the varFiled4 to set
	 */
	public void setVarFiled4(String varFiled4) {
		this.varFiled4 = varFiled4;
	}

	/**
	 * @return the varFiled5
	 */
	public String getVarFiled5() {
		return varFiled5;
	}

	/**
	 * @param varFiled5 the varFiled5 to set
	 */
	public void setVarFiled5(String varFiled5) {
		this.varFiled5 = varFiled5;
	}

	/**
	 * @return the varFiled6
	 */
	public String getVarFiled6() {
		return varFiled6;
	}

	/**
	 * @param varFiled6 the varFiled6 to set
	 */
	public void setVarFiled6(String varFiled6) {
		this.varFiled6 = varFiled6;
	}

	/**
	 * @return the varFiled7
	 */
	public String getVarFiled7() {
		return varFiled7;
	}

	/**
	 * @param varFiled7 the varFiled7 to set
	 */
	public void setVarFiled7(String varFiled7) {
		this.varFiled7 = varFiled7;
	}

	/**
	 * @return the varFiled8
	 */
	public String getVarFiled8() {
		return varFiled8;
	}

	/**
	 * @param varFiled8 the varFiled8 to set
	 */
	public void setVarFiled8(String varFiled8) {
		this.varFiled8 = varFiled8;
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
	 * @return the registerNickname
	 */
	public String getRegisterNickname() {
		return registerNickname;
	}

	/**
	 * @param registerNickname the registerNickname to set
	 */
	public void setRegisterNickname(String registerNickname) {
		this.registerNickname = registerNickname;
	}

	/**
	 * @return the registerEmail
	 */
	public String getRegisterEmail() {
		return registerEmail;
	}

	/**
	 * @param registerEmail the registerEmail to set
	 */
	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
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
	 * @return the registerAfterHour
	 */
	public String getRegisterAfterHour() {
		return registerAfterHour;
	}

	/**
	 * @param registerAfterHour the registerAfterHour to set
	 */
	public void setRegisterAfterHour(String registerAfterHour) {
		this.registerAfterHour = registerAfterHour;
	}

	/**
	 * @return the updateAfterHour
	 */
	public String getUpdateAfterHour() {
		return updateAfterHour;
	}

	/**
	 * @param updateAfterHour the updateAfterHour to set
	 */
	public void setUpdateAfterHour(String updateAfterHour) {
		this.updateAfterHour = updateAfterHour;
	}

	/**
	 * @return the listImgInfo
	 */
	public String getListImgInfo() {
		return listImgInfo;
	}

	/**
	 * @param listImgInfo the listImgInfo to set
	 */
	public void setListImgInfo(String listImgInfo) {
		this.listImgInfo = listImgInfo;
	}

	/**
	 * @return the listImgPath
	 */
	public String getListImgPath() {
		return listImgPath;
	}

	/**
	 * @param listImgPath the listImgPath to set
	 */
	public void setListImgPath(String listImgPath) {
		this.listImgPath = listImgPath;
	}

	/**
	 * @return the listAttachInfo
	 */
	public String getListAttachInfo() {
		return listAttachInfo;
	}

	/**
	 * @param listAttachInfo the listAttachInfo to set
	 */
	public void setListAttachInfo(String listAttachInfo) {
		this.listAttachInfo = listAttachInfo;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return the newFlag
	 */
	public String getNewFlag() {
		return newFlag;
	}

	/**
	 * @param newFlag the newFlag to set
	 */
	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	/**
	 * @return the messageConId
	 */
	public Integer getMessageConId() {
		return messageConId;
	}

	/**
	 * @param messageConId the messageConId to set
	 */
	public void setMessageConId(Integer messageConId) {
		this.messageConId = messageConId;
	}

	/**
	 * @return the attachmentList
	 */
	public List<MessageAttachmentVO> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * @param attachmentList the attachmentList to set
	 */
	public void setAttachmentList(List<MessageAttachmentVO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * @return the lastAttachment
	 */
	public MessageAttachmentVO getLastAttachment() {
		return lastAttachment;
	}

	/**
	 * @param lastAttachment the lastAttachment to set
	 */
	public void setLastAttachment(MessageAttachmentVO lastAttachment) {
		this.lastAttachment = lastAttachment;
	}

	/**
	 * @return the firstAttachment
	 */
	public MessageAttachmentVO getFirstAttachment() {
		return firstAttachment;
	}

	/**
	 * @param firstAttachment the firstAttachment to set
	 */
	public void setFirstAttachment(MessageAttachmentVO firstAttachment) {
		this.firstAttachment = firstAttachment;
	}

	/**
	 * @return the downloadAttachment
	 */
	public MessageAttachmentVO getDownloadAttachment() {
		return downloadAttachment;
	}

	/**
	 * @param downloadAttachment the downloadAttachment to set
	 */
	public void setDownloadAttachment(MessageAttachmentVO downloadAttachment) {
		this.downloadAttachment = downloadAttachment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageVO [messageId=" + messageId + ", boardId=" + boardId + ", messageCategoryId=" + messageCategoryId
				+ ", messageCategoryName=" + messageCategoryName + ", parentMessageId=" + parentMessageId
				+ ", messageLevel=" + messageLevel + ", tags=" + tags + ", topFlag=" + topFlag + ", title=" + title
				+ ", subTitle=" + subTitle + ", summaryContents=" + summaryContents + ", viewCount=" + viewCount
				+ ", replyCount=" + replyCount + ", commentCount=" + commentCount + ", attachmentCount="
				+ attachmentCount + ", scrapCount=" + scrapCount + ", recommendCount=" + recommendCount
				+ ", recommendPoint=" + recommendPoint + ", thumbnailUrl=" + thumbnailUrl + ", homeUrl=" + homeUrl
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", progressStatus=" + progressStatus
				+ ", sortTree=" + sortTree + ", licenseType=" + licenseType + ", licensePoint=" + licensePoint
				+ ", varFiled1=" + varFiled1 + ", varFiled2=" + varFiled2 + ", varFiled3=" + varFiled3 + ", varFiled4="
				+ varFiled4 + ", varFiled5=" + varFiled5 + ", varFiled6=" + varFiled6 + ", varFiled7=" + varFiled7
				+ ", varFiled8=" + varFiled8 + ", registerId=" + registerId + ", registerPwd=" + registerPwd
				+ ", registerName=" + registerName + ", registerNickname=" + registerNickname + ", registerEmail="
				+ registerEmail + ", registerIp=" + registerIp + ", registerDate=" + registerDate + ", updateId="
				+ updateId + ", updateDate=" + updateDate + ", updateIp=" + updateIp + ", statusType=" + statusType
				+ ", registerAfterHour=" + registerAfterHour + ", updateAfterHour=" + updateAfterHour + ", listImgInfo="
				+ listImgInfo + ", listImgPath=" + listImgPath + ", listAttachInfo=" + listAttachInfo + ", contents="
				+ contents + ", newFlag=" + newFlag + ", messageConId=" + messageConId + ", attachmentList="
				+ attachmentList + ", lastAttachment=" + lastAttachment + ", firstAttachment=" + firstAttachment
				+ ", downloadAttachment=" + downloadAttachment + "]";
	}

	/**
	 * @return the showFile1
	 */
	public String getShowFile1() {
		return showFile1;
	}

	/**
	 * @param showFile1 the showFile1 to set
	 */
	public void setShowFile1(String showFile1) {
		this.showFile1 = showFile1;
	}

	/**
	 * @return the showFile2
	 */
	public String getShowFile2() {
		return showFile2;
	}

	/**
	 * @param showFile2 the showFile2 to set
	 */
	public void setShowFile2(String showFile2) {
		this.showFile2 = showFile2;
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

	public MessageVarFiledsVO getMessageVarFiledsVO() {
		return messageVarFiledsVO;
	}

	public void setMessageVarFiledsVO(MessageVarFiledsVO messageVarFiledsVO) {
		this.messageVarFiledsVO = messageVarFiledsVO;
	}

	public String getVarFileds() {
		return varFileds;
	}

	public void setVarFileds(String varFileds) {
		this.varFileds = varFileds;
	}


}
