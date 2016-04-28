package com.pama.front.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pama.bbs.service.MessageService;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;

@Controller
@RequestMapping("/web/**")
public class FrontWebController {

    private static final Log LOG = LogFactory.getLog(FrontWebController.class);

    @Autowired
	private MessageService messageService;

    @Autowired
	private AccountInfoService accountInfoService;

    @Autowired
	private AccountService accountService;


    /**
     * main페이지
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/*")
    public String getWebContents(HttpServletRequest request,
                                HttpServletResponse response){

    	if(LOG.isDebugEnabled()){
    	     LOG.debug("invoked 'getWebContents' method...");
    	}

        String requestURI =  request.getRequestURI();
        requestURI = StringUtils.replace(requestURI, "../", "");
		requestURI = StringUtils.replace(requestURI, "..", "");
        String requestURIPath = "front" + requestURI.substring(0,requestURI.lastIndexOf(".do"));


        if(StringUtils.startsWith(requestURI,"/web/main.do") ){
        	try {
				response.sendRedirect("/main/main.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }


        return requestURIPath;
    }

}