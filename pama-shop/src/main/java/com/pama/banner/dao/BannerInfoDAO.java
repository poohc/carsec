package com.pama.banner.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerInfoVO;
import com.pama.banner.vo.BannerSearchVO;

@Repository
public class BannerInfoDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(BannerInfoDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.banner.dao.BannerInfoDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 배너 총 갯수
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
	 * 배너 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerInfoVO> getBannerInfoList(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerInfoList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBannerInfoList"), bannerSearchVO);
	}

	/**
	 * 배너그룹에따란 배너 리슽트
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerInfoVO> getBannerGroupInfoList(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerGroupInfoList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBannerGroupInfoList"), bannerSearchVO);
	}

	/**
	 * 배너 정보
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerInfoVO getBannerInfo(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerInfo' method...");
        }
        return (BannerInfoVO)sqlSessionTemplate.selectOne(getSqlId("getBannerInfo"), bannerSearchVO);
	}

	/**
	 * 배너 정보(노출 API)
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerInfoVO> getBanners(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBanners' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getBanners"), bannerSearchVO);
	}

	/**
	 * 배너 정보(노출 API)
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerInfoVO getBanner(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBanner' method...");
        }
        return (BannerInfoVO)sqlSessionTemplate.selectOne(getSqlId("getBanner"), bannerSearchVO);
	}

	/**
	 * 배너 등록
	 * @param bannerInfoVO
	 * @return
	 */
	public int insertBannerInfo(BannerInfoVO bannerInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertBannerInfo' method...");
        }
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertBannerInfo"), bannerInfoVO);
	}

	/**
	 * 배너 수정
	 * @param bannerInfoVO
	 * @return
	 */
	public int updateBannerInfo(BannerInfoVO bannerInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerInfo' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerInfo"), bannerInfoVO);
	}

	/**
	 * 배너 오픈수 증가
	 * @param bannerInfoVO
	 * @return
	 */
	public int updateBannerOpenCount(BannerInfoVO bannerInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerOpenCount' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerOpenCount"), bannerInfoVO);
	}

	/**
	 * 배너 클릭수 증가
	 * @param bannerInfoVO
	 * @return
	 */
	public int updateBannerClickCount(BannerInfoVO bannerInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerClickCount' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerClickCount"), bannerInfoVO);
	}

	/**
	 * 배너 상태 수정(삭제)
	 * @param bannerInfoVO
	 * @return
	 */
	public int updateBannerInfoRemove(BannerInfoVO bannerInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerInfoRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerInfoRemove"), bannerInfoVO);
	}

	/**
	 * 배너 일괄 상태 수정(삭제)
	 * @param bannerInfoVO
	 * @return
	 */
	public int updateSelectBannerInfoRemove(BannerFormVO bannerFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateSelectBannerInfoRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateSelectBannerInfoRemove"), bannerFormVO);
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
