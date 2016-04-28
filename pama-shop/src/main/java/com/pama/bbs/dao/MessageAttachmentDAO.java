package com.pama.bbs.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.bbs.vo.MessageAttachmentSearchVO;
import com.pama.bbs.vo.MessageAttachmentVO;
import com.pama.bbs.vo.MessageFormVO;

@Repository
public class MessageAttachmentDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(MessageAttachmentDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.bbs.dao.MessageAttachmentDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 파일 갯수
	 * @param messageId
	 * @return
	 */
	public int getMessageAttachmentListTotalConut(
			MessageAttachmentSearchVO messageAttachmentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachmentListTotalConut' method...");
        }
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachmentListTotalConut"),messageAttachmentSearchVO);
	}

	/**
	 * 파일 정보 리스트
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public List<MessageAttachmentVO> getMessageAttachmentList(
			MessageAttachmentSearchVO messageAttachmentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachmentList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageAttachmentList"), messageAttachmentSearchVO);
	}

	/**
	 * 파일 정보 리스트
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public List<MessageAttachmentVO> getMessageAttachmentShowIndex(String messageId, int showIndex) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageAttachmentShowIndex' method...");
		}

		MessageAttachmentSearchVO messageAttachmentSearchVO = new MessageAttachmentSearchVO();
		messageAttachmentSearchVO.setMessageId(messageId);
		messageAttachmentSearchVO.setShowIndex(showIndex);
		return sqlSessionTemplate.selectList(getSqlId("getMessageAttachmentShowIndex"), messageAttachmentSearchVO);
	}

	/**
	 * 파일 상세 정보(게시물포함정보)
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public int getMessageAttachmentCnt(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachmentCnt' method...");
        }
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachmentCnt"),messageId);
	}

	/**
	 * 파일 상세정보
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public MessageAttachmentVO getMessageAttachment(String attachmentId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachment' method...");
        }
		return (MessageAttachmentVO)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachment"), attachmentId);
	}

	/**
	 * 게시물에 따른 파일 리스트
	 * @param messageId
	 * @return
	 */
	public MessageAttachmentVO getMessageAttachment2(String attachmentId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachment2' method...");
        }
		return (MessageAttachmentVO)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachment2"), attachmentId);
	}

	/**
	 * 파일명으로 파일정보가져오기
	 * @param messageId
	 * @return
	 */
	public MessageAttachmentVO getMessageAttachmentFileName(String fileName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageAttachmentFileName' method...");
		}
		return (MessageAttachmentVO)sqlSessionTemplate.selectOne(getSqlId("getMessageAttachmentFileName"), fileName);
	}

	/**
	 * 파일 정보 수정
	 * @param messageAttachmentVO
	 * @return
	 */
	public int updateAddMessageAttachmentDownload(String fileName) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateAddMessageAttachmentDownload' method...");
        }
		return sqlSessionTemplate.update(getSqlId("updateAddMessageAttachmentDownload"), fileName);
	}

	/**
	 * 파일 검색 타입 리스트
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public List<MessageAttachmentVO> getMessageAttachments(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachments' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getMessageAttachments"), messageId);
	}

	/**
	 * 최근 Type 파일 리스트
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public List<MessageAttachmentVO> getMessageAttachmentTypesList(
			MessageAttachmentSearchVO messageAttachmentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachmentTypesList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageAttachmentTypesList"), messageAttachmentSearchVO);
	}

	/**
	 * 최근 파일 리스트
	 * @param messageAttachmentSearchVO
	 * @return
	 */
	public List<MessageAttachmentVO> getMessageAttachmentLately(
			MessageAttachmentSearchVO messageAttachmentSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessageAttachmentLately' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getMessageAttachmentLately"), messageAttachmentSearchVO);
	}

	/**
	 * 파일 정보 저장
	 * @param messageAttachmentVO
	 * @return
	 */
	public int insertMessageAttachment(MessageAttachmentVO messageAttachmentVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessageAttachment' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertMessageAttachment"), messageAttachmentVO);
		return 1;
	}

	/**
	 * 파일 정보 수정
	 * @param messageAttachmentVO
	 * @return
	 */
	public int updateMessageAttachment(MessageAttachmentVO messageAttachmentVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateMessageAttachment' method...");
        }
		return sqlSessionTemplate.update(getSqlId("updateBoard"), messageAttachmentVO);
	}

	/**
	 * 파일 정보 삭제(DB 완전 삭제)
	 * @param attachmentId
	 * @return
	 */
	public int deleteMessageAttachment(String attachmentId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageAttachment' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("deleteMessageAttachment"), attachmentId);
	}

	/**
	 * 파일명으로 검색하여 삭제
	 * @param fileName
	 * @return
	 */
	public int deleteNameMessageAttachment(String fileName) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteNameMessageAttachment' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("deleteNameMessageAttachment"), fileName);
	}


	/**
	 * 게시물기준으로 모든 관련 파일 삭제
	 * @param messageId
	 * @return
	 */
	public int deleteMessageAttachmentMessageId(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageAttachmentMessageId' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("deleteMessageAttachmentMessageId"), messageId);
	}

	/**
	 * 게시물 일괄 삭제 기준으로 모든 파일 삭제
	 * @param messageFormVO
	 * @return
	 */
	public int deleteSelectMessageAttachment(MessageFormVO messageFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageAttachmentMessageId' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("deleteSelectMessageAttachment"), messageFormVO);
	}

	/**
	 * 파일 타입정보로 삭제
	 * @param messageAttachmentVO
	 * @return
	 */
	public int deleteMessageAttachmentFileTypes(
			MessageAttachmentVO messageAttachmentVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'deleteMessageAttachmentFileTypes' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("deleteMessageAttachmentFileTypes"), messageAttachmentVO);
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
