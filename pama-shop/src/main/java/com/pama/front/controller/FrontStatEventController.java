package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.stat.service.StatEventViewService;
import com.pama.stat.vo.StatEventViewVO;

@Controller
@RequestMapping("/stat/event/*")
public class FrontStatEventController {


    private static final Log LOG = LogFactory.getLog(FrontStatEventController.class);

    @Autowired
    private StatEventViewService eventViewService;

    @RequestMapping("/statEventRegister")
    public ModelAndView addStatEvent(HttpServletRequest request,
									HttpServletResponse response,
									StatEventViewVO statEventViewVO) {
    	if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addStatEvent' controller...");
        }

    	statEventViewVO.setRegisterIp(request.getRemoteAddr());

    	eventViewService.insertStatEventView(statEventViewVO);

    	ModelAndView mav = new ModelAndView("jsonView");
    	mav.addObject("msgCode","200");
    	return mav;
    }
}
