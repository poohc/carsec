package com.pama.banner.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bannerGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class BannerGroupVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5804518790599808240L;

	@XmlElement(name = "bannerGroupId")
	private Integer bannerGroupId;

	@XmlElement(name = "compyName")
	private String compyName;

	@XmlElement(name = "personName")
	private String personName;

	@XmlElement(name = "personEmail")
	private String personEmail;

	@XmlElement(name = "personTel")
	private String personTel;

	@XmlElement(name = "registerDate")
	private String registerDate;

	@XmlElement(name = "registerId")
	private String registerId;

	@XmlElement(name = "registerIp")
	private String registerIp;

	@XmlElement(name = "updateDate")
	private String updateDate;

	@XmlElement(name = "updateId")
	private String updateId;

	@XmlElement(name = "updateIp")
	private String updateIp;

	@XmlElement(name = "statusType")
	private String statusType;

	/**
	 * @return the bannerGroupId
	 */
	public Integer getBannerGroupId() {
		return bannerGroupId;
	}

	/**
	 * @param bannerGroupId the bannerGroupId to set
	 */
	public void setBannerGroupId(Integer bannerGroupId) {
		this.bannerGroupId = bannerGroupId;
	}

	/**
	 * @return the compyName
	 */
	public String getCompyName() {
		return compyName;
	}

	/**
	 * @param compyName the compyName to set
	 */
	public void setCompyName(String compyName) {
		this.compyName = compyName;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the personEmail
	 */
	public String getPersonEmail() {
		return personEmail;
	}

	/**
	 * @param personEmail the personEmail to set
	 */
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	/**
	 * @return the personTel
	 */
	public String getPersonTel() {
		return personTel;
	}

	/**
	 * @param personTel the personTel to set
	 */
	public void setPersonTel(String personTel) {
		this.personTel = personTel;
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
	public String getStatusType() {
		return statusType;
	}

	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

}
