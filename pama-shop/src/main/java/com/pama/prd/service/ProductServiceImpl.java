package com.pama.prd.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.mbr.dao.AccountDAO;
import com.pama.mbr.dao.AccountInfoDAO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountVO;
import com.pama.prd.dao.ProductDAO;
import com.pama.prd.dao.ProductOptDAO;
import com.pama.prd.vo.ProductAttachementVO;
import com.pama.prd.vo.ProductContentsVO;
import com.pama.prd.vo.ProductListVO;
import com.pama.prd.vo.ProductOptVO;
import com.pama.prd.vo.ProductSearchVO;
import com.pama.prd.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService
{
	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(CategoryService.class);

    /**
     * ProductBiz 객체 정의.
     */
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductOptDAO productOptDAO;
    
    @Autowired
    private AccountDAO accountDAO;
    
    @Autowired
    private AccountInfoDAO accountInfoDAO;

    /* 상품 정보 리스트
	 * @see com.pama.prd.service.ProductService#getProductList(com.pama.prd.vo.ProductSearchVO)
	 */
	public ProductListVO getProductList(ProductSearchVO productSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductList' method...");
        }

		ProductListVO productListVO = new ProductListVO();

		List<ProductVO> productList = new ArrayList<ProductVO>();
		//상품 기본 정보의 총 카운트 취득
		int productAllCount = productDAO.getProductInfoListCount(productSearchVO);
		//상품 기본 정보 리스트 취득 후, ProductVO에 격납
		List<ProductVO> productInfoVOList = productDAO.getProductInfoList(productSearchVO);

		//상품 기본 정보에 해당하는 상품 내용 정보, 상품 파일 정보를 취득후 ProductListVO에에 격납
		for(ProductVO productVO : productInfoVOList){
		    //상품 내용 정보 리스트를 취득 후, ProductContentsVO에 격납
		    List<ProductContentsVO> productContentsVOList = productDAO.getProductContentsList(productVO);
	        //상품 파일 정보 리스트를 취득후 , ProductAttachementVO에 격납
	        List<ProductAttachementVO> productAttachementVOList = productDAO.getProductAttachementList(productVO);
	        
	        AccountVO accountVO = new AccountVO();
	        
	        accountVO.setMbrId(productVO.getComp());
	        productVO.setAccountVO(accountDAO.getAccount(accountVO));

	        productVO.setProductContentsVO(productContentsVOList);

	        productVO.setProductAttachementVO(productAttachementVOList);

	        productList.add(productVO);
		}
		//ProductListVO에 격납 후, 리턴
		productListVO.setProductList(productList);
		productListVO.setProductSearchVO(productSearchVO);
		productListVO.getProductSearchVO().setTotalCount(productAllCount);

		return productListVO;
	}

	/* 인기 상품 정보 리스트
	 * @see com.pama.prd.service.ProductService#getBestProductList(com.pama.prd.vo.ProductSearchVO)
	 */
	public ProductListVO getBestProductList(ProductSearchVO productSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBestProductList' method...");
        }

		ProductListVO productListVO = new ProductListVO();

		List<ProductVO> productList = new ArrayList<ProductVO>();
		//상품 기본 정보의 총 카운트 취득
		int productAllCount = productDAO.getBestProductInfoListCount(productSearchVO);
		//상품 기본 정보 리스트 취득 후, ProductVO에 격납
		List<ProductVO> productInfoVOList = productDAO.getBestProductInfoList(productSearchVO);

		//상품 기본 정보에 해당하는 상품 내용 정보, 상품 파일 정보를 취득후 ProductListVO에에 격납
		for(ProductVO productVO : productInfoVOList){
		    //상품 내용 정보 리스트를 취득 후, ProductContentsVO에 격납
		    List<ProductContentsVO> productContentsVOList = productDAO.getProductContentsList(productVO);
	        //상품 파일 정보 리스트를 취득후 , ProductAttachementVO에 격납
	        List<ProductAttachementVO> productAttachementVOList = productDAO.getProductAttachementList(productVO);

	        productVO.setProductContentsVO(productContentsVOList);

	        productVO.setProductAttachementVO(productAttachementVOList);

	        productList.add(productVO);
		}
		//ProductListVO에 격납 후, 리턴
		productListVO.setProductList(productList);
		productListVO.setProductSearchVO(productSearchVO);
		productListVO.getProductSearchVO().setTotalCount(productAllCount);

		return productListVO;
	}


	/* 상품 상세 정보
	 * @see com.pama.prd.service.ProductService#getProduct(com.pama.prd.vo.ProductSearchVO)
	 */
	public ProductVO getProduct(ProductSearchVO productSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProduct' method...");
        }
		//상품 기본 정보 취득 후, ProductVO에 격납
		ProductVO productVO = productDAO.getProductInfo(productSearchVO);
		
		if (productVO == null) return null;
		
		//상품 내용 정보를 취득 후, ProductContentsVO에 격납
		List<ProductContentsVO> productContentsVOList = productDAO.getProductContentsList(productVO);
		//상품 파일 정보를 취득후 , ProductAttachementVO에 격납
        List<ProductAttachementVO> productAttachementVOList = productDAO.getProductAttachementList(productVO);

        ProductOptVO productOptVO = new ProductOptVO();
        productOptVO.setPrdId(productVO.getPrdId());
        productVO.setProductOptVO(productOptDAO.getProductOptList(productOptVO));
        //ProductVO에 격납 후, 리턴
        productVO.setProductContentsVO(productContentsVOList);
        productVO.setProductAttachementVO(productAttachementVOList);
        
        AccountVO accountVO = new AccountVO();
        accountVO.setMbrId(productVO.getComp());
        productVO.setAccountVO(accountDAO.getAccount(accountVO));
        
        AccountMechanicInfoVO accountMechanicInfoVO = new AccountMechanicInfoVO();
        accountMechanicInfoVO.setMbrId(productVO.getComp());
        
        AccountMechanicInfoVO accountMechanicInfo = accountInfoDAO.getAccountMechanicInfo(accountMechanicInfoVO);
        if (accountMechanicInfo != null) {
        	productVO.getAccountVO().setAccountMechanicInfoVO(accountMechanicInfo);
        }

		return productVO;
	}

	/* 상품 엑셀출력리스트
	 * @see com.pama.prd.service.ProductService#getProductExcelList(com.pama.prd.vo.ProductSearchVO)
	 */
	public ProductListVO getProductExcelList(ProductSearchVO productSearchVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductExcelList' method...");
        }

        ProductListVO productListVO = new ProductListVO();

        List<ProductVO> productList = new ArrayList<ProductVO>();
        //상품 기본 정보의 총 카운트 취득
        int productAllCount = productDAO.getProductInfoListCount(productSearchVO);
        //상품 기본 정보 리스트 취득 후, ProductVO에 격납
        List<ProductVO> productInfoVOList = productDAO.getProductInfoList(productSearchVO);
        //상품 기본 정보에 해당하는 상품 내용 정보, 상품 파일 정보를 취득후 ProductListVO에에 격납
        for(ProductVO productVO : productInfoVOList){
            //상품 내용 정보 리스트를 취득 후, ProductContentsVO에 격납
            List<ProductContentsVO> productContentsVOList = productDAO.getProductContentsList(productVO);
            //상품 파일 정보 리스트를 취득후 , ProductAttachementVO에 격납
            List<ProductAttachementVO> productAttachementVOList = productDAO.getProductAttachementList(productVO);

            productVO.setProductContentsVO(productContentsVOList);

            productVO.setProductAttachementVO(productAttachementVOList);

            productList.add(productVO);
        }
        //ProductListVO에 격납 후, 리턴
        productListVO.setProductList(productList);
        productListVO.setProductSearchVO(productSearchVO);
        productListVO.getProductSearchVO().setTotalCount(productAllCount);

        return productListVO;
    }

	public ProductListVO getProductCategoryList(ProductSearchVO productSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductCategoryList' method...");
        }
		//상품 정보 취득 후, ProductListVO에 격납
		ProductListVO productListVO = new ProductListVO();

		productListVO.setProductList(productDAO.getProductCategoryList(productSearchVO));

		return productListVO;
	}

	/* (non-Javadoc)
	 * @see com.pama.prd.service.ProductService#getProductOnList(com.pama.prd.vo.ProductSearchVO)
	 */
	public ProductListVO getProductOnList(ProductSearchVO productSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOnList' method...");
        }
		//상품 정보 취득 후, ProductListVO에 격납
		ProductListVO productListVO = new ProductListVO();

		productListVO.setProductList(productDAO.getProductOnList(productSearchVO));

		return productListVO;
	}

	/* 상품 등록
	 * @see com.pama.prd.service.ProductService#addProduct(com.pama.prd.vo.ProductVO)
	 */
	public int addProduct(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addProduct' method...");
        }
		//상품 기본 정보 등록
		int productInfoID = productDAO.insertProductInfo(productVO);

	    for (int i=0; i<productVO.getOptId().length; ++i) {
	    	if (productVO.getOptId()[i]!=null && !"".equals(productVO.getOptId()[i])) {
	    		ProductOptVO productOptVO = new ProductOptVO();
	    		productOptVO.setPrdId(productVO.getPrdId());
	    		productOptVO.setOptId(productVO.getOptId()[i]);
	    		productOptVO.setOptName(productVO.getOptName()[i]);
	    		productOptVO.setOptPrice(productVO.getOptPrice()[i]);
	    		productOptDAO.insertProductOpt(productOptVO);
	    	}
	    }

		//상품 기본정보 등록 성공시
		if(productVO.getPrdId() != null && !"".equals(productVO.getPrdId())) {

		    List<ProductContentsVO> productContentsList = productVO.getProductContentsVO();

		    List<ProductAttachementVO> productAttachementList = productVO.getProductAttachementVO();

		    int productCountsCount = 0;

		    int productAttachementCount = 0;
		    //상품 내용 정보 취득후, 등록
		    for(ProductContentsVO productContentsVO : productContentsList){
		        productContentsVO.setPrdId(String.valueOf(productVO.getPrdId()));
		        productCountsCount = productDAO.insertProductContents(productContentsVO);
		    }
		    //상품 파일 정보 취득후, 등록
		    for(ProductAttachementVO productAttachementVO : productAttachementList){
		        productAttachementVO.setPrdId(String.valueOf(productVO.getPrdId()));
		        productAttachementCount = productDAO.insertProductAttachement(productAttachementVO);
            }

		    if (LOG.isDebugEnabled()) {
	            LOG.debug("invoked 'productCountsCount' method..." + productCountsCount);
	            LOG.debug("invoked 'productAttachementCount' method..." + productAttachementCount);
	        }

		}

		return productInfoID;
	}

	/* 상품 수정
	 * @see com.pama.prd.service.ProductService#modifyProduct(com.pama.prd.vo.ProductVO)
	 */
	public int modifyProduct(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProduct' method...");
        }
		//상품 기본 정보 수정
		int inforCount = productDAO.updateProductInfo(productVO);

	    for (int i=0; i<productVO.getOptId().length; ++i) {
	    	if (productVO.getOptId()[i]!=null && !"".equals(productVO.getOptId()[i])) {
		    	ProductOptVO productOptVO = new ProductOptVO();
		    	productOptVO.setPrdId(productVO.getPrdId());
		    	productOptVO.setOptId(productVO.getOptId()[i]);
		    	productOptVO.setOptName(productVO.getOptName()[i]);
		    	productOptVO.setOptPrice(productVO.getOptPrice()[i]);
		    	if (productVO.getOldOptId()[i] == null || "".equals(productVO.getOldOptId()[i])) {
		    		productOptDAO.insertProductOpt(productOptVO);
		    	} else {
		    		productOptDAO.updateProductOpt(productOptVO);
		    	}
	    	}
	    }

		//상품 기본정보 수정 성공시
		if(inforCount != 0){

		    List<ProductContentsVO> productContentsList = productVO.getProductContentsVO();

            List<ProductAttachementVO> productAttachementList = productVO.getProductAttachementVO();

            int productCountsCount = 0;

            int productAttachementCount = 0;
            //상품 내용 정보 취득후, 수정
            for(ProductContentsVO productContentsVO : productContentsList){
            	//productContentsVO.setPrdId(productVO.getPrdId());
                productCountsCount = productDAO.updateProductContents(productContentsVO);
            }
            //상품 파일 정보 취득후, 수정
            for(ProductAttachementVO productAttachementVO : productAttachementList){
            	productAttachementVO.setPrdId(productVO.getPrdId());
            	if (productAttachementVO.getPrdAttaId() == null || "".equals(productAttachementVO.getPrdAttaId())) {
            		productAttachementCount = productDAO.insertProductAttachement(productAttachementVO);
            	} else {
            		productAttachementCount = productDAO.updateProductAttachement(productAttachementVO);
            	}
                
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("invoked 'productCountsCount' method..." + productCountsCount);
                LOG.debug("invoked 'productAttachementCount' method..." + productAttachementCount);
            }
		}
		return inforCount;
	}

	/* 상품 상태변경(상품판매종료)
	 * @see com.pama.prd.service.ProductService#modifyProductStatus(com.pama.prd.vo.ProductVO)
	 */
	public int modifyProductStatus(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductStatus' method...");
        }
		return productDAO.updateProductStatus(productVO);
	}

	/* 상품 삭제
	 * @see com.pama.prd.service.ProductService#removeProduct(com.pama.prd.vo.ProductVO)
	 */
	public int removeProduct(ProductVO productVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeProduct' method...");
        }
		//상품 기본 정보 삭제
		int inforCount = productDAO.deleteProductInfo(productVO);
		//상품 기본정보 삭제 성공시
        if(inforCount != 0){

            List<ProductContentsVO> productContentsList = productVO.getProductContentsVO();

            List<ProductAttachementVO> productAttachementList = productVO.getProductAttachementVO();

            int productCountsCount = 0;

            int productAttachementCount = 0;
            //상품 내용 정보 취득후, 삭제
            for(ProductContentsVO productContentsVO : productContentsList){
                productCountsCount = productDAO.deleteProductContents(productContentsVO);
            }
            //상품 파일 정보 취득후, 삭제
            for(ProductAttachementVO productAttachementVO : productAttachementList){
                productAttachementCount = productDAO.deleteProductAttachement(productAttachementVO);
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("invoked 'productCountsCount' method..." + productCountsCount);
                LOG.debug("invoked 'productAttachementCount' method..." + productAttachementCount);
            }
        }
        return inforCount;
	}

	public int modifyProductOptStatus(ProductOptVO productOptVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductOptStatus' method...");
        }
		return productOptDAO.deleteProductOpt(productOptVO);
	}
}
