package com.pama.mbrpoint.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "point")
@XmlAccessorType(XmlAccessType.FIELD)
public class PointVO implements Serializable{

	private static final long serialVersionUID = 4957455975378611827L;

	@XmlElement
    private int pointId;

    @XmlElement
    private String mbrId;

    @XmlElement
    private String pointFlag; // 1:충전 2:사용 3:환불

    @XmlElement
    private int point;

    @XmlElement
    private String pointTitle;

    @XmlElement
    private int messageId;

    @XmlElement
    private String messageRegisterId;

    @XmlElement
    private Timestamp registerDate;

    @XmlElement
    private String registerId;

    @XmlElement
    private String registerIp;

    @XmlElement
    private int countPoint;//총판매수

    @XmlElement
    private int sumPoint;//총 판매금액

    @XmlElement
    private int settlPoint;//정산예정금액

    @XmlElement
    private float infoSettlRates;//정산률


	public int getCountPoint() {
		return countPoint;
	}

	public void setCountPoint(int countPoint) {
		this.countPoint = countPoint;
	}

	public int getSumPoint() {
		return sumPoint;
	}

	public void setSumPoint(int sumPoint) {
		this.sumPoint = sumPoint;
	}

	public int getSettlPoint() {
		return settlPoint;
	}

	public void setSettlPoint(int settlPoint) {
		this.settlPoint = settlPoint;
	}

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
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
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
	 * @return the infoSettlRates
	 */
	public float getInfoSettlRates() {
		return infoSettlRates;
	}

	/**
	 * @param infoSettlRates the infoSettlRates to set
	 */
	public void setInfoSettlRates(float infoSettlRates) {
		this.infoSettlRates = infoSettlRates;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PointVO [pointId=" + pointId + ", mbrId=" + mbrId + ", pointFlag=" + pointFlag + ", point=" + point
				+ ", pointTitle=" + pointTitle + ", messageId=" + messageId + ", messageRegisterId=" + messageRegisterId
				+ ", registerDate=" + registerDate + ", registerId=" + registerId + ", registerIp=" + registerIp
				+ ", countPoint=" + countPoint + ", sumPoint=" + sumPoint + ", settlPoint=" + settlPoint
				+ ", infoSettlRates=" + infoSettlRates + "]";
	}

}
