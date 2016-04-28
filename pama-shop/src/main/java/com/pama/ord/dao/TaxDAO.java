package com.pama.ord.dao;

import java.util.List;

import com.pama.ord.vo.TaxSearchVO;
import com.pama.ord.vo.TaxVO;

public interface TaxDAO {

    /**
     * 목록전체갯수조회
     * @param taxSearchVO
     * @return
     */
    public int getListTotalCount(TaxSearchVO taxSearchVO);

    /**
     * 목록조회
     * @param taxSearchVO
     * @return
     */
    public List<TaxVO> getTaxList(TaxSearchVO taxSearchVO);

    /**
     * 상세
     * @param taxVO
     * @return
     */
    public TaxVO getTax(TaxVO taxVO);

    /**
     * 추가
     * @param taxVO
     * @return
     */
    public int insertTax(TaxVO taxVO);

    /**
     * 수정
     * @param taxVO
     * @return
     */
    public int updateTax(TaxVO taxVO);

    /**
     * 삭제
     * @param taxVO
     * @return
     */
    public int removeTax(TaxVO taxVO);

}
