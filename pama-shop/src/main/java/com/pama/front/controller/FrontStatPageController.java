package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.stat.service.StatPageViewService;
import com.pama.stat.vo.StatPageViewVO;

@Controller
@RequestMapping("/stat/page/*")
public class FrontStatPageController {

	private static final Log LOG = LogFactory.getLog(FrontStatPageController.class);

    @Autowired
    private StatPageViewService pageViewService;

    @RequestMapping("/statPageRegister")
    public ModelAndView addStatPage(HttpServletRequest request,
									HttpServletResponse response,
									StatPageViewVO statPageViewVO) {
    	if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addStatPage' controller...");
        }

    	statPageViewVO.setRegisterIp(request.getRemoteAddr());

    	pageViewService.insertStatPageView(statPageViewVO);

    	ModelAndView mav = new ModelAndView("jsonView");
    	mav.addObject("msgCode","200");
    	return mav;
    }
}
