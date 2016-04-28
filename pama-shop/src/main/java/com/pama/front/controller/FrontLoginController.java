package com.pama.front.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.admin.login.controller.LoginController;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbr.vo.LoginFormVO;

@Controller
@RequestMapping("/login/*")
public class FrontLoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountInfoService accountInfoService;

    /**
     * 관리자 로그인 Form
     * @param request
     * @param response
     * @param accountVO
     * @return
     */
    @RequestMapping("loginForm")
    public ModelAndView loginForm (HttpServletRequest request,
            HttpServletResponse response, LoginFormVO loginFormVO)  {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'loginForm' controller...");
        }

        if(StringUtils.isNotEmpty(loginFormVO.getReturnURL()) && (loginFormVO.getReturnURL().indexOf("loginForm") != -1 || loginFormVO.getReturnURL().indexOf("Proc") != -1)){
            return new ModelAndView("redirect:/main/main.do");
        }else{
            ModelAndView mav = new ModelAndView("front/login/loginForm");

            mav.addObject("loginFormVO", loginFormVO);

            return mav;
        }

    }
    /**
     * 관리자 로그인
     * @param request
     * @param response
     * @param accountVO
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping("loginProc")
    public ModelAndView loginFormProc(HttpServletRequest request,
            HttpServletResponse response,
            LoginFormVO loginFormVO) throws UnsupportedEncodingException {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'loginFormProc' controller...");
        }

        if (StringUtils.isEmpty(loginFormVO.getLoginId()) ){
            return new ModelAndView("redirect:loginForm.do?mode=100&returnURL=" + URLEncoder.encode(loginFormVO.getReturnURL(), "UTF-8"));  // 아이디가 안넘어 왔을때
        }

        if (StringUtils.isEmpty(loginFormVO.getPwd()) ){
            return new ModelAndView("redirect:loginForm.do?mode=101&returnURL=" + URLEncoder.encode(loginFormVO.getReturnURL(), "UTF-8"));  // 비밀번호가 안넘어 왔을때
        }

        AccountVO accountParamVO = new AccountVO();

        //accountParamVO.setLevel(Constants.MBR_ACCOUNT_LEVEL_ADMIN); //

        accountParamVO.setEmail(loginFormVO.getLoginId());
        accountParamVO.setMbrId(loginFormVO.getLoginId());

        accountParamVO.setPwd(loginFormVO.getPwd());
        AccountVO loginAccountInfoVO = accountService.getAccountLogin(accountParamVO);  //로그인 시도

        if(loginAccountInfoVO != null){ // 로그인 성공

        	//Front에서는 관리자는 로그인이 안된다.
            if(loginAccountInfoVO.getLevel() >= Constants.MBR_ACCOUNT_LEVEL_ADMIN){
            	return new ModelAndView("redirect:loginForm.do?mode=102&returnURL=" + URLEncoder.encode(loginFormVO.getReturnURL(), "UTF-8"));  // 관리자가 로그인했을때
            }

            //사업자회원인경우 승인이 안되면 로그인 안된다.
            if(loginAccountInfoVO.getLevel() == Constants.MBR_ACCOUNT_LEVEL_BUSINESS_A){
            	return new ModelAndView("redirect:loginForm.do?mode=30&returnURL=" + URLEncoder.encode(loginFormVO.getReturnURL(), "UTF-8"));  // 관리자가 로그인했을때
            }

            //로그인 정보 업데이트
            accountService.modifyLastLoginDate(loginAccountInfoVO);

            // AccountSessionVO 에 로그인 정보 격납
            SessionVO sessionVO = new SessionVO();
            sessionVO.setMbrId(loginAccountInfoVO.getMbrId());
            sessionVO.setMemberNm(loginAccountInfoVO.getFirstName());
            sessionVO.setNickNm(loginAccountInfoVO.getNickName());
            sessionVO.setEmail(loginAccountInfoVO.getEmail());
            sessionVO.setLevel(loginAccountInfoVO.getLevel());
            sessionVO.setLoginCnt(loginAccountInfoVO.getLoginCount());
            sessionVO.setLoginDate(loginAccountInfoVO.getLoginDate());
            sessionVO.setGender(loginAccountInfoVO.getGender());



            //로그인 정보를 session에 담는다
            SessionUtil.createSession(Constants.ACCOUNT_FRONT_SESSION_NAME, sessionVO, request);

            if(StringUtils.isNotEmpty(loginFormVO.getReturnURL()) && loginFormVO.getReturnURL().indexOf("loginForm") == -1 && loginFormVO.getReturnURL().indexOf("Proc") == -1){
                return new ModelAndView("redirect:" + loginFormVO.getReturnURL());
            }else{
                return new ModelAndView("redirect:/main/main.do");
            }

            //return new ModelAndView("redirect:loginForm.do?mode=200");

        }else{ // 로그인 실패
        	if (loginFormVO.getReturnURL() == null) {
        		return new ModelAndView("redirect:/login/loginForm.do?mode=300");
        	} else {
        		return new ModelAndView("redirect:/login/loginForm.do?mode=300&returnURL=" + URLEncoder.encode(loginFormVO.getReturnURL(), "UTF-8"));
        	}
        }
    }

    /**
     * 로그아웃
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public ModelAndView getLogout(HttpServletRequest request) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getLogout' controller...");
        }
        String returnURL = StringUtils.defaultString(request.getParameter("returnURL"),"loginForm.do");

        SessionUtil.removeSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);

        return new ModelAndView("redirect:"+returnURL); // 로그아웃후 로그인 페이지로 이동
    }
}
