package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "WishProductsSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class WishProductsSearchVO extends SearchVO implements Serializable{

    static final long serialVersionUID = -8647929395433544405L;

    //TODO 나중에 필요 없으면 삭제

}
