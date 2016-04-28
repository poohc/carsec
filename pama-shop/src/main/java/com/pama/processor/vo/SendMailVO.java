package com.pama.processor.vo;

import java.io.Serializable;

public class SendMailVO implements Serializable {

    private static final long serialVersionUID = -140553187921851886L;

    /**
     * 보내는 사람 이메일주소
     */
    String fromEmail;

    /**
     * 보내는 사람 이름
     */
    String fromName;

    /**
     * 받는 사람 이메일주소
     */
    String toEmail;

    /**
     * 받는 사람 이름
     */
    String toName;

    /**
     * 제목
     */
    String subject;

    /**
     * HTML 메세지
     */
    String htmlMessage;

    /**
     * @return the fromEmail
     */
    public String getFromEmail() {
        return fromEmail;
    }

    /**
     * @param fromEmail the fromEmail to set
     */
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    /**
     * @return the fromName
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * @param fromName the fromName to set
     */
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    /**
     * @return the toEmail
     */
    public String getToEmail() {
        return toEmail;
    }

    /**
     * @param toEmail the toEmail to set
     */
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    /**
     * @return the toName
     */
    public String getToName() {
        return toName;
    }

    /**
     * @param toName the toName to set
     */
    public void setToName(String toName) {
        this.toName = toName;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the htmlMessage
     */
    public String getHtmlMessage() {
        return htmlMessage;
    }

    /**
     * @param htmlMessage the htmlMessage to set
     */
    public void setHtmlMessage(String htmlMessage) {
        this.htmlMessage = htmlMessage;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SendMailVO [fromEmail=" + fromEmail + ", fromName=" + fromName
                + ", toEmail=" + toEmail + ", toName=" + toName + ", subject="
                + subject + ", htmlMessage=" + htmlMessage
                + ", getFromEmail()=" + getFromEmail() + ", getFromName()="
                + getFromName() + ", getToEmail()=" + getToEmail()
                + ", getToName()=" + getToName() + ", getSubject()="
                + getSubject() + ", getHtmlMessage()=" + getHtmlMessage() + "]";
    }
}
