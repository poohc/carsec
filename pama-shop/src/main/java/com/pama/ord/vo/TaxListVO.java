package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "taxList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaxListVO implements Serializable
{

    static final long serialVersionUID = 29014122515330420L;

    @XmlElement(name = "tax")
    private List<TaxVO> taxList;

    private TaxSearchVO taxSearchVO;

    /**
     * @return the taxList
     */
    public List<TaxVO> getTaxList() {
        return taxList;
    }

    /**
     * @param taxList the taxList to set
     */
    public void setTaxList(List<TaxVO> taxList) {
        this.taxList = taxList;
    }

    /**
     * @return the taxSearchVO
     */
    public TaxSearchVO getTaxSearchVO() {
        return taxSearchVO;
    }

    /**
     * @param taxSearchVO the taxSearchVO to set
     */
    public void setTaxSearchVO(TaxSearchVO taxSearchVO) {
        this.taxSearchVO = taxSearchVO;
    }


}