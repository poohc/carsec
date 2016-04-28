<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원정보</title>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class=""><a href="/web/etc/estimate1.do">요청한 견적</a></li>
                <li class=""><a href="/web/etc/estimate2.do">받은 견적</a></li>
                <li class="on"><a href="/web/etc/estimate2_1.do">예약리스트</a></li>
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
                    <col style="width:20%" />
                    <col style="width:24%" />
                    <col style="width:12%" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">예약일</th>
                        <th scope="col">차종</th>
                        <th scope="col">증상</th>
                        <th scope="col">예상정비내역</th>
                        <th scope="col">예상견적가</th>
                        <th scope="col">예약업체</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>미션 소음</td>
                        <td>미션을 교환하거나 오일교환</td>
                        <td>150,000</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">송도카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>미션 소음</td>
                        <td>미션을 교환하거나 오일교환</td>
                        <td>150,000</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">송도카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>미션 소음</td>
                        <td>미션을 교환하거나 오일교환</td>
                        <td>150,000</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">송도카센터</a></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>미션 소음</td>
                        <td>미션을 교환하거나 오일교환</td>
                        <td>150,000</td>
                        <td><a href="/web/sub1/mechanic_detail_view.do">송도카센터</a></td>
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