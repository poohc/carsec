package com.pama.front.controller;

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

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.common.Constants;
import com.pama.common.util.SecurityUtil;
import com.pama.common.util.SessionUtil;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountFormVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsLicenseVO;
import com.pama.ord.vo.ProductsListVO;
import com.pama.ord.vo.ProductsVO;

@Controller
@RequestMapping("/mbr/mypage/*")
public class FrontMyPageController {
    private static final Log LOG = LogFactory.getLog(FrontMyPageController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private BoardService boardService;

    /**
     * 나의 주문 목록
     * @param request
     * @param response
     * @param orderSearchVO
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("myOrderList")
    public ModelAndView getList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO) throws NoSuchAlgorithmException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getList' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/myOrderList");

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }
        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setEndDateType("1"); //이용기간내 목록 가져오기
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        mav.addObject("orderListVO", orderListVO);
        mav.addObject("loginEmail", loginEmail);
        mav.addObject("loginPwd", SecurityUtil.md5enc(loginEmail.split("@")[0]));
        mav.addObject("loginName", loginName);
        mav.addObject("loginGender", loginGender);

        return mav;
    }
    
    @RequestMapping("couponList")
    public ModelAndView getCouponList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCouponList' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        String statusTypes[] = { "10", "11" };
        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setStatusTypes(statusTypes);
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("front/mypage/coupon1");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }
    
    @RequestMapping("couponEndList")
    public ModelAndView getCouponEndList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCouponEndList' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setStatusType(20);
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("front/mypage/coupon1_end");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }
    
    @RequestMapping("couponReturnList")
    public ModelAndView couponReturnList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'couponReturnList' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setStatusType(90);
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("front/mypage/coupon1_return");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }
    
    @RequestMapping("couponAgencyList")
    public ModelAndView couponAgencyList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'couponAgencyList' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        orderSearchVO.setComp(loginId);
        orderSearchVO.setStatusType(11);
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("front/mypage/coupon1_agency");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    }   
    
    @RequestMapping("couponAgencyEndList")
    public ModelAndView couponAgencyEndList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'couponAgencyEndList' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        String statusTypes[] = { "10", "11", "20" };
        orderSearchVO.setComp(loginId);
        orderSearchVO.setStatusTypes(statusTypes);
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("front/mypage/coupon1_agencyend");
        mav.addObject("orderListVO", orderListVO);

        return mav;
    } 
    
    @RequestMapping("couponUseProc")
    public ModelAndView couponUseProc(HttpServletRequest request,
            HttpServletResponse response,
            InfoVO infoVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'couponUseProc' controller...");
        }
        
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        LOG.debug(infoVO.getOrdId()+"=======================");
        if  (StringUtils.isNotEmpty(infoVO.getOrdId())){
        	infoVO.setStatusType(20);
        	infoVO.setUpdateId(loginId);
        	infoVO.setUpdateIp(request.getRemoteAddr());
            int row = orderService.modifyOrderStatusType(infoVO);
        }

        return new ModelAndView("redirect:/mbr/mypage/couponAgencyList.do");

    }

    /**
     * 나의 주문 목록
     * @param request
     * @param response
     * @param orderSearchVO
     * @return
     */
    @RequestMapping("myOrderFinishList")
    public ModelAndView getFinishList(HttpServletRequest request,
                                HttpServletResponse response,
                                OrderSearchVO orderSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getList' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/myOrderFinishList");

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }
        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setEndDateType("2"); //이용기간외 목록 가져오기
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        mav.addObject("orderListVO", orderListVO);
        mav.addObject("loginEmail", loginEmail);
        mav.addObject("loginName", loginName);
        mav.addObject("loginGender", loginGender);

        return mav;
    }

