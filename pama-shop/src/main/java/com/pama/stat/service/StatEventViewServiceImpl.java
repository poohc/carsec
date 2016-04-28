package com.pama.stat.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.stat.dao.StatEventViewDAO;
import com.pama.stat.vo.StatEventViewVO;

@Service
public class StatEventViewServiceImpl implements StatEventViewService {


    private static final Log LOG = LogFactory.getLog(StatEventViewServiceImpl.class);

    @Autowired
    private StatEventViewDAO statEventViewDAO;


    @Override
    public int insertStatEventView(StatEventViewVO statEventViewVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertStatEventView' method...");
        }
        return statEventViewDAO.insertStatEventView(statEventViewVO);
    }

}
