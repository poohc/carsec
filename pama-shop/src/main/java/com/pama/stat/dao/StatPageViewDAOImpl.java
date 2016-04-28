package com.pama.stat.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.stat.vo.StatPageViewVO;

@Repository
public class StatPageViewDAOImpl implements StatPageViewDAO {

	private static final Log LOG = LogFactory.getLog(StatPageViewDAOImpl.class);
	private static final String SQLMAP_NAMESPACE = "com.pama.stat.dao.StatPageViewDAO";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertStatPageView(StatPageViewVO StatPageViewVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'insertStatPageView' method...");
		}
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertStatPageView"), StatPageViewVO);
	}

	/**
	 * @param methodName
	 * @return
	 */
	private String getSqlId(String methodName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SQLMAP_NAMESPACE);
		stringBuilder.append(".");
		stringBuilder.append(methodName);
		return stringBuilder.toString();
	}

}
