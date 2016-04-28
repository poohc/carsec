package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.carcheck.service.CarCheckService;
import com.pama.carestimate.service.CarEstimateService;
import com.pama.carestimate.vo.CarEstimateListVO;
import com.pama.carestimate.vo.CarEstimateSearchVO;
import com.pama.carestimate.vo.CarEstimateVO;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountService;

@Controller
@RequestMapping("/estimate")
public class FrontEstimateController {

    private static final Log LOG = LogFactory.getLog(FrontEstimateController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CarCheckService carCheckService;

	 @Autowired
	 private CarEstimateService carEstimateService;

    @RequestMapping("estimate.do")
    public ModelAndView getEstimate(HttpServletRequest request,
                                HttpServletResponse response,
                                CarEstimateSearchVO carEstimateSearchVO
    		){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCheck' controller...");
        }

        ModelAndView mav = new ModelAndView();

        SessionVO sessionVO = SessionUtil.getFrontSession();


        String viewName ="";
        if(carEstimateSearchVO.getProgressStatus()==0){
        	carEstimateSearchVO.setProgressStatus(1);
        }

        if( sessionVO.getLevel()>=90 ){//관리자

        } else if(sessionVO.getLevel() >= 30){//메카닉회원


        	viewName = "estimateAgency"+carEstimateSearchVO.getProgressStatus();
    		String requestCompanyId=sessionVO.getMbrId();
            carEstimateSearchVO.setRequestCompanyId(requestCompanyId);

        } else { //일반회원

        	viewName = "estimate"+carEstimateSearchVO.getProgressStatus();
    		String requestId=sessionVO.getMbrId();
            carEstimateSearchVO.setRequestId(requestId);
        }


        CarEstimateListVO carEstimateListVO = carEstimateService.getCarEstimateList(carEstimateSearchVO);
        mav.addObject("carEstimateListVO", carEstimateListVO);

        mav.setViewName("front/estimate/"+viewName);
        return mav;
    }

    @RequestMapping("modifyCarEstimatePrice.do")
    public ModelAndView modifyCarEstimatePrice(HttpServletRequest request,
    		HttpServletResponse response,
    		CarEstimateVO carEstimateVO
    		){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'modifyCarEstimatePrice' controller...");
    	}

    	ModelAndView mav = new ModelAndView();
    	SessionVO sessionVO = SessionUtil.getFrontSession();
    	String requestCompanyId = sessionVO.getMbrId();
    	carEstimateVO.setRequestCompanyId(requestCompanyId);

    	int result = carEstimateService.modifyCarEstimatePrice(carEstimateVO);

    	mav.addObject("result", result);
    	mav.setViewName("jsonView");
    	return mav;
    }

    @RequestMapping("modifyCarEstimateVisit.do")
    public ModelAndView modifyCarEstimateVisit(HttpServletRequest request,
    		HttpServletResponse response,
    		CarEstimateVO carEstimateVO
    		){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'modifyCarEstimateVisit' controller...");
    	}

    	ModelAndView mav = new ModelAndView();
    	SessionVO sessionVO = SessionUtil.getFrontSession();
    	String requestId = sessionVO.getMbrId();
    	carEstimateVO.setRequestId(requestId);

    	int result = carEstimateService.modifyCarEstimateVisit(carEstimateVO);

    	mav.addObject("result", result);
    	mav.setViewName("jsonView");
    	return mav;
    }



}
