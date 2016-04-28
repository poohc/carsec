package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "productLicenseSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductLicenseSearchVO extends SearchVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2752619889919911123L;

    /**
     * 상품 License ID
     */
    @XmlElement(name = "prdLicenseId")
    private String prdLicenseId;

	/**
     * 카테고리 ID
     */
    @XmlElement(name = "cateId")
    private String cateId;

	/**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

	/**
     * 상품명
     */
    @XmlElement(name = "prdName")
    private String prdName;

	/**
     * 라이센스코드
     */
    @XmlElement(name = "licenseCode")
    private String licenseCode;

    /**
     * 라이센스 발행여부
     */
    @XmlElement(name = "licensePublishType")
    private String licensePublishType;

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

}
