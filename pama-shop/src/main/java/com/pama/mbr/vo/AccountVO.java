package com.pama.mbr.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountVO implements Serializable{

    static final long serialVersionUID = 567711528709195728L;

    /**
     * 회원 ID
     */
    @XmlElement(name = "mbrId")
    private String mbrId;

    /**
     * 비밀번호
     */
    @XmlElement(name = "pwd")
    private String pwd;

    /**
     * 비밀번호 변경시 변경할 비밀번호
     */
    @XmlElement(name = "modifyPwd")
    private String modifyPwd;

    /**
     * 회원 first이름
     */
    @XmlElement(name = "firstName")
    private String firstName;

    /**
     * 회원 last이름
     */
    @XmlElement(name = "lastName")
    private String lastName;

    /**
     * 회원 nickName
     */
    @XmlElement(name = "nickName")
    private String nickName;

    /**
     * 회원 이메일
     */
    @XmlElement(name = "email")
    private String email;

    /**
     * 회원 전화번호
     */
    @XmlElement(name = "tel")
    private String tel;

    /**
     * 회원 hp번호
     */
    @XmlElement(name = "mobile")
    private String mobile;

    /**
     * 회원 hp번호
     */
    @XmlElement(name = "mobile1")
    private String mobile1;

    /**
     * 회원 hp번호
     */
    @XmlElement(name = "mobile2")
    private String mobile2;

    /**
     * 회원 hp번호
     */
    @XmlElement(name = "mobile3")
    private String mobile3;

    /**
     *  우편번호
     */
    @XmlElement(name = "zipcode")
    private String zipcode;

    /**
     * 회원 주소1
     */
    @XmlElement(name = "addr1")
    private String addr1;

    /**
     * 회원 주소2
     */
    @XmlElement(name = "addr2")
    private String addr2;

    /**
     * 회원 생일
     */
    @XmlElement(name = "birth")
    private String birth;

    /**
     * 회원 레벨
     */
    @XmlElement(name = "level")
    private int level;

    /**
     * 성별 (m/f)
     */
    @XmlElement(name = "gender")
    private String gender;

    /**
     * sns 수신동의 (y/n)
     */
    @XmlElement(name = "snsReceiveYN")
    private String snsReceiveYN;

    /**
     * 마지막 로그인 날짜
     */
    @XmlElement(name = "loginDate")
    private String loginDate;

    /**
     * 회원 상태
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * 회원 포인트
     */
    @XmlElement(name = "accPoint")
    private int accPoint;

    /**
     * 회원 로그인 카운트
     */
    @XmlElement(name = "loginCount")
    private int loginCount;

    /**
     * 회원 가입 날짜
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 회원 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

    /**
     * 회원 수정 날짜
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 회원 수정 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 메모
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * 추천인
     */
    @XmlElement(name = "recommender")
    private String recommender;

    /**
     * 경력(정보원 소개)
     */
    @XmlElement(name = "career")
    private String career;


    @XmlElement
    private AccountCarInfoVO accountCarInfoVO;

    @XmlElement
    private AccountMechanicInfoVO accountMechanicInfoVO;


    private String bizNumber;
    private MultipartFile file1;
    private MultipartFile file2;
    private MultipartFile file3;
    private MultipartFile file4;

    public String getBizNumber() {
		return bizNumber;
	}

	public void setBizNumber(String bizNumber) {
		this.bizNumber = bizNumber;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	public MultipartFile getFile4() {
		return file4;
	}

	public void setFile4(MultipartFile file4) {
		this.file4 = file4;
	}

	private AccountStatVO accountStatVO;

    /**
     * @return the mbrId
     */
    public String getMbrId() {
        return mbrId;
    }

    /**
     * @param mbrId the mbrId to set
     */
    public void setMbrId(String mbrId) {
        this.mbrId = mbrId;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


	/**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the addr1
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * @param addr1 the addr1 to set
     */
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    /**
     * @return the addr2
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * @param addr2 the addr2 to set
     */
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    /**
     * @return the birth
     */
    public String getBirth() {
        return birth;
    }

    /**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
     * @param birth the birth to set
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public String getSnsReceiveYN() {
		return snsReceiveYN;
	}

	public void setSnsReceiveYN(String snsReceiveYN) {
		this.snsReceiveYN = snsReceiveYN;
	}

	/**
     * @return the loginDate
     */
    public String getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * @return the statusType
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the accPoint
     */
    public int getAccPoint() {
        return accPoint;
    }

    /**
     * @param accPoint the accPoint to set
     */
    public void setAccPoint(int accPoint) {
        this.accPoint = accPoint;
    }

    /**
     * @return the loginCount
     */
    public int getLoginCount() {
        return loginCount;
    }

    /**
     * @param loginCount the loginCount to set
     */
    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * @return the registerDate
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return the registerIp
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * @param registerIp the registerIp to set
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    /**
     * @return the updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the updateIp
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * @param updateIp the updateIp to set
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

	/**
	 * @return the recommender
	 */
	public String getRecommender() {
		return recommender;
	}

	/**
	 * @param recommender the recommender to set
	 */
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	/**
	 * @return
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * @param career
	 */
	public void setCareer(String career) {
		this.career = career;
	}

	/**
	 * @return the modifyPwd
	 */
	public String getModifyPwd() {
		return modifyPwd;
	}

	/**
	 * @param modifyPwd the modifyPwd to set
	 */
	public void setModifyPwd(String modifyPwd) {
		this.modifyPwd = modifyPwd;
	}

	/**
	 * @return the mobile1
	 */
	public String getMobile1() {
		return mobile1;
	}

	/**
	 * @param mobile1 the mobile1 to set
	 */
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	/**
	 * @return the mobile2
	 */
	public String getMobile2() {
		return mobile2;
	}

	/**
	 * @param mobile2 the mobile2 to set
	 */
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	/**
	 * @return the mobile3
	 */
	public String getMobile3() {
		return mobile3;
	}

	/**
	 * @param mobile3 the mobile3 to set
	 */
	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	/**
	 * @return the accountStatVO
	 */
	public AccountStatVO getAccountStatVO() {
		return accountStatVO;
	}

	/**
	 * @param accountStatVO the accountStatVO to set
	 */
	public void setAccountStatVO(AccountStatVO accountStatVO) {
		this.accountStatVO = accountStatVO;
	}

	/**
	 * @return the accountCarInfoVO
	 */
	public AccountCarInfoVO getAccountCarInfoVO() {
		return accountCarInfoVO;
	}

	/**
	 * @param accountCarInfoVO the accountCarInfoVO to set
	 */
	public void setAccountCarInfoVO(AccountCarInfoVO accountCarInfoVO) {
		this.accountCarInfoVO = accountCarInfoVO;
	}

	/**
	 * @return the accountMechanicInfoVO
	 */
	public AccountMechanicInfoVO getAccountMechanicInfoVO() {
		return accountMechanicInfoVO;
	}

	/**
	 * @param accountMechanicInfoVO the accountMechanicInfoVO to set
	 */
	public void setAccountMechanicInfoVO(AccountMechanicInfoVO accountMechanicInfoVO) {
		this.accountMechanicInfoVO = accountMechanicInfoVO;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "AccountVO [mbrId=" + mbrId + ", pwd=" + pwd + ", modifyPwd=" + modifyPwd + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nickName=" + nickName + ", email=" + email + ", tel=" + tel
				+ ", mobile=" + mobile + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3
				+ ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", birth=" + birth + ", level="
				+ level + ", gender=" + gender + ", snsReceiveYN=" + snsReceiveYN + ", loginDate=" + loginDate
				+ ", statusType=" + statusType + ", accPoint=" + accPoint + ", loginCount=" + loginCount
				+ ", registerDate=" + registerDate + ", registerIp=" + registerIp + ", updateDate=" + updateDate
				+ ", updateIp=" + updateIp + ", memo=" + memo + ", recommender=" + recommender + ", career=" + career
				+ ", accountCarInfoVO=" + accountCarInfoVO + ", accountMechanicInfoVO=" + accountMechanicInfoVO
				+ ", accountStatVO=" + accountStatVO + "]";
	}


}
