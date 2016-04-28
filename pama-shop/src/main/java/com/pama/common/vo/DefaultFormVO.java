package com.pama.common.vo;

import java.io.Serializable;

public class DefaultFormVO implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = -6931809697304117609L;

	/**
     * mode 처리결과 코드
     */
    private String mode;

    /**
     * act 프로세서 처리코드
     */
    private String act;

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the act
	 */
	public String getAct() {
		return act;
	}

	/**
	 * @param act the act to set
	 */
	public void setAct(String act) {
		this.act = act;
	}


}
