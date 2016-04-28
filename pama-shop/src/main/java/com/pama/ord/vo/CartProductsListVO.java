package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CartProductsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CartProductsListVO implements Serializable{

    static final long serialVersionUID = -5715432935881415146L;

    @XmlElement(name = "cartProductsList")
    private List<CartProductsVO> cartProductsList;

    /**
     * 주문 total 가격
     */
    @XmlElement(name = "totalPrice")
    private int totalPrice;

    /**
     * 주문 결제 가격
     */
    @XmlElement(name = "settlePrice")
    private int settlePrice;

    /**
     * 배송비
     */
    @XmlElement(name = "deliveryPrice")
    private int deliveryPrice;


    /**
     * @return the cartProductsList
     */
    public List<CartProductsVO> getCartProductsList() {
        return cartProductsList;
    }

    /**
     * @param cartProductsList the cartProductsList to set
     */
    public void setCartProductsList(List<CartProductsVO> cartProductsList) {
        this.cartProductsList = cartProductsList;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the settlePrice
     */
    public int getSettlePrice() {
        return settlePrice;
    }

    /**
     * @param settlePrice the settlePrice to set
     */
    public void setSettlePrice(int settlePrice) {
        this.settlePrice = settlePrice;
    }

    /**
     * @return the deliveryPrice
     */
    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * @param deliveryPrice the deliveryPrice to set
     */
    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

}
