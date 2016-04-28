package com.pama.car.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.car.vo.CarcodeVO;

@Repository
public class CarcodeDAO {
	
    private static final Log LOG = LogFactory.getLog(CarcodeDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.car.dao.CarcodeDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<CarcodeVO> getCarcodeList(CarcodeVO carcodeVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getCarcodeList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getCarcodeList"), carcodeVO);
    }

    public List<CarcodeVO> getCarcodeSearchList(CarcodeVO carcodeVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getCarcodeSearchList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getCarcodeSearchList"), carcodeVO);
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
