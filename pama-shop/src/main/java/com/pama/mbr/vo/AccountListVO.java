package com.pama.mbr.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accountList")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountListVO implements Serializable {

	private static final long serialVersionUID = 2700021881685138375L;

	@XmlElement(name = "account")
    private List<AccountVO> accountList;

    private AccountSearchVO accountSearchVO;

    /**
     * @return the accountList
     */
    public List<AccountVO> getAccountList() {
        return accountList;
    }

    /**
     * @param accountList the accountList to set
     */
    public void setAccountList(List<AccountVO> accountList) {
        this.accountList = accountList;
    }

    /**
     * @return the accountSearchVO
     */
    public AccountSearchVO getAccountSearchVO() {
        return accountSearchVO;
    }

    /**
     * @param accountSearchVO the accountSearchVO to set
     */
    public void setAccountSearchVO(AccountSearchVO accountSearchVO) {
        this.accountSearchVO = accountSearchVO;
    }

}

