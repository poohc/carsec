package com.pama.carcheck.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carCheckQuestion")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarCheckQuestionVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4449890751704040341L;
	private int totalCount;
	private String questionType;
	private CarCheckVO carCheckVO;
	private List<CarCheckVO> list;
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
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	/**
	 * @return the carCheckVO
	 */
	public CarCheckVO getCarCheckVO() {
		return carCheckVO;
	}
	/**
	 * @param carCheckVO the carCheckVO to set
	 */
	public void setCarCheckVO(CarCheckVO carCheckVO) {
		this.carCheckVO = carCheckVO;
	}
	/**
	 * @return the list
	 */
	public List<CarCheckVO> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<CarCheckVO> list) {
		this.list = list;
	}



}
