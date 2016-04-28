<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec

::: 쇼핑</title>
</head>
<body>
<!-- contain -->
<div id="container">
  <div class="sub_notice">
    <ul class="system_notice">
      <li class="on"><a href="#">공지사항</a></li>
      <li class=""><a href="#">시스템 작업 공지</a></li>
    </ul>
  </div>
  <!--주문서-->
  <div class="content5">
      <div class="order_header">
      <h2 class="order_header_tit">주문서입력</h2>
      <ul>
      <li class="order_bt01 on">01. 장바구니</li>
       <li class="order_bt02">02. 주문서</li>
        <li class="order_bt03">03. 주문완료</li>
      </ul>
      </div>
      <!--1. 주문상품정보-->
      <div class="order_info">
      <h3 class="order_info_tit">1. 주문상품정보</h3>
      <table cellspacing="0" class="tb_products">
      <caption>
      주문상품정보
      </caption>
      <colgroup>
      <col width="*">
      <col width="150">
      <col width="150">
  
      <col width="150">
      <col>
      </colgroup>
      <thead>
        <tr>
          <th scope="col" class="product">상품정보</th>
          <th scope="col">옵션선택</th>
          <th scope="col">정비업체</th>
          <th scope="col" class="col_price">최종결제금액</th>
        </tr>
      </thead>
      <tbody>
        <tr >
          <td><span class="bdr"></span>
            <div class="product_info"> <a href="#" class="product_thmb" target="_blank" >
            <img src="https://order.pay.naver.com/proxy/phinf/shop1/20150807_40/showindowCommon_1438905590113CGX1J_JPEG/2755606548135532_407238256.jpg?type=m120" alt="인디언 수술 원피스"> </a>
              <div class="product_dsc"> 
              <p class="product_d">상품번호:000000</p> 
              <a href="#" target="_blank" class="product_name" >
              <strong>상품명</strong></a> 
              <p>상품가격<em>20,000원</em></p> </div>
            </div></td>
          <td rowspan="1"><div class="option"> <span class="ico_option">옵션1</span>
              <ul class="option_list">
                <li>+5000원</li>
              </ul>
            </div></td>
          <td rowspan="1"><span class="deli_fee">송도카센터</span></td>
          <td class="col_price"><strong><em >22,000</em>원</strong></td>
        </tr>
      </tbody>
    </table>
    </div>
    <!--//1. 주문상품정보-->
     <!--2. 결제정보 입력-->
     <div class="payment_wrap">
    <div class="payment_info">
      <h3 class="order_info_tit">2.결제정보 입력</h3>
      <div class="payment">
        <div >
          <ul class="tab_payment" >
            <li class="payment_method"><span>신용 / 체크카드</span>
              <input type="radio">
              <label>신용 / 체크카드</label>
            </li>
            <li class="payment_method"><span>온라인이체</span>
              <input type="radio" alt="무통장입금">
              <label>무통장입금</label>
              <input type="radio" alt="실시간계좌이체">
              <label>실시간계좌이체</label>
            </li>
          </ul>
        </div>
        <div class="bank_name" > <span>입금은행</span> <strong>기업은행 1010-9393-00000000(주)디에우로파</strong>
          <p>입금자명은 주문자명과 동일해야합니다. </p>
        </div>
      </div>
    </div>
  </div>
      <!--//2. 결제정보 입력-->
      <!--3. 구매자 확인-->
      <div class="userinfo_wrap">
    <h3 class="order_info_tit">3.구매자 확인</h3>
    <ul class="user_info">
      <li><strong>아이디 :</strong>car</li>
      <li><strong>닉네임 :</strong>닉네임</li>
      <li><strong>휴대폰 :</strong>011-3**-3**7</li>
    </ul>
  </div>
       <!--//3. 구매자 확인-->
       <!--4. 결제하기-->
       <div class="price_wrap">
        <h3 class="order_info_tit">4.결제하기</h3>
        <div class="price_sum">
   
    <div class="lasttotal"><strong>총 결제금액</strong><em >25,000</em><span class="txt">원</span></div>
  </div>
  </div>
       <!--//4. 결제하기-->
       <div class="orderbt_wrap"><span><a href="/web/sub3/order_last.do" class="btn_type1">결제하기</a></span><span><a href="#" class="btn_type2">취소하기</a></span></div>
  </div>
  <!--//주문서-->
</div>
</body>
</html>