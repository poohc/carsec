package com.pama.bbs.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.dao.MessageCommentDAO;
import com.pama.bbs.dao.MessageDAO;
import com.pama.bbs.dao.MessageRecommendDAO;
import com.pama.bbs.vo.MessageCommentFormVO;
import com.pama.bbs.vo.MessageCommentListVO;
import com.pama.bbs.vo.MessageCommentSearchVO;
import com.pama.bbs.vo.MessageCommentVO;
import com.pama.bbs.vo.MessageFormVO;
import com.pama.bbs.vo.MessageRecommendVO;
import com.pama.common.util.ConvertUtil;

@Repository
public class MessageCommentService {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageCommentService.class);


    @Autowired
    private MessageCommentDAO messageCommentDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private MessageRecommendDAO messageRecommendDAO;

    public MessageCommentListVO getMessageCommentList(MessageCommentSearchVO messageCommentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCommentList' method...");
        }

        int totalCount = messageCommentDAO.getListTotalCount(messageCommentSearchVO);
        List<MessageCommentVO> messageCommentList = messageCommentDAO.getMessageCommentList(messageCommentSearchVO);

        MessageCommentListVO messageCommentListVO = new MessageCommentListVO();

        messageCommentListVO.setMessageCommentList(messageCommentList);
        messageCommentListVO.setMessageCommentSearchVO(messageCommentSearchVO);
        messageCommentListVO.getMessageCommentSearchVO().setTotalCount(totalCount);

		return messageCommentListVO;

    }

    public int getMessageCommentRegisterIdCount(MessageCommentSearchVO messageCommentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCommentRegisterIdCount' method...");
        }

        int totalCount = messageCommentDAO.getMessageCommentRegisterIdCount(messageCommentSearchVO);


		return totalCount;

    }

    public MessageCommentListVO getMessageCommentEventList(MessageCommentSearchVO messageCommentSearchVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'getMessageCommentList' method...");
    	}
        List<MessageCommentVO> messageCommentList = messageCommentDAO.getMessageCommentEventList(messageCommentSearchVO);

        MessageCommentListVO messageCommentListVO = new MessageCommentListVO();

        messageCommentListVO.setMessageCommentList(messageCommentList);
        messageCommentListVO.setMessageCommentSearchVO(messageCommentSearchVO);

		return messageCommentListVO;

    }

    public int insertMessageComment(MessageCommentFormVO messageCommentFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageComment' method...");
        }


        int row = 0;

        row += messageCommentDAO.insertMessageComment(messageCommentFormVO);

        if( row > 0 ){
        	String sortTree = ConvertUtil.getSortTree(messageCommentFormVO.getSortTree(), Integer.valueOf(messageCommentFormVO.getCommentId()));

        	messageCommentFormVO.setSortTree(sortTree);
        	messageCommentDAO.updateMessageCommentSortTree(messageCommentFormVO);

        }

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageId(messageCommentFormVO.getMessageId());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);

        return row;
    }

    public int updateMessageCommentRecommendCount(MessageCommentFormVO messageCommentFormVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'insertMessageComment' method...");
    	}

    	int row = 0;

    	MessageRecommendVO messageRecommendVO = messageRecommendDAO.getMessageRecommendRegisterId( Integer.parseInt( messageCommentFormVO.getMessageId() ) , messageCommentFormVO.getRegisterId());
    	if( messageRecommendVO==null ){
    		messageRecommendVO = new MessageRecommendVO();
    		messageRecommendVO.setMessageId(Integer.parseInt(messageCommentFormVO.getMessageId()));
    		messageRecommendVO.setRegisterId(messageCommentFormVO.getRegisterId());
    		row += messageRecommendDAO.insertMessageRecommend(messageRecommendVO);
    		row += messageCommentDAO.updateMessageCommentRecommendCount(messageCommentFormVO);
    	}else{
    		row = -2;
    	}


    	return row;
    }

    public int deleteComment(MessageCommentFormVO messageCommentFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteComment' method...");
        }

        int row = 0;
        row += messageCommentDAO.deleteComment(messageCommentFormVO);

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageId(messageCommentFormVO.getMessageId());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);
        return row;
    }

    public int deleteSelectComment(MessageCommentFormVO messageCommentFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteSelectComment' method...");
        }
        int row = 0;
        row += messageCommentDAO.deleteSelectComment(messageCommentFormVO);

        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageId(messageCommentFormVO.getMessageId());
        row += messageDAO.updateMessageAddCommentCount(messageFormVO);
        return row;
    }

}
