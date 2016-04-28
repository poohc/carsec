package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginFormVO implements Serializable{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5193158563445878150L;

    /**
     * 회원 ID
     */
    @XmlElement(name = "loginId")
    private String loginId;

    /**
     * 비밀번호
     */
    @XmlElement(name = "pwd")
    private String pwd;

    /**
     * mode
     */
    @XmlElement(name = "mode")
    private String mode;

    /**
     * returnURL
     */
    @XmlElement(name = "returnURL")
    private String returnURL;

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
     * @return the returnURL
     */
    public String getReturnURL() {
        return returnURL;
    }

    /**
     * @param returnURL the returnURL to set
     */
    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }


}
