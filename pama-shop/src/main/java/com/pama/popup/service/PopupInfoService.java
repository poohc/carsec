package com.pama.popup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.popup.dao.PopupInfoDAO;
import com.pama.popup.vo.PopupInfoListVO;
import com.pama.popup.vo.PopupInfoVO;
import com.pama.popup.vo.PopupSearchVO;


@Service
public class PopupInfoService {

	@Autowired
	private PopupInfoDAO popupInfoDAO;
	
	public PopupInfoListVO getList(PopupSearchVO popupSearchVO){
		
		List<PopupInfoVO> popupInfoVOs = popupInfoDAO.getList(popupSearchVO);
    	int totalCount = popupInfoDAO.getListTotalCount(popupSearchVO);
    	
    	PopupInfoListVO popupInfoListVO = new PopupInfoListVO();
    	popupInfoListVO.setPopupInfoVOs(popupInfoVOs);
    	popupInfoListVO.setPopupSearchVO(popupSearchVO);
    	popupInfoListVO.getPopupSearchVO().setTotalCount(totalCount);;
    	
    	return popupInfoListVO; 
    	 
    }
	
}
