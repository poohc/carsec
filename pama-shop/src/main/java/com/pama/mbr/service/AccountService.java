package com.pama.mbr.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pama.common.Constants;
import com.pama.common.util.SecurityUtil;
import com.pama.mbr.dao.AccountDAO;
import com.pama.mbr.dao.AccountInfoDAO;
import com.pama.mbr.vo.AccountMechanicInfoVO;
import com.pama.mbr.vo.AccountCarInfoVO;
import com.pama.mbr.vo.AccountListVO;
import com.pama.mbr.vo.AccountSearchVO;
import com.pama.mbr.vo.AccountVO;

@Service
public class AccountService {

    /**
     * Log 객체를 생성한다.
     */
    private static final Log LOG = LogFactory.getLog(AccountService.class);

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountInfoDAO accountInfoDAO;


    /**
     * 중복 아이디 체크
     * @param accountVO
     * @return
     */
    public String accountIdChk(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'accountIdChk' method...");
        }
        String mbrId = null;

        if(accountDAO.getAccountChk(accountVO) != null){
            mbrId = accountDAO.getAccountChk(accountVO).getMbrId(); // 찾은 아이디
        }

        return mbrId; //true 이면 중복
    }

    /**
     * NickName 중복 체크
     * @param accountVO
     * @return
     */
    public String accountNickChk(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'accountNickChk' method...");
        }
        String nickName = null;

        if(accountDAO.getAccountChk(accountVO) != null){
        	nickName = accountDAO.getAccountChk(accountVO).getNickName(); // 찾은 NickName
        }

        return nickName; //true 이면 중복
    }


    /**
     * mobileNumber 중복 체크
     * @param accountVO
     * @return
     */
    public String accountMobilechk(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'accountMobilechk' method...");
        }
        String mobileNumber = null;

        if(accountDAO.getAccountChk(accountVO) != null){
        	mobileNumber = accountDAO.getAccountChk(accountVO).getMobile(); // 찾은 핸드폰번호
        }

        return mobileNumber; //true 이면 중복
    }

    /**
     * 중복 이메일 체크
     * @param accountVO
     * @return
     */
    public String accountEmailChk(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'accountEmailChk' method...");
        }
        String email = null;

        if(accountDAO.getAccountChk(accountVO) != null){
            email = accountDAO.getAccountChk(accountVO).getEmail(); // 찾은 이메일
        }

        return email; //true 이면 중복
    }

    /**
     * 중복 닉네임 체크
     * @param accountVO
     * @return
     */
    public String accountNickNameChk(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'accountNickNameChk' method...");
        }
        String nickName = null;

        AccountVO accountResultVO = accountDAO.getAccountChk(accountVO);

        if(accountResultVO != null){
        	nickName = accountResultVO.getNickName(); // 찾은 닉네임
        }

        return nickName; //true 이면 중복
    }

    /**
    * 회원 리스트
    * 목록(AccountSearchVO 안에 TotalCount 및 페이징정보같이 들어감
    * @param accountSearchVO
    * @return
    */
    public AccountListVO getAccountPagingList(AccountSearchVO accountSearchVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccountPagingList' method...");
        }

        AccountListVO accountListVO = new AccountListVO();
        int accountTotalCount = accountDAO.getAccountListTotalCount(accountSearchVO);
        List<AccountVO> accountList = accountDAO.getAccountPagingList(accountSearchVO);

        accountListVO.setAccountList(accountList);
        accountListVO.setAccountSearchVO(accountSearchVO);
        accountListVO.getAccountSearchVO().setTotalCount(accountTotalCount);

        return accountListVO;
    }

    /**
    * 회원 상세 정보
    * @param accountVO
    * @return
    */
    public AccountVO getAccount(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccount' method...");
        }

        AccountVO accountInfoVO = accountDAO.getAccount(accountVO);

        if (accountInfoVO.getLevel() == 10) {
        	AccountCarInfoVO accountCarInfoVO = new AccountCarInfoVO();
        	accountCarInfoVO.setMbrId(accountVO.getMbrId());
        	accountInfoVO.setAccountCarInfoVO(accountInfoDAO.getAccountCarInfo(accountCarInfoVO));
        } else if (accountInfoVO.getLevel()==30 || accountInfoVO.getLevel()==40) {
        	AccountMechanicInfoVO accountMechanicInfoVO = new AccountMechanicInfoVO();
        	accountMechanicInfoVO.setMbrId(accountVO.getMbrId());
        	accountInfoVO.setAccountMechanicInfoVO(accountInfoDAO.getAccountMechanicInfo(accountMechanicInfoVO));
        }

        return accountInfoVO;
    }

    /**
    * 일반회원회원가입등록
    * @param accountVO
    * @return
    */
    public int addAccount(AccountVO accountVO) {
        int row = 0;
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addAccount' method...");
        }
        try {
            //비밀번호 암호화
            accountVO.setPwd(SecurityUtil.md5enc(accountVO.getPwd()));

            //Account 기본 가입
            row = accountDAO.insertAccount(accountVO);

            //카정보 입력
            AccountCarInfoVO accountCarInfoVO = accountVO.getAccountCarInfoVO();
            accountCarInfoVO.setMbrId(accountVO.getMbrId());//Form에서 안넘어오기 때문에 세팅함

            accountInfoDAO.insertAccountCarInfo(accountCarInfoVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 메카닉회원가입등록
     * @param accountVO
     * @return
     */
    public int addAccountAgencyProc(AccountVO accountVO) {
        int row = 0;
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'addAccountAgencyProc' method...");
        }
        try {
            //비밀번호 암호화
            accountVO.setPwd(SecurityUtil.md5enc(accountVO.getPwd()));

            //메카닉회원 기본 가입
            row = accountDAO.insertAccount(accountVO);

            //메카닉회원 서비스품목 등록
            AccountMechanicInfoVO accountMechanicInfoVO = accountVO.getAccountMechanicInfoVO();
            accountMechanicInfoVO.setMbrId(accountVO.getMbrId());//Form에서 안넘어오기 때문에 세팅함

            accountInfoDAO.insertAccountMechanicInfo(accountMechanicInfoVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 회원 가입 등록
     * @param accountVO
     * @return
     */
    public int addAccountB(AccountVO accountVO) {
    	int row = 0;
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'addAccount' method...");
    	}
    	try {
    		//비밀번호 암호화
    		accountVO.setPwd(SecurityUtil.md5enc(accountVO.getPwd()));
    		row = accountDAO.insertAccount(accountVO);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return row;
    }

    /**
    * 회원 정보 수정
    * @param accountVO
    * @return
    */
    public int modifyAccount(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyAccount' method...");
        }

        int result = accountDAO.updateAccount(accountVO);

        if (accountVO.getLevel()==10) {
	        AccountCarInfoVO accountCarInfoVO = accountVO.getAccountCarInfoVO();
	        accountCarInfoVO.setMbrId(accountVO.getMbrId());
	        if (accountCarInfoVO.getCarId() == null ||
	        		"".equals(accountCarInfoVO.getCarId())) {
	        	accountInfoDAO.insertAccountCarInfo(accountCarInfoVO);
	        } else {
	        	accountInfoDAO.updateAccountCarInfo(accountCarInfoVO);
	        }
        } else if (accountVO.getLevel()==30 || accountVO.getLevel()==40) {
        	AccountMechanicInfoVO accountMechanicInfoVO = accountVO.getAccountMechanicInfoVO();
        	accountMechanicInfoVO.setMbrId(accountVO.getMbrId());
        	if (accountMechanicInfoVO.getMechanicId() == null ||
        			"".equals(accountMechanicInfoVO.getMechanicId() )) {
        		accountInfoDAO.insertAccountMechanicInfo(accountMechanicInfoVO);
        	} else {
        		accountInfoDAO.updateAccountMechanicInfo(accountMechanicInfoVO);
        	}
        }

        return result;
    }

    /**
    * 회원 탈퇴
    * @param accountVO
    * @return
    */
    public int removeAccount(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'removeAccount' method...");
        }

        //try {
		//	accountVO.setPwd(SecurityUtil.md5enc(accountVO.getPwd()));
		//} catch (NoSuchAlgorithmException e) {
		//	e.printStackTrace();
		//}
        return accountDAO.updateAccountRemove(accountVO);
    }

    /**
     * 회원 아이디 찾기
     * @param accountVO
     * @return
     */
    public String getSearchID(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getSearchID' method...");
        }
        String mbrId = null;

        AccountVO accountInfoVO = accountDAO.getAccountSearch(accountVO);
        if(accountInfoVO != null){
            mbrId = accountInfoVO.getEmail();
        }
        return mbrId;
    }

    /**
     * 회원 비밀번호 찾기
     * @param accountVO
     * @return
     */
    public String getSearchPwd(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getSearchPwd' method...");
        }

        String pwd = null;

        try {

            //비번을 찾으려는 아이디 확인
            AccountVO accountInfoVO = accountDAO.getAccountSearch(accountVO);

            if(accountInfoVO != null && StringUtils.isNotEmpty(accountInfoVO.getMbrId())){
                pwd = SecurityUtil.getRandom(7); //pwd(비밀번호) 생성
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pwd; //null 이면 실패
    }

    /**
    * 회원 등급 변경
    * @param accountVO
    * @return
    */
    public int modifyAccountLevel(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyAccountLevel' method...");
        }
        return accountDAO.updateAccountLevel(accountVO);
    }

    /**
     * 비밀번호 번경
     * @param accountVO
     * @return
     */
    public int modifyPwd(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyPwd' method...");
        }
        int row =0;
        try {
            accountVO.setPwd(SecurityUtil.md5enc(accountVO.getPwd())); // 변경하려는 비밀번호 암호화
            row = accountDAO.updatePwd(accountVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;

    }

    /**
     * 비밀번호 확인
     * @param accountVO
     * @return
     */
    public String getAccountPwdChk(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccountPwdChk' method...");
        }
        String pwd = null; // DB에 있는 비밀번호
        try {
            pwd = accountDAO.getAccount(accountVO).getPwd(); // DB에 있는 비밀번호

            // DB의 비밀번호와 확인하려는  비밀번호가 같지 않다면
            if (StringUtils.isNotEmpty(pwd) && !SecurityUtil.md5enc(accountVO.getPwd()).equals(pwd)){
                pwd = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pwd; //pwd가 null이면 확인 실패
    }

    /**
     * 로그인
     * @param accountVO
     * @return
     */
    public AccountVO getAccountLogin(AccountVO accountVO) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'getAccountLogin' method...");
        }
        AccountVO accountInfoVO = null;
        try {

            accountVO.setStatusType(Constants.MBR_ACCOUNT_STATUS_TYPE);  // 타입이 일반일때만 로그인 가능
            accountInfoVO = accountDAO.getAccount(accountVO);

            if (accountInfoVO != null && !SecurityUtil.md5enc(accountVO.getPwd()).equals(accountInfoVO.getPwd())){   // 비밀번호 가 같지 않다면
                accountInfoVO = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountInfoVO; // null이면 로그인 실패 (아이디가 없거나 비밀번호가 틀림)
    }

    /**
     * 로그인 정보 수정 (마지막 로그인 날짜 업데이트  & 로그인 카운트 +1)
     * @param accountVO
     * @return
     */
    public int modifyLastLoginDate(AccountVO accountVO){
        if (LOG.isDebugEnabled()) {
            LOG.debug("invoked 'modifyLastLoginDate' method...");
        }
        //마지막 로그인 날짜 업데이트  & 로그인 카운트 +1
        int row = accountDAO.updateLastLoginDate(accountVO);
        return row;
    }

    /**
     * 메모수정
     * @param accountVO
     * @return
     */
    public int modifyAccountMemo(String mbrId, String memo, String updateIp){
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("invoked 'modifyAccountMemo' method...");
    	}

    	AccountVO accountVO = new AccountVO();
    	accountVO.setMbrId(mbrId);
    	accountVO.setMemo(memo);
    	accountVO.setUpdateIp(updateIp);

    	int row = accountDAO.updateAccountMemo(accountVO);
    	return row;
    }

}
