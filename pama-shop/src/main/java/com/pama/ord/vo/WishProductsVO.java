package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WishProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class WishProductsVO implements Serializable{

    static final long serialVersionUID = -8876906846442867821L;

    /**
     * 찜하기 ID
     */
    @XmlElement(name = "wishNid")
    private int wishNid;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

    /**
     * @return the wishNid
     */
    public int getWishNid() {
        return wishNid;
    }

    /**
     * @param wishNid the wishNid to set
     */
    public void setWishNid(int wishNid) {
        this.wishNid = wishNid;
    }

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
