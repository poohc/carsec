package com.pama.carestimate.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.carestimate.dao.CarEstimateDAO;
import com.pama.carestimate.vo.CarEstimateListVO;
import com.pama.carestimate.vo.CarEstimateSearchVO;
import com.pama.carestimate.vo.CarEstimateVO;

@Repository
public class CarEstimateService {

    private static final Log LOG = LogFactory.getLog(CarEstimateService.class);

    @Autowired
    private CarEstimateDAO carEstimateDAO;



    public CarEstimateListVO getCarEstimateList(CarEstimateSearchVO carEstimateSearchVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getCarEstimateList' method...");
        }

        CarEstimateListVO carEstimateListVO = new CarEstimateListVO();

        carEstimateListVO.setTotalCount(carEstimateDAO.getCarEstimateListTotalCount(carEstimateSearchVO));
        carEstimateListVO.setList(carEstimateDAO.getCarEstimateList(carEstimateSearchVO));
        carEstimateListVO.setCarEstimateSearchVO(carEstimateSearchVO);

        return carEstimateListVO;
    }

    public List<CarEstimateVO> getMbrAccountMec(String companyAddr) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateList' method...");
    	}

    	CarEstimateVO carEstimateVO = new CarEstimateVO();
    	carEstimateVO.setCompanyAddr(companyAddr);
    	List<CarEstimateVO>  list = carEstimateDAO.getMbrAccountMec(carEstimateVO);

    	return list;
    }


    public CarEstimateVO getCarEstimateOne(CarEstimateVO carEstimateVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateOne' method...");
    	}
    	return carEstimateDAO.getCarEstimateOne(carEstimateVO);
    }

    public CarEstimateVO getCarEstimateCount(CarEstimateVO carEstimateVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getCarEstimateCount' method...");
    	}
    	return carEstimateDAO.getCarEstimateCount(carEstimateVO);
    }

    public int addCarEstimate(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertCarEstimate' method...");
    	}
    	return carEstimateDAO.insertCarEstimate(carEstimateVO);
    }

    public int modifyCarEstimatePrice(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateCarEstimatePrice' method...");
    	}
    	return carEstimateDAO.updateCarEstimatePrice(carEstimateVO);
    }

    public int modifyCarEstimateVisit(CarEstimateVO carEstimateVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateCarEstimateVisit' method...");
    	}
    	return carEstimateDAO.updateCarEstimateVisit(carEstimateVO);
    }

}
