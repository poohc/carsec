package com.pama.prdoption.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.prdoption.dao.ProductOptionDAO;
import com.pama.prdoption.vo.ProductOptionListVO;
import com.pama.prdoption.vo.ProductOptionSearchVO;
import com.pama.prdoption.vo.ProductOptionVO;

@Service
public class ProductOptionService {
	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductOptionService.class);
    
    @Autowired
    private ProductOptionDAO productOptionDAO;
    
	public ProductOptionListVO getProductOptionList(ProductOptionSearchVO productOptionSearchVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOptionList' method...");
        }
		
		ProductOptionListVO productOptionListVO = new ProductOptionListVO();
		
		int productOptionCount = productOptionDAO.getProductOptionListCount(productOptionSearchVO);
		
		List<ProductOptionVO> productOptionList = productOptionDAO.getProductOptionList(productOptionSearchVO);

		productOptionListVO.setProductOptionList(productOptionList);
		productOptionListVO.setProductOptionSearchVO(productOptionSearchVO);
		productOptionListVO.getProductOptionSearchVO().setTotalCount(productOptionCount);

		return productOptionListVO;
	}
	
	public List<ProductOptionVO> getProductOptionList(ProductOptionVO productOptionVO){
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOptionList' method...");
        }
		
		ProductOptionSearchVO productOptionSearchVO = new ProductOptionSearchVO();
		
		productOptionSearchVO.setOptId(productOptionVO.getOptId());
		
		List<ProductOptionVO> productOptionList = productOptionDAO.getProductOptionList(productOptionSearchVO);

		return productOptionList;
	}
	
	public ProductOptionVO getProductOption(
			ProductOptionSearchVO productOptionSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductOption' method...");
        }
		//상품 기본 정보 취득 후, ProductVO에 격납
		ProductOptionVO productOptionVO = productOptionDAO.getProductOption(productOptionSearchVO);

		return productOptionVO;
	}
	
	public int addProductOption(ProductOptionVO productOptionVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addProductOption' method...");
        }
		//상품 라이센스 정보 등록
		int productInfoID = productOptionDAO.insertProductOption(productOptionVO);

		return productInfoID;
	}

	public int modifyProductOption(ProductOptionVO productOptionVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductOption' method...");
        }

		return productOptionDAO.updateProductOption(productOptionVO);
	}	
	
	public int modifyProductOptionStatus(ProductOptionVO productOptionVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductOptionStatus' method...");
        }

		return productOptionDAO.updateProductOptionStatus(productOptionVO);
	}	
}
