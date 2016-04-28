package com.pama.cmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.zip.service.ZipcodeService;
import com.pama.zip.vo.ZipcodeListVO;
import com.pama.zip.vo.ZipcodeVO;

@Controller
@RequestMapping("/common/zip/*")
public class ZipcodeController {

     private static final Log LOG = LogFactory.getLog(ZipcodeController.class);

        @Autowired
        private ZipcodeService zipcodeService;

        /**
         * 우편번호 리스트
         * @param request
         * @param response
         * @param zipcodeVO
         * @return
         */
        @RequestMapping("zipcodeList")
        public ModelAndView getZipcodeList(HttpServletRequest request,
                                    HttpServletResponse response,
                                    ZipcodeVO zipcodeVO){
            if ( LOG.isDebugEnabled() ) {
                LOG.debug("starting 'getZipcodeList' controller...");
            }

            ModelAndView mav = new ModelAndView();

            if(StringUtils.isNotEmpty(zipcodeVO.getDong())) {
                ZipcodeListVO zipcodeList = zipcodeService.getList(zipcodeVO);

                mav.addObject("zipcodeList", zipcodeList);
                mav.addObject("zipcodeVO", zipcodeVO);
            }

        	mav.setViewName("/modules/zip/zipcodeList");

            return mav;
        }
}
