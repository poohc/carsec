package com.pama.carestimate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.carcheck.vo.CarCheckVO;
import com.pama.carestimate.vo.CarEstimateSearchVO;
import com.pama.carestimate.vo.CarEstimateVO;

@Repository
public class CarEstimateDAO {

    private static final Log LOG = LogFactory.getLog(CarEstimateDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.carestimate.dao.CarEstimateDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int getCarEstimateListTotalCount(CarEstimateSearchVO carEstimateSearchVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateListTotalCount' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getCarEstimateListTotalCount"), carEstimateSearchVO);
    }


    public List<CarEstimateVO> getCarEstimateList(CarEstimateSearchVO carEstimateSearchVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getCarEstimateList' method...");
        }

        return sqlSessionTemplate.selectList(getSqlId("getCarEstimateList"), carEstimateSearchVO);
    }

    public List<CarEstimateVO> getMbrAccountMec(CarEstimateVO carEstimateVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getMbrAccountMec' method...");
    	}

    	return sqlSessionTemplate.selectList(getSqlId("getMbrAccountMec"), carEstimateVO);
    }

    public CarEstimateVO getCarEstimateCount(CarEstimateVO carEstimateVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateCount' method...");
    	}

    	return sqlSessionTemplate.selectOne(getSqlId("getCarEstimateCount"), carEstimateVO);
    }


    public CarEstimateVO getCarEstimateOne(CarEstimateVO carEstimateVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateOne' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getCarEstimateOne"), carEstimateVO);
    }

    public int insertCarEstimate(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertCarEstimate' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("insertCarEstimate"), carEstimateVO);
    }

    public int updateCarEstimatePrice(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateCarEstimatePrice' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("updateCarEstimatePrice"), carEstimateVO);
    }

    public int updateCarEstimateVisit(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateCarEstimateVisit' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("updateCarEstimateVisit"), carEstimateVO);
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
