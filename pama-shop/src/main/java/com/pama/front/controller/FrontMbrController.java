package com.pama.front.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.car.service.CarcodeService;
import com.pama.car.vo.CarcodeVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbr.vo.LoginFormVO;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.MailSendProcessor;
import com.pama.processor.vo.AttachmentVO;
import com.pama.processor.vo.SendMailVO;
import com.pama.zip.service.ZipcodeService;
import com.pama.zip.vo.ZipcodeVO;
/**
 * 회원 폼 및 화면 및 처리
 * @author sycop
 *
 */
@Controller
@RequestMapping("/mbr/*")
public class FrontMbrController {

    private static final Log LOG = LogFactory.getLog(FrontMbrController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private ZipcodeService zipcodeService;

    @Autowired
    private CarcodeService carcodeService;

    @Autowired
    private MailSendProcessor mailSendProcessor;

    @Autowired
	private AttachmentProcessor attachmentProcessor;

    /**
     * 회원가입(일반회원) 폼(동의포함)
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountAgree")
    public ModelAndView accountAgree(){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountAgree' controller...");
        }
        ModelAndView mav = new ModelAndView("front/account/accountAgree");
        return mav;
    }

    /**
     * 일반회원
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
     @RequestMapping("accountAgreeProc")
     public ModelAndView accountJoinProc(
    		 HttpServletRequest request,
             HttpServletResponse response,
             AccountVO accountVO){
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("starting 'accountAgreeProc' controller...");
         }

    	 if (accountVO.getSnsReceiveYN()==null) {
    		 accountVO.setSnsReceiveYN("N");
    	 }

    	 AccountVO accountParamVO = new AccountVO();
         accountParamVO.setEmail(accountVO.getMbrId());
         accountParamVO.setMbrId(accountVO.getMbrId());
         accountParamVO.setPwd(accountVO.getPwd());

    	 accountVO.setLevel(Constants.MBR_ACCOUNT_LEVEL_INDIVIDUAL);; //일반회원
    	 accountVO.setStatusType(Constants.MBR_ACCOUNT_STATUS_TYPE);
    	 accountVO.setRegisterIp(request.getRemoteAddr());

    	 accountService.addAccount(accountVO);


    	 ModelAndView mav = new ModelAndView("redirect:/login/loginForm.do?mode=500");

         return mav;
     }

    /**
     * 메카닉회원 가입(업체회원)  폼
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountAgreeAgency")
    public ModelAndView accountAgreeAgency(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountAgreeAgency' controller...");
        }

        ModelAndView mav = new ModelAndView("front/account/accountAgreeAgency");
        mav.addObject("accountVO", accountVO);

        return mav;
    }



     /**
      * 메카닉회원등록
      * @param request
      * @param response
      * @param accountVO
      * @return
     * @throws IOException
     * @throws IllegalStateException
      */
      @RequestMapping("accountAgreeAgencyProc")
      public ModelAndView accountAgreeAgencyProc(HttpServletRequest request,
              HttpServletResponse response,
              AccountVO accountVO) throws IllegalStateException, IOException{
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'accountAgreeAgencyProc' controller...");
          }

     	 if (accountVO.getSnsReceiveYN()==null) {
     		 accountVO.setSnsReceiveYN("N");
     	 }

     	 accountVO.setLevel(Constants.MBR_ACCOUNT_LEVEL_BUSINESS_A);; //회원
     	 accountVO.setStatusType(Constants.MBR_ACCOUNT_STATUS_TYPE);
     	 accountVO.setRegisterIp(request.getRemoteAddr());
     	 accountVO.getAccountMechanicInfoVO().setBizNumber(accountVO.getBizNumber());

     	 /**
     	  * 사업자등록증
     	  */
     	  AttachmentVO attachmentVO=null;

     	  if (accountVO.getFile1()!=null) {
        	  attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_ACCOUNTINFO, accountVO.getFile1());
        	  if (attachmentVO!=null) {
        		  accountVO.getAccountMechanicInfoVO().setBizRegFile(attachmentVO.getFileName());
        	  }
          }

