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

function statusProc(infoApproval) {


	//$("#checkedIds")

	var params=$("input[name='checkedIds']:checked").serialize();

	var title="";
	if(infoApproval==0){
		title="활동정지";
	}else{
		title="승인";
	}

	if(!confirm(title+" 하시겠습니까?")){
		return;
	}
	var jsonURL = 'accountInfoApproval2.do?infoApproval='+infoApproval;

    $.getJSON(jsonURL, params, function(data) {
          if(data.row > 0) {
        	  $("input[name='checkedIds']:checked").each(function(i){
                  $(  "#status_"+$(this).val()  ).html(title);
             });
          }
     });


}
// function removeProc() {


// 	//$("#checkedIds")

// 	var params=$("input[name='checkedIds']:checked").serialize();

// 	if(!confirm("강제탈퇴 하시겠습니까?\n일반회원:네임카드삭제")){
// 		return;
// 	}
// 	var jsonURL = 'removeAccountInfo.do?infoApproval='+infoApproval;

//     $.getJSON(jsonURL, params, function(data) {
//           if(data.row > 0) {
//         	  $("input[name='checkedIds']:checked").each(function(i){
//                   $(  "#status_"+$(this).val()  ).html(title);
//              });
//           }
//      });


// }

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

//전체체크
function checkAll(){
	if($("#allCheckBox").is(':checked')){
		$("input[name='checkedIds']").attr("checked",true);
	}else{
		$("input[name='checkedIds']").attr("checked",false);
	}
}


</script>
</head>

<div class="title">정보원 리스트(TOTAL:${accountListVO.accountSearchVO.totalCount})</div>

<form name="accountSearchForm" method="get" autocomplete="off">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<input type="hidden" name="pageNo" value="${accountListVO.accountSearchVO.pageNo}" />
<table class="contents">
    <colgroup>
        <col width="80%"></col>
        <col width="20%"></col>
    </colgroup>
    <thead>

    </thead>
    <tbody>
        <tr>
            <td width>
                <select name="searchColumn" id="searchColumn" style="width:100px;">
                    <option value="">선택</option>
                    <option value="mbrId" ${accountListVO.accountSearchVO.searchColumn=='mbrId'?'selected':'' }>아이디</option>
                    <option value="firstName" ${accountListVO.accountSearchVO.searchColumn=='firstName'?'selected':'' }>이름</option>
                </select>
                <input type="text" name="searchValue" value="${accountListVO.accountSearchVO.searchValue}" />
            </td>
            <td>
            <a href="#;" onclick="goAccountSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
            </td>
        </tr>
    </tbody>
</table>
</form>
<br />

<div class="btn">
<button onclick="statusProc(0);">활동정지</button>
<!-- <button onclick="removeProc();">강제탈퇴</button> -->
<button onclick="statusProc(2);">활동정지 해제</button>
</div>

<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="10%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first"><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />All</th>
            <th>이름(아이디)</th>
            <th>가입일</th>
            <th>최종방문일</th>
            <th>방문수</th>
            <th>정보등록수</th>
            <th>덧글수</th>
            <th>상태</th>
        </tr>
    </thead>


    <tbody>
        <c:forEach items="${accountListVO.accountList}" var="i" varStatus="iStatus">

            <tr>
                <td align="center"><input type="checkbox" name="checkedIds" value="${i.mbrId}" /> ${accountListVO.accountSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td align="center">
                <a href="accountInfoForm.do?mbrId=${i.mbrId}">${i.firstName}(${i.mbrId})</a>
                </td>
                <td align="center">${fn:substring(i.registerDate,0,10)}</td>
                <td align="center">${fn:substring(i.loginDate,0,10)}</td>
                <td align="center">${i.loginCount}</td>
                <td align="center">${i.accountStatVO.messageCount}</td>
                <td align="center">${i.accountStatVO.commentCount}</td>
                <td align="center" id="status_${i.mbrId}">
                <c:choose>
                	<c:when test="${i.accountInfoVO.infoApproval==0}">활동정지</c:when>
                	<c:when test="${i.accountInfoVO.infoApproval==2}">승인</c:when>
                </c:choose>
                </td>
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