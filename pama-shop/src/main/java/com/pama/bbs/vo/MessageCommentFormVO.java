/**
 * 이소스는 저작권은 개발자  pama게시판 개발자에게 있습니다.
 * 납품한 홈페이지에서는 자유롭게 수정 및 편집이 가능하나 다른 홈페이지에
 * 게재시 지적 재산권에 문제있음을 공지합니다.
 * 개발자 : pama
 * 이메일 : sycop78@gmail.com
 */
package com.pama.bbs.vo;

public class MessageCommentFormVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2432800156221884778L;

	private String commentId;
	private String messageId;
	private String title;
	private String comments;
	private String returnUrl;
    private String registerId;
    private String registerPwd;
    private String registerName;
    private String registerNickname;
    private String registerEmail;
    private String registerIp;
    private String sortTree;
    private String statusType;
    private String[] checkedIds;

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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the returnUrl
	 */
	public String getReturnUrl() {
		return returnUrl;
	}
	/**
	 * @param returnUrl the returnUrl to set
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
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

}
