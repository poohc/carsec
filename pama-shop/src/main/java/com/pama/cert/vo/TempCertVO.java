package com.pama.cert.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bluesky ko
 *
 */
@XmlRootElement(name = "tempCert")
@XmlAccessorType(XmlAccessType.FIELD)
public class TempCertVO  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9023395748111573156L;

	@XmlElement(name = "tmpId")
    private Integer tmpId;
    
    @XmlElement(name = "mobile")
    private String mobile;
    
    @XmlElement(name = "certKey")
    private String certKey;
    
    @XmlElement(name = "registerDate")
    private String registerDate;

	public Integer getTmpId() {
		return tmpId;
	}

	public void setTmpId(Integer tmpId) {
		this.tmpId = tmpId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCertKey() {
		return certKey;
	}

	public void setCertKey(String certKey) {
		this.certKey = certKey;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

    
}
