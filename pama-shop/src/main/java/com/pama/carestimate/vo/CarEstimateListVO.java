package com.pama.carestimate.vo;

import java.io.Serializable;
import java.util.List;

public class CarEstimateListVO implements Serializable {

	private static final long serialVersionUID = -1274992109520364168L;

	private int totalCount;
	private CarEstimateSearchVO carEstimateSearchVO;
	private List<CarEstimateVO> list;
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the carEstimateSearchVO
	 */
	public CarEstimateSearchVO getCarEstimateSearchVO() {
		return carEstimateSearchVO;
	}
	/**
	 * @param carEstimateSearchVO the carEstimateSearchVO to set
	 */
	public void setCarEstimateSearchVO(CarEstimateSearchVO carEstimateSearchVO) {
		this.carEstimateSearchVO = carEstimateSearchVO;
	}
	/**
	 * @return the list
	 */
	public List<CarEstimateVO> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<CarEstimateVO> list) {
		this.list = list;
	}



}
