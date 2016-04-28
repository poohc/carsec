package com.pama.car.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.car.dao.CarcodeDAO;
import com.pama.car.vo.CarcodeVO;

@Service
public class CarcodeService {
	
	private static final Log LOG = LogFactory.getLog(CarcodeService.class);

	@Autowired
	private CarcodeDAO carcodeDAO;
	
	public List<CarcodeVO> getAccountAddrSearch(CarcodeVO carcodeVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getAccountAddrSearch' method...");
		}

		List<CarcodeVO> carcodeList = carcodeDAO.getCarcodeSearchList(carcodeVO);

		return carcodeList;
	}

}
