package com.pama.admin.prd.controller;

import java.util.List;

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
import com.pama.prd.service.CategoryService;
import com.pama.prd.service.ProductLicenseService;
import com.pama.prd.vo.CategoryVO;
import com.pama.prd.vo.ProductLicenseFormVO;
import com.pama.prd.vo.ProductLicenseListVO;
import com.pama.prd.vo.ProductLicenseSearchVO;
import com.pama.prd.vo.ProductLicenseVO;

@Controller
@RequestMapping("/admin/prd/*")
public class ProductLicenseController {


	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductLicenseController.class);

    /**
     * Service 생성
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * Service 생성
     */
    @Autowired
    private ProductLicenseService productLicenseService;

    @RequestMapping("license/productLicenseList")
    public ModelAndView getProductLicenseList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseSearchVO productLicenseSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductLicenseForm' controller...");
        }




        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(new CategoryVO());

        ProductLicenseListVO productLicenseListVO = productLicenseService.getProductLicenseList(productLicenseSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("categoryListBox", categoryListBox);
        mav.addObject("productLicenseList", productLicenseListVO);
        return mav;
    }

    @RequestMapping("license/excel/productLicenseList")
    public ModelAndView getProductLicenseExcelList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseSearchVO productLicenseSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductLicenseExcelList' controller...");
        }

        ProductLicenseListVO productLicenseListVO = productLicenseService.getProductLicenseList(productLicenseSearchVO);

        ModelAndView mav = new ModelAndView("admin/prd/license/excel/productLicenseList");
        mav.addObject("productLicenseList", productLicenseListVO);
        return mav;
    }

    @RequestMapping("license/productLicenseForm")
    public ModelAndView getProductLicenseForm(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseSearchVO productLicenseSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductLicenseForm' controller...");
        }


        ModelAndView mav = new ModelAndView();
        if(StringUtils.isNotEmpty(productLicenseSearchVO.getPrdLicenseId())){
        	ProductLicenseVO productLicenseVO = productLicenseService.getProductLicense(productLicenseSearchVO);
        	mav.addObject("productLicenseVO", productLicenseVO);
        }

        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(new CategoryVO());

        mav.addObject("categoryListBox", categoryListBox);
        mav.addObject("productLicenseSearchVO", productLicenseSearchVO);

        return mav;
    }

    /**
     * 상품 라이센스 등록
     * @param request
     * @param response
     * @param productLicenseFormVO
     * @return
     * @throws Exception
     * @throws ClassNotFoundException
     */
    @RequestMapping("license/productLicenseFormProc")
    public ModelAndView productLicenseFormProc(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseFormVO productLicenseFormVO) throws ClassNotFoundException, Exception{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'productLicenseFormProc' controller...");
        }

        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        ProductLicenseVO productLicenseVO = new ProductLicenseVO();

        productLicenseVO = (ProductLicenseVO)BeenUtil.load(productLicenseVO, productLicenseFormVO);

        productLicenseVO.setRegisterId(loginId);
        productLicenseVO.setUpdateId(loginId);

        int productKey = productLicenseService.addProductLicense(productLicenseVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("updateCount : " + productKey);
        }

        return new ModelAndView("redirect:productLicenseList.do");
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
    @RequestMapping("license/productLicenseModify")
    public ModelAndView modifyLicenseProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseFormVO productLicenseFormVO) throws ClassNotFoundException, Exception{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyLicenseProduct' controller...");
        }

        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        ProductLicenseVO productLicenseVO = new ProductLicenseVO();

        productLicenseVO = (ProductLicenseVO)BeenUtil.load(productLicenseVO, productLicenseFormVO);

        productLicenseVO.setUpdateId(loginId);

        int updateCount = productLicenseService.modifyProductLicense(productLicenseVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("updateCount : " + updateCount);
        }

        return new ModelAndView("redirect:productLicenseList.do");
    }

    /**
     * 상품 라이센스 상태 수정
     * @param request
     * @param response
     * @param productLicenseVO
     * @return
     */
    @RequestMapping("license/productLicenseStatus")
    public ModelAndView modifyLicenseProductStatus(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductLicenseVO productLicenseVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyLicenseProductStatus' controller...");
        }
        String loginId = null;
        if( SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME, request)){  //로그인체크
        	loginId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        productLicenseVO.setUpdateId(loginId);
        productLicenseVO.setLicensePublishType("0");

        //상품 정보 삭제
        int deleteCount = productLicenseService.modifyProductLicenseStatus(productLicenseVO);

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("deleteCount : " + deleteCount);
        }

        return new ModelAndView("redirect:productLicenseList.do");
    }

    @RequestMapping("license/licenseRemoveSelectProc")
    public ModelAndView removeSelectLicense(HttpServletRequest request,
    							HttpServletResponse response,
    							ProductLicenseFormVO productLicenseFormVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeSelectLicense' controller...");
        }

        productLicenseService.removeSelectLicense(productLicenseFormVO);

        return new ModelAndView("redirect:productLicenseList.do");
    }

}
