package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Tax")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaxVO implements Serializable{

    static final long serialVersionUID = 4632836446164799419L;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * 사업자등록 번호
     */
    @XmlElement(name = "compBizNo")
    private String compBizNo;

    /**
     * 회사명
     */
    @XmlElement(name = "compNm")
    private String compNm;

    /**
     * 대표자명
     */
    @XmlElement(name = "ceoNm")
    private String ceoNm;

    /**
     * 회사주소
     */
    @XmlElement(name = "compAddr")
    private String compAddr;

    /**
     * 부서명
     */
    @XmlElement(name = "compBizNm")
    private String compBizNm;

    /**
     * 업종
     */
    @XmlElement(name = "compFieldNm")
    private String compFieldNm;

    /**
     * @return the ordId
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * @param ordId the ordId to set
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    /**
     * @return the compBizNo
     */
    public String getCompBizNo() {
        return compBizNo;
    }

    /**
     * @param compBizNo the compBizNo to set
     */
    public void setCompBizNo(String compBizNo) {
        this.compBizNo = compBizNo;
    }

    /**
     * @return the compNm
     */
    public String getCompNm() {
        return compNm;
    }

    /**
     * @param compNm the compNm to set
     */
    public void setCompNm(String compNm) {
        this.compNm = compNm;
    }

    /**
     * @return the ceoNm
     */
    public String getCeoNm() {
        return ceoNm;
    }

    /**
     * @param ceoNm the ceoNm to set
     */
    public void setCeoNm(String ceoNm) {
        this.ceoNm = ceoNm;
    }

    /**
     * @return the compAddr
     */
    public String getCompAddr() {
        return compAddr;
    }

    /**
     * @param compAddr the compAddr to set
     */
    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }

    /**
     * @return the compBizNm
     */
    public String getCompBizNm() {
        return compBizNm;
    }

    /**
     * @param compBizNm the compBizNm to set
     */
    public void setCompBizNm(String compBizNm) {
        this.compBizNm = compBizNm;
    }

    /**
     * @return the compFieldNm
     */
    public String getCompFieldNm() {
        return compFieldNm;
    }

    /**
     * @param compFieldNm the compFieldNm to set
     */
    public void setCompFieldNm(String compFieldNm) {
        this.compFieldNm = compFieldNm;
    }

}