    @RequestMapping("myStudyInfo")
    public ModelAndView getStudyInfo(HttpServletRequest request,
            HttpServletResponse response,
            AccountVO accountVO) throws NoSuchAlgorithmException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getStudyInfo' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = "not login is unauthorized value";
        String loginName = "";
        String loginEmail = "";
        String loginGender = "";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            loginEmail = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getEmail();
            loginName = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMemberNm();  //
            loginGender = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getGender();
        }

        OrderSearchVO orderSearchVO = new OrderSearchVO();
        orderSearchVO.setRegisterId(loginId);
        orderSearchVO.setEndDateType("1"); //이용기간외 목록 가져오기
        ProductsListVO productsListVO = orderService.getOrderLicenseList(orderSearchVO);

        ProductsLicenseVO productLicenseVO = new ProductsLicenseVO();

        productLicenseVO.setFirstName(loginName);
        productLicenseVO.setEmail(loginEmail);
        productLicenseVO.setGender(loginGender);
        productLicenseVO.setPassword(SecurityUtil.md5enc(loginEmail.split("@")[0]));

        if ("".equals(productLicenseVO.getFirstName())) productLicenseVO.setFirstName(productLicenseVO.getLastName());

        if (productsListVO.getOrderSearchVO().getTotalCount() == 1) {
	        for (ProductsVO productsVO : productsListVO.getProductsList()) {
	        	productLicenseVO.setLicenseCode(productsVO.getLicenseCode());
	        	productLicenseVO.setCateId(productsVO.getCateId());
	        }
        }

        productLicenseVO.setTotalCount(productsListVO.getOrderSearchVO().getTotalCount());

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("license", productLicenseVO);

        return mav;

    }

    @RequestMapping("messageList")
    public ModelAndView getMessageList(HttpServletRequest request,
                                HttpServletResponse response,
                                MessageSearchVO messageSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getMessageList' controller...");
        }

        BoardVO boardVO = boardService.getBoard(messageSearchVO.getBoardId());

        messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));

        if ("1".equals(boardVO.getTopMessageFlag())) {
            messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());	//공지사항 사용여부 셋팅
        }

        messageSearchVO.setConsultFlag(boardVO.getConsultFlag());  // 게시판 상담기능 사용 체크

        messageSearchVO.setRow(Integer.parseInt(boardVO.getListLines())); //listLines
        messageSearchVO.setEndIndex(messageSearchVO.getStartIndex() + Integer.parseInt(boardVO.getListLines()));   // 리스트 갯수 셋팅
        MessageListVO messageList = messageService.getMessageList(messageSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardVO);
        mav.addObject("messageList", messageList);
        mav.setViewName("/front/mypage/"+boardVO.getBoardKey()+"List");

        return mav;
    }

    @RequestMapping("messageDetail")
    public ModelAndView getMessage(HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getMessage' controller...");
        }
        BoardVO boardVO = boardService.getBoard(messageSearchVO.getBoardId());

        MessageVO messageInfoVO = messageService.getMessageOne(messageSearchVO);

        ModelAndView mav = new ModelAndView();

        if ("1".equals(boardVO.getConsultFlag())) {
            MessageListVO messageList = messageService.getMessageLevelList(messageSearchVO);
            mav.addObject("messageList", messageList);
        }

        mav.addObject("boardVO", boardVO);
        mav.addObject("messageVO", messageInfoVO);
        mav.setViewName("/front/mypage/"+boardVO.getBoardKey()+"Detail");

        return mav;
    }

    /**
     * 주문 상세
     * @param request
     * @param response
     * @param infoVO
     * @return
     */
    @RequestMapping("myOrderDetail")
    public ModelAndView orderComplete(HttpServletRequest request,
            HttpServletResponse response,
            InfoVO infoVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'myOrderDetail' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/myOrderDetail");

        //ordId 가 넘어왔을때만 실행
        if  (StringUtils.isNotEmpty(infoVO.getOrdId())){
            OrderVO orderInfoVO = orderService.getOrder(infoVO);
            mav.addObject("orderVO", orderInfoVO);
        }
        return mav;
    }

    /**
     * 회원수정  폼
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountModifyForm")
    public ModelAndView accountForm(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountModifyForm' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = "not login is unauthorized value";
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
        }

        ModelAndView mav = new ModelAndView("front/mypage/accountModifyForm");

        accountVO.setMbrId(loginId);
        AccountVO accountInfoVO = accountService.getAccount(accountVO);
        mav.addObject("accountFormVO", accountInfoVO);

        return mav;
    }

    /**
     * 회원수정
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
     @RequestMapping("accountModifyFormProc")
     public ModelAndView accountFormProc(HttpServletRequest request,
             HttpServletResponse response,
             AccountVO accountVO){
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("starting 'accountModifyFormProc' controller...");
         }

         if  (StringUtils.isNotEmpty(accountVO.getMbrId())){
             accountVO.setStatusType(Constants.MBR_ACCOUNT_STATUS_TYPE);
             accountVO.setUpdateIp(request.getRemoteAddr());
             int row = accountService.modifyAccount(accountVO);
         }

         return new ModelAndView("redirect:/mypage/accountModifyForm.do");

     }

     /**
      * 회원 탈퇴 Form
      * @param request
      * @param response
      * @param accountVO
      * @return
      */
      @RequestMapping("accountRemoveForm")
      public ModelAndView removeAccountForm(HttpServletRequest request,
              HttpServletResponse response,
              AccountVO accountVO){
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'removeAccountForm' controller...");
          }

          //-----------------------------------------------------------------------------
          // 로그인 정보
          //-----------------------------------------------------------------------------
          String loginId = "not login is unauthorized value";
          if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
              loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
          }

          ModelAndView mav = new ModelAndView("front/mypage/accountRemoveForm");
          mav.addObject("loginId", loginId);

          return mav;

      }

     /**
      * 회원 탈퇴
      * @param request
      * @param response
      * @param accountVO
      * @return
      */
      @RequestMapping("accountRemoveFormProc")
      public ModelAndView removeAccountFormProc(HttpServletRequest request,
              HttpServletResponse response,
              AccountVO accountVO){
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'removeAccountFormProc' controller...");
          }

          if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
	           accountVO.setMbrId(SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId());
	           AccountVO loginAccountInfoVO = accountService.getAccountLogin(accountVO);  //로그인 시도

	           if (loginAccountInfoVO != null) {
	               accountVO.setUpdateIp(request.getRemoteAddr());
	               int row = accountService.removeAccount(accountVO);
	               SessionUtil.removeSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request); // 로그아웃
	           }  else {
	        	   return new ModelAndView("redirect:/mypage/accountRemoveForm.do?error=300");
	           }
          }

          return new ModelAndView("redirect:/web/main.do");
      }

      /**
       * 비밀번호 변경 Form
       * @param request
       * @param response
       * @param accountVO
       * @return
       */
       @RequestMapping("accountModifyPwdForm")
       public String accountModifyPwdForm(HttpServletRequest request,
               HttpServletResponse response,
               AccountFormVO accountFormVO){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'accountModifyPwdForm' controller...");
           }

           return "front/mypage/accountModifyPwdForm";

       }

       /**
        * 비밀번호 변경
        * @param request
        * @param response
        * @param accountVO
        * @return
        */
        @RequestMapping("accountModifyPwdFormProc")
        public ModelAndView accountModifyPwdFormProc(HttpServletRequest request,
                HttpServletResponse response,
                AccountFormVO accountFormVO){
            if ( LOG.isDebugEnabled() ) {
                LOG.debug("starting 'accountModifyPwdFormProc' controller...");
            }

            //-----------------------------------------------------------------------------
            // 로그인 정보
            //-----------------------------------------------------------------------------
            String loginId = "not login is unauthorized value";
            if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
                loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  // 로그인된 아이디
            }

            AccountVO accountParamVO = new AccountVO();

            accountParamVO.setMbrId(loginId);
            accountParamVO.setPwd(accountFormVO.getPwd());
            //비밀번호 확인
            String pwd = accountService.getAccountPwdChk(accountParamVO); // DB에 있는 비밀번호
            int updateCount = 0;

            if (StringUtils.isNotEmpty(pwd)){  // 비밀번호가 확인 되었으면

                // 비밀번호 암호화 및 업데이트
                accountParamVO.setUpdateIp(request.getRemoteAddr());
                accountParamVO.setPwd(accountFormVO.getModifyPwd());
                updateCount = accountService.modifyPwd(accountParamVO);  // 변경된 비밀번호 업데이트

            }

            if(updateCount > 0) { // 비밀번호가 업데이트 되었다면
                return new ModelAndView("redirect:/mypage/accountModifyPwdForm.do?mode=200");  // 성공
            }else{
                return new ModelAndView("redirect:/mypage/accountModifyPwdForm.do?mode=100"); // 실패
            }

        }
}
