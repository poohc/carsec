/**
 * 이소스는 저작권은 개발자  pama게시판 개발자에게 있습니다.
 * 납품한 홈페이지에서는 자유롭게 수정 및 편집이 가능하나 다른 홈페이지에
 * 게재시 지적 재산권에 문제있음을 공지합니다.
 * 개발자 : pama
 * 이메일 : sycop78@gmail.com
 */
package com.pama.bbs.vo;

public class MessageRecommendVO implements java.io.Serializable {
	
	private static final long serialVersionUID = -2646627860580545176L;

	private int recommendId;
	private int messageId;
	private String registerDate;
	private String registerId;
	private String registerIp;
	public int getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(int recommendId) {
		this.recommendId = recommendId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getRegisterIp() {
		return registerIp;
	}
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

}
