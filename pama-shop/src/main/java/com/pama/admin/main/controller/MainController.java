package com.pama.admin.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/main/*")
public class MainController {

	private static final Log LOG = LogFactory.getLog(MainController.class);

	@ModelAttribute("types")
    public String populatePetTypes() {
        System.out.println("11111");
        return "ttt";
    }


    @RequestMapping("main")
    public ModelAndView getMain(HttpServletRequest request,
                                HttpServletResponse response){

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getMain' controller...");
        }

        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
