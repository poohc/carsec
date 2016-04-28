package com.pama.cmm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pama.bbs.service.MessageService;
import com.pama.common.Constants;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Controller
@RequestMapping("/media/*")
public class MediaController {
    private static final Log LOG = LogFactory.getLog(MediaController.class);

    @Autowired
    private AttachmentProcessor attachmentProcessor;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value="/{imageId}.image", method = RequestMethod.GET)
    public void getImageDownload(HttpServletRequest request, HttpServletResponse response, @PathVariable String imageId) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getImageDownload' controller...");
        }
        AttachmentVO attachmentVO = attachmentProcessor.getImage(imageId);

        URL url=null;
        File file = null;
        OutputStream out = null;
        FileInputStream fis = null;

        if(attachmentVO != null){//no 이미지 처리
            file = new File(attachmentVO.getFilePath(), attachmentVO.getOriginalFilename());
        }

        if(attachmentVO == null || !file.exists()){
            url = this.getClass( ).getResource( "/media/noimage_thumb.gif" );
            file = new File(url.getPath());
        }

        response.setContentLength((int) file.length() );
        response.setHeader("Content-Transfer-Encoding", "binary");

        try {
            out = response.getOutputStream();
            try {
                fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, out);

            } finally {
                if (fis != null){
                    try {fis.close();} catch (IOException ex) {}
                }
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value="{serviceId}/download.do", method = RequestMethod.GET)
    public void getFileDownload(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("serviceId") String serviceId,
            @RequestParam("attachmentId") int attachmentId
            ) throws Exception {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'getFileDownload' controller...");
        }
        AttachmentVO attachmentVO = attachmentProcessor.getAttachment(serviceId, attachmentId);

        File file = null;
        OutputStream out = null;
        FileInputStream fis = null;

        if(attachmentVO != null){
            file = new File(attachmentVO.getFilePath(), attachmentVO.getFileName());
        }

        if(attachmentVO == null || !file.exists()){
            response.sendError(404);
            return;
        }

        String originalFilename = attachmentVO.getOriginalFilename();
        if(StringUtils.isBlank(originalFilename)){
            originalFilename=System.currentTimeMillis() +"";
        }

        /** 브라우져 세팅 ------------------------- **/
        String strClient = request.getHeader("User-Agent");
        response.setHeader("Cache-control", "private");
        if(strClient.indexOf("MSIE 5.5") != -1 ){
            response.setHeader("Content-Type", "doesn/matter");
            this.setDBCSHeader("Content-Disposition",
                    "filename=\"" + URLEncoder.encode(originalFilename, "UTF-8") + "\";", response);

        }else if(strClient.indexOf("MSIE") != -1 ){
            response.setHeader("Content-Type", "application/octet-stream");
            this.setDBCSHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(originalFilename, "UTF-8") + "\";", response);

        }else {
            response.setHeader("Content-Type", "application/octet-stream");
            this.setDBCSHeader("Content-Disposition",
                    "attachment;filename=\"" + originalFilename + "\";", response);
        }
        /** 브라우져 세팅 ------------------------- **/

        response.setContentLength((int) file.length() );

        try {
            out = response.getOutputStream();
            try {
                fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, out);

            } finally {
                if (fis != null){
                    try {fis.close();} catch (IOException ex) {}
                }
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value="{serviceId}/ckeditorUpload.do", method = RequestMethod.POST)
    public void ckeditorUpload(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("serviceId") String serviceId,
            @RequestParam MultipartFile upload,
            @RequestParam String CKEditorFuncNum
            ) throws IllegalStateException, IOException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'ckeditorUpload' controller...");
        }

        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        if(
                !(StringUtils.equals(serviceId, Constants.SERVICE_ID_ACCOUNT)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_BBS)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_ORDER)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_PRODUCTS))
        ){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"잘못된 서비스식별자(serviceId)\");");
            out.println("</script>");
        }else{

        	AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId, upload);
        	out.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
                     + CKEditorFuncNum
                     + ",'"
                     + "/media/"+attachmentVO.getFileName()+".image"
                     + "','이미지를 업로드 하였습니다.'"
                     + ")</script>");

        }
        out.flush();
        out.close();

    }

    @RequestMapping(value="{serviceId}/ckeditorUploader.do", method = RequestMethod.POST)
    public ModelAndView ckeditorUploader(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("serviceId") String serviceId,
            @RequestParam MultipartFile upload
            ) throws IllegalStateException, IOException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'ckeditorUpload' controller...");
        }

        ModelAndView mav = new ModelAndView("jsonView");
        if(
                !(StringUtils.equals(serviceId, Constants.SERVICE_ID_ACCOUNT)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_BBS)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_ORDER)
                        || StringUtils.equals(serviceId, Constants.SERVICE_ID_PRODUCTS))
        ){

        }else{

        	AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId, upload);
        	mav.addObject("uploaded","1");
            mav.addObject("fileName", attachmentVO.getOriginalFilename());
            mav.addObject("url","/media/"+attachmentVO.getFileName()+".image");
        	System.out.println(attachmentVO.toString());

        }

        return mav;


    }

    /**
     * 파일업로드 Admin에서 팝업
     * @param request
     * @param response
     * @param serviceId
     * @param multipartFile
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value="{serviceId}/uploadFile.do", method = RequestMethod.POST)
    public void addUploadFile(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("serviceId") String serviceId,
            @RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addUploadFile' controller...");
        }
//TODO : 섹션인증
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();


        if(
                !(StringUtils.startsWith(serviceId, Constants.SERVICE_ID_ACCOUNT)
                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_BBS)
                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_ORDER)
                        || StringUtils.startsWith(serviceId, Constants.SERVICE_ID_PRODUCTS))
        ){
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"잘못된 서비스식별자(serviceId)\");");
            out.println("</script>");
        }
        String closeScript="";
        String serviceId2=serviceId;

        if(StringUtils.startsWith(serviceId, Constants.SERVICE_ID_BBS)){
        	closeScript = StringUtils.removeStart(serviceId, Constants.SERVICE_ID_BBS);
        	serviceId2=StringUtils.removeEnd(serviceId2, closeScript);

        }


        AttachmentVO attachmentVO = attachmentProcessor.upload(serviceId2, multipartFile);
        String fileName = attachmentVO.getFileName();

        String imgSrc ="/media/" +  fileName + ".image";
//        out.println("<script src='/common/js/jquery/jquery.js'   type='text/javascript' charset='UTF-8'></script>");
        out.println("<script type=\"text/javascript\">");
        out.println("window.opener.set"+closeScript+"(");
        out.println("		{");
        out.println("			'fileUploadType' : 'new',");
        out.println("			'filePath' : '" + imgSrc + "',");
        out.println("			'originalFilename' : '" + attachmentVO.getOriginalFilename() + "',");
    	out.println("		  	'fileSize' : '" + attachmentVO.getFileSize() + "',");
    	out.println("		  	'fileName' : '" + attachmentVO.getFileName() + "',");
    	out.println("		  	'contentType' : '" + attachmentVO.getContentType() + "',");
    	out.println("		  	'imageHeight' : '" + attachmentVO.getImageHeight() + "',");
    	out.println("		  	'imageWidth' : '" + attachmentVO.getImageWidth() + "'");
    	out.println("		}");
    	out.println(");");
    	out.println("window.self.close();");
    	out.println("</script>");

        out.flush();
        out.close();

    }


    @RequestMapping(value="{serviceId}/uploadReFile.json", method = RequestMethod.GET)
    public ModelAndView removeUploadFile(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("serviceId") String serviceId,
            @RequestParam("imageId") String imageId) {

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'removeUploadFile' controller...");
        }

    	AttachmentVO attachmentVO = attachmentProcessor.getImage(imageId);

    	File f = new File(attachmentVO.getFilePath(),attachmentVO.getOriginalFilename());

    	f.delete();

    	ModelAndView mav = new ModelAndView("jsonView");
    	mav.addObject("msgCode","100");
    	return mav;

    }

    @RequestMapping(value="{serviceId}/uploadForm.do", method = RequestMethod.GET)
    public ModelAndView uploadForm(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("serviceId") String serviceId) {

        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'uploadForm' controller...");
        }

    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("/modules/upload/uploadForm");
    	return mav;
    }

    private void setDBCSHeader(String header, String value, HttpServletResponse response) {
        byte by[];
        try {
            by = value.getBytes(response.getCharacterEncoding());
        }
        catch (Exception ex) {
            by = value.getBytes();
        }
        char c[] = new char[by.length];
        for (int i=0;i<by.length;i++){
            c[i]=(char)(((char)by[i])&0xff);
        }
        response.setHeader(header,new String(c));
    }

}
