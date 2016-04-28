package com.pama.carcheck.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carcheck")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarCheckVO implements Serializable {

	private static final long serialVersionUID = -527822309859274002L;

	private String gcode;
	private String qcode;
	private String qcodeTitle;
	private String gcodeTitle;
	private String gcodeType;
	private int qtypeLength;
	private int qcodeLength;
	private int qcodeNextLength;
	private String qcodeFinalYN;
	/**
	 * @return the gcode
	 */
	public String getGcode() {
		return gcode;
	}
	/**
	 * @param gcode the gcode to set
	 */
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	/**
	 * @return the qcode
	 */
	public String getQcode() {
		return qcode;
	}
	/**
	 * @param qcode the qcode to set
	 */
	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	/**
	 * @return the qcodeTitle
	 */
	public String getQcodeTitle() {
		return qcodeTitle;
	}
	/**
	 * @param qcodeTitle the qcodeTitle to set
	 */
	public void setQcodeTitle(String qcodeTitle) {
		this.qcodeTitle = qcodeTitle;
	}
	/**
	 * @return the gcodeTitle
	 */
	public String getGcodeTitle() {
		return gcodeTitle;
	}
	/**
	 * @param gcodeTitle the gcodeTitle to set
	 */
	public void setGcodeTitle(String gcodeTitle) {
		this.gcodeTitle = gcodeTitle;
	}
	/**
	 * @return the gcodeType
	 */
	public String getGcodeType() {
		return gcodeType;
	}
	/**
	 * @param gcodeType the gcodeType to set
	 */
	public void setGcodeType(String gcodeType) {
		this.gcodeType = gcodeType;
	}
	/**
	 * @return the qtypeLength
	 */
	public int getQtypeLength() {
		return qtypeLength;
	}
	/**
	 * @param qtypeLength the qtypeLength to set
	 */
	public void setQtypeLength(int qtypeLength) {
		this.qtypeLength = qtypeLength;
	}
	/**
	 * @return the qcodeLength
	 */
	public int getQcodeLength() {
		return qcodeLength;
	}
	/**
	 * @param qcodeLength the qcodeLength to set
	 */
	public void setQcodeLength(int qcodeLength) {
		this.qcodeLength = qcodeLength;
	}
	/**
	 * @return the qcodeNextLength
	 */
	public int getQcodeNextLength() {
		return qcodeNextLength;
	}
	/**
	 * @param qcodeNextLength the qcodeNextLength to set
	 */
	public void setQcodeNextLength(int qcodeNextLength) {
		this.qcodeNextLength = qcodeNextLength;
	}
	/**
	 * @return the qcodeFinalYN
	 */
	public String getQcodeFinalYN() {
		return qcodeFinalYN;
	}
	/**
	 * @param qcodeFinalYN the qcodeFinalYN to set
	 */
	public void setQcodeFinalYN(String qcodeFinalYN) {
		this.qcodeFinalYN = qcodeFinalYN;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarCheckVO [gcode=" + gcode + ", qcode=" + qcode + ", qcodeTitle=" + qcodeTitle + ", gcodeTitle="
				+ gcodeTitle + ", gcodeType=" + gcodeType + ", qtypeLength=" + qtypeLength + ", qcodeLength="
				+ qcodeLength + ", qcodeNextLength=" + qcodeNextLength + ", qcodeFinalYN=" + qcodeFinalYN + "]";
	}



}
