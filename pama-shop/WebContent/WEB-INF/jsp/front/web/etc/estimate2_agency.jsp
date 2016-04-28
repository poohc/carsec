<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 견적</title>
</head>
<body>
    <!-- contain -->
    <div class="header_etc mb_0">
        <div class="wrap_header2">
            <p class="welcome_member">송도카센터</p>
            <ul class="information_list">
                <li class="on"><a href="/web/etc/estimate1_agency.do">견적</a></li>
                <li class=""><a href="/web/etc/coupon1_agency.do">쿠폰 사용처리</a></li>
                <li><a href="/web/etc/qna_agency.do">1:1문의</a></li>
            </ul>
        </div>
    </div>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class=""><a href="/web/etc/estimate1_agency.do">요청받은 견적</a></li>
                <li class="on"><a href="/web/etc/estimate2_agency.do">받은 예약건</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="board_list3"><!-- board_list -->
            <table class="acodian">
                <caption>견적 게시판</caption>
                <colgroup>
                    <col style="width:10%" />
                    <col style="width:16%" />
                    <col style="width:8%" />
                    <col style="width:8%" />
                    <col style="width:auto" />
                    <col style="width:18%" />
                    <col style="width:8%" />
                    <col style="width:8%" />
                    <col style="width:8%" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">예약일</th>
                        <th scope="col">차종</th>
                        <th scope="col">연식</th>
                        <th scope="col">주행거리</th>
                        <th scope="col">색상</th>
                        <th scope="col">증상</th>
                        <th scope="col">예상견적</th>
                        <th scope="col">닉네임</th>
                        <th scope="col">연락처</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>990,000</td>
                        <td>홍길동</td>
                        <td>01099448282</td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>990,000</td>
                        <td>홍길동</td>
                        <td>01099448282</td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>990,000</td>
                        <td>홍길동</td>
                        <td>01099448282</td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>990,000</td>
                        <td>홍길동</td>
                        <td>01099448282</td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>990,000</td>
                        <td>홍길동</td>
                        <td>01099448282</td>
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
        <div class="textbox_type1">
            <p class="intitle">TIP!</p>
            <p class="incont"></p>
        </div>

    </div>

</body>
</html>