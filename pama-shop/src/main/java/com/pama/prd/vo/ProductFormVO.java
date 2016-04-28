package com.pama.prd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;

import com.pama.common.Constants;
import com.pama.processor.vo.AttachmentVO;

/**
 * @author kimsejinsky
 *
 */
@XmlRootElement(name = "productForm")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductFormVO implements Serializable{

	/**
	 * UID
	 */
	private static final long serialVersionUID = 7073041214499160406L;

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
     * 상품 내용 정보 ID
     */
    @XmlElement(name = "prdConId")
    private String prdConId;

    /**
     * 내용
     */
    @XmlElement(name = "contents")
    private String contents;

    /**
     * 첨부파일 ID1
     */
    @XmlElement(name = "prdAttaId1")
    private String prdAttaId1;

    /**
     * 파일 타입1
     */
    @XmlElement(name = "imageType1")
    private String imageType1;

    /**
     * 파일 타입1
     */
    @XmlElement(name = "fileType1")
    private int fileType1;

    /**
     * 컨텐츠 타입1
     */
    @XmlElement(name = "contentType1")
    private String contentType1;

    /**
     * 파일 이름1
     */
    @XmlElement(name = "fileName1")
    private String fileName1;

    /**
     * 파일 표시 이름1
     */
    @XmlElement(name = "displayName1")
    private String displayName1;

    /**
     * 파일 경로1
     */
    @XmlElement(name = "filePath1")
    private String filePath1;

    /**
     * 파일 사이즈1
     */
    @XmlElement(name = "fileSize1")
    private long fileSize1;

    /**
     * 파일 넓이1
     */
    @XmlElement(name = "imageWidth1")
    private int imageWidth1;

    /**
     * 파일 높이1
     */
    @XmlElement(name = "imageHeight1")
    private int imageHeight1;

    /**
     * 다운로드 수1
     */
    @XmlElement(name = "downLoadCount1")
    private String downLoadCount1;

    /**
     * 첨부파일 ID2
     */
    @XmlElement(name = "prdAttaId2")
    private String prdAttaId2;

    /**
     * 파일 타입2
     */
    @XmlElement(name = "imageType2")
    private String imageType2;

    /**
     * 파일 타입2
     */
    @XmlElement(name = "fileType2")
    private int fileType2;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType2")
    private String contentType2;

    /**
     * 파일 이름2
     */
    @XmlElement(name = "fileName2")
    private String fileName2;

    /**
     * 파일 표시 이름2
     */
    @XmlElement(name = "displayName2")
    private String displayName2;

    /**
     * 파일 경로2
     */
    @XmlElement(name = "filePath2")
    private String filePath2;

    /**
     * 파일 사이즈2
     */
    @XmlElement(name = "fileSize2")
    private long fileSize2;

    /**
     * 파일 넓이2
     */
    @XmlElement(name = "imageWidth2")
    private int imageWidth2;

    /**
     * 파일 높이2
     */
    @XmlElement(name = "imageHeight2")
    private int imageHeight2;

    /**
     * 다운로드 수2
     */
    @XmlElement(name = "downLoadCount2")
    private String downLoadCount2;

    /**
     * 첨부파일 ID3
     */
    @XmlElement(name = "prdAttaId3")
    private String prdAttaId3;

    /**
     * 파일 타입3
     */
    @XmlElement(name = "imageType3")
    private String imageType3;

    /**
     * 파일 타입3
     */
    @XmlElement(name = "fileType3")
    private int fileType3;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType3")
    private String contentType3;

    /**
     * 파일 이름3
     */
    @XmlElement(name = "fileName3")
    private String fileName3;

    /**
     * 파일 표시 이름3
     */
    @XmlElement(name = "displayName3")
    private String displayName3;

    /**
     * 파일 경로3
     */
    @XmlElement(name = "filePath3")
    private String filePath3;

    /**
     * 파일 사이즈3
     */
    @XmlElement(name = "fileSize3")
    private long fileSize3;

    /**
     * 파일 넓이3
     */
    @XmlElement(name = "imageWidth3")
    private int imageWidth3;

    /**
     * 파일 높이3
     */
    @XmlElement(name = "imageHeight3")
    private int imageHeight3;

    /**
     * 다운로드 수3
     */
    @XmlElement(name = "downLoadCount3")
    private String downLoadCount3;

    /**
     * 첨부파일 ID4
     */
    @XmlElement(name = "prdAttaId4")
    private String prdAttaId4;

    /**
     * 파일 타입4
     */
    @XmlElement(name = "imageType4")
    private String imageType4;

    /**
     * 파일 타입4
     */
    @XmlElement(name = "fileType4")
    private int fileType4;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType4")
    private String contentType4;

    /**
     * 파일 이름4
     */
    @XmlElement(name = "fileName4")
    private String fileName4;

    /**
     * 파일 표시 이름4
     */
    @XmlElement(name = "displayName4")
    private String displayName4;

    /**
     * 파일 경로4
     */
    @XmlElement(name = "filePath4")
    private String filePath4;

    /**
     * 파일 사이즈4
     */
    @XmlElement(name = "fileSize4")
    private long fileSize4;

    /**
     * 파일 넓이4
     */
    @XmlElement(name = "imageWidth4")
    private int imageWidth4;

    /**
     * 파일 높이4
     */
    @XmlElement(name = "imageHeight4")
    private int imageHeight4;

    /**
     * 다운로드 수4
     */
    @XmlElement(name = "downLoadCount4")
    private String downLoadCount4;

    /**
     * 첨부파일 ID5
     */
    @XmlElement(name = "prdAttaId5")
    private String prdAttaId5;

    /**
     * 파일 타입5
     */
    @XmlElement(name = "imageType5")
    private String imageType5;

    /**
     * 파일 타입5
     */
    @XmlElement(name = "fileType5")
    private int fileType5;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType5")
    private String contentType5;

    /**
     * 파일 이름5
     */
    @XmlElement(name = "fileName5")
    private String fileName5;

    /**
     * 파일 표시 이름5
     */
    @XmlElement(name = "displayName5")
    private String displayName5;

    /**
     * 파일 경로5
     */
    @XmlElement(name = "filePath5")
    private String filePath5;

    /**
     * 파일 사이즈5
     */
    @XmlElement(name = "fileSize5")
    private long fileSize5;

    /**
     * 파일 넓이5
     */
    @XmlElement(name = "imageWidth5")
    private int imageWidth5;

    /**
     * 파일 높이5
     */
    @XmlElement(name = "imageHeight5")
    private int imageHeight5;

    /**
     * 다운로드 수5
     */
    @XmlElement(name = "downLoadCount5")
    private String downLoadCount5;

    /**
     * 첨부파일 ID6
     */
    @XmlElement(name = "prdAttaId6")
    private String prdAttaId6;

    /**
     * 파일 타입6
     */
    @XmlElement(name = "imageType6")
    private String imageType6;

    /**
     * 파일 타입5
     */
    @XmlElement(name = "fileType6")
    private int fileType6;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType6")
    private String contentType6;

    /**
     * 파일 이름6
     */
    @XmlElement(name = "fileName6")
    private String fileName6;

    /**
     * 파일 표시 이름6
     */
    @XmlElement(name = "displayName6")
    private String displayName6;

    /**
     * 파일 경로6
     */
    @XmlElement(name = "filePath6")
    private String filePath6;

    /**
     * 파일 사이즈6
     */
    @XmlElement(name = "fileSize6")
    private long fileSize6;

    /**
     * 파일 넓이6
     */
    @XmlElement(name = "imageWidth6")
    private int imageWidth6;

    /**
     * 파일 높이6
     */
    @XmlElement(name = "imageHeight6")
    private int imageHeight6;

    /**
     * 다운로드 수6
     */
    @XmlElement(name = "downLoadCount6")
    private String downLoadCount6;

    /**
     * 첨부파일 ID7
     */
    @XmlElement(name = "prdAttaId7")
    private String prdAttaId7;

    /**
     * 파일 타입7
     */
    @XmlElement(name = "imageType7")
    private String imageType7;

    /**
     * 파일 타입7
     */
    @XmlElement(name = "fileType7")
    private int fileType7;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType7")
    private String contentType7;

    /**
     * 파일 이름7
     */
    @XmlElement(name = "fileName7")
    private String fileName7;

    /**
     * 파일 표시 이름7
     */
    @XmlElement(name = "displayName7")
    private String displayName7;

    /**
     * 파일 경로7
     */
    @XmlElement(name = "filePath7")
    private String filePath7;

    /**
     * 파일 사이즈7
     */
    @XmlElement(name = "fileSize7")
    private long fileSize7;

    /**
     * 파일 넓이7
     */
    @XmlElement(name = "imageWidth7")
    private int imageWidth7;

    /**
     * 파일 높이7
     */
    @XmlElement(name = "imageHeight7")
    private int imageHeight7;

    /**
     * 다운로드 수7
     */
    @XmlElement(name = "downLoadCount7")
    private String downLoadCount7;

    /**
     * 첨부파일 ID8
     */
    @XmlElement(name = "prdAttaId8")
    private String prdAttaId8;

    /**
     * 파일 타입8
     */
    @XmlElement(name = "imageType8")
    private String imageType8;

    /**
     * 파일 타입8
     */
    @XmlElement(name = "fileType8")
    private int fileType8;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType8")
    private String contentType8;

    /**
     * 파일 이름8
     */
    @XmlElement(name = "fileName8")
    private String fileName8;

    /**
     * 파일 표시 이름8
     */
    @XmlElement(name = "displayName8")
    private String displayName8;

    /**
     * 파일 경로8
     */
    @XmlElement(name = "filePath8")
    private String filePath8;

    /**
     * 파일 사이즈8
     */
    @XmlElement(name = "fileSize8")
    private long fileSize8;

    /**
     * 파일 넓이8
     */
    @XmlElement(name = "imageWidth8")
    private int imageWidth8;

    /**
     * 파일 높이8
     */
    @XmlElement(name = "imageHeight8")
    private int imageHeight8;

    /**
     * 다운로드 수8
     */
    @XmlElement(name = "downLoadCount8")
    private String downLoadCount8;

    /**
     * 첨부파일 ID9
     */
    @XmlElement(name = "prdAttaId9")
    private String prdAttaId9;

    /**
     * 파일 타입9
     */
    @XmlElement(name = "imageType9")
    private String imageType9;

    /**
     * 파일 타입9
     */
    @XmlElement(name = "fileType9")
    private int fileType9;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType9")
    private String contentType9;

    /**
     * 파일 이름9
     */
    @XmlElement(name = "fileName9")
    private String fileName9;

    /**
     * 파일 표시 이름9
     */
    @XmlElement(name = "displayName9")
    private String displayName9;

    /**
     * 파일 경로9
     */
    @XmlElement(name = "filePath9")
    private String filePath9;

    /**
     * 파일 사이즈9
     */
    @XmlElement(name = "fileSize9")
    private long fileSize9;

    /**
     * 파일 넓이9
     */
    @XmlElement(name = "imageWidth9")
    private int imageWidth9;

    /**
     * 파일 높이9
     */
    @XmlElement(name = "imageHeight9")
    private int imageHeight9;

    /**
     * 다운로드 수9
     */
    @XmlElement(name = "downLoadCount9")
    private String downLoadCount9;

    /**
     * 첨부파일 ID10
     */
    @XmlElement(name = "prdAttaId10")
    private String prdAttaId10;

    /**
     * 파일 타입10
     */
    @XmlElement(name = "imageType10")
    private String imageType10;

    /**
     * 파일 타입10
     */
    @XmlElement(name = "fileType10")
    private int fileType10;

    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType10")
    private String contentType10;

    /**
     * 파일 이름10
     */
    @XmlElement(name = "fileName10")
    private String fileName10;

    /**
     * 파일 표시 이름10
     */
    @XmlElement(name = "displayName10")
    private String displayName10;

    /**
     * 파일 경로10
     */
    @XmlElement(name = "filePath10")
    private String filePath10;

    /**
     * 파일 사이즈10
     */
    @XmlElement(name = "fileSize10")
    private long fileSize10;

    /**
     * 파일 넓이10
     */
    @XmlElement(name = "imageWidth10")
    private int imageWidth10;

    /**
     * 파일 높이10
     */
    @XmlElement(name = "imageHeight10")
    private int imageHeight10;

    /**
     * 다운로드 수10
     */
    @XmlElement(name = "downLoadCount10")
    private String downLoadCount10;


    /**
     * 파일업로드1
     */
    private MultipartFile uplodeFile1;

    /**
     * 파일업로드2
     */
    private MultipartFile uplodeFile2;

    /**
     * 파일업로드3
     */
    private MultipartFile uplodeFile3;

    /**
     * 파일업로드4
     */
    private MultipartFile uplodeFile4;

    /**
     * 파일업로드5
     */
    private MultipartFile uplodeFile5;

    /**
     * 파일업로드6
     */
    private MultipartFile uplodeFile6;

    /**
     * 파일업로드7
     */
    private MultipartFile uplodeFile7;

    /**
     * 파일업로드8
     */
    private MultipartFile uplodeFile8;

    /**
     * 파일업로드9
     */
    private MultipartFile uplodeFile9;

    /**
     * 파일업로드10
     */
    private MultipartFile uplodeFile10;

    /**
     * 카테고리 분류
     * 6자리 기준
     * 전방 두자리 대분류
     * 중방 두자리 중분류
     * 후방 두자리 소분류
     */
    private String sortTree;

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
    public String getPrdConId() {
		return prdConId;
	}

	/**
	 * @param prdConId
	 */
	public void setPrdConId(String prdConId) {
		this.prdConId = prdConId;
	}

	/**
     * @return
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

	/**
	 * @return
	 */
	public String getPrdAttaId1() {
		return prdAttaId1;
	}

	/**
	 * @param prdAttaId1
	 */
	public void setPrdAttaId1(String prdAttaId1) {
		this.prdAttaId1 = prdAttaId1;
	}

	/**
	 * @return
	 */
	public String getImageType1() {
		return imageType1;
	}

	/**
	 * @param imageType1
	 */
	public void setImageType1(String imageType1) {
		this.imageType1 = imageType1;
	}

	/**
	 * @return
	 */
	public int getFileType1() {
		return fileType1;
	}

	/**
	 * @param fileType1
	 */
	public void setFileType1(int fileType1) {
		this.fileType1 = fileType1;
	}

	/**
	 * @return
	 */
	public String getFileName1() {
		return fileName1;
	}

	/**
	 * @param fileName1
	 */
	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	/**
	 * @return
	 */
	public String getDisplayName1() {
		return displayName1;
	}

	/**
	 * @param displayName1
	 */
	public void setDisplayName1(String displayName1) {
		this.displayName1 = displayName1;
	}

	/**
	 * @return
	 */
	public String getFilePath1() {
		return filePath1;
	}

	/**
	 * @param filePath1
	 */
	public void setFilePath1(String filePath1) {
		this.filePath1 = filePath1;
	}

	/**
	 * @return
	 */
	public long getFileSize1() {
		return fileSize1;
	}

	/**
	 * @param fileSize1
	 */
	public void setFileSize1(long fileSize1) {
		this.fileSize1 = fileSize1;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount1() {
		return downLoadCount1;
	}

	/**
	 * @param downLoadCount1
	 */
	public void setDownLoadCount1(String downLoadCount1) {
		this.downLoadCount1 = downLoadCount1;
	}

	/**
	 * @return
	 */
	public String getContentType1() {
		return contentType1;
	}

	/**
	 * @param contentType1
	 */
	public void setContentType1(String contentType1) {
		this.contentType1 = contentType1;
	}

	/**
	 * @return
	 */
	public int getImageWidth1() {
		return imageWidth1;
	}

	/**
	 * @param imageWidth1
	 */
	public void setImageWidth1(int imageWidth1) {
		this.imageWidth1 = imageWidth1;
	}

	/**
	 * @return
	 */
	public int getImageHeight1() {
		return imageHeight1;
	}

	/**
	 * @param imageHeight1
	 */
	public void setImageHeight1(int imageHeight1) {
		this.imageHeight1 = imageHeight1;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId2() {
		return prdAttaId2;
	}

	/**
	 * @param prdAttaId2
	 */
	public void setPrdAttaId2(String prdAttaId2) {
		this.prdAttaId2 = prdAttaId2;
	}

	/**
	 * @return
	 */
	public String getImageType2() {
		return imageType2;
	}

	/**
	 * @param imageType2
	 */
	public void setImageType2(String imageType2) {
		this.imageType2 = imageType2;
	}

	/**
	 * @return
	 */
	public int getFileType2() {
		return fileType2;
	}

	/**
	 * @param fileType2
	 */
	public void setFileType2(int fileType2) {
		this.fileType2 = fileType2;
	}

	/**
	 * @return
	 */
	public String getContentType2() {
		return contentType2;
	}

	/**
	 * @param contentType2
	 */
	public void setContentType2(String contentType2) {
		this.contentType2 = contentType2;
	}

	/**
	 * @return
	 */
	public String getFileName2() {
		return fileName2;
	}

	/**
	 * @param fileName2
	 */
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	/**
	 * @return
	 */
	public String getDisplayName2() {
		return displayName2;
	}

	/**
	 * @param displayName2
	 */
	public void setDisplayName2(String displayName2) {
		this.displayName2 = displayName2;
	}

	/**
	 * @return
	 */
	public String getFilePath2() {
		return filePath2;
	}

	/**
	 * @param filePath2
	 */
	public void setFilePath2(String filePath2) {
		this.filePath2 = filePath2;
	}

	/**
	 * @return
	 */
	public long getFileSize2() {
		return fileSize2;
	}

	/**
	 * @param fileSize2
	 */
	public void setFileSize2(long fileSize2) {
		this.fileSize2 = fileSize2;
	}

	/**
	 * @return
	 */
	public int getImageWidth2() {
		return imageWidth2;
	}

	/**
	 * @param imageWidth2
	 */
	public void setImageWidth2(int imageWidth2) {
		this.imageWidth2 = imageWidth2;
	}

	/**
	 * @return
	 */
	public int getImageHeight2() {
		return imageHeight2;
	}

	/**
	 * @param imageHeight2
	 */
	public void setImageHeight2(int imageHeight2) {
		this.imageHeight2 = imageHeight2;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount2() {
		return downLoadCount2;
	}

	/**
	 * @param downLoadCount2
	 */
	public void setDownLoadCount2(String downLoadCount2) {
		this.downLoadCount2 = downLoadCount2;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId3() {
		return prdAttaId3;
	}

	/**
	 * @param prdAttaId3
	 */
	public void setPrdAttaId3(String prdAttaId3) {
		this.prdAttaId3 = prdAttaId3;
	}

	/**
	 * @return
	 */
	public String getImageType3() {
		return imageType3;
	}

	/**
	 * @param imageType3
	 */
	public void setImageType3(String imageType3) {
		this.imageType3 = imageType3;
	}

	/**
	 * @return
	 */
	public int getFileType3() {
		return fileType3;
	}

	/**
	 * @param fileType3
	 */
	public void setFileType3(int fileType3) {
		this.fileType3 = fileType3;
	}

	/**
	 * @return
	 */
	public String getContentType3() {
		return contentType3;
	}

	/**
	 * @param contentType3
	 */
	public void setContentType3(String contentType3) {
		this.contentType3 = contentType3;
	}

	/**
	 * @return
	 */
	public String getFileName3() {
		return fileName3;
	}

	/**
	 * @param fileName3
	 */
	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}

	/**
	 * @return
	 */
	public String getDisplayName3() {
		return displayName3;
	}

	/**
	 * @param displayName3
	 */
	public void setDisplayName3(String displayName3) {
		this.displayName3 = displayName3;
	}

	/**
	 * @return
	 */
	public String getFilePath3() {
		return filePath3;
	}

	/**
	 * @param filePath3
	 */
	public void setFilePath3(String filePath3) {
		this.filePath3 = filePath3;
	}

	/**
	 * @return
	 */
	public long getFileSize3() {
		return fileSize3;
	}

	/**
	 * @param fileSize3
	 */
	public void setFileSize3(long fileSize3) {
		this.fileSize3 = fileSize3;
	}

	/**
	 * @return
	 */
	public int getImageWidth3() {
		return imageWidth3;
	}

	/**
	 * @param imageWidth3
	 */
	public void setImageWidth3(int imageWidth3) {
		this.imageWidth3 = imageWidth3;
	}

	/**
	 * @return
	 */
	public int getImageHeight3() {
		return imageHeight3;
	}

	/**
	 * @param imageHeight3
	 */
	public void setImageHeight3(int imageHeight3) {
		this.imageHeight3 = imageHeight3;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount3() {
		return downLoadCount3;
	}

	/**
	 * @param downLoadCount3
	 */
	public void setDownLoadCount3(String downLoadCount3) {
		this.downLoadCount3 = downLoadCount3;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId4() {
		return prdAttaId4;
	}

	/**
	 * @param prdAttaId4
	 */
	public void setPrdAttaId4(String prdAttaId4) {
		this.prdAttaId4 = prdAttaId4;
	}

	/**
	 * @return
	 */
	public String getImageType4() {
		return imageType4;
	}

	/**
	 * @param imageType4
	 */
	public void setImageType4(String imageType4) {
		this.imageType4 = imageType4;
	}

	/**
	 * @return
	 */
	public int getFileType4() {
		return fileType4;
	}

	/**
	 * @param fileType4
	 */
	public void setFileType4(int fileType4) {
		this.fileType4 = fileType4;
	}

	/**
	 * @return
	 */
	public String getContentType4() {
		return contentType4;
	}

	/**
	 * @param contentType4
	 */
	public void setContentType4(String contentType4) {
		this.contentType4 = contentType4;
	}

	/**
	 * @return
	 */
	public String getFileName4() {
		return fileName4;
	}

	/**
	 * @param fileName4
	 */
	public void setFileName4(String fileName4) {
		this.fileName4 = fileName4;
	}

	/**
	 * @return
	 */
	public String getDisplayName4() {
		return displayName4;
	}

	/**
	 * @param displayName4
	 */
	public void setDisplayName4(String displayName4) {
		this.displayName4 = displayName4;
	}

	/**
	 * @return
	 */
	public String getFilePath4() {
		return filePath4;
	}

	/**
	 * @param filePath4
	 */
	public void setFilePath4(String filePath4) {
		this.filePath4 = filePath4;
	}

	/**
	 * @return
	 */
	public long getFileSize4() {
		return fileSize4;
	}

	/**
	 * @param fileSize4
	 */
	public void setFileSize4(long fileSize4) {
		this.fileSize4 = fileSize4;
	}

	/**
	 * @return
	 */
	public int getImageWidth4() {
		return imageWidth4;
	}

	/**
	 * @param imageWidth4
	 */
	public void setImageWidth4(int imageWidth4) {
		this.imageWidth4 = imageWidth4;
	}

	/**
	 * @return
	 */
	public int getImageHeight4() {
		return imageHeight4;
	}

	/**
	 * @param imageHeight4
	 */
	public void setImageHeight4(int imageHeight4) {
		this.imageHeight4 = imageHeight4;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount4() {
		return downLoadCount4;
	}

	/**
	 * @param downLoadCount4
	 */
	public void setDownLoadCount4(String downLoadCount4) {
		this.downLoadCount4 = downLoadCount4;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId5() {
		return prdAttaId5;
	}

	/**
	 * @param prdAttaId5
	 */
	public void setPrdAttaId5(String prdAttaId5) {
		this.prdAttaId5 = prdAttaId5;
	}

	/**
	 * @return
	 */
	public String getImageType5() {
		return imageType5;
	}

	/**
	 * @param imageType5
	 */
	public void setImageType5(String imageType5) {
		this.imageType5 = imageType5;
	}

	/**
	 * @return
	 */
	public int getFileType5() {
		return fileType5;
	}

	/**
	 * @param fileType5
	 */
	public void setFileType5(int fileType5) {
		this.fileType5 = fileType5;
	}

	/**
	 * @return
	 */
	public String getContentType5() {
		return contentType5;
	}

	/**
	 * @param contentType5
	 */
	public void setContentType5(String contentType5) {
		this.contentType5 = contentType5;
	}

	/**
	 * @return
	 */
	public String getFileName5() {
		return fileName5;
	}

	/**
	 * @param fileName5
	 */
	public void setFileName5(String fileName5) {
		this.fileName5 = fileName5;
	}

	/**
	 * @return
	 */
	public String getDisplayName5() {
		return displayName5;
	}

	/**
	 * @param displayName5
	 */
	public void setDisplayName5(String displayName5) {
		this.displayName5 = displayName5;
	}

	/**
	 * @return
	 */
	public String getFilePath5() {
		return filePath5;
	}

	/**
	 * @param filePath5
	 */
	public void setFilePath5(String filePath5) {
		this.filePath5 = filePath5;
	}

	/**
	 * @return
	 */
	public long getFileSize5() {
		return fileSize5;
	}

	/**
	 * @param fileSize5
	 */
	public void setFileSize5(long fileSize5) {
		this.fileSize5 = fileSize5;
	}

	/**
	 * @return
	 */
	public int getImageWidth5() {
		return imageWidth5;
	}

	/**
	 * @param imageWidth5
	 */
	public void setImageWidth5(int imageWidth5) {
		this.imageWidth5 = imageWidth5;
	}

	/**
	 * @return
	 */
	public int getImageHeight5() {
		return imageHeight5;
	}

	/**
	 * @param imageHeight5
	 */
	public void setImageHeight5(int imageHeight5) {
		this.imageHeight5 = imageHeight5;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount5() {
		return downLoadCount5;
	}

	/**
	 * @param downLoadCount5
	 */
	public void setDownLoadCount5(String downLoadCount5) {
		this.downLoadCount5 = downLoadCount5;
	}

    /**
     * @return
     */
    public String getPrdAttaId6() {
		return prdAttaId6;
	}

	/**
	 * @param prdAttaId6
	 */
	public void setPrdAttaId6(String prdAttaId6) {
		this.prdAttaId6 = prdAttaId6;
	}

	/**
	 * @return
	 */
	public String getImageType6() {
		return imageType6;
	}

	/**
	 * @param imageType6
	 */
	public void setImageType6(String imageType6) {
		this.imageType6 = imageType6;
	}

	/**
	 * @return
	 */
	public int getFileType6() {
		return fileType6;
	}

	/**
	 * @param fileType6
	 */
	public void setFileType6(int fileType6) {
		this.fileType6 = fileType6;
	}

	/**
	 * @return
	 */
	public String getContentType6() {
		return contentType6;
	}

	/**
	 * @param contentType6
	 */
	public void setContentType6(String contentType6) {
		this.contentType6 = contentType6;
	}

	/**
	 * @return
	 */
	public String getFileName6() {
		return fileName6;
	}

	/**
	 * @param fileName6
	 */
	public void setFileName6(String fileName6) {
		this.fileName6 = fileName6;
	}

	/**
	 * @return
	 */
	public String getDisplayName6() {
		return displayName6;
	}

	/**
	 * @param displayName6
	 */
	public void setDisplayName6(String displayName6) {
		this.displayName6 = displayName6;
	}

	/**
	 * @return
	 */
	public String getFilePath6() {
		return filePath6;
	}

	/**
	 * @param filePath6
	 */
	public void setFilePath6(String filePath6) {
		this.filePath6 = filePath6;
	}

	/**
	 * @return
	 */
	public long getFileSize6() {
		return fileSize6;
	}

	/**
	 * @param fileSize6
	 */
	public void setFileSize6(long fileSize6) {
		this.fileSize6 = fileSize6;
	}

	/**
	 * @return
	 */
	public int getImageWidth6() {
		return imageWidth6;
	}

	/**
	 * @param imageWidth6
	 */
	public void setImageWidth6(int imageWidth6) {
		this.imageWidth6 = imageWidth6;
	}

	/**
	 * @return
	 */
	public int getImageHeight6() {
		return imageHeight6;
	}

	/**
	 * @param imageHeight6
	 */
	public void setImageHeight6(int imageHeight6) {
		this.imageHeight6 = imageHeight6;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount6() {
		return downLoadCount6;
	}

	/**
	 * @param downLoadCount6
	 */
	public void setDownLoadCount6(String downLoadCount6) {
		this.downLoadCount6 = downLoadCount6;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId7() {
		return prdAttaId7;
	}

	/**
	 * @param prdAttaId7
	 */
	public void setPrdAttaId7(String prdAttaId7) {
		this.prdAttaId7 = prdAttaId7;
	}

	/**
	 * @return
	 */
	public String getImageType7() {
		return imageType7;
	}

	/**
	 * @param imageType7
	 */
	public void setImageType7(String imageType7) {
		this.imageType7 = imageType7;
	}

	/**
	 * @return
	 */
	public int getFileType7() {
		return fileType7;
	}

	/**
	 * @param fileType7
	 */
	public void setFileType7(int fileType7) {
		this.fileType7 = fileType7;
	}

	/**
	 * @return
	 */
	public String getContentType7() {
		return contentType7;
	}

	/**
	 * @param contentType7
	 */
	public void setContentType7(String contentType7) {
		this.contentType7 = contentType7;
	}

	/**
	 * @return
	 */
	public String getFileName7() {
		return fileName7;
	}

	/**
	 * @param fileName7
	 */
	public void setFileName7(String fileName7) {
		this.fileName7 = fileName7;
	}

	/**
	 * @return
	 */
	public String getDisplayName7() {
		return displayName7;
	}

	/**
	 * @param displayName7
	 */
	public void setDisplayName7(String displayName7) {
		this.displayName7 = displayName7;
	}

	/**
	 * @return
	 */
	public String getFilePath7() {
		return filePath7;
	}

	/**
	 * @param filePath7
	 */
	public void setFilePath7(String filePath7) {
		this.filePath7 = filePath7;
	}

	/**
	 * @return
	 */
	public long getFileSize7() {
		return fileSize7;
	}

	/**
	 * @param fileSize7
	 */
	public void setFileSize7(long fileSize7) {
		this.fileSize7 = fileSize7;
	}

	/**
	 * @return
	 */
	public int getImageWidth7() {
		return imageWidth7;
	}

	/**
	 * @param imageWidth7
	 */
	public void setImageWidth7(int imageWidth7) {
		this.imageWidth7 = imageWidth7;
	}

	/**
	 * @return
	 */
	public int getImageHeight7() {
		return imageHeight7;
	}

	/**
	 * @param imageHeight7
	 */
	public void setImageHeight7(int imageHeight7) {
		this.imageHeight7 = imageHeight7;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount7() {
		return downLoadCount7;
	}

	/**
	 * @param downLoadCount7
	 */
	public void setDownLoadCount7(String downLoadCount7) {
		this.downLoadCount7 = downLoadCount7;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId8() {
		return prdAttaId8;
	}

	/**
	 * @param prdAttaId8
	 */
	public void setPrdAttaId8(String prdAttaId8) {
		this.prdAttaId8 = prdAttaId8;
	}

	/**
	 * @return
	 */
	public String getImageType8() {
		return imageType8;
	}

	/**
	 * @param imageType8
	 */
	public void setImageType8(String imageType8) {
		this.imageType8 = imageType8;
	}

	/**
	 * @return
	 */
	public int getFileType8() {
		return fileType8;
	}

	/**
	 * @param fileType8
	 */
	public void setFileType8(int fileType8) {
		this.fileType8 = fileType8;
	}

	/**
	 * @return
	 */
	public String getContentType8() {
		return contentType8;
	}

	/**
	 * @param contentType8
	 */
	public void setContentType8(String contentType8) {
		this.contentType8 = contentType8;
	}

	/**
	 * @return
	 */
	public String getFileName8() {
		return fileName8;
	}

	/**
	 * @param fileName8
	 */
	public void setFileName8(String fileName8) {
		this.fileName8 = fileName8;
	}

	/**
	 * @return
	 */
	public String getDisplayName8() {
		return displayName8;
	}

	/**
	 * @param displayName8
	 */
	public void setDisplayName8(String displayName8) {
		this.displayName8 = displayName8;
	}

	/**
	 * @return
	 */
	public String getFilePath8() {
		return filePath8;
	}

	/**
	 * @param filePath8
	 */
	public void setFilePath8(String filePath8) {
		this.filePath8 = filePath8;
	}

	/**
	 * @return
	 */
	public long getFileSize8() {
		return fileSize8;
	}

	/**
	 * @param fileSize8
	 */
	public void setFileSize8(long fileSize8) {
		this.fileSize8 = fileSize8;
	}

	/**
	 * @return
	 */
	public int getImageWidth8() {
		return imageWidth8;
	}

	/**
	 * @param imageWidth8
	 */
	public void setImageWidth8(int imageWidth8) {
		this.imageWidth8 = imageWidth8;
	}

	/**
	 * @return
	 */
	public int getImageHeight8() {
		return imageHeight8;
	}

	/**
	 * @param imageHeight8
	 */
	public void setImageHeight8(int imageHeight8) {
		this.imageHeight8 = imageHeight8;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount8() {
		return downLoadCount8;
	}

	/**
	 * @param downLoadCount8
	 */
	public void setDownLoadCount8(String downLoadCount8) {
		this.downLoadCount8 = downLoadCount8;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId9() {
		return prdAttaId9;
	}

	/**
	 * @param prdAttaId9
	 */
	public void setPrdAttaId9(String prdAttaId9) {
		this.prdAttaId9 = prdAttaId9;
	}

	/**
	 * @return
	 */
	public String getImageType9() {
		return imageType9;
	}

	/**
	 * @param imageType9
	 */
	public void setImageType9(String imageType9) {
		this.imageType9 = imageType9;
	}

	/**
	 * @return
	 */
	public int getFileType9() {
		return fileType9;
	}

	/**
	 * @param fileType9
	 */
	public void setFileType9(int fileType9) {
		this.fileType9 = fileType9;
	}

	/**
	 * @return
	 */
	public String getContentType9() {
		return contentType9;
	}

	/**
	 * @param contentType9
	 */
	public void setContentType9(String contentType9) {
		this.contentType9 = contentType9;
	}

	/**
	 * @return
	 */
	public String getFileName9() {
		return fileName9;
	}

	/**
	 * @param fileName9
	 */
	public void setFileName9(String fileName9) {
		this.fileName9 = fileName9;
	}

	/**
	 * @return
	 */
	public String getDisplayName9() {
		return displayName9;
	}

	/**
	 * @param displayName9
	 */
	public void setDisplayName9(String displayName9) {
		this.displayName9 = displayName9;
	}

	/**
	 * @return
	 */
	public String getFilePath9() {
		return filePath9;
	}

	/**
	 * @param filePath9
	 */
	public void setFilePath9(String filePath9) {
		this.filePath9 = filePath9;
	}

	/**
	 * @return
	 */
	public long getFileSize9() {
		return fileSize9;
	}

	/**
	 * @param fileSize9
	 */
	public void setFileSize9(long fileSize9) {
		this.fileSize9 = fileSize9;
	}

	/**
	 * @return
	 */
	public int getImageWidth9() {
		return imageWidth9;
	}

	/**
	 * @param imageWidth9
	 */
	public void setImageWidth9(int imageWidth9) {
		this.imageWidth9 = imageWidth9;
	}

	/**
	 * @return
	 */
	public int getImageHeight9() {
		return imageHeight9;
	}

	/**
	 * @param imageHeight9
	 */
	public void setImageHeight9(int imageHeight9) {
		this.imageHeight9 = imageHeight9;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount9() {
		return downLoadCount9;
	}

	/**
	 * @param downLoadCount9
	 */
	public void setDownLoadCount9(String downLoadCount9) {
		this.downLoadCount9 = downLoadCount9;
	}

	/**
	 * @return
	 */
	public String getPrdAttaId10() {
		return prdAttaId10;
	}

	/**
	 * @param prdAttaId10
	 */
	public void setPrdAttaId10(String prdAttaId10) {
		this.prdAttaId10 = prdAttaId10;
	}

	/**
	 * @return
	 */
	public String getImageType10() {
		return imageType10;
	}

	/**
	 * @param imageType10
	 */
	public void setImageType10(String imageType10) {
		this.imageType10 = imageType10;
	}

	/**
	 * @return
	 */
	public int getFileType10() {
		return fileType10;
	}

	/**
	 * @param fileType10
	 */
	public void setFileType10(int fileType10) {
		this.fileType10 = fileType10;
	}

	/**
	 * @return
	 */
	public String getContentType10() {
		return contentType10;
	}

	/**
	 * @param contentType10
	 */
	public void setContentType10(String contentType10) {
		this.contentType10 = contentType10;
	}

	/**
	 * @return
	 */
	public String getFileName10() {
		return fileName10;
	}

	/**
	 * @param fileName10
	 */
	public void setFileName10(String fileName10) {
		this.fileName10 = fileName10;
	}

	/**
	 * @return
	 */
	public String getDisplayName10() {
		return displayName10;
	}

	/**
	 * @param displayName10
	 */
	public void setDisplayName10(String displayName10) {
		this.displayName10 = displayName10;
	}

	/**
	 * @return
	 */
	public String getFilePath10() {
		return filePath10;
	}

	/**
	 * @param filePath10
	 */
	public void setFilePath10(String filePath10) {
		this.filePath10 = filePath10;
	}

	/**
	 * @return
	 */
	public long getFileSize10() {
		return fileSize10;
	}

	/**
	 * @param fileSize10
	 */
	public void setFileSize10(long fileSize10) {
		this.fileSize10 = fileSize10;
	}

	/**
	 * @return
	 */
	public int getImageWidth10() {
		return imageWidth10;
	}

	/**
	 * @param imageWidth10
	 */
	public void setImageWidth10(int imageWidth10) {
		this.imageWidth10 = imageWidth10;
	}

	/**
	 * @return
	 */
	public int getImageHeight10() {
		return imageHeight10;
	}

	/**
	 * @param imageHeight10
	 */
	public void setImageHeight10(int imageHeight10) {
		this.imageHeight10 = imageHeight10;
	}

	/**
	 * @return
	 */
	public String getDownLoadCount10() {
		return downLoadCount10;
	}

	/**
	 * @param downLoadCount10
	 */
	public void setDownLoadCount10(String downLoadCount10) {
		this.downLoadCount10 = downLoadCount10;
	}

	/**
     * @return
     */
    public MultipartFile getUplodeFile1() {
		return uplodeFile1;
	}

	/**
	 * @param uplodeFile1
	 */
	public void setUplodeFile1(MultipartFile uplodeFile1) {
		this.uplodeFile1 = uplodeFile1;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile2() {
		return uplodeFile2;
	}

	/**
	 * @param uplodeFile2
	 */
	public void setUplodeFile2(MultipartFile uplodeFile2) {
		this.uplodeFile2 = uplodeFile2;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile3() {
		return uplodeFile3;
	}

	/**
	 * @param uplodeFile3
	 */
	public void setUplodeFile3(MultipartFile uplodeFile3) {
		this.uplodeFile3 = uplodeFile3;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile4() {
		return uplodeFile4;
	}

	/**
	 * @param uplodeFile4
	 */
	public void setUplodeFile4(MultipartFile uplodeFile4) {
		this.uplodeFile4 = uplodeFile4;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile5() {
		return uplodeFile5;
	}

	/**
	 * @param uplodeFile5
	 */
	public void setUplodeFile5(MultipartFile uplodeFile5) {
		this.uplodeFile5 = uplodeFile5;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile6() {
		return uplodeFile6;
	}

	/**
	 * @param uplodeFile6
	 */
	public void setUplodeFile6(MultipartFile uplodeFile6) {
		this.uplodeFile6 = uplodeFile6;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile7() {
		return uplodeFile7;
	}

	/**
	 * @param uplodeFile7
	 */
	public void setUplodeFile7(MultipartFile uplodeFile7) {
		this.uplodeFile7 = uplodeFile7;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile8() {
		return uplodeFile8;
	}

	/**
	 * @param uplodeFile8
	 */
	public void setUplodeFile8(MultipartFile uplodeFile8) {
		this.uplodeFile8 = uplodeFile8;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile9() {
		return uplodeFile9;
	}

	/**
	 * @param uplodeFile9
	 */
	public void setUplodeFile9(MultipartFile uplodeFile9) {
		this.uplodeFile9 = uplodeFile9;
	}

	/**
	 * @return
	 */
	public MultipartFile getUplodeFile10() {
		return uplodeFile10;
	}

	/**
	 * @param uplodeFile10
	 */
	public void setUplodeFile10(MultipartFile uplodeFile10) {
		this.uplodeFile10 = uplodeFile10;
	}

	/**
	 * @return
	 */
	public String getSortTree() {
		return sortTree;
	}

	/**
	 * @param sortTree
	 */
	public void setSortTree(String sortTree) {
		this.sortTree = sortTree;
	}

	public String[] getOldOptId() {
		return oldOptId;
	}

	public void setOldOptId(String[] oldOptId) {
		this.oldOptId = oldOptId;
	}

	/**
	 * @return
	 */
	public String[] getOptId() {
		return optId;
	}

	/**
	 * @param optId
	 */
	public void setOptId(String[] optId) {
		this.optId = optId;
	}

	/**
	 * @return
	 */
	public String[] getOptName() {
		return optName;
	}

	/**
	 * @param optName
	 */
	public void setOptName(String[] optName) {
		this.optName = optName;
	}

	/**
	 * @return
	 */
	public String[] getOptPrice() {
		return optPrice;
	}

	/**
	 * @param optPrice
	 */
	public void setOptPrice(String[] optPrice) {
		this.optPrice = optPrice;
	}

	/**
     * @return
     */
    public ProductVO getProductVO(
    		AttachmentVO attachmentVO1,
    		AttachmentVO attachmentVO2,
    		AttachmentVO attachmentVO3,
    		AttachmentVO attachmentVO4,
    		AttachmentVO attachmentVO5,
    		AttachmentVO attachmentVO6,
    		AttachmentVO attachmentVO7,
    		AttachmentVO attachmentVO8,
    		AttachmentVO attachmentVO9,
    		AttachmentVO attachmentVO10){

    	//리스트 생성
    	List<ProductContentsVO> productContentsList = new ArrayList<ProductContentsVO>();
    	List<ProductAttachementVO> productAttachementList = new ArrayList<ProductAttachementVO>();

    	//상품 내용 격납
    	ProductContentsVO productContentsVO = new ProductContentsVO();
    	productContentsVO.setPrdConId(this.prdConId);
        productContentsVO.setContents(this.contents);
        productContentsList.add(productContentsVO);

        //상품 첨부파일 격납
        if(attachmentVO1 != null){
            ProductAttachementVO productAttachementVO1 = new ProductAttachementVO();
            productAttachementVO1.setPrdAttaId(this.prdAttaId1);
            productAttachementVO1.setImageType(Constants.IMAGE_TYPE_LIST);
            productAttachementVO1.setFileType(Constants.FILE_TYPE_IMG);
            productAttachementVO1.setContentType(attachmentVO1.getContentType());
            productAttachementVO1.setFileName(attachmentVO1.getFileName());
            productAttachementVO1.setFilePath(attachmentVO1.getFilePath());
            productAttachementVO1.setFileSize(attachmentVO1.getFileSize());
            productAttachementVO1.setImageWidth(attachmentVO1.getImageWidth());
            productAttachementVO1.setImageHeight(attachmentVO1.getImageHeight());
            productAttachementVO1.setDisplayName(attachmentVO1.getOriginalFilename());
            productAttachementList.add(productAttachementVO1);
        }
        //상품 첨부파일 격납
        if(attachmentVO2 != null){
	        ProductAttachementVO productAttachementVO2 = new ProductAttachementVO();
	        productAttachementVO2.setPrdAttaId(this.prdAttaId2);
	        productAttachementVO2.setImageType(Constants.IMAGE_TYPE_DETAIL1);
	        productAttachementVO2.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO2.setContentType(attachmentVO2.getContentType());
	        productAttachementVO2.setFileName(attachmentVO2.getFileName());
	        productAttachementVO2.setFilePath(attachmentVO2.getFilePath());
	        productAttachementVO2.setFileSize(attachmentVO2.getFileSize());
	        productAttachementVO2.setImageWidth(attachmentVO2.getImageWidth());
	        productAttachementVO2.setImageHeight(attachmentVO2.getImageHeight());
	        productAttachementVO2.setDisplayName(attachmentVO2.getOriginalFilename());
	        productAttachementList.add(productAttachementVO2);
        }
        //상품 첨부파일 격납
        if(attachmentVO3 != null){
	        ProductAttachementVO productAttachementVO3 = new ProductAttachementVO();
	        productAttachementVO3.setPrdAttaId(this.prdAttaId3);
	        productAttachementVO3.setImageType(Constants.IMAGE_TYPE_DETAIL2);
	        productAttachementVO3.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO3.setContentType(attachmentVO3.getContentType());
	        productAttachementVO3.setFileName(attachmentVO3.getFileName());
	        productAttachementVO3.setFilePath(attachmentVO3.getFilePath());
	        productAttachementVO3.setFileSize(attachmentVO3.getFileSize());
	        productAttachementVO3.setImageWidth(attachmentVO3.getImageWidth());
	        productAttachementVO3.setImageHeight(attachmentVO3.getImageHeight());
	        productAttachementVO3.setDisplayName(attachmentVO3.getOriginalFilename());
	        productAttachementList.add(productAttachementVO3);
        }
        //상품 첨부파일 격납
        if(attachmentVO4 != null){
	        ProductAttachementVO productAttachementVO4= new ProductAttachementVO();
	        productAttachementVO4.setPrdAttaId(this.prdAttaId4);
	        productAttachementVO4.setImageType(Constants.IMAGE_TYPE_DETAIL3);
	        productAttachementVO4.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO4.setContentType(attachmentVO4.getContentType());
	        productAttachementVO4.setFileName(attachmentVO4.getFileName());
	        productAttachementVO4.setFilePath(attachmentVO4.getFilePath());
	        productAttachementVO4.setFileSize(attachmentVO4.getFileSize());
	        productAttachementVO4.setImageWidth(attachmentVO4.getImageWidth());
	        productAttachementVO4.setImageHeight(attachmentVO4.getImageHeight());
	        productAttachementVO4.setDisplayName(attachmentVO4.getOriginalFilename());
	        productAttachementList.add(productAttachementVO4);
        }
        //상품 첨부파일 격납
        if(attachmentVO5 != null){
	        ProductAttachementVO productAttachementVO5 = new ProductAttachementVO();
	        productAttachementVO5.setPrdAttaId(this.prdAttaId5);
	        productAttachementVO5.setImageType(Constants.IMAGE_TYPE_DETAIL4);
	        productAttachementVO5.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO5.setContentType(attachmentVO5.getContentType());
	        productAttachementVO5.setFileName(attachmentVO5.getFileName());
	        productAttachementVO5.setFilePath(attachmentVO5.getFilePath());
	        productAttachementVO5.setFileSize(attachmentVO5.getFileSize());
	        productAttachementVO5.setImageWidth(attachmentVO5.getImageWidth());
	        productAttachementVO5.setImageHeight(attachmentVO5.getImageHeight());
	        productAttachementVO5.setDisplayName(attachmentVO5.getOriginalFilename());
	        productAttachementList.add(productAttachementVO5);
        }
        //상품 첨부파일 격납
        if(attachmentVO6 != null){
	        ProductAttachementVO productAttachementVO6 = new ProductAttachementVO();
	        productAttachementVO6.setPrdAttaId(this.prdAttaId6);
	        productAttachementVO6.setImageType(Constants.IMAGE_TYPE_DETAIL5);
	        productAttachementVO6.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO6.setContentType(attachmentVO6.getContentType());
	        productAttachementVO6.setFileName(attachmentVO6.getFileName());
	        productAttachementVO6.setFilePath(attachmentVO6.getFilePath());
	        productAttachementVO6.setFileSize(attachmentVO6.getFileSize());
	        productAttachementVO6.setImageWidth(attachmentVO6.getImageWidth());
	        productAttachementVO6.setImageHeight(attachmentVO6.getImageHeight());
	        productAttachementVO6.setDisplayName(attachmentVO6.getOriginalFilename());
	        productAttachementList.add(productAttachementVO6);
        }
        //상품 첨부파일 격납
        if(attachmentVO7 != null){
	        ProductAttachementVO productAttachementVO7 = new ProductAttachementVO();
	        productAttachementVO7.setPrdAttaId(this.prdAttaId7);
	        productAttachementVO7.setImageType(Constants.IMAGE_TYPE_DETAIL6);
	        productAttachementVO7.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO7.setContentType(attachmentVO7.getContentType());
	        productAttachementVO7.setFileName(attachmentVO7.getFileName());
	        productAttachementVO7.setFilePath(attachmentVO7.getFilePath());
	        productAttachementVO7.setFileSize(attachmentVO7.getFileSize());
	        productAttachementVO7.setImageWidth(attachmentVO7.getImageWidth());
	        productAttachementVO7.setImageHeight(attachmentVO7.getImageHeight());
	        productAttachementVO7.setDisplayName(attachmentVO7.getOriginalFilename());
	        productAttachementList.add(productAttachementVO7);
        }
        //상품 첨부파일 격납
        if(attachmentVO8 != null){
	        ProductAttachementVO productAttachementVO8 = new ProductAttachementVO();
	        productAttachementVO8.setPrdAttaId(this.prdAttaId8);
	        productAttachementVO8.setImageType(Constants.IMAGE_TYPE_DETAIL7);
	        productAttachementVO8.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO8.setContentType(attachmentVO8.getContentType());
	        productAttachementVO8.setFileName(attachmentVO8.getFileName());
	        productAttachementVO8.setFilePath(attachmentVO8.getFilePath());
	        productAttachementVO8.setFileSize(attachmentVO8.getFileSize());
	        productAttachementVO8.setImageWidth(attachmentVO8.getImageWidth());
	        productAttachementVO8.setImageHeight(attachmentVO8.getImageHeight());
	        productAttachementVO8.setDisplayName(attachmentVO8.getOriginalFilename());
	        productAttachementList.add(productAttachementVO8);
        }
        //상품 첨부파일 격납
        if(attachmentVO9 != null){
	        ProductAttachementVO productAttachementVO9 = new ProductAttachementVO();
	        productAttachementVO9.setPrdAttaId(this.prdAttaId9);
	        productAttachementVO9.setImageType(Constants.IMAGE_TYPE_DETAIL8);
	        productAttachementVO9.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO9.setContentType(attachmentVO9.getContentType());
	        productAttachementVO9.setFileName(attachmentVO9.getFileName());
	        productAttachementVO9.setFilePath(attachmentVO9.getFilePath());
	        productAttachementVO9.setFileSize(attachmentVO9.getFileSize());
	        productAttachementVO9.setImageWidth(attachmentVO9.getImageWidth());
	        productAttachementVO9.setImageHeight(attachmentVO9.getImageHeight());
	        productAttachementVO9.setDisplayName(attachmentVO9.getOriginalFilename());
	        productAttachementList.add(productAttachementVO9);
        }
        //상품 첨부파일 격납
        if(attachmentVO10 != null){
	        ProductAttachementVO productAttachementVO10 = new ProductAttachementVO();
	        productAttachementVO10.setPrdAttaId(this.prdAttaId10);
	        productAttachementVO10.setImageType(Constants.IMAGE_TYPE_DETAIL9);
	        productAttachementVO10.setFileType(Constants.FILE_TYPE_IMG);
	        productAttachementVO10.setContentType(attachmentVO10.getContentType());
	        productAttachementVO10.setFileName(attachmentVO10.getFileName());
	        productAttachementVO10.setFilePath(attachmentVO10.getFilePath());
	        productAttachementVO10.setFileSize(attachmentVO10.getFileSize());
	        productAttachementVO10.setImageWidth(attachmentVO10.getImageWidth());
	        productAttachementVO10.setImageHeight(attachmentVO10.getImageHeight());
	        productAttachementVO10.setDisplayName(attachmentVO10.getOriginalFilename());
	        productAttachementList.add(productAttachementVO10);
        }
        //상품 기본 정보 격납
    	ProductVO productVO = new ProductVO();
    	productVO.setPrdId(this.prdId);
    	productVO.setCateId(this.cateId);
        productVO.setPrdName(this.prdName);
        productVO.setUnit(this.unit);
        productVO.setExpirationMonth(this.expirationMonth);
        productVO.setPrice(this.price);
        productVO.setSalePrice(this.salePrice);
        productVO.setComp(this.comp);
        productVO.setCountry(this.country);
        productVO.setRegisterId(this.registerId);
        productVO.setRegisterIp(this.registerIp);
        productVO.setUpdateId(this.updateId);
        productVO.setUpdateIp(this.updateIp);
        productVO.setStatusType(this.statusType);

        productVO.setProductContentsVO(productContentsList);
        productVO.setProductAttachementVO(productAttachementList);
    	return productVO;
    }

}
