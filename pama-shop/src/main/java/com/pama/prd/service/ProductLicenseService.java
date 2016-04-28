package com.pama.prd.service;

import com.pama.prd.vo.ProductLicenseListVO;
import com.pama.prd.vo.ProductLicenseSearchVO;
import com.pama.prd.vo.ProductLicenseVO;
import com.pama.prd.vo.ProductLicenseFormVO;

public interface ProductLicenseService {

	/**
	 * 상품 라이센스 리스트
	 * @param productSearchVO
	 * @return
	 */
	public ProductLicenseListVO getProductLicenseList(ProductLicenseSearchVO productLicenseSearchVO);

	/**
	 * 상품 라이센스 정보
	 * @param productVO
	 * @return
	 */
	public ProductLicenseVO getProductLicense(ProductLicenseSearchVO productLicenseSearchVO);

	/**
	 * 상품 라이센스 코드 가져오기
	 * @param productLicenseSearchVO
	 * @return
	 */
	public String getProductLicensePublish(String prdId);

	/**
	 * 상품 라이센스 등록
	 * @param productVO
	 * @return
	 */
	public int addProductLicense(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 수정
	 * @param productLicenseVO
	 * @return
	 */
	public int modifyProductLicense(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 발행
	 * @param productLicenseVO
	 * @return
	 */
	public int modifyProductLicensePublish(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 상태변경
	 * @param productLicenseVO
	 * @return
	 */
	public int modifyProductLicenseStatus(ProductLicenseVO productLicenseVO);

	/**
	 * 상품 라이센스 일괄삭제
	 * @param productLicenseFormVO
	 * @return
	 */
	public int removeSelectLicense(ProductLicenseFormVO productLicenseFormVO);

}
