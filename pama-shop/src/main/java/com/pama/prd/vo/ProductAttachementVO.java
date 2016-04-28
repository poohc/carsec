package com.pama.prd.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productAttachement")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductAttachementVO implements Serializable
{
    /**
     * UID
     */
    private static final long serialVersionUID = -3147167878260473384L;

    /**
     * 첨부파일 ID
     */
    @XmlElement(name = "prdAttaId")
    private String prdAttaId;
    
    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;
    
    /**
     * 이미지 타입
     */
    @XmlElement(name = "imageType")
    private String imageType;
    
    /**
     * 파일 타입
     */
    @XmlElement(name = "fileType")
    private int fileType;
    
    /**
     * 컨텐츠 타입
     */
    @XmlElement(name = "contentType")
    private String contentType;
    
    /**
     * 파일 이름
     */
    @XmlElement(name = "fileName")
    private String fileName;

    /**
     * 파일 표시 이름
     */
    @XmlElement(name = "displayName")
    private String displayName;
    
    /**
     * 파일 경로
     */
    @XmlElement(name = "filePath")
    private String filePath;

    /**
     * 파일 사이즈
     */
    @XmlElement(name = "fileSize")
    private long fileSize;
    
    /**
     * 파일 넓이
     */
    @XmlElement(name = "imageWidth")
    private int imageWidth;
    
    /**
     * 파일 높이
     */
    @XmlElement(name = "imageHeight")
    private int imageHeight;

    /**
     * 다운로드 수
     */
    @XmlElement(name = "downLoadCount")
    private String downLoadCount;
    
    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;
    
    /**
     * @return
     */
    public String getPrdAttaId() {
        return prdAttaId;
    }

    /**
     * @param prdAttaId
     */
    public void setPrdAttaId(String prdAttaId) {
        this.prdAttaId = prdAttaId;
    }

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
    public String getImageType() {
        return imageType;
    }

    /**
     * @param imageType
     */
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    /**
     * @return
     */
    public int getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    /**
     * @return
     */
    public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return
     */
    public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth
	 */
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight
	 */
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
     * @return
     */
    public String getDownLoadCount() {
        return downLoadCount;
    }

    /**
     * @param downLoadCount
     */
    public void setDownLoadCount(String downLoadCount) {
        this.downLoadCount = downLoadCount;
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
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
}
