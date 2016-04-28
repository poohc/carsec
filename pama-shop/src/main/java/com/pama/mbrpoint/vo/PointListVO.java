package com.pama.mbrpoint.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "pointList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PointListVO implements Serializable{

	private static final long serialVersionUID = 2908353590161547221L;

	private List<PointVO> pointList;

	private PointSearchVO pointSearchVO;

	/**
	 * @return the pointList
	 */
	public List<PointVO> getPointList() {
		return pointList;
	}

	/**
	 * @param pointList the pointList to set
	 */
	public void setPointList(List<PointVO> pointList) {
		this.pointList = pointList;
	}

	/**
	 * @return the pointSearchVO
	 */
	public PointSearchVO getPointSearchVO() {
		return pointSearchVO;
	}

	/**
	 * @param pointSearchVO the pointSearchVO to set
	 */
	public void setPointSearchVO(PointSearchVO pointSearchVO) {
		this.pointSearchVO = pointSearchVO;
	}


}
