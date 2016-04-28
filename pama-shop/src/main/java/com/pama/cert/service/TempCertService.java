package com.pama.cert.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.cert.dao.TempCertDAO;
import com.pama.cert.vo.TempCertVO;

@Service
public class TempCertService {
	
	private static final Log LOG = LogFactory.getLog(TempCertService.class);

	@Autowired
	private TempCertDAO tempCertDAO;
	
	public TempCertVO getTempCert(TempCertVO tempCertVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getTempCert' method...");
		}

		TempCertVO tempCert = tempCertDAO.getTempCert(tempCertVO);

		return tempCert;
	}

	/**
	 * 생성된 인증키 등록
	 * @param tempCertVO
	 * @return
	 */
	public int addTempCert(TempCertVO tempCertVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addTempCert' method...");
        }

		return tempCertDAO.insertTempCert(tempCertVO);
	}

	/**
	 * 기존 인증키 삭제
	 * @param tempCertVO
	 * @return
	 */
	public int removeTempCert(TempCertVO tempCertVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeTempCert' method...");
        }
		return tempCertDAO.deleteTempCert(tempCertVO);
	}
	
}
