package com.pama.admin.smp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/smp/*")
public class SmpController {

	private static final Log LOG = LogFactory.getLog(SmpController.class);

	@ModelAttribute("types")
    public String populatePetTypes() {
        System.out.println("11111");
        return "ttt";
    }


    @RequestMapping("{smpType}form")
    public ModelAndView form(@PathVariable("smpType") String smpType ,
    		HttpServletRequest request,
                                HttpServletResponse response){

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'form' controller...");
        }

        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
