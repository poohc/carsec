package com.pama.zip.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zipcode")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZipcodeVO implements Serializable{

    static final long serialVersionUID = -336018970319968313L;

    @XmlElement(name = "seq")
    private int seq;

    @XmlElement(name = "zipcode")
    private String zipcode;

    @XmlElement(name = "sido")
    private String sido;

    @XmlElement(name = "gugun")
    private String gugun;

    @XmlElement(name = "dong")
    private String dong;

    @XmlElement(name = "ri")
    private String ri;

    @XmlElement(name = "bunji")
    private String bunji;
    
    @XmlElement(name = "SearchType")
    private String SearchType;

    /**
     * @return the seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the sido
     */
    public String getSido() {
        return sido;
    }

    /**
     * @param sido the sido to set
     */
    public void setSido(String sido) {
        this.sido = sido;
    }

    /**
     * @return the gugun
     */
    public String getGugun() {
        return gugun;
    }

    /**
     * @param gugun the gugun to set
     */
    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    /**
     * @return the dong
     */
    public String getDong() {
        return dong;
    }

    /**
     * @param dong the dong to set
     */
    public void setDong(String dong) {
        this.dong = dong;
    }

    /**
     * @return the ri
     */
    public String getRi() {
        return ri;
    }

    /**
     * @param ri the ri to set
     */
    public void setRi(String ri) {
        this.ri = ri;
    }

    /**
     * @return the bunji
     */
    public String getBunji() {
        return bunji;
    }

    /**
     * @param bunji the bunji to set
     */
    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

	public String getSearchType() {
		return SearchType;
	}

	public void setSearchType(String searchType) {
		SearchType = searchType;
	}

}
