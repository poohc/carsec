package com.pama.ord.service;

import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;

public interface CartProductsService {

    /**
     * 장바구니 목록
     * 페이징처리, 검색, 정렬 하지 않음
     * @param cartProductsVO
     * @return
     */
    public CartProductsListVO getCartProductsList(CartProductsVO cartProductsVO);

    /**
     * 장바구니 등록
     * @param cartProductsVO
     * @return
     */
    public int addCartProducts(CartProductsVO cartProductsVO);

    /**
     * 장바구니 상품 수량 변경
     * @param cartProductsVO
     * @return
     */
    public int modifyCartProductsQty(CartProductsVO cartProductsVO);

    /**
     * 장바구니 삭제
     * @param cartProductsVO
     * @return
     */
    public int removeCartProducts(CartProductsVO cartProductsVO);

}
