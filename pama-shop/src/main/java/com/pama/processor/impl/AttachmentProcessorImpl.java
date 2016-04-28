package com.pama.processor.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.ImageIcon;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pama.common.Constants;
import com.pama.common.util.ThumbnailUtil;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

/**
 *  파일업로드 다운로드에 대한 처리
 * @author sycopmac
 */
@Service
public class AttachmentProcessorImpl implements AttachmentProcessor {

    /**
     *  파일업로드   root 패스
     */
	@Value("#{config['upload.path']}")
    private String uploadPath;

    public AttachmentVO imageUpload(String serviceId, String imageUrl, String ext) throws Exception {

        if(StringUtils.isEmpty(serviceId) ||  StringUtils.isEmpty(imageUrl) ){
            return null;
        }

        URL url = new URL(imageUrl);

        Image image = new ImageIcon(FileCopyUtils.copyToByteArray(url.openStream())).getImage();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        File f = new File(url.getFile());



        long systemCurrTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd");
        String dateDir = formatter.format(systemCurrTime);

        String filePath = this.uploadPath + "/" + serviceId + "/" + dateDir;

        String fileName = "";
        if ("".equals(ext))	{
        	fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString();
        } else {
        	fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString() + "." + ext;
        }

        File fileDir = new File(filePath);
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

        f.renameTo(new File(fileDir, fileName));

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(fileName);
        attachmentVO.setContentType("image");
        attachmentVO.setFileName(fileName);
        attachmentVO.setFilePath(filePath);
        attachmentVO.setFileSize(f.length());
        attachmentVO.setImageWidth(imageWidth);
        attachmentVO.setImageHeight(imageHeight);

        ThumbnailUtil.createThumbnail(f,new File(filePath + File.separator + "thumb"),20);

        return attachmentVO;
    }

    public AttachmentVO upload(String serviceId, MultipartFile multipartFile) throws IllegalStateException, IOException  {
    	return upload(serviceId, multipartFile, "");
    }

    /* (non-Javadoc)
     * @see com.pama.processor.AttachmentProcessor#upload(java.lang.String, org.springframework.web.multipart.MultipartFile)
     */
    @Override
	public AttachmentVO upload(String serviceId, MultipartFile multipartFile, String ext) throws IllegalStateException, IOException  {

        //인자값검증 추가 : 2011-04-20
        if(StringUtils.isEmpty(serviceId) ||  multipartFile==null || multipartFile.getSize()==0){
            return null;
        }

        //파일확장자처리부분
        //	if(imageId.matches("(?i)^[ \\w\uAC00-\uD7A3]+\\.(jpg|gif|bmp|doc|pdf|ppt|txt|xls|zip)$")){
        //			return;
        //		}

        long systemCurrTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd");
        String dateDir = formatter.format(systemCurrTime);

        String filePath = this.uploadPath + "/" + serviceId + "/" + dateDir;
        String fileName = "";
        if ("".equals(ext))	{
        	fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString();
        } else {
        	fileName = serviceId + Constants.FILE_NAME_DECIMAL + dateDir + Constants.FILE_NAME_DECIMAL + UUID.randomUUID().toString() + "." + ext;
        }

        File fileDir = new File(filePath);
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

        File uploadFile = new File(fileDir, fileName);
        multipartFile.transferTo(uploadFile);

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setOriginalFilename(multipartFile.getOriginalFilename());
        attachmentVO.setContentType(multipartFile.getContentType());
        attachmentVO.setFileName(fileName);
        attachmentVO.setFilePath(filePath);
        attachmentVO.setFileSize(multipartFile.getSize());

        int imageWidth=0;
        int imageHeight=0;
        if(StringUtils.startsWith(multipartFile.getContentType(), "image")){
            //이미지일경우에
            Image image = new ImageIcon(uploadFile.getAbsolutePath()).getImage();
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
        }

        attachmentVO.setImageWidth(imageWidth);
        attachmentVO.setImageHeight(imageHeight);

        return attachmentVO;
    }

