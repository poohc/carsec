<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class="on"><a href="/web/sub1/check1.do">내차SELF 점검</a></li>
                <li class=""><a href="/web/sub1/check3.do">차량부품 Map</a></li>
                <li class=""><a href="/web/sub1/mechanic_search.do">협력정비업체</a></li>
            </ul>
            <p>회원님의 차량의 문제점을 선택하시면 셀프점검 페이지로 이동합니다.</p><br><br><br>
            <ul>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_01.png">엔진이 힘들게 돌아가고 계기판 불이....(확인 후 지워주세요)</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_02.png">정차시에만 소음이...</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_03.png">차량의 엔진 타입은</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_04.png">엔진의 힘이 떨어졌나요?</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_05.png">본넷에서 연기가 납니까?</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_06.png">에어컨/히터 작동시 냄새?</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_07.png">출력도 떨어졌나요?</a></li>
                <li><a href="/web/sub1/check2.do"><img src="/img/icon_08.png">누유된 기름의 색상이 검정색</a></li>
            </ul>
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                     <p class="names_box"><span class="names">홍길동 님</span><span class="car_name elipsis"></span></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                </div>
            </form>
            <div class="epilogue_banner"><a href="#"><i class="fa fa-pencil-square-o"></i> 셀프진단 정비후기</a></div>
            <ul class="use_epilogue">
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
            </ul>
            <div class="epilogue_banner event_intro"><a href="#"><i class="fa fa-pencil-square-o"></i> 이벤트안내</a></div>
            <ul class="use_epilogue type2">
                <li><a href="#">[EVENT]워셔액 증정 이벤트</a></li>
                <li><a href="#">[EVENT]워셔액 증정 이벤트</a></li>
            </ul>
            <div class="banner">
                <ul>
                    <li><a href="/web/sub1/check3.do"><img src="/img/self_banner.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub5/recruit.do"><img src="/img/self_banner2.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub1/check1.do"><img src="/img/self_banner3.jpg" alt="배너"></a></li>
                </ul>
            </div>

        </div>
        <div class="event_search2">
            <dl class="event">
                <dt>이벤트 공지</dt>
                <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
            </dl>
        </div>
    </div>
</body>
</html>