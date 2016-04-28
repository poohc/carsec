package com.pama.bbs.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.MessageCommentFormVO;
import com.pama.bbs.vo.MessageCommentSearchVO;
import com.pama.bbs.vo.MessageCommentVO;

@Repository
public class MessageCommentDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageCommentDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.MessageCommentDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int getListTotalCount(MessageCommentSearchVO messageCommentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"), messageCommentSearchVO);
    }

    public int getMessageCommentRegisterIdCount(MessageCommentSearchVO messageCommentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCommentRegisterIdCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getMessageCommentRegisterIdCount"), messageCommentSearchVO);
    }

    public List<MessageCommentVO> getMessageCommentList(MessageCommentSearchVO messageCommentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCommentList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getMessageCommentList"), messageCommentSearchVO);
    }

    public List<MessageCommentVO> getMessageCommentEventList(MessageCommentSearchVO messageCommentSearchVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'getMessageCommentEventList' method...");
    	}
    	return sqlSessionTemplate.selectList(getSqlId("getMessageCommentEventList"), messageCommentSearchVO);
    }

    public int insertMessageComment(MessageCommentFormVO messageCommentFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageComment' method...");
        }
        return sqlSessionTemplate.insert(getSqlId("insertMessageComment"), messageCommentFormVO);
    }

    public int updateMessageCommentSortTree(MessageCommentFormVO messageCommentFormVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'updateMessageCommentSortTree' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("updateMessageCommentSortTree"), messageCommentFormVO);
    }

    public List<MessageCommentVO> getMessageCommentEventList(MessageCommentFormVO messageCommentFormVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'getMessageCommentEventList' method...");
    	}
    	return sqlSessionTemplate.selectList(getSqlId("getMessageCommentEventList"), messageCommentFormVO);
    }

    public int updateMessageCommentRecommendCount(MessageCommentFormVO messageCommentFormVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'updateMessageCommentRecommendCount' method...");
    	}
    	return sqlSessionTemplate.insert(getSqlId("updateMessageCommentRecommendCount"), messageCommentFormVO);
    }

    public int deleteComment(MessageCommentFormVO messageCommentFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteComment' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteComment"), messageCommentFormVO);
    }

    public int deleteSelectComment(MessageCommentFormVO messageCommentFormVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'deleteComment' method...");
    	}
    	return sqlSessionTemplate.delete(getSqlId("deleteSelectComment"), messageCommentFormVO);
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
