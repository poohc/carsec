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
                <li class=""><a href="/bbs/company3/messageList.do">협력정비업체</a></li>
            </ul>
            <div class="start_selfservice">
                <div class="event_area"><img src="/img/event_img.png" alt="self견적을 받고 견적 의뢰를 하면 추첨을 통하여 선물을 드립니다."></div>
                <div class="self_start">
                    <a class="start_self" href="/web/sub1/check1_1.do"><img src="/img/bt_self.png" alt="셀프진단시작"></a>
                </div>
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
        <div id="sidetab">
            <ul class="sidetab">
                <li><a href="#">카섹의<span>셀프점검</span></a></li>
                <li><a href="#">자동차의<span>모든부품정보</span></a></li>
            </ul>
        </div>
        <div id="sidetab2">
            <p class="point_title">POINT</p>
            <p class="point_title2">99,000</p>
            <p class="point_title3">게시판에 댓글을 남기면 <span>워셔액 포인트</span>를 드립니다.</p>
        </div>
    </div>

    <!-- 탑 버튼입니다<div id="sidetab3">
        <a href="#header"><img src="/img/top_button.png" alt=""></a>
    </div> -->
</body>
</html>