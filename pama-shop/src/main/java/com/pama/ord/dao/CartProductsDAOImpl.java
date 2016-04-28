package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.CartProductsVO;

@Repository
public class CartProductsDAOImpl implements CartProductsDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(CartProductsDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.CartProductsDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.CartProductsDAO#insertCartProducts(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int insertCartProducts(CartProductsVO cartProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertCartProducts' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertCartProducts"), cartProductsVO);
        return 1;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.CartProductsDAO#updateCartProducts(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int updateCartProducts(CartProductsVO cartProductsVO) {
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("invoked 'updateCartProducts' method...");
         }
         return (Integer) sqlSessionTemplate.update(getSqlId("updateCartProducts"), cartProductsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.CartProductsDAO#removeCartProducts(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int removeCartProducts(CartProductsVO cartProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'removeCartProducts' method...");
        }

        return (Integer) sqlSessionTemplate.delete(getSqlId("removeCartProducts"), cartProductsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.CartProductsDAO#getCartProductsList(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public List<CartProductsVO> getCartProductsList(CartProductsVO cartProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getCartProductsList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getCartProductsList"),cartProductsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.CartProductsDAO#getCartProductList(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public List<CartProductsVO> getCartProductList(CartProductsVO cartProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getCartProductList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getCartProductList"),cartProductsVO);
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
