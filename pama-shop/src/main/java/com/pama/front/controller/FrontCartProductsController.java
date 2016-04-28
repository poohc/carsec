package com.pama.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.ord.service.CartProductsService;
import com.pama.ord.vo.CartProductsListVO;
import com.pama.ord.vo.CartProductsVO;

@Controller
@RequestMapping("/ord/*")
public class FrontCartProductsController {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(FrontCartProductsController.class);

    /**
     * Service 생성
     */
    @Autowired
    private CartProductsService cartProductsService;

    /**
     * 장바구니 리스트
     * @param request
     * @param response
     * @param
     * @return
     */
    @RequestMapping("cartList")
    public ModelAndView getCartProductsList(HttpServletRequest request,
                                HttpServletResponse response,
                                CartProductsVO cartProductsVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getCartProductsList' controller...");
        }

        ModelAndView mav = new ModelAndView("front/ord/cartList");

        //-----------------------------------------------------------------------------
        // 로그인 정보
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //-----------------------------------------------------------------------------
        // 장바구니 리스트
        //-----------------------------------------------------------------------------
        cartProductsVO.setRegisterId(loginId);
        CartProductsListVO cartProductsListVO = cartProductsService.getCartProductsList(cartProductsVO);  // 장바구니 리스트 정보

        mav.addObject("cartProductsListVO", cartProductsListVO);

        return mav;
    }

    /**
     * 장바구니 등록
     * @param request
     * @param response
     * @param cartProductsVO
     * @return
     */
    @RequestMapping("cartAddProc")
    public ModelAndView addCartProducts(HttpServletRequest request,
            HttpServletResponse response,
            CartProductsVO cartProductsVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addCartProducts' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //qty, prdId
        cartProductsVO.setRegisterIp(request.getRemoteAddr());
        cartProductsVO.setRegisterId(loginId);
        cartProductsVO.setUpdateId(loginId);

        int updateCount = cartProductsService.addCartProducts(cartProductsVO);

        ModelAndView mav = new ModelAndView(new RedirectView("/ord/cartComplete.do"));
        mav.addObject("updateCount", updateCount); // updateCount > 0 이면 성공
        mav.addObject("prdId", cartProductsVO.getPrdId());

        return mav;
    }

    /**
     * 장바구니 등록 완료 (임시)
     * @param request
     * @param response
     * @param infoVO
     * @return
     */
    @RequestMapping("cartComplete")
    public ModelAndView cartComplete(HttpServletRequest request,
            HttpServletResponse response,
            CartProductsVO cartProductsVO,
            int updateCount){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'cartComplete' controller...");
        }

        ModelAndView mav = new ModelAndView("front/ord/cartComplete");

        mav.addObject("updateCount", updateCount); // updateCount > 0 이면 성공
        mav.addObject("prdId", cartProductsVO.getPrdId());

        return mav;
    }

    /**
     * 장바구니 상품 수량 변경
     * @param request
     * @param response
     * @param cartProductsVO
     * @return
     */
    @RequestMapping("cartQtyModify")
    public ModelAndView modifyCartProductsQty(HttpServletRequest request,
            HttpServletResponse response,
            CartProductsVO cartProductsVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'modifyCartProductsQty' controller...");
        }

        //-----------------------------------------------------------------------------
        // 로그인 정보 (임시)
        //-----------------------------------------------------------------------------
        String loginId = ""; // 로그인된 아이디
        if (SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request) != null){
            loginId = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request).getMbrId();
        }

        //qty, prdId, cartId
        cartProductsVO.setRegisterId(loginId);
        cartProductsVO.setUpdateId(loginId);
        cartProductsService.modifyCartProductsQty(cartProductsVO);

        ModelAndView mav = new ModelAndView(new RedirectView("/ord/cartList.do"));  // 변경후 refresh
        //mav.addObject("updateCount", updateCount);

        return mav;
    }

    /**
     * 장바구니 삭제
     * @param request
     * @param response
     * @param cartProductsVO
     * @return
     */
    @RequestMapping("cartRemoveProc")
    public ModelAndView removeCart(HttpServletRequest request,
            HttpServletResponse response,
            CartProductsVO cartProductsVO){
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeCart' controller...");
        }

        //prdId, cartId
        cartProductsService.removeCartProducts(cartProductsVO);

        ModelAndView mav = new ModelAndView(new RedirectView("/ord/cartList.do")); // 변경후 refresh
        //mav.addObject("removeCount", removeCount);

        return mav;

    }
}
