package com.pama.prdoption.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productOptionForm")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOptionFormVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4796233990951093281L;

	@XmlElement(name = "optId")
	private String optId;
	
	@XmlElement(name = "optName")
	private String optName;
	
	@XmlElement(name = "optStatus")
	private String optStatus;

	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getOptStatus() {
		return optStatus;
	}

	public void setOptStatus(String optStatus) {
		this.optStatus = optStatus;
	}
	
}