     	  /**
     	   * 사업장 포토
     	   */
     	 AttachmentVO attachmentVO2=null;
     	 if (accountVO.getFile2()!=null) {
     		attachmentVO2 = attachmentProcessor.upload(Constants.SERVICE_ID_ACCOUNTINFO, accountVO.getFile2());
       	  if (attachmentVO2!=null) {
       		  accountVO.getAccountMechanicInfoVO().setBizPhoto(attachmentVO2.getFileName());
       	  }
         }


     	 accountService.addAccountAgencyProc(accountVO);


          ModelAndView mav = new ModelAndView("redirect:/login/loginForm.do?mode=500");

          return mav;
      }

      /**
       * 회원 상세
       * @param request
       * @param response
       * @param accountVO
       * @return
       */
      @RequestMapping("mypage/mypage")
      public ModelAndView getMypage(HttpServletRequest request,
                                  HttpServletResponse response,
                                  LoginFormVO loginFormVO){
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'getMypage' controller...");
          }

          ModelAndView mav = new ModelAndView("front/mypage/password");
          mav.addObject("mode", loginFormVO.getMode());
          return mav;
      }

      /**
       * 회원 상세
       * @param request
       * @param response
       * @param accountVO
       * @return
       */
      @RequestMapping("mypage/mypageInfo")
      public ModelAndView getAccount(HttpServletRequest request,
                                  HttpServletResponse response,
                                  AccountVO accountVO){
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'getAccount' controller...");
          }

          if (StringUtils.isEmpty(accountVO.getPwd()) ){
              return new ModelAndView("redirect:/mbr/mypage/mypage.do");  // 비밀번호가 안넘어 왔을때
          }

          String loginId = "";
          if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
              loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
          }
          accountVO.setMbrId(loginId);

          AccountVO loginAccountInfoVO = accountService.getAccountLogin(accountVO);  //사용자 확인

          ModelAndView mav = new ModelAndView();

          if(loginAccountInfoVO != null){ // 로그인 성공
        	  //mbrId 가 넘어왔을때만 실행
              if  (StringUtils.isNotEmpty(accountVO.getMbrId())){
            	  AccountVO accountInfoVO = accountService.getAccount(accountVO);
            	  mav.addObject("accountFormVO", accountInfoVO);
                  if (accountInfoVO.getLevel()==10) {
                	  mav.setViewName("front/mypage/mypage");
                  } else if (accountInfoVO.getLevel()==30 || accountInfoVO.getLevel()==40) {
                	  mav.setViewName("front/mypage/mypageAgency");
                  }
              }
          } else {
        	  mav = new ModelAndView("redirect:/mbr/mypage/mypage.do");
        	  mav.addObject("mode", "300");
          }

          return mav;
      }


    /**
     * 회원 상세
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/mypageChangePwd")
    public ModelAndView getAccountChangePwd(HttpServletRequest request,
                                HttpServletResponse response,
                                LoginFormVO loginFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountChangePwd' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/mypageChangePwd");
        return mav;
    }

    /**
     * 회원수정
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/mypageModifyFormProc")
    public ModelAndView accountModifyFormProc(HttpServletRequest request,
   		 HttpServletResponse response,
   		 AccountVO accountVO) throws IllegalStateException, IOException {
	   	 if ( LOG.isDebugEnabled() ) {
	   		 LOG.debug("starting 'accountModifyFormProc' controller...");
	   	 }

	   	 String loginId = "";
	   	 if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
	   		 loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //

	         AccountVO accountInfoVO = accountService.getAccount(accountVO);

	   		 accountVO.setMbrId(loginId);
	   		 accountVO.setUpdateIp(request.getRemoteAddr());
	         accountVO.setLevel(accountInfoVO.getLevel());

	         if (accountInfoVO.getLevel() == 30 || accountInfoVO.getLevel() == 40) {

	        	 accountVO.getAccountMechanicInfoVO().setBizNumber(accountVO.getBizNumber());

		     	 /**
		     	  * 사업자등록증
		     	  */
		     	  AttachmentVO attachmentVO=null;

		     	  if (accountVO.getFile1()!=null) {
		        	  attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_ACCOUNTINFO, accountVO.getFile1());
		        	  if (attachmentVO!=null) {
		        		  accountVO.getAccountMechanicInfoVO().setBizRegFile(attachmentVO.getFileName());
		        	  }
		          }

		     	  /**
		     	   * 사업장 포트
		     	   */
		     	 AttachmentVO attachmentVO2=null;
		     	 if (accountVO.getFile2()!=null) {
		     		attachmentVO2 = attachmentProcessor.upload(Constants.SERVICE_ID_ACCOUNTINFO, accountVO.getFile2());
		       	  if (attachmentVO2!=null) {
		       		  accountVO.getAccountMechanicInfoVO().setBizPhoto(attachmentVO2.getFileName());
		       	  }
		         }
	         }

	   		 accountService.modifyAccount(accountVO);

	 	   	if (accountInfoVO.getLevel() == 30 || accountInfoVO.getLevel() == 40) {

	 	   		return new ModelAndView("redirect:modifyComplete.do");
		   	} else {
		   		return new ModelAndView("redirect:modifyComplete.do");
		   	}

	   	 }

		 return new ModelAndView("redirect:mypageInfo.do");
    }

    /**
     * 회원수정
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/mypageModifyPwdProc")
    public ModelAndView mypageModifyPwdProc(HttpServletRequest request,
   		 HttpServletResponse response,
   		 AccountVO accountVO){
	   	 if ( LOG.isDebugEnabled() ) {
	   		 LOG.debug("starting 'mypageModifyPwdProc' controller...");
	   	 }

	   	 String msg = "";

	   	 String loginId = "";
	   	 if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
	   		 loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //

	   		 accountVO.setMbrId(loginId);
	   		 accountVO.setUpdateIp(request.getRemoteAddr());

	   		if(accountService.getAccountPwdChk(accountVO) == null){
	   			msg="-1";
	   		}else{

	   			if(StringUtils.length(accountVO.getModifyPwd()) > 5){
		   			accountVO.setPwd(accountVO.getModifyPwd());
		   			accountService.modifyPwd(accountVO);
	   			}

	   			msg="100";
	   		}
	   	 }

		 return new ModelAndView("redirect:mypageChangePwd.do?mode="+msg);
    }

    @RequestMapping("mypage/modifyComplete")
    public ModelAndView getModifyComplete(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getModifyComplete' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/modify_complete");
        mav.addObject("accountVO", accountVO);
        return mav;
    }

    /**
     * 회원 상세
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/unregister")
    public ModelAndView getUnregister(HttpServletRequest request,
                                HttpServletResponse response,
                                LoginFormVO loginFormVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getUnregister' controller...");
        }

        ModelAndView mav = new ModelAndView("front/mypage/unregister");
        mav.addObject("mode", loginFormVO.getMode());
        return mav;
    }

    /**
     * 회원 상세
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/unregisterInfo")
    public ModelAndView getUnregisterInfo(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountVO accountVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getUnregisterInfo' controller...");
        }

        if (StringUtils.isEmpty(accountVO.getPwd()) ){
            return new ModelAndView("redirect:/mbr/mypage/unregister.do");  // 비밀번호가 안넘어 왔을때
        }

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
        }
        accountVO.setMbrId(loginId);

        AccountVO loginAccountInfoVO = accountService.getAccountLogin(accountVO);  //사용자 확인

        ModelAndView mav = null;

        if(loginAccountInfoVO != null){ // 로그인 성공
      	  	mav = new ModelAndView("front/mypage/unregister2");
        } else {
      	  	mav = new ModelAndView("redirect:/mbr/mypage/unregister.do");
      	  	mav.addObject("mode", "300");
        }

        return mav;
    }

    /**
     * 회원 탈퇴
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("mypage/accountRemoveProc")
    public ModelAndView removeAccount(HttpServletRequest request,
           HttpServletResponse response,
           AccountVO accountVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'removeAccount' controller...");
    	}

        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
        }

    	accountVO.setUpdateIp(request.getRemoteAddr());

    	AccountCarInfoVO accountCarInfoVO = new AccountCarInfoVO();
    	accountCarInfoVO.setMbrId(loginId);
    	accountInfoService.removeAccountCarInfo(accountCarInfoVO);

    	AccountMechanicInfoVO accountMechanicInfoVO = new AccountMechanicInfoVO();
    	accountMechanicInfoVO.setMbrId(loginId);
    	accountInfoService.removeAccountMechanicInfo(accountMechanicInfoVO);

    	accountVO.setMbrId(loginId);
    	accountService.removeAccount(accountVO);

    	return new ModelAndView("redirect:/login/logout.do");

    }

       /**
        * 회원 아이디  비밀번호 찾기Form
        * @param request
        * @param response
        * @param accountVO
        * @return
        */
       @RequestMapping("searchIdPwdForm")
       public String searchIdPwdForm(){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'searchIdPwdForm' controller...");
           }

           return "front/mbr/searchIdPwdForm";

       }

       /**
        * 회원 아이디 찾기
        * @param request
        * @param response
        * @param accountVO
        * @return
        */
       @RequestMapping("accountSearchId")
       public ModelAndView getSearchId(HttpServletRequest request,
               HttpServletResponse response,
               AccountVO accountVO){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'getSearchId' controller...");
           }

           ModelAndView mav = new ModelAndView("front/mbr/accountSearchId");

           String mbrId = accountService.getSearchID(accountVO);

           mav.addObject("mbrId", mbrId);  // mbrId가 있으면 성공

           return mav;

       }

       /**
        * 회원 비밀번호 찾기
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

           ModelAndView mav = new ModelAndView("front/mbr/accountSearchPwd");

           int updateCount = 0;
           String pwd = accountService.getSearchPwd(accountVO); // 비밀번호 찾은후 변경

           if (StringUtils.isNotEmpty(pwd)){  // 비밀번호가 변경 되었으면

               //pwd 암호화 전 메일 보내기
               String htmlMessage = "고객님의 임시 비밀 번호가 발급되었습니다.\n\n"  +

               "발급된 비밀번호는" + pwd + "입니다.\n\n" +

               "확인후 바로 변경해 주시기 바랍니다.\n";

               SendMailVO sendMailVO = new SendMailVO();
               sendMailVO.setFromEmail("webmaster@naver.com");
               sendMailVO.setFromName("나눔채");
               sendMailVO.setSubject("건강나라 나눔채 비밀번호가 변경 되었습니다.");
               sendMailVO.setHtmlMessage(htmlMessage);
               sendMailVO.setToEmail(accountVO.getEmail());
               sendMailVO.setToName(accountVO.getFirstName() + accountVO.getLastName());
               mailSendProcessor.sendMail(sendMailVO);

               // 메일 발송후 비밀번호 암호화 및 업데이트
               accountVO.setUpdateIp(request.getRemoteAddr());
               accountVO.setPwd(pwd);
               updateCount = accountService.modifyPwd(accountVO);  // 변경된 비밀번호 업데이트
           }

           if(updateCount > 0) { // 비밀번호가 업데이트 되었다면
               mav.addObject("pwd", pwd);  // pwd가 있으면 성공
           }

           return mav;
       }

       /**
       * 비밀번호 확인
       * @param request
       * @param response
       * @param accountVO
       * @return
       */
       @RequestMapping("accountPwdChk")
       public ModelAndView getAccountPwdChk(HttpServletRequest request,
               HttpServletResponse response,
               AccountVO accountVO){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'getAccountPwdChk' controller...");
           }

           ModelAndView mav = new ModelAndView("jsonView");

           String pwd = accountService.getAccountPwdChk(accountVO);

           if (StringUtils.isNotEmpty(pwd))
               mav.addObject("result", "success");  // 성공시 원하는 페이지로 이동한다.
           else
               mav.addObject("result", "error");

           return mav;

       }

       @RequestMapping("accountAddrSearch")
       public ModelAndView getAccountAddrSearch(HttpServletRequest request,
               HttpServletResponse response,
               ZipcodeVO zipcodeVO){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'getAccountAddrSearch' controller...");
           }

           ModelAndView mav = new ModelAndView("jsonView");

           mav.addObject("zipcode", zipcodeService.getAccountAddrSearch(zipcodeVO));

           return mav;

       }

       @RequestMapping("accountCarSearch")
       public ModelAndView getAccountCarSearch(HttpServletRequest request,
               HttpServletResponse response,
               CarcodeVO carcodeVO){
           if ( LOG.isDebugEnabled() ) {
               LOG.debug("starting 'getAccountCarSearch' controller...");
           }

           ModelAndView mav = new ModelAndView("jsonView");

           mav.addObject("carcode", carcodeService.getAccountAddrSearch(carcodeVO));

           return mav;

       }

}
