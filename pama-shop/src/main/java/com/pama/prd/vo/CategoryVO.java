package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryVO implements Serializable
{
    /**
     * UID
     */
    private static final long serialVersionUID = 3278011567548650285L;

    /**
     * 카테고리 ID
     */
    @XmlElement(name = "cateId")
    private String cateId;

    /**
     * 카테고리 분류
     * 6자리 기준
     * 전방 두자리 대분류
     * 중방 두자리 중분류
     * 후방 두자리 소분류
     */
    @XmlElement(name = "sortTree")
    private String sortTree;

    /**
     * 카테고리 이름
     */
    @XmlElement(name = "cateName")
    private String cateName;

    /**
     * 카테고리 URL
     */
    @XmlElement(name = "pageUrl")
    private String pageUrl;

    /**
     * 등록 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 수정 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * 등록 날짜
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 수정 날짜
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * @return
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * @param cateId
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    /**
     * @return
     */
    public String getSortTree() {
        return sortTree;
    }

    /**
     * @param sortTree
     */
    public void setSortTree(String sortTree) {
        this.sortTree = sortTree;
    }

    /**
     * @return
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * @param pageUrl
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * @return
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    /**
     * @return
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * @return
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
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
