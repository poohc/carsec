package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductsOpt")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsOptVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1585996842294929503L;
	
	/**
	 * 구매옵션아이디
	 */
	@XmlElement(name = "ordPrdOptId")
	private String ordPrdOptId;
	
	/**
	 * 주문 상품 아이디
	 */
	@XmlElement(name = "ordId")
	private String ordId;
	
	/**
	 * 상품 아이디
	 */
	@XmlElement(name = "prdId")
	private String prdId;
	
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

	public String getOrdPrdOptId() {
		return ordPrdOptId;
	}

	public void setOrdPrdOptId(String ordPrdOptId) {
		this.ordPrdOptId = ordPrdOptId;
	}

	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getPrdId() {
		return prdId;
	}

	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}

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

}
