package com.pama.bbs.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.bbs.dao.MessageCategoryDAO;
import com.pama.bbs.vo.MessageCategoryListVO;
import com.pama.bbs.vo.MessageCategorySearchVO;
import com.pama.bbs.vo.MessageCategoryVO;
import com.pama.common.util.ConvertUtil;

@Service
public class MessageCategoryService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(MessageCategoryService.class);

	@Autowired
	private MessageCategoryDAO messageCategoryDAO;

	public MessageCategoryListVO getMessageCategoryList(
			MessageCategorySearchVO messageCategorySearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategoryList' method...");
        }

		int messageCategoryTotalCount = messageCategoryDAO.getListTotalCount(messageCategorySearchVO);

		MessageCategoryListVO messageCategoryListVO = new MessageCategoryListVO();

		List<MessageCategoryVO> messageCategoryList = messageCategoryDAO.getMessageCategoryList(messageCategorySearchVO.getBoardId());

		messageCategoryListVO.setMessageCategoryList(messageCategoryList);
		messageCategoryListVO.setMessageCategorySearchVO(messageCategorySearchVO);
		messageCategoryListVO.getMessageCategorySearchVO().setTotalCount(messageCategoryTotalCount);

		return messageCategoryListVO;
	}

	public List<MessageCategoryVO> getMessageCategorySelectList(String boardId) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategorySelectList' method...");
        }

		return messageCategoryDAO.getMessageCategoryList(boardId);

	}

	public MessageCategoryVO getMessageCategory(
			MessageCategoryVO messageCateaoryVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategory' method...");
        }

		return messageCategoryDAO.getMessageCategory(messageCateaoryVO.getMessageCategoryId());
	}

	public int addMessageCategory(MessageCategoryVO messageCategoryVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addMessageCategory' method...");
        }

		int categoryKey = messageCategoryDAO.insertMessageCategory(messageCategoryVO);

		messageCategoryVO.setMessageCategoryId(String.valueOf(categoryKey));

		String level = ConvertUtil.getSortTree(messageCategoryVO.getSortTree(), categoryKey);

		messageCategoryVO.setMessageCategoryLevel(String.valueOf((level.length()-1) / 5)); //레벨계산

		messageCategoryVO.setSortTree(level);

		messageCategoryDAO.updateMessageCategorySortTree(messageCategoryVO);

		return categoryKey;
	}

	public int modifyMessageCategory(MessageCategoryVO messageCategoryVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyMessageCategory' method...");
        }
		return messageCategoryDAO.updateMessageCategory(messageCategoryVO);
	}

	public int modifyMessageCategoryStatus(MessageCategoryVO messageCategoryVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategory' method...");
        }
		return 0;
	}

	public int removeMessageCategory(MessageCategoryVO messageCategoryVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageCategory' method...");
        }
		return messageCategoryDAO.deleteMessageCategory(messageCategoryVO.getMessageCategoryId());
	}

}
