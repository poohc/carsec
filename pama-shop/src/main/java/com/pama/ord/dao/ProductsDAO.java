package com.pama.ord.dao;

import java.util.List;

import com.pama.ord.vo.OrderVO;
import com.pama.ord.vo.ProductsVO;

public interface ProductsDAO {

    /**
     * 목록조회
     * @param ProductsVO
     * @return
     */
    public List<ProductsVO> getProductsList(ProductsVO productsVO);

    /**
     * 사용중인 라이센스 리스트  전체갯수조회
     * @param productsVO
     * @return
     */
    public int getLicenseListTotalCount(ProductsVO productsVO);

    /**
     * 사용중인 라이센스 리스트
     * @param productsVO
     * @return
     */
    public List<ProductsVO> getProductsLicenseList(ProductsVO productsVO);

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

    /**
     * 추가 (바로구매)
     * @param ProductsVO
     * @return
     */
    public int insertProduct(OrderVO orderVO);

    /**
     * 추가 (장바구니 구매)
     * @param ProductsVO
     * @return
     */
    public int insertProducts(OrderVO orderVO);

    /**
     * 라이센스 코드 부여
     * @param productsVO
     * @return
     */
    public int updateProductsLicense(ProductsVO productsVO);

    /**
     * 삭제
     * @param ProductsVO
     * @return
     */
    public int removeProducts(ProductsVO ProductsVO);

}
