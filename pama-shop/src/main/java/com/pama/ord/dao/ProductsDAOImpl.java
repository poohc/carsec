package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsVO;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    private static final Log LOG = LogFactory.getLog(ProductsDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.ProductsDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#getProductsList(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public List<ProductsVO> getProductsList(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductsList"),productsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#getLicenseListTotalCount(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public int getLicenseListTotalCount(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getLicenseListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getLicenseListTotalCount"),productsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#getProductsLicenseList(com.pama.ord.vo.ProductsVO)
     */
    @Override
	public List<ProductsVO> getProductsLicenseList(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getProductsLicenseList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getProductsLicenseList"),productsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#getProductsLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public ProductsVO getProductsLicense(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getProductsLicense' method...");
        }
        return (ProductsVO)sqlSessionTemplate.selectOne(getSqlId("getProductsLicense"),productsVO);
    }
    
    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#getLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public ProductsVO getLicense(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getLicense' method...");
        }
        return (ProductsVO)sqlSessionTemplate.selectOne(getSqlId("getLicense"),productsVO);
    }  

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#insertProduct(com.pama.ord.vo.OrderVO)
     */
    @Override
    public int insertProduct(OrderVO orderVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertproduct' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertProduct"), orderVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#insertProducts(com.pama.ord.vo.OrderVO)
     */
    @Override
    public int insertProducts(OrderVO orderVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertproducts' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertProducts"), orderVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#updateProductsLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public int updateProductsLicense(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateProductsLicense' method...");
        }
        int rows = sqlSessionTemplate.update(getSqlId("updateProductsLicense"), productsVO);

        return rows;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.ProductsDAO#removeProducts(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public int removeProducts(ProductsVO productsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'removeProducts' method...");
        }
        int rows = sqlSessionTemplate.update(getSqlId("removeProducts"), productsVO);

        return rows;
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
