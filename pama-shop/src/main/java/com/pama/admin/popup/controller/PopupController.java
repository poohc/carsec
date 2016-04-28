package com.pama.admin.popup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.banner.vo.BannerSearchVO;
import com.pama.popup.service.PopupInfoService;
import com.pama.popup.vo.PopupInfoFormVO;
import com.pama.popup.vo.PopupSearchVO;

@Controller
@RequestMapping("/admin/popup/*")
public class PopupController {

	private static final Log LOG = LogFactory.getLog(PopupController.class);

	@Autowired
	private PopupInfoService popupInfoService;

    @RequestMapping("/popupInfoList")
    public ModelAndView getPopupInfoList(HttpServletRequest request,
                                HttpServletResponse response,
                                PopupSearchVO popupSearchVO
    		){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'popupList' controller...");
        }


        ModelAndView mav = new ModelAndView();
        mav.addObject("list", popupInfoService.getList(popupSearchVO));
        return mav;
    }



    @RequestMapping("popupInfoForm")
    public ModelAndView getPopupInfoForm(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'popupForm' controller...");
        }

        ModelAndView mav = new ModelAndView();

        return mav;
    }


    @RequestMapping("popupInfoFormProc")
    public ModelAndView addPopupInfoFormProc(HttpServletRequest request,
			HttpServletResponse response,
			PopupInfoFormVO popupInfoFormVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'popupForm' controller...");
        }


        System.out.println(popupInfoFormVO.toString());

        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:popupInfoList.do");
        return mav;
    }

}
