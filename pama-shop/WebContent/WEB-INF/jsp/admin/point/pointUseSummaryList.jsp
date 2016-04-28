<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goPage
function goPage(pageNo){
    var form = document.pointForm;
    form.pageNo.value = pageNo;
    form.submit();
}

function goSearch(){
    var form = document.searchForm;
    form.submit();
}

//]]>
</script>
</head>


	<div class="title">수익금 관리</div>
	<div class="btn">
	<form name="searchForm">
		판매월
			<select class="select" id="year" name="year">
			<c:forEach var="i" begin="2015" end="2030" step="1" varStatus="iStatus">
				<option value="${i}" <c:if test="${pointSearchVO.year==i}"> selected="selected"</c:if>>${i}년</option>
			</c:forEach>
			</select>
			<select class="select" id="month" name="month">
			<c:forEach var="i" begin="1" end="12" step="1" varStatus="iStatus">
				<option value="${i}" <c:if test="${pointSearchVO.month==i}"> selected="selected"</c:if>>${i}월</option>
			</c:forEach>
			</select>
</form>
	    <div class="btnFr"><a href="javascript:goSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a></div>
	    <div style="clear: right;"></div>
	</div>

	<div class="btn">
	정산금액 : ${pointSummaryTotalSettlPoint }
	</div>


	<table class="contents">
	    <colgroup>
	        <col width="10px"></col>
	        <col width=""></col>
	        <col width="200"></col>
	        <col width="70"></col>
	        <col width="70"></col>
	        <col width="70"></col>
	    </colgroup>

	    <thead>
	        <tr>
	            <th class="first">No</th>
	            <th>정보내용</th>
	            <th>총 판매수</th>
	            <th>총 판매금액</th>
	            <th>정산예정금액</th>
	            <th>정보원(정산률)</th>
	        </tr>
	    </thead>
	    <tbody>

	        <c:forEach items="${pointUseSummaryList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${iStatus.index+1}</td>
                <td align="center"><c:out value="${i.pointTitle}" /></td>
                <td align="center"><c:out value="${i.countPoint}" /></td>
                <td align="center"><fmt:formatNumber value="${i.sumPoint}" type="number" /></td>
                <td align="center"><fmt:formatNumber value="${i.settlPoint}" type="number" /></td>
                <td align="center"><c:out value="${i.messageRegisterId}" />(<fmt:formatNumber value="${i.infoSettlRates}"  type="percent" maxFractionDigits="6" />)</td>
            </tr>
	        </c:forEach>
	    </tbody>
	</table>