package com.pama.processor.impl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pama.processor.MailSendProcessor;
import com.pama.processor.vo.SendMailVO;

@Service
public class MailSendProcessorImpl implements MailSendProcessor
{
	@Value("${mail.defaultEncoding}")
    private String defaultEncoding;

	@Value("${mail.defaultFromEmail}")
    private String defaultFromEmail;

	@Value("${mail.defaultFromName}")
    private String defaultFromName;

	@Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(SendMailVO sendMailVO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        if(StringUtils.isEmpty(sendMailVO.getFromEmail())){
            sendMailVO.setFromEmail(defaultFromEmail);
        }

        if(StringUtils.isEmpty(sendMailVO.getFromName())){
            sendMailVO.setFromName(defaultFromName);
        }

        try {

            boolean isMultipart = false;
            //        if(files.length > 0){
            //            isMultipart = true;
            //        }
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, isMultipart, defaultEncoding);
            mimeMessageHelper.setFrom(new InternetAddress(sendMailVO.getFromEmail(), sendMailVO.getFromName(),"UTF-8"));
            mimeMessageHelper.setTo(new InternetAddress(sendMailVO.getToEmail(), sendMailVO.getToName(),"UTF-8"));

            //참조
            //mimeMessageHelper.addCc(cc, personal);
            //비밀참조
            //mimeMessageHelper.addBcc(bcc, personal);

            mimeMessageHelper.setSubject(sendMailVO.getSubject());
            mimeMessageHelper.setText(sendMailVO.getHtmlMessage(), true);


            if(isMultipart){
                //        	mimeMessageHelper.addAttachment("", file);
            }

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
