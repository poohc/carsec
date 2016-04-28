package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Purchaser")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaserVO implements Serializable{

    static final long serialVersionUID = -2621982483996597275L;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * 주문자 ID
     */
    @XmlElement(name = "ordererId")
    private String ordererId;

    /**
     * 주문자 이름
     */
    @XmlElement(name = "ordererName")
    private String ordererName;

    /**
     * 주문자 이메일
     */
    @XmlElement(name = "ordererEmail")
    private String ordererEmail;

    /**
     * 주문자 전화
     */
    @XmlElement(name = "ordererTel")
    private String ordererTel;

    /**
     * 주문자 핸드폰
     */
    @XmlElement(name = "ordererMobile")
    private String ordererMobile;

    /**
     * 주문자 우편번호
     */
    @XmlElement(name = "ordererZipcode")
    private String ordererZipcode;

    /**
     * 주문자 주소
     */
    @XmlElement(name = "ordererAddr1")
    private String ordererAddr1;

    /**
     * 주문자 상세주소
     */
    @XmlElement(name = "ordererAddr2")
    private String ordererAddr2;

    /**
     * 받는이 이름
     */
    @XmlElement(name = "receiveNane")
    private String receiveNane;

    /**
     * 받는이 이메일
     */
    @XmlElement(name = "receiveEmail")
    private String receiveEmail;

    /**
     * 받는이 전화
     */
    @XmlElement(name = "receiveTel")
    private String receiveTel;

    /**
     * 받는이 핸드폰
     */
    @XmlElement(name = "receiveMobile")
    private String receiveMobile;

    /**
     * 받는이 우편번호
     */
    @XmlElement(name = "receiveZipcode")
    private String receiveZipcode;

    /**
     * 받는이 주소
     */
    @XmlElement(name = "receiveAddr1")
    private String receiveAddr1;

    /**
     * 받는이 상세주소
     */
    @XmlElement(name = "receiveAddr2")
    private String receiveAddr2;

    /**
     * 메모
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

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
     * @return the ordererId
     */
    public String getOrdererId() {
        return ordererId;
    }

    /**
     * @param ordererId the ordererId to set
     */
    public void setOrdererId(String ordererId) {
        this.ordererId = ordererId;
    }

    /**
     * @return the ordererName
     */
    public String getOrdererName() {
        return ordererName;
    }

    /**
     * @param ordererName the ordererName to set
     */
    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    /**
     * @return the ordererEmail
     */
    public String getOrdererEmail() {
        return ordererEmail;
    }

    /**
     * @param ordererEmail the ordererEmail to set
     */
    public void setOrdererEmail(String ordererEmail) {
        this.ordererEmail = ordererEmail;
    }

    /**
     * @return the ordererTel
     */
    public String getOrdererTel() {
        return ordererTel;
    }

    /**
     * @param ordererTel the ordererTel to set
     */
    public void setOrdererTel(String ordererTel) {
        this.ordererTel = ordererTel;
    }

    /**
     * @return the ordererMobile
     */
    public String getOrdererMobile() {
        return ordererMobile;
    }

    /**
     * @param ordererMobile the ordererMobile to set
     */
    public void setOrdererMobile(String ordererMobile) {
        this.ordererMobile = ordererMobile;
    }

    /**
     * @return the ordererZipcode
     */
    public String getOrdererZipcode() {
        return ordererZipcode;
    }

    /**
     * @param ordererZipcode the ordererZipcode to set
     */
    public void setOrdererZipcode(String ordererZipcode) {
        this.ordererZipcode = ordererZipcode;
    }

    /**
     * @return the ordererAddr1
     */
    public String getOrdererAddr1() {
        return ordererAddr1;
    }

    /**
     * @param ordererAddr1 the ordererAddr1 to set
     */
    public void setOrdererAddr1(String ordererAddr1) {
        this.ordererAddr1 = ordererAddr1;
    }

    /**
     * @return the ordererAddr2
     */
    public String getOrdererAddr2() {
        return ordererAddr2;
    }

    /**
     * @param ordererAddr2 the ordererAddr2 to set
     */
    public void setOrdererAddr2(String ordererAddr2) {
        this.ordererAddr2 = ordererAddr2;
    }

    /**
     * @return the receiveNane
     */
    public String getReceiveNane() {
        return receiveNane;
    }

    /**
     * @param receiveNane the receiveNane to set
     */
    public void setReceiveNane(String receiveNane) {
        this.receiveNane = receiveNane;
    }

    /**
     * @return the receiveEmail
     */
    public String getReceiveEmail() {
        return receiveEmail;
    }

    /**
     * @param receiveEmail the receiveEmail to set
     */
    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    /**
     * @return the receiveTel
     */
    public String getReceiveTel() {
        return receiveTel;
    }

    /**
     * @param receiveTel the receiveTel to set
     */
    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    /**
     * @return the receiveMobile
     */
    public String getReceiveMobile() {
        return receiveMobile;
    }

    /**
     * @param receiveMobile the receiveMobile to set
     */
    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    /**
     * @return the receiveZipcode
     */
    public String getReceiveZipcode() {
        return receiveZipcode;
    }

    /**
     * @param receiveZipcode the receiveZipcode to set
     */
    public void setReceiveZipcode(String receiveZipcode) {
        this.receiveZipcode = receiveZipcode;
    }

    /**
     * @return the receiveAddr1
     */
    public String getReceiveAddr1() {
        return receiveAddr1;
    }

    /**
     * @param receiveAddr1 the receiveAddr1 to set
     */
    public void setReceiveAddr1(String receiveAddr1) {
        this.receiveAddr1 = receiveAddr1;
    }

    /**
     * @return the receiveAddr2
     */
    public String getReceiveAddr2() {
        return receiveAddr2;
    }

    /**
     * @param receiveAddr2 the receiveAddr2 to set
     */
    public void setReceiveAddr2(String receiveAddr2) {
        this.receiveAddr2 = receiveAddr2;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
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

}
