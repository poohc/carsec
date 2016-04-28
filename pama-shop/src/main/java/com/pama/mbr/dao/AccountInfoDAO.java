package com.pama.mbr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;

@Repository
public class AccountInfoDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(AccountDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.mbr.dao.AccountInfoDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 자동차 상세정보
     * @param AccountCarInfoVO
     * @return
     */
    public AccountCarInfoVO getAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccountCarInfo' method...");
        }
        return (AccountCarInfoVO)sqlSessionTemplate.selectOne(getSqlId("getAccountCarInfo"),accountCarInfoVO);
    }

    /**
     * 메트릭 상세정보
     * @param accountMechanicInfoVO
     * @return
     */
    public AccountMechanicInfoVO getAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccountCarInfo' method...");
        }
        return (AccountMechanicInfoVO)sqlSessionTemplate.selectOne(getSqlId("getAccountMechanicInfo"),accountMechanicInfoVO);
    }

    /**
     * 자동차 정보 등록
     * @param accountCarInfoVO
     * @return
     */
    public int insertAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertAccountCarInfo' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertAccountCarInfo"), accountCarInfoVO);
        return 1;
    }


    /**
     * 메카닉회원 서비스품목 등록
     * @param accountMechanicInfoVO
     * @return
     */
    public int insertAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO ) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertAccountAgencyInfo' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertAccountMechanicInfo"), accountMechanicInfoVO);
        return 1;
    }

    /**
     * 자동차 정보 수정
     * @param accountCarInfoVO
     * @return
     */
    public int updateAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccountCarInfo' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateAccountCarInfo"), accountCarInfoVO);
    }

    /**
     * 메트릭 정보 수정
     * @param accountMechanicInfoVO
     * @return
     */
    public int updateAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccountMechanicInfo' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateAccountMechanicInfo"), accountMechanicInfoVO);
    }

    /**
     * 자동차 정보 삭제
     * @param accountCarInfoVO
     * @return
     */
    public int deleteAccountCarInfo(AccountCarInfoVO accountCarInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'deleteAccountCarInfo' method...");
        }
        return (Integer)sqlSessionTemplate.delete(getSqlId("deleteAccountCarInfo"), accountCarInfoVO);
    }

    /**
     * 메트릭 정보 삭제
     * @param accountMechanicInfoVO
     * @return
     */
    public int deleteAccountMechanicInfo(AccountMechanicInfoVO accountMechanicInfoVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'deleteAccountMechanicInfo' method...");
        }
        return (Integer)sqlSessionTemplate.delete(getSqlId("deleteAccountMechanicInfo"), accountMechanicInfoVO);
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
