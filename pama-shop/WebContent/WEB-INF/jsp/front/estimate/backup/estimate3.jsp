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
                <li class="on"><a href="/web/etc/estimate1.do">요청한 견적</a></li>
                <li class=""><a href="/web/etc/estimate2.do">받은 견적</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="board_list3"><!-- board_list -->
            <table class="acodian">
                <caption>견적 게시판</caption>
                <colgroup>
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:auto" />
                    <col style="width:12%" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">받은 날짜</th>
                        <th scope="col">차종</th>
                        <th scope="col">연식</th>
                        <th scope="col">미션</th>
                        <th scope="col">문의 방법</th>
                        <th scope="col">증상</th>
                        <th scope="col">조치</th>
                        <th scope="col">예상견적</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>자동/수동</td>
                        <td>SELF진단 후</td>
                        <td>미션 소음</td>
                        <td>미션오일 교환</td>
                        <td>150,000</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="t_r"><button type="submit" class="button_type3" id="calendar">방문예정일</button><input type="text" id="calendar" title="제목/내용"><button type="submit" class="button_type3">방문접수하기</button></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>자동/수동</td>
                        <td>SELF진단 후</td>
                        <td>미션 소음</td>
                        <td>미션오일 교환</td>
                        <td>150,000</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="t_r"><button type="submit" class="button_type3" id="calendar">방문예정일</button><input type="text" id="calendar" title="제목/내용"><button type="submit" class="button_type3">방문접수하기</button></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>자동/수동</td>
                        <td>SELF진단 후</td>
                        <td>미션 소음</td>
                        <td>미션오일 교환</td>
                        <td>150,000</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="t_r"><button type="submit" class="button_type3" id="calendar">방문예정일</button><input type="text" id="calendar" title="제목/내용"><button type="submit" class="button_type3">방문접수하기</button></td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>자동/수동</td>
                        <td>SELF진단 후</td>
                        <td>미션 소음</td>
                        <td>미션오일 교환</td>
                        <td>150,000</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="t_r"><button type="submit" class="button_type3" id="calendar">방문예정일</button><input type="text" id="calendar" title="제목/내용"><button type="submit" class="button_type3">방문접수하기</button></td>
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

<script>
/**********************************************************************************/
// 아코디언
/**********************************************************************************/
$(function(){
    var article = (".acodian .show");
    $(".acodian .item  td").click(function() {
        var myArticle =$(this).parents().next("tr");
        if($(myArticle).hasClass('hide')) {
            $(article).removeClass('show').addClass('hide');
            $(myArticle).removeClass('hide').addClass('show');
        }
        else {
            $(myArticle).addClass('hide').removeClass('show');
        }
    });
});
</script>

</body>
</html>