package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productsOptList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsOptListVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8204177162563164293L;
	
    @XmlElement(name = "productsOptList")
    private List<ProductsOptVO> productsOptList;

    private OrderSearchVO orderSearchVO;

	public List<ProductsOptVO> getProductsOptList() {
		return productsOptList;
	}

	public void setProductsOptList(List<ProductsOptVO> productsOptList) {
		this.productsOptList = productsOptList;
	}

	public OrderSearchVO getOrderSearchVO() {
		return orderSearchVO;
	}

	public void setOrderSearchVO(OrderSearchVO orderSearchVO) {
		this.orderSearchVO = orderSearchVO;
	}

}
