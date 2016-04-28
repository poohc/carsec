<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 중고차</title>

</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub5/recruit.do">정비소 구인</a></li>
                <li class=""><a href="/web/sub5/recruit_write.do">구직등록</a></li>
                <li class="on"><a href="/web/sub5/usedcar.do">중고차 매매</a></li>
                <li class=""><a href="/web/sub5/usedcar_write.do">중고차 매물 등록</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <div class="usedcar_view">
                    <h1>현대 YF 소나타 Y20 프리미어 최고급형</h1>
                    <p class="writed_date">등록일 : <span>2015-07-17</span></p>
                    <ul>
                        <li>지역</li>
                        <li>제조사</li>
                        <li>모델</li>
                        <li>연식</li>
                        <li>주행거리</li>
                        <li>가격</li>
                        <li>색상</li>
                        <li>사고여부</li>
                    </ul>
                    <p class="detail_pic">상세사진</p>
                    <div class="img_gallery">
                        <div class="pic">
                            <a href=""><img src="/img/img_view.jpg" alt=""></a>
                            <a href=""><img src="/img/img_view_2.jpg" alt=""></a>
                            <a href=""><img src="/img/img_view_3.jpg" alt=""></a>
                            <a href=""><img src="/img/img_view_4.jpg" alt=""></a>
                        </div>
                        <div class="thum">
                            <img src="/img/img_view1.jpg" alt="">
                            <img src="/img/img_view1.jpg" alt="">
                            <img src="/img/img_view2.jpg" alt="">
                            <img src="/img/img_view3.jpg" alt="">
                        </div>
                    </div>
                    <dl class="detail_info">
                        <dt>상세설명</dt>
                        <dd>광택을 한 차량이라 내 외관이 깔끔합니다. <br>현금 구매는 물론 무보증 36개월 할부, 카드 결제 가능하십니다.</dd>
                    </dl>
                    <dl class="detail_info2">
                        <dt>매매자 정보</dt>
                        <dd>홍길동</dd>
                        <dd>010-1234-4565</dd>
                    </dl>
                </div>
                <a class="input_type6 align_center w_100" href="/web/sub5/usedcar.do">목 록</a>
            </div>
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                    <p class="names">홍길동 님</p>
                    <p class="car_name elipsis">람보르기니이탈리아</p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                    <a href="/web/sub1/check1.do" class="mycar a_style">내차</a>
                </div>
            </form>
            <div class="banner">
                <ul>
                    <li><a href="/web/sub1/check3.do"><img src="/img/self_banner.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub5/recruit.do"><img src="/img/self_banner2.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub1/check1.do"><img src="/img/self_banner3.jpg" alt="배너"></a></li>
                </ul>
            </div>
            <div class="shopping_channel">
                <p class="cs_title">carsec 쇼핑채널</p>
                <ul>
                    <li class="pd1"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd2"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd3"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd4"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd5"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
                    <li class="pd6"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
                </ul>
            </div>
        </div>
    </div>

<script>
$(".img_gallery .thum img").click(function(){
    var ti = $(this).index();
    $(".img_gallery .pic img").not(":eq("+ti+")").removeClass("ch").fadeOut(300);
    $(".img_gallery .pic img").eq(ti).addClass("ch").fadeIn(300);
    $(".img_gallery .thum img").not(":eq("+ti+")").removeClass("ch1");
    $(".img_gallery .thum img").eq(ti).addClass("ch1");
}).eq(0).click();
</script>

</body>
</html>