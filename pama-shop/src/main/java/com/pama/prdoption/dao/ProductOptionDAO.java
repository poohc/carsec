package com.pama.prdoption.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prdoption.vo.ProductOptionSearchVO;
import com.pama.prdoption.vo.ProductOptionVO;

@Repository
public class ProductOptionDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductOptionDAO.class);
    
    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prdoption.dao.ProductOptionDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
	public int getProductOptionListCount(ProductOptionSearchVO productOptionSearchVO){
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getProductOptionListCount' method...");
		}
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getProductOptionListCount"), productOptionSearchVO);
	}    
	
    public List<ProductOptionVO> getProductOptionList(ProductOptionSearchVO productOptionSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOptionList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getProductOptionList"), productOptionSearchVO);
	}
	
    public ProductOptionVO getProductOption(ProductOptionSearchVO productOptionSearchVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOption' method...");
        }
        return (ProductOptionVO)sqlSessionTemplate.selectOne(getSqlId("getProductOption"), productOptionSearchVO);
    }
    
	public int insertProductOption(ProductOptionVO productOptionVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertProductOption' method...");
        }
        return (Integer) sqlSessionTemplate.insert(getSqlId("insertProductOption"), productOptionVO);
	}
	
    public int updateProductOption(ProductOptionVO productOptionVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductOption' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateProductOption"), productOptionVO);
    }
    
	public int updateProductOptionStatus(ProductOptionVO productOptionVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateProductOptionStatus' method...");
        }
		return (Integer) sqlSessionTemplate.update(getSqlId("updateProductOptionStatus"), productOptionVO);
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
