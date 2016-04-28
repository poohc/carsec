package com.pama.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.carcheck.service.CarCheckService;
import com.pama.carcheck.vo.CarCheckQuestionVO;
import com.pama.carcheck.vo.CarCheckVO;
import com.pama.carestimate.service.CarEstimateService;
import com.pama.carestimate.vo.CarEstimateSearchVO;
import com.pama.carestimate.vo.CarEstimateVO;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;

@Controller
@RequestMapping("/check")
public class FrontCheckController {

    private static final Log LOG = LogFactory.getLog(FrontCheckController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CarCheckService carCheckService;

	 @Autowired
	 private CarEstimateService carEstimateService;

    @RequestMapping("check1.do")
    public ModelAndView getCheck1(HttpServletRequest request,
                                HttpServletResponse response){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCheck' controller...");
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("front/check/check1");
        return mav;
    }

    @RequestMapping("check1_1.do")
    public ModelAndView getCheck1_1(HttpServletRequest request,
    		HttpServletResponse response,
    		CarCheckVO carCheckVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'getCheck1_1' controller...");
    	}

    	ModelAndView mav = new ModelAndView();

		List<CarCheckVO> list = carCheckService.getCarCheckFirstList();

		mav.addObject("list", list);
    	mav.setViewName("front/check/check1_1");
    	return mav;
    }

    @RequestMapping("check2.do")
    public ModelAndView getCheck2(HttpServletRequest request,
    		HttpServletResponse response,
    		CarCheckVO carCheckVO){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'getCheck2' controller...");
    	}

    	ModelAndView mav = new ModelAndView();
    	CarCheckQuestionVO carCheckQuestionVO = carCheckService.getCarCheckNextList(carCheckVO);
    	mav.addObject("check", carCheckQuestionVO);

    	String viewName="front/check/check2";
    	if( StringUtils.equals(carCheckQuestionVO.getQuestionType(),"F") ){
    		viewName="front/check/check2_1";
    	}else {
    		viewName="front/check/check2";
    	}

    	mav.setViewName(viewName);

    	return mav;
    }

    @RequestMapping("addEstimate.do")
    public ModelAndView addEstimate(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam String qcodeTitle,
            @RequestParam String gcodeQcode,
            @RequestParam String companyAddr
    		){


    	CarEstimateVO carEstimateVO = new CarEstimateVO();

    	SessionVO sessionVO = SessionUtil.getFrontSession();

		//파라메터부분
		String requestId=sessionVO.getMbrId();
		String carCheckTitle = qcodeTitle;
		String carCheckGcodeQcode = gcodeQcode;
		String companyAddr2 = companyAddr;

		AccountVO accountVO =new AccountVO();
		accountVO .setMbrId(requestId);
		accountVO = accountService.getAccount(accountVO);

		carEstimateVO.setRequestId(accountVO.getMbrId());
		carEstimateVO.setRequestNickname(accountVO.getNickName());
		carEstimateVO.setRequestTel(accountVO.getMobile());
		
		carEstimateVO.setCarId(accountVO.getAccountCarInfoVO().getCarId());
		carEstimateVO.setModel(accountVO.getAccountCarInfoVO().getModel());
		carEstimateVO.setCarYear(accountVO.getAccountCarInfoVO().getCaryear());
		carEstimateVO.setMission(accountVO.getAccountCarInfoVO().getMission());
		carEstimateVO.setDistance(accountVO.getAccountCarInfoVO().getDistance());
		
		
		carEstimateVO.setCarCheckTitle(carCheckTitle);
		carEstimateVO.setCarCheckGcodeQcode(carCheckGcodeQcode);


		List<CarEstimateVO> companyList = carEstimateService.getMbrAccountMec(companyAddr2);
		int carEstimateId = 0;
		for (CarEstimateVO company : companyList) {

			String requestCompanyId = company.getRequestCompanyId();
			String requestCompanyName = company.getRequestCompanyName();
			carEstimateVO.setRequestCompanyId(requestCompanyId);
			carEstimateVO.setRequestCompanyName(requestCompanyName);
			carEstimateService.addCarEstimate(carEstimateVO);
			carEstimateId = carEstimateVO.getCarEstimateId();
		}

		ModelAndView mav = new ModelAndView("redirect:check2_finish.do?carEstimateId="+carEstimateId);
    	return mav;

    }

    @RequestMapping("check2_finish.do")
    public ModelAndView getCheck2_finish(HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestParam int carEstimateId){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCheck2_finish' controller...");
        }

        ModelAndView mav = new ModelAndView();
        SessionVO sessionVO = SessionUtil.getFrontSession();
        String requestId=sessionVO.getMbrId();

        CarEstimateVO carEstimateVO = new CarEstimateVO();
        carEstimateVO.setCarEstimateId(carEstimateId);
        carEstimateVO.setRequestId(requestId);

        carEstimateVO = carEstimateService.getCarEstimateOne(carEstimateVO);

        AccountVO accountVO =new AccountVO();
        if(carEstimateVO!=null){
	        String mbrId = carEstimateVO.getRequestCompanyId();
			accountVO.setMbrId(mbrId);
			accountVO = accountService.getAccount(accountVO);
        }

		mav.addObject("accountVO", accountVO);
		mav.addObject("carEstimateVO", carEstimateVO);


        mav.setViewName("front/check/check2_finish");
        return mav;
    }


    @RequestMapping("caritemmap.do")
    public ModelAndView getCheck3(HttpServletRequest request,
    		HttpServletResponse response,
    		MessageSearchVO messageSearchVO
    		){
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("starting 'getCheck' controller...");
    	}

    	ModelAndView mav = new ModelAndView();

    	if(StringUtils.isEmpty(messageSearchVO.getMessageCategoryId())){
    		messageSearchVO.setMessageCategoryId("21");
    	}

    	messageSearchVO.setStatusType("2");
    	BoardVO boardVO = boardService.getBoard("caritemmap");

    	messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
		messageSearchVO.setRow(500);
		MessageListVO messageList = messageService.getMessageList(messageSearchVO);

		if( StringUtils.isNotEmpty(messageSearchVO.getMessageId()) && Integer.parseInt(messageSearchVO.getMessageId()) > 0){
			MessageVO messageVO = messageService.getMessageOne(messageSearchVO);
			if( Integer.parseInt(messageVO.getBoardId()) == boardVO.getBoardId() ){
				mav.addObject("message", messageVO);
			}
		}

		mav.addObject("boardVO", boardVO);
		mav.addObject("messageList", messageList);

    	mav.setViewName("front/check/caritemmap");
//
    	return mav;
    }

}