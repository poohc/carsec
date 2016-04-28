package com.pama.ord.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.common.util.ConvertUtil;
import com.pama.ord.dao.CartProductsDAO;
import com.pama.ord.dao.InfoDAO;
import com.pama.ord.dao.ProductsDAO;
import com.pama.ord.dao.ProductsOptDAO;
import com.pama.ord.dao.PurchaserDAO;
import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;
import com.pama.ord.vo.InfoVO;
import com.pama.ord.vo.OrderListVO;
import com.pama.ord.vo.OrderSearchVO;
import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsListVO;
import com.pama.ord.vo.ProductsOptVO;
import com.pama.ord.vo.ProductsVO;
import com.pama.prd.dao.ProductOptDAO;
import com.pama.prd.vo.ProductOptVO;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Log LOG = LogFactory.getLog(OrderService.class);

    @Autowired
    private InfoDAO infoDAO; // 주문 정보
    @Autowired
    private PurchaserDAO purchaserDAO; // 주문자 / 배송자 정보
    @Autowired
    private CartProductsDAO cartProductsDAO; // 장바구니
    @Autowired
    private ProductOptDAO productOptDAO; // 상품 옵션 정보
    @Autowired
    private ProductsDAO productsDAO; // 주문 상품 정보
    @Autowired
    private ProductsOptDAO productsOptDAO; // 주문 상품 옵션 정보

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getOrderList(com.pama.ord.vo.OrderSearchVO)
     */
    @Override
    public OrderListVO getOrderList(OrderSearchVO orderSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getOrderList' method...");
        }
        OrderListVO orderListVO = new OrderListVO();
        List<OrderVO> orderProductsList = new ArrayList<OrderVO>();

        int orderTotalCount = infoDAO.getListTotalCount(orderSearchVO);  // total count 구함
        List<OrderVO> orderList = infoDAO.getOrderList(orderSearchVO); // 주문 리스트 구함

        for(OrderVO orderVO : orderList){
            ProductsVO productsVO = new ProductsVO();
            productsVO.setOrdId(orderVO.getOrdId());
            List<ProductsVO> orderProductsVOList = productsDAO.getProductsList(productsVO);

            List<ProductsVO> orderProductsOptList = new ArrayList<ProductsVO>();
            
            for(ProductsVO productsVO1 : orderProductsVOList) {
            	ProductsOptVO productsOptVO = new ProductsOptVO();
            	productsOptVO.setOrdId(productsVO1.getOrdId());
            	productsOptVO.setPrdId(productsVO1.getPrdId());
            	List<ProductsOptVO> productOptList = productsOptDAO.getProductsOptList(productsOptVO);
            	
            	productsVO1.setProductsOptVO(productOptList);
            	
            	orderProductsOptList.add(productsVO1);
            }
            orderVO.setProductsVO(orderProductsOptList);

            orderProductsList.add(orderVO);
        }

        orderListVO.setOrderList(orderProductsList);   // 주문의 정보와 배송정보 리스트
        orderListVO.setOrderSearchVO(orderSearchVO);
        orderListVO.getOrderSearchVO().setTotalCount(orderTotalCount);

        return orderListVO;
    }

    @Override
    public ProductsListVO getOrderLicenseList(OrderSearchVO orderSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getOrderLicenseList' method...");
        }

        ProductsVO productsVO = new ProductsVO();
        productsVO.setRegisterId(orderSearchVO.getRegisterId());

        ProductsListVO productsListVO = new ProductsListVO();
        productsListVO.setOrderSearchVO(orderSearchVO);
        productsListVO.getOrderSearchVO().setTotalCount(productsDAO.getLicenseListTotalCount(productsVO));
        productsListVO.setProductsList(productsDAO.getProductsLicenseList(productsVO));

        return productsListVO;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getOrder(com.pama.ord.vo.InfoVO)
     */
    @Override
    public OrderVO getOrder(InfoVO infoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getOrder' method...");
        }

        OrderVO orderVO = infoDAO.getInfo(infoVO);

        ProductsVO productsVO = new ProductsVO();
        productsVO.setOrdId(orderVO.getOrdId());

        List<ProductsVO> orderProductList = new ArrayList<ProductsVO>();
        
        for ( ProductsVO products : productsDAO.getProductsList(productsVO)) {
        	ProductsOptVO productsOptVO = new ProductsOptVO();
        	productsOptVO.setOrdId(products.getOrdId());
        	productsOptVO.setPrdId(products.getPrdId());
        	
        	products.setProductsOpt(productsOptDAO.getProductsOptList(productsOptVO));
        	orderProductList.add(products);
        }
        
        orderVO.setProductsVO(orderProductList);

        return orderVO;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getOrderProductsForm(com.pama.ord.vo.CartProductsVO)
     */
    @Override
    public CartProductsListVO getOrderProductsForm(CartProductsVO cartProductsVO) {
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
        	int prdTotalPrice = 0; // 상품 옵션추가금액
        	if (cartProductsVO.getOptId() != null && !"".equals(cartProductsVO.getOptId())) {
        		List<ProductOptVO> productOptList = new ArrayList<ProductOptVO>();
	        	for ( String optId : cartProductsVO.getOptId() ) {
	        		ProductOptVO productOptVO = new ProductOptVO();
	        		productOptVO.setOptId(optId);
	        		productOptVO.setPrdId(cartProductsVO.getPrdId());
	        		for ( ProductOptVO productOpt : productOptDAO.getProductOptList(productOptVO)) {
	        			productOptList.add(productOpt);
	        			prdTotalPrice+=Integer.parseInt(productOpt.getOptPrice());
	        			totalPrice+=Integer.parseInt(productOpt.getOptPrice());
	        		}
	        	}
	        	cartProductsInfoVO.setProductOptVO(productOptList);
        	}
        	prdTotalPrice += (Integer.parseInt(cartProductsInfoVO.getPrice())) * cartProductsInfoVO.getQty();
        	cartProductsInfoVO.setSalePrice(String.valueOf(prdTotalPrice));
            // 주문가격 (상품가격  * 수량)
            totalPrice += (Integer.parseInt(cartProductsInfoVO.getPrice())) * cartProductsInfoVO.getQty();
            // 주문가격 ((상품가격 - 할인가격) * 수량)
            //totalPrice += (Integer.parseInt(cartProductsInfoVO.getPrice()) -  Integer.parseInt(cartProductsInfoVO.getSalePrice())) * cartProductsInfoVO.getQty();
        }
        if(totalPrice < 30000) deliveryPrice = 0; // 배송료 (3만원 이하면 2500원)
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
     * @see com.pama.ord.service.OrderService#addOrderProduct(com.pama.ord.vo.OrderVO)
     */
    @Override
    public String addOrderProduct(OrderVO orderVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'addOrderProduct' method...");
        }

        //주문제품내역 입력
        if (StringUtils.isNotEmpty(orderVO.getCartId())){  //CartId가 넘어 왔다면 장바구니 구매
            // 장바구니 구매는 CartId 이용하여 쿼리에서 처리
            int insertProducts = productsDAO.insertProducts(orderVO);

            // 주문된 장바구니 삭제
            if(insertProducts > 0){  // 장바구니의 상품이 구매상품 테이블에 모두 등록되었으면 장바구니 목록 삭제
                CartProductsVO cartProductsVO = new CartProductsVO();
                cartProductsVO.setCartId(orderVO.getCartId());
                cartProductsDAO.removeCartProducts(cartProductsVO);
            }

            orderVO.setOrdId(orderVO.getCartId());  // 장바구니 구매시 카트 id를 ordId에 넣는다.

        }else { // 즉시구매
            // 주문ID(ORD_ID) 생성    (장바구니 구매시는 생성 안함)
            try {
                orderVO.setOrdId(ConvertUtil.getOrdIdString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            productsDAO.insertProduct(orderVO);
            
        	for ( String optId : orderVO.getOptId() ) {
        		ProductOptVO productOptVO = new ProductOptVO();
        		productOptVO.setOptId(optId);
        		productOptVO.setPrdId(orderVO.getPrdId());
        		for ( ProductOptVO productOpt : productOptDAO.getProductOptList(productOptVO)) {
        			ProductsOptVO productsOptVO = new ProductsOptVO();
        			productsOptVO.setOrdId(orderVO.getOrdId());
        			productsOptVO.setOptId(productOpt.getOptId());
        			productsOptVO.setPrdId(productOpt.getPrdId());
        			productsOptVO.setOptName(productOpt.getOptName());
        			productsOptVO.setOptPrice(productOpt.getOptPrice());
        			productsOptDAO.insertProductsOpt(productsOptVO);
        		}
        	}
        }

        //주문정보 입력
        int info = infoDAO.insertInfo(orderVO); //입력
        int purchaser = 0;

        if(info > 0){ //주문정보 입력 성공시
            purchaser = purchaserDAO.insertPurchaser(orderVO); //배송자 /주문자 입력
        }

        String ordId = null;   // 주문완료후 주문완료 페이지로 이동하기 위한 주문ID
        if(info > 0){ //배송정보 입력 성공시
            ordId = orderVO.getOrdId();
        }

        return ordId; // ordId가 null 이 아니면 주문성공
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#modifyOrderStatusType(com.pama.ord.vo.InfoVO)
     */
    @Override
    public int modifyOrderStatusType(InfoVO infoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyOrderStatusType' method...");
        }
        return infoDAO.updateOrderStatusType(infoVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#modifyOrderRemove(com.pama.ord.vo.InfoVO)
     */
    @Override
    public int modifyOrderRemove(InfoVO infoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyOrderRemove' method...");
        }
        return infoDAO.updateOrderRemove(infoVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#modifyProductsLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public int modifyProductsLicense(ProductsVO productsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductsLicense' method...");
        }
        return productsDAO.updateProductsLicense(productsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getProductsList(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public List<ProductsVO> getProductsList(ProductsVO productsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductsList' method...");
        }
        return productsDAO.getProductsList(productsVO);
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getProductsLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public ProductsVO getProductsLicense(ProductsVO productsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductsLicense' method...");
        }
        return productsDAO.getProductsLicense(productsVO);
    }
    
    /* (non-Javadoc)
     * @see com.pama.ord.service.OrderService#getLicense(com.pama.ord.vo.ProductsVO)
     */
    @Override
    public ProductsVO getLicense(ProductsVO productsVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getLicense' method...");
        }
        return productsDAO.getLicense(productsVO);
    }
}
