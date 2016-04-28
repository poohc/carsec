package com.pama.ord.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.PurchaserVO;

@Repository
public class PurchaserDAOImpl implements PurchaserDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(PurchaserDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.ord.dao.PurchaserDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.PurchaserDAO#getPurchaser(com.pama.ord.vo.PurchaserVO)
     */
    @Override
    public PurchaserVO getPurchaser(PurchaserVO purchaserVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getPurchaser' method...");
        }
        return (PurchaserVO) sqlSessionTemplate.selectOne(getSqlId("getPurchaser"),purchaserVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.PurchaserDAO#insertPurchaser(com.pama.ord.vo.OrderVO)
     */
    @Override
    public int insertPurchaser(OrderVO orderVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertPurchaser' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertPurchaser"), orderVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.PurchaserDAO#updatePurchaser(com.pama.ord.vo.PurchaserVO)
     */
    @Override
    public int updatePurchaser(PurchaserVO purchaserVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updatePurchaser' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updatePurchaser"), purchaserVO);
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
