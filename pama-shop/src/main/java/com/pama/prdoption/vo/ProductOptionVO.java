package com.pama.prdoption.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productOption")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOptionVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 832361586122702954L;

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
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 등록 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

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

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateIp() {
		return updateIp;
	}

	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}

	public String getOptStatus() {
		return optStatus;
	}

	public void setOptStatus(String optStatus) {
		this.optStatus = optStatus;
	}

}
