package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;
@XmlRootElement(name = "taxSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaxSearchVO extends SearchVO implements Serializable{

    static final long serialVersionUID = 5936423095764732832L;

    @XmlElement(name = "compBizNo")
    private String compBizNo;

    @XmlElement(name = "compNm")
    private String compNm;

    /**
     * @return the compBizNo
     */
    public String getCompBizNo() {
        return compBizNo;
    }

    /**
     * @param compBizNo the compBizNo to set
     */
    public void setCompBizNo(String compBizNo) {
        this.compBizNo = compBizNo;
    }

    /**
     * @return the compNm
     */
    public String getCompNm() {
        return compNm;
    }

    /**
     * @param compNm the compNm to set
     */
    public void setCompNm(String compNm) {
        this.compNm = compNm;
    }

}
