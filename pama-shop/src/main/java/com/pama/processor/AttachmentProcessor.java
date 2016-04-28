package com.pama.processor;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.pama.processor.vo.AttachmentVO;

/**
 *  파일업로드 다운로드에 대한 처리
 * @author sycopmac
 */
public interface AttachmentProcessor {


    /**
     * @param serviceId
     * @param imageUrl
     * @param ext
     * @return
     * @throws Exception
     */
    public AttachmentVO imageUpload(String serviceId, String imageUrl, String ext) throws Exception;

    /**
     * 파일업로드
     * @param serviceId
     * @param multipartFile
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentVO upload(String serviceId, MultipartFile multipartFile) throws IllegalStateException, IOException;

    /**
     * 파일업로드 확장명 추가
     * @param serviceId
     * @param multipartFile
     * @param ext
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentVO upload(String serviceId, MultipartFile multipartFile, String ext) throws IllegalStateException, IOException;

    /**
     * 파일정보를 얻는다.
     * @param imageId
     * imageId : serviceId + DateDir + FileName 조합
     * @return
     */
    public AttachmentVO getImage(String imageId);

    /**
     * 이동된 파일정보를 얻는다.
     * @param arrFile
     * @param serviceId
     * @param moveId
     * arrFile : fileUploadType + fileName + originalFilename + fileSize + contentType + imageWidth + imageHight
     * @return
     */
    public AttachmentVO getMoveFile(String serviceId, String moveId, String arrFile);

    /**
     * 썸네일을 만든다.
     * @param serviceId
     * @param arrFile
     * arrFile : fileUploadType + fileName + originalFilename + fileSize + contentType + imageWidth + imageHight
     * @return
     */
    public AttachmentVO getThumbnailFile(String serviceId, String arrFile);

    /**
     * 파일정보를 얻는다.(DB에서 조회한다)
     * @param  serviceId
     * @param  attachmentId
     * @return
     */
    public AttachmentVO getAttachment(String serviceId, int attachmentId);

    /**
     * 삭제
     * @throws IOException
     */
    public boolean removeFile(String serviceId, String fileName) throws IOException;


}


