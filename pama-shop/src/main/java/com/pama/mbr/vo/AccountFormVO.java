package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accountForm")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountFormVO implements Serializable{

    static final long serialVersionUID = -71778248436478630L;

    /**
     * 회원 ID
     */
    @XmlElement(name = "mbrId")
    private String mbrId;

    /**
     * 회원 탈퇴 사유
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * mode
     */
    @XmlElement(name = "mode")
    private String mode;

    /**
     * 비밀번호
     */
    @XmlElement(name = "pwd")
    private String pwd;

    /**
     * 비밀번호 변경시 변경할 비밀번호
     */
    @XmlElement(name = "modifyPwd")
    private String modifyPwd;

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
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

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
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the modifyPwd
     */
    public String getModifyPwd() {
        return modifyPwd;
    }

    /**
     * @param modifyPwd the modifyPwd to set
     */
    public void setModifyPwd(String modifyPwd) {
        this.modifyPwd = modifyPwd;
    }

}
