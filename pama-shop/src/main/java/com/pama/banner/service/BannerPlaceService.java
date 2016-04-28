package com.pama.banner.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.banner.dao.BannerPlaceDAO;
import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerListVO;
import com.pama.banner.vo.BannerPlaceVO;
import com.pama.banner.vo.BannerSearchVO;

@Service
public class BannerPlaceService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(BannerPlaceService.class);

    @Autowired
    private BannerPlaceDAO bannerPlaceDAO;

	/**
	 * 배너 위치 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerListVO getBannerPlaceList(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerPlaceList' method...");
        }

		BannerListVO bannerListVO = new BannerListVO();

		int totalCount = bannerPlaceDAO.getListTotalCount(bannerSearchVO);
		List<BannerPlaceVO> bannerPlaceList = bannerPlaceDAO.getBannerPlaceList(bannerSearchVO);

		bannerListVO.setBannerPlaceList(bannerPlaceList);
		bannerListVO.setBannerSearchVO(bannerSearchVO);
		bannerListVO.getBannerSearchVO().setTotalCount(totalCount);

		return bannerListVO;
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

		if (bannerSearchVO.getBannerPlaceId() != null) {

			BannerPlaceVO bannerPlaceVO = bannerPlaceDAO.getBannerPlace(bannerSearchVO);

			return bannerPlaceVO;

		} else {

			return null;

		}
	}

	/**
	 * 배너 위치 등록
	 * @param bannerPlaceVO
	 * @return
	 */
	public int addBannerPlace(BannerPlaceVO bannerPlaceVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addBannerPlace' method...");
        }

		return bannerPlaceDAO.insertBannerPlace(bannerPlaceVO);
	}

	/**
	 * 배너 위치 수정
	 * @param bannerPlaceVO
	 * @return
	 */
	public int modifyBannerPlace(BannerPlaceVO bannerPlaceVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBannerPlace' method...");
        }
		return bannerPlaceDAO.updateBannerPlace(bannerPlaceVO);
	}

	/**
	 * 배너 위치 삭제
	 * @param bannerPlaceVO
	 * @return
	 */
	public int removeBannerPlace(BannerPlaceVO bannerPlaceVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeBannerPlace' method...");
        }
		return bannerPlaceDAO.updateBannerPlaceRemove(bannerPlaceVO);
	}

	/**
	 * 배너 위치 일괄 선택 삭제
	 * @param bannerFormVO
	 * @return
	 */
	public int removeSelectBannerPlace(BannerFormVO bannerFormVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeSelectBannerPlace' method...");
        }
		return bannerPlaceDAO.updateSelectBannerPlaceRemove(bannerFormVO);
	}

}
