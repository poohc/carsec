<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 메카닉</title>

</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub4/mechanic1.do">신차</a></li>
                <li class=""><a href="/web/sub4/mechanic2.do">신기술</a></li>
                <li class=""><a href="/web/sub4/mechanic3.do">정비사례</a></li>
                <li class="on"><a href="/web/sub4/mechanic5.do">매장매매</a></li>
                <li class=""><a href="/web/sub4/mechanic6.do">업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">정비외 업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">중고부품 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <div class="usedcar_view">
                    <h1>현대 YF 소나타 Y20 프리미어 최고급형</h1>
                    <p class="writed_date">등록일 : <span>2015-07-17</span></p>
                    <ul class="mb_20">
                        <li>지역:  서울시 노원구 상계동</li>
                        <li>현업종 : 세차</li>
                        <li>보증금 : 1000</li>
                        <li>월세 : 100</li>
                        <li>권리금 : 500</li>
                    </ul>
                    <p class="text_type1">본문 내용</p>
                </div>
                <a class="input_type6 align_center w_100" href="/web/sub4/mechanic5.do">목 록</a>
            </div>
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">메카닉회원</p>
                    <p class="names">송도카센터</p>
                    <p class="car_name elipsis"></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1_agency.do">견적요청<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2_agency.do">예약건<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/coupon1_agency.do">쿠폰업무<em>1</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
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