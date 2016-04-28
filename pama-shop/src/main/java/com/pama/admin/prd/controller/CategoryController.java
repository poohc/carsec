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
import com.pama.common.util.ConvertUtil;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.prd.service.CategoryService;
import com.pama.prd.vo.CategoryVO;

@Controller
@RequestMapping("/admin/prd/*")
public class CategoryController {
	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(CategoryController.class);

    /**
     * Service 생성
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * 카테고리 리스트 정보 취득.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryListCount")
    public ModelAndView getCategoryListCount(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCategoryListCount' controller...");
        }

        //카테고리 리스트 건수
        int categoryListCount = categoryService.getCategoryListCount(categoryVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("categoryListCount", categoryListCount);

        return mav;
    }

    /**
     * 카테고리 리스트 정보 취득.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryList")
    public ModelAndView getCategoryList(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCategoryList' controller...");
        }
        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(new CategoryVO());

        //카테고리 리스트 정보
        List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("categoryList", categoryList);
        mav.addObject("categoryListBox", categoryListBox);
        mav.addObject("categoryVO", categoryVO);

        return mav;
    }

    /**
     * 카테고리 상세 정보 취득.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryDetail")
    public ModelAndView getCategory(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCategory' controller...");
        }
        //카테고리 상세 정보
        CategoryVO Category = categoryService.getCategory(categoryVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("categoryVO", Category);

        return mav;
    }

    /**
     * 카테고리 상세 정보 취득.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryForm")
    public ModelAndView getCategoryForm(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCategoryForm' controller...");
        }
        CategoryVO CategoryFormVO = null;

        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(new CategoryVO());

        if(StringUtils.isNotEmpty(categoryVO.getCateId())){
            //카테고리 상세 정보
        	CategoryFormVO = categoryService.getCategory(categoryVO);
        }


        ModelAndView mav = new ModelAndView();
        mav.addObject("categoryListBox", categoryListBox);
        mav.addObject("CategoryFormVO", CategoryFormVO);
        mav.addObject("categoryVO", categoryVO);

        return mav;
    }

    /**
     * 카테고리 정보 등록.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryFormProc")
    public ModelAndView categoryFormProc(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryParam){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'categoryFormProc' controller...");
        }

        CategoryVO categoryVO=categoryParam;

        SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
        
        categoryVO.setRegisterId(sessionVO.getMbrId());
        categoryVO.setUpdateId(sessionVO.getMbrId());

        //상품 정보 등록  int categoryKey =
        categoryService.addCategory(categoryVO);
        
        return new ModelAndView("redirect:categoryList.do");
    }

    /**
     * 카테고리 정보 수정.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryModify")
    public ModelAndView modifyCategory(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryParam){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyCategory' controller...");
        }

		CategoryVO categoryVO=categoryParam;

        SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
        categoryVO.setRegisterId(sessionVO.getMbrId());
        categoryVO.setUpdateId(sessionVO.getMbrId());

        //상품 정보 수정
        int updateCount = categoryService.modifyCategory(categoryVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("updateCount", updateCount);

        return new ModelAndView("redirect:categoryList.do");
    }


    /**
     * 카테고리 정보 상태 수정.
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryStatus")
    public ModelAndView modifyCategoryStatus(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryParam){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyCategoryStatus' controller...");
        }

        CategoryVO categoryVO=categoryParam;

        SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
        categoryVO.setRegisterId(sessionVO.getMbrId());
        categoryVO.setUpdateId(sessionVO.getMbrId());

        //상품 정보 상태 수정
        int updateCount = categoryService.modifyCategoryStatus(categoryVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("updateCount", updateCount);

        return mav;
    }

    /**
     * 카테고리 정보 삭제
     * @param request
     * @param response
     * @param categoryVO
     * @return
     */
    @RequestMapping("categoryRemove")
    public ModelAndView removeCategory(HttpServletRequest request,
                                HttpServletResponse response,
                                CategoryVO categoryVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeCategory' controller...");
        }
        //상품 정보 삭제 int deleteCount =
         categoryService.removeCategory(categoryVO);

        return new ModelAndView("redirect:categoryList.do");
    }
}
