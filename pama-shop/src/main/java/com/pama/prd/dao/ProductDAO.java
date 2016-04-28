package com.pama.prd.dao;

import java.util.List;

import com.pama.prd.vo.ProductAttachementVO;
import com.pama.prd.vo.ProductContentsVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;

public interface ProductDAO
{
    /**
     * 상품 기본 정보 리스트 건수
     * @param productSearchVO
     * @return
     */
    public int getProductInfoListCount(ProductSearchVO productSearchVO);

    /**
     * 상품 기본 정보
     * @param productSearchVO
     * @return
     */
    public ProductVO getProductInfo(ProductSearchVO productSearchVO);

    /**
     * 상품 기본 정보 리스트
     * @param productSearchVO
     * @return
     */
    public List<ProductVO> getProductInfoList(ProductSearchVO productSearchVO);

    /**
     * 인기 상품 기본 정보 리스트 건수
     * @param productSearchVO
     * @return
     */
    public int getBestProductInfoListCount(ProductSearchVO productSearchVO);

	/**
	 * 인기 상품 기본 정보 리스트
	 * @param productSearchVO
	 * @return
	 */
	public List<ProductVO> getBestProductInfoList(ProductSearchVO productSearchVO);

	/**
	 * 카테고리별 상품 리스트
	 * @param productSearchVO
	 * @return
	 */
	public List<ProductVO> getProductCategoryList(ProductSearchVO productSearchVO);


	/**
	 * 카테고리별 미사용중인 라이센스 상품 리스트
	 * @param productSearchVO
	 * @return
	 */
	public List<ProductVO> getProductOnList(ProductSearchVO productSearchVO);

    /**
     * 상품 내용정보 리스트
     * @param productVO
     * @return
     */
    public List<ProductContentsVO> getProductContentsList(ProductVO productVO);

    /**
     * 상품 파일 정보 리스트
     * @param productVO
     * @return
     */
    public List<ProductAttachementVO> getProductAttachementList(ProductVO productVO);

    /**
     * 상품 기본 정보 등록
     * @param productVO
     * @return
     */
    public int insertProductInfo(ProductVO productVO);

    /**
     * 상품내용 정보 등록
     * @param productContentsVO
     * @return
     */
    public int insertProductContents(ProductContentsVO productContentsVO);

    /**
     * 상품 파일 정보 등록
     * @param productAttachementVO
     * @return
     */
    public int insertProductAttachement(ProductAttachementVO productAttachementVO);

    /**
     * 상품 기본 정보 수정
     * @param productVO
     * @return
     */
    public int updateProductInfo(ProductVO productVO);

    /**
     * 상품내용 정보 수정
     * @param productContentsVO
     * @return
     */
    public int updateProductContents(ProductContentsVO productContentsVO);

    /**
     * 상품 파일 정보 수정
     * @param productAttachementVO
     * @return
     */
    public int updateProductAttachement(ProductAttachementVO productAttachementVO);

	/**
	 * 상품 상태변경(상품판매종료)
	 * @param productVO
	 * @return
	 */
	public int updateProductStatus(ProductVO productVO);

    /**
     * 상품 기본 정보 삭제
     * @param productVO
     * @return
     */
    public int deleteProductInfo(ProductVO productVO);

    /**
     * 상품내용 정보 삭제
     * @param productContentsVO
     * @return
     */
    public int deleteProductContents(ProductContentsVO productContentsVO);

    /**
     * 상품 파일 정보 삭제
     * @param productAttachementVO
     * @return
     */
    public int deleteProductAttachement(ProductAttachementVO productAttachementVO);

}
