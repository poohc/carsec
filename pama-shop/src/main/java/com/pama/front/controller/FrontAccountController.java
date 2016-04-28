package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.cert.service.TempCertService;
import com.pama.cert.vo.TempCertVO;
import com.pama.common.util.SecurityUtil;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;
import com.pama.processor.MailSendProcessor;
import com.pama.processor.SmsProcessor;
import com.pama.processor.vo.SendMailVO;
import com.pama.processor.vo.SendSmsVO;
/**
 * 회원 체크로직
 * @author sycop
 *
 */
@Controller
@RequestMapping("/signup/*")
public class FrontAccountController {

	private static final Log LOG = LogFactory.getLog(FrontAccountController.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TempCertService tempCertService;

	@Autowired
	private MailSendProcessor mailSendProcessor;
	
	@Autowired
	private SmsProcessor smsProcessor;

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


	/**mobileNumber 중복 체크
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("accountMobilechk")
	public ModelAndView accountMobilechk(HttpServletRequest request,
			HttpServletResponse response,
			AccountVO accountVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'accountMobilechk' controller...");
		}

		String mobileNumber = accountService.accountMobilechk(accountVO);

		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println("===================== mobileNumber");
		mav.addObject("mobileChk", mobileNumber);

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
	 * email 중복 체크
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("accountNickNameChk")
	public ModelAndView accountNickNameChk(HttpServletRequest request,
			HttpServletResponse response,
			AccountVO accountVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'accountNickNameChk' controller...");
		}

		String nickName = accountService.accountNickNameChk(accountVO);

		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("nickNameChk", nickName);

		return mav;

	}

	/**
	 * 회원 아이디   찾기Form
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("searchIdForm")
	public String searchIdForm(){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'searchIdForm' controller...");
		}

		return "front/account/searchIdForm";

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

		ModelAndView mav = new ModelAndView("front/account/accountSearchId");

		String mbrId = accountService.getSearchID(accountVO);

		mav.addObject("mbrId", mbrId);  // mbrId가 있으면 성공

		return mav;

	}

	/**
	 * 회원 비밀번호 찾기Form
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("searchPwdForm")
	public String searchPwdForm(){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'searchPwdForm' controller...");
		}

		return "front/account/searchPwdForm";

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

		ModelAndView mav = new ModelAndView("front/account/accountSearchPwd");

		int updateCount = 0;
		String pwd = accountService.getSearchPwd(accountVO); // 비밀번호 찾은후 변경

		if (StringUtils.isNotEmpty(pwd)){  // 비밀번호가 변경 되었으면

			//pwd 암호화 전 메일 보내기
			String htmlMessage = "고객님의 임시 비밀 번호가 발급되었습니다.\n\n"  +

               "발급된 비밀번호는" + pwd + "입니다.\n\n" +

               "로그인후 개인정보로 가져서 바로 변경해 주시기 바랍니다.\n";

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

	/**
	 * 메모수정
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("updateAccountMemo")
	public ModelAndView updateAccountMemo(HttpServletRequest request,
			HttpServletResponse response,
			String infomemo){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'updateAccountMemo' controller...");
		}

		ModelAndView mav = new ModelAndView("jsonView");
		int row =0;
		SessionVO sessionVO = SessionUtil.getFrontSession();
		if(sessionVO!=null){
			String mbrId=sessionVO.getMbrId();
			row = accountService.modifyAccountMemo(mbrId, infomemo, request.getRemoteAddr());
		}
		if (row > 0){
			mav.addObject("result", "success");  // 성공시 원하는 페이지로 이동한다.
		}else{
			mav.addObject("result", "error");
		}

		return mav;

	}
	
    /**
     * 인증번호 키를 생성 후 문자발생
     * @param request
     * @param response
     * @param number
     * @return
     */
    @RequestMapping("accountCert")
    public ModelAndView getAccountCertificate(HttpServletRequest request,
            HttpServletResponse response,
            String number) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountCertificate' controller...");
        }

        ModelAndView mav = new ModelAndView("jsonView");
        
        try {
			String certKey = SecurityUtil.getCertificationKey(number, 4);
			
			LOG.debug("certKey ::::" + certKey);
			
	        int row =0;
	        // 인증번호 문자 보내기
	        SendSmsVO sendSmsVO = new SendSmsVO();
	        sendSmsVO.setSmsType("S");  // S:단문(SMS), L:장문(LMS) 
	        sendSmsVO.setSubject("");//장문(LMS)인 경우(한글30자이내)
	        
	        //단문(SMS) : 최대 90byte까지 전송할 수 있으며, 잔여건수 1건이 차감됩니다.
	        //장문(LMS) : 한번에 최대 2,000byte까지 전송할 수 있으며 1회 발송당 잔여건수 3건이 차감됩니다.
	        sendSmsVO.setMsg("본인인증번호는 "+certKey+"입니다. 정확히 입력해주세요.");
	        sendSmsVO.setRphone(number); // 받는번호 : 예) 011-011-111 , '-' 포함해서 입력 ('-' 포함안되도 발송됨).
	        
	        sendSmsVO.setTestflag("");
	        
	        // 예약정보
	        sendSmsVO.setRepeatFlag("");
	        sendSmsVO.setRepeatNum("1");
	        sendSmsVO.setRepeatTime("15");
	        
	        sendSmsVO.setReturnurl("");
	        sendSmsVO.setNointeractive("");
	        
	        row = smsProcessor.sendSms(sendSmsVO);
	        
	        if (row > 0) {
	        
		        // 인증번호 DB 저장
		        TempCertVO tempCertVO = new TempCertVO();
		        tempCertVO.setMobile(number);
		        tempCertVO.setCertKey(certKey);
		        
		        // 기존 인증서 삭제
		        row = tempCertService.removeTempCert(tempCertVO);
		        // 신규 인증서 등록
		        row += tempCertService.addTempCert(tempCertVO);

		        if (row > 0){
					mav.addObject("result", "success");  // 성공시 원하는 페이지로 이동한다.
				}else{
					mav.addObject("result", "error");
				}
	        } else {
	        	mav.addObject("result", "error");
	        }
	        
		} catch (Exception e) {
			mav.addObject("result", "error");
			LOG.error(e);
		}

        return mav;

    }	

    /**
     * 저장된 인증번호와 발송된 인증번호 비교
     * @param request
     * @param response
     * @param keyNumber
     * @return
     */
    @RequestMapping("accountCertChk")
    public ModelAndView accountCertificateChk(HttpServletRequest request,
            HttpServletResponse response,
            TempCertVO tempCertVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountCertificateChk' controller...");
        }

        ModelAndView mav = new ModelAndView("jsonView");
        
        // 저장된 인증번호 DB 비고
        TempCertVO tempCertResultVO = tempCertService.getTempCert(tempCertVO);
        // 비교후 삭제
        tempCertService.removeTempCert(tempCertVO);

        if (tempCertResultVO != null) {
        	if (tempCertVO.getMobile().equals(tempCertResultVO.getMobile())){
        		mav.addObject("result", "success");  // 성공시 원하는 페이지로 이동한다.
        	} else {
        		mav.addObject("result", "error");
        	}
		}else{
			mav.addObject("result", "error");
		}

        return mav;

    }	
}
