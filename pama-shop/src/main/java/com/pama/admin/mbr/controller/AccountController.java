package com.pama.admin.mbr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.common.Constants;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountFormVO;
import com.pama.mbr.vo.AccountListVO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.processor.MailSendProcessor;
import com.pama.processor.vo.SendMailVO;

@Controller
@RequestMapping("/admin/account/*")
public class AccountController {

    private static final Log LOG = LogFactory.getLog(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private MailSendProcessor mailSendProcessor;

    @Autowired
    private OrderService orderService;

    /**
     * Account Type별 회원 리스트
     * @param accountType
     * @param request
     * @param response
     * @param accountSearchVO
     * @return
     */
    @RequestMapping("{accountType}/{statusVal}list")
    public ModelAndView getList(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountSearchVO accountSearchVO){

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountList' controller...");
        }

        /*
         * 각 회원 구분
         */
        if( StringUtils.equals(Constants.MBR_ACCOUNT_INDIVIDUAL, accountType) ){
        	accountSearchVO.setLevel(String.valueOf(Constants.MBR_ACCOUNT_LEVEL_INDIVIDUAL));
        } else if( StringUtils.equals(Constants.MBR_ACCOUNT_BUSINESS, accountType) ){
        	String[] levels = {String.valueOf(Constants.MBR_ACCOUNT_LEVEL_BUSINESS_A),String.valueOf(Constants.MBR_ACCOUNT_LEVEL_BUSINESS_B)};
        	accountSearchVO.setLevels(levels);
        } else if( StringUtils.equals(Constants.MBR_ACCOUNT_ADMIN, accountType) ){
        	accountSearchVO.setLevel(String.valueOf(Constants.MBR_ACCOUNT_LEVEL_SUPERADMIN));
        } else {
        	//TODO : Exception 처리
        }

        if( StringUtils.equals(Constants.MBR_ACCOUNT_STATUS_TYPE_OUT, statusVal) ){
        	accountSearchVO.setStatusType("0");
        } else {
        	accountSearchVO.setStatusType("2");
        }

        AccountListVO accountListVO = accountService.getAccountPagingList(accountSearchVO);  // 회원 리스트 정보
        ModelAndView mav = new ModelAndView();
        mav.addObject("accountListVO", accountListVO);
        mav.addObject("accountType", accountType);
        mav.addObject("statusVal", statusVal);
        mav.setViewName("admin/account/accountList");

        return mav;
    }




