package com.pama.zip.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zipcodeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZipcodeListVO implements Serializable {

    static final long serialVersionUID = 6579351550148207410L;

    @XmlElement(name = "zipcode")
    private List<ZipcodeVO> zipcodeList;

    /**
     * @return the zipcodeList
     */
    public List<ZipcodeVO> getZipcodeList() {
        return zipcodeList;
    }

    /**
     * @param zipcodeList the zipcodeList to set
     */
    public void setZipcodeList(List<ZipcodeVO> zipcodeList) {
        this.zipcodeList = zipcodeList;
    }

}
