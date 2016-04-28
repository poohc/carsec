package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.Constants;
import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "productSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSearchVO extends SearchVO implements Serializable
{

    /**
     * UID
     */
    private static final long serialVersionUID = 5970979435630272121L;
    
    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;
    
    /**
     * 카테고리 ID
     */
    @XmlElement(name = "cateId")
    private String cateId;
    
    /**
     * 카테고리 IDS
     */
    @XmlElement(name = "cateIds")
    private String[] cateIds;

    /**
     * 카테고리 이름
     */
    @XmlElement(name = "cateName")
    private String cateName;
    
    /**
     * 상품 이름
     */
    @XmlElement(name = "prdName")
    private String prdName;
    
    /**
     * 가격
     */
    @XmlElement(name = "price")
    private String price;

    /**
     * 할인 가격
     */
    @XmlElement(name = "salePrice")
    private String salePrice;

    /**
     * 회사
     */
    @XmlElement(name = "comp")
    private String comp;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     *  상태
     */
    @XmlElement(name = "statusType")
    private String statusType;
    
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
     * 상품리스트화면의 탭 플래그
     */
    @XmlElement(name = "sortTab")
    private String sortTab = Constants.PRODUCT_SORT_TAB_NEW;

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
	public String[] getCateIds() {
		return cateIds;
	}

	/**
	 * @param cateIds
	 */
	public void setCateIds(String[] cateIds) {
		this.cateIds = cateIds;
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
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prdName
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    /**
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return
     */
    public String getComp() {
        return comp;
    }

    /**
     * @param comp
     */
    public void setComp(String comp) {
        this.comp = comp;
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
	public String getSortTab() {
		return sortTab;
	}

	/**
	 * @param sortTab
	 */
	public void setSortTab(String sortTab) {
		this.sortTab = sortTab;
	}
    
    

}
