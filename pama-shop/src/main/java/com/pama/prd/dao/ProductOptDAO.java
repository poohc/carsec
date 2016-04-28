package com.pama.prd.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prd.vo.ProductOptVO;

@Repository
public class ProductOptDAO {
    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductOptDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prd.dao.ProductOptDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	public List<ProductOptVO> getProductOptList(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOptList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductOptList"), productOptVO);
    }

    public ProductOptVO getProductOpt(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOpt' method...");
        }
        return (ProductOptVO) sqlSessionTemplate.selectOne(getSqlId("getProductOpt"), productOptVO);
    }

    public int insertProductOpt(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductOpt' method...");
        }
        return (Integer) sqlSessionTemplate.insert(getSqlId("insertProductOpt"), productOptVO);
    }

    public int updateProductOpt(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductOpt' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductOpt"), productOptVO);
    }

    public int updateProductOptStatus(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductOptStatus' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductOptStatus"), productOptVO);
    }

    public int deleteProductOpt(ProductOptVO productOptVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteProductOpt' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("deleteProductOpt"), productOptVO);
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