    /* (non-Javadoc)
     * @see com.pama.processor.AttachmentProcessor#getAttachment(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public AttachmentVO getImage(String imageId) {
        //인자값검증 추가 : 2011-04-20
        if(StringUtils.isEmpty(imageId)){
            return null;
        }

        imageId = imageId.replaceAll("\\..\\/", "");
        imageId = imageId.replaceAll("\\.\\/", "");
        imageId = imageId.replaceAll(".*\\.\\./.*","");


        String[] imageIds = StringUtils.split(imageId, Constants.FILE_NAME_DECIMAL);
        if(imageIds.length != 3){
            return null;
        }

        String serviceId = imageIds[0];
        String dateDir = imageIds[1];
        String originalFilename = imageId;

        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setFilePath(this.uploadPath + "/" + serviceId + "/" + dateDir);
        attachmentVO.setOriginalFilename(originalFilename);

        return attachmentVO;
    }

    /* (non-Javadoc)
     * @see com.pama.processor.AttachmentProcessor#getMoveFile(java.lang.String)
     */
    @Override
    public AttachmentVO getMoveFile(String serviceId, String moveId, String arrFile) {
    	String[] fileInfo = arrFile.split("\\|");
    	String[] filePath = fileInfo[1].split(Constants.FILE_NAME_DECIMAL);
    	File file = new File(
    						this.uploadPath
    						+ File.separator
    						+ filePath[0]
    						+ File.separator
    						+ filePath[1]
    						+ File.separator
    						+ fileInfo[1]);
    	File new_fileDir = new File(
    			this.uploadPath
				+ File.separator
				+ serviceId
				+ File.separator
				+ filePath[1]
		);

        if( !new_fileDir.exists() ){
        	new_fileDir.mkdirs();
        }

    	file.renameTo(
    			new File(
    			this.uploadPath
				+ File.separator
				+ serviceId
				+ File.separator
				+ filePath[1]
				+ File.separator
				+ fileInfo[1].replace(moveId, serviceId)
				)
		);

    	AttachmentVO attachmentVO = new AttachmentVO();
    	attachmentVO.setOriginalFilename(fileInfo[2]);
    	attachmentVO.setFileName(fileInfo[1].replace(moveId, serviceId));
    	attachmentVO.setFileSize(Long.parseLong(fileInfo[3]));
    	attachmentVO.setFilePath(new_fileDir.getPath());
    	attachmentVO.setContentType(fileInfo[4]);
    	attachmentVO.setImageHeight(Integer.parseInt(fileInfo[6]));
    	attachmentVO.setImageWidth(Integer.parseInt(fileInfo[5]));



    	return attachmentVO;
    }

    /* (non-Javadoc)
     * @see com.pama.processor.AttachmentProcessor#getThumbnailFile(java.lang.String, java.lang.String)
     */
    @Override
    public AttachmentVO getThumbnailFile(String serviceId, String arrFile) {
    	String[] fileInfo = arrFile.split("\\|");
    	String[] filePath = fileInfo[1].split(Constants.FILE_NAME_DECIMAL);

    	File file = new File(
				this.uploadPath
				+ File.separator
				+ filePath[0]
				+ File.separator
				+ filePath[1]
				+ File.separator
				+ fileInfo[1]);

        File fileDir = new File(
        						this.uploadPath
								+ File.separator
								+ serviceId
								+ File.separator
								+ filePath[1]
								+ File.separator
								+ "thumb");
        if( !fileDir.exists() ){
            fileDir.mkdirs();
        }

    	try {
			ThumbnailUtil.createThumbnail(
	    			new File(
	    					this.uploadPath
	    					+ File.separator
	    					+ serviceId
	    					+ File.separator
	    					+ filePath[1]
	    					+ File.separator
	    					+ fileInfo[1]
	    					),
	    	    	new File(
	    	    			this.uploadPath
	    					+ File.separator
	    					+ serviceId
	    					+ File.separator
	    					+ filePath[1]
	    					+ File.separator
	    					+ "thumb"
	    					+ File.separator
	    					+ fileInfo[1]
	    					)
	    			, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	AttachmentVO attachmentVO = new AttachmentVO();
    	attachmentVO.setOriginalFilename(fileInfo[2]);
    	attachmentVO.setFileName(fileInfo[1]);
    	attachmentVO.setFileSize(Long.parseLong(fileInfo[3]));
    	attachmentVO.setFilePath(file.getPath());
    	attachmentVO.setContentType(fileInfo[4]);
    	attachmentVO.setImageHeight(Integer.parseInt(fileInfo[6]));
    	attachmentVO.setImageWidth(Integer.parseInt(fileInfo[5]));

    	return attachmentVO;
    }

    /* (non-Javadoc)
     * @see com.pama.processor.AttachmentProcessor#getAttachment(java.lang.String)
     */
    @Override
    public AttachmentVO getAttachment(String serviceId, int attachmentId) {
        //인자값검증 추가 : 2011-04-20
        if(attachmentId==0){
            return null;
        }

        AttachmentVO attachmentVO = new AttachmentVO();

        return attachmentVO;
    }

	@Override
	public boolean removeFile(String serviceId, String fileName) throws IOException {

		AttachmentVO attachmentVO = getImage(fileName);
		File file = new File(attachmentVO.getFilePath()+File.separator+attachmentVO.getFileName());
		file.delete();
		return file.delete();
	}


}


