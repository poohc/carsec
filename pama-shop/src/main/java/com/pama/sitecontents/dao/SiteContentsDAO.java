package com.pama.sitecontents.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.sitecontents.vo.SiteContentVO;

@Repository
public class SiteContentsDAO {

	 /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(SiteContentsDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.sitecontents.dao.SiteContentsDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public int getListTotalCount(SiteContentVO siteContentVO){
    	if (LOG.isDebugEnabled()){
    		LOG.debug("invoked 'getTotalCount' method...");
    	}
    	System.out.println("==============TotalCount"+sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"), siteContentVO));
    	return sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"), siteContentVO);
    }


	/**
	 * siteContentList 게시글List 가져오기
	 * @param siteContentVO
	 * @return
	 */
	public List<SiteContentVO> getSiteContentList(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getSiteContentList' method...");
        }
		return  sqlSessionTemplate.selectList(getSqlId("getSiteContentList"), siteContentVO);
	}

	/**
	 * siteContentList 게시글 자세히 보기
	 * @param messageId
	 * @return
	 */
	public SiteContentVO getMessage(String messageId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getMessage' method...");
        }
        return (SiteContentVO)sqlSessionTemplate.selectOne(getSqlId("getMessage"), messageId);
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
		return sqlSessionTemplate.update(getSqlId("modifyMessage"), siteContentVO);
	}

	/**
	 * siteContentList 게시글 삭제
	 * @param siteContentVO
	 * @return
	 */
	public int removeSelectMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeSelectMessage' method...");
        }
		return sqlSessionTemplate.delete(getSqlId("removeSelectMessage"), siteContentVO);
	}

	 /**
     * SqlMap Namespace를 생성한다.
     * @param methodName
     * @return
     */


	/**
	 * siteContentList 게시글 쓰기
	 * @param siteContentVO
	 * @return
	 */
	public int insertMessage(SiteContentVO siteContentVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertMessage' method...");
        }
		return sqlSessionTemplate.insert(getSqlId("insertMessage"), siteContentVO);
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
