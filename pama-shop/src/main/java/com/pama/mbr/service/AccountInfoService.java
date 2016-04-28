package com.pama.mbr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.mbr.dao.AccountInfoDAO;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountVO;

@Service
public class AccountInfoService {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(AccountService.class);

    @Autowired
    private AccountInfoDAO accountInfoDAO;

    /**
     * 정보
     * @param AccountCarInfoVO
     * @return
     */
    public AccountVO getAccountInfo(String mbrInfoId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccountInfo' method...");
        }

        return new AccountVO();
    }

    /**
     * 자동차 정보
     * @param AccountCarInfoVO
     * @return
     */
    public AccountCarInfoVO getAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccountCarInfo' method...");
        }

        return accountInfoDAO.getAccountCarInfo(accountCarInfoVO);
    }

    /**
     * 메트릭 정보
     * @param AccountMechanicInfoVO
     * @return
     */
    public AccountMechanicInfoVO getAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'getAccountMechanicInfo' method...");
    	}

    	return accountInfoDAO.getAccountMechanicInfo(accountMechanicInfoVO);
    }

    /**
     * 자동차 정보 등록
     * @param accountInfoVO
     * @return
     */
    public int addAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addAccountCarInfo' method...");
        }
    	int row = 0;
        try {
        	row = accountInfoDAO.insertAccountCarInfo(accountCarInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 매카닉 정보 등록
     * @param accountMechanicInfoVO
     * @return
     */
    public int addAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addAccountMechanicInfo' method...");
        }
    	int row = 0;
        try {
        	row = accountInfoDAO.insertAccountMechanicInfo(accountMechanicInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
    * 자동차 정보 수정
    * @param AccountCarInfoVO
    * @return
    */
    public int modifyAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyAccountCarInfo' method...");
        }
        int row = 0;
        try {
        	row = accountInfoDAO.updateAccountCarInfo(accountCarInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
    * 매카닉회원 정보 수정
    * @param accountMechanicInfoVO
    * @return
    */
    public int modifyAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyAccountMechanicInfo' method...");
        }
        int row = 0;
        try {
        	row = accountInfoDAO.updateAccountMechanicInfo(accountMechanicInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
    *  레벨은 10으로
    * @param accountCarInfoVO
    * @return
    */
    public int removeAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeAccountCarInfo' method...");
        }

        return accountInfoDAO.deleteAccountCarInfo(accountCarInfoVO);
    }

    /**
    *  레벨은 10으로
    * @param accountCarInfoVO
    * @return
    */
    public int removeAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeAccountMechanicInfo' method...");
        }

        return accountInfoDAO.deleteAccountMechanicInfo(accountMechanicInfoVO);
    }

}
