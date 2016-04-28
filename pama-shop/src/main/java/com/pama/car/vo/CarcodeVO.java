package com.pama.car.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bluesky ko
 *
 */
@XmlRootElement(name = "carcode")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarcodeVO  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9023395748111573156L;

	@XmlElement(name = "carId")
    private Integer carId;
    
    @XmlElement(name = "maker")
    private String maker;
    
    @XmlElement(name = "modelName")
    private String modelName;
    
    @XmlElement(name = "method")
    private String method;
    
    @XmlElement(name = "startYear")
    private String startYear;
    
    @XmlElement(name = "endYear")
    private String endYear;
    
    @XmlElement(name = "SearchType")
    private String SearchType;

	/**
	 * @return
	 */
	public Integer getCarId() {
		return carId;
	}

	/**
	 * @param carId
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	/**
	 * @return
	 */
	public String getMaker() {
		return maker;
	}

	/**
	 * @param maker
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * @return
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return
	 */
	public String getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear
	 */
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return
	 */
	public String getEndYear() {
		return endYear;
	}

	/**
	 * @param endYear
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	/**
	 * @return
	 */
	public String getSearchType() {
		return SearchType;
	}

	/**
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		SearchType = searchType;
	}
    
}
