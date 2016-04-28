package com.pama.admin.mbrpoint.controller;

import java.text.SimpleDateFormat;
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

import com.pama.mbrpoint.service.PointService;
import com.pama.mbrpoint.vo.PointSearchVO;
import com.pama.mbrpoint.vo.PointVO;

@Controller
@RequestMapping("/admin/point/*")
public class AdminPointController {

    private static final Log LOG = LogFactory.getLog(AdminPointController.class);

    @Autowired
    private PointService pointService;

    @RequestMapping("pointUseSummaryList")
    public ModelAndView getPointUseSummaryList(HttpServletRequest request,
                                HttpServletResponse response,
                                PointSearchVO pointSearchVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'pointUseSummaryList' controller...");
        }

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



        List<PointVO> pointUseSummaryList = pointService.getPointUseSummaryList(pointSearchVO);
        int pointSummaryTotalSumPoint = 0;
        int pointSummaryTotalSettlPoint = 0;

        for (PointVO pointVO : pointUseSummaryList) {

        	pointSummaryTotalSumPoint += pointVO.getSumPoint();
        	pointSummaryTotalSettlPoint += pointVO.getSettlPoint();

		}

        ModelAndView mav = new ModelAndView("admin/point/pointUseSummaryList");
        mav.addObject("pointSearchVO", pointSearchVO);
        mav.addObject("pointUseSummaryList", pointUseSummaryList);
        mav.addObject("pointSummaryTotalSumPoint", pointSummaryTotalSumPoint);
        mav.addObject("pointSummaryTotalSettlPoint", pointSummaryTotalSettlPoint);

        return mav;
    }



}

