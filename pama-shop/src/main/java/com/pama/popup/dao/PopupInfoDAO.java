package com.pama.popup.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.popup.vo.PopupInfoVO;
import com.pama.popup.vo.PopupSearchVO;

@Repository
public class PopupInfoDAO {

    /**
     * Log 객체를 생성한다.
     */
	private static final Log LOG = LogFactory.getLog(PopupInfoDAO.class);

    /**
     * SqlMap Namespace
     */
    private static final String SQLMAP_NAMESPACE = "com.pama.popup.dao.PopupInfoDAO";
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;    
    
    public List<PopupInfoVO> getList(PopupSearchVO popupSearchVO){
    	return sqlSessionTemplate.selectList(SQLMAP_NAMESPACE+".popupInfoList", popupSearchVO);
    }
    
    public int getListTotalCount(PopupSearchVO popupSearchVO){
    	return sqlSessionTemplate.selectOne(SQLMAP_NAMESPACE+".popupInfoListTotalCount", popupSearchVO);
    }
}