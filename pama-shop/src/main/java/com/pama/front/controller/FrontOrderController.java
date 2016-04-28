package com.pama.front.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
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
import com.pama.common.util.SecurityUtil;
import com.pama.common.util.SessionUtil;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;
import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsVO;
import com.pama.prd.service.CategoryService;
import com.pama.prd.service.ProductLicenseService;
import com.pama.prd.service.ProductService;
import com.pama.prd.service.StatisticsService;
import com.pama.prd.vo.ProductLicenseVO;
import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.StatisticsVO;

@Controller
@RequestMapping("/ord/*")
public class FrontOrderController {
    private static final Log LOG = LogFactory.getLog(FrontOrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * Service 생성
     */
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticsService statisticsService;

    /**
     * Service 생성
     */
    @Autowired
    private ProductLicenseService productLicenseService;

    /**
     * 주문 Form
     * @param request
     * @param response
     * @param orderVO
     * @return
     */
    @RequestMapping("orderForm")
    public ModelAndView getOrderForm(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderVO orderVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrderForm' controller...");
        }

        ModelAndView mav = new ModelAndView("front/ord/orderForm");

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //CategoryVO categoryVO = new CategoryVO();
        //categoryVO.setCateId(orderVO.getCartId());
        //categoryVO = categoryService.getCategory(categoryVO);

        //mav.addObject("categoryVO", categoryVO);

        //ProductSearchVO productSearchVO = new ProductSearchVO();
        //productSearchVO.setCateId(orderVO.getCateId());

        //ProductListVO productListVO  = productService.getProductOnList(productSearchVO);

        //mav.addObject("productListVO", productListVO);

        //-----------------------------------------------------------------------------
        // 장바구니 조회 & 즉시구매시는 상품 조회
        //-----------------------------------------------------------------------------
        CartProductsVO cartProductsparameVO = new CartProductsVO();
        cartProductsparameVO.setPrdId(orderVO.getPrdId()); // prdId 가 넘어왔을때는 즉시구매로 상품을 조회한다.
        cartProductsparameVO.setQty(orderVO.getQty());
        cartProductsparameVO.setRegisterId(loginId);
        cartProductsparameVO.setOptId(orderVO.getOptId());
        CartProductsListVO cartProductsListVO = orderService.getOrderProductsForm(cartProductsparameVO);
        mav.addObject("cartProductsListVO", cartProductsListVO);
        
        //-----------------------------------------------------------------------------
        // 현재 로그인한 사용자의 정보 (session 에서 처리하려면 sessionVO 에 주소등 추가하여야함.
        // 일단은 DB에서 가져오는 것으로 처리.
        //-----------------------------------------------------------------------------
        // 현재 로그인된 고객의 ID가 있을때만 실행
        if  (StringUtils.isNotEmpty(loginId)){
            AccountVO accountParamVO = new AccountVO();
            accountParamVO.setMbrId(loginId);
            AccountVO accountVO = accountService.getAccount(accountParamVO);
            mav.addObject("accountFormVO", accountVO);
        }

        return mav;
    }

    @RequestMapping("astart")
    public ModelAndView astart(HttpServletRequest request,
            HttpServletResponse response,
            OrderVO orderVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'astart' controller...");
        }
        ModelAndView mav = new ModelAndView("front/ord/orderAorm");

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //CategoryVO categoryVO = new CategoryVO();
        //categoryVO.setCateId(orderVO.getCartId());
        //categoryVO = categoryService.getCategory(categoryVO);

        //mav.addObject("categoryVO", categoryVO);

        ProductSearchVO productSearchVO = new ProductSearchVO();
        productSearchVO.setCateId(orderVO.getCateId());

        ProductListVO productListVO  = productService.getProductCategoryList(productSearchVO);

        mav.addObject("productListVO", productListVO);

        //-----------------------------------------------------------------------------
        // 장바구니 조회 & 즉시구매시는 상품 조회
        //-----------------------------------------------------------------------------
        CartProductsVO cartProductsparameVO = new CartProductsVO();
        cartProductsparameVO.setPrdId(orderVO.getPrdId()); // prdId 가 넘어왔을때는 즉시구매로 상품을 조회한다.
        cartProductsparameVO.setQty(orderVO.getQty());
        cartProductsparameVO.setRegisterId(loginId);
        CartProductsListVO cartProductsListVO = orderService.getOrderProductsForm(cartProductsparameVO);
        mav.addObject("cartProductsListVO", cartProductsListVO);

        //-----------------------------------------------------------------------------
        // 현재 로그인한 사용자의 정보 (session 에서 처리하려면 sessionVO 에 주소등 추가하여야함.
        // 일단은 DB에서 가져오는 것으로 처리.
        //-----------------------------------------------------------------------------
        // 현재 로그인된 고객의 ID가 있을때만 실행
        if  (StringUtils.isNotEmpty(loginId)){
            AccountVO accountParamVO = new AccountVO();
            accountParamVO.setMbrId(loginId);
            AccountVO accountVO = accountService.getAccount(accountParamVO);
            mav.addObject("accountFormVO", accountVO);
        }

