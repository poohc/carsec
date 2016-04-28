<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원정보</title>
<link rel="stylesheet" href="/common/jquery-ui-1.11.4.custom/jquery-ui.css">
<style type="text/css">
.ui-datepicker { width: 20em; padding: .2em .2em 0; display: none; }
.ui-datepicker .ui-datepicker-header { position:relative; padding:.2em 0; }
.ui-datepicker .ui-datepicker-prev, .ui-datepicker .ui-datepicker-next { position:absolute; top: 2px; width: 1.8em; height: 1.8em; }
/* .ui-datepicker .ui-datepicker-prev-hover, .ui-datepicker .ui-datepicker-next-hover { top: 1px; } */
.ui-datepicker .ui-datepicker-prev { left:2px; }
.ui-datepicker .ui-datepicker-next { right:2px; }
.ui-datepicker .ui-datepicker-prev-hover { left:1px; }
.ui-datepicker .ui-datepicker-next-hover { right:1px; }
.ui-datepicker .ui-datepicker-prev span, .ui-datepicker .ui-datepicker-next span { display: block; position: absolute; left: 50%; margin-left: -8px; top: 50%; margin-top: -8px;  }
.ui-datepicker .ui-datepicker-title { margin: 0 2.3em; line-height: 1.8em; text-align: center; }
.ui-datepicker .ui-datepicker-title select { font-size:1em; margin:1px 0; }
.ui-datepicker select.ui-datepicker-month-year {width: 100%;}
.ui-datepicker select.ui-datepicker-month,
.ui-datepicker select.ui-datepicker-year { width: 49%;}
.ui-datepicker table {width: 100%; font-size: .9em; border-collapse: collapse; margin:0 0 .4em; }
.ui-datepicker th { padding: .7em .3em; text-align: center; font-weight: bold; border: 0;  }
.ui-datepicker td { border: 0; padding: 1px; }
.ui-datepicker td span, .ui-datepicker td a { display: block; padding: .2em; text-align: right; text-decoration: none; }
.ui-datepicker .ui-datepicker-buttonpane { background-image: none; margin: .7em 0 0 0; padding:0 .2em; border-left: 0; border-right: 0; border-bottom: 0; }
.ui-datepicker .ui-datepicker-buttonpane button { float: right; margin: .5em .2em .4em; cursor: pointer; padding: .2em .6em .3em .6em; width:auto; overflow:visible; }
.ui-datepicker .ui-datepicker-buttonpane button.ui-datepicker-current { float:left; }

</style>
<script src="/common/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script>
$().ready(function() {
	// Datepicker
	$("input[name=visitDate]").datepicker({
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		dateFormat: "yy-mm-dd",
		showMonthAfterYear: true,
		changeYear: true,
		changeMonth: true,
		nextText:"",
		prevText:""

	});

});
</script>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
            	<li class=""><a href="/estimate/estimate.do?progressStatus=1">요청한 견적</a></li>
                <li class="on"><a href="/estimate/estimate.do?progressStatus=2">받은 견적</a></li>
                <li class=""><a href="/estimate/estimate.do?progressStatus=3">예약리스트</a></li>
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
                    <col style="width:auto" />
                    <col style="width:auto" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">받은 날짜</th>
                        <th scope="col">차종</th>
                        <th scope="col">증상</th>
                        <th scope="col">예상정비내역</th>
                        <th scope="col">예상견적제출</th>
                        <th scope="col">견적업체</th>
                    </tr>
                </thead>
                <tbody>
                 <c:forEach items="${carEstimateListVO.list}" var="i" varStatus="iStatus">
                    <tr class="item" id="estimateRow_${i.carEstimateId }">
                        <td>${fn:substring(i.estimateDate,0,10) }</td>
                        <td>${i.model }</td>
                        <td>${i.carCheckTitle }</td>
                        <td>${i.repairInfo }</td>
                        <td>${i.estimatePrice  }</td>
                        <td>${i.requestCompanyName}</td>
                    </tr>
                    <tr class="hide"  id="estimateRowForm_${i.carEstimateId }">
                        <td colspan="8" class="t_r">
                        <form>
                        <button type="button" class="button_type3" id="calendar">방문예정일</button>
                        <input type="hidden" name="carEstimateId" value="${i.carEstimateId }" />
                        <input type="text" name="visitDate" readonly="readonly" style="text-align: center;"/>
                        <button type="button" class="button_type3" onclick="modifyCarEstimateVisit(this.form)">방문접수하기</button>
                        </form>

                        </td>
                    </tr>
					</c:forEach>
                </tbody>
            </table>
<script>
function modifyCarEstimateVisit(form){

	carEstimateId = form.carEstimateId.value;

	if( form.visitDate.value==""){
		alert("방문예정일을 입력하세요.");
		form.visitDate.focus();
		return;
	}


	$.post( "modifyCarEstimateVisit.do", $(form).serialize() ,function( data ) {

		if(data.result==1){
			alert("방문접수가 완료했습니다.");
			$("#estimateRow_"+carEstimateId).remove();
			$("#estimateRowForm_"+carEstimateId).remove();
		}
	});
}
</script>

        </div>

         <div class="paging">
		<!-- //Paging -->
		<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
			<jsp:param name="count" value="${carEstimateListVO.carEstimateSearchVO.totalCount}" />
			<jsp:param name="row" value="${carEstimateListVO.carEstimateSearchVO.row}" />
			<jsp:param name="page" value="${carEstimateListVO.carEstimateSearchVO.pageNo}" />
		</jsp:include>
		<!-- Paging// -->
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