package com.pama.prd.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.prd.dao.ProductLicenseDAO;
import com.pama.prd.vo.ProductLicenseFormVO;
import com.pama.prd.vo.ProductLicenseListVO;
import com.pama.prd.vo.ProductLicenseSearchVO;
import com.pama.prd.vo.ProductLicenseVO;

@Service
public class ProductLicenseServiceImpl implements ProductLicenseService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(ProductLicenseService.class);

    /**
     * ProductBiz 객체 정의.
     */
    @Autowired
    private ProductLicenseDAO productLicenseDAO;

	@Override
	public ProductLicenseListVO getProductLicenseList(
			ProductLicenseSearchVO productLicenseSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicenseList' method...");
        }

		ProductLicenseListVO producLicensetListVO = new ProductLicenseListVO();

		//상품 라이센스 정보의 총 카운트 취득
		int productAllCount = productLicenseDAO.getProductLicenseListCount(productLicenseSearchVO);
		//상품 기본 정보 리스트 취득 후, ProductVO에 격납
		List<ProductLicenseVO> productLicenseList = productLicenseDAO.getProductLicenseList(productLicenseSearchVO);

		//ProductListVO에 격납 후, 리턴
		producLicensetListVO.setProductLicenseList(productLicenseList);
		producLicensetListVO.setProductLicenseSearchVO(productLicenseSearchVO);
		producLicensetListVO.getProductLicenseSearchVO().setTotalCount(productAllCount);

		return producLicensetListVO;
	}

	@Override
	public ProductLicenseVO getProductLicense(
			ProductLicenseSearchVO productLicenseSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicense' method...");
        }
		//상품 기본 정보 취득 후, ProductVO에 격납
		ProductLicenseVO productLicenseVO = productLicenseDAO.getProductLicense(productLicenseSearchVO);

		return productLicenseVO;
	}

	@Override
	public String getProductLicensePublish(String prdId) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getProductLicensePublish' method...");
        }

		return productLicenseDAO.getProductLicensePublish(prdId);
	}

	@Override
	public int addProductLicense(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addProductLicense' method...");
        }
		//상품 라이센스 정보 등록
		int productInfoID = productLicenseDAO.insertProductLicense(productLicenseVO);

		return productInfoID;
	}

	@Override
	public int modifyProductLicense(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductLicense' method...");
        }

		return productLicenseDAO.updateProductLicense(productLicenseVO);
	}

	@Override
	public int modifyProductLicensePublish(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductLicensePublish' method...");
        }

		return productLicenseDAO.updateProductLicensePublish(productLicenseVO);
	}

	@Override
	public int modifyProductLicenseStatus(ProductLicenseVO productLicenseVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyProductLicenseStatus' method...");
        }

		return productLicenseDAO.updateProductLicenseStatus(productLicenseVO);
	}

	@Override
	public int removeSelectLicense(ProductLicenseFormVO productLicenseFormVO) {

		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeSelectLicense' method...");
        }

		return productLicenseDAO.updateSelectLicenseStatus(productLicenseFormVO);
	}

}
