package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;
@XmlRootElement(name = "accountSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountSearchVO extends SearchVO implements Serializable{

    static final long serialVersionUID = 8911453255105256427L;

    /**
     * 회원 ID
     */
    @XmlElement(name = "mbrId")
    private String mbrId;

    /**
     * 회원 레벨
     */
    @XmlElement(name = "level")
    private String level;

    /**
     * 회원 레벨
     */
    @XmlElement(name = "levels")
    private String[] levels;

    /**
     * 회원 상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

	/**
     * 정보원 승인여부 0:대기, 1:승인
     */
    @XmlElement(name = "infoApproval")
    private String infoApproval;

    /**
     * 마지막 로그인 날짜 (시작)
     */
    @XmlElement(name = "startLoginDate")
    private String startLoginDate;

    /**
     * 마지막 로그인 날짜 (끝)
     */
    @XmlElement(name = "endLoginDate")
    private String endLoginDate;

    /**
     * 회원 가입 날짜 (시작)
     */
    @XmlElement(name = "startRegisterDate")
    private String startRegisterDate;

    /**
     * 회원 가입 날짜 (끝)
     */
    @XmlElement(name = "endRegisterDate")
    private String endRegisterDate;

    /**
	 * @return the mbrId
	 */
	public String getMbrId() {
		return mbrId;
	}

	/**
	 * @param mbrId the mbrId to set
	 */
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	/**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return
     */
    public String[] getLevels() {
		return levels;
	}

	/**
	 * @param levels
	 */
	public void setLevels(String[] levels) {
		this.levels = levels;
	}

	/**
	 * @return
	 */
	public String getStatusType() {
		return statusType;
	}

	/**
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	/**
     * @return
     */
    public String getInfoApproval() {
		return infoApproval;
	}

	/**
	 * @param infoApproval
	 */
	public void setInfoApproval(String infoApproval) {
		this.infoApproval = infoApproval;
	}

	/**
     * @return the startLoginDate
     */
    public String getStartLoginDate() {
        return startLoginDate;
    }

    /**
     * @param startLoginDate the startLoginDate to set
     */
    public void setStartLoginDate(String startLoginDate) {
        this.startLoginDate = startLoginDate;
    }

    /**
     * @return the endLoginDate
     */
    public String getEndLoginDate() {
        return endLoginDate;
    }

    /**
     * @param endLoginDate the endLoginDate to set
     */
    public void setEndLoginDate(String endLoginDate) {
        this.endLoginDate = endLoginDate;
    }

    /**
     * @return the startRegisterDate
     */
    public String getStartRegisterDate() {
        return startRegisterDate;
    }

    /**
     * @param startRegisterDate the startRegisterDate to set
     */
    public void setStartRegisterDate(String startRegisterDate) {
        this.startRegisterDate = startRegisterDate;
    }

    /**
     * @return the endRegisterDate
     */
    public String getEndRegisterDate() {
        return endRegisterDate;
    }

    /**
     * @param endRegisterDate the endRegisterDate to set
     */
    public void setEndRegisterDate(String endRegisterDate) {
        this.endRegisterDate = endRegisterDate;
    }

}
