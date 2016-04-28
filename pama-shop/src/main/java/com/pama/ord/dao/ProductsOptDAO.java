package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.ProductsOptVO;

@Repository
public class ProductsOptDAO {
	
    private static final Log LOG = LogFactory.getLog(ProductsDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.ProductsOptDAO";
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public List<ProductsOptVO> getProductsOptList(ProductsOptVO productsOptVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getProductsOptList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductsOptList"),productsOptVO);
    }
    
    public int insertProductsOpt(ProductsOptVO productsOptVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertProductsOpt' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertProductsOpt"), productsOptVO);
    }
    
    /**
     * @param methodName
     * @return
     */
    private String getSqlId(String methodName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SQLMAP_NAMESPACE);
        stringBuilder.append(".");
        stringBuilder.append(methodName);
        return stringBuilder.toString();
    }

}
