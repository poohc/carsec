package com.pama.ord.dao;

import java.util.List;

import com.pama.ord.vo.WishProductsVO;


public interface WishProductsDAO {

    /**
     * 찜하기 리스트
     * @param WishProductsVO
     * @return
     */
     public List<WishProductsVO> getWishProductsList(WishProductsVO wishProductsVO);

    /**
     * 찜하기 등록
     * @param WishProductsVO
     * @return
     */
    public int insertWishProducts(WishProductsVO wishProductsVO);

    /**
     * 찜하기 삭제
     * @param WishProductsVO
     * @return
     */
    public int removeWishProducts(WishProductsVO wishProductsVO);


}
