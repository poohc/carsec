package com.pama.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.banner.service.BannerService;
import com.pama.banner.vo.BannerInfoVO;
import com.pama.banner.vo.BannerSearchVO;

@Controller
@RequestMapping("/banner")
public class FrontBannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("api")
	public ModelAndView getBanner(HttpServletRequest request,
            HttpServletResponse response, String bannerPlaceId) {

		BannerSearchVO bannerSearchVO = new BannerSearchVO();
		bannerSearchVO.setBannerPlaceId(bannerPlaceId);
		BannerInfoVO bannerVO = bannerService.getBanner(bannerSearchVO);

		if (bannerVO != null) bannerService.modifyBannerInfoOpenCount(bannerVO);

		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("jsonData", bannerVO);
		return mav;
	}

    @RequestMapping("banners")
    public ModelAndView getBanners(HttpServletRequest request,
    		HttpServletResponse response, String bannerPlaceId, int row) {

    	BannerSearchVO bannerSearchVO = new BannerSearchVO();
    	bannerSearchVO.setBannerPlaceId(bannerPlaceId);
    	bannerSearchVO.setRow(row);
    	List<BannerInfoVO> bannerVOs = bannerService.getBanners(bannerSearchVO);

	    for (BannerInfoVO bannerInfoVO : bannerVOs) {
	    	if (bannerVOs != null) bannerService.modifyBannerInfoOpenCount(bannerInfoVO);
		}

    	ModelAndView mav = new ModelAndView("jsonView");
    	mav.addObject("jsonData", bannerVOs);
    	return mav;
    }

}
