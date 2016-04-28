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
            	<li class="on"><a href="/estimate/estimate.do?progressStatus=1">요청받은 견적</a></li>
                <li class=""><a href="/estimate/estimate.do?progressStatus=2">요청한 견적</a></li>
                <li class=""><a href="/estimate/estimate.do?progressStatus=3">받은 예약</a></li>
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
                        <th scope="col">닉네임</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${carEstimateListVO.list}" var="i" varStatus="iStatus">
                    <tr class="item" id="estimateRow_${i.carEstimateId }">
                        <td>${fn:substring(i.requestDate,0,10) }</td>
                        <td>${i.model }</td>
                        <td>${i.carYear}</td>
                        <td>${i.distance}</td>
                        <td>${i.mission}</td>
                        <td>${i.carCheckTitle }</td>
                        <td>${i.requestNickname}</td>
                    </tr>
                    <tr class="hide"  id="estimateRowForm_${i.carEstimateId }">
                        <td colspan="8" class="">
                            <p class="text_type2">정비내용</p>
                            <form>
                            <input type="hidden" name="carEstimateId" value="${i.carEstimateId }" />
                            <textarea rows="10" cols="10" id="cont" name="repairInfo" class="mechanic_text"></textarea><br>
                            <label for="expect" class="expect_label">예상견적</label>
                            <input type="text" name="estimatePrice" id="expect" class="input_type2">
                            <button type="button" class="button_type3" id="calendar" onclick="modifyCarEstimatePrice(this.form);">견적 제출</button>
                            </form>
                        </td>
                    </tr>
                 </c:forEach>

                </tbody>
            </table>
        </div>
<script>
function modifyCarEstimatePrice(form){
	carEstimateId = form.carEstimateId.value;

	if( form.repairInfo.value==""){
		alert("정비내용을 입력하세요.");
		form.repairInfo.focus();
		return;
	}

	if( form.estimatePrice.value==""){
		alert("예상견적 금액을 입력하세요.");
		form.estimatePrice.focus();
		return;
	}


	$.post( "modifyCarEstimatePrice.do", $(form).serialize() ,function( data ) {
		if(data.result==1){
			alert("견적요청을 완료했습니다.");
			$("#estimateRow_"+carEstimateId).remove();
			$("#estimateRowForm_"+carEstimateId).remove();
		}
	});
}
</script>

        <div class="paging">
		<!-- //Paging -->
		<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
			<jsp:param name="count" value="${carEstimateListVO.carEstimateSearchVO.totalCount}" />
			<jsp:param name="row" value="${carEstimateListVO.carEstimateSearchVO.row}" />
			<jsp:param name="page" value="${carEstimateListVO.carEstimateSearchVO.pageNo}" />
		</jsp:include>
		<!-- Paging// -->
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