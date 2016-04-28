<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 이벤트</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub1/check1.do">내차SELF 점검</a></li>
                <li class=""><a href="/web/sub1/check3.do">차량부품 Map</a></li>
                <li class="on"><a href="/web/sub1/mechanic_search.do">협력정비업체</a></li>
            </ul>
            <div class="layout_type1">
                <dl class="event">
                    <dt>이벤트 공지</dt>
                    <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                </dl>
                <div class="write_search">
                    <form action="">
                        <div class="right_area">
                            <input type="text" title="제목/내용">
                            <button type="submit" class="btn_search" title="검색">검색</button>
                        </div>
                    </form>
           	    </div>
                <ul class="gallery_layout2">
                    <li class="on">
                        <a href="/web/sub1/mechanic_detail_view.do">
                            <img src="/img/mechanic_pic1.jpg" alt="bmw신차">
                            <div class="gallery_introbox">
                                <h1 class="elipsis">[메카닉회원 슬로건 가져옴]최고의 기술력을 가진 송도카센터입니다.</h1>
                                <p>[메카닉회원의 업체명] 송도카센터</p>
                                <p>메카닉 회원의 주소 가져옴]인천광역시 연수구 송도동 7-50 갯벌타워 시험생산동 311호<p>
                                <span>[정비품목을 가져옴]엔진정비 미션정비 타이어교체 정비</span><span>032-324-8382</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/web/sub1/mechanic_detail_view.do">
                            <img src="/img/mechanic_pic2.jpg" alt="bmw신차">
                            <div class="gallery_introbox">
                                <h1 class="elipsis">[메카닉회원 슬로건 가져옴]최고의 기술력을 가진 송도카센터입니다.</h1>
                                <p>[메카닉회원의 업체명] 송도카센터</p>
                                <p>메카닉 회원의 주소 가져옴]인천광역시 연수구 송도동 7-50 갯벌타워 시험생산동 311호<p>
                                <span>[정비품목을 가져옴]엔진정비 미션정비 타이어교체 정비</span><span>032-324-8382</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/web/sub1/mechanic_detail_view.do">
                            <img src="/img/mechanic_pic3.jpg" alt="bmw신차">
                            <div class="gallery_introbox">
                                <h1 class="elipsis">[메카닉회원 슬로건 가져옴]최고의 기술력을 가진 송도카센터입니다.</h1>
                                <p>[메카닉회원의 업체명] 송도카센터</p>
                                <p>메카닉 회원의 주소 가져옴]인천광역시 연수구 송도동 7-50 갯벌타워 시험생산동 311호<p>
                                <span>[정비품목을 가져옴]엔진정비 미션정비 타이어교체 정비</span><span>032-324-8382</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="/web/sub1/mechanic_detail_view.do">
                            <img src="/img/mechanic_pic4.jpg" alt="bmw신차">
                            <div class="gallery_introbox">
                                <h1 class="elipsis">[메카닉회원 슬로건 가져옴]최고의 기술력을 가진 송도카센터입니다.</h1>
                                <p>[메카닉회원의 업체명] 송도카센터</p>
                                <p>메카닉 회원의 주소 가져옴]인천광역시 연수구 송도동 7-50 갯벌타워 시험생산동 311호<p>
                                <span>[정비품목을 가져옴]엔진정비 미션정비 타이어교체 정비</span><span>032-324-8382</span>
                            </div>
                        </a>
                    </li>
                </ul>
	            <div class="paging"><!-- paging -->
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#" class="next">다음</a>
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