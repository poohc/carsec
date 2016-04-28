package com.pama.mbrpoint.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "point")
@XmlAccessorType(XmlAccessType.FIELD)
public class PointFormVO implements Serializable{

	private static final long serialVersionUID = -3286264769806644712L;

	@XmlElement
    private int pointId;

    @XmlElement
    private String mbrId;

    @XmlElement
    private String pointFlag; // 1:충전 2:사용 3:환불

    @XmlElement
    private int point;

    @XmlElement
    private int updateAccPoint;

    @XmlElement
    private String pointTitle;

    @XmlElement
    private int messageId;

    @XmlElement
    private String messageRegisterId;

    @XmlElement
    private String registerId;

    @XmlElement
    private String registerIp;

	/**
	 * @return the pointId
	 */
	public int getPointId() {
		return pointId;
	}

	/**
	 * @param pointId the pointId to set
	 */
	public void setPointId(int pointId) {
		this.pointId = pointId;
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
	 * @return the pointFlag
	 */
	public String getPointFlag() {
		return pointFlag;
	}

	/**
	 * @param pointFlag the pointFlag to set
	 */
	public void setPointFlag(String pointFlag) {
		this.pointFlag = pointFlag;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the updateAccPoint
	 */
	public int getUpdateAccPoint() {
		return updateAccPoint;
	}

	/**
	 * @param updateAccPoint the updateAccPoint to set
	 */
	public void setUpdateAccPoint(int updateAccPoint) {
		this.updateAccPoint = updateAccPoint;
	}

	/**
	 * @return the pointTitle
	 */
	public String getPointTitle() {
		return pointTitle;
	}

	/**
	 * @param pointTitle the pointTitle to set
	 */
	public void setPointTitle(String pointTitle) {
		this.pointTitle = pointTitle;
	}

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messageRegisterId
	 */
	public String getMessageRegisterId() {
		return messageRegisterId;
	}

	/**
	 * @param messageRegisterId the messageRegisterId to set
	 */
	public void setMessageRegisterId(String messageRegisterId) {
		this.messageRegisterId = messageRegisterId;
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

}
