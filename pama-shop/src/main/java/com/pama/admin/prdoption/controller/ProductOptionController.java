package com.pama.admin.prdoption.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.common.Constants;
import com.pama.common.util.BeenUtil;
import com.pama.common.util.SessionUtil;
import com.pama.prdoption.service.ProductOptionService;
import com.pama.prdoption.vo.ProductOptionFormVO;
import com.pama.prdoption.vo.ProductOptionListVO;
import com.pama.prdoption.vo.ProductOptionSearchVO;
import com.pama.prdoption.vo.ProductOptionVO;

@Controller
@RequestMapping("/admin/prdoption/*")
public class ProductOptionController {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductOptionController.class);

    /**
     * Service 생성
     */
    @Autowired
    private ProductOptionService productOptionService;	
    
    @RequestMapping("productOptionList")
    public ModelAndView getProductOptionList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductOptionSearchVO productOptionSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'productOptionList' controller...");
        }

        ProductOptionListVO productOptionListVO = productOptionService.getProductOptionList(productOptionSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productOptionList", productOptionListVO);
        return mav;
    }
    
    @RequestMapping("productOptionForm")
    public ModelAndView getProductOptionForm(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductOptionSearchVO productOptionSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductOptionForm' controller...");
        }

        ModelAndView mav = new ModelAndView();
        if(StringUtils.isNotEmpty(productOptionSearchVO.getOptId())){
        	ProductOptionVO productOptionVO = productOptionService.getProductOption(productOptionSearchVO);
        	mav.addObject("productOptionVO", productOptionVO);
        }

        mav.addObject("productOptionSearchVO", productOptionSearchVO);

        return mav;
    }

    /**
     * 상품 옵션 등록
     * @param request
     * @param response
     * @param productLicenseFormVO
     * @return
     * @throws Exception
     * @throws ClassNotFoundException
     */
    @RequestMapping("productOptionFormProc")
    public ModelAndView productOptionFormProc(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductOptionFormVO productOptionFormVO) throws ClassNotFoundException, Exception{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'productOptionFormProc' controller...");
        }

        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        ProductOptionVO productOptionVO = new ProductOptionVO();

        productOptionVO = (ProductOptionVO)BeenUtil.load(productOptionVO, productOptionFormVO);

        productOptionVO.setRegisterId(loginId);
        productOptionVO.setUpdateId(loginId);

        int productOptionKey = productOptionService.addProductOption(productOptionVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("updateCount : " + productOptionKey);
        }

        return new ModelAndView("redirect:productOptionList.do");
    }

    /**
     * 상품 라이센스 수정
     * @param request
     * @param response
     * @param productLicenseFormVO
     * @return
     * @throws Exception
     * @throws ClassNotFoundException
     */
    @RequestMapping("productOptionModify")
    public ModelAndView modifyProductOption(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductOptionFormVO productOptionFormVO) throws ClassNotFoundException, Exception{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyProductOption' controller...");
        }

        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        ProductOptionVO productOptionVO = new ProductOptionVO();

        productOptionVO = (ProductOptionVO)BeenUtil.load(productOptionVO, productOptionFormVO);

        productOptionVO.setUpdateId(loginId);

        int updateCount = productOptionService.modifyProductOption(productOptionVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("updateCount : " + updateCount);
        }

        return new ModelAndView("redirect:productOptionList.do");
    }  
    
    @RequestMapping("productOptionStatus")
    public ModelAndView modifyProductOptionStatus(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductOptionVO productOptionVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyProductOptionStatus' controller...");
        }
        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        productOptionVO.setUpdateId(loginId);

        //상품 정보 삭제
        int deleteCount = productOptionService.modifyProductOptionStatus(productOptionVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("deleteCount : " + deleteCount);
        }

        return new ModelAndView("redirect:productOptionList.do");
    }
}
