package com.pama.zip.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.zip.dao.ZipcodeDAO;
import com.pama.zip.vo.ZipcodeListVO;
import com.pama.zip.vo.ZipcodeVO;

@Service
public class ZipcodeService {


	private static final Log LOG = LogFactory.getLog(ZipcodeService.class);

	@Autowired
	private ZipcodeDAO zipcodeDAO;

	/**
	 * 우편번호를 조회한다.
	 * @param zipcodeVO
	 * @return
	 */
	public ZipcodeListVO getList(ZipcodeVO zipcodeVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getList' method...");
		}
		ZipcodeListVO zipcodeListVO = new ZipcodeListVO();
		List<ZipcodeVO> zipcodeList = zipcodeDAO.getList(zipcodeVO);

		zipcodeListVO.setZipcodeList(zipcodeList);

		return zipcodeListVO;
	}
	
	public List<ZipcodeVO> getAccountAddrSearch(ZipcodeVO zipcodeVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'getAccountAddrSearch' method...");
		}

		List<ZipcodeVO> zipcodeList = zipcodeDAO.getAccountAddrSearch(zipcodeVO);

		return zipcodeList;
	}

}
