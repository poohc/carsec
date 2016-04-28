package com.pama.mbrpoint.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.mbrpoint.vo.PointFormVO;
import com.pama.mbrpoint.vo.PointSearchVO;
import com.pama.mbrpoint.vo.PointVO;

@Repository
public class PointDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(PointDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.mbrpoint.dao.PointDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     *
     * @param pointSearchVO
     * @return
     */
    public int getPointListTotalCount(PointSearchVO pointSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getPointListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getPointListTotalCount"), pointSearchVO);
    }

    /**
     *
     * @param pointSearchVO
     * @return
     */
    public List<PointVO> getPointList(PointSearchVO pointSearchVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPointList' method...");
    	}
    	return sqlSessionTemplate.selectList(getSqlId("getPointList"), pointSearchVO);
    }
    
   /**
    * 수익금 정산
    * @param pointSearchVO
    * @return
    */
   public List<PointVO> getPointUseSummaryList(PointSearchVO pointSearchVO) {
   	if ( LOG.isDebugEnabled() ) {
   		LOG.debug("invoked 'getPointUseSummaryList' method...");
   	}
   	return sqlSessionTemplate.selectList(getSqlId("getPointUseSummaryList"), pointSearchVO);
   }

    /**
     *
     * @param pointSearchVO
     * @return
     */
    public PointVO getPoint(int pointId) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPoint' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getPoint"), pointId);
    }

    /**
     * 포인트 사용여부
     * @param pointSearchVO
     * @return
     */
    public PointVO getPointUse(PointFormVO pointFormVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPointUse' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getPointUse"), pointFormVO);
    }

    /**
     *
     * @param pointFormVO
     * @return
     */
    public int insertPoint(PointFormVO pointFormVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertPoint' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("insertPoint"), pointFormVO);
   }

    /**
     *
     * @param pointFormVO
     * @return
     */
    public int updateAccountAccPoint(PointFormVO pointFormVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateAccountAccPoint' method...");
    	}
    	return sqlSessionTemplate.update(getSqlId("updateAccountAccPoint"), pointFormVO);
    }

    /**
     *
     * @param pointFormVO
     * @return
     */
    public int getAccountAccPoint(PointFormVO pointFormVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getAccountAccPoint' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getAccountAccPoint"), pointFormVO);
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
