package com.pama.bbs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.bbs.dao.BoardDAO;
import com.pama.bbs.dao.MessageAttachmentDAO;
import com.pama.bbs.dao.MessageDAO;
import com.pama.bbs.vo.BoardVO;
import com.pama.bbs.vo.MessageAttachmentVO;
import com.pama.bbs.vo.MessageFormVO;
import com.pama.bbs.vo.MessageListVO;
import com.pama.bbs.vo.MessageSearchVO;
import com.pama.bbs.vo.MessageStatVO;
import com.pama.bbs.vo.MessageVO;
import com.pama.bbs.vo.MessageVarFiledsVO;
import com.pama.common.Constants;
import com.pama.common.util.ConvertUtil;
import com.pama.common.util.StringUtil;
import com.pama.processor.AttachmentProcessor;
import com.pama.processor.vo.AttachmentVO;

@Service
public class MessageService {

	/**
	 * Log 객체를 생성한다.
	 */
	private static final Log LOG = LogFactory.getLog(MessageService.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private MessageAttachmentDAO messageAttachmentDAO;

	@Autowired
	private AttachmentProcessor attachmentProcessor;


	public int getMessageCount(String searchValue) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageCount' method...");
		}

		return messageDAO.getMessageCount(searchValue);
	}

	/**
	 * 메세지 페이징 정보
	 * @param messageSearchVO
	 * @return
	 */
	public MessageListVO getMessageList(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageList' method...");
		}

		MessageListVO messageListVO = new MessageListVO();

		/* 최상단 메세지 플래그 */
		if ("1".equals(messageSearchVO.getTopMessageFlag())) {
			List<MessageVO> messageTopList = messageDAO.getMessageTopList(messageSearchVO);
			messageListVO.setMessageTopList(messageTopList);
		}

		int totalCount = messageDAO.getListTotalCount(messageSearchVO);
		List<MessageVO> messageList = messageDAO.getMessageList(messageSearchVO);
		List<MessageVO> messageList2 = new ArrayList<MessageVO>();
		for (MessageVO messageVO : messageList) {

			String varFileds = messageVO.getVarFileds();
			if(StringUtils.isNotEmpty(varFileds)){
				try {
					//TODO : tag말고 쓴는 방법을 확인하자.
					ObjectMapper objectMapper = new ObjectMapper();
					MessageVarFiledsVO messageVarFiledsVO = objectMapper.readValue(varFileds, MessageVarFiledsVO.class);
					messageVO.setMessageVarFiledsVO(messageVarFiledsVO);
				} catch (Exception e) {
					LOG.error("JSON ERROR" + e.getMessage());
				}
			}

			messageList2.add(messageVO);
		}

		messageListVO.setMessageList(messageList);
		messageListVO.setMessageSearchVO(messageSearchVO);
		messageListVO.getMessageSearchVO().setTotalCount(totalCount);

		return messageListVO;
	}


	public MessageListVO getMessageAllList(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageAllList' method...");
		}

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageAllList(messageSearchVO));

		return messageListVO;
	}


	public MessageListVO getMessageSearchList(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageSearchList' method...");
		}

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageList(messageSearchVO));

		return messageListVO;
	}

	public List<MessageVO> getMessageMainList(String boardKey, int row) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageMainList' method...");
		}

		BoardVO boardVO = boardService.getBoard(boardKey);

		return messageDAO.getMessageMainList(String.valueOf(boardVO.getBoardId()), row);

	}

	public MessageListVO getMessageBestList(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageBestList' method...");
		}

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageBestList(messageSearchVO));

		return messageListVO;

	}

	public MessageListVO getMessageLevelList(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageLevelList' method...");
		}

		MessageListVO messageListVO = new MessageListVO();
		messageListVO.setMessageList(messageDAO.getMessageLevelList(messageSearchVO));

		return messageListVO;

	}


	public List<MessageVO> getRandomMessages(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getRandomMessage' method...");
		}

		BoardVO boardVO = boardService.getBoard(messageSearchVO.getBoardKey());

		messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));

		return messageDAO.getRandomMessages(messageSearchVO);
	}


	public MessageVO getMessageOne(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		return getMessageOne(messageSearchVO.getBoardId(), messageSearchVO.getMessageId());
	}

	/**
	 * 관리자/사용자 같은거 사용함
	 * @param messageId
	 * @return
	 */
	public MessageVO getMessageOne(String boardId, String messageId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		if (messageId != null) {

			MessageVO messageVO = messageDAO.getMessageOne(boardId, messageId);


			String varFileds = messageVO.getVarFileds();
			if(StringUtils.isNotEmpty(varFileds)){
				try {
					//TODO : tag말고 쓴는 방법을 확인하자.
					ObjectMapper objectMapper = new ObjectMapper();
					MessageVarFiledsVO messageVarFiledsVO = objectMapper.readValue(varFileds, MessageVarFiledsVO.class);
					messageVO.setMessageVarFiledsVO(messageVarFiledsVO);
				} catch (Exception e) {
					LOG.error("JSON ERROR" + e.getMessage());
				}
			}






			//첨부 조회
			List<MessageAttachmentVO> messageAttachmentVOs =  messageAttachmentDAO.getMessageAttachments(messageId);

			MessageAttachmentVO[] messageAttachmentVOShowIndex=new MessageAttachmentVO[9];

			for (MessageAttachmentVO messageAttachmentVO : messageAttachmentVOs) {

				if(messageAttachmentVO.getShowIndex()>0){
					messageAttachmentVOShowIndex[messageAttachmentVO.getShowIndex()]=messageAttachmentVO;
				}
			}

			if( messageAttachmentVOs.size() > 0){
				messageVO.setAttachmentList(messageAttachmentVOs);
				int messageAttachmentVOsSize = messageAttachmentVOs.size();
				messageVO.setLastAttachment(messageAttachmentVOs.get(messageAttachmentVOsSize-1));
				messageVO.setFirstAttachment(messageAttachmentVOs.get(0));
			}
			return messageVO;

		} else {
			return null;
		}
	}

	/**
	 * 관리자/사용자 같은거 사용함
	 * @param messageId
	 * @return
	 */
	public MessageVO getMessageOne2(String messageId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		if (messageId != null) {

			MessageVO messageVO = messageDAO.getMessageOne2(messageId);

			return messageVO;

		} else {
			return null;
		}
	}


	public MessageVO getMessageViewPrev(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageViewPrev' method...");
		}

		if (messageSearchVO.getMessageId() != null) {
			MessageVO messageVO = messageDAO.getMessageViewPrev(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}


	public MessageVO getMessageViewNext(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageViewNext' method...");
		}

		if (messageSearchVO.getMessageId() != null) {
			MessageVO messageVO = messageDAO.getMessageViewNext(messageSearchVO);
			return messageVO;
		} else {
			return null;
		}
	}


	public int addMessage(MessageFormVO messageFormVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'addMessage' method...");
		}


		//요약정보
		if (StringUtils.isEmpty(messageFormVO.getSummaryContents())) {


			String contents = "";

			if(StringUtils.isNotEmpty(messageFormVO.getContents())){//contents Param없을경우 대비
				contents = StringUtil.removeTag(messageFormVO.getContents());
			}

			if (contents.length() > 500) {
				messageFormVO.setSummaryContents(contents.substring(0, 500));
			} else {
				messageFormVO.setSummaryContents(contents);
			}
		}

		// 게시여부
		if (messageFormVO.getStatusType()==null || "".equals(messageFormVO.getStatusType())){
			messageFormVO.setStatusType(Constants.CONTENTS_STATUS_WAIT); // 대기
		}

		int insertMessageSuccess = messageDAO.insertMessage(messageFormVO);

		if (insertMessageSuccess != 0) {

			//messageVO.setMessageId(messageKey);

			String sortTree = ConvertUtil.getSortTree(messageFormVO.getSortTree(), Integer.valueOf(messageFormVO.getMessageId()));

			messageFormVO.setMessageLevel(String.valueOf((sortTree.length()-1) / 5)); //레벨계산

			messageFormVO.setSortTree(sortTree);

			// 정렬 코드 저장
			messageDAO.updateMessageSortTree(messageFormVO);

			// 내용을 저장
			messageDAO.insertMessageContents(messageFormVO);

			// 첨부파일 저장
			if  (messageFormVO.getAttachmentList() != null) {
				for (MessageAttachmentVO messageAttachmentVO : messageFormVO.getAttachmentList()) {
					messageAttachmentVO.setMessageId(String.valueOf(messageFormVO.getMessageId()));
					messageAttachmentDAO.insertMessageAttachment(messageAttachmentVO);
				}
			}

			if (!StringUtils.isEmpty(messageFormVO.getParentMessageId()) && !"0".equals(messageFormVO.getParentMessageId())) {
				messageDAO.updateMessageAddReplyCount(messageFormVO); // 답변수 증가
			}
		}
		return Integer.valueOf(messageFormVO.getMessageId());
	}


	public int modifyMessage(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessage' method...");
		}

		int messageCount = 0;

		if (StringUtils.isEmpty(messageVO.getSummaryContents())) {
			if(StringUtils.isNotEmpty(messageVO.getContents())){

				String contents = StringUtil.removeTag(messageVO.getContents());
				if (contents.length() > 500) {
					messageVO.setSummaryContents(contents.substring(0, 500));
				} else {
					messageVO.setSummaryContents(contents);
				}
			}
		}
		// 게시여부
		if (StringUtils.equals(messageVO.getStatusType(), Constants.CONTENTS_STATUS_WAIT)
				|| StringUtils.equals(messageVO.getStatusType(), Constants.CONTENTS_STATUS_ON)
				){

		}else{
			messageVO.setStatusType(null);
		}


		messageCount = messageDAO.updateMessage(messageVO);

		if (messageCount != 0) {
			messageDAO.updateMessageContents(messageVO);

			if (messageVO.getAttachmentList()!=null) {
				for (MessageAttachmentVO messageAttachmentVO : messageVO.getAttachmentList()) {

					if(messageAttachmentVO.getShowIndex() > 0){

						//편의상 잘못올라간 showindex가 중복이 될 경우에는 삭제한다.
						List<MessageAttachmentVO> messageAttachmentVOs = messageAttachmentDAO.getMessageAttachmentShowIndex(String.valueOf(messageVO.getMessageId()),  messageAttachmentVO.getShowIndex());

						for (MessageAttachmentVO messageAttachmentVO2 : messageAttachmentVOs) {
							messageAttachmentDAO.deleteMessageAttachment(messageAttachmentVO2.getAttachmentId());

							try {
								attachmentProcessor.removeFile(Constants.SERVICE_ID_BBS, messageAttachmentVO2.getFileName());
							} catch (IOException e) { LOG.error("[FILE Delete Error] " + e.getMessage()); }
						}

					}

					messageAttachmentVO.setMessageId(String.valueOf(messageVO.getMessageId()));
					messageAttachmentDAO.insertMessageAttachment(messageAttachmentVO);




				}
			}
		}

		return messageCount;
	}


	public int modifyMessageAddViewCount(MessageFormVO messageFormVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessageAddViewCount' method...");
		}
		return messageDAO.updateMessageAddViewCount(messageFormVO);
	}

	public int modifyVarFiled1(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyVarFiled1' method...");
		}

		return messageDAO.updateVarFiled1(messageVO);
	}


	public int modifyMessageStatus(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessageStatus' method...");
		}

		return messageDAO.updateMessageRemove(messageVO);
	}


	public int modifyMessageTags(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessageTags' method...");
		}

		return messageDAO.updateMessageTagsRemove(messageVO);
	}


	public int removeMessage(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'removeMessage' method...");
		}

		return messageDAO.updateMessageRemove(messageVO);
	}


	public int removeAllMessage(MessageVO messageVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'removeAllMessage' method...");
		}

		int messageCount = 0;

		messageCount = messageAttachmentDAO.deleteMessageAttachmentMessageId(String.valueOf(messageVO.getMessageId()));

		messageCount = messageDAO.deleteMessageContents(String.valueOf(messageVO.getMessageId()));

		messageCount = messageDAO.deleteMessage(String.valueOf(messageVO.getMessageId()));

		return messageCount;
	}


	public int removeSelectMessage(MessageFormVO messageFormVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'removeSelectMessage' method...");
		}

		int messageCount = 0;

		messageCount = messageAttachmentDAO.deleteSelectMessageAttachment(messageFormVO);

		messageCount = messageDAO.deleteSelectMessageContents(messageFormVO);

		messageCount = messageDAO.deleteSelectMessage(messageFormVO);

		return messageCount;
	}


	public int removeMessageAttachment(String fileName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'removeMessageAttachment' method...");
		}

		int messageCount = 0;
		messageCount = messageAttachmentDAO.deleteNameMessageAttachment(fileName);

		return messageCount;
	}


	public MessageAttachmentVO getMessageAttachmentoVO(AttachmentVO attachmentVO, String boardId) {

		MessageAttachmentVO messageAttachmentVO = new MessageAttachmentVO();
		messageAttachmentVO.setBoardId(boardId);
		messageAttachmentVO.setDisplayName(attachmentVO.getOriginalFilename());
		messageAttachmentVO.setFileName(attachmentVO.getFileName());
		messageAttachmentVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
		messageAttachmentVO.setFilePath(attachmentVO.getFilePath());
		messageAttachmentVO.setContentType(attachmentVO.getContentType());
		if (attachmentVO.getContentType().indexOf("image") >= 0) {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
			messageAttachmentVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
			messageAttachmentVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
		} else {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
		}

		return messageAttachmentVO;
	}

	public MessageAttachmentVO getShowIndexMessageAttachmentoVO(AttachmentVO attachmentVO, String boardId, int showIndex) {

		MessageAttachmentVO messageAttachmentVO = new MessageAttachmentVO();
		messageAttachmentVO.setBoardId(boardId);
		messageAttachmentVO.setDisplayName(attachmentVO.getOriginalFilename());
		messageAttachmentVO.setFileName(attachmentVO.getFileName());
		messageAttachmentVO.setFileSize(String.valueOf(attachmentVO.getFileSize()));
		messageAttachmentVO.setFilePath(attachmentVO.getFilePath());
		messageAttachmentVO.setContentType(attachmentVO.getContentType());
		messageAttachmentVO.setShowIndex(showIndex);
		if (attachmentVO.getContentType().indexOf("image") >= 0) {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_IMG));
			messageAttachmentVO.setImageHeight(String.valueOf(attachmentVO.getImageHeight()));
			messageAttachmentVO.setImageWidth(String.valueOf(attachmentVO.getImageWidth()));
		} else {
			messageAttachmentVO.setFileType(String.valueOf(Constants.FILE_TYPE_PDS));
		}

		return messageAttachmentVO;
	}


	public MessageVO getMessageLicenseAttachment(int boardId, String fileName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		MessageAttachmentVO messageAttachmentVO = messageAttachmentDAO.getMessageAttachmentFileName(fileName);
		String messageId = messageAttachmentVO.getMessageId();
		MessageVO messageVO = messageDAO.getMessageOne(String.valueOf(boardId), messageId);
		messageVO.setDownloadAttachment(messageAttachmentVO);

		return messageVO;
	}

	public MessageStatVO getMessageStat(MessageSearchVO messageSearchVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessageStat' method...");
		}

		MessageStatVO messageStatVO = new MessageStatVO();

		MessageStatVO messageStatVO1 = messageDAO.getMessageStat(messageSearchVO);
		if(messageStatVO1 != null){
			messageStatVO.setMessageCount(messageStatVO1.getMessageCount());
			messageStatVO.setMessageRank(messageStatVO1.getMessageRank());
		}

		MessageStatVO messageStatVO2 = messageDAO.getMessageAttachmentStat(messageSearchVO);
		if(messageStatVO2 != null){
			messageStatVO.setAttachDownloadCount(messageStatVO2.getAttachDownloadCount());
			messageStatVO.setAttachDownloadRank(messageStatVO2.getAttachDownloadRank());
		}

		return messageStatVO;
	}


	public MessageVO addMessageAttachmentDownload(int boardId, String fileName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		MessageAttachmentVO messageAttachmentVO = messageAttachmentDAO.getMessageAttachmentFileName(fileName);
		String messageId = messageAttachmentVO.getMessageId();
		MessageVO messageVO = messageDAO.getMessageOne(String.valueOf(boardId), messageId);
		messageVO.setDownloadAttachment(messageAttachmentVO);

		return messageVO;
	}

	public int modifyMessageAttachmentDownload(String fileName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		int resultCnt = messageAttachmentDAO.updateAddMessageAttachmentDownload(fileName);

		return resultCnt;
	}

}
