/**
 * 이소스는 저작권은 개발자  pama게시판 개발자에게 있습니다.
 * 납품한 홈페이지에서는 자유롭게 수정 및 편집이 가능하나 다른 홈페이지에
 * 게재시 지적 재산권에 문제있음을 공지합니다.
 * 개발자 : pama
 * 이메일 : sycop78@gmail.com
 */
package com.pama.bbs.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messageAttachment")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageAttachmentVO implements java.io.Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -3912443330191379834L;

	@XmlElement(name = "attachmentId")
    private String attachmentId;

    @XmlElement(name = "messageId")
    private String messageId;

    @XmlElement(name = "fileType")
    private String fileType;

    @XmlElement(name = "contentType")
    private String contentType;

    @XmlElement(name = "fileName")
    private String fileName;

    @XmlElement(name = "displayName")
    private String displayName;

    @XmlElement(name = "filePath")
    private String filePath;

    @XmlElement(name = "fileSize")
    private String fileSize;

    @XmlElement(name = "downloadCount")
    private String downloadCount;

    @XmlElement(name = "registerDate")
    private String registerDate;

    @XmlElement(name = "imageWidth")
    private String imageWidth;

    @XmlElement(name = "imageHeight")
    private String imageHeight;

    @XmlElement(name = "fileExt")
    private String fileExt;

    @XmlElement(name = "showIndex")
    private int showIndex;

    @XmlElement(name = "registerAfterHour")
    private String registerAfterHour;//등록후 지난시간

    @XmlElement(name = "updateAfterdHour")
    private String updateAfterdHour;//수정후 지난시간

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "boardId")
    private String boardId;

    @XmlElement(name = "messageCategoryId")
    private String messageCategoryId;

	/**
	 * @return the attachmentId
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the downloadCount
	 */
	public String getDownloadCount() {
		return downloadCount;
	}

	/**
	 * @param downloadCount the downloadCount to set
	 */
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}

	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the imageWidth
	 */
	public String getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public String getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the fileExt
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @param fileExt the fileExt to set
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	/**
	 * @return the registerAfterHour
	 */
	public String getRegisterAfterHour() {
		return registerAfterHour;
	}

	/**
	 * @param registerAfterHour the registerAfterHour to set
	 */
	public void setRegisterAfterHour(String registerAfterHour) {
		this.registerAfterHour = registerAfterHour;
	}

	/**
	 * @return the updateAfterdHour
	 */
	public String getUpdateAfterdHour() {
		return updateAfterdHour;
	}

	/**
	 * @param updateAfterdHour the updateAfterdHour to set
	 */
	public void setUpdateAfterdHour(String updateAfterdHour) {
		this.updateAfterdHour = updateAfterdHour;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the boardId
	 */
	public String getBoardId() {
		return boardId;
	}

	/**
	 * @param boardId the boardId to set
	 */
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	/**
	 * @return the messageCategoryId
	 */
	public String getMessageCategoryId() {
		return messageCategoryId;
	}

	/**
	 * @param messageCategoryId the messageCategoryId to set
	 */
	public void setMessageCategoryId(String messageCategoryId) {
		this.messageCategoryId = messageCategoryId;
	}

	public int getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageAttachmentVO [attachmentId=" + attachmentId + ", messageId=" + messageId + ", fileType="
				+ fileType + ", contentType=" + contentType + ", fileName=" + fileName + ", displayName=" + displayName
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", downloadCount=" + downloadCount
				+ ", registerDate=" + registerDate + ", imageWidth=" + imageWidth + ", imageHeight=" + imageHeight
				+ ", fileExt=" + fileExt + ", showIndex=" + showIndex + ", registerAfterHour=" + registerAfterHour
				+ ", updateAfterdHour=" + updateAfterdHour + ", title=" + title + ", boardId=" + boardId
				+ ", messageCategoryId=" + messageCategoryId + "]";
	}

}
