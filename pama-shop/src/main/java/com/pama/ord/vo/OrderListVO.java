package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orderList")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderListVO implements Serializable
{

    static final long serialVersionUID = 4996005517669663974L;

    @XmlElement(name = "order")
    private List<OrderVO> orderList;

    private OrderSearchVO orderSearchVO;

    /**
     * @return the orderList
     */
    public List<OrderVO> getOrderList() {
        return orderList;
    }

    /**
     * @param orderList the orderList to set
     */
    public void setOrderList(List<OrderVO> orderList) {
        this.orderList = orderList;
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