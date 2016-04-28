<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 쇼핑</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div id="container">
       <div class="sub_notice">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <!--form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                   <p class="names_box"><span class="names">홍길동님</span><span class="car_name elipsis"></span></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                </div>
            </form-->
        </div>
       <div class="img_gallery2">
            <div class="pic">
                <img src="/img/hospital1.jpg" alt="">
                <img src="/img/hospital2.jpg" alt="">
                <img src="/img/hospital3.jpg" alt="">
            </div>
            <div class="thum">
                <img src="/img/sonax_banner.jpg" alt="">
                <img src="/img/sonax_banner.jpg" alt="">
                <img src="/img/sonax_banner.jpg" alt="">
            </div>
        </div>
        
        <div class="content0">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub3/shopping1.do">병원</a></li>
                <li class=""><a href="/web/sub3/shopping2.do">뷰티샵</a></li>
                <li class="on"><a href="/web/sub3/shopping3.do">Culture</a></li>
            </ul>
            <div class="category">
               
              <div class="category_tit"><span>병원카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li class="on"><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop1">엔진정비</a></li>
                    <li><a href="#shop1">브레이크오일</a></li>
                    <li><a href="#shop1">벨트관련</a></li>
                    <li><a href="#shop1">하체부품 관련</a></li>
                    <li><a href="#shop1">타이밍벨트</a></li>
                </ul>
                <ul class="hospital_list type2">
                    <li><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop1">엔진정비</a></li>
                    <li><a href="#shop1">브레이크오일</a></li>
                    <li><a href="#shop1">벨트관련</a></li>
                    <li><a href="#shop1">하체부품 관련</a></li>
                    <li><a href="#shop1">타이밍벨트</a></li>
                </ul>
                </div>
            </div>
        </div>
        <div width=100%>
<p>1. 주문상품정보</p>
<table width="100%" border="1">
  <thead>
   <tr>
      <th>이미지</th>
      <th>상품정보</th>
      <th>옵션선택</th>
      <th>장비업체</th>
      <th>최종결제금액</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><a href="#"><img src="" /></a></td>
      <td>
          <ul>
             <li>상품번호 00000
             <li>상품명
             <li>상품가격 20000원
          <ul>
      </td>
      <td>
          <ul>
             <li>옵션1
             <li>+5000원
          <ul>
      </td>
      <td>
           <ul>
             <li>송도카센터
          <ul>
      </td>
      <td>
           <ul>
             <li>25000원
           <ul>
      </td>
    </tr>
  </tbody>
</table>
</br>
<p>2. 결제정보입력</p>
<hr />
 <table width="100%" border="1">
  <tbody>
    <tr>
      <td>신용카드 결제</td>
      <td>
       <input type="radio"  value="" />
       <label for="corporate">신용/체크카드</label></td>
      
    </tr>
    <tr>
      <td>온라인이체</td>
      <td>
       <input type="radio"   value="" />
       <label for="corporate">무통장입금</label>
       &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="radio"  value="" />
       <label for="corporate">실시간계좌이체</label>
       </td>
   </tr>
   <tr>
      <td>현금영수증신청</td>
      <td>
       <p><input type="radio"  value="" /><span>개인휴대폰번호</span> <input type="text"  value="01099998888"  /> </p>   
       <p><input type="radio"  value="" />
       <span>사업자번호</span> <input type="text"  value="130"  />-<input type="text"  value="87"  />-<input type="text"  value="890000"  /> </p>         
      </td>
   </tr>
  </tbody>
</table>
</br>
 <p><strong>입금은행</strong>&nbsp;&nbsp;&nbsp;&nbsp; 기업은행 1010 9393 444444</p>
 <p>입금자명은 주문자명과 동일해야 합니다.</p>
 </br>
<p>3. 구매자확인</p>
 <hr />
 <span ><strong>아이디</strong><span>/</span>carsec</span> &nbsp;&nbsp;&nbsp;&nbsp;
  <span ><strong>닉네임</strong><span>/</span>카섹</span> &nbsp;&nbsp;&nbsp;&nbsp;
  <span ><strong>휴대폰</strong><span>/</span>010-9999-9999</span>
  
<p>4. 결제하기</p>
<hr />
 <span ><strong>최종결제금액</strong><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>25000원</span><br>
<a href="/web/sub3/shopping_payment_complete.do"><input type="submit" value="결제하기" class="input_type4">
</div>
    </div>


<script>
$(".img_gallery2 .thum img").click(function(){
    var ti = $(this).index();
    $(".img_gallery2 .pic img").not(":eq("+ti+")").removeClass("ch").fadeOut(300);
    $(".img_gallery2 .pic img").eq(ti).addClass("ch").fadeIn(300);
    $(".img_gallery2 .thum img").not(":eq("+ti+")").removeClass("ch1");
    $(".img_gallery2 .thum img").eq(ti).addClass("ch1");
}).eq(0).click();
</script>

</body>
</html>