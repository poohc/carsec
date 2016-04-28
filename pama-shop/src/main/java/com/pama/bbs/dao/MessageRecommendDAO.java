package com.pama.bbs.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.MessageRecommendVO;

@Repository
public class MessageRecommendDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageRecommendDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.MessageRecommendDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public MessageRecommendVO getMessageRecommendRegisterId(int messageId, String registerId) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'getMessageRecommendRegisterId' method...");
    	}
    	MessageRecommendVO messageRecommendVO = new MessageRecommendVO();
    	messageRecommendVO.setMessageId(messageId);
    	messageRecommendVO.setRegisterId(registerId);

    	return sqlSessionTemplate.selectOne(getSqlId("getMessageRecommendRegisterId"), messageRecommendVO);
    }

    public int insertMessageRecommend(MessageRecommendVO messageRecommendVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageRecommend' method...");
        }
        return sqlSessionTemplate.insert(getSqlId("insertMessageRecommend"), messageRecommendVO);
    }

    /**
     * SqlMap Namespace를 생성한다.
     * @param methodName
     * @return
     */
    private String getSqlId(String methodName) {
        return SQLMAP_NAMESPACE + "." + methodName;
    }
}
