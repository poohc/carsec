package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsListVO implements Serializable
{

    private static final long serialVersionUID = 6579351550148207410L;

    @XmlElement(name = "productsList")
    private List<ProductsVO> productsList;

    private OrderSearchVO orderSearchVO;

    /**
     * @return the productsList
     */
    public List<ProductsVO> getProductsList() {
        return productsList;
    }

    /**
     * @param productsList the productsList to set
     */
    public void setProductsList(List<ProductsVO> productsList) {
        this.productsList = productsList;
    }

	/**
	 * @return the orderSearchVO
	 */
	public OrderSearchVO getOrderSearchVO() {
		return orderSearchVO;
	}

	/**
	 * @param orderSearchVO the orderSearchVO to set
	 */
	public void setOrderSearchVO(OrderSearchVO orderSearchVO) {
		this.orderSearchVO = orderSearchVO;
	}

}