<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 예약관리</title>
</head>
<body>
    <div id="container">
        <ul class="esti_list">
            <li>견적요청<span>5</span></li>
            <li>보낸견적<span>2</span></li>
            <li>정비예약<span>2</span></li>
        </ul>
        <div class="board_list3"><!-- board_list -->
            <table class="acodian">
                <caption>견적 게시판</caption>
                <colgroup>
                    <col style="width:18%" />
                    <col style="width:18%" />
                    <col style="width:18%" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">예약일</th>
                        <th scope="col">아이디</th>
                        <th scope="col">증상</th>
                        <th scope="col">정비내용</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>CARSEC</td>
                        <td>타이밍 벨트 손상</td>
                        <td>타이밍 벨트 교체</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="4" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="30" id="cont" name="cont" class="mechanic_text"></textarea>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>CARSEC</td>
                        <td>타이밍 벨트 손상</td>
                        <td>타이밍 벨트 교체</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="4" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="30" id="cont" name="cont" class="mechanic_text"></textarea>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>CARSEC</td>
                        <td>타이밍 벨트 손상</td>
                        <td>타이밍 벨트 교체</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="4" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="30" id="cont" name="cont" class="mechanic_text"></textarea>
                            <label for="expect" class="expect_label">예상견적</label><input type="text" id="expect" class="input_type2"><button type="submit" class="button_type3" id="calendar">견적 제출</button>
                        </td>
                    </tr>
                    <tr class="item">
                        <td>2015-06-10</td>
                        <td>CARSEC</td>
                        <td>타이밍 벨트 손상</td>
                        <td>타이밍 벨트 교체</td>
                    </tr>
                    <tr class="hide">
                        <td colspan="4" class="">
                            <p class="text_type2">정비내용</p>
                            <textarea rows="10" cols="30" id="cont" name="cont" class="mechanic_text"></textarea>
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
            <p class="incont">견적 제출에 대한 안내 문구</p>
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