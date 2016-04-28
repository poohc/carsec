package com.pama.admin.ord.controller;

import java.security.NoSuchAlgorithmException;

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
import com.pama.common.util.SecurityUtil;
import com.pama.common.util.SessionUtil;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbrpoint.service.PointService;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsVO;

@Controller
@RequestMapping("/admin/ord/*")
public class OrderController {
    private static final Log LOG = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PointService pointService;

    /**
     * 주문목록조회
     * @param request
     * @param response
     * @param orderSearchVO
     * @return
     */
    @RequestMapping("orderList")
    public ModelAndView getList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getList' controller...");
        }

        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }

    /**
     * 주문목록조회 (excel)
     * @param request
     * @param response
     * @param orderSearchVO
     * @return
     */
    @RequestMapping("/excel/orderList")
    public ModelAndView getExcelList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getExcelList' controller...");
        }

        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("admin/ord/excel/orderList");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }

    /**
     * 주문 상세
     * @param request
     * @param response
     * @param infoVO
     * @return
     */
    @RequestMapping("orderDetail")
    public ModelAndView getOrder(HttpServletRequest request,
                                HttpServletResponse response,
                                InfoVO infoVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrder' controller...");
        }

        ModelAndView mav = new ModelAndView();
        OrderVO orderInfoVO = null;

        //ordId 가 넘어왔을때만 실행
        if  (StringUtils.isNotEmpty(infoVO.getOrdId())){
            orderInfoVO = orderService.getOrder(infoVO);
            mav.addObject("orderVO", orderInfoVO);
        }

        return mav;
    }

    /**
     * 주문 상세
     * @param request
     * @param response
     * @param infoVO
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("orderLicenseComplete")
    public ModelAndView getOrderLicenseComplete(HttpServletRequest request,
                                HttpServletResponse response,
                                InfoVO infoVO) throws NoSuchAlgorithmException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrderLicenseComplete' controller...");
        }

        ModelAndView mav = new ModelAndView();
        OrderVO orderInfoVO = null;

        //ordId 가 넘어왔을때만 실행
        if  (StringUtils.isNotEmpty(infoVO.getOrdId())){
            orderInfoVO = orderService.getOrder(infoVO);
            mav.addObject("orderVO", orderInfoVO);

            AccountVO accountVO = new AccountVO();
            accountVO.setMbrId(orderInfoVO.getOrdererId());
            AccountVO accountInfoVO = accountService.getAccount(accountVO);

	        mav.addObject("loginEmail", accountInfoVO.getEmail());
	        mav.addObject("loginPwd", SecurityUtil.md5enc(accountInfoVO.getEmail().split("@")[0]));
	        mav.addObject("loginName", accountInfoVO.getFirstName());
	        mav.addObject("loginGender", accountInfoVO.getGender());
        }

        return mav;
    }

    /**
    * 주문 상태변경
    * @param request
    * @param response
    * @param infoVO
    * @return
    */
   @RequestMapping("modifyOrderStatusType.json")
   public ModelAndView modifyOrderStatusType(HttpServletRequest request,
                                    HttpServletResponse response,
                                     InfoVO infoVO){
       if ( LOG.isDebugEnabled() ) {
           LOG.debug("starting 'modifyOrderStatusType' controller...");
       }

       String admId = "admin";
       // 로그인 정보
       if (SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request) != null){
           admId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
       }

       infoVO.setUpdateId(admId);
       infoVO.setUpdateIp(request.getRemoteAddr());

       int row = orderService.modifyOrderStatusType(infoVO);

       OrderVO orderInfoVO = orderService.getOrder(infoVO);

       for ( ProductsVO products : orderInfoVO.getProductsVO() ) {
           ProductsVO productsVO = new ProductsVO();
           productsVO.setOrdId(products.getOrdId());
           productsVO.setPrdId(products.getPrdId());
           String sortTree = ConvertUtil.getCouponNumber(products.getOrdId());
           productsVO.setLicenseCode(sortTree);
           while (orderService.getLicense(productsVO)!=null) {
        	   sortTree = ConvertUtil.getCouponNumber(products.getOrdId());
        	   productsVO.setLicenseCode(sortTree);
           }
           orderService.modifyProductsLicense(productsVO);
       }

//       String mbrId = orderInfoVO.getRegisterId();
//       int point = orderInfoVO.getSettlePrice();
//       String pointTitle = "쿠폰발급";
//
//       pointService.trxChargingPoint(mbrId , point, pointTitle, admId, request.getRemoteAddr());

       //포인트

//       for (Iterator<?> iterator = orderInfoVO.getProductsVO().iterator(); iterator.hasNext();) {
//    	   ProductsVO productsVO = (ProductsVO)iterator.next();
//
//    	   String licenseCode = productLicenseService.getProductLicensePublish(productsVO.getPrdId());
//
//    	   productsVO.setLicenseCode(licenseCode);
//    	   orderService.modifyProductsLicense(productsVO);
//
//    	   ProductLicenseVO productLicenseVO = new ProductLicenseVO();
//    	   productLicenseVO.setLicenseCode(licenseCode);
//    	   productLicenseVO.setLicensePublishType("2");
//    	   productLicenseService.modifyProductLicensePublish(productLicenseVO);
//       }

       ModelAndView mav = new ModelAndView("jsonView");

       if (row > 0){
           mav.addObject("result", "success");
       }else{
           mav.addObject("result", "error");
       }

       return mav;
   }

   /**
   * 주문 삭제
   * @param request
   * @param response
   * @param infoVO
   * @return
   */
   @RequestMapping("orderRemoveProc")
   public ModelAndView removeAccount(HttpServletRequest request,
           HttpServletResponse response,
           InfoVO infoVO){
       if ( LOG.isDebugEnabled() ) {
           LOG.debug("starting 'removeAccount' controller...");
       }

       String mbrId = "admin";
       // 로그인 정보
       if (SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request) != null){
           mbrId = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request).getMbrId();
       }

       infoVO.setUpdateId(mbrId);
       infoVO.setUpdateIp(request.getRemoteAddr());
       infoVO.setStatusType(90);
       orderService.modifyOrderRemove(infoVO);

       return new ModelAndView("redirect:orderList.do");

   }

}
