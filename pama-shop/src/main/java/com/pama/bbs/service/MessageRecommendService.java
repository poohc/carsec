package com.pama.bbs.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.dao.MessageRecommendDAO;
import com.pama.bbs.vo.MessageRecommendVO;

@Repository
public class MessageRecommendService {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageRecommendService.class);

    @Autowired
    private MessageRecommendDAO messageRecommendDAO;


    public MessageRecommendVO getMessageRecommendRegisterId(int messageId, String registerId) {
    	MessageRecommendVO messageRecommendVO = messageRecommendDAO.getMessageRecommendRegisterId(messageId, registerId);

    	return messageRecommendVO;
    }



}
