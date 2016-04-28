package com.pama.cmm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pama.processor.AttachmentProcessor;

@Controller
public class UploaderController {
    private static final Log LOG = LogFactory.getLog(UploaderController.class);

    @Autowired
    private AttachmentProcessor attachmentProcessor;

	@Value("#{config['upload.path']}")
    private String uploadpath;

    @RequestMapping(value="/uploadFile.do", method = RequestMethod.POST)
    public void addUploadFile(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("data") MultipartFile multipartFile
            ) throws IllegalStateException, IOException{
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("starting 'addUploadFile' controller...");
        }

        System.out.println("ssssssssssss");
//
//        response.setContentType("text/html; charset=UTF-8");
//        response.setHeader("Cache-Control", "no-cache");
//
//        AttachmentVO attachmentVO = attachmentProcessor.upload("flashtest", multipartFile);
//        System.out.println(attachmentVO.toString());

    }

}