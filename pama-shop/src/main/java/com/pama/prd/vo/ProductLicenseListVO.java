package com.pama.prd.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productAllLicenseList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductLicenseListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3075855615441087291L;

    /**
     * 상품 라이센스 리스트
     */
    @XmlElement(name = "productLicenseList")
    private List<ProductLicenseVO> productLicenseList;

    /**
     * 상품 라이센스 검색 조건
     */
    private ProductLicenseSearchVO productLicenseSearchVO;

	/**
	 * @return the productLicenseList
	 */
	public List<ProductLicenseVO> getProductLicenseList() {
		return productLicenseList;
	}

	/**
	 * @param productLicenseList the productLicenseList to set
	 */
	public void setProductLicenseList(List<ProductLicenseVO> productLicenseList) {
		this.productLicenseList = productLicenseList;
	}

	/**
	 * @return the productLicenseSearchVO
	 */
	public ProductLicenseSearchVO getProductLicenseSearchVO() {
		return productLicenseSearchVO;
	}

	/**
	 * @param productLicenseSearchVO the productLicenseSearchVO to set
	 */
	public void setProductLicenseSearchVO(
			ProductLicenseSearchVO productLicenseSearchVO) {
		this.productLicenseSearchVO = productLicenseSearchVO;
	}

}
