package com.pama.banner.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bannerPlace")
@XmlAccessorType(XmlAccessType.FIELD)
public class BannerPlaceVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2850822418303077687L;

	@XmlElement(name = "bannerPlaceId")
	private Integer bannerPlaceId;  // 배너위치번호

	@XmlElement(name = "bannerTitle")
	private String bannerTitle;  // 배너위치명

	@XmlElement(name = "bannerSize")
	private String bannerSize;  // 배너 사이즈 ( W : 300 * H : 300 )

	@XmlElement(name = "bannerMemo")
	private String bannerMemo;  // 배너 위치 설명

	@XmlElement(name = "registerDate")
	private String registerDate;

    @XmlElement(name = "registerId")
    private String registerId;

    @XmlElement(name = "registerIp")
    private String registerIp;

    @XmlElement(name = "updateDate")
    private String updateDate;

    @XmlElement(name = "statusType")
    private String statusType;  // 게시물 상태  0:삭제 1:대기 2:게재

	/**
	 * @return the bannerPlaceId
	 */
	public Integer getBannerPlaceId() {
		return bannerPlaceId;
	}

	/**
	 * @param bannerPlaceId the bannerPlaceId to set
	 */
	public void setBannerPlaceId(Integer bannerPlaceId) {
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
	 * @return the bannerMemo
	 */
	public String getBannerMemo() {
		return bannerMemo;
	}

	/**
	 * @param bannerMemo the bannerMemo to set
	 */
	public void setBannerMemo(String bannerMemo) {
		this.bannerMemo = bannerMemo;
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
