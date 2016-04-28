package com.pama.mbr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;

@Repository
public class AccountDAO {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(AccountDAO.class);
    private static final String SQLMAP_NAMESPACE = "com.pama.mbr.dao.AccountDAO";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 회원 리스트 전체갯수조회
     * @param accountSearchVO
     * @return
     */
    public int getAccountListTotalCount(AccountSearchVO accountSearchVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getCount' method...");
        }
        return (Integer)sqlSessionTemplate.selectOne(getSqlId("getAccountListTotalCount"),accountSearchVO);
    }

    /**
     * 회원 리스트
     * @param AccountVO
     * @return
     */
    public List<AccountVO> getAccountPagingList(AccountSearchVO accountSearchVO) {
        if ( LOG.isDebugEnabled() ) {
                LOG.debug("invoked 'getAccountPagingList' method...");
        }
        return sqlSessionTemplate.selectList(getSqlId("getAccountPagingList"),accountSearchVO);
    }

    /**
     * 회원 상세
     * @param AccountVO
     * @return
     */
    public AccountVO getAccount(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccount' method...");
        }
        return (AccountVO)sqlSessionTemplate.selectOne(getSqlId("getAccount"),accountVO);
    }

    /**
     * 회원 등록 메카닉회원 등록
     * @param AccountVO
     * @return
     */
    public int insertAccount(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'insertAccount' method...");
        }
        sqlSessionTemplate.insert(getSqlId("insertAccount"), accountVO);
        return 1;
    }

    /**
     * 회원 수정
     * @param AccountVO
     * @return
     */
    public int updateAccount(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccount' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateAccount"), accountVO);
    }

    public int updateAccountCareer(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccountCareer' method...");
        }
        return (Integer) sqlSessionTemplate.update(getSqlId("updateAccountCareer"), accountVO);
    }

    public int updateAccountMemo(AccountVO accountVO) {
    	if ( LOG.isDebugEnabled() ) {
    		LOG.debug("invoked 'updateAccountMemo' method...");
    	}
    	return (Integer) sqlSessionTemplate.update(getSqlId("updateAccountMemo"), accountVO);
    }

    /**
     * 회원 탈퇴
     * @param AccountVO
     * @return
     */
    public int updateAccountRemove(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccountRemove' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateAccountRemove"), accountVO);
    }

    /**
     * 회원 레벨 변경
     * @param AccountVO
     * @return
     */
    public int updateAccountLevel(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateAccountLevel' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateAccountLevel"), accountVO);
    }


    /**
     * 로그인 정보 수정 (마지막 로그인 날짜 업데이트  & 로그인 카운트 +1)
     * @param AccountVO
     * @return
     */
    public int updateLastLoginDate(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updateLastLoginDate' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updateLastLoginDate"), accountVO);
    }

    /**
     * 회원  비밀번호 변경
     * @param AccountVO
     * @return
     */
    public int updatePwd(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'updatePwd' method...");
        }
        return (Integer)sqlSessionTemplate.update(getSqlId("updatePwd"), accountVO);
    }

    /**
     * 회원 아이디, 비밀번호 찾기
     * @param AccountVO
     * @return
     */
    public AccountVO getAccountSearch(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccountSearch' method...");
        }
        return (AccountVO) sqlSessionTemplate.selectOne(getSqlId("getAccountSearch"), accountVO);
    }

    /**
     * 회원 아이디, 회원 이메일 ,회원 닉네임, 회원 휴대폰번호 중복체크
     * @param AccountVO
     * @return
     */
    public AccountVO getAccountChk(AccountVO accountVO) {
        if ( LOG.isDebugEnabled() ) {
            LOG.debug("invoked 'getAccountChk' method...");
        }
        return (AccountVO) sqlSessionTemplate.selectOne(getSqlId("getAccountChk"), accountVO);
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
