package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WishProductsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class WishProductsListVO implements Serializable{

    static final long serialVersionUID = -1688764639327723949L;

    @XmlElement(name = "wishProducts")
    private List<WishProductsVO> wishProductsList;

    //private WishProductsSearchVO wishProductsSearchVO; 나중에 필요하면 사용

    /**
     * @return the wishProductsList
     */
    public List<WishProductsVO> getWishProductsList() {
        return wishProductsList;
    }

    /**
     * @param wishProductsList the wishProductsList to set
     */
    public void setWishProductsList(List<WishProductsVO> wishProductsList) {
        this.wishProductsList = wishProductsList;
    }

}
