package com.pama.ord.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.common.util.ConvertUtil;
import com.pama.ord.dao.CartProductsDAO;
import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;

@Service
public class CartProductsServiceImpl implements CartProductsService {

    private static final Log LOG = LogFactory.getLog(CartProductsService.class);

    @Autowired
    private CartProductsDAO cartProductsDAO;

    /* (non-Javadoc)
     * @see com.pama.ord.service.CartProductsService#getCartProductsList(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public CartProductsListVO getCartProductsList(CartProductsVO cartProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getCartProductsList' method...");
        }
        CartProductsListVO cartProductsListVO = new CartProductsListVO();

        List<CartProductsVO> cartProductsList = null;
        if(cartProductsVO.getPrdId() != null && !"".equals(cartProductsVO.getPrdId())){
            cartProductsList = cartProductsDAO.getCartProductList(cartProductsVO);  // 즉시 구매시 리스트
        }else{
           cartProductsList = cartProductsDAO.getCartProductsList(cartProductsVO);  // 장바구니 리스트
        }

        //-----------------------------------------------------------------------------
        // 총주문가격, 배송가격, 주문결재 가격 계산
        //-----------------------------------------------------------------------------
        int totalPrice = 0; //총주문가격
        int deliveryPrice = 0; // 배송가격
        int settlePrice = 0; // 주문결재 가격

        for(CartProductsVO cartProductsInfoVO : cartProductsList){
            // 주문가격 (상품가격  * 수량)
            totalPrice += (Integer.parseInt(cartProductsInfoVO.getPrice())) * cartProductsInfoVO.getQty();
            // 주문가격 ((상품가격 - 할인가격) * 수량)
            //totalPrice += (Integer.parseInt(cartProductsInfoVO.getPrice()) -  Integer.parseInt(cartProductsInfoVO.getSalePrice())) * cartProductsInfoVO.getQty();
        }
        if(totalPrice < 30000) deliveryPrice = 2500; // 배송료 (3만원 이하면 2500원)
        settlePrice = totalPrice + deliveryPrice;  // 결재금액

        //배송료및 총결산 금액
        cartProductsListVO.setTotalPrice(totalPrice); // 총주문가격
        cartProductsListVO.setDeliveryPrice(deliveryPrice); // 배송가격
        cartProductsListVO.setSettlePrice(settlePrice); // 주문결재 가격

        // 장바구니 리스트
        cartProductsListVO.setCartProductsList(cartProductsList);

        return cartProductsListVO;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.CartProductsService#addCartProducts(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int addCartProducts(CartProductsVO cartProductsVO) {

        //-----------------------------------------------------------------------------------------------------------
        // 현재 등록하려는 ID로 CART_ID가 등록되어 있다면 그 CART_ID 를  등록한다. 그러기 위해서 int i 를 사용한다.
        // i=0이면 갯수만 업데이트,  i=1이면 등록된 정보 없음 CART_ID생성하여 insert , i>1 이면 이미 등록된 CART_ID를 등록.
        //------------------------------------------------------------------------------------------------------------

        //현재 ID로 등록된 동일 상품이 있는지 검색
        List<CartProductsVO> cartProductsLists = cartProductsDAO.getCartProductsList(cartProductsVO); //REGISTER_ID로 등록된 장바구니를 검색해온다.

        int i = 1; // CART_ID를 어떤것으로 등록할지를 결정하기 위해 필요
        String cartId = ""; // 이미 생성되어 있는 cartId를 담는데 사용한다.
        int row = 0;

        //가져온 리스트중에 현재 등록하려고 하는 상품이 있는지 찾아본다
        for (CartProductsVO cartProductsList : cartProductsLists) {

            if(i==1) cartId = cartProductsList.getCartId(); // 이미 등록된 CART_ID를 첫번째 LOOP가 돌때  cartId 에 담는다. (i>1 일때 사용)

            if (cartProductsVO.getPrdId() != null && cartProductsList.getPrdId().equals(cartProductsVO.getPrdId())){   // 같은 PRD_ID가 이미 등록되어 있다면.

                //갯수만 업데이트
                cartProductsVO.setCartId(cartProductsList.getCartId());
                cartProductsVO.setPrdId(cartProductsList.getPrdId()); // 이미 전단계에서 넘겼으므로 필요 없음. 테스트후 삭제.
                cartProductsVO.setQty(cartProductsList.getQty() + cartProductsVO.getQty());  // 현재 수량과 추가하려는 수량을 더하기.

                row = cartProductsDAO.updateCartProducts(cartProductsVO); // 수량 업데이트

                i = 0; // 이미 갯수만 업데이트 했으므로 insert 할 필요 없다.
                break;
            }
            i++;
        }

        if(i != 0){ // i가 0 이면 갯수만 업데이트 (위에서 업데이트 했으므로 아래는 타지 않음.)
            if(i == 1) {  //등록된 CART_ID가 없음 CART_ID를 생성.
                // 임시 주문ID(CART_ID) 생성
                try {
                    cartProductsVO.setCartId(ConvertUtil.getOrdIdString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(i > 1){ //등록된 CART_ID가 이미 있음  이미 등록된 CART_ID 사용.
                cartProductsVO.setCartId(cartId);
            }
             //추가
            row = cartProductsDAO.insertCartProducts(cartProductsVO);
        }
        return row;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.CartProductsService#removeCartProducts(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int removeCartProducts(CartProductsVO cartProductsVO) {
        //삭제
        int row = cartProductsDAO.removeCartProducts(cartProductsVO);
        return row;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.CartProductsService#modifyCartProductsQty(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public int modifyCartProductsQty(CartProductsVO cartProductsVO) {

        int row = cartProductsDAO.updateCartProducts(cartProductsVO); // 수량 업데이트
        return row;
    }

}
