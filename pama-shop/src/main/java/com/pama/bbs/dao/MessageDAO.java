package com.pama.bbs.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.MessageFormVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageStatVO;
import com.pama.bbs.vo.MessageVO;

@Repository
public class MessageDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(MessageDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.MessageDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 메세지 목록에 대한 전체게시물갯수
     * @param messageSearchVO
     * @return
     */
	public int getListTotalCount(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"), messageSearchVO);
	}

	/**
	 * 메세지 목록 조회
	 * @param messageSearchVO
	 * @return
	 */
	public List<MessageVO> getMessageList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageList"), messageSearchVO);
	}

	/**
	 * 메세지 TOP 목록 조회
	 * @param messageSearchVO
	 * @return
	 */
	public List<MessageVO> getMessageTopList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageTopList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageTopList"), messageSearchVO);
	}


	public int getMessageCount(String searchValue) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCount' method...");
        }
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getMessageCount"), searchValue);
	}



	public List<MessageVO> getMessageAllList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAllList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageAllList"), messageSearchVO);
	}

	public List<MessageVO> getMessageBestList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageBestList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageBestList"), messageSearchVO);
	}

	public List<MessageVO> getMessageMainList(String boardId, int row) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageMainList' method...");
		}

		MessageSearchVO messageSearchVO =new MessageSearchVO();

		messageSearchVO.setBoardId(boardId);
		messageSearchVO.setRow(row);

		return sqlSessionTemplate.selectList(getSqlId("getMessageMainList"), messageSearchVO);
	}

	public List<MessageVO> getMessageLevelList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageLevelList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageLevelList"), messageSearchVO);
	}


	public List<MessageVO> getMessageReplyList(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageReplyList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageReplyList"), messageSearchVO);
	}

	public List<MessageVO> getRandomMessages(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getRandomMessage' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getRandomMessages"), messageSearchVO);
	}


	public MessageVO getMessageOne2(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageOne' method...");
        }
        return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageOne2"), messageId);
	}

	public MessageVO getMessageOne(String boardId, String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageOne' method...");
        }

        MessageVO messageVO = new MessageVO();
        messageVO.setBoardId(boardId);
        messageVO.setMessageId(Integer.parseInt(messageId));

        return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageOne"), messageVO);
	}

	public MessageVO getMessageView(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageView' method...");
        }
		return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageView"), messageSearchVO);
	}

	public MessageVO getMessageViewPrev(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageViewPrev' method...");
        }
		return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageViewPrev"), messageSearchVO);
	}

	public MessageVO getMessageViewNext(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageViewNext' method...");
        }
		return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageViewNext"), messageSearchVO);
	}

	public MessageVO getMessageContents(MessageSearchVO messageSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageContents' method...");
        }
		return (MessageVO)sqlSessionTemplate.selectOne(getSqlId("getMessageContents"), messageSearchVO);
	}

	public MessageStatVO getMessageStat(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageStat' method...");
		}
		return (MessageStatVO)sqlSessionTemplate.selectOne(getSqlId("getMessageStat"), messageSearchVO);
	}

	public MessageStatVO getMessageAttachmentStat(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageAttachmentStat' method...");
		}
		return (MessageStatVO)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachmentStat"), messageSearchVO);
	}

	public int insertMessage(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessage' method...");
        }
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertMessage"), messageFormVO);
	}

	public int insertMessageContents(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageContents' method...");
        }
        return (Integer)sqlSessionTemplate.insert(getSqlId("insertMessageContents"), messageFormVO);
	}

	public int updateMessage(MessageVO messageVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessage' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessage"), messageVO);
	}

	public int updateMessageSortTree(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageSortTree' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageSortTree"), messageFormVO);
	}

	public int updateMessageContents(MessageVO messageVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageContents' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageContents"), messageVO);
	}

	public int updateMessageProgressStatus(MessageVO messageVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageProgressStatus' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageProgressStatus"), messageVO);
	}

	public int updateMessageAddViewCount(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageAddViewCount' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageAddViewCount"), messageFormVO);
	}

	public int updateMessageAddReplyCount(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageAddReplyCount' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageAddReplyCount"), messageFormVO);
	}

	public int updateMessageAddCommentCount(MessageFormVO messageFormVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'updateMessageAddCommentCount' method...");
		}
		return sqlSessionTemplate.update(getSqlId("updateMessageAddCommentCount"), messageFormVO);
	}

	public int updateVarFiled1(MessageVO messageVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateVarFiled1' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateVarFiled1"), messageVO);
	}
	public int updateMessageRemove(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'updateMessageRemove' method...");
		}
		return sqlSessionTemplate.update(getSqlId("updateMessageRemove"), messageVO);
	}

	public int updateMessageTagsRemove(MessageVO messageVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageTagsRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateMessageTagsRemove"), messageVO);
	}

	public int deleteMessage(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessage' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteMessage"), messageId);
	}

	public int deleteMessageContents(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageContents' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteMessageContents"), messageId);
	}

	public int deleteSelectMessage(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteSelectMessage' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteSelectMessage"), messageFormVO);
	}

	public int deleteSelectMessageContents(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteSelectMessageContents' method...");
        }
        return sqlSessionTemplate.delete(getSqlId("deleteSelectMessageContents"), messageFormVO);
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
