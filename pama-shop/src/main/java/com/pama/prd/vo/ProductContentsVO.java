package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productContents")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductContentsVO implements Serializable
{
    /**
     * UID
     */
    private static final long serialVersionUID = -3126342015009508615L;

    /**
     * 상품 내용 정보 ID
     */
    @XmlElement(name = "prdConId")
    private String prdConId;
    
    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;
    
    /**
     * 내용
     */
    @XmlElement(name = "contents")
    private String contents;
    
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
     * @return
     */
    public String getPrdConId() {
        return prdConId;
    }

    /**
     * @param prdConId
     */
    public void setPrdConId(String prdConId) {
        this.prdConId = prdConId;
    }

    /**
     * @return
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * @param prdId
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    /**
     * @return
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * @return
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
    
}
