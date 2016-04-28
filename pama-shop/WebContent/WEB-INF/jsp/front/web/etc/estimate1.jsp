<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원정보</title>
</head>
<body>
    <!-- contain -->
    <div class="header_etc mb_0">
        <div class="wrap_header2">
            <p class="welcome_member"><span>홍길동</span>&nbsp;&nbsp;회원님 반갑습니다!</p>
            <ul class="information_list">
                <li><a href="/web/etc/password.do">회원정보 수정</a></li>
                <li class="on"><a href="/web/etc/estimate1.do">견적</a></li>
                <li><a href="/web/etc/coupon1.do">쿠폰</a></li>
                <li><a href="/web/etc/qna.do">1:1문의</a></li>
                <li class=""><a href="/web/etc/unregister.do">회원탈퇴</a></li>
            </ul>
        </div>
    </div>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class="on"><a href="/web/etc/estimate1.do">요청한 견적</a></li>
                <li class=""><a href="/web/etc/estimate2.do">받은 견적</a></li>
                <li class=""><a href="/web/etc/estimate2_1.do">예약리스트</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="board_list3"><!-- board_list -->
            <table class="acodian">
                <caption>견적 게시판</caption>
                <colgroup>
                    <col style="width:10%" />
                    <col style="width:18%" />
                    <col style="width:8%" />
                    <col style="width:10%" />
                    <col style="width:26%" />
                    <col style="width:12%" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">견적요청일</th>
                        <th scope="col">차종</th>
                        <th scope="col">연식</th>
                        <th scope="col">주행거리</th>
                        <th scope="col">증상</th>
                        <th scope="col">견적요청업체</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>미션 소음</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">송도카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>미션 소음</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">부평카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>미션 소음</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">판교카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>미션 소음</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">분당카센터</a></td>
                    </tr>
                </tbody>
            </table>
        </div><!-- //board_list -->
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
</body>
</html>