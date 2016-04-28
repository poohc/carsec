package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.common.Constants;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.vo.AccountListVO;
import com.pama.mbr.vo.AccountSearchVO;

@Controller
@RequestMapping("/namecard/*")
public class FrontNameCardController {

    private static final Log LOG = LogFactory.getLog(FrontNameCardController.class);

    @Autowired
    private AccountInfoService accountInfoService;

	@Autowired
	private MessageService messageService;

    /**
     * 정보제공자 리스트
     * @param request
     * @param response
     * @param accountSearchVO
     * @return
     */
    @RequestMapping("namecard")
    public ModelAndView getAccountPagingList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountPagingList' controller...");
        }

        String[] levels = {"30","40"};
        accountSearchVO.setLevels(levels);
        accountSearchVO.setInfoApproval("2"); // 승인자
        //AccountListVO accountListVO = accountInfoService.getAccountInfoPagingList(accountSearchVO);  // 회원 리스트 정보
        ModelAndView mav = new ModelAndView("front/namecard/namecard");
        mav.addObject("accountListVO", new AccountListVO());

        return mav;
    }

    /**
     * 회원 리스트
     * @param request
     * @param response
     * @param accountSearchVO
     * @return
     */
    @RequestMapping("namecardMaster")
    public ModelAndView getAccountMasterPagingList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountMasterPagingList' controller...");
        }

        ModelAndView mav = new ModelAndView("front/namecard/namecard_master");


        String mbrLevel = String.valueOf(Constants.MBR_ACCOUNT_LEVEL_BUSINESS_A);
        MessageSearchVO messageSearchVO = new MessageSearchVO();
        messageSearchVO.setMbrLevel(mbrLevel);


        messageSearchVO.setBoardId("29"); // 29무료 정보
        messageSearchVO.setStartIndex(0);
        messageSearchVO.setEndIndex(5);
        MessageListVO bestFree = messageService.getMessageBestList(messageSearchVO);
        mav.addObject("bestFree", bestFree);

        messageSearchVO.setBoardId("30"); // 30유료 정보
        messageSearchVO.setStartIndex(0);
        messageSearchVO.setEndIndex(5);
        MessageListVO bestLicense = messageService.getMessageBestList(messageSearchVO);
        mav.addObject("bestLicense", bestLicense);

        accountSearchVO.setLevel(mbrLevel);
        accountSearchVO.setInfoApproval("2"); // 승인자
        //AccountListVO accountListVO = accountInfoService.getAccountInfoPagingList(accountSearchVO);  // 회원 리스트 정보

        mav.addObject("accountListVO", new AccountListVO());

        return mav;
    }

    /**
     * 회원 리스트
     * @param request
     * @param response
     * @param accountSearchVO
     * @return
     */
    @RequestMapping("namecardInfo")
    public ModelAndView getAccountInfoPagingList(HttpServletRequest request,
                                HttpServletResponse response,
                                AccountSearchVO accountSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getAccountInfoPagingList' controller...");
        }
        ModelAndView mav = new ModelAndView("front/namecard/namecard_info");

        String mbrLevel = String.valueOf(Constants.MBR_ACCOUNT_LEVEL_BUSINESS_B);
        MessageSearchVO messageSearchVO = new MessageSearchVO();
        messageSearchVO.setMbrLevel(mbrLevel);


        messageSearchVO.setBoardId("29"); // 29무료 정보
        messageSearchVO.setStartIndex(0);
        messageSearchVO.setEndIndex(5);
        MessageListVO bestFree = messageService.getMessageBestList(messageSearchVO);
        mav.addObject("bestFree", bestFree);

        messageSearchVO.setBoardId("30"); // 30유료 정보
        messageSearchVO.setStartIndex(0);
        messageSearchVO.setEndIndex(5);
        MessageListVO bestLicense = messageService.getMessageBestList(messageSearchVO);
        mav.addObject("bestLicense", bestLicense);

        accountSearchVO.setLevel(mbrLevel);
        accountSearchVO.setInfoApproval("2"); // 승인자
        //AccountListVO accountListVO = accountInfoService.getAccountInfoPagingList(accountSearchVO);  // 회원 리스트 정보

        mav.addObject("accountListVO", new AccountListVO());

        return mav;
    }
}
