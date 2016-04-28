package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productLicenseForm")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductLicenseFormVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2453828944278052379L;

    /**
     * 상품 라이센스 ID
     */
    @XmlElement(name = "prdLicenseId")
    private String prdLicenseId;

	/**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 라이센스 코드
     */
    @XmlElement(name = "licenseCode")
    private String licenseCode;

    /**
     * 발행일
     */
    @XmlElement(name = "publishDate")
    private String publishDate;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 등록 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 라이센스 발행 상태
     */
    @XmlElement(name = "licensePublishType")
    private String licensePublishType;

    private String[] checkedIds;

	/**
	 * @return the prdLicenseId
	 */
	public String getPrdLicenseId() {
		return prdLicenseId;
	}

	/**
	 * @param prdLicenseId the prdLicenseId to set
	 */
	public void setPrdLicenseId(String prdLicenseId) {
		this.prdLicenseId = prdLicenseId;
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
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
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

	/**
	 * @return the licensePublishType
	 */
	public String getLicensePublishType() {
		return licensePublishType;
	}

	/**
	 * @param licensePublishType the licensePublishType to set
	 */
	public void setLicensePublishType(String licensePublishType) {
		this.licensePublishType = licensePublishType;
	}

	/**
	 * @return the checkedIds
	 */
	public String[] getCheckedIds() {
		return checkedIds;
	}

	/**
	 * @param checkedIds the checkedIds to set
	 */
	public void setCheckedIds(String[] checkedIds) {
		this.checkedIds = checkedIds;
	}

}
