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
import com.pama.banner.service.BannerService;
import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerGroupVO;
import com.pama.banner.vo.BannerInfoVO;
import com.pama.banner.vo.BannerListVO;
import com.pama.banner.vo.BannerSearchVO;
import com.pama.common.Constants;
import com.pama.common.util.BeenUtil;
import com.pama.common.util.SessionUtil;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/admin/banner/*")
public class BannerController {

	private static final Log LOG = LogFactory.getLog(BannerController.class);

    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerPlaceService bannerPlaceService;

    @Autowired
    private AttachmentProcessor attachmentProcessor;

    @RequestMapping("/bannerList")
    public ModelAndView getBannerInfoList(HttpServletRequest request,
                                HttpServletResponse response,
                                BannerSearchVO bannerSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'bannerList' controller...");
        }

        bannerSearchVO.setRow(20); //listLines
        BannerListVO bannerList = bannerService.getBannerInfoList(bannerSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerList", bannerList);
        mav.setViewName("/admin/banner/bannerInfoList");

        return mav;
    }

    @RequestMapping("bannerForm")
    public ModelAndView getBannerInfoForm(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerInfoForm' controller...");
        }

        BannerInfoVO bannerInfoVO = null;
        if (bannerSearchVO.getBannerId()!=null) {
        	bannerInfoVO = bannerService.getBannerInfo(bannerSearchVO);
        	bannerSearchVO.setBannerPlaceId(bannerInfoVO.getBannerPlaceId());
        }

        bannerSearchVO.setRow(0);
        BannerListVO bannerList = bannerPlaceService.getBannerPlaceList(bannerSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerInfoVO", bannerInfoVO);
        mav.addObject("bannerList", bannerList);
        mav.addObject("bannerSearchVO", bannerSearchVO);
        mav.setViewName("/admin/banner/bannerInfoForm");

        return mav;
    }

    @RequestMapping("/bannerGroupList")
    public ModelAndView getBannerGroupList(HttpServletRequest request,
                                HttpServletResponse response,
                                BannerSearchVO bannerSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'bannerGroupList' controller...");
        }

        bannerSearchVO.setRow(20); //listLines
        BannerListVO bannerList = bannerService.getBannerGroupList(bannerSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerList", bannerList);
        mav.setViewName("/admin/banner/bannerGroupList");

        return mav;
    }





    @RequestMapping("bannerGroupDetail")
    public ModelAndView getBannerGroup(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerGroup' controller...");
        }
        BannerGroupVO bannerGroupVO = bannerService.getBannerGroup(bannerSearchVO);

        BannerListVO bannerList = bannerService.getBannerGroupInfoList(bannerSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerGroupVO", bannerGroupVO);
        mav.addObject("bannerList", bannerList);

        return mav;
    }

    @RequestMapping("bannerGroupForm")
    public ModelAndView getBannerGroupForm(HttpServletRequest request,
			HttpServletResponse response,
			BannerSearchVO bannerSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getBannerGroupForm' controller...");
        }

        BannerGroupVO bannerGroupVO = null;
        if (bannerSearchVO.getBannerGroupId()!=null) {
        	bannerGroupVO = bannerService.getBannerGroup(bannerSearchVO);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("bannerGroupVO", bannerGroupVO);

        return mav;
    }



    @RequestMapping("bannerGroupRegister")
    public ModelAndView addBannerGroup(HttpServletRequest request,
			HttpServletResponse response,
			BannerGroupVO bannerGroupVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addBannerGroup' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        bannerGroupVO.setRegisterId(loginId);
        bannerGroupVO.setRegisterIp(request.getRemoteAddr());
        bannerGroupVO.setUpdateId(loginId);
        bannerGroupVO.setUpdateIp(request.getRemoteAddr());

        int bannerGroupKey = bannerService.addBannerGroup(bannerGroupVO);

        ModelAndView mav = new ModelAndView(new RedirectView("bannerGroupList.do"));
        mav.addObject("bannerGroupId", bannerGroupKey);

        return mav;

    }

    @RequestMapping("bannerRegister")
    public ModelAndView addBannerInfo(HttpServletRequest request,
			HttpServletResponse response,
			BannerFormVO bannerFormVO) throws ClassNotFoundException, Exception{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addBannerInfo' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        BannerInfoVO bannerInfoVO = new BannerInfoVO();
        bannerInfoVO = (BannerInfoVO)BeenUtil.load(bannerInfoVO, bannerFormVO);

        bannerInfoVO.setRegisterId(loginId);
        bannerInfoVO.setRegisterIp(request.getRemoteAddr());
        bannerInfoVO.setUpdateId(loginId);
        bannerInfoVO.setUpdateIp(request.getRemoteAddr());

        if (bannerFormVO.getFile()!=null) {  //
            AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BANNER, bannerFormVO.getFile());
            if(attachmentVO!=null){
            	bannerInfoVO.setFileName(attachmentVO.getFileName());
            	bannerInfoVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
            	bannerInfoVO.setContentType(attachmentVO.getContentType());
            	if (attachmentVO.getContentType().indexOf("image") >= 0) {
            		bannerInfoVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
            		bannerInfoVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
            		bannerInfoVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
            	} else {
            		bannerInfoVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
            	}
            }
        }

        bannerService.addBannerInfo(bannerInfoVO);

//        ModelAndView mav = new ModelAndView(new RedirectView("bannerGroupDetail.do"));
        ModelAndView mav = new ModelAndView(new RedirectView("bannerList.do"));
        mav.addObject("bannerGroupId", bannerFormVO.getBannerGroupId());
        mav.addObject("bannerPlaceId", bannerFormVO.getBannerPlaceId());

        return mav;

    }

    @RequestMapping("bannerGroupModify")
    public ModelAndView modifyBannerGroup(HttpServletRequest request,
			HttpServletResponse response,
			BannerGroupVO bannerGroupVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyBannerGroup' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        bannerGroupVO.setUpdateId(loginId);
        bannerGroupVO.setUpdateIp(request.getRemoteAddr());

        bannerService.modifyBannerGroup(bannerGroupVO);

    	ModelAndView mav = new ModelAndView(new RedirectView("bannerGroupForm.do"));
    	mav.addObject("bannerGroupId",bannerGroupVO.getBannerGroupId());

    	return mav;
    }

    @RequestMapping("bannerModify")
    public ModelAndView modifyBannerInfo(HttpServletRequest request,
			HttpServletResponse response,
			BannerFormVO bannerFormVO) throws ClassNotFoundException, Exception {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyBannerInfo' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        BannerInfoVO bannerInfoVO = new BannerInfoVO();
        bannerInfoVO = (BannerInfoVO)BeenUtil.load(bannerInfoVO, bannerFormVO);

        bannerInfoVO.setBannerId(Integer.parseInt(bannerFormVO.getBannerId()));
        bannerInfoVO.setUpdateId(loginId);
        bannerInfoVO.setUpdateIp(request.getRemoteAddr());

        if (bannerFormVO.getFile()!=null) {  //
            AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BANNER, bannerFormVO.getFile());
            if(attachmentVO!=null){
            	bannerInfoVO.setFileName(attachmentVO.getFileName());
            	bannerInfoVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
            	bannerInfoVO.setContentType(attachmentVO.getContentType());
            	if (attachmentVO.getContentType().indexOf("image") >= 0) {
            		bannerInfoVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
            		bannerInfoVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
            		bannerInfoVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
            	} else {
            		bannerInfoVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
            	}
            }
        }

        bannerService.modifyBannerInfo(bannerInfoVO);

//        ModelAndView mav = new ModelAndView(new RedirectView("bannerGroupDetail.do"));
        ModelAndView mav = new ModelAndView(new RedirectView("bannerForm.do"));
    	mav.addObject("bannerId",bannerInfoVO.getBannerId());
    	mav.addObject("bannerGroupId",bannerInfoVO.getBannerGroupId());
    	mav.addObject("listReturnURL",bannerFormVO.getListReturnURL());

    	return mav;
    }

    @RequestMapping("bannerGroupRemove")
    public ModelAndView removeBannerGroup(HttpServletRequest request,
    							HttpServletResponse response,
    							BannerGroupVO bannerGroupVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeBannerGroup' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        bannerGroupVO.setUpdateId(loginId);
        bannerGroupVO.setUpdateIp(request.getRemoteAddr());

        bannerService.removeBannerGroup(bannerGroupVO); //

        return new ModelAndView("redirect:/admin/banner/bannerGroupList.do");
    }

    @RequestMapping("bannerRemove")
    public ModelAndView removeBannerInfo(HttpServletRequest request,
    							HttpServletResponse response,
    							BannerInfoVO bannerInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeBannerInfo' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        bannerInfoVO.setUpdateId(loginId);
        bannerInfoVO.setUpdateIp(request.getRemoteAddr());

        bannerService.removeBannerInfo(bannerInfoVO); //

        return new ModelAndView("redirect:/admin/banner/bannerGroupList.do");
    }

    @RequestMapping("bannerPlaceSelectRemove")
    public ModelAndView removeSelectBannerPlace(HttpServletRequest request,
    							HttpServletResponse response,
    							BannerFormVO bannerFormVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeSelectBannerPlace' controller...");
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
        }

        bannerFormVO.setUpdateId(loginId);
        bannerFormVO.setUpdateIp(request.getRemoteAddr());

        bannerService.removeSelectBannerGroup(bannerFormVO);

        return new ModelAndView("redirect:/admin/banner/bannerGroupList.do");
    }
}
