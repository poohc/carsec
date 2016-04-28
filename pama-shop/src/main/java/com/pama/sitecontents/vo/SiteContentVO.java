package com.pama.sitecontents.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;

public class SiteContentVO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 932097436728048380L;

    @XmlElement(name = "contentId")
    private Integer contentId;	// 게시물 번호

    @XmlElement(name = "contentKey")
    private String contentKey;		//

    @XmlElement(name = "contents")
    private String contents;

    @XmlElement(name = "checkedIds")
    private String[] checkedIds;


	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getContentKey() {
		return contentKey;
	}

	public void setContentKey(String contentKey) {
		this.contentKey = contentKey;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String[] getCheckedIds() {
		return checkedIds;
	}

	public void setCheckedIds(String[] checkedIds) {
		this.checkedIds = checkedIds;
	}

	@Override
	public String toString() {
		return "SiteContentVO [contentId=" + contentId + ", contentKey=" + contentKey + ", contents=" + contents
				+ ", checkedIds=" + Arrays.toString(checkedIds) + "]";
	}



}
