package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountCarInfoVO implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -3553264823714970897L;

	/**
     * 자동차정보 일련번호
     */
    @XmlElement(name = "carId")
	private String carId;

    /**
     * 회원 아이디
     */
    @XmlElement(name = "mbrId")
	private String mbrId;

    /**
     * 제조사
     */
    @XmlElement(name = "brand")
	private String brand;

    /**
     * 모델
     */
    @XmlElement(name = "model")
	private String model;

    /**
     * 미션
     */
    @XmlElement(name = "mission")
	private String mission;

    /**
     * 연식
     */
    @XmlElement(name = "caryear")
	private String caryear;

    /**
     * 주행거리
     */
    @XmlElement(name = "distance")
	private String distance;

    /**
     * 차대번호
     */
    @XmlElement(name = "carIdentNumber")
	private String carIdentNumber;

    /**
     * 차량번호
     */
    @XmlElement(name = "carNumber")
	private String carNumber;

    /**
     * 차량정보 코드
     */
    @XmlElement(name = "carCode")
   	private String carCode;


	public String getCarIdentNumber() {
		return carIdentNumber;
	}

	public void setCarIdentNumber(String carIdentNumber) {
		this.carIdentNumber = carIdentNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getCaryear() {
		return caryear;
	}

	public void setCaryear(String caryear) {
		this.caryear = caryear;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	@Override
	public String toString() {
		return "AccountCarInfoVO [carId=" + carId + ", mbrId=" + mbrId + ", brand=" + brand + ", model=" + model
				+ ", mission=" + mission + ", caryear=" + caryear + ", distance=" + distance + ", carIdentNumber="
				+ carIdentNumber + ", carNumber=" + carNumber + ", carCode=" + carCode + "]";
	}

}
