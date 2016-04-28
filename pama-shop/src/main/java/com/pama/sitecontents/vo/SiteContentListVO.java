package com.pama.sitecontents.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.bbs.vo.MessageSearchVO;


@XmlRootElement(name = "siteContentList")
@XmlAccessorType(XmlAccessType.FIELD)
public  class SiteContentListVO implements Serializable{



	/**
	 *
	 */
	private static final long serialVersionUID = 4478818877387913246L;

	@XmlElement(name = "siteContentList")
	private List<SiteContentVO> siteContentList;

	private int totalCount;

	private MessageSearchVO messageSearchVO;



	public List<SiteContentVO> getSiteContentList() {
		return siteContentList;
	}


	public void setSiteContentList(List<SiteContentVO> siteContentList) {
		this.siteContentList = siteContentList;
	}




	public MessageSearchVO getMessageSearchVO() {
		return messageSearchVO;
	}


	public void setMessageSearchVO(MessageSearchVO messageSearchVO) {
		this.messageSearchVO = messageSearchVO;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}





}
