package com.pama.sitecontents.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.sitecontents.dao.SiteContentsDAO;
import com.pama.sitecontents.vo.SiteContentListVO;
import com.pama.sitecontents.vo.SiteContentVO;

@Service
public class SitecontentsService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(SitecontentsService.class);

    @Autowired
    private SiteContentsDAO siteContentsDAO;

	/**
	 * 게시판 리스트
	 * @param boardSearchVO
	 * @return
	 */
	public SiteContentListVO getSiteContentList(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getSiteContentList' method...");
        }
		SiteContentListVO vo = new SiteContentListVO();

		int totalCount = siteContentsDAO.getListTotalCount(siteContentVO);

		List<SiteContentVO> messageList =  siteContentsDAO.getSiteContentList(siteContentVO);
		vo.setSiteContentList(messageList);
		vo.setTotalCount(totalCount);

		/*TO DO: 셋팅이 안됨 protected int totalCount;
		vo.getMessageSearchVO().setTotalCount(totalCount);*/
		return vo;
	}

	public SiteContentVO getMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		return getMessage(String.valueOf(siteContentVO.getContentId()));
	}

	/**
	 * 관리자/사용자 같은거 사용함
	 * @param messageId
	 * @return
	 */
	public SiteContentVO getMessage(String contentId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'getMessage' method...");
		}

		if (contentId != null) {

			SiteContentVO siteContentVO = siteContentsDAO.getMessage(contentId);

			return siteContentVO;

		} else {
			return null;
		}
	}


	/**
	 * siteContentList 게시글 수정
	 * @param siteContentVO
	 * @return
	 */
	public int modifyMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessage' method...");
		}

		int messageCount = siteContentsDAO.modifyMessage(siteContentVO);

		return messageCount;
	}

	/**
	 * siteContentList 게시글 삭제
	 * @param siteContentVO
	 * @return
	 */
	public int removeSelectMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessage' method...");
		}
		int deleteCount =siteContentsDAO.removeSelectMessage(siteContentVO);
		return deleteCount;

	}

	/**
	 * siteContentList 게시글 쓰기
	 * @param siteContentVO
	 * @return
	 */
	public int insertMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("invoked 'modifyMessage' method...");
		}
		int insertCount = siteContentsDAO.insertMessage(siteContentVO);
		return insertCount;
	}
}