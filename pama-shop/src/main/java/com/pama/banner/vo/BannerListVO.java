package com.pama.banner.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bannerList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BannerListVO implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -9203977802180729618L;

	@XmlElement(name = "bannerPlaceList")
	private List<BannerPlaceVO> bannerPlaceList;

	@XmlElement(name = "bannerGroupList")
	private List<BannerGroupVO> bannerGroupList;

	@XmlElement(name = "bannerInfoList")
	private List<BannerInfoVO> bannerInfoList;

    private BannerSearchVO bannerSearchVO;

	/**
	 * @return the bannerPlaceList
	 */
	public List<BannerPlaceVO> getBannerPlaceList() {
		return bannerPlaceList;
	}

	/**
	 * @param bannerPlaceList the bannerPlaceList to set
	 */
	public void setBannerPlaceList(List<BannerPlaceVO> bannerPlaceList) {
		this.bannerPlaceList = bannerPlaceList;
	}

	/**
	 * @return the bannerGroupList
	 */
	public List<BannerGroupVO> getBannerGroupList() {
		return bannerGroupList;
	}

	/**
	 * @param bannerGroupList the bannerGroupList to set
	 */
	public void setBannerGroupList(List<BannerGroupVO> bannerGroupList) {
		this.bannerGroupList = bannerGroupList;
	}

	/**
	 * @return the bannerInfoList
	 */
	public List<BannerInfoVO> getBannerInfoList() {
		return bannerInfoList;
	}

	/**
	 * @param bannerInfoList the bannerInfoList to set
	 */
	public void setBannerInfoList(List<BannerInfoVO> bannerInfoList) {
		this.bannerInfoList = bannerInfoList;
	}

	/**
	 * @return the bannerSearchVO
	 */
	public BannerSearchVO getBannerSearchVO() {
		return bannerSearchVO;
	}

	/**
	 * @param bannerSearchVO the bannerSearchVO to set
	 */
	public void setBannerSearchVO(BannerSearchVO bannerSearchVO) {
		this.bannerSearchVO = bannerSearchVO;
	}

}
