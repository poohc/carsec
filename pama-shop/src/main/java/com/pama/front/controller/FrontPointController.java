package com.pama.front.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.BoardService;
import com.pama.bbs.service.MessageService;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageStatVO;
import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;
import com.pama.mbr.service.AccountInfoService;
import com.pama.mbr.service.AccountService;
import com.pama.mbr.vo.AccountVO;
import com.pama.mbrpoint.service.PointService;
import com.pama.mbrpoint.vo.PointListVO;
import com.pama.mbrpoint.vo.PointSearchVO;
import com.pama.mbrpoint.vo.PointVO;
import com.pama.ord.service.OrderService;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.prd.service.ProductService;
import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;
import com.pama.processor.AttachmentProcessor;

@Controller
@RequestMapping("/point/*")
public class FrontPointController {

	private static final Log LOG = LogFactory.getLog(FrontPointController.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private AttachmentProcessor attachmentProcessor;

	@Autowired
	private PointService pointService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductService productService;

	@Autowired
	OrderService orderService;

	@Autowired
	private AccountInfoService accountInfoService;



	/**
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("/pointCharging")
	public ModelAndView pointCharging(
			HttpServletRequest request,
			HttpServletResponse response
			){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointCharging' controller...");
		}
		ModelAndView mav = new ModelAndView("front/web/etc/charging");

		ProductSearchVO productSearchVO = new ProductSearchVO();

		//상품 정보 리스트
		ProductListVO productListVO = productService.getProductList(productSearchVO);

		mav.addObject("productSearchVO", productSearchVO);
		mav.addObject("productListVO", productListVO);


		return mav;

	}

	/**
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("/pointChargingNonpgbank")
	public ModelAndView pointChargingNonpgbank(
			HttpServletRequest request,
			HttpServletResponse response,
			ProductSearchVO productSearchVO
			){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointCharging' controller...");
		}
		ModelAndView mav = new ModelAndView("front/web/etc/charging-nonpgbank");


		//상품 정보 리스트
		ProductVO productVO = productService.getProduct(productSearchVO);

		mav.addObject("productSearchVO", productSearchVO);
		mav.addObject("productVO", productVO);


		return mav;

	}

	/**
	 * 결재내역
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("/pointChargingList")
	public ModelAndView pointChargingList(
			HttpServletRequest request,
			HttpServletResponse response,
			OrderSearchVO orderSearchVO
			){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointCharging' controller...");
		}
		ModelAndView mav = new ModelAndView("front/web/etc/charging_list");

		SessionVO sessionVO = SessionUtil.getFrontSession();

		if(sessionVO !=null ){
			String registerId=sessionVO.getMbrId();
			orderSearchVO.setRegisterId(registerId);//자기자신것만.
			OrderListVO orderListVO = orderService.getOrderList(orderSearchVO);
			mav.addObject("orderListVO", orderListVO);
		}

		return mav;

	}

	/**
	 * 사용내역
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("/pointChargingList2")
	public ModelAndView pointUsingList(
			HttpServletRequest request,
			HttpServletResponse response,
			PointSearchVO pointSearchVO
			){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'pointChargingList2' controller...");
		}
		ModelAndView mav = new ModelAndView("front/web/etc/charging_list2");


		SessionVO sessionVO = SessionUtil.getFrontSession();
		PointListVO pointListVO = new PointListVO();
		if(sessionVO !=null ){
			String mbrId=sessionVO.getMbrId();
			pointSearchVO.setMbrId(mbrId);//자기자신것만.
			pointSearchVO.setPointFlag(Constants.MBR_POINT_FLAG_USE);//사용한건만
			pointListVO = pointService.getPointList(pointSearchVO);
		}

		mav.addObject("pointListVO", pointListVO);


		return mav;

	}

	/**
	 * 정보원 수입금 내역
	 * @param request
	 * @param response
	 * @param zipcodeVO
	 * @return
	 */
	@RequestMapping("/infoPointlist")
	public ModelAndView infoPointlist(
			HttpServletRequest request,
			HttpServletResponse response,
			PointSearchVO pointSearchVO
			){

		if ( LOG.isDebugEnabled() ) {
			LOG.debug("starting 'infoPointlist' controller...");
		}


		ModelAndView mav = new ModelAndView("front/skin/board/stock/cafeInfoPointlist");
		if(pointSearchVO.getYear() == null){ //Non Parameter

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
			String currentyyyyMM= simpleDateFormat.format(new Date());
			pointSearchVO.setYear(StringUtils.left(currentyyyyMM , 4));
			pointSearchVO.setMonth(StringUtils.right(currentyyyyMM , 2));

		}else{

			int parseMonthInt = Integer.parseInt(pointSearchVO.getMonth());
			pointSearchVO.setMonth((parseMonthInt < 10 ? "0":"")+pointSearchVO.getMonth());

		}

		pointSearchVO.setRegisterDate(pointSearchVO.getYear()+pointSearchVO.getMonth());

		SessionVO sessionVO = SessionUtil.getFrontSession();
		List<PointVO> pointUseSummaryList  = new ArrayList<PointVO>();
		if(sessionVO !=null ){

			String mbrInfoId = request.getParameter("infoid");
			AccountVO  accountVO = accountInfoService.getAccountInfo(mbrInfoId);
			mav.addObject("ACCOUNTVO", accountVO);
			MessageSearchVO messageSearchVO = new MessageSearchVO();
			messageSearchVO.setRegisterId(accountVO.getMbrId());

			MessageStatVO messageStatVO = messageService.getMessageStat(messageSearchVO);
			mav.addObject("messageStatVO", messageStatVO);


			pointSearchVO.setMessageRegisterId(sessionVO.getMbrId());
			pointUseSummaryList= pointService.getPointUseSummaryList(pointSearchVO);
		}

		int pointSummaryTotalSumPoint = 0;
		int pointSummaryTotalSettlPoint = 0;

		for (PointVO pointVO : pointUseSummaryList) {
			pointSummaryTotalSumPoint += pointVO.getSumPoint();
			pointSummaryTotalSettlPoint += pointVO.getSettlPoint();
		}

		mav.addObject("pointSearchVO", pointSearchVO);
		mav.addObject("pointUseSummaryList", pointUseSummaryList);
		mav.addObject("pointSummaryTotalSumPoint", pointSummaryTotalSumPoint);
		mav.addObject("pointSummaryTotalSettlPoint", pointSummaryTotalSettlPoint);


		return mav;

	}
}
