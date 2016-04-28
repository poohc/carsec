package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;

@Repository
public class InfoDAOImpl implements InfoDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(InfoDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.InfoDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#getListTotalCount(com.pama.ord.vo.OrderSearchVO)
     */
    @Override
    public int getListTotalCount(OrderSearchVO orderSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"),orderSearchVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#getOrderList(com.pama.ord.vo.OrderSearchVO)
     */
    @Override
    public List<OrderVO> getOrderList(OrderSearchVO orderSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getOrderList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getOrderList"),orderSearchVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#getInfo(com.pama.ord.vo.InfoVO)
     */
    @Override
    public OrderVO getInfo(InfoVO infoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getInfo' method...");
        }
        return (OrderVO)sqlSessionTemplate.selectOne(getSqlId("getOrderInfo"), infoVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#insertInfo(com.pama.ord.vo.OrderVO)
     */
    @Override
    public int insertInfo(OrderVO orderVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertInfo' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertInfo"), orderVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#updateInfo(com.pama.ord.vo.InfoVO)
     */
    @Override
    public int updateInfo(InfoVO infoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateInfo' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateInfo"), infoVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#updateOrderStatusType(com.pama.ord.vo.InfoVO)
     */
    @Override
    public int updateOrderStatusType(InfoVO infoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateOrderStatusType' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateOrderStatusType"), infoVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.InfoDAO#updateOrderRemove(com.pama.ord.vo.InfoVO)
     */
    @Override
    public int updateOrderRemove(InfoVO infoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateOrderRemove' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateOrderRemove"), infoVO);
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
