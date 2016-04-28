package com.pama.ord.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.common.vo.SearchVO;

@XmlRootElement(name = "CartProductsSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class CartProductsSearchVO extends SearchVO implements Serializable{

	private static final long serialVersionUID = -1698893343276987133L;

    //TODO 나중에 필요 없으면 삭제

}
