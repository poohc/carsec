package com.pama.prd.service;

import java.util.List;

import com.pama.prd.vo.CategoryVO;

public interface CategoryService
{
	
	/**
	 * 상품 카테고리 리스트 건수
	 * @param categoryVO
	 * @return
	 */
	public int getCategoryListCount(CategoryVO categoryVO);
	
    /**
     * 상품 카테고리 리스트
     * @param categoryVO
     * @return
     */
    public List<CategoryVO> getCategoryList(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 상세
     * @param categoryVO
     * @return
     */
    public CategoryVO getCategory(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 등록
     * @param categoryVO
     * @return
     */
    public int addCategory(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 수정
     * @param categoryVO
     * @return
     */
    public int modifyCategory(CategoryVO categoryVO);
    
    /**
     * @param categoryVO
     * @return
     */
    public int modifyCategorySortTree(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 상태변경
     * @param categoryVO
     * @return
     */
    public int modifyCategoryStatus(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 삭제
     * @param categoryVO
     * @return
     */
    public int removeCategory(CategoryVO categoryVO);
    
}
