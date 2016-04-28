package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;

@XmlRootElement(name = "mechanicInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountMechanicInfoVO implements Serializable{

	private static final long serialVersionUID = 2420712871627600700L;


	/**
	 * 메카닉 아이디
	 */
	@XmlElement
	private String mechanicId;

	/**
	 * 회원 아이디
	 */
	@XmlElement(name = "mbrId")
	private String mbrId;

	/**
	 *사업자 등록번호
	 */
	@XmlElement(name = "bizNumber")
	private String bizNumber;

	/**
	 *사업장 사진 파일위치
	 */
	@XmlElement(name = "bizPhoto")
	private String bizPhoto;

	/**
	 *사업자등록증 파일위치
	 */
	@XmlElement(name = "bizRegFile")
	private String bizRegFile;

	/**
	 * 패스수신여부
	 */
	@XmlElement
	private String faxTrans;

	/**
	 *서비스품목1
	 */
	@XmlElement(name = "serviceItem1")
	private String serviceItem1;

	/**
	 *서비스품목2
	 */
	@XmlElement(name = "serviceItem2")
	private String serviceItem2;


	/**
	 *서비스품목3
	 */
	@XmlElement(name = "serviceItem3")
	private String serviceItem3;

	/**
	 *서비스품목4
	 */
	@XmlElement(name = "serviceItem4")
	private String serviceItem4;

	/**
	 *서비스품목5
	 */
	@XmlElement(name = "serviceItem5")
	private String serviceItem5;

	/**
	 * file1
	 */
	private MultipartFile file1;

	/**
	 * file2
	 */
	private MultipartFile file2;

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getBizNumber() {
		return bizNumber;
	}

	public void setBizNumber(String bizNumber) {
		this.bizNumber = bizNumber;
	}

	public String getBizPhoto() {
		return bizPhoto;
	}

	public void setBizPhoto(String bizPhoto) {
		this.bizPhoto = bizPhoto;
	}

	public String getBizRegFile() {
		return bizRegFile;
	}

	public void setBizRegFile(String bizRegFile) {
		this.bizRegFile = bizRegFile;
	}

	public String getServiceItem1() {
		return serviceItem1;
	}

	public void setServiceItem1(String serviceItem1) {
		this.serviceItem1 = serviceItem1;
	}

	public String getServiceItem2() {
		return serviceItem2;
	}

	public void setServiceItem2(String serviceItem2) {
		this.serviceItem2 = serviceItem2;
	}

	public String getServiceItem3() {
		return serviceItem3;
	}

	public void setServiceItem3(String serviceItem3) {
		this.serviceItem3 = serviceItem3;
	}

	public String getServiceItem4() {
		return serviceItem4;
	}

	public void setServiceItem4(String serviceItem4) {
		this.serviceItem4 = serviceItem4;
	}

	public String getServiceItem5() {
		return serviceItem5;
	}

	public void setServiceItem5(String serviceItem5) {
		this.serviceItem5 = serviceItem5;
	}


	@Override
	public String toString() {
		return "AccountAgencyInfoVO [mbrId=" + mbrId + ", bizNumber=" + bizNumber + ", bizPhoto=" + bizPhoto
				+ ", bizRegFile=" + bizRegFile + ", serviceItem1=" + serviceItem1 + ", serviceItem2=" + serviceItem2
				+ ", serviceItem3=" + serviceItem3 + ", serviceItem4=" + serviceItem4 + ", serviceItem5=" + serviceItem5
				+ "]";
	}

	/**
	 * @return the faxTrans
	 */
	public String getFaxTrans() {
		return faxTrans;
	}

	/**
	 * @param faxTrans the faxTrans to set
	 */
	public void setFaxTrans(String faxTrans) {
		this.faxTrans = faxTrans;
	}

	/**
	 * @return the file1
	 */
	public MultipartFile getFile1() {
		return file1;
	}

	/**
	 * @param file1 the file1 to set
	 */
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	/**
	 * @return the file2
	 */
	public MultipartFile getFile2() {
		return file2;
	}

	/**
	 * @param file2 the file2 to set
	 */
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	/**
	 * @return the mechanicId
	 */
	public String getMechanicId() {
		return mechanicId;
	}

	/**
	 * @param mechanicId the mechanicId to set
	 */
	public void setMechanicId(String mechanicId) {
		this.mechanicId = mechanicId;
	}



}
