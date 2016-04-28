package com.pama.stat.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.stat.vo.StatEventViewVO;

@Repository
public class StatEventViewDAOImpl implements StatEventViewDAO {

	private static final Log LOG = LogFactory.getLog(StatEventViewDAOImpl.class);
	private static final String SQLMAP_NAMESPACE = "com.pama.stat.dao.StatEventViewDAO";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertStatEventView(StatEventViewVO statEventViewVO) {
		if ( LOG.isDebugEnabled() ) {
			LOG.debug("invoked 'insertStatEventView' method...");
		}
		return (Integer)sqlSessionTemplate.insert(getSqlId("insertStatEventView"), statEventViewVO);
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
