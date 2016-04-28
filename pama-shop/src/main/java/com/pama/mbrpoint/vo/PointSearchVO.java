package com.pama.mbrpoint.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;
@XmlRootElement(name = "pointSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class PointSearchVO extends SearchVO implements Serializable{

    static final long serialVersionUID = 8911453255105256427L;

    @XmlElement
    private String mbrId;

    @XmlElement
    private String pointFlag; // 1:충전 2:사용 3:환불

    @XmlElement
    private int messageId;

    @XmlElement
    private String messageRegisterId;

    @XmlElement
    private String registerId;
    
    @XmlElement
    private String registerDate;

    /**
     * 마지막 Point 날짜 (시작)
     */
    @XmlElement
    private String startPointDate;

    /**
     * 마지막 Point 날짜 (끝)
     */
    @XmlElement
    private String endPointDate;
    
    private String year;
    private String month;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getPointFlag() {
		return pointFlag;
	}

	public void setPointFlag(String pointFlag) {
		this.pointFlag = pointFlag;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageRegisterId() {
		return messageRegisterId;
	}

	public void setMessageRegisterId(String messageRegisterId) {
		this.messageRegisterId = messageRegisterId;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getStartPointDate() {
		return startPointDate;
	}

	public void setStartPointDate(String startPointDate) {
		this.startPointDate = startPointDate;
	}

	public String getEndPointDate() {
		return endPointDate;
	}

	public void setEndPointDate(String endPointDate) {
		this.endPointDate = endPointDate;
	}

}
