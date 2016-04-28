package com.pama.bbs.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.MessageCategorySearchVO;
import com.pama.bbs.vo.MessageCategoryVO;

@Repository
public class MessageCategoryDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageCategoryDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.MessageCategoryDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int getListTotalCount(MessageCategorySearchVO messageCategorySearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"),messageCategorySearchVO);
    }

    public List<MessageCategoryVO> getMessageCategoryList(String boardId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategoryList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getMessageCategoryList"), boardId);
    }

    public MessageCategoryVO getMessageCategory(String messageCategoryId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategory' method...");
        }
        return (MessageCategoryVO)sqlSessionTemplate.selectOne(getSqlId("getMessageCategory"), messageCategoryId);
    }

    public int insertMessageCategory(MessageCategoryVO messageCategoryVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageCategory' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertMessageCategory"), messageCategoryVO);
    }

    public int updateMessageCategory(MessageCategoryVO messageCategoryVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageCategory' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageCategory"), messageCategoryVO);
    }

    public int updateMessageCategorySortTree(MessageCategoryVO messageCategoryVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageCategorySortTree' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageCategorySortTree"), messageCategoryVO);
    }

    public int updateCategoryIdFirst(String messageCategoryId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateCategoryIdFirst' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateCategoryIdFirst"), messageCategoryId);
    }

    public int deleteMessageCategory(String messageCategoryId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageCategory' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteMessageCategory"), messageCategoryId);
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
