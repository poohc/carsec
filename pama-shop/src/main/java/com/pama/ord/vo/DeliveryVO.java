package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Delivery")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryVO implements Serializable{

    static final long serialVersionUID = -5855190026234345307L;

    /**
     * 배송 ID
     */
    @XmlElement(name = "dlvId")
    private int dlvId;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * name
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * transNo
     */
    @XmlElement(name = "transNo")
    private String transNo;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 등록자 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정자 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * @return the dlvId
     */
    public int getDlvId() {
        return dlvId;
    }

    /**
     * @param dlvId the dlvId to set
     */
    public void setDlvId(int dlvId) {
        this.dlvId = dlvId;
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the transNo
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * @param transNo the transNo to set
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo;
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
     * @return the updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the updateId
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId the updateId to set
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

}
