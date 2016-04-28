package com.pama.prd.dao;

import java.util.List;

import com.pama.prd.vo.CategoryVO;

public interface CategoryDAO
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
    public int insertCategory(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 수정
     * @param categoryVO
     * @return
     */
    public int updateCategory(CategoryVO categoryVO);
    
    /**
     * @param categoryVO
     * @return
     */
    public int updateCategorySortTree(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 상태변경
     * @param categoryVO
     * @return
     */
    public int updateCategoryStatus(CategoryVO categoryVO);
    
    /**
     * 상품 카테고리 삭제
     * @param categoryVO
     * @return
     */
    public int deleteCategory(CategoryVO categoryVO);
}
