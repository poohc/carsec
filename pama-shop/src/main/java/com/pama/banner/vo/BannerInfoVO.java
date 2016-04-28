package com.pama.banner.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bannerInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class BannerInfoVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6288109304875909927L;

	@XmlElement(name = "bannerId")
	private Integer bannerId;

	@XmlElement(name = "bannerGroupId")
	private String bannerGroupId;

	@XmlElement(name = "compyName")
	private String compyName;

	@XmlElement(name = "bannerPlaceId")
	private String bannerPlaceId;

	@XmlElement(name = "bannerTitle")
	private String bannerTitle;  // 배너위치명

	@XmlElement(name = "bannerSize")
	private String bannerSize;  // 배너 사이즈 ( W : 300 * H : 300 )

	@XmlElement(name = "bannerStartDate")
	private String bannerStartDate;

	@XmlElement(name = "bannerEndDate")
	private String bannerEndDate;

	@XmlElement(name = "bannerOpenTags")
	private String bannerOpenTags;

	@XmlElement(name = "openCount")
	private String openCount;

	@XmlElement(name = "clickCount")
	private String clickCount;

	@XmlElement(name = "bannerTargetType")
	private String bannerTargetType;

	@XmlElement(name = "bannerTargetOpen")
	private String bannerTargetOpen;

	@XmlElement(name = "bannerTargetUrl")
	private String bannerTargetUrl;

	@XmlElement(name = "fileType")
	private String fileType;

	@XmlElement(name = "fileName")
	private String fileName;

	@XmlElement(name = "fileSize")
	private String fileSize;

	@XmlElement(name = "imageWidth")
	private String imageWidth;

	@XmlElement(name = "imageHeight")
	private String imageHeight;

	@XmlElement(name = "contentType")
	private String contentType;

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
	 * @return the bannerId
	 */
	public Integer getBannerId() {
		return bannerId;
	}

	/**
	 * @param bannerId the bannerId to set
	 */
	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
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
	 * @return the bannerSize
	 */
	public String getBannerSize() {
		return bannerSize;
	}

	/**
	 * @param bannerSize the bannerSize to set
	 */
	public void setBannerSize(String bannerSize) {
		this.bannerSize = bannerSize;
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
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
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
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the imageWidth
	 */
	public String getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public String getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
