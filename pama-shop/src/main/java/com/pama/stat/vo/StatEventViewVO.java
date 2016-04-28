package com.pama.stat.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "statEventView")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatEventViewVO implements Serializable{
    /**
	 *
	 */
	private static final long serialVersionUID = -137580209409601420L;

	/**
	 * 이벤트 코드 : 무료학습(FREESTUDY....)
	 */
	@XmlElement(name = "eventCode")
    protected String eventCode;

	/**
	 * 브라우져정보
	 */
    @XmlElement(name = "userAgent")
    protected String userAgent;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    protected String registerDate;

    /**
     * 등록아이피
     */
    @XmlElement(name = "registerIp")
    protected String registerIp;

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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

}
