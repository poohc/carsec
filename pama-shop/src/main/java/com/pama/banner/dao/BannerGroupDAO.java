package com.pama.banner.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerGroupVO;
import com.pama.banner.vo.BannerSearchVO;

@Repository
public class BannerGroupDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(BannerGroupDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.banner.dao.BannerGroupDAO";
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;    

	/**
	 * 배너그룹 총 갯수
	 * @param bannerSearchVO
	 * @return
	 */
	public int getListTotalCount(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getListTotalCount' method...");
        }
		return (Integer)sqlSessionTemplate.selectOne(getSqlId("getListTotalCount"), bannerSearchVO);
	}

	/**
	 * 배너 그룹 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerGroupVO> getBannerGroupList(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerGroupList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBannerGroupList"), bannerSearchVO);
	}

	/**
	 * 배너 그룹 정보
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerGroupVO getBannerGroup(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerGroup' method...");
        }
        return (BannerGroupVO)sqlSessionTemplate.selectOne(getSqlId("getBannerGroup"), bannerSearchVO);
	}

	/**
	 * 배너그룹 등록
	 * @param bannerGroupVO
	 * @return
	 */
	public int insertBannerGroup(BannerGroupVO bannerGroupVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertBannerGroup' method...");
        }
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertBannerGroup"), bannerGroupVO);
	}

	/**
	 * 배너그룹 수정
	 * @param bannerGroupVO
	 * @return
	 */
	public int updateBannerGroup(BannerGroupVO bannerGroupVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerGroup' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerGroup"), bannerGroupVO);
	}

	/**
	 * 배너그풉 상태 수정(삭제)
	 * @param bannerGroupVO
	 * @return
	 */
	public int updateBannerGroupRemove(BannerGroupVO bannerGroupVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerGroupRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerGroupRemove"), bannerGroupVO);
	}

	/**
	 * 배너그룹 일괄 상태 수정(삭제)
	 * @param bannerFormVO
	 * @return
	 */
	public int updateSelectBannerGroupRemove(BannerFormVO bannerFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateSelectBannerGroupRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateSelectBannerGroupRemove"), bannerFormVO);
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
