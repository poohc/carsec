package com.pama.prd.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productAllList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductListVO implements Serializable
{
    /**
     * UID
     */
    private static final long serialVersionUID = -980941447086082242L;

    /**
     * 상품 리스트
     */
    @XmlElement(name = "productList")
    private List<ProductVO> productList;

    /**
     * 상품 검색 조건
     */
    private ProductSearchVO productSearchVO;

    /**
     * @return
     */
    public List<ProductVO> getProductList() {
        return productList;
    }

    /**
     * @param productList
     */
    public void setProductList(List<ProductVO> productList) {
        this.productList = productList;
    }

    /**
     * @return
     */
    public ProductSearchVO getProductSearchVO() {
        return productSearchVO;
    }

    /**
     * @param productSearchVO
     */
    public void setProductSearchVO(ProductSearchVO productSearchVO) {
        this.productSearchVO = productSearchVO;
    }



}
