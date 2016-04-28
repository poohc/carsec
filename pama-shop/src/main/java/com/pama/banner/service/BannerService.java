package com.pama.banner.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.banner.dao.BannerGroupDAO;
import com.pama.banner.dao.BannerInfoDAO;
import com.pama.banner.dao.BannerPlaceDAO;
import com.pama.banner.vo.BannerFormVO;
import com.pama.banner.vo.BannerGroupVO;
import com.pama.banner.vo.BannerInfoVO;
import com.pama.banner.vo.BannerListVO;
import com.pama.banner.vo.BannerPlaceVO;
import com.pama.banner.vo.BannerSearchVO;

@Service
public class BannerService {

	/**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(BannerService.class);

    @Autowired
    private BannerGroupDAO bannerGroupDAO;

    @Autowired
    private BannerInfoDAO bannerInfoDAO;

    @Autowired
    private BannerPlaceDAO bannerPlaceDAO;

	/**
	 * 배너 그룹 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerListVO getBannerGroupList(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerGroupList' method...");
        }

		BannerListVO bannerListVO = new BannerListVO();

		int totalCount = bannerGroupDAO.getListTotalCount(bannerSearchVO);

		List<BannerGroupVO> bannerGroupList = bannerGroupDAO.getBannerGroupList(bannerSearchVO);

		bannerListVO.setBannerGroupList(bannerGroupList);
		bannerListVO.setBannerSearchVO(bannerSearchVO);
		bannerListVO.getBannerSearchVO().setTotalCount(totalCount);

		return bannerListVO;
	}

	/**
	 * 배너 리스트
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerListVO getBannerInfoList(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerInfoList' method...");
        }

		BannerListVO bannerListVO = new BannerListVO();

		int totalCount = bannerInfoDAO.getListTotalCount(bannerSearchVO);

		List<BannerInfoVO> bannerInfoList = bannerInfoDAO.getBannerInfoList(bannerSearchVO);

		BannerSearchVO bannerSearchVO2 = bannerSearchVO;
		bannerSearchVO2.setRow(0);
		List<BannerPlaceVO> bannerPlaceList = bannerPlaceDAO.getBannerPlaceList(bannerSearchVO2);

		bannerListVO.setBannerInfoList(bannerInfoList);
		bannerListVO.setBannerPlaceList(bannerPlaceList);
		bannerListVO.setBannerSearchVO(bannerSearchVO);
		bannerListVO.getBannerSearchVO().setTotalCount(totalCount);

		return bannerListVO;
	}

	/**
	 * 배너그룹에따란 배너 리슽트
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerListVO getBannerGroupInfoList(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBannerGroupInfoList' method...");
        }

		BannerListVO bannerListVO = new BannerListVO();

		List<BannerInfoVO> bannerInfoList = bannerInfoDAO.getBannerGroupInfoList(bannerSearchVO);

		bannerListVO.setBannerInfoList(bannerInfoList);
		bannerListVO.setBannerSearchVO(bannerSearchVO);

		return bannerListVO;
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

		if (bannerSearchVO.getBannerGroupId() != null) {

			BannerGroupVO bannerGroupVO = bannerGroupDAO.getBannerGroup(bannerSearchVO);

			return bannerGroupVO;

		} else {

			return null;

		}
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

		if (bannerSearchVO.getBannerId() != null) {

			BannerInfoVO bannerInfoVO = bannerInfoDAO.getBannerInfo(bannerSearchVO);

			return bannerInfoVO;

		} else {

			return null;

		}
	}

	/**
	 * 배너 노출 정보
	 * @param bannerSearchVO
	 * @return
	 */
	public List<BannerInfoVO> getBanners(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBanner' method...");
        }

		if (bannerSearchVO.getBannerPlaceId() != null) {

			List<BannerInfoVO> bannerInfoVOs = bannerInfoDAO.getBanners(bannerSearchVO);

			return bannerInfoVOs;

		} else {

			return null;

		}
	}

	/**
	 * 배너 노출 정보
	 * @param bannerSearchVO
	 * @return
	 */
	public BannerInfoVO getBanner(BannerSearchVO bannerSearchVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getBanner' method...");
        }

		if (bannerSearchVO.getBannerPlaceId() != null) {

			BannerInfoVO bannerInfoVO = bannerInfoDAO.getBanner(bannerSearchVO);

			return bannerInfoVO;

		} else {

			return null;

		}
	}

	/**
	 * 배너 그룹 등록
	 * @param bannerGroupVO
	 * @return
	 */
	public int addBannerGroup(BannerGroupVO bannerGroupVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addBannerGroup' method...");
        }

		return bannerGroupDAO.insertBannerGroup(bannerGroupVO);
	}

	/**
	 * 배너 등록
	 * @param bannerInfoVO
	 * @return
	 */
	public int addBannerInfo(BannerInfoVO bannerInfoVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addBannerInfo' method...");
        }

		return bannerInfoDAO.insertBannerInfo(bannerInfoVO);
	}

	/**
	 * 배너 그룹 수정
	 * @param bannerGroupVO
	 * @return
	 */
	public int modifyBannerGroup(BannerGroupVO bannerGroupVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBannerGroup' method...");
        }
		return bannerGroupDAO.updateBannerGroup(bannerGroupVO);
	}

	/**
	 * 배너 수정
	 * @param bannerInfoVO
	 * @return
	 */
	public int modifyBannerInfo(BannerInfoVO bannerInfoVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBannerInfo' method...");
        }
		return bannerInfoDAO.updateBannerInfo(bannerInfoVO);
	}

	/**
	 * 배너 오픈수 증가
	 * @param bannerInfoVO
	 * @return
	 */
	public int modifyBannerInfoOpenCount(BannerInfoVO bannerInfoVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBannerInfoOpenCount' method...");
        }
		return bannerInfoDAO.updateBannerOpenCount(bannerInfoVO);
	}

	/**
	 * 배너 클릭수 증가
	 * @param bannerInfoVO
	 * @return
	 */
	public int modifyBannerInfoClickCount(BannerInfoVO bannerInfoVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyBannerInfoClickCount' method...");
        }
		return bannerInfoDAO.updateBannerClickCount(bannerInfoVO);
	}

	/**
	 * 배너 그룹 삭제
	 * @param bannerGroupVO
	 * @return
	 */
	public int removeBannerGroup(BannerGroupVO bannerGroupVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeBannerGroup' method...");
        }
		return bannerGroupDAO.updateBannerGroupRemove(bannerGroupVO);
	}

	/**
	 * 배너 그룹 일괄 선택 삭제
	 * @param bannerFormVO
	 * @return
	 */
	public int removeSelectBannerGroup(BannerFormVO bannerFormVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeSelectBannerGroup' method...");
        }
		return bannerGroupDAO.updateSelectBannerGroupRemove(bannerFormVO);
	}

	/**
	 * 배너 삭제
	 * @param bannerInfoVO
	 * @return
	 */
	public int removeBannerInfo(BannerInfoVO bannerInfoVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeBannerInfo' method...");
        }
		return bannerInfoDAO.updateBannerInfoRemove(bannerInfoVO);
	}

	/**
	 * 배너 일괄 선택 삭제
	 * @param bannerFormVO
	 * @return
	 */
	public int removeSelectBannerInfo(BannerFormVO bannerFormVO) {
		if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeSelectBannerInfo' method...");
        }
		return bannerInfoDAO.updateSelectBannerInfoRemove(bannerFormVO);
	}

}
