package com.pama.mbr.aspect;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.carestimate.service.CarEstimateService;
import com.pama.carestimate.vo.CarEstimateVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;

@Aspect
public class AccountAspect {

	@Pointcut("execution(public * com.pama..*Controller.*(..))")
	private void controllerMethod(){}

	@Autowired
	private AccountService accountService;

	@Autowired
	private CarEstimateService carEstimateService;

	@Autowired
	private MessageService messageService;

	@Before("controllerMethod()")
	public void beforeMethod(JoinPoint joinPoint) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		if(!StringUtils.startsWith((String)request.getAttribute("currentURI"),"/admin") ){

			SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
			if(sessionVO != null){
				String mbrId=sessionVO.getMbrId();
				AccountVO accountVO = new AccountVO();
				accountVO.setMbrId(mbrId);

				accountVO  = accountService.getAccount(accountVO);
				CarEstimateVO carEstimateVO = new CarEstimateVO();

				if(accountVO.getLevel()==10){
					carEstimateVO .setRequestId(mbrId);
					carEstimateVO= carEstimateService.getCarEstimateCount(carEstimateVO);
				}else if(accountVO.getLevel()==30 || accountVO.getLevel()==40  ){
					carEstimateVO .setRequestCompanyId(mbrId);
					carEstimateVO= carEstimateService.getCarEstimateCount(carEstimateVO);
				}

				request.setAttribute("carEstimate", carEstimateVO);
				request.setAttribute("mbrDbVO", accountVO);

			}


			MessageSearchVO messageSearchVO = new MessageSearchVO();
			messageSearchVO.setBoardKey("notice4");
			List<MessageVO> notice4 = messageService.getRandomMessages(messageSearchVO);


			getMessage(request, "notice1", 1);
			getMessage(request, "notice2", 1);
			getMessage(request, "notice3", 1);
			getMessage(request, "notice4", 2);
			getMessage(request, "usereviews", 4);


			request.setAttribute("randomNotice", notice4);

		}

	}

	private void getMessage(HttpServletRequest request, String boardKey, int row){

		List<MessageVO> list = messageService.getMessageMainList(boardKey, row);
		request.setAttribute("aspect"+boardKey, list);
	}
}
