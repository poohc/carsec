package com.pama.prd.dao;

import java.util.List;

import com.pama.prd.vo.ProductLicenseFormVO;
import com.pama.prd.vo.ProductLicenseVO;
import com.pama.prd.vo.ProductLicenseSearchVO;

public interface ProductLicenseDAO {

    /**
     * 상품 라이센스 리스트 건수
     * @param productLicenseSearchVO
     * @return
     */
    public int getProductLicenseListCount(ProductLicenseSearchVO productLicenseSearchVO);

    /**
     * 상품 라이센스 리스트
     * @param productLicenseSearchVO
     * @return
     */
    public List<ProductLicenseVO> getProductLicenseList(ProductLicenseSearchVO productLicenseSearchVO);


    /**
     * 상품 라이센스 가져오기
     * @param prdId
     * @return
     */
    public String getProductLicensePublish(String prdId);

    /**
     * 상품 라이센스
     * @param productLicenseSearchVO
     * @return
     */
    public ProductLicenseVO getProductLicense(ProductLicenseSearchVO productLicenseSearchVO);

    /**
     * 상품 라이센스 등록
     * @param productLicenseVO
     * @return
     */
    public int insertProductLicense(ProductLicenseVO productLicenseVO);

    /**
     * 상품 라이센스 수정
     * @param productLicenseVO
     * @return
     */
    public int updateProductLicense(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 발행
	 * @param productLicenseVO
	 * @return
	 */
	public int updateProductLicensePublish(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 상태 변경
	 * @param productLicenseVO
	 * @return
	 */
	public int updateProductLicenseStatus(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 일괄 상태 변경
	 * @param productLicenseFormVO
	 * @return
	 */
	public int updateSelectLicenseStatus(ProductLicenseFormVO productLicenseFormVO);

}
