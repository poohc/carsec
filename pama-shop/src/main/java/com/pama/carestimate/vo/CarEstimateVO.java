package com.pama.carestimate.vo;

import java.io.Serializable;

public class CarEstimateVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2607839033916395550L;
	private int carEstimateId;
	private String requestDate;
	private String requestId;
	private String requestNickname;
	private String requestTel;
	private String requestCompanyId;
	private String requestCompanyName;
	private String carId;
	private String model;
	private String carYear;
	private String mission;
	private String distance;
	private String carCheckTitle;
	private String carCheckGcodeQcode;
	private String estimateDate;
	private String estimatePrice;
	private String repairInfo;
	private String visitDate;
	private String visitRegisterDate;
	private int progressStatus; //1:요청,2:견적,3:예약
	private int r1Count; //1:요청
	private int r2Count; //2:견적
	private int r3Count; //3:예약

	private String companyAddr;
	/**
	 * @return the carEstimateId
	 */
	public int getCarEstimateId() {
		return carEstimateId;
	}
	/**
	 * @param carEstimateId the carEstimateId to set
	 */
	public void setCarEstimateId(int carEstimateId) {
		this.carEstimateId = carEstimateId;
	}
	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the requestNickname
	 */
	public String getRequestNickname() {
		return requestNickname;
	}
	/**
	 * @param requestNickname the requestNickname to set
	 */
	public void setRequestNickname(String requestNickname) {
		this.requestNickname = requestNickname;
	}
	/**
	 * @return the requestTel
	 */
	public String getRequestTel() {
		return requestTel;
	}
	/**
	 * @param requestTel the requestTel to set
	 */
	public void setRequestTel(String requestTel) {
		this.requestTel = requestTel;
	}
	/**
	 * @return the requestCompanyId
	 */
	public String getRequestCompanyId() {
		return requestCompanyId;
	}
	/**
	 * @param requestCompanyId the requestCompanyId to set
	 */
	public void setRequestCompanyId(String requestCompanyId) {
		this.requestCompanyId = requestCompanyId;
	}
	/**
	 * @return the requestCompanyName
	 */
	public String getRequestCompanyName() {
		return requestCompanyName;
	}
	/**
	 * @param requestCompanyName the requestCompanyName to set
	 */
	public void setRequestCompanyName(String requestCompanyName) {
		this.requestCompanyName = requestCompanyName;
	}
	/**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the carYear
	 */
	public String getCarYear() {
		return carYear;
	}
	/**
	 * @param carYear the carYear to set
	 */
	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}
	/**
	 * @return the mission
	 */
	public String getMission() {
		return mission;
	}
	/**
	 * @param mission the mission to set
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	 * @return the carCheckTitle
	 */
	public String getCarCheckTitle() {
		return carCheckTitle;
	}
	/**
	 * @param carCheckTitle the carCheckTitle to set
	 */
	public void setCarCheckTitle(String carCheckTitle) {
		this.carCheckTitle = carCheckTitle;
	}
	/**
	 * @return the carCheckGcodeQcode
	 */
	public String getCarCheckGcodeQcode() {
		return carCheckGcodeQcode;
	}
	/**
	 * @param carCheckGcodeQcode the carCheckGcodeQcode to set
	 */
	public void setCarCheckGcodeQcode(String carCheckGcodeQcode) {
		this.carCheckGcodeQcode = carCheckGcodeQcode;
	}
	/**
	 * @return the estimateDate
	 */
	public String getEstimateDate() {
		return estimateDate;
	}
	/**
	 * @param estimateDate the estimateDate to set
	 */
	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}
	/**
	 * @return the estimatePrice
	 */
	public String getEstimatePrice() {
		return estimatePrice;
	}
	/**
	 * @param estimatePrice the estimatePrice to set
	 */
	public void setEstimatePrice(String estimatePrice) {
		this.estimatePrice = estimatePrice;
	}
	/**
	 * @return the repairInfo
	 */
	public String getRepairInfo() {
		return repairInfo;
	}
	/**
	 * @param repairInfo the repairInfo to set
	 */
	public void setRepairInfo(String repairInfo) {
		this.repairInfo = repairInfo;
	}
	/**
	 * @return the visitDate
	 */
	public String getVisitDate() {
		return visitDate;
	}
	/**
	 * @param visitDate the visitDate to set
	 */
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	/**
	 * @return the visitRegisterDate
	 */
	public String getVisitRegisterDate() {
		return visitRegisterDate;
	}
	/**
	 * @param visitRegisterDate the visitRegisterDate to set
	 */
	public void setVisitRegisterDate(String visitRegisterDate) {
		this.visitRegisterDate = visitRegisterDate;
	}
	/**
	 * @return the progressStatus
	 */
	public int getProgressStatus() {
		return progressStatus;
	}
	/**
	 * @param progressStatus the progressStatus to set
	 */
	public void setProgressStatus(int progressStatus) {
		this.progressStatus = progressStatus;
	}
	@Override
	public String toString() {
		return "CarEstimateVO [carEstimateId=" + carEstimateId + ", requestDate=" + requestDate + ", requestId="
				+ requestId + ", requestNickname=" + requestNickname + ", requestTel=" + requestTel
				+ ", requestCompanyId=" + requestCompanyId + ", requestCompanyName=" + requestCompanyName + ", carId="
				+ carId + ", model=" + model + ", carYear=" + carYear + ", mission=" + mission + ", distance="
				+ distance + ", carCheckTitle=" + carCheckTitle + ", carCheckGcodeQcode=" + carCheckGcodeQcode
				+ ", estimateDate=" + estimateDate + ", estimatePrice=" + estimatePrice + ", repairInfo=" + repairInfo
				+ ", visitDate=" + visitDate + ", visitRegisterDate=" + visitRegisterDate + ", progressStatus="
				+ progressStatus + "]";
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	/**
	 * @return the r1Count
	 */
	public int getR1Count() {
		return r1Count;
	}
	/**
	 * @param r1Count the r1Count to set
	 */
	public void setR1Count(int r1Count) {
		this.r1Count = r1Count;
	}
	/**
	 * @return the r2Count
	 */
	public int getR2Count() {
		return r2Count;
	}
	/**
	 * @param r2Count the r2Count to set
	 */
	public void setR2Count(int r2Count) {
		this.r2Count = r2Count;
	}
	/**
	 * @return the r3Count
	 */
	public int getR3Count() {
		return r3Count;
	}
	/**
	 * @param r3Count the r3Count to set
	 */
	public void setR3Count(int r3Count) {
		this.r3Count = r3Count;
	}

}
