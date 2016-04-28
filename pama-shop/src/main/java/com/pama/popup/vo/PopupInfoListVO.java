package com.pama.popup.vo;

import java.util.List;


public class PopupInfoListVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -556975833278513739L;

	private List<PopupInfoVO> popupInfoVOs;
	
	private PopupSearchVO popupSearchVO;

	/**
	 * @return the popupInfoVOs
	 */
	public List<PopupInfoVO> getPopupInfoVOs() {
		return popupInfoVOs;
	}

	/**
	 * @param popupInfoVOs the popupInfoVOs to set
	 */
	public void setPopupInfoVOs(List<PopupInfoVO> popupInfoVOs) {
		this.popupInfoVOs = popupInfoVOs;
	}

	/**
	 * @return the popupSearchVO
	 */
	public PopupSearchVO getPopupSearchVO() {
		return popupSearchVO;
	}

	/**
	 * @param popupSearchVO the popupSearchVO to set
	 */
	public void setPopupSearchVO(PopupSearchVO popupSearchVO) {
		this.popupSearchVO = popupSearchVO;
	}
	
	
}
