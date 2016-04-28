<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 자유게시판</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub4/mechanic1.do">신차</a></li>
                <li class=""><a href="/web/sub4/mechanic2.do">신기술</a></li>
                <li class=""><a href="/web/sub4/mechanic3.do">정비사례</a></li>
                <li class="on"><a href="/web/sub4/recruit.do">구인정보</a></li>
                <li class=""><a href="/web/sub4/mechanic5.do">매장매매</a></li>
                <li class=""><a href="/web/sub4/mechanic6.do">업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">중고부품 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <ul class="recuit_list">
                    <li class="type1">지역명</li>
                    <li class="type2">경력게시</li>
                    <li class="type3">구인제목 게시</li>
                    <li class="type4">정비업체명 게시</li>
                    <li class="type5">날짜 게시</li>
                </ul>
                <p class="recruit_detail">
                    정비직원 급구 0명 경력자우대 09~18시(토15시) <br>급여면접후결정 4대보험,명절상여,공휴일휴무 이력서지참(방문면접) <br>삼성동 000-0번지 「OO정비소」
                </p>
                <a href="/web/sub5/recruit.do" class="input_type6 align_center w_57">목 록</a>


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
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">예약<em>2</em></a></li>
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


</body>
</html>