package com.pama.admin.banner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pama.banner.service.BannerPlaceService;
import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerListVO;
import com.pama.banner.vo.BannerPlaceVO;
import com.pama.banner.vo.BannerSearchVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;

@Controller
@RequestMapping("/admin/banner/place/*")
public class BannerPlaceController {

	private static final Log LOG = LogFactory.getLog(BannerPlaceController.class);

    @Autowired
    private BannerPlaceService bannerPlaceService;

    @RequestMapping("bannerPlaceList")
    public ModelAndView getBannerPlaceList(HttpServletRequest request,
                                HttpServletResponse response,
                                BannerSearchVO bannerSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerPlaceList' controller...");
        }

        bannerSearchVO.setRow(20); //listLines
		System.out.println(bannerSearchVO.toSearchVOString());

        BannerListVO bannerList = bannerPlaceService.getBannerPlaceList(bannerSearchVO);
		System.out.println(bannerSearchVO.toSearchVOString());


        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerList", bannerList);
        mav.setViewName("/admin/banner/bannerPlaceList");

        return mav;
    }

    @RequestMapping("bannerPlaceDetail")
    public ModelAndView getBannerPlace(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerPlace' controller...");
        }

        BannerPlaceVO bannerPlaceVO = bannerPlaceService.getBannerPlace(bannerSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerPlaceVO", bannerPlaceVO);

        return mav;
    }

    @RequestMapping("bannerPlaceForm")
    public ModelAndView getBannerPlaceForm(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerPlaceForm' controller...");
        }

        BannerPlaceVO bannerPlaceVO = null;
        if (bannerSearchVO.getBannerPlaceId()!=null) {
        	bannerPlaceVO = bannerPlaceService.getBannerPlace(bannerSearchVO);
        }
        ModelAndView mav = new ModelAndView("/admin/banner/bannerPlaceForm");
        mav.addObject("bannerPlaceVO", bannerPlaceVO);

        return mav;
    }

    @RequestMapping("bannerPlaceRegister")
    public ModelAndView addBannerPlace(HttpServletRequest request,
			HttpServletResponse response,
			BannerPlaceVO bannerPlaceVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addBannerPlace' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  //
        }

        bannerPlaceVO.setRegisterId(loginId);
        bannerPlaceVO.setRegisterIp(request.getRemoteAddr());

        int bannerPlaceKey = bannerPlaceService.addBannerPlace(bannerPlaceVO);

        ModelAndView mav = new ModelAndView(new RedirectView("bannerPlaceList.do"));
        mav.addObject("bannerPlaceId", bannerPlaceKey);

        return mav;

    }

    @RequestMapping("bannerPlaceModify")
    public ModelAndView modifyBannerPlace(HttpServletRequest request,
			HttpServletResponse response,
			BannerPlaceVO bannerPlaceVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyBannerPlace' controller...");
        }

    	bannerPlaceService.modifyBannerPlace(bannerPlaceVO);

    	ModelAndView mav = new ModelAndView(new RedirectView("bannerPlaceForm.do"));
    	mav.addObject("bannerPlaceId",bannerPlaceVO.getBannerPlaceId());

    	return mav;
    }

    @RequestMapping("bannerPlaceRemove")
    public ModelAndView removeBannerPlace(HttpServletRequest request,
    							HttpServletResponse response,
    							BannerPlaceVO bannerPlaceVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeBannerPlace' controller...");
        }

        bannerPlaceService.removeBannerPlace(bannerPlaceVO); //

        return new ModelAndView("redirect:/admin/banner/place/bannerPlaceList.do");
    }

    @RequestMapping("bannerPlaceSelectRemove")
    public ModelAndView removeSelectBannerPlace(HttpServletRequest request,
    							HttpServletResponse response,
    							BannerFormVO bannerFormVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeSelectBannerPlace' controller...");
        }

        bannerPlaceService.removeSelectBannerPlace(bannerFormVO);

        return new ModelAndView("redirect:/admin/banner/place/bannerPlaceList.do");
    }

}
