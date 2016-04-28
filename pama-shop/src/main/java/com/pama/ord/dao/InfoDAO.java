package com.pama.ord.dao;

import java.util.List;

import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;

public interface InfoDAO {

    /**
     * 목록전체갯수조회
     * @param orderSearchVO
     * @return
     */
    public int getListTotalCount(OrderSearchVO orderSearchVO);

    /**
     * 목록조회
     * @param orderSearchVO
     * @return
     */
    public List<OrderVO> getOrderList(OrderSearchVO orderSearchVO);

    /**
     * 상세
     * @param infoVO
     * @return
     */
    public OrderVO getInfo(InfoVO infoVO);

    /**
     * 주문정보 등록
     * @param InfoVO
     * @return
     */
    public int insertInfo(OrderVO orderVO);

    /**
     * 주문정보 수정
     * @param InfoVO
     * @return
     */
    public int updateInfo(InfoVO infoVO);

    /**
     * 주문상태 정보 수정
     * @param InfoVO
     * @return
     */
    public int updateOrderStatusType(InfoVO infoVO);

    /**
     * 주문 삭제
     * @param InfoVO
     * @return
     */
    public int updateOrderRemove(InfoVO infoVO);

}
