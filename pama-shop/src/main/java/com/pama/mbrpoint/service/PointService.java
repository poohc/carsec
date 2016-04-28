package com.pama.mbrpoint.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pama.common.Constants;
import com.pama.mbrpoint.dao.PointDAO;
import com.pama.mbrpoint.vo.PointFormVO;
import com.pama.mbrpoint.vo.PointListVO;
import com.pama.mbrpoint.vo.PointSearchVO;
import com.pama.mbrpoint.vo.PointVO;

@Service
public class PointService {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(PointService.class);

    @Autowired
    private PointDAO pointDAO;

    /**
     *
     * @param pointSearchVO
     * @return
     */
    public PointListVO getPointList(PointSearchVO pointSearchVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPointList' method...");
    	}

    	int totalCount = pointDAO.getPointListTotalCount(pointSearchVO);
    	List<PointVO> pointVOList = pointDAO.getPointList(pointSearchVO);

    	PointListVO pointListVO = new PointListVO();

    	pointListVO.setPointSearchVO(pointSearchVO);
    	pointListVO.getPointSearchVO().setTotalCount(totalCount);
    	pointListVO.setPointList(pointVOList);

    	return pointListVO;
    }

    public List<PointVO> getPointUseSummaryList(PointSearchVO pointSearchVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'pointUseSummaryList' method...");
    	}

    	List<PointVO> pointUseSummaryList = pointDAO.getPointUseSummaryList(pointSearchVO);

    	return pointUseSummaryList;
    }

    /**
     *
     * @param pointId
     * @return
     */
    public PointVO getPoint(int pointId) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPoint' method...");
    	}

    	return pointDAO.getPoint(pointId);
    }

    /**
     *
     * @param pointId
     * @return
     */
    public PointVO getPointUse(int messageId, String mbrId, String pointFlag) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'getPointUse' method...");
    	}

    	PointFormVO pointFormVO = new PointFormVO();
    	pointFormVO.setMbrId(mbrId);
    	pointFormVO.setMessageId(messageId);
    	pointFormVO.setPointFlag(Constants.MBR_POINT_FLAG_USE);

    	return pointDAO.getPointUse(pointFormVO);
    }

    /**
     * 충전한다
     * @param pointSearchVO
     * @return
     */
    public int trxChargingPoint(String mbrId, int point, String pointTitle, String registerId, String registerIp) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertPoint' method...");
    	}
    	PointFormVO pointFormVO = new PointFormVO();
    	pointFormVO.setMbrId(mbrId);
    	pointFormVO.setPoint(point);
    	pointFormVO.setPointFlag(Constants.MBR_POINT_FLAG_CHARGING);
    	pointFormVO.setPointTitle(pointTitle);
    	pointFormVO.setRegisterId(registerId);
    	pointFormVO.setRegisterIp(registerIp);
    	pointFormVO.setUpdateAccPoint(point);

    	pointDAO.insertPoint(pointFormVO);
    	pointDAO.updateAccountAccPoint(pointFormVO);

    	return 1;
    }

    /**
     * bbs 충전한다
     * @param pointSearchVO
     * @return
     */
    public int trxAddPoint(String mbrId, int point, String pointTitle, int messageId, String messageRegisterId, String registerId, String registerIp) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertPoint' method...");
    	}
    	PointFormVO pointFormVO = new PointFormVO();
    	pointFormVO.setMbrId(mbrId);
    	pointFormVO.setPoint(point);
    	pointFormVO.setPointFlag(Constants.MBR_POINT_FLAG_CHARGING);
    	pointFormVO.setPointTitle(pointTitle);
     	pointFormVO.setMessageId(messageId);
    	pointFormVO.setMessageRegisterId(messageRegisterId);
    	pointFormVO.setRegisterId(registerId);
    	pointFormVO.setRegisterIp(registerIp);
    	pointFormVO.setUpdateAccPoint(point);

    	pointDAO.insertPoint(pointFormVO);
    	pointDAO.updateAccountAccPoint(pointFormVO);

    	return 1;
    }

    /**
     * 사용한다
     * @param pointSearchVO
     * @return
     */
    public int trxUsePoint(String mbrId, int point, String pointTitle, int messageId, String messageRegisterId, String registerId, String registerIp) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertPoint' method...");
    	}
    	PointFormVO pointFormVO = new PointFormVO();
    	pointFormVO.setMbrId(mbrId);
    	pointFormVO.setPoint(point);
    	pointFormVO.setPointFlag(Constants.MBR_POINT_FLAG_USE);
    	pointFormVO.setPointTitle(pointTitle);
    	pointFormVO.setMessageId(messageId);
    	pointFormVO.setMessageRegisterId(messageRegisterId);
    	pointFormVO.setRegisterId(registerId);
    	pointFormVO.setRegisterIp(registerIp);

    	pointFormVO.setUpdateAccPoint(-point);
    	int accountAccPoint = pointDAO.getAccountAccPoint(pointFormVO);
    	if(accountAccPoint >= point ){
    		pointDAO.insertPoint(pointFormVO);
        	pointDAO.updateAccountAccPoint(pointFormVO);
        	return Constants.MBR_POINT_USE_POINT_SUCCESS;
    	}else{
    		return Constants.MBR_POINT_USE_POINT_NOPOINT;
    	}
    }

    /**
     * 환불한다
     * @param pointSearchVO
     * @return
     */
    public int trxReturnPoint(int pointId, String pointTitle) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'insertPoint' method...");
    	}

    	PointVO pointVO = pointDAO.getPoint(pointId);
    	if(pointVO==null){
    		return Constants.MBR_POINT_RETURN_POINT_NULLERROR;
    	}

    	if(!StringUtils.equals(pointVO.getPointFlag(), Constants.MBR_POINT_FLAG_USE)){//사용한 포인트가 아니면 -1
    		return Constants.MBR_POINT_RETURN_POINT_TYPEERROR;
    	}

    	PointFormVO pointFormVO = new PointFormVO();
    	try {
			BeanUtils.copyProperties(pointFormVO, pointVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

    	pointFormVO.setPointFlag(Constants.MBR_POINT_FLAG_RETURN);
    	pointFormVO.setPointTitle(pointVO.getPointTitle() + " : " + pointTitle);
    	pointFormVO.setUpdateAccPoint(pointVO.getPoint());

		pointDAO.insertPoint(pointFormVO);
		pointDAO.updateAccountAccPoint(pointFormVO);
		return Constants.MBR_POINT_RETURN_POINT_SUCCESS;
    }

}
