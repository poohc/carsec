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
                <li class="on"><a href="/web/sub2/library1.do">자유게시판</a></li>
                <li class=""><a href="/web/sub2/library2.do">사고관련 게시판</a></li>
                <li class=""><a href="/web/sub2/library3.do">신차</a></li>
                <li class=""><a href="/web/sub2/library4.do">리콜</a></li>
                <li class=""><a href="/web/sub2/library5.do">자동차검사</a></li>
                <li class=""><a href="/web/sub2/library6.do">교통법&벌금</a></li>
                <li class=""><a href="/web/sub2/library7.do">드라이브코스</a></li>
                <li class=""><a href="/web/sub2/library8.do">자동차와 사람</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/board_img.jpg" alt="자동차관련 글 게시판입니다."></p>
                <dl class="event">
                    <dt>이벤트 공지</dt>
                    <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                </dl>
                <form action="library1.do">
                    <div class="board_write3">
                        <div class="board_write3">
                        <table>
                            <caption>사고관련게시판 글쓰기</caption>
                            <colgroup>
                                <col style="width:10%">
                                <col style="width:25%">
                                <col style="width:10%">
                                <col style="width:45%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><label for="author">작성자</label></th>
                                    <th class="t_l" colspan="3"><span class="enter_st enter_st3"><input type="text" id="author" title="작성자"></span></th>
                                </tr>
                                <tr>
                                    <th><label for="title">제목</label></th>
                                    <th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" class="title" title="제목"></span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td colspan="4"><div class="textedit">텍스트에디트 들어가는곳.</div></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    </div>
                    <div class="btn_right">
                        <button type="submit" class="button_type1">목록</button>
                        <button type="submit" class="button_type2">등록하기</button>
                    </div>
                </form>

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
                    <p class="car_name elipsis"></p>
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