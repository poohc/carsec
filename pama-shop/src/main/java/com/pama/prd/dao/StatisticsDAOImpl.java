package com.pama.prd.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.prd.vo.StatisticsVO;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO{

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(StatisticsDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.prd.dao.StatisticsDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /* (non-Javadoc)
     * @see com.pama.prd.dao.StatisticsDAO#getStatistics(com.pama.prd.vo.StatisticsVO)
     */
    @Override
    public StatisticsVO getStatistics(StatisticsVO statisticsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getStatistics' method...");
        }
        return (StatisticsVO)sqlSessionTemplate.selectOne(getSqlId("getStatistics"), statisticsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.prd.dao.StatisticsDAO#insertStatistics(com.pama.prd.vo.StatisticsVO)
     */
    @Override
    public int insertStatistics(StatisticsVO statisticsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertStatistics' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertStatistics"), statisticsVO);
        return 1;
    }

    /* (non-Javadoc)
     * @see com.pama.prd.dao.StatisticsDAO#updateStatisticsCount(com.pama.prd.vo.StatisticsVO)
     */
    @Override
    public int updateStatisticsCount(StatisticsVO statisticsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateStatisticsCount' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateStatisticsCount"), statisticsVO);
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
