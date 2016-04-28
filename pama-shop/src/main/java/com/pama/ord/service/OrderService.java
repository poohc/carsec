package com.pama.ord.service;

import java.util.List;

import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;
import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsListVO;
import com.pama.ord.vo.ProductsVO;

public interface OrderService {

    /**
     * 주문 목록
     * 구매정보, 배송정보, 구매한 상품 목록 을 리스트 형식으로 (상세페이지에 보일것들을 다 여기서 보여준다.)
     * @param orderSearchVO
     * @return
     */
    public OrderListVO getOrderList(OrderSearchVO orderSearchVO);

    /**
     * 사용중인 라이센트 리스트
     * @param orderSearchVO
     * @return
     */
    public ProductsListVO getOrderLicenseList(OrderSearchVO orderSearchVO);

    /**
     * 주문 상세
     * @param infoVO
     * @return
     */
    public OrderVO getOrder(InfoVO infoVO);

    /**
     * 주문  구매  Form
     * 구매하기 form 은 컨트롤에서 CartID가 넘어오면 getOrderProductsForm를 안넘어오면 getOrderProductForm를 호출하여 처리
     * @param cartProductsVO
     * @return
     */
    public CartProductsListVO getOrderProductsForm(CartProductsVO cartProductsVO);

    /**
     * 주문
     * @param orderVO
     * @return
     */
    public String addOrderProduct(OrderVO orderVO);

    /**
     * 주문상태정보 변경
     * @param infoVO
     * @return
     */
    public int modifyOrderStatusType(InfoVO infoVO);

    /**
     * 주문 삭제
     * @param infoVO
     * @return
     */
    public int modifyOrderRemove(InfoVO infoVO);

    /**
     * 라이센스 코드 부여
     * @param productsVO
     * @return
     */
    public int modifyProductsLicense(ProductsVO productsVO);

    /**
     * 주문 상품 목록
     * @param orderSearchVO
     * @return
     */
    public List<ProductsVO> getProductsList(ProductsVO productsVO);

    /**
     * 구매상품 정보 가져오기
     * @param productsVO
     * @return
     */
    public ProductsVO getProductsLicense(ProductsVO productsVO);
    
    /**
     * 쿠폰번호 가져오기
     * @param productsVO
     * @return
     */
    public ProductsVO getLicense(ProductsVO productsVO);
}
