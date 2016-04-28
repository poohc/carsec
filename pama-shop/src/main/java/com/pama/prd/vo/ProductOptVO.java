package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productOpt")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOptVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6739711703692147064L;

	/**
	 * 옵션아이디
	 */
	@XmlElement(name = "optId")
	private String optId;

	/**
	 * 옵션명
	 */
	@XmlElement(name = "optName")
	private String optName;

	/**
	 * 옵션 금액
	 */
	@XmlElement(name = "optPrice")
	private String optPrice;

	/**
	 * 상품아이디
	 */
	@XmlElement(name = "prdId")
	private String prdId;

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

	public String getOptPrice() {
		return optPrice;
	}

	public void setOptPrice(String optPrice) {
		this.optPrice = optPrice;
	}

	public String getPrdId() {
		return prdId;
	}

	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

}
