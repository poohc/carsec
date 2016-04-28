package com.pama.prd.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.common.Constants;
import com.pama.prd.dao.StatisticsDAO;
import com.pama.prd.vo.StatisticsVO;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(StatisticsService.class);

    /**
     * StatisticsBiz 객체 정의.
     */
    @Autowired
    private StatisticsDAO statisticsDAO;

    /* (non-Javadoc)
     * @see com.pama.prd.service.StatisticsService#addProductStatistics(com.pama.prd.vo.StatisticsVO)
     */
    @Override
    public int addProductStatistics(StatisticsVO statisticsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addProductStatistics' method...");
        }
        int row = 0;

        // 현재 등록하려는 상품이 이미 등록되어 있는지 prdId로 확인한다.
        StatisticsVO statisticsInfoVO = statisticsDAO.getStatistics(statisticsVO);

        if (statisticsInfoVO != null){ //이미 등록되어 있다면

            // 기존에 등록된 prdId에 count +1 한다.
            row = statisticsDAO.updateStatisticsCount(statisticsVO);

        }else { //등록되어 있지 않다면

            // 새로 insert 한다.
            statisticsVO.setStatusType(Constants.PRODUCT_STATISTICS_STATUS_TYPE);
            statisticsVO.setStatisticsCount(Constants.PRODUCT_STATISTICS_STATISTICS_COUNT);
            row = statisticsDAO.insertStatistics(statisticsVO);
        }
        return row;

    }

}