        return mav;
    }

    /**
     * 주문
     * @param request
     * @param response
     * @param orderVO
     * @return
     */
    @RequestMapping("orderFromProc")
    public ModelAndView addOrderProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderVO orderVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrderForm' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //-----------------------------------------------------------------------------
        // 주문등록
        //-----------------------------------------------------------------------------
        orderVO.setRegisterId(loginId);
        orderVO.setRegisterIp(request.getRemoteAddr());
        orderVO.setUpdateId(loginId);
        orderVO.setStatusType(10); // 무통장 입금대기
        orderVO.setUpdateIp(request.getRemoteAddr());
        String ordId = orderService.addOrderProduct(orderVO);

        //-----------------------------------------------------------------------------
        // 주문 상품 통계 등록
        //-----------------------------------------------------------------------------
        StatisticsVO statisticsVO = new StatisticsVO();

        if (StringUtils.isNotEmpty(orderVO.getCartId())){  //CartId가 넘어 왔다면 장바구니 구매

            ProductsVO productsVO = new ProductsVO();

            productsVO.setOrdId(orderVO.getCartId());
            List<ProductsVO> orderProductsVOList = orderService.getProductsList(productsVO);

            for (ProductsVO productsList : orderProductsVOList) {   // 장바구니에서 구매한 모든 상품을 등록
                statisticsVO.setPrdId(productsList.getPrdId());
                statisticsService.addProductStatistics(statisticsVO);
            }
        }else { // 즉시구매 상품 한개만 등록
            statisticsVO.setPrdId(orderVO.getPrdId());
            statisticsService.addProductStatistics(statisticsVO);
        }

        return new ModelAndView("redirect:orderComplete.do?ordId=" + ordId);
    }

    /**
     * 주문(카드결제)
     * @param request
     * @param response
     * @param orderVO
     * @return
     */
    @RequestMapping("orderFromPayProc")
    public ModelAndView addOrderProductPay(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderVO orderVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addOrderProductPay' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        /**************************************************************************************************************/
        String goodCode=request.getParameter("goodCode");
        String goodNm=request.getParameter("GoodNm");
        String custId=request.getParameter("CustId");
        String custNm=request.getParameter("CustNm");
        String custEmail=request.getParameter("CustEmail");
        String custPhone1=request.getParameter("CustPhone1");
        String custPhone2=request.getParameter("CustPhone2");
        String custAddress=request.getParameter("CustAddress");
        String custMemo=request.getParameter("CustMemo");

        //-----------------------------------------------------------------------------
        // 주문등록
        //-----------------------------------------------------------------------------
        orderVO.setRegisterId(loginId);
        orderVO.setRegisterIp(request.getRemoteAddr());
        orderVO.setUpdateId(loginId);
        orderVO.setStatusType(11); // 결제완료
        orderVO.setUpdateIp(request.getRemoteAddr());
        String ordId = orderService.addOrderProduct(orderVO);

        //-----------------------------------------------------------------------------
        // 주문 상품 통계 등록
        //-----------------------------------------------------------------------------
        StatisticsVO statisticsVO = new StatisticsVO();

        if (StringUtils.isNotEmpty(orderVO.getCartId())){  //CartId가 넘어 왔다면 장바구니 구매

            ProductsVO productsVO = new ProductsVO();

            productsVO.setOrdId(orderVO.getCartId());
            List<ProductsVO> orderProductsVOList = orderService.getProductsList(productsVO);

            for (ProductsVO productsList : orderProductsVOList) {   // 장바구니에서 구매한 모든 상품을 등록
                statisticsVO.setPrdId(productsList.getPrdId());
                statisticsService.addProductStatistics(statisticsVO);
            }
        }else { // 즉시구매 상품 한개만 등록
            statisticsVO.setPrdId(orderVO.getPrdId());
            statisticsService.addProductStatistics(statisticsVO);
        }

        InfoVO infoVO = new InfoVO();

        infoVO.setOrdId(orderVO.getOrdId());
        infoVO.setUpdateId(loginId);
        infoVO.setUpdateIp(request.getRemoteAddr());

        OrderVO orderInfoVO = orderService.getOrder(infoVO);
        for (Iterator<?> iterator = orderInfoVO.getProductsVO().iterator(); iterator.hasNext();) {
     	   ProductsVO productsVO = (ProductsVO)iterator.next();

     	   String licenseCode = productLicenseService.getProductLicensePublish(productsVO.getPrdId());

     	   productsVO.setLicenseCode(licenseCode);
     	   orderService.modifyProductsLicense(productsVO);

     	   ProductLicenseVO productLicenseVO = new ProductLicenseVO();
     	   productLicenseVO.setLicenseCode(licenseCode);
     	   productLicenseVO.setLicensePublishType("2");
     	   productLicenseService.modifyProductLicensePublish(productLicenseVO);
        }

        return new ModelAndView("redirect:orderComplete.do?ordId=" + ordId);
//        return new ModelAndView("redirect:orderError.do");

    }

    /**
     * 주문 완료
     * @param request
     * @param response
     * @param infoVO
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("orderComplete")
    public ModelAndView orderComplete(HttpServletRequest request,
            HttpServletResponse response,
            InfoVO infoVO) throws NoSuchAlgorithmException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'orderComplete' controller...");
        }

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

        ModelAndView mav = new ModelAndView("front/ord/orderComplete");

        //ordId 가 넘어왔을때만 실행
        if  (StringUtils.isNotEmpty(infoVO.getOrdId())){
            OrderVO orderInfoVO = orderService.getOrder(infoVO);
            mav.addObject("orderVO", orderInfoVO);

            if(!"".equals(loginEmail)) {
    	        mav.addObject("loginEmail", loginEmail);
    	        mav.addObject("loginPwd", SecurityUtil.md5enc(loginEmail.split("@")[0]));
    	        mav.addObject("loginName", loginName);
    	        mav.addObject("loginGender", loginGender);
            }
        }
        return mav;
    }

}
