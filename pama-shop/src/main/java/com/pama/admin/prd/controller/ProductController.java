package com.pama.admin.prd.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountListVO;
import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.prd.service.CategoryService;
import com.pama.prd.service.ProductService;
import com.pama.prd.vo.CategoryVO;
import com.pama.prd.vo.ProductFormVO;
import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductOptVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;
import com.pama.prdoption.service.ProductOptionService;
import com.pama.prdoption.vo.ProductOptionSearchVO;
import com.pama.prdoption.vo.ProductOptionVO;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/admin/prd/*")
public class ProductController {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductController.class);

    /**
     * Service 생성
     */
    @Autowired
    private ProductService productService;

    /**
     * Service 생성
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * Service 생성
     */
    @Autowired
    private ProductOptionService productOptionService;

    /**
     * Service 생성
     */
    @Autowired
    private AttachmentProcessor attachmentProcessor;

    @Autowired
    private AccountService accountService;

    /**
     * 상품 정보 리스트 취득.
     * @param request
     * @param response
     * @param productSearchVO
     * @return
     */
    @RequestMapping("productList")
    public ModelAndView getProductList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductList' controller...");
        }

        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(new CategoryVO());

        //상품 정보 리스트
        ProductListVO productListVO = productService.getProductList(productSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productSearchVO", productSearchVO);
        mav.addObject("productListVO", productListVO);
        mav.addObject("categoryListBox", categoryListBox);
        return mav;
    }

    /**
     * 제품 상세 정보 취득.
     * @param request
     * @param response
     * @param productSearchVO
     * @return
     */
    @RequestMapping("productDetail")
    public ModelAndView getProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProduct' controller...");
        }
        //제품 상세 정보
        ProductVO productVO = productService.getProduct(productSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productSearchVO", productSearchVO);
        mav.addObject("productVO", productVO);

        return mav;
    }

    @RequestMapping("productCategoryList.json")
    public ModelAndView getProductListJS(HttpServletRequest request,
                                HttpServletResponse response,
                                String cateId){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProduct' controller...");
        }
        //제품 상세 정보
        ProductSearchVO productSearchVO = new ProductSearchVO();
        productSearchVO.setCateId(cateId);

        ProductListVO productListVO = productService.getProductCategoryList(productSearchVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("productList", productListVO);

        return mav;
    }

    /**
     * 상품 액셀 정보 리스트 취득.
     * @param request
     * @param response
     * @param productSearchVO
     * @return
     */
    @RequestMapping("productExcel")
    public ModelAndView getProductExcelList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductExcelList' controller...");
        }
        //상품 액셀 정보 리스트
        ProductListVO productExcelListVO = productService.getProductExcelList(productSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productSearchVO", productSearchVO);
        mav.addObject("productExcelListVO", productExcelListVO);

        return mav;
    }

    /**
     * 제품 상세 정보 취득.
     * @param request
     * @param response
     * @param productSearchVO
     * @return
     */
    @RequestMapping("productForm")
    public ModelAndView getProductForm(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductForm' controller...");
        }

        ProductFormVO productFormVO = null;
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setSortTree(productSearchVO.getSortTree());
        
        //카테고리 리스트 박스 정보
        List<CategoryVO> categoryListBox = categoryService.getCategoryList(categoryVO);

        List<ProductOptionVO> optionInfoListBox = productOptionService.getProductOptionList(new ProductOptionVO());

        AccountSearchVO accountSearchVO = new AccountSearchVO();
        accountSearchVO.setLevel("40");
        accountSearchVO.setStatusType("2");
        AccountListVO companyListBox = accountService.getAccountPagingList(accountSearchVO);

        List<ProductOptVO> optionListBox = null;
        //제품 등록시
        if(StringUtils.isNotEmpty(productSearchVO.getPrdId())){
            //제품 상세 정보
        	CategoryVO categorySearchVO = new CategoryVO();
        	ProductVO productVO = productService.getProduct(productSearchVO);
        	categorySearchVO.setCateId(productVO.getCateId());
        	categoryVO = categoryService.getCategory(categorySearchVO);

        	productFormVO = productVO.getProductFormVO();

        	optionListBox = productVO.getProductOptVO();
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("productSearchVO", productSearchVO);
        mav.addObject("productFormVO", productFormVO);
        mav.addObject("categoryListBox", categoryListBox);
        mav.addObject("optionInfoListBox", optionInfoListBox);
        mav.addObject("categoryVO", categoryVO);
        mav.addObject("optionListBox", optionListBox);
        mav.addObject("companyListBox", companyListBox.getAccountList());

        return mav;
    }

    /**
     * 상품 정보 등록.
     * @param request
     * @param response
     * @param productVO
     * @return
     */
    @RequestMapping("productFormProc")
    public ModelAndView productFormProc(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductFormVO productFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'productFormProc' controller...");
        }

        ProductVO productVO = null;
        try{
        	//등록- 현재 리스트 1개 상세 5개만 사용 하도록 되어 있으나 추가 확장의 용이성을 생각하여 최대 10개까지 업로드 가능하고 jsp에서만 추가
        	AttachmentVO attachmentVO1 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile1());
        	AttachmentVO attachmentVO2 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile2());
        	AttachmentVO attachmentVO3 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile3());
        	AttachmentVO attachmentVO4 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile4());
        	AttachmentVO attachmentVO5 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile5());
        	AttachmentVO attachmentVO6 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile6());
        	AttachmentVO attachmentVO7 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile7());
        	AttachmentVO attachmentVO8 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile8());
        	AttachmentVO attachmentVO9 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile9());
        	AttachmentVO attachmentVO10 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile10());

        	//SortTree정보를 이용하여 CateId에 격납하기 위해서, 카테고리 정보를 취득
        	CategoryVO categorySearchVO = new CategoryVO();
        	categorySearchVO.setCateId(productFormVO.getCateId());
        	CategoryVO categoryVO = categoryService.getCategory(categorySearchVO);

        	//ProductFormVO로 부터 받은 정보를 ProductVO에 격납
        	productVO = productFormVO.getProductVO(attachmentVO1,attachmentVO2,attachmentVO3,attachmentVO4,attachmentVO5,
        											attachmentVO6,attachmentVO7,attachmentVO8,attachmentVO9,attachmentVO10);
        	//CateId를 격납
        	productVO.setCateId(String.valueOf(categoryVO.getCateId()));

        	productVO.setOptId(productFormVO.getOptId());
        	productVO.setOptName(productFormVO.getOptName());
        	productVO.setOptPrice(productFormVO.getOptPrice());

        	//상품 정보 등록
    	    int productKey = productService.addProduct(productVO);

    	    if ( LOG.isDebugEnabled() ) {
                LOG.debug("productKey : " + productKey);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ModelAndView("redirect:productList.do?sortTree="+productFormVO.getSortTree());
    }

    /**
     * 상품 정보 수정.
     * @param request
     * @param response
     * @param productVO
     * @return
     */
    @RequestMapping("productModify")
    public ModelAndView modifyProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductFormVO productFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyProduct' controller...");
        }

        ProductVO productVO = null;
        try{
        	//등록- 현재 리스트 1개 상세 5개만 사용 하도록 되어 있으나 추가 확장의 용이성을 생각하여 최대 10개까지 업로드 가능하고 jsp에서만 추가
        	AttachmentVO attachmentVO1 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile1());
        	AttachmentVO attachmentVO2 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile2());
        	AttachmentVO attachmentVO3 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile3());
        	AttachmentVO attachmentVO4 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile4());
        	AttachmentVO attachmentVO5 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile5());
        	AttachmentVO attachmentVO6 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile6());
        	AttachmentVO attachmentVO7 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile7());
        	AttachmentVO attachmentVO8 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile8());
        	AttachmentVO attachmentVO9 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile9());
        	AttachmentVO attachmentVO10 = attachmentProcessor.upload(Constants.SERVICE_ID_PRODUCTS, productFormVO.getUplodeFile10());

        	//SortTree정보를 이용하여 CateId에 격납하기 위해서, 카테고리 정보를 취득
        	CategoryVO categorySearchVO = new CategoryVO();
        	categorySearchVO.setCateId(productFormVO.getCateId());
        	CategoryVO categoryVO = categoryService.getCategory(categorySearchVO);

        	//ProductFormVO로 부터 받은 정보를 ProductVO에 격납
        	productVO = productFormVO.getProductVO(attachmentVO1,attachmentVO2,attachmentVO3,attachmentVO4,attachmentVO5,
        											attachmentVO6,attachmentVO7,attachmentVO8,attachmentVO9,attachmentVO10);

        	//CateId를 격납
        	productVO.setCateId(String.valueOf(categoryVO.getCateId()));

        	productVO.setOldOptId(productFormVO.getOldOptId());
        	productVO.setOptId(productFormVO.getOptId());
        	productVO.setOptName(productFormVO.getOptName());
        	productVO.setOptPrice(productFormVO.getOptPrice());

            //상품 정보 수정
            int updateCount = productService.modifyProduct(productVO);

            if ( LOG.isDebugEnabled() ) {
                LOG.debug("updateCount : " + updateCount);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ModelAndView("redirect:productList.do?sortTree="+productFormVO.getSortTree());
    }

    /**
     * 상품 정보 상태 수정.
     * @param request
     * @param response
     * @param productVO
     * @return
     */
    @RequestMapping("productStatus")
    public ModelAndView modifyProductStatus(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductVO productVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyProductStatus' controller...");
        }
        //상품 정보 상태 수정
        int updateCount = productService.modifyProductStatus(productVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("updateCount", updateCount);

        return mav;
    }

    /**
     * 상품 정보 삭제
     * @param request
     * @param response
     * @param productVO
     * @return
     */
    @RequestMapping("productRemove")
    public ModelAndView removeProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeProduct' controller...");
        }
        ProductVO productVO = productService.getProduct(productSearchVO);

        //상품 정보 삭제
        productService.removeProduct(productVO);

        return new ModelAndView("redirect:productList.do");
    }

	@RequestMapping("productOptStatus")
	public ModelAndView productOptStatus(HttpServletRequest request,
			HttpServletResponse response,
			ProductOptVO productOptVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'productOptStatus' controller...");
		}

		int updateCede = productService.modifyProductOptStatus(productOptVO);

		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("updateCede", updateCede);

		return mav;

	}
}
