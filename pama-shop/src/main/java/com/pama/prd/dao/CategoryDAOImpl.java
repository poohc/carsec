package com.pama.prd.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prd.vo.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO
{
    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(CategoryDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prd.dao.CategoryDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* 상품 카테고리 리스트 건수
     * @see com.pama.prd.dao.CategoryDAO#getCategoryListCount(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int getCategoryListCount(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCatego	ryListCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getCategoryListCount"),categoryVO);
    }

    /* 상품 카테고리 리스트
     * @see com.pama.prd.dao.CategoryDAO#getCategoryList(com.pama.prd.vo.CategoryVO)
     */
    @Override
	public List<CategoryVO> getCategoryList(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCategoryList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getCategoryList"), categoryVO);
    }

    /* 상품 카테고리 상세
     * @see com.pama.prd.dao.CategoryDAO#getCategory(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public CategoryVO getCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getCategory' method...");
        }
        return (CategoryVO) sqlSessionTemplate.selectOne(getSqlId("getCategory"), categoryVO);
    }

    /* 상품 카테고리 등록
     * @see com.pama.prd.dao.CategoryDAO#insertCategory(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int insertCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertCategory' method...");
        }
        return (Integer) sqlSessionTemplate.insert(getSqlId("insertCategory"), categoryVO);
    }

    /* 상품 카테고리 수정
     * @see com.pama.prd.dao.CategoryDAO#updateCategory(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int updateCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateCategory' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateCategory"), categoryVO);
    }
    
    /* (non-Javadoc)
     * @see com.pama.prd.dao.CategoryDAO#updateCategorySortTree(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int updateCategorySortTree(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateCategorySortTree' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateCategorySortTree"), categoryVO);
    }

    /* 상품 카테고리 상태변경
     * @see com.pama.prd.dao.CategoryDAO#updateCategoryStatus(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int updateCategoryStatus(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateCategoryStatus' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateCategoryStatus"), categoryVO);
    }

    /* 상품 카테고리 삭제
     * @see com.pama.prd.dao.CategoryDAO#deleteCategory(com.pama.prd.vo.CategoryVO)
     */
    @Override
    public int deleteCategory(CategoryVO categoryVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteCategory' method...");
        }
        return sqlSessionTemplate.update(getSqlId("deleteCategory"), categoryVO);
    }

    /**
     * SqlMap Namespace를 생성한다.
     * @param methodName
     * @return
     */
    private String getSqlId(String methodName) {
        return SQLMAP_NAMESPACE + "." + methodName;
    }
}
