package com.pama.prd.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.prd.dao.CategoryDAO;
import com.pama.prd.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService
{
    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(CategoryService.class);

    /**
     * CategoryBiz 객체 정의.
     */
    @Autowired
    private CategoryDAO categoryDAO;

    /* 상품 카테고리 리스트 건수
     * @see com.pama.prd.service.CategoryService#getCategoryListCount(com.pama.prd.vo.CategoryVO)
     */
    public int getCategoryListCount(CategoryVO categoryVO){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCategoryListCount' method...");
        }
        return categoryDAO.getCategoryListCount(categoryVO);
    }

    /* 상품 카테고리 리스트
     * @see com.pama.prd.service.CategoryService#getCategoryList(com.pama.prd.vo.CategoryVO)
     */
    public List<CategoryVO> getCategoryList(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCategoryList' method...");
        }
        return categoryDAO.getCategoryList(categoryVO);
    }

    /* 상품 카테고리 상세
     * @see com.pama.prd.service.CategoryService#getCategory(com.pama.prd.vo.CategoryVO)
     */
    public CategoryVO getCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCategory' method...");
        }
        return categoryDAO.getCategory(categoryVO);
    }

    /* 상품 카테고리 등록
     * @see com.pama.prd.service.CategoryService#addCategory(com.pama.prd.vo.CategoryVO)
     */
    public int addCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addCategory' method...");
        }
        return categoryDAO.insertCategory(categoryVO);
    }

    /* 상품 카테고리 수정
     * @see com.pama.prd.service.CategoryService#modifyCategory(com.pama.prd.vo.CategoryVO)
     */
    public int modifyCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyCategory' method...");
        }
        return categoryDAO.updateCategory(categoryVO);
    }

    public int modifyCategorySortTree(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyCategorySortTree' method...");
        }
        return categoryDAO.updateCategorySortTree(categoryVO);
    }
    
    /* 상품 카테고리 상태변경
     * @see com.pama.prd.service.CategoryService#modifyCategoryStatus(com.pama.prd.vo.CategoryVO)
     */
    public int modifyCategoryStatus(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyCategoryStatus' method...");
        }
        return categoryDAO.updateCategoryStatus(categoryVO);
    }

    /* 상품 카테고리 삭제
     * @see com.pama.prd.service.CategoryService#removeCategory(com.pama.prd.vo.CategoryVO)
     */
    public int removeCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeCategory' method...");
        }
        return categoryDAO.deleteCategory(categoryVO);
    }
}
