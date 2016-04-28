package com.pama.prd.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pama.mbr.vo.AccountVO;

/**
 * @author bluesky
 *
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductVO implements Serializable
{

    /**
     * UID
     */
    private static final long serialVersionUID = 2200130115318608238L;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 카테고리 ID
     */
    @XmlElement(name = "cateId")
    private String cateId;

    /**
     * 카테고리 이름
     */
    @XmlElement(name = "cateName")
    private String cateName;

    /**
     * 상품 이름
     */
    @XmlElement(name = "prdName")
    private String prdName;

    /**
     * 단위
     */
    @XmlElement(name = "unit")
    private String unit;

    /**
     * 기간
     */
    @XmlElement(name = "expirationMonth")
    private String expirationMonth;

    /**
     * 가격
     */
    @XmlElement(name = "price")
    private String price;

    /**
     * 할인 가격
     */
    @XmlElement(name = "salePrice")
    private String salePrice;

    /**
     * 회사
     */
    @XmlElement(name = "comp")
    private String comp;

    /**
     * 국가
     */
    @XmlElement(name = "country")
    private String country;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 등록 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 수정 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     *  상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * 통계 건수
     */
    @XmlElement(name = "statisticsCount")
    private String statisticsCount;

    /**
     * 기존옵션아이디
     */
    private String[] oldOptId;

    /**
     * 옵션아이디
     */
    private String[] optId;

    /**
     * 옵션명
     */
    private String[] optName;

    /**
     * 옵션금액
     */
    private String[] optPrice;

    /**
     * 내용 관련 VO
     */
    private List<ProductContentsVO> productContentsVO;

    /**
     * 첨부 파일 관련 VO
     */
    private List<ProductAttachementVO> productAttachementVO;

    /**
     * 라이센스코드 관련 VO
     */
    private List<ProductLicenseVO> productLicenseVO;

    /**
     * 상품 옵션정보
     */
    private List<ProductOptVO> productOptVO;
    
    /**
     * 업체정보
     */
    private AccountVO accountVO;

    /**
     * @return
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * @param prdId
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    /**
     * @return
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * @param cateId
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    /**
     * @return
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prdName
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    /**
     * @return
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
	 * @return the expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * @param expirationMonth the expirationMonth to set
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return
     */
    public String getComp() {
        return comp;
    }

    /**
     * @param comp
     */
    public void setComp(String comp) {
        this.comp = comp;
    }

    /**
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    /**
     * @return
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * @param registerIp
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    /**
     * @return
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * @return
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * @param updateIp
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    /**
     * @return
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * @return
     */
    public String getStatisticsCount() {
        return statisticsCount;
    }

    /**
     * @param statisticsCount
     */
    public void setStatisticsCount(String statisticsCount) {
        this.statisticsCount = statisticsCount;
    }

    public String[] getOldOptId() {
		return oldOptId;
	}

	public void setOldOptId(String[] oldOptId) {
		this.oldOptId = oldOptId;
	}

	public String[] getOptId() {
		return optId;
	}

	public void setOptId(String[] optId) {
		this.optId = optId;
	}

	public String[] getOptName() {
		return optName;
	}

	public void setOptName(String[] optName) {
		this.optName = optName;
	}

	public String[] getOptPrice() {
		return optPrice;
	}

	public void setOptPrice(String[] optPrice) {
		this.optPrice = optPrice;
	}

	/**
     * @return
     */
    public List<ProductContentsVO> getProductContentsVO() {
        return productContentsVO;
    }

    /**
     * @param productContentsVO
     */
    public void setProductContentsVO(List<ProductContentsVO> productContentsVO) {
        this.productContentsVO = productContentsVO;
    }

    /**
     * @return
     */
    public List<ProductAttachementVO> getProductAttachementVO() {
        return productAttachementVO;
    }

    /**
     * @param productAttachementVO
     */
    public void setProductAttachementVO(List<ProductAttachementVO> productAttachementVO) {
        this.productAttachementVO = productAttachementVO;
    }

    /**
	 * @return the productLicenseVO
	 */
	public List<ProductLicenseVO> getProductLicenseVO() {
		return productLicenseVO;
	}

	/**
	 * @param productLicenseVO the productLicenseVO to set
	 */
	public void setProductLicenseVO(List<ProductLicenseVO> productLicenseVO) {
		this.productLicenseVO = productLicenseVO;
	}

	/**
	 * @return
	 */
	public List<ProductOptVO> getProductOptVO() {
		return productOptVO;
	}

	/**
	 * @param productOptVO
	 */
	public void setProductOptVO(List<ProductOptVO> productOptVO) {
		this.productOptVO = productOptVO;
	}

	/**
	 * @return
	 */
	public AccountVO getAccountVO() {
		return accountVO;
	}

	/**
	 * @param accountVO
	 */
	public void setAccountVO(AccountVO accountVO) {
		this.accountVO = accountVO;
	}

	/**
     * @param productVO
     * @return
     */
    public ProductFormVO getProductFormVO(){
        //취득한 ProductVO정보를 ProductFormVO에 격납
        ProductFormVO productFormVO = new ProductFormVO();
        productFormVO.setPrdId(this.prdId);
        productFormVO.setCateId(this.cateId);
        productFormVO.setPrdName(this.prdName);
        productFormVO.setUnit(this.unit);
        productFormVO.setExpirationMonth(this.expirationMonth);
        productFormVO.setPrice(this.price);
        productFormVO.setSalePrice(this.salePrice);
        productFormVO.setComp(this.comp);
        productFormVO.setCountry(this.country);
        productFormVO.setRegisterId(this.registerId);
        productFormVO.setRegisterIp(this.registerIp);
        productFormVO.setUpdateId(this.updateId);
        productFormVO.setUpdateIp(this.updateIp);
        productFormVO.setStatusType(this.statusType);

        //취득한 productContentsVO정보를 ProductFormVO에 격납
        int productContentsCount = 0;
        if(this.productContentsVO != null){
            for(ProductContentsVO productContentsVO : this.productContentsVO){
                switch(productContentsCount){
                    case 0:
                        productFormVO.setPrdConId(productContentsVO.getPrdConId());
                        productFormVO.setContents(productContentsVO.getContents());
                        break;
                }
                productContentsCount++;
            }
        }

        //취득한 ProductAttachementVO정보를 ProductFormVO에 격납
        int productAttachementCount = 0;
        if(this.productAttachementVO != null){
            for(ProductAttachementVO productAttachementVO : this.productAttachementVO){
                switch(productAttachementCount){
                    case 0:
                        productFormVO.setPrdAttaId1(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType1(productAttachementVO.getImageType());
                        productFormVO.setFileType1(productAttachementVO.getFileType());
                        productFormVO.setFileName1(productAttachementVO.getFileName());
                        productFormVO.setDisplayName1(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath1(productAttachementVO.getFilePath());
                        productFormVO.setFileSize1(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount1(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType1(productAttachementVO.getContentType());
                        productFormVO.setImageWidth1(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight1(productAttachementVO.getImageHeight());
                        break;
                    case 1:
                        productFormVO.setPrdAttaId2(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType2(productAttachementVO.getImageType());
                        productFormVO.setFileType2(productAttachementVO.getFileType());
                        productFormVO.setFileName2(productAttachementVO.getFileName());
                        productFormVO.setDisplayName2(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath2(productAttachementVO.getFilePath());
                        productFormVO.setFileSize2(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount2(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType2(productAttachementVO.getContentType());
                        productFormVO.setImageWidth2(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight2(productAttachementVO.getImageHeight());
                        break;
                    case 2:
                        productFormVO.setPrdAttaId3(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType3(productAttachementVO.getImageType());
                        productFormVO.setFileType3(productAttachementVO.getFileType());
                        productFormVO.setFileName3(productAttachementVO.getFileName());
                        productFormVO.setDisplayName3(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath3(productAttachementVO.getFilePath());
                        productFormVO.setFileSize3(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount3(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType3(productAttachementVO.getContentType());
                        productFormVO.setImageWidth3(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight3(productAttachementVO.getImageHeight());
                        break;
                    case 3:
                        productFormVO.setPrdAttaId4(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType4(productAttachementVO.getImageType());
                        productFormVO.setFileType4(productAttachementVO.getFileType());
                        productFormVO.setFileName4(productAttachementVO.getFileName());
                        productFormVO.setDisplayName4(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath4(productAttachementVO.getFilePath());
                        productFormVO.setFileSize4(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount4(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType4(productAttachementVO.getContentType());
                        productFormVO.setImageWidth4(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight4(productAttachementVO.getImageHeight());
                        break;
                    case 4:
                        productFormVO.setPrdAttaId5(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType5(productAttachementVO.getImageType());
                        productFormVO.setFileType5(productAttachementVO.getFileType());
                        productFormVO.setFileName5(productAttachementVO.getFileName());
                        productFormVO.setDisplayName5(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath5(productAttachementVO.getFilePath());
                        productFormVO.setFileSize5(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount5(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType5(productAttachementVO.getContentType());
                        productFormVO.setImageWidth5(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight5(productAttachementVO.getImageHeight());
                        break;
                    case 5:
                        productFormVO.setPrdAttaId6(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType6(productAttachementVO.getImageType());
                        productFormVO.setFileType6(productAttachementVO.getFileType());
                        productFormVO.setFileName6(productAttachementVO.getFileName());
                        productFormVO.setDisplayName6(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath6(productAttachementVO.getFilePath());
                        productFormVO.setFileSize6(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount6(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType6(productAttachementVO.getContentType());
                        productFormVO.setImageWidth6(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight6(productAttachementVO.getImageHeight());
                        break;
                    case 6:
                        productFormVO.setPrdAttaId7(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType7(productAttachementVO.getImageType());
                        productFormVO.setFileType7(productAttachementVO.getFileType());
                        productFormVO.setFileName7(productAttachementVO.getFileName());
                        productFormVO.setDisplayName7(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath7(productAttachementVO.getFilePath());
                        productFormVO.setFileSize7(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount7(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType7(productAttachementVO.getContentType());
                        productFormVO.setImageWidth7(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight7(productAttachementVO.getImageHeight());
                        break;
                    case 7:
                        productFormVO.setPrdAttaId8(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType8(productAttachementVO.getImageType());
                        productFormVO.setFileType8(productAttachementVO.getFileType());
                        productFormVO.setFileName8(productAttachementVO.getFileName());
                        productFormVO.setDisplayName8(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath8(productAttachementVO.getFilePath());
                        productFormVO.setFileSize8(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount8(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType8(productAttachementVO.getContentType());
                        productFormVO.setImageWidth8(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight8(productAttachementVO.getImageHeight());
                        break;
                    case 8:
                        productFormVO.setPrdAttaId9(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType9(productAttachementVO.getImageType());
                        productFormVO.setFileType9(productAttachementVO.getFileType());
                        productFormVO.setFileName9(productAttachementVO.getFileName());
                        productFormVO.setDisplayName9(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath9(productAttachementVO.getFilePath());
                        productFormVO.setFileSize9(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount9(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType9(productAttachementVO.getContentType());
                        productFormVO.setImageWidth9(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight9(productAttachementVO.getImageHeight());
                        break;
                    case 9:
                        productFormVO.setPrdAttaId10(productAttachementVO.getPrdAttaId());
                        productFormVO.setImageType10(productAttachementVO.getImageType());
                        productFormVO.setFileType10(productAttachementVO.getFileType());
                        productFormVO.setFileName10(productAttachementVO.getFileName());
                        productFormVO.setDisplayName10(productAttachementVO.getDisplayName());
                        productFormVO.setFilePath10(productAttachementVO.getFilePath());
                        productFormVO.setFileSize10(productAttachementVO.getFileSize());
                        productFormVO.setDownLoadCount10(productAttachementVO.getDownLoadCount());
                        productFormVO.setContentType10(productAttachementVO.getContentType());
                        productFormVO.setImageWidth10(productAttachementVO.getImageWidth());
                        productFormVO.setImageHeight10(productAttachementVO.getImageHeight());
                        break;

                }
                productAttachementCount++;
            }
        }


        return productFormVO;
    }
}
