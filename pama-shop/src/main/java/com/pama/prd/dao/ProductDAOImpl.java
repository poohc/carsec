package com.pama.prd.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prd.vo.ProductAttachementVO;
import com.pama.prd.vo.ProductContentsVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO
{
    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prd.dao.ProductDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* 상품 기본 정보 리스트 건수
     * @see com.pama.prd.dao.ProductDAO#getProductInfoListCount(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
    public int getProductInfoListCount(ProductSearchVO productSearchVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductInfoListCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getProductInfoListCount"),productSearchVO);
    }

    /* 상품 기본 정보
     * @see com.pama.prd.dao.ProductDAO#getProductInfo(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
    public ProductVO getProductInfo(ProductSearchVO productSearchVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductInfo' method...");
        }
        return (ProductVO)sqlSessionTemplate.selectOne(getSqlId("getProductInfo"), productSearchVO);
    }

    /* 상품 기본 정보 리스트
     * @see com.pama.prd.dao.ProductDAO#getProductInfoList(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
    public List<ProductVO> getProductInfoList(ProductSearchVO productSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductInfoList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getProductInfoList"), productSearchVO);
	}

    /* 인기 상품 기본 정보 리스트 건수
     * @see com.pama.prd.dao.ProductDAO#getBestProductInfoListCount(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
    public int getBestProductInfoListCount(ProductSearchVO productSearchVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBestProductInfoListCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getBestProductInfoListCount"),productSearchVO);
    }

    /* 인기 상품 기본 정보 리스트
     * @see com.pama.prd.dao.ProductDAO#getBestProductInfoList(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
    public List<ProductVO> getBestProductInfoList(ProductSearchVO productSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBestProductInfoList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBestProductInfoList"), productSearchVO);
	}

    /* (non-Javadoc)
     * @see com.pama.prd.dao.ProductDAO#getProductCategoryList(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
	public List<ProductVO> getProductCategoryList(ProductSearchVO productSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductCategoryList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getProductCategoryList"), productSearchVO);
    }

    /* (non-Javadoc)
     * @see com.pama.prd.dao.ProductDAO#getProductOnList(com.pama.prd.vo.ProductSearchVO)
     */
    @Override
	public List<ProductVO> getProductOnList(ProductSearchVO productSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOnList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getProductOnList"), productSearchVO);
    }

    /* 상품 내용 리스트
     * @see com.pama.prd.dao.ProductDAO#getProductContentsList(com.pama.prd.vo.ProductVO)
     */
    @Override
    public List<ProductContentsVO> getProductContentsList(ProductVO productVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductContentsList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductContentsList"), productVO);
    }

    /* 상품 파일 리스트
     * @see com.pama.prd.dao.ProductDAO#getProductAttachementList(com.pama.prd.vo.ProductVO)
     */
    @Override
    public List<ProductAttachementVO> getProductAttachementList(ProductVO productVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductAttachementList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductAttachementList"), productVO);
    }

	/* 상품 기본 정보 등록
	 * @see com.pama.prd.dao.ProductDAO#insertProductInfo(com.pama.prd.vo.ProductVO)
	 */
    @Override
	public int insertProductInfo(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductInfo' method...");
        }
        return (Integer) sqlSessionTemplate.insert(getSqlId("insertProductInfo"), productVO);
	}

	/* 상품내용 정보 등록
	 * @see com.pama.prd.dao.ProductDAO#insertProductContents(com.pama.prd.vo.ProductContentsVO)
	 */
    @Override
	public int insertProductContents(ProductContentsVO productContentsVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductContents' method...");
        }
		sqlSessionTemplate.insert(getSqlId("insertProductContents"), productContentsVO);
        return 1;
	}

	/* 상품 파일 정보 등록
	 * @see com.pama.prd.dao.ProductDAO#insertProductAttachement(com.pama.prd.vo.ProductAttachementVO)
	 */
    @Override
	public int insertProductAttachement(ProductAttachementVO productAttachementVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductAttachement' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertProductAttachement"), productAttachementVO);
        return 1;
    }

    /* 상품 기본 정보 수정
     * @see com.pama.prd.dao.ProductDAO#updateProductInfo(com.pama.prd.vo.ProductVO)
     */
    @Override
    public int updateProductInfo(ProductVO productVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductInfo' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductInfo"), productVO);
    }

    /* 상품내용 정보 수정
     * @see com.pama.prd.dao.ProductDAO#updateProductContents(com.pama.prd.vo.ProductContentsVO)
     */
    @Override
    public int updateProductContents(ProductContentsVO productContentsVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductContents' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductContents"), productContentsVO);
    }

    /* 상품 파일 정보 수정
     * @see com.pama.prd.dao.ProductDAO#updateProductAttachement(com.pama.prd.vo.ProductAttachementVO)
     */
    @Override
    public int updateProductAttachement(ProductAttachementVO productAttachementVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductAttachement' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductAttachement"), productAttachementVO);
    }

	/* 상품 상태변경(상품판매종료)
	 * @see com.pama.prd.dao.ProductDAO#updateProductStatus(com.pama.prd.vo.ProductVO)
	 */
    @Override
	public int updateProductStatus(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductStatus' method...");
        }
		return (Integer) sqlSessionTemplate.update(getSqlId("updateProductStatus"), productVO);
	}

    /* 상품 기본 정보 삭제
     * @see com.pama.prd.dao.ProductDAO#deleteProductInfo(com.pama.prd.vo.ProductVO)
     */
    @Override
    public int deleteProductInfo(ProductVO productVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteProductInfo' method...");
        }
        return sqlSessionTemplate.update(getSqlId("deleteProductInfo"), productVO);
    }

    /* 상품내용 정보 삭제
     * @see com.pama.prd.dao.ProductDAO#deleteProductContents(com.pama.prd.vo.ProductContentsVO)
     */
    @Override
    public int deleteProductContents(ProductContentsVO productContentsVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteProductContents' method...");
        }
        return sqlSessionTemplate.update(getSqlId("deleteProductContents"), productContentsVO);
    }

    /* 상품 파일 정보 삭제
     * @see com.pama.prd.dao.ProductDAO#deleteProductAttachement(com.pama.prd.vo.ProductAttachementVO)
     */
    @Override
    public int deleteProductAttachement(ProductAttachementVO productAttachementVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteProductAttachement' method...");
        }
        return sqlSessionTemplate.update(getSqlId("deleteProductAttachement"), productAttachementVO);
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
