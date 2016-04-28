package com.pama.zip.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.zip.vo.ZipcodeVO;


@Repository
public class ZipcodeDAO {

    private static final Log LOG = LogFactory.getLog(ZipcodeDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.zip.dao.ZipcodeDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<ZipcodeVO> getList(ZipcodeVO zipcodeVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getList"), zipcodeVO);
    }

    public List<ZipcodeVO> getAccountAddrSearch(ZipcodeVO zipcodeVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccountAddrSearch' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getAddrList"), zipcodeVO);
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
