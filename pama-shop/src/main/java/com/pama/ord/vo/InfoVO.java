package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Delivery")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoVO implements Serializable {

    static final long serialVersionUID = -9164199728924473513L;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * 주문 title
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * 주문 total 가격
     */
    @XmlElement(name = "totalPrice")
    private int totalPrice;

    /**
     * 주문 결제 가격
     */
    @XmlElement(name = "settlePrice")
    private int settlePrice;

    /**
     * 주문 결제 타입 (0 : 무통장, 1: 카드, 2: 실시간 계좌이체)
     */
    @XmlElement(name = "settleType")
    private String settleType;

    /**
     * 주문 결제 계좌 번호
     */
    @XmlElement(name = "settleAccountNo")
    private String settleAccountNo;

    /**
     * 주문 결제 계좌 은행
     */
    @XmlElement(name = "settleAccountBank")
    private String settleAccountBank;

    /**
     * 주문 결제 계좌 예금주
     */
    @XmlElement(name = "settleAccountNm")
    private String settleAccountNm;

    /**
     * 주문 입금자
     */
    @XmlElement(name = "depositNm")
    private String depositNm;

    /**
     * 배송 타입 (0 : 무료, 유료 - 1: 선불  2: 착불)
     */
    @XmlElement(name = "deliveryType")
    private String deliveryType;

    /**
     * 배송비
     */
    @XmlElement(name = "deliveryPrice")
    private int deliveryPrice;

    /**
     * 세금 계산서 발행 여부
     */
    @XmlElement(name = "orderTexyn")
    private String orderTexyn;

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
     * 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

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
     * 수정 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 주문 상태
     */
    @XmlElement(name = "statusType")
    private int statusType;

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the settlePrice
     */
    public int getSettlePrice() {
        return settlePrice;
    }

    /**
     * @param settlePrice the settlePrice to set
     */
    public void setSettlePrice(int settlePrice) {
        this.settlePrice = settlePrice;
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

    /**
     * @return the settleAccountNo
     */
    public String getSettleAccountNo() {
        return settleAccountNo;
    }

    /**
     * @param settleAccountNo the settleAccountNo to set
     */
    public void setSettleAccountNo(String settleAccountNo) {
        this.settleAccountNo = settleAccountNo;
    }

    /**
     * @return the settleAccountBank
     */
    public String getSettleAccountBank() {
        return settleAccountBank;
    }

    /**
     * @param settleAccountBank the settleAccountBank to set
     */
    public void setSettleAccountBank(String settleAccountBank) {
        this.settleAccountBank = settleAccountBank;
    }

    /**
     * @return the settleAccountNm
     */
    public String getSettleAccountNm() {
        return settleAccountNm;
    }

    /**
     * @param settleAccountNm the settleAccountNm to set
     */
    public void setSettleAccountNm(String settleAccountNm) {
        this.settleAccountNm = settleAccountNm;
    }

    /**
     * @return the depositNm
     */
    public String getDepositNm() {
        return depositNm;
    }

    /**
     * @param depositNm the depositNm to set
     */
    public void setDepositNm(String depositNm) {
        this.depositNm = depositNm;
    }

    /**
     * @return the deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * @param deliveryType the deliveryType to set
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * @return the deliveryPrice
     */
    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * @param deliveryPrice the deliveryPrice to set
     */
    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * @return the orderTexyn
     */
    public String getOrderTexyn() {
        return orderTexyn;
    }

    /**
     * @param orderTexyn the orderTexyn to set
     */
    public void setOrderTexyn(String orderTexyn) {
        this.orderTexyn = orderTexyn;
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

    /**
     * @return the updateIp
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * @param updateIp the updateIp to set
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
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

}
