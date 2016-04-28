<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 견적</title>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class="on"><a href="/web/etc/estimate1_agency.do">요청받은 견적</a></li>
                <li class=""><a href="/web/etc/estimate2_agency.do">받은 예약건</a></li>
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
                    <col style="width:26%" />
                    <col style="width:12%" />
                    <col style="width:8%" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">견적요청일</th>
                        <th scope="col">차종</th>
                        <th scope="col">연식</th>
                        <th scope="col">주행거리</th>
                        <th scope="col">색상</th>
                        <th scope="col">증상</th>
                        <th scope="col">지역</th>
                        <th scope="col">닉네임</th>
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
                        <td>인천</td>
                        <td>닉네임</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="10" id="cont" name="cont" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>인천</td>
                        <td>닉네임</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="10" id="cont" name="cont" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>인천</td>
                        <td>닉네임</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="10" id="cont" name="cont" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>인천</td>
                        <td>닉네임</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="10" id="cont" name="cont" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>아우디 A5</td>
                        <td>2013</td>
                        <td>125,000</td>
                        <td>색상</td>
                        <td>미션 소음</td>
                        <td>인천</td>
                        <td>닉네임</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="10" id="cont" name="cont" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
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