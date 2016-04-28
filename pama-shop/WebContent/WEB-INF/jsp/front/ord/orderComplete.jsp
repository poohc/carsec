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
  <div class="content5 order_last">
      <div class="order_header">
      <h2 class="order_header_tit">주문서입력</h2>
      <ul>
      <li class="order_bt01 on">01. 장바구니</li>
       <li class="order_bt02">02. 주문서</li>
        <li class="order_bt03">03. 주문완료</li>
      </ul>
      </div>
      <p class="order_txt">정비 쿠폰 주문이 완료되었습니다.</p>
      <!--1. 주문상품정보-->
      <div class="order_info ">
      
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
          <th scope="col">쿠폰번호</th>
          <th scope="col">정비업체</th>
          <th scope="col" class="col_price">최종결제금액</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${orderVO.productsVO}" var="productsList" varStatus="productsCount">
        <tr >
          <td><span class="bdr"></span>
            <div class="product_info last_info"> 
            <a href="#" class="product_thmb" target="_blank" >
            <img src="/media/${productsList.fileName}.image" alt="" width="80px" height="100px"> </a>
              <div class="product_dsc"> 
              <p class="product_d">상품번호:${productsList.prdId}</p> 
               <strong>${productsList.prdName}</strong> 
              </div>
            </div></td>
          <td class="cupon_d">CAE00000000</td>
          <td ><span class="deli_fee">${productsList.firstName}</span></td>
          <td class="col_price"><strong><em ><fmt:formatNumber value="${productsList.salePrice}" type="number" /></em>원</strong></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    <!--//1. 주문상품정보-->
     
       <!--주의사항 문구-->
       <div class="warning_bx">
    <div class="warning_txt"><strong>쿠폰 이용 주의사항</strong>
    <p>쿠폰이용 주의사항 내용</p></div>

  </div>
       <!--//4. 결제하기-->
       <div class="orderbt_wrap"><span><a href="#" class="btn_type1">쿠폰함</a></span></div>
  </div>
  <!--//주문서-->
</div>
</body>
</html>