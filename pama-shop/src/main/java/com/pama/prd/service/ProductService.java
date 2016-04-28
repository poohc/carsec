package com.pama.prd.service;

import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductOptVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;

public interface ProductService
{

	/**
	 * 상품 정보 리스트
	 * @param productSearchVO
	 * @return
	 */
	public ProductListVO getProductList(ProductSearchVO productSearchVO);

	/**
	 * 인기 상품 기본 정보 리스트
	 * @param productSearchVO
	 * @return
	 */
	public ProductListVO getBestProductList(ProductSearchVO productSearchVO);

	/**
	 * 카테고리별 상품 리스트
	 * @param productSearchVO
	 * @return
	 */
	public ProductListVO getProductCategoryList(ProductSearchVO productSearchVO);

	/**
	 * 카테고리별 미사용중인 라이센스 상품 리스트
	 * @param productSearchVO
	 * @return
	 */
	public ProductListVO getProductOnList(ProductSearchVO productSearchVO);

	/**
	 * 상품 상세 정보
	 * @param productVO
	 * @return
	 */
	public ProductVO getProduct(ProductSearchVO productSearchVO);

	/**
	 * 상품 엑셀출력리스트
	 * @param productVO
	 * @return
	 */
	public ProductListVO getProductExcelList(ProductSearchVO productSearchVO);

	/**
	 * 상품 등록
	 * @param productVO
	 * @return
	 */
	public int addProduct(ProductVO productVO);

	/**
	 * 상품 수정
	 * @param productVO
	 * @return
	 */
	public int modifyProduct(ProductVO productVO);

	/**
	 * 상품 상태변경(상품판매종료)
	 * @param productVO
	 * @return
	 */
	public int modifyProductStatus(ProductVO productVO);

	/**
	 * 상품 삭제
	 * @param productVO
	 * @return
	 */
	public int removeProduct(ProductVO productVO);

	/**
	 * @param productOptVO
	 * @return
	 */
	public int modifyProductOptStatus(ProductOptVO productOptVO);


}
