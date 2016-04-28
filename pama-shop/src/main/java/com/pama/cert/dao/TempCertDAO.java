package com.pama.cert.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.cert.vo.TempCertVO;

@Repository
public class TempCertDAO {
	
    private static final Log LOG = LogFactory.getLog(TempCertDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.cert.dao.TempCertDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public TempCertVO getTempCert(TempCertVO tempCertVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getTempCert' method...");
        }
        return sqlSessionTemplate.selectOne(getSqlId("getTempCert"), tempCertVO);
    }
    
	public int insertTempCert(TempCertVO tempCertVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertTempCert' method...");
        }
        return sqlSessionTemplate.insert(getSqlId("insertTempCert"), tempCertVO);
	}
	
	public int deleteTempCert(TempCertVO tempCertVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteTempCert' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteTempCert"), tempCertVO);
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
