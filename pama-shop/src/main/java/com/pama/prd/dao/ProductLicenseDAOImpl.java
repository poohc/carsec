package com.pama.prd.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prd.vo.ProductLicenseFormVO;
import com.pama.prd.vo.ProductLicenseSearchVO;
import com.pama.prd.vo.ProductLicenseVO;

@Repository
public class ProductLicenseDAOImpl implements ProductLicenseDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductLicenseDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prd.dao.ProductLicenseDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#getProductLicenseListCount(com.pama.prd.vo.ProductLicenseSearchVO)
	 */
	@Override
	public int getProductLicenseListCount(
			ProductLicenseSearchVO productLicenseSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicenseListCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getProductLicenseListCount"),productLicenseSearchVO);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#getProductLicenseList(com.pama.prd.vo.ProductLicenseSearchVO)
	 */
	@Override
	public List<ProductLicenseVO> getProductLicenseList(
			ProductLicenseSearchVO productLicenseSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicenseList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductLicenseList"), productLicenseSearchVO);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#getProductLicense(com.pama.prd.vo.ProductLicenseSearchVO)
	 */
	@Override
	public ProductLicenseVO getProductLicense(
			ProductLicenseSearchVO productLicenseSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicense' method...");
        }
        return (ProductLicenseVO)sqlSessionTemplate.selectOne(getSqlId("getProductLicense"), productLicenseSearchVO);
	}


	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#getProductLicensePublish(java.lang.String)
	 */
	@Override
	public String getProductLicensePublish(String prdId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicensePublish' method...");
        }
        return (String) sqlSessionTemplate.selectOne(getSqlId("getProductLicensePublish"), prdId);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#insertProductLicense(com.pama.prd.vo.ProductLicenseVO)
	 */
	@Override
	public int insertProductLicense(ProductLicenseVO productLicenseVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductLicense' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertProductLicense"), productLicenseVO);
        return 1;
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#updateProductLicense(com.pama.prd.vo.ProductLicenseVO)
	 */
	@Override
	public int updateProductLicense(ProductLicenseVO productLicenseVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductLicense' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductLicense"), productLicenseVO);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#updateProductLicensePublish(com.pama.prd.vo.ProductLicenseVO)
	 */
	@Override
	public int updateProductLicensePublish(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductLicensePublish' method...");
        }
		return (Integer) sqlSessionTemplate.update(getSqlId("updateProductLicensePublish"), productLicenseVO);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#updateProductLicenseStatus(com.pama.prd.vo.ProductLicenseVO)
	 */
	@Override
	public int updateProductLicenseStatus(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductLicenseStatus' method...");
        }
		return (Integer) sqlSessionTemplate.update(getSqlId("updateProductLicenseStatus"), productLicenseVO);
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.dao.ProductLicenseDAO#updateSelectLicenseStatus(com.pama.prd.vo.ProductLicenseFormVO)
	 */
	@Override
	public int updateSelectLicenseStatus(ProductLicenseFormVO productLicenseFormVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateSelectLicenseStatus' method...");
        }
		return (Integer) sqlSessionTemplate.update(getSqlId("updateSelectLicenseStatus"), productLicenseFormVO);
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
