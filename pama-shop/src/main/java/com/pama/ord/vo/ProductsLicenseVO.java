package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductsLicense")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsLicenseVO implements Serializable{

    static final long serialVersionUID = -4016205632179529398L;

    /**
     * 회원 first이름
     */
    @XmlElement(name = "firstName")
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    /**
     * 회원 이메일
     */
    @XmlElement(name = "email")
    private String email;

    /**
     * 성별 (m/f)
     */
    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "password")
    private String password;

    /**
     * 주문 상품 ID
     */
    @XmlElement(name = "opdRodId")
    private String opdRodId;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * 주문 상품 이름
     */
    @XmlElement(name = "prdName")
    private String prdName;

    /**
     * QTY
     */
    @XmlElement(name = "qty")
    private int qty;

    /**
     * 할인가격
     */
    @XmlElement(name = "salePrice")
    private int salePrice;

    /**
     * 가격
     */
    @XmlElement(name = "price")
    private String price;

    /**
     * 시작일
     */
    @XmlElement(name = "startDate")
    private String startDate;

    /**
     * 종료일
     */
    @XmlElement(name = "endDate")
    private String endDate;

    /**
     * 유효개월수
     */
    @XmlElement(name = "expirationMonth")
    private String expirationMonth;

    /**
     * 라이센스 코드
     */
    @XmlElement(name = "licenseCode")
    private String licenseCode;

    /**
     * 카테고리 이름
     */
    @XmlElement(name = "cateId")
    private String cateId;

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

    /**
     * 파일 이름
     */
    @XmlElement(name = "totalCount")
    private int totalCount;

    /**
     * 등록자 ID
     */
    private String registerId;

    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * @return the opdRodId
     */
    public String getOpdRodId() {
        return opdRodId;
    }

    /**
     * @param opdRodId the opdRodId to set
     */
    public void setOpdRodId(String opdRodId) {
        this.opdRodId = opdRodId;
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
     * @return the prodName
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName;
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
     * @return the salePrice
     */
    public int getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * @param expirationMonth the expirationMonth to set
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
	 * @return the licenseCode
	 */
	public String getLicenseCode() {
		return licenseCode;
	}

	/**
	 * @param licenseCode the licenseCode to set
	 */
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	/**
	 * @return the cateId
	 */
	public String getCateId() {
		return cateId;
	}

	/**
	 * @param cateId the cateId to set
	 */
	public void setCateId(String cateId) {
		this.cateId = cateId;
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

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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

}
