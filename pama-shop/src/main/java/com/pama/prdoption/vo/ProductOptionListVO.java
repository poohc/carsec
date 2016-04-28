package com.pama.prdoption.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productOptionList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOptionListVO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9020069881676478758L;

	/**
	 * 상품 리스트
	 */
	@XmlElement(name = "productOptionList")
    private List<ProductOptionVO> productOptionList;

    /**
     * 상품 검색 조건
     */
    private ProductOptionSearchVO productOptionSearchVO;

	public List<ProductOptionVO> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<ProductOptionVO> productOptionList) {
		this.productOptionList = productOptionList;
	}

	public ProductOptionSearchVO getProductOptionSearchVO() {
		return productOptionSearchVO;
	}

	public void setProductOptionSearchVO(ProductOptionSearchVO productOptionSearchVO) {
		this.productOptionSearchVO = productOptionSearchVO;
	}

}
