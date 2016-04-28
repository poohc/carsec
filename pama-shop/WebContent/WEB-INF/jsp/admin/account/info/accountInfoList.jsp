<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account/info");
%>
<html>
<head>
<link rel="stylesheet" href="/common/css/jquery/themes/base/jquery.ui.all.css">
<script src="/common/js/jquery/ui/jquery.ui.core.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.widget.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript">

function statusProc(mbrId,level) {
	var title="";
	if(level==30){
		title="전문가";
	}else{
		title="정보원";
	}

	if(!confirm("["+title+"]으로 승인하시겠습니까!")){
		return;
	}
    var statusTypeChangeUrl = 'accountInfoApproval.do?mbrId='+mbrId+'&'+'requestLevel='+level+'&infoApproval=2';
    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.row == 1){
                    alert("승인되었습니다.");

                    $("#infoRow_" + mbrId ).remove();



                }else{
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
                }
            });
}

function goDetail(mbrId) {
	location.href="/admin/account/info/accountInfoDetail.do?mbrId="+mbrId;
}

//goSearch
function goAccountSearch(){
    var form = document.accountSearchForm;
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.accountSearchForm;
    form.pageNo.value = pageNo;
    form.submit();
}

$(function() {
    $( "#startRegisterDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#endRegisterDate" ).datepicker( { dateFormat: 'yy-mm-dd' } );
    $( "#startLoginDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#endLoginDate" ).datepicker( { dateFormat: 'yy-mm-dd' } );
});


</script>
</head>

<div class="title">정보원 리스트(TOTAL:${accountListVO.accountSearchVO.totalCount})</div>

<form name="accountSearchForm" method="get" autocomplete="off">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<input type="hidden" name="pageNo" value="${accountListVO.accountSearchVO.pageNo}" />
<table class="contents">
    <colgroup>
        <col width="20%"></col>
        <col width="80%"></col>
    </colgroup>
    <thead>

    </thead>
    <tbody>
        <tr>
            <td>
                <select name="searchColumn" id="searchColumn" style="width:100px;">
                    <option value="">선택</option>
                    <option value="email" ${accountListVO.accountSearchVO.searchColumn=='email'?'selected':'' }>아이디</option>
                    <option value="firstName" ${accountListVO.accountSearchVO.searchColumn=='firstName'?'selected':'' }>이름</option>
                </select>
                <input type="text" name="searchValue" value="${accountListVO.accountSearchVO.searchValue}" />
            </td>
        </tr>
    </tbody>
</table>
</form>
<div class="btn">
    <div class="btnFr"><a href="#;" onclick="goAccountSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a></div>
    <div style="clear: both"></div>
</div>
<br/>
<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="10%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="20%"></col>
        <col width="20%"></col>
        <col width="15%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>이름</th>
            <th>아이디</th>
            <th>정보원신청일</th>
            <th>신청서보기</th>
            <th>수정</th>
        </tr>
    </thead>



    <tbody>
        <c:forEach items="${accountListVO.accountList}" var="i" varStatus="iStatus">
            <tr id="infoRow_${i.mbrId}">
                <td>${accountListVO.accountSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td akug>${i.firstName}</td>
                <td>${i.mbrId}</td>
                <td>${i.registerDate}</td>
                <td align="center"><button type="button" onclick="goDetail('${i.mbrId}');">신청서</button></td>
                <td align="center"><button type="button" onclick="statusProc('${i.mbrId}','${i.accountInfoVO.requestLevel}');">${i.accountInfoVO.requestLevel=='30'?'전문가':'정보원'}승인</button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>



<!-- Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${accountListVO.accountSearchVO.totalCount}" />
    <jsp:param name="row" value="${accountListVO.accountSearchVO.row}" />
    <jsp:param name="page" value="${accountListVO.accountSearchVO.pageNo}" />
</jsp:include>

</html>