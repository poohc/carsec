package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.prd.vo.ProductOptVO;

/**
 * @author 영수
 *
 */
@XmlRootElement(name = "CartProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class CartProductsVO implements Serializable{

    static final long serialVersionUID = 7531797618523735553L;

    /**
     * 장바구니 ID
     */
    @XmlElement(name = "cartId")
    private String cartId;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * QTY
     */
    @XmlElement(name = "qty")
    private int qty;
    
    /**
     * 기업회원코드 및 기업명
     */
    @XmlElement(name = "comp")
    private String comp;
    
    /**
     * 기업회원명
     */
    @XmlElement(name = "firstName")
    private String firstName;

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
     * 카테고리 이름
     */
    @XmlElement(name = "cateName")
    private String cateName;

    /**
     * 파일 이름
     */
    @XmlElement(name = "fileName")
    private String fileName;
    
    @XmlElement(name = "productOptVO")
    private List<ProductOptVO> productOptVO;    
    
    private String[] optId;

    /**
     * @return the cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

    /**
     * @return the prdName
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prdName the prdName to set
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the salePrice
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public List<ProductOptVO> getProductOptVO() {
		return productOptVO;
	}

	public void setProductOptVO(List<ProductOptVO> productOptVO) {
		this.productOptVO = productOptVO;
	}
    
    public String[] getOptId() {
		return optId;
	}

	public void setOptId(String[] optId) {
		this.optId = optId;
	}

}