    @RequestMapping("order/orderList")
    public ModelAndView getOrderList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrderList' controller...");
        }
        OrderSearchVO orderSearchVO = new OrderSearchVO();
        orderSearchVO.setRegisterId(accountSearchVO.getMbrId());
        orderSearchVO.setEndDateType("1"); //이용기간내 목록 가져오기
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("admin/account/order/orderList");

        mav.addObject("orderListVO", orderListVO);

        return mav;
    }

    @RequestMapping("order/orderFinishList")
    public ModelAndView getOrderFinishList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getOrderFinishList' controller...");
        }
        OrderSearchVO orderSearchVO = new OrderSearchVO();
        orderSearchVO.setRegisterId(accountSearchVO.getMbrId());
        orderSearchVO.setEndDateType("2"); //이용기간내 목록 가져오기
        OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);

        ModelAndView mav = new ModelAndView("admin/account/order/orderList");

        mav.addObject("orderListVO", orderListVO);
        mav.addObject("accountSearchVO", accountSearchVO);

        return mav;
    }

    /**
     * 회원 리스트
     * @param request
     * @param response
     * @param accountSearchVO
     * @return
     */
    @RequestMapping("accountList")
    public ModelAndView getAccountPagingList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountPagingList' controller...");
        }

        AccountListVO accountListVO = accountService.getAccountPagingList(accountSearchVO);  // 회원 리스트 정보
        ModelAndView mav = new ModelAndView();
        mav.addObject("accountListVO", accountListVO);

        return mav;
    }

    /**
     * 회원 상세
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("{accountType}/{statusVal}detail")
    public ModelAndView getAccount(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountVO accountParamVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccount' controller...");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/account/accountDetail");

        //mbrId 가 넘어왔을때만 실행
        if  (StringUtils.isNotEmpty(accountParamVO.getMbrId())){

        	AccountVO accountVO = accountService.getAccount(accountParamVO);

            mav.addObject("accountVO", accountVO);
            if (accountVO.getLevel() == 10) {
            	AccountCarInfoVO accountCarInfoVO = new AccountCarInfoVO();
            	accountCarInfoVO.setMbrId(accountVO.getMbrId());
            	mav.addObject("accountCarVO", accountInfoService.getAccountCarInfo(accountCarInfoVO));
            }
            if (accountVO.getLevel() == 30 || accountVO.getLevel() == 40) {
            	AccountMechanicInfoVO accountMechanicInfoVO = new AccountMechanicInfoVO();
            	accountMechanicInfoVO.setMbrId(accountVO.getMbrId());
            	mav.addObject("accountMechanicInfoVO", accountInfoService.getAccountMechanicInfo(accountMechanicInfoVO));
            }
        }
        mav.addObject("accountType", accountType);
        mav.addObject("statusVal", statusVal);

        return mav;
    }

    /**
     * 회원등록 & 수정 폼
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("{accountType}/{statusVal}form")
    public ModelAndView getAccountForm(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountForm' controller...");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/account/accountForm");

        // 회원정보 수정일때만
        if  (StringUtils.isNotEmpty(accountVO.getMbrId())){
            mav.addObject("accountFormVO", accountService.getAccount(accountVO));
        }
        mav.addObject("accountType", accountType);
        mav.addObject("statusVal", statusVal);

        return mav;
    }

    /**
    * 회원등록 & 수정
    * @param request
    * @param response
    * @param accountVO
    * @return
    */
    @RequestMapping("{accountType}/{statusVal}formProc")
    public ModelAndView accountFormProc(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountFormProc' controller...");
        }

        if(StringUtils.isEmpty(accountVO.getPwd())){//수정처리
            accountVO.setUpdateIp(request.getRemoteAddr());
            accountService.modifyAccount(accountVO);
        }else{//등록

            //UUID mbrId = UUID.randomUUID();
            //accountVO.setMbrId(mbrId.toString());
            accountVO.setRegisterIp(request.getRemoteAddr());

            accountService.addAccount(accountVO);
        }
        return new ModelAndView("redirect:"+statusVal+"detail.do?mbrId=" + accountVO.getMbrId());
    }

    /**
     * 회원 비밀번호 찾기 및 변경
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountSearchPwd")
    public ModelAndView getSearchPwd(HttpServletRequest request,
                                     HttpServletResponse response,
                                      AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getSearchPwd' controller...");
        }

        AccountVO accountInfoVO = null;

        //  회원값 셋팅
        if  (StringUtils.isNotEmpty(accountVO.getEmail())){
            accountInfoVO = accountService.getAccount(accountVO);

            accountVO.setFirstName(accountInfoVO.getFirstName());
            //accountVO.setLastName(accountInfoVO.getLastName());
            accountVO.setEmail(accountInfoVO.getEmail());
        }

        accountVO.setUpdateIp(request.getRemoteAddr());
        String pwd = accountService.getSearchPwd(accountVO);

        int updateCount = 0;
        if (StringUtils.isNotEmpty(pwd)){  // 비밀번호가 변경 되었으면

            //pwd 암호화 전 메일 보내기
            String htmlMessage = "고객님의 임시 비밀 번호가 발급되었습니다.\n\n"  +

            "발급된 비밀번호는" + pwd + "입니다.\n\n" +

            "확인후 바로 변경해 주시기 바랍니다.\n";

            SendMailVO sendMailVO = new SendMailVO();
            sendMailVO.setFromEmail("master@webeyespeak.com");
            sendMailVO.setFromName("EYESPEAK");
            sendMailVO.setSubject("비밀번호가 변경 되었습니다.");
            sendMailVO.setHtmlMessage(htmlMessage);
            sendMailVO.setToEmail(accountVO.getEmail());
            sendMailVO.setToName(accountVO.getFirstName());
            mailSendProcessor.sendMail(sendMailVO);

            // 메일 발송후 비밀번호 암호화 및 업데이트
            accountVO.setUpdateIp(request.getRemoteAddr());
            accountVO.setPwd(pwd);
            updateCount = accountService.modifyPwd(accountVO);  // 변경된 비밀번호 업데이트
        }

        ModelAndView mav = new ModelAndView("jsonView");

        if(updateCount > 0)
            mav.addObject("result", "success");
        else
            mav.addObject("result", "error");

        return mav;

    }

    /**
     * ID 중복 체크
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountIdChk")
    public ModelAndView accountIdChk(HttpServletRequest request,
                                     HttpServletResponse response,
                                      AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountIdChk' controller...");
        }

        String mbrId = accountService.accountIdChk(accountVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("mbrIdChk", mbrId);

        return mav;

    }

    /**
     * NickName 중복 체크
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountNickChk")
    public ModelAndView accountNickChk(HttpServletRequest request,
                                     HttpServletResponse response,
                                      AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountNickChk' controller...");
        }

        String nickName = accountService.accountNickChk(accountVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("mbrNickChk", nickName);

        return mav;

    }

    /**
     * email 중복 체크
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountEmailChk")
    public ModelAndView accountEmailChk(HttpServletRequest request,
                                     HttpServletResponse response,
                                      AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountEmailChk' controller...");
        }

        String email = accountService.accountEmailChk(accountVO);

        ModelAndView mav = new ModelAndView("jsonView");
        mav.addObject("emailChk", email);

        return mav;

    }

    /**
    * 회원 레벨 변경
    * @param request
    * @param response
    * @param accountVO
    * @return
    */
   @RequestMapping("modifyAccountLevel")
   public ModelAndView modifyAccountLevel(HttpServletRequest request,
                                    HttpServletResponse response,
                                     AccountVO accountVO){
       if ( LOG.isDebugEnabled() ) {
           LOG.debug("starting 'modifyAccountLevel' controller...");
       }

       int row = accountService.modifyAccountLevel(accountVO);

       ModelAndView mav = new ModelAndView("jsonView");

       if (row > 0)
           mav.addObject("result", "success");
       else
           mav.addObject("result", "error");

       return mav;

   }

   /**
    * 회원 탈퇴 Form
    * @param request
    * @param response
    * @param accountVO
    * @return
    */
    @RequestMapping("{accountType}/{statusVal}removeForm")
    public ModelAndView removeAccountForm(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountFormVO accountFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeAccountForm' controller...");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/account/accountRemoveForm");
        mav.addObject("accountFormVO", accountFormVO);

        return mav;
    }

   /**
    * 회원 삭제
    * @param request
    * @param response
    * @param accountVO
    * @return
    */
    @RequestMapping("{accountType}/{statusVal}removeProc")
    public ModelAndView removeAccount(
    		@PathVariable("accountType") String accountType,
    		@PathVariable("statusVal") String statusVal,
    		HttpServletRequest request,
            HttpServletResponse response,
            AccountFormVO accountFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeAccount' controller...");
        }

        AccountVO accountParamVO = new AccountVO();

        accountParamVO.setUpdateIp(request.getRemoteAddr());
        accountParamVO.setMbrId(accountFormVO.getMbrId());
        accountParamVO.setMemo(accountFormVO.getMemo());

        int row = accountService.removeAccount(accountParamVO);

        if (row > 0){
            return new ModelAndView("redirect:{statusVal}list.do"); // 탈퇴 성공
        }else{
            return new ModelAndView("redirect:{statusVal}removeForm.do?mode=100"); // 탈퇴 실패
        }

    }

}

