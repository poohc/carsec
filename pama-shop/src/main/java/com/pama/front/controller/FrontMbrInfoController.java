package com.pama.front.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/mbr/info/*")
public class FrontMbrInfoController {

    private static final Log LOG = LogFactory.getLog(FrontMbrInfoController.class);

    @Autowired
    private AccountInfoService accountInfoService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

    /**
     * 일반회원 자동차정보  폼
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountCarInfo")
    public ModelAndView accountCarInfo(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountCarInfoVO accountCarInfoVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountCarInfo' controller...");
        }
        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
        }

        ModelAndView mav = new ModelAndView("front/account/join3");

        return mav;
    }

    /**
     * 업체회원 메카닉정보  폼
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("accountMechanicInfo")
    public ModelAndView accountMechanicInfo(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountMechanicInfoVO accountMechanicInfoVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'accountMechanicInfo' controller...");
        }
        String loginId = "";
        if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
        }

        ModelAndView mav = new ModelAndView("front/account/join3_agency");

        return mav;
    }

    /**
     * 일반회원 자동차정보 등록
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
     @RequestMapping("accountCarInfoProc")
     public ModelAndView accountCarInfoProc(HttpServletRequest request,
             HttpServletResponse response,
             AccountCarInfoVO accountCarInfoVO){
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("starting 'accountCarInfoProc' controller...");
         }

         String loginId = "";
         if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
             loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
         }

         accountCarInfoVO.setMbrId(loginId);

         AccountCarInfoVO accountCarResultVO = accountInfoService.getAccountCarInfo(accountCarInfoVO);

         if (accountCarResultVO != null) accountCarInfoVO.setCarId(accountCarResultVO.getCarId());

         if (accountCarInfoVO.getCarId() == null || accountCarInfoVO.getCarId().equals("")) {
        	 accountInfoService.addAccountCarInfo(accountCarInfoVO);
         } else {
        	 accountInfoService.modifyAccountCarInfo(accountCarInfoVO);
         }

         return new ModelAndView("redirect:accountInfoEnd.do");
     }

     /**
      * 기업회원 메카닉정보 등록
      * @param request
      * @param response
      * @param accountVO
      * @return
     * @throws IOException
     * @throws IllegalStateException
      */
      @RequestMapping("accountMechanicInfoProc")
      public ModelAndView accountMechanicInfoProc(HttpServletRequest request,
              HttpServletResponse response,
              AccountMechanicInfoVO accountMechanicInfoVO) throws IllegalStateException, IOException{
          if ( LOG.isDebugEnabled() ) {
              LOG.debug("starting 'accountMechanicInfoProc' controller...");
          }

          String loginId = "";
          if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
              loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
          }

          accountMechanicInfoVO.setMbrId(loginId);

          AccountMechanicInfoVO accountMechanicResultVO = accountInfoService.getAccountMechanicInfo(accountMechanicInfoVO);

          if (accountMechanicResultVO != null) accountMechanicInfoVO.setMechanicId(accountMechanicResultVO.getMechanicId());

          if (accountMechanicInfoVO.getFaxTrans() == null || accountMechanicInfoVO.getFaxTrans().equals("")) {
        	  accountMechanicInfoVO.setFaxTrans("N");
          }

          AttachmentVO attachmentVO;
          if (accountMechanicInfoVO.getFile1()!=null) {
        	  attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_ACCOUNTINFO, accountMechanicInfoVO.getFile1());
        	  if (attachmentVO!=null) {
        		  accountMechanicInfoVO.setBizRegFile(attachmentVO.getFileName());
        	  }
          }

          if (accountMechanicInfoVO.getMechanicId() == null || accountMechanicInfoVO.getMechanicId().equals("")) {
         	 accountInfoService.addAccountMechanicInfo(accountMechanicInfoVO);
          } else {
         	 accountInfoService.modifyAccountMechanicInfo(accountMechanicInfoVO);
          }

          return new ModelAndView("redirect:accountMecInfoEnd.do");
      }

     /**
      * 일반회원 등록  완료
      * @param request
      * @param response
      * @param accountVO
      * @return
      */
     @RequestMapping("accountInfoEnd")
     public ModelAndView accountInfoEnd(HttpServletRequest request,
                                 HttpServletResponse response){
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("starting 'accountInfoForm' controller...");
         }

         String loginId = "";
         if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
             loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
         }

         ModelAndView mav = new ModelAndView("front/account/join4");
         mav.addObject("loginId", loginId);
         return mav;
     }

     /**
      * 기업회원 등록  완료
      * @param request
      * @param response
      * @param accountVO
      * @return
      */
     @RequestMapping("accountMecInfoEnd")
     public ModelAndView accountMecInfoEnd(HttpServletRequest request,
                                 HttpServletResponse response){
         if ( LOG.isDebugEnabled() ) {
             LOG.debug("starting 'accountMecInfoEnd' controller...");
         }

         String loginId = "";
         if( SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request)){  //
             loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();  //
         }

         ModelAndView mav = new ModelAndView("front/account/join4_agency");
         mav.addObject("loginId", loginId);
         return mav;
     }
}
