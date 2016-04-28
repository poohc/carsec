package com.pama.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.MessageVO;
import com.pama.common.util.ConvertUtil;
import com.pama.mbr.service.AccountInfoService;

@Controller
@RequestMapping("/main")
public class FrontMainController {

	private static final Log LOG = LogFactory.getLog(FrontMainController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private AccountInfoService accountInfoService;

	/**
	 * main페이지
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("main.do")
	public ModelAndView getMainPage(HttpServletRequest request,
			HttpServletResponse response){
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'getMainPage' controller...");
		}


		ModelAndView mav = new ModelAndView();
		getMessage(mav, "notice1", 3);
		getMessage(mav, "notice2", 3);
		getMessage(mav, "freeboard", 6);
		getMessage(mav, "accident", 6);
		getMessage(mav, "carnews", 5);
		getMessage(mav, "recallnews", 5);
		getMessage(mav, "carcheck", 5);
		getMessage(mav, "trafficlaw", 5);
		getMessage(mav, "drivecourse", 5);
		getMessage(mav, "carnpeople", 5);
		getMessage(mav, "recruit2", 6);

		mav.setViewName("front/main/main");
		//
		return mav;
	}

	private void getMessage(ModelAndView mav, String boardKey, int row){

		List<MessageVO> list = messageService.getMessageMainList(boardKey, row);

		mav.addObject(boardKey, list);
	}

}