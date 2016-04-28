package com.pama.ord.service;

import com.pama.ord.vo.WishProductsListVO;
import com.pama.ord.vo.WishProductsVO;

public interface WishProductsService {

    /**
     * 찜하기 목록
     * 페이징처리, 검색, 정렬 하지 않음
     * @param wishProductsVO
     * @return
     */
    public WishProductsListVO getWishProductsList(WishProductsVO wishProductsVO);

    /**
     * 찜하기 등록
     * @param wishProductsVO
     * @return
     */
    public int addWishProducts(WishProductsVO wishProductsVO);

    /**
     * 찜하기 삭제
     * @param wishProductsVO
     * @return
     */
    public int removeWishProducts(WishProductsVO wishProductsVO);
}
