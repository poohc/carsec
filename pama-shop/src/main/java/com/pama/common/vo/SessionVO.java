package com.pama.common.vo;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.StringUtils;

public class SessionVO implements Serializable {

    static final long serialVersionUID = -1404575046937514191L;

	/**
     * 회원 ID
     */
    @XmlElement(name = "mbrId")
    private String mbrId;

    /**
     * 회원 이름
     */
    @XmlElement(name = "memberNm")
    private String memberNm;

    /**
     * 회원 닉네임
     */
    @XmlElement(name = "nickNm")
    private String nickNm;

    /**
     * 회원 이메일
     */
    @XmlElement(name = "email")
    private String email;

    /**
     * 회원 레벨
     */
    @XmlElement(name = "level")
    private int level;

    /**
     * 마지막 로그인 날짜
     */
    @XmlElement(name = "loginDate")
    private String loginDate;

    /**
     * 회원 로그인 카운트
     */
    @XmlElement(name = "loginCnt")
    private int loginCnt;

    /**
     * 트위터 토근정보(암호)
     */
    @XmlElement(name = "tokenSecret")
    private String tokenSecret;

    /**
     * 성별구분
     */
    @XmlElement(name = "gender")
    private String gender;

    /**
     * 정보원아이디
     */
    @XmlElement(name = "infoid")
    private String infoid;

    /**
     * infoApproval
     */
    @XmlElement(name = "infoApproval")
    private String infoApproval;


	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	/**
	 * @return the mbrId
	 */
	public String getMbrId() {
		return mbrId;
	}

	/**
	 * @param mbrId the mbrId to set
	 */
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	/**
	 * @return the memberNm
	 */
	public String getMemberNm() {
		return memberNm;
	}

	/**
	 * @param memberNm the memberNm to set
	 */
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	/**
	 * @return the nickNm
	 */
	public String getNickNm() {
		if(StringUtils.isEmpty(nickNm)){
			nickNm=memberNm;
		}
		return nickNm;
	}

	/**
	 * @param nickNm the nickNm to set
	 */
	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the loginDate
	 */
	public String getLoginDate() {
		return loginDate;
	}

	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * @return the loginCnt
	 */
	public int getLoginCnt() {
		return loginCnt;
	}

	/**
	 * @param loginCnt the loginCnt to set
	 */
	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}

	/**
	 * @return the tokenSecret
	 */
	public String getTokenSecret() {
		return tokenSecret;
	}

	/**
	 * @param tokenSecret the tokenSecret to set
	 */
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the infoApproval
	 */
	public String getInfoApproval() {
		return infoApproval;
	}

	/**
	 * @param infoApproval the infoApproval to set
	 */
	public void setInfoApproval(String infoApproval) {
		this.infoApproval = infoApproval;
	}

}
