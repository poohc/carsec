package com.pama.banner.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "bannerSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BannerSearchVO extends SearchVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3538010829935359623L;

	@XmlElement(name = "bannerPlaceId")
	private String bannerPlaceId;  // 배너위치번호

	@XmlElement(name = "bannerTitle")
	private String bannerTitle;  // 배너위치명

	@XmlElement(name = "bannerGroupId")
	private String bannerGroupId;

	@XmlElement(name = "compyName")
	private String compyName;

	@XmlElement(name = "personName")
	private String personName;

	@XmlElement(name = "personEmail")
	private String personEmail;

	@XmlElement(name = "personTel")
	private String personTel;

	@XmlElement(name = "bannerId")
	private String bannerId;

	@XmlElement(name = "bannerOpenTags")
	private String bannerOpenTags;

	@XmlElement(name = "statusType")
	private String statusType;

	@XmlElement(name = "bannerTargetOpen")
	private String bannerTargetOpen;

	/**
	 * @return the bannerPlaceId
	 */
	public String getBannerPlaceId() {
		return bannerPlaceId;
	}

	/**
	 * @param bannerPlaceId the bannerPlaceId to set
	 */
	public void setBannerPlaceId(String bannerPlaceId) {
		this.bannerPlaceId = bannerPlaceId;
	}

	/**
	 * @return the bannerTitle
	 */
	public String getBannerTitle() {
		return bannerTitle;
	}

	/**
	 * @param bannerTitle the bannerTitle to set
	 */
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}

	/**
	 * @return the bannerGroupId
	 */
	public String getBannerGroupId() {
		return bannerGroupId;
	}

	/**
	 * @param bannerGroupId the bannerGroupId to set
	 */
	public void setBannerGroupId(String bannerGroupId) {
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
	 * @return the bannerId
	 */
	public String getBannerId() {
		return bannerId;
	}

	/**
	 * @param bannerId the bannerId to set
	 */
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	/**
	 * @return the bannerOpenTags
	 */
	public String getBannerOpenTags() {
		return bannerOpenTags;
	}

	/**
	 * @param bannerOpenTags the bannerOpenTags to set
	 */
	public void setBannerOpenTags(String bannerOpenTags) {
		this.bannerOpenTags = bannerOpenTags;
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

	/**
	 * @return the bannerTargetOpen
	 */
	public String getBannerTargetOpen() {
		return bannerTargetOpen;
	}

	/**
	 * @param bannerTargetOpen the bannerTargetOpen to set
	 */
	public void setBannerTargetOpen(String bannerTargetOpen) {
		this.bannerTargetOpen = bannerTargetOpen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BannerSearchVO [bannerPlaceId=" + bannerPlaceId
				+ ", bannerTitle=" + bannerTitle + ", bannerGroupId="
				+ bannerGroupId + ", compyName=" + compyName + ", personName="
				+ personName + ", personEmail=" + personEmail + ", personTel="
				+ personTel + ", bannerId=" + bannerId + ", bannerOpenTags="
				+ bannerOpenTags + ", statusType=" + statusType
				+ ", bannerTargetOpen=" + bannerTargetOpen + "]";
	}

}
