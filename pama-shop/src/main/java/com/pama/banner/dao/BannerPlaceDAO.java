package com.pama.banner.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerPlaceVO;
import com.pama.banner.vo.BannerSearchVO;

@Repository
public class BannerPlaceDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(BannerPlaceDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.banner.dao.BannerPlaceDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;  
    
	/**
	 * 배너위치 총 갯수
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
	 * 배너 위치 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerPlaceVO> getBannerPlaceList(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerPlaceList' method...");
        }
		return sqlSessionTemplate.selectList(getSqlId("getBannerPlaceList"), bannerSearchVO);
	}

	/**
	 * 배너 위치 정보
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerPlaceVO getBannerPlace(BannerSearchVO bannerSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerPlace' method...");
        }
        return (BannerPlaceVO)sqlSessionTemplate.selectOne(getSqlId("getBannerPlace"), bannerSearchVO);
	}

	/**
	 * 배너위치 등록
	 * @param bannerPlaceVO
	 * @return
	 */
	public int insertBannerPlace(BannerPlaceVO bannerPlaceVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'insertBannerPlace' method...");
        }
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertBannerPlace"), bannerPlaceVO);
	}

	/**
	 * 배너위치 수정
	 * @param bannerPlaceVO
	 * @return
	 */
	public int updateBannerPlace(BannerPlaceVO bannerPlaceVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerPlace' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerPlace"), bannerPlaceVO);
	}

	/**
	 * 배너위치 상태 수정(삭제)
	 * @param bannerPlaceVO
	 * @return
	 */
	public int updateBannerPlaceRemove(BannerPlaceVO bannerPlaceVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateBannerPlaceRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateBannerPlaceRemove"), bannerPlaceVO);
	}

	/**
	 * 배너위치 일괄 상태 수정(삭제)
	 * @param bannerFormVO
	 * @return
	 */
	public int updateSelectBannerPlaceRemove(BannerFormVO bannerFormVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'updateSelectBannerPlaceRemove' method...");
        }
        return sqlSessionTemplate.update(getSqlId("updateSelectBannerPlaceRemove"), bannerFormVO);
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
