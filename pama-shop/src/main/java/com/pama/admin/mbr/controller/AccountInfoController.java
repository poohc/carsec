package com.pama.admin.mbr.controller;

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

import com.pama.common.Constants;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountListVO;
import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/admin/account/info/*")
public class AccountInfoController {

	private static final Log LOG = LogFactory.getLog(AccountInfoController.class);

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

	/**
	 * 정보원 등록
	 * @param request
	 * @param response
	 * @param accountVO
	 * @return
	 */
	@RequestMapping("accountCarInfoForm")
	public ModelAndView accountCarInfoForm(HttpServletRequest request,
			HttpServletResponse response,
			AccountCarInfoVO accountCarInfoVO){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'accountCarInfoForm' controller...");
		}

		ModelAndView mav = new ModelAndView();

		// 회원정보 수정일때만
		if  (StringUtils.isNotEmpty(accountCarInfoVO.getMbrId())){
			mav.addObject("accountFormVO", accountInfoService.getAccountCarInfo(accountCarInfoVO));
		}

		return mav;
	}

	@RequestMapping("accountCarInfoFormProc")
	public ModelAndView accountCarInfoFormProc(HttpServletRequest request,
			HttpServletResponse response,
			AccountCarInfoVO accountCarInfoVO) throws IllegalStateException, IOException{
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'accountCarInfoFormProc' controller...");
		}

		accountInfoService.modifyAccountCarInfo(accountCarInfoVO);

		return new ModelAndView("redirect:accountCarInfoForm.do?mbrId="+accountCarInfoVO.getMbrId());
	}

	@RequestMapping("removeAccountCarInfo")
	public ModelAndView removeAccountInfo(HttpServletRequest request,
			HttpServletResponse response,
			AccountCarInfoVO accountCarInfoVO) throws IllegalStateException, IOException{
		int row=0;
		row = accountInfoService.removeAccountCarInfo(accountCarInfoVO);
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("row", row);

		return mav;
	}


}
