package com.pama.carcheck.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.carcheck.vo.CarCheckVO;

@Repository
public class CarCheckDAO {

    private static final Log LOG = LogFactory.getLog(CarCheckDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.carcheck.dao.CarCheckDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<CarCheckVO> getCarCheckFirstList() {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getCarCheckFirstList' method...");
        }

        CarCheckVO carCheckVO = new CarCheckVO();
        return sqlSessionTemplate.selectList(getSqlId("getCarCheckFirstList"), carCheckVO);
    }

    public int getCarCheckGcodeTotalCount(CarCheckVO carCheckVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarCheckGcodeTotalCount' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getCarCheckGcodeTotalCount"), carCheckVO);
    }

    public CarCheckVO getCarCheckOne(CarCheckVO carCheckVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarCheckOne' method...");
    	}
    	return sqlSessionTemplate.selectOne(getSqlId("getCarCheckOne"), carCheckVO);
    }

    public List<CarCheckVO> getCarCheckNextList(CarCheckVO carCheckVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarCheckNextList' method...");
    	}

    	return sqlSessionTemplate.selectList(getSqlId("getCarCheckNextList"), carCheckVO);
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
