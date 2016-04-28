package com.pama.ord.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderVO implements Serializable{

    static final long serialVersionUID = 4662125201622012191L;

    /**
     * 주문 ID
     */
    @XmlElement(name = "ordId")
    private String ordId;

    /**
     * 카테고리 ID
     */
    @XmlElement(name = "cateId")
    private String cateId;

    /**
     * 카테고리명
     */
    @XmlElement(name = "cateName")
    private String cateName;

    /**
     * 주문 title
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * 주문 total 가격
     */
    @XmlElement(name = "totalPrice")
    private int totalPrice;

    /**
     * 주문 결제 가격
     */
    @XmlElement(name = "settlePrice")
    private int settlePrice;

    /**
     * 주문 결제 타입
     */
    @XmlElement(name = "settleType")
    private String settleType;

    /**
     * 주문 결제 계좌 번호
     */
    @XmlElement(name = "settleAccountNo")
    private String settleAccountNo;

    /**
     * 주문 결제 계좌 은행
     */
    @XmlElement(name = "settleAccountBank")
    private String settleAccountBank;

    /**
     * 주문 결제 계좌 예금주
     */
    @XmlElement(name = "settleAccountNm")
    private String settleAccountNm;

    /**
     * 주문 입금자
     */
    @XmlElement(name = "depositNm")
    private String depositNm;

    /**
     * 배송 타입 (무료, 유료 - 선불  착불)
     */
    @XmlElement(name = "deliveryType")
    private String deliveryType;

    /**
     * 배송비
     */
    @XmlElement(name = "deliveryPrice")
    private int deliveryPrice;

    /**
     * 세금 계산서 발행 여부
     */
    @XmlElement(name = "orderTexyn")
    private String orderTexyn;

    /**
     * 시작일
     */
    @XmlElement(name = "startDate")
    private String startDate;

    /**
     * 종료일
     */
    @XmlElement(name = "endDate")
    private String endDate;

    /**
     * 라이센스코드
     */
    @XmlElement(name = "licenseCode")
    private String licenseCode;

    /**
     * 유효기간
     */
    @XmlElement(name = "expirationMonth")
    private String expirationMonth;

    /**
     * 등록자 ID
     */
    @XmlElement(name = "registerId")
    private String registerId;

    /**
     * 등록 IP
     */
    @XmlElement(name = "registerIp")
    private String registerIp;

    /**
     * 수정자 ID
     */
    @XmlElement(name = "updateId")
    private String updateId;

    /**
     * 수정 IP
     */
    @XmlElement(name = "updateIp")
    private String updateIp;

    /**
     * 주문 상태
     */
    @XmlElement(name = "statusType")
    private int statusType;

    /**
     * 주문자 ID
     */
    @XmlElement(name = "ordererId")
    private String ordererId;

    /**
     * 주문자 이름
     */
    @XmlElement(name = "ordererName")
    private String ordererName;

    /**
     * 주문자 이메일
     */
    @XmlElement(name = "ordererEmail")
    private String ordererEmail;

    /**
     * 주문자 전화
     */
    @XmlElement(name = "ordererTel")
    private String ordererTel;

    /**
     * 주문자 핸드폰
     */
    @XmlElement(name = "ordererMobile")
    private String ordererMobile;

    /**
     * 주문자 우편번호
     */
    @XmlElement(name = "ordererZipcode")
    private String ordererZipcode;

    /**
     * 주문자 주소
     */
    @XmlElement(name = "ordererAddr1")
    private String ordererAddr1;

    /**
     * 주문자 상세주소
     */
    @XmlElement(name = "ordererAddr2")
    private String ordererAddr2;

    /**
     * 받는이 이름
     */
    @XmlElement(name = "receiveNane")
    private String receiveNane;

    /**
     * 받는이 이메일
     */
    @XmlElement(name = "receiveEmail")
    private String receiveEmail;

    /**
     * 받는이 전화
     */
    @XmlElement(name = "receiveTel")
    private String receiveTel;

    /**
     * 받는이 핸드폰
     */
    @XmlElement(name = "receiveMobile")
    private String receiveMobile;

    /**
     * 받는이 우편번호
     */
    @XmlElement(name = "receiveZipcode")
    private String receiveZipcode;

    /**
     * 받는이 주소
     */
    @XmlElement(name = "receiveAddr1")
    private String receiveAddr1;

    /**
     * 받는이 상세주소
     */
    @XmlElement(name = "receiveAddr2")
    private String receiveAddr2;

    /**
     * 메모
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * 등록일
     */
    @XmlElement(name = "registerDate")
    private String registerDate;

    /**
     * 수정일
     */
    @XmlElement(name = "updateDate")
    private String updateDate;

    /**
     * 주문 상품 ID
     */
    @XmlElement(name = "opdRodId")
    private String opdRodId;

    /**
     * 상품 ID
     */
    @XmlElement(name = "prdId")
    private String prdId;

    /**
     * 주문 상품 이름
     */
    @XmlElement(name = "prdName")
    private String prdName;

    /**
     * QTY
     */
    @XmlElement(name = "qty")
    private int qty;

    /**
     * 판매가격
     */
    @XmlElement(name = "salePrice")
    private int salePrice;

    /**
     * 장바구니 ID
     */
    @XmlElement(name = "cartId")
    private String cartId;
    
    @XmlElement(name = "firstName")
    private String firstName;
    
    @XmlElement(name = "lastName")
    private String lastName;
    
    @XmlElement(name = "tel")
    private String tel;
    
    @XmlElement(name = "addr1")
    private String addr1;
    
    private String[] optId;

    /**
     * 주문 상품 VO
     */
    @XmlElement(name = "productsVO")
    private List<ProductsVO> productsVO;

    /**
     * @return the ordId
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * @param ordId the ordId to set
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    /**
	 * @return the cateId
	 */
	public String getCateId() {
		return cateId;
	}

	/**
	 * @param cateId the cateId to set
	 */
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	/**
	 * @return the cateName
	 */
	public String getCateName() {
		return cateName;
	}

	/**
	 * @param cateName the cateName to set
	 */
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	/**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the settlePrice
     */
    public int getSettlePrice() {
        return settlePrice;
    }

    /**
     * @param settlePrice the settlePrice to set
     */
    public void setSettlePrice(int settlePrice) {
        this.settlePrice = settlePrice;
    }

    /**
     * @return the settleType
     */
    public String getSettleType() {
        return settleType;
    }

    /**
     * @param settleType the settleType to set
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    /**
     * @return the settleAccountNo
     */
    public String getSettleAccountNo() {
        return settleAccountNo;
    }

    /**
     * @param settleAccountNo the settleAccountNo to set
     */
    public void setSettleAccountNo(String settleAccountNo) {
        this.settleAccountNo = settleAccountNo;
    }

    /**
     * @return the settleAccountBank
     */
    public String getSettleAccountBank() {
        return settleAccountBank;
    }

    /**
     * @param settleAccountBank the settleAccountBank to set
     */
    public void setSettleAccountBank(String settleAccountBank) {
        this.settleAccountBank = settleAccountBank;
    }

    /**
     * @return the settleAccountNm
     */
    public String getSettleAccountNm() {
        return settleAccountNm;
    }

    /**
     * @param settleAccountNm the settleAccountNm to set
     */
    public void setSettleAccountNm(String settleAccountNm) {
        this.settleAccountNm = settleAccountNm;
    }

    /**
     * @return the depositNm
     */
    public String getDepositNm() {
        return depositNm;
    }

    /**
     * @param depositNm the depositNm to set
     */
    public void setDepositNm(String depositNm) {
        this.depositNm = depositNm;
    }

    /**
     * @return the deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * @param deliveryType the deliveryType to set
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * @return the deliveryPrice
     */
    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * @param deliveryPrice the deliveryPrice to set
     */
    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * @return the orderTexyn
     */
    public String getOrderTexyn() {
        return orderTexyn;
    }

    /**
     * @param orderTexyn the orderTexyn to set
     */
    public void setOrderTexyn(String orderTexyn) {
        this.orderTexyn = orderTexyn;
    }

    /**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the licenseCode
	 */
	public String getLicenseCode() {
		return licenseCode;
	}

	/**
	 * @param licenseCode the licenseCode to set
	 */
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	/**
	 * @return the expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * @param expirationMonth the expirationMonth to set
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
     * @return the registerId
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId the registerId to set
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId;
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
     * @return the updateId
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId the updateId to set
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
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
     * @return the statusType
     */
    public int getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the ordererId
     */
    public String getOrdererId() {
        return ordererId;
    }

    /**
     * @param ordererId the ordererId to set
     */
    public void setOrdererId(String ordererId) {
        this.ordererId = ordererId;
    }

    /**
     * @return the ordererName
     */
    public String getOrdererName() {
        return ordererName;
    }

    /**
     * @param ordererName the ordererName to set
     */
    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    /**
     * @return the ordererEmail
     */
    public String getOrdererEmail() {
        return ordererEmail;
    }

    /**
     * @param ordererEmail the ordererEmail to set
     */
    public void setOrdererEmail(String ordererEmail) {
        this.ordererEmail = ordererEmail;
    }

    /**
     * @return the ordererTel
     */
    public String getOrdererTel() {
        return ordererTel;
    }

    /**
     * @param ordererTel the ordererTel to set
     */
    public void setOrdererTel(String ordererTel) {
        this.ordererTel = ordererTel;
    }

    /**
     * @return the ordererMobile
     */
    public String getOrdererMobile() {
        return ordererMobile;
    }

    /**
     * @param ordererMobile the ordererMobile to set
     */
    public void setOrdererMobile(String ordererMobile) {
        this.ordererMobile = ordererMobile;
    }

    /**
     * @return the ordererZipcode
     */
    public String getOrdererZipcode() {
        return ordererZipcode;
    }

    /**
     * @param ordererZipcode the ordererZipcode to set
     */
    public void setOrdererZipcode(String ordererZipcode) {
        this.ordererZipcode = ordererZipcode;
    }

    /**
     * @return the ordererAddr1
     */
    public String getOrdererAddr1() {
        return ordererAddr1;
    }

    /**
     * @param ordererAddr1 the ordererAddr1 to set
     */
    public void setOrdererAddr1(String ordererAddr1) {
        this.ordererAddr1 = ordererAddr1;
    }

    /**
     * @return the ordererAddr2
     */
    public String getOrdererAddr2() {
        return ordererAddr2;
    }

    /**
     * @param ordererAddr2 the ordererAddr2 to set
     */
    public void setOrdererAddr2(String ordererAddr2) {
        this.ordererAddr2 = ordererAddr2;
    }

    /**
     * @return the receiveNane
     */
    public String getReceiveNane() {
        return receiveNane;
    }

    /**
     * @param receiveNane the receiveNane to set
     */
    public void setReceiveNane(String receiveNane) {
        this.receiveNane = receiveNane;
    }

    /**
     * @return the receiveEmail
     */
    public String getReceiveEmail() {
        return receiveEmail;
    }

    /**
     * @param receiveEmail the receiveEmail to set
     */
    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    /**
     * @return the receiveTel
     */
    public String getReceiveTel() {
        return receiveTel;
    }

    /**
     * @param receiveTel the receiveTel to set
     */
    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    /**
     * @return the receiveMobile
     */
    public String getReceiveMobile() {
        return receiveMobile;
    }

    /**
     * @param receiveMobile the receiveMobile to set
     */
    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    /**
     * @return the receiveZipcode
     */
    public String getReceiveZipcode() {
        return receiveZipcode;
    }

    /**
     * @param receiveZipcode the receiveZipcode to set
     */
    public void setReceiveZipcode(String receiveZipcode) {
        this.receiveZipcode = receiveZipcode;
    }

    /**
     * @return the receiveAddr1
     */
    public String getReceiveAddr1() {
        return receiveAddr1;
    }

    /**
     * @param receiveAddr1 the receiveAddr1 to set
     */
    public void setReceiveAddr1(String receiveAddr1) {
        this.receiveAddr1 = receiveAddr1;
    }

    /**
     * @return the receiveAddr2
     */
    public String getReceiveAddr2() {
        return receiveAddr2;
    }

    /**
     * @param receiveAddr2 the receiveAddr2 to set
     */
    public void setReceiveAddr2(String receiveAddr2) {
        this.receiveAddr2 = receiveAddr2;
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
     * @return the opdRodId
     */
    public String getOpdRodId() {
        return opdRodId;
    }

    /**
     * @param opdRodId the opdRodId to set
     */
    public void setOpdRodId(String opdRodId) {
        this.opdRodId = opdRodId;
    }

    /**
     * @return the prdId
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * @param prdId the prdId to set
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    /**
     * @return the prodName
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the salePrice
     */
    public int getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return the cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
     * @return
     */
    public String[] getOptId() {
		return optId;
	}

	/**
	 * @param optId
	 */
	public void setOptId(String[] optId) {
		this.optId = optId;
	}

	/**
     * @return the productsVO
     */
    public List<ProductsVO> getProductsVO() {
        return productsVO;
    }

    /**
     * @param productsVO the productsVO to set
     */
    public void setProductsVO(List<ProductsVO> productsVO) {
        this.productsVO = productsVO;
    }

}
