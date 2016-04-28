package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.carcheck.service.CarCheckService;
import com.pama.carestimate.service.CarEstimateService;
import com.pama.mbr.service.AccountService;

@Controller
@RequestMapping("/coupon")
public class FrontCouponController {

    private static final Log LOG = LogFactory.getLog(FrontCouponController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CarCheckService carCheckService;

	 @Autowired
	 private CarEstimateService carEstimateService;

    @RequestMapping("coupon.do")
    public ModelAndView getEstimate(HttpServletRequest request,
                                HttpServletResponse response){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCheck' controller...");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("front/coupon/coupon1");
        return mav;
    }



}