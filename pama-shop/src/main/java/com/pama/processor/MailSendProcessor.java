package com.pama.processor;

import com.pama.processor.vo.SendMailVO;


/**
 *  메일에 대한 처리
 * @author sycopmac
 */
public interface MailSendProcessor {

    /**
     *
     * @return
     */
    public void sendMail(SendMailVO sendMailVO);
}
