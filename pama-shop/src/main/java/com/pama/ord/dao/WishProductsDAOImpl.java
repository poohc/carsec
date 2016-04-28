package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.WishProductsVO;

@Repository
public class WishProductsDAOImpl implements WishProductsDAO{

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(WishProductsDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.WishProductsDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.WishProductsDAO#getWishProductsList(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public List<WishProductsVO> getWishProductsList(WishProductsVO wishProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getWishProductsList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getWishProductsList"),wishProductsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.WishProductsDAO#insertWishProducts(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public int insertWishProducts(WishProductsVO wishProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertWishProducts' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertWishProducts"), wishProductsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.WishProductsDAO#removeWishProducts(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public int removeWishProducts(WishProductsVO wishProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'removeWishProducts' method...");
        }
        return (Integer) sqlSessionTemplate.delete(getSqlId("removeWishProducts"), wishProductsVO);
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
