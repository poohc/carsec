package com.pama.carestimate.vo;

import java.io.Serializable;

import com.pama.common.vo.SearchVO;

public class CarEstimateSearchVO extends SearchVO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -1527219992753350171L;
	private String requestId;
	private String requestCompanyId;
	private int progressStatus;

	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestCompanyId() {
		return requestCompanyId;
	}
	public void setRequestCompanyId(String requestCompanyId) {
		this.requestCompanyId = requestCompanyId;
	}
	public int getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(int progressStatus) {
		this.progressStatus = progressStatus;
	}

}
