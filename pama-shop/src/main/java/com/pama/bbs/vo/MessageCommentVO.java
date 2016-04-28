/**
 * 이소스는 저작권은 개발자  pama게시판 개발자에게 있습니다.
 * 납품한 홈페이지에서는 자유롭게 수정 및 편집이 가능하나 다른 홈페이지에
 * 게재시 지적 재산권에 문제있음을 공지합니다.
 * 개발자 : pama
 * 이메일 : sycop78@gmail.com
 */
package com.pama.bbs.vo;

public class MessageCommentVO implements java.io.Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 2297225266816943428L;
	private String commentId;
    private String messageId;
    private String title;
    private String comments;
    private String statusType;
    private String registerId;
    private String registerPwd;
    private String registerName;
    private String registerNickname;
    private String registerEmail;
    private String registerIp;
    private String sortTree;
    private String recommendCount;

    public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getRegisterPwd() {
		return registerPwd;
	}
	public void setRegisterPwd(String registerPwd) {
		this.registerPwd = registerPwd;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getRegisterNickname() {
		return registerNickname;
	}
	public void setRegisterNickname(String registerNickname) {
		this.registerNickname = registerNickname;
	}
	public String getRegisterEmail() {
		return registerEmail;
	}
	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}
	public String getRegisterIp() {
		return registerIp;
	}
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	private String registerDate;

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
	 * @return the recommendCount
	 */
	public String getRecommendCount() {
		return recommendCount;
	}
	/**
	 * @param recommendCount the recommendCount to set
	 */
	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}

}
