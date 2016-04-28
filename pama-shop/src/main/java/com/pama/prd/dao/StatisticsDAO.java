package com.pama.prd.dao;

import com.pama.prd.vo.StatisticsVO;

public interface StatisticsDAO {

    /**
     * 조회
     * @param StatisticsVO
     * @return
     */
    public StatisticsVO getStatistics(StatisticsVO statisticsVO);

    /**
     * 통계 추가
     * @param StatisticsVO
     * @return
     */
    public int insertStatistics(StatisticsVO statisticsVO);

    /**
     * 통계 Count 업데이트
     * @param StatisticsVO
     * @return
     */
    public int updateStatisticsCount(StatisticsVO statisticsVO);

}
