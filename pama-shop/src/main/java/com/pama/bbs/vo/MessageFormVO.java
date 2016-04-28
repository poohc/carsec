package com.pama.bbs.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pama.processor.vo.SendMailVO;

public class MessageFormVO extends SendMailVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -810631262151416570L;

	private String messageId;	// 게시물 번호

    private String boardId;		// 게시판 아이디

    private String messageCategoryId;		// 게시물 분류 번호

    private String messageCategoryName;		// 게시물 분류명

    private String parentMessageId;		// 부모 게시물 번호

    private String messageLevel;		// 게시물 레벨

    private String tags;			// 테그

    private String otags;			// 이전태그

    private String topFlag;

    private String title;			// 제목

    private String subTitle;		// 부제목

    private String summaryContents;		// 요약

    private String messageContentsTarget;

    private int viewCount;

    private int replyCount;

    private int commentCount;

    private int attachmentCount;

    private int scrapCount;

    private int recommendCount;

    private int recommendPoint;

    private String startDate;

    private String endDate;

    private String thumbnailUrl;

    private String licenseType;

    private int licensePoint;

    private String homeUrl;

    private String progressStatus;//0취소  1미진행 2진행 3완료 4보류

    private String sortTree;

    private String varFiled1;

    private String varFiled2;

    private String varFiled3;

    private String varFiled4;

    private String varFiled5;

    private String varFiled6;

    private String varFiled7;

    private String varFiled8;

    private String varFileds;

    private String registerId;

    private String registerPwd;

    private String registerName;

    private String registerNickname;

    private String registerEmail;

    private String registerIp;

    private String registerDate;

    private String updateId;

    private String updateDate;

    private String updateIp;

    private String statusType;

    private String contents;//메세지내용

    private String pointInit;//포인트초기화

	private MultipartFile file;

	private MultipartFile showFile1;
	private MultipartFile showFile2;
	private MultipartFile showFile3;
	private MultipartFile showFile4;
	private MultipartFile showFile5;
	private MultipartFile showFile6;
	private MultipartFile showFile7;
	private MultipartFile showFile8;
	private MultipartFile showFile9;

	private String[] files; // 임시 파일 저장 위치

	private String listReturnURL;

	private String attachmentId;

	private String[] checkedIds;

	private String registerDateType;	// 등록일 기준 적용

    private List<MessageCategoryVO> messageCategoryList;

    private List<MessageAttachmentVO> attachmentList;

    private String infoid;

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
	 * @return the otags
	 */
	public String getOtags() {
		return otags;
	}

	/**
	 * @param otags the otags to set
	 */
	public void setOtags(String otags) {
		this.otags = otags;
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
	 * @return the messageContentsTarget
	 */
	public String getMessageContentsTarget() {
		return messageContentsTarget;
	}

	/**
	 * @param messageContentsTarget the messageContentsTarget to set
	 */
	public void setMessageContentsTarget(String messageContentsTarget) {
		this.messageContentsTarget = messageContentsTarget;
	}

	/**
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @return the replyCount
	 */
	public int getReplyCount() {
		return replyCount;
	}

	/**
	 * @param replyCount the replyCount to set
	 */
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
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

	/**
	 * @return the attachmentCount
	 */
	public int getAttachmentCount() {
		return attachmentCount;
	}

	/**
	 * @param attachmentCount the attachmentCount to set
	 */
	public void setAttachmentCount(int attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	/**
	 * @return the scrapCount
	 */
	public int getScrapCount() {
		return scrapCount;
	}

	/**
	 * @param scrapCount the scrapCount to set
	 */
	public void setScrapCount(int scrapCount) {
		this.scrapCount = scrapCount;
	}

	/**
	 * @return the recommendCount
	 */
	public int getRecommendCount() {
		return recommendCount;
	}

	/**
	 * @param recommendCount the recommendCount to set
	 */
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	/**
	 * @return the recommendPoint
	 */
	public int getRecommendPoint() {
		return recommendPoint;
	}

	/**
	 * @param recommendPoint the recommendPoint to set
	 */
	public void setRecommendPoint(int recommendPoint) {
		this.recommendPoint = recommendPoint;
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
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the files
	 */
	public String[] getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(String[] files) {
		this.files = files;
	}

	/**
	 * @return the listReturnURL
	 */
	public String getListReturnURL() {
		return listReturnURL;
	}

	/**
	 * @param listReturnURL the listReturnURL to set
	 */
	public void setListReturnURL(String listReturnURL) {
		this.listReturnURL = listReturnURL;
	}

	/**
	 * @return the attachmentId
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * @return the checkedIds
	 */
	public String[] getCheckedIds() {
		return checkedIds;
	}

	/**
	 * @param checkedIds the checkedIds to set
	 */
	public void setCheckedIds(String[] checkedIds) {
		this.checkedIds = checkedIds;
	}

	/**
	 * @return the registerDateType
	 */
	public String getRegisterDateType() {
		return registerDateType;
	}

	/**
	 * @param registerDateType the registerDateType to set
	 */
	public void setRegisterDateType(String registerDateType) {
		this.registerDateType = registerDateType;
	}

	/**
	 * @return the messageCategoryList
	 */
	public List<MessageCategoryVO> getMessageCategoryList() {
		return messageCategoryList;
	}

	/**
	 * @param messageCategoryList the messageCategoryList to set
	 */
	public void setMessageCategoryList(List<MessageCategoryVO> messageCategoryList) {
		this.messageCategoryList = messageCategoryList;
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
	 * @return the infoid
	 */
	public String getInfoid() {
		return infoid;
	}

	/**
	 * @param infoid the infoid to set
	 */
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	public MultipartFile getShowFile1() {
		return showFile1;
	}

	public void setShowFile1(MultipartFile showFile1) {
		this.showFile1 = showFile1;
	}

	public MultipartFile getShowFile2() {
		return showFile2;
	}

	public void setShowFile2(MultipartFile showFile2) {
		this.showFile2 = showFile2;
	}

	public MultipartFile getShowFile3() {
		return showFile3;
	}

	public void setShowFile3(MultipartFile showFile3) {
		this.showFile3 = showFile3;
	}

	public MultipartFile getShowFile4() {
		return showFile4;
	}

	public void setShowFile4(MultipartFile showFile4) {
		this.showFile4 = showFile4;
	}

	public MultipartFile getShowFile5() {
		return showFile5;
	}

	public void setShowFile5(MultipartFile showFile5) {
		this.showFile5 = showFile5;
	}

	public MultipartFile getShowFile6() {
		return showFile6;
	}

	public void setShowFile6(MultipartFile showFile6) {
		this.showFile6 = showFile6;
	}

	public MultipartFile getShowFile7() {
		return showFile7;
	}

	public void setShowFile7(MultipartFile showFile7) {
		this.showFile7 = showFile7;
	}

	public MultipartFile getShowFile8() {
		return showFile8;
	}

	public void setShowFile8(MultipartFile showFile8) {
		this.showFile8 = showFile8;
	}

	public MultipartFile getShowFile9() {
		return showFile9;
	}

	public void setShowFile9(MultipartFile showFile9) {
		this.showFile9 = showFile9;
	}

	public String getVarFileds() {
		return varFileds;
	}

	public void setVarFileds(String varFileds) {
		this.varFileds = varFileds;
	}

	public String getPointInit() {
		return pointInit;
	}

	public void setPointInit(String pointInit) {
		this.pointInit = pointInit;
	}

}
