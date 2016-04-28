package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatisticsVO implements Serializable{

    /**
     * UID
     */
    private static final long serialVersionUID = 1915456973331691592L;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 통계 타입
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * 구매 통계 Count
     */
    @XmlElement(name = "statisticsCount")
    private String statisticsCount;

    /**
     * @return the prdId
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * @param prdId the prdId to set
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId;
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
     * @return the statisticsCount
     */
    public String getStatisticsCount() {
        return statisticsCount;
    }

    /**
     * @param statisticsCount the statisticsCount to set
     */
    public void setStatisticsCount(String statisticsCount) {
        this.statisticsCount = statisticsCount;
    }

}
