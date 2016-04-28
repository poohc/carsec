package com.pama.prd.service;

import com.pama.prd.vo.StatisticsVO;;

public interface StatisticsService {

    /**
     * 상품구매 시 통계 등록
     * @param statisticsVO
     * @return
     */
    public int addProductStatistics(StatisticsVO statisticsVO);

}
