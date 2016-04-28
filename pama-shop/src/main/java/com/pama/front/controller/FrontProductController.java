package com.pama.front.controller;

import java.security.NoSuchAlgorithmException;
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

import com.pama.admin.prd.controller.ProductController;
import com.pama.common.Constants;
import com.pama.common.util.SecurityUtil;
import com.pama.common.util.SessionUtil;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.ProductsVO;
import com.pama.prd.service.CategoryService;
import com.pama.prd.service.ProductService;
import com.pama.prd.vo.CategoryVO;
import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;

@Controller
@RequestMapping("/prd/*")
public class FrontProductController {

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

    @Autowired
    private OrderService orderService;

    /**
     * 상품 정보 리스트 취득.
     * @param request
     * @param response
     * @param productSearchVO
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("productList")
    public ModelAndView getProductList(HttpServletRequest request,
                                HttpServletResponse response,
                                ProductSearchVO productSearchVO) throws NoSuchAlgorithmException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductList' controller...");
        }

        //String bigSortTree = "";

        //왼쪽 카테고리, 상단 인기 상품은 대분류에서만 값을 취득하여 검색
        //if(StringUtils.isNotEmpty(productSearchVO.getSortTree()) && productSearchVO.getSortTree().length() >= 2){
        //    bigSortTree = productSearchVO.getSortTree().substring(0, 2);
        //}


        //해당 카테고리 정보 격납
        //CategoryVO categoryVO = new CategoryVO();
        //categoryVO.setSortTree(bigSortTree);
        //categoryVO.setCateId(productSearchVO.getCateId());
        //카테고리 리스트 박스 정보
        //List<CategoryVO> categoryListBox = categoryService.getCategoryList(categoryVO);


        //인기 상품 정보 격납
        //ProductSearchVO bestProductSearchVO = new ProductSearchVO();
        //bestProductSearchVO.setRow(5);//5개 출력
        //bestProductSearchVO.setSortDirection(0);
        //bestProductSearchVO.setSortColumn("STATISTICS_COUNT");//카운트 순으로 출력
        //bestProductSearchVO.setStatusType(Constants.PRODUCT_STATE_TYPE_VIEW);//공개 데이터만 출력
        //bestProductSearchVO.setSortTree(bigSortTree);
        //인기 상품 정보 리스트
        //ProductListVO bestProductListVO = productService.getBestProductList(bestProductSearchVO);

        ModelAndView mav = new ModelAndView("front/prd/productList");
        //상품 정보 격납
        productSearchVO.setStatusType(Constants.PRODUCT_STATE_TYPE_VIEW);//공개 데이터만 출력
        //인기 상품의 경우(격납이 다른 이유는 Quarry의 가독성과 간결함을 위해서 따로 배치)
        //if(productSearchVO.getSortTab().equals(Constants.PRODUCT_SORT_TAB_BEST)){
            //인기 상품 정보 리스트
        //    productListVO = productService.getBestProductList(productSearchVO);
        //}else{
            //상품 정보 리스트
        if (productSearchVO.getSortTree().equals("10")) {
        	productSearchVO.setCateId("2"); // 엔진오일
        	ProductListVO productListVO1 = productService.getProductList(productSearchVO);
            mav.addObject("productList1", productListVO1);

        	productSearchVO.setCateId("3"); // 미션오일
        	ProductListVO productListVO2 = productService.getProductList(productSearchVO);
            mav.addObject("productList2", productListVO2);
            
        	productSearchVO.setCateId("4"); // 엔진정비
        	ProductListVO productListVO3 = productService.getProductList(productSearchVO);
            mav.addObject("productList3", productListVO3);
            
        	productSearchVO.setCateId("5"); // 브레이크오일
        	ProductListVO productListVO4 = productService.getProductList(productSearchVO);
            mav.addObject("productList4", productListVO4);
            
        	productSearchVO.setCateId("6"); // 벨트관련
        	ProductListVO productListVO5 = productService.getProductList(productSearchVO);
            mav.addObject("productList5", productListVO5);
            
        	productSearchVO.setCateId("7"); // 하체부품관련
        	ProductListVO productListVO6 = productService.getProductList(productSearchVO);
            mav.addObject("productList6", productListVO6);
            
        	productSearchVO.setCateId("8"); // 타이밍 벨트
        	ProductListVO productListVO7 = productService.getProductList(productSearchVO);
            mav.addObject("productList7", productListVO7);
        } else if (productSearchVO.getSortTree().equals("20")) {
        	productSearchVO.setCateId("9"); // 엔진오일
        	ProductListVO productListVO1 = productService.getProductList(productSearchVO);
            mav.addObject("productList1", productListVO1);

        	productSearchVO.setCateId("10"); // 미션오일
        	ProductListVO productListVO2 = productService.getProductList(productSearchVO);
            mav.addObject("productList2", productListVO2);
            
        	productSearchVO.setCateId("11"); // 엔진정비
        	ProductListVO productListVO3 = productService.getProductList(productSearchVO);
            mav.addObject("productList3", productListVO3);
            
        	productSearchVO.setCateId("12"); // 브레이크오일
        	ProductListVO productListVO4 = productService.getProductList(productSearchVO);
            mav.addObject("productList4", productListVO4);
            
        	productSearchVO.setCateId("13"); // 벨트관련
        	ProductListVO productListVO5 = productService.getProductList(productSearchVO);
            mav.addObject("productList5", productListVO5);
            
        	productSearchVO.setCateId("14"); // 하체부품관련
        	ProductListVO productListVO6 = productService.getProductList(productSearchVO);
            mav.addObject("productList6", productListVO6);
            
        	productSearchVO.setCateId("15"); // 타이밍 벨트
        	ProductListVO productListVO7 = productService.getProductList(productSearchVO);
            mav.addObject("productList7", productListVO7);        	
        } else if (productSearchVO.getSortTree().equals("30")) {
        	productSearchVO.setCateId("16"); // 엔진오일
        	ProductListVO productListVO1 = productService.getProductList(productSearchVO);
            mav.addObject("productList1", productListVO1);

        	productSearchVO.setCateId("17"); // 미션오일
        	ProductListVO productListVO2 = productService.getProductList(productSearchVO);
            mav.addObject("productList2", productListVO2);
            
        	productSearchVO.setCateId("18"); // 엔진정비
        	ProductListVO productListVO3 = productService.getProductList(productSearchVO);
            mav.addObject("productList3", productListVO3);
            
        	productSearchVO.setCateId("19"); // 브레이크오일
        	ProductListVO productListVO4 = productService.getProductList(productSearchVO);
            mav.addObject("productList4", productListVO4);
            
        	productSearchVO.setCateId("20"); // 벨트관련
        	ProductListVO productListVO5 = productService.getProductList(productSearchVO);
            mav.addObject("productList5", productListVO5);
            
        	productSearchVO.setCateId("21"); // 하체부품관련
        	ProductListVO productListVO6 = productService.getProductList(productSearchVO);
            mav.addObject("productList6", productListVO6);
            
        	productSearchVO.setCateId("22"); // 타이밍 벨트
        	ProductListVO productListVO7 = productService.getProductList(productSearchVO);
            mav.addObject("productList7", productListVO7);        	
        }
        //}

        ProductsVO productsVO = new ProductsVO();

        String loginId = ""; // 로그인된 아이디
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        productsVO.setRegisterId(loginId);
        //productsVO.setCateId(productSearchVO.getCateId());
        //for (ProductVO productVO : productListVO.getProductList()) {
        	//productsVO.setPrdId(productVO.getPrdId());
        //}
        //ProductsVO productsLicenseVO = orderService.getProductsLicense(productsVO);

//        categoryVO.setCateId(productSearchVO.getCateId());
//        CategoryVO categoryVO2= categoryService.getCategory(categoryVO);


        mav.addObject("productSearchVO", productSearchVO);

        //mav.addObject("licenseVO", productsLicenseVO);
        //mav.addObject("bestProductListVO", bestProductListVO);
        //mav.addObject("categoryListBox", categoryListBox);
//        mav.addObject("category", categoryVO2);
        if(!"".equals(loginEmail)) {
	        mav.addObject("loginEmail", loginEmail);
//	        mav.addObject("loginPwd", SecurityUtil.md5enc(loginEmail.split("@")[0]));
	        mav.addObject("loginName", loginName);
	        mav.addObject("loginGender", loginGender);
        }
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

        String bigSortTree = "";

        //왼쪽 카테고리, 상단 인기 상품은 대분류에서만 값을 취득하여 검색
        //if(StringUtils.isNotEmpty(productSearchVO.getSortTree()) && productSearchVO.getSortTree().length() >= 2){
        //    bigSortTree = productSearchVO.getSortTree().substring(0, 2);
        //}

        //카테고리 정보 격납
        //CategoryVO bigCategoryVO = new CategoryVO();
        //bigCategoryVO.setSortTree(bigSortTree);
        //카테고리 리스트 박스 정보
        //List<CategoryVO> categoryListBox = categoryService.getCategoryList(bigCategoryVO);


        //제품 상세 정보
        ProductVO productVO = productService.getProduct(productSearchVO);

        ProductsVO productsVO = new ProductsVO();

        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        productsVO.setRegisterId(loginId);
        //productsVO.setPrdId(productVO.getPrdId());

        //ProductsVO productsLicenseVO = orderService.getProductsLicense(productsVO);

        //카테고리 정보 격납
        //CategoryVO categoryVO = new CategoryVO();
        //categoryVO.setCateId(productVO.getCateId());//제품 상세 정보에서 취득한 카테고리 ID를 격납
        //해당 카테고리 정보 취득
        //CategoryVO category = categoryService.getCategory(categoryVO);


        ModelAndView mav = new ModelAndView("front/prd/productDetail");
        mav.addObject("productSearchVO", productSearchVO);
        mav.addObject("productVO", productVO);
        //mav.addObject("licenseVO", productsLicenseVO);
        //mav.addObject("categoryVO", category);
        //mav.addObject("categoryListBox", categoryListBox);

        return mav;
    }

    @RequestMapping("product.json")
    public ModelAndView getProductJS(HttpServletRequest request,
                                HttpServletResponse response,
                                String prdId){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getProductJS' controller...");
        }
        //제품 상세 정보
        ProductSearchVO productSearchVO = new ProductSearchVO();
        productSearchVO.setPrdId(prdId);

        ProductVO productVO = productService.getProduct(productSearchVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("productVO", productVO);

        return mav;
    }

}
