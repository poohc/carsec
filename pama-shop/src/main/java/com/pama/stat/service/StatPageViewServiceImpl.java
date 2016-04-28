package com.pama.stat.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.stat.dao.StatPageViewDAO;
import com.pama.stat.vo.StatPageViewVO;

@Service
public class StatPageViewServiceImpl implements StatPageViewService {


    private static final Log LOG = LogFactory.getLog(StatPageViewServiceImpl.class);

    @Autowired
    private StatPageViewDAO statPageViewDAO;


    @Override
    public int insertStatPageView(StatPageViewVO StatPageViewVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertSample' method...");
        }
        return statPageViewDAO.insertStatPageView(StatPageViewVO);
    }




}
