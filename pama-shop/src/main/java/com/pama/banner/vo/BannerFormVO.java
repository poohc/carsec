package com.pama.banner.vo;

import org.springframework.web.multipart.MultipartFile;

public class BannerFormVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6811262952490223220L;

	private String bannerPlaceId;  // 배너위치번호

	private String bannerTitle;  // 배너위치명

    private String registerId;

    private String registerIp;

	private String updateId;

	private String updateIp;

	private String bannerGroupId;

	private String compyName;

	private String personName;

	private String personEmail;

	private String personTel;

	private String bannerId;

	private String bannerStartDate;

	private String bannerEndDate;

	private String bannerOpenTags;

	private String openCount;

	private String clickCount;

	private String bannerTargetType;

	private String bannerTargetOpen;

	private String bannerTargetUrl;

	private String statusType;

	private MultipartFile file;

	private String listReturnURL;

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
	 * @return the bannerStartDate
	 */
	public String getBannerStartDate() {
		return bannerStartDate;
	}

	/**
	 * @param bannerStartDate the bannerStartDate to set
	 */
	public void setBannerStartDate(String bannerStartDate) {
		this.bannerStartDate = bannerStartDate;
	}

	/**
	 * @return the bannerEndDate
	 */
	public String getBannerEndDate() {
		return bannerEndDate;
	}

	/**
	 * @param bannerEndDate the bannerEndDate to set
	 */
	public void setBannerEndDate(String bannerEndDate) {
		this.bannerEndDate = bannerEndDate;
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
	 * @return the openCount
	 */
	public String getOpenCount() {
		return openCount;
	}

	/**
	 * @param openCount the openCount to set
	 */
	public void setOpenCount(String openCount) {
		this.openCount = openCount;
	}

	/**
	 * @return the clickCount
	 */
	public String getClickCount() {
		return clickCount;
	}

	/**
	 * @param clickCount the clickCount to set
	 */
	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
	}

	/**
	 * @return the bannerTargetType
	 */
	public String getBannerTargetType() {
		return bannerTargetType;
	}

	/**
	 * @param bannerTargetType the bannerTargetType to set
	 */
	public void setBannerTargetType(String bannerTargetType) {
		this.bannerTargetType = bannerTargetType;
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

	/**
	 * @return the bannerTargetUrl
	 */
	public String getBannerTargetUrl() {
		return bannerTargetUrl;
	}

	/**
	 * @param bannerTargetUrl the bannerTargetUrl to set
	 */
	public void setBannerTargetUrl(String bannerTargetUrl) {
		this.bannerTargetUrl = bannerTargetUrl;
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
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the listReturnURL
	 */
	public String getListReturnURL() {
		return listReturnURL;
	}

	/**
	 * @param listReturnURL the listReturnURL to set
	 */
	public void setListReturnURL(String listReturnURL) {
		this.listReturnURL = listReturnURL;
	}

}
