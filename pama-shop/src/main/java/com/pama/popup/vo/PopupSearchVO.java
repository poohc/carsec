package com.pama.popup.vo;

import com.pama.common.vo.SearchVO;


public class PopupSearchVO extends SearchVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3180341924865494905L;
	private String popupId;

	/**
	 * @return the popupId
	 */
	public String getPopupId() {
		return popupId;
	}

	/**
	 * @param popupId the popupId to set
	 */
	public void setPopupId(String popupId) {
		this.popupId = popupId;
	}
	
	
}
