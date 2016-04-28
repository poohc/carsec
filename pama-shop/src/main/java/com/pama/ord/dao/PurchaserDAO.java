package com.pama.ord.dao;

import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.PurchaserVO;

public interface PurchaserDAO {

    /**
     * 주문자/받는자 상세
     * @param PurchaserVO
     * @return
     */
    public PurchaserVO getPurchaser(PurchaserVO purchaserVO);

    /**
     * 주문자/받는자 정보등록
     * @param PurchaserVO
     * @return
     */
    public int insertPurchaser(OrderVO orderVO);

    /**
     * 주문자/받는자 정보수정
     * @param PurchaserVO
     * @return
     */
    public int updatePurchaser(PurchaserVO purchaserVO);

}
