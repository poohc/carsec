package com.pama.ord.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.ord.dao.WishProductsDAO;
import com.pama.ord.vo.WishProductsListVO;
import com.pama.ord.vo.WishProductsVO;

@Service
public class WishProductsServiceImpl implements WishProductsService {

    private static final Log LOG = LogFactory.getLog(WishProductsService.class);

    @Autowired
    private WishProductsDAO wishProductsDAO;

    /* (non-Javadoc)
     * @see com.pama.ord.service.WishProductsService#getWishProductsList(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public WishProductsListVO getWishProductsList(WishProductsVO wishProductsVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getWishProductsList' method...");
        }
        WishProductsListVO wishProductsListVO = new WishProductsListVO();
        List<WishProductsVO> wishProductsList = wishProductsDAO.getWishProductsList(wishProductsVO);

        wishProductsListVO.setWishProductsList(wishProductsList);

        return wishProductsListVO;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.WishProductsService#addWishProducts(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public int addWishProducts(WishProductsVO wishProductsVO) {

        //추가
        int row = wishProductsDAO.insertWishProducts(wishProductsVO);

        return row;
    }

    /* (non-Javadoc)
     * @see com.pama.ord.service.WishProductsService#removeWishProducts(com.pama.ord.vo.WishProductsVO)
     */
    @Override
    public int removeWishProducts(WishProductsVO wishProductsVO) {
        //삭제
        int row = wishProductsDAO.removeWishProducts(wishProductsVO);

        return row;
    }


}
