package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;
@XmlRootElement(name = "orderSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSearchVO extends SearchVO implements Serializable{

    private static final long serialVersionUID = -7911079097978081007L;

    /**
     * 주문 등록자 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 주문 상태
     */
    @XmlElement(name = "statusType")
    private int statusType;

    /**
     * 주문등록 날짜 (시작)
     */
    @XmlElement(name = "startRegisterDate")
    private String startRegisterDate;

    /**
     * 주문등록 날짜 (끝)
     */
    @XmlElement(name = "endRegisterDate")
    private String endRegisterDate;


    /**
     * 이용기간 종료 구분
     */
    @XmlElement(name = "endDateType")
    private String endDateType;

    /**
     * 주문 결제 타입
     */
    @XmlElement(name = "settleType")
    private String settleType;
    
    private String comp;
    
    private String[] statusTypes;

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
     * @return the statusType
     */
    public int getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the startRegisterDate
     */
    public String getStartRegisterDate() {
        return startRegisterDate;
    }

    /**
     * @param startRegisterDate the startRegisterDate to set
     */
    public void setStartRegisterDate(String startRegisterDate) {
        this.startRegisterDate = startRegisterDate;
    }

    /**
     * @return the endRegisterDate
     */
    public String getEndRegisterDate() {
        return endRegisterDate;
    }

    /**
     * @param endRegisterDate the endRegisterDate to set
     */
    public void setEndRegisterDate(String endRegisterDate) {
        this.endRegisterDate = endRegisterDate;
    }

    /**
	 * @return the endDateType
	 */
	public String getEndDateType() {
		return endDateType;
	}

	/**
	 * @param endDateType the endDateType to set
	 */
	public void setEndDateType(String endDateType) {
		this.endDateType = endDateType;
	}

	/**
     * @return the settleType
     */
    public String getSettleType() {
        return settleType;
    }

    /**
     * @param settleType the settleType to set
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String[] getStatusTypes() {
		return statusTypes;
	}

	public void setStatusTypes(String[] statusTypes) {
		this.statusTypes = statusTypes;
	}

}
