package com.pama.ord.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.ord.vo.TaxSearchVO;
import com.pama.ord.vo.TaxVO;

@Repository
public class TaxDAOImpl implements TaxDAO {

    private static final Log LOG = LogFactory.getLog(TaxDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.tax.dao.TaxDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#getListTotalCount(com.pama.ord.vo.TaxSearchVO)
     */
    @Override
    public int getListTotalCount(TaxSearchVO taxSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"),taxSearchVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#getTaxList(com.pama.ord.vo.TaxSearchVO)
     */
    @Override
    public List<TaxVO> getTaxList(TaxSearchVO taxSearchVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getList"),taxSearchVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#getTax(com.pama.ord.vo.TaxVO)
     */
    @Override
    public TaxVO getTax(TaxVO taxVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getTax' method...");
        }
        return (TaxVO)sqlSessionTemplate.selectOne(getSqlId("getTax"), taxVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#insertTax(com.pama.ord.vo.TaxVO)
     */
    @Override
    public int insertTax(TaxVO taxVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertTax' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertTax"), taxVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#updateTax(com.pama.ord.vo.TaxVO)
     */
    @Override
    public int updateTax(TaxVO taxVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateTax' method...");
        }
        int rows = sqlSessionTemplate.update(getSqlId("updateTax"), taxVO);

        return rows;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.dao.TaxDAO#removeTax(com.pama.ord.vo.TaxVO)
     */
    @Override
    public int removeTax(TaxVO taxVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'removeTax' method...");
        }
        int rows = sqlSessionTemplate.delete(getSqlId("removeTax"), taxVO);

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
