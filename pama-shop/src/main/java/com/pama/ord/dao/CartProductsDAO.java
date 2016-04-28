package com.pama.ord.dao;

import java.util.List;

import com.pama.ord.vo.CartProductsVO;

public interface CartProductsDAO {
    /**
     * 장바구니 등록
     * @param CartProductsVO
     * @return
     */
    public int insertCartProducts(CartProductsVO cartProductsVO);

    /**
     * 장바구니 수정
     * @param CartProductsVO
     * @return
     */
    public int updateCartProducts(CartProductsVO cartProductsVO);

    /**
     * 장바구니 삭제
     * @param CartProductsVO
     * @return
     */
    public int removeCartProducts(CartProductsVO cartProductsVO);

    /**
     * 장바구니 목록
     * @param CartProductsVO
     * @return
     */
    public List<CartProductsVO> getCartProductsList(CartProductsVO cartProductsVO);

    /**
     * 장바구니 목록 (즉시구매시)
     * @param CartProductsVO
     * @return
     */
    public List<CartProductsVO> getCartProductList(CartProductsVO cartProductsVO);
}
