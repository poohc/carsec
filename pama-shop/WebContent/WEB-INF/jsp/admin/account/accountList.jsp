<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account");
%>
<html>
<head>
<link rel="stylesheet" href="/common/css/jquery/themes/base/jquery.ui.all.css">
<script src="/common/js/jquery/ui/jquery.ui.core.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.widget.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript">
<!--

function statusProc(mbrId,level) {
    var statusTypeChangeUrl = '/admin/account/modifyAccountLevel.do?mbrId='+mbrId+'&'+'level='+level;
    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.result == 'success')
                    alert("회원 레벨을 변경하였습니다.");
                else
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
            });
    return false;
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

//-->
</script>
</head>

<div class="title">회원 리스트(TOTAL:${accountListVO.accountSearchVO.totalCount})</div>

<div class="btn">
<!--     <div class="btnFl"><a href="/admin/account/accountForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div> -->
    <div style="clear: both"></div>
</div>

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
            <th>회원 검색</th>
            <td>
                <select name="searchColumn" id="searchColumn" style="width:100px;">
                    <option value="">선택</option>
                    <option value="mbrId" ${accountListVO.accountSearchVO.searchColumn=='mbrId'?'selected':'' }>아이디</option>
                    <option value="firstName" ${accountListVO.accountSearchVO.searchColumn=='firstName'?'selected':'' }>이름</option>
                    <option value="nickName" ${accountListVO.accountSearchVO.searchColumn=='nickName'?'selected':'' }>닉네임</option>
                </select>
                <input type="text" name="searchValue" value="${accountListVO.accountSearchVO.searchValue}" />
            </td>
        </tr>
<!--         <tr> -->
<!--             <th>회원분류</th> -->
<!--             <td> -->
<!--                 <select name='level'> -->
<!--                     <option value="">선택</option> -->
<%--                     <option value="10" ${accountListVO.accountSearchVO.level=='10'?'selected':'' }>일반회원</option> --%>
<%--                     <option value="30" ${accountListVO.accountSearchVO.level=='30'?'selected':'' }>전문가</option> --%>
<%--                     <option value="40" ${accountListVO.accountSearchVO.level=='40'?'selected':'' }>정보원</option> --%>
<%--                     <option value="90" ${accountListVO.accountSearchVO.level=='90'?'selected':'' }>관리자</option> --%>
<!--                 </select> -->
<!--             </td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--             <th>가입일</th> -->
<!--             <td> -->
<%--                 <input type="text" id="startRegisterDate" name="startRegisterDate" value="${accountListVO.accountSearchVO.startRegisterDate}" /> - --%>
<%--                 <input type="text" id="endRegisterDate" name="endRegisterDate" value="${accountListVO.accountSearchVO.endRegisterDate}" /> --%>
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startRegisterDate,document.accountSearchForm.endRegisterDate,0,0,0);">[오늘]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startRegisterDate,document.accountSearchForm.endRegisterDate,0,0,-7);">[일주일]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startRegisterDate,document.accountSearchForm.endRegisterDate,0,0,-15);">[15일]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startRegisterDate,document.accountSearchForm.endRegisterDate,0,-1,0);">[한달]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startRegisterDate,document.accountSearchForm.endRegisterDate,0,-2,0);">[2달]</a> -->
<!--             </td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--             <th>최근 접속일</th> -->
<!--             <td> -->
<%--                 <input id="startLoginDate" type="text" name="startLoginDate" value="${accountListVO.accountSearchVO.startLoginDate}" /> - --%>
<%--                 <input id="endLoginDate" type="text" name="endLoginDate" value="${accountListVO.accountSearchVO.endLoginDate}" /> --%>
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startLoginDate,document.accountSearchForm.endLoginDate,0,0,0);">[오늘]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startLoginDate,document.accountSearchForm.endLoginDate,0,0,-7);">[일주일]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startLoginDate,document.accountSearchForm.endLoginDate,0,0,-15);">[15일]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startLoginDate,document.accountSearchForm.endLoginDate,0,-1,0);">[한달]</a> -->
<!--                 <a href="#;" onclick="getCalculatedDate(document.accountSearchForm.startLoginDate,document.accountSearchForm.endLoginDate,0,-2,0);">[2달]</a> -->
<!--             </td> -->
<!--         </tr> -->
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
	<c:if test="${statusVal == 'out'}">
        <col width="5%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="auto"></col>
        <col width="8%"></col>
	</c:if>
	<c:if test="${statusVal != 'out'}">
    <colgroup>
        <col width="5%"></col>
        <col width="13%"></col>
        <col width="auto"></col>
        <col width="15%"></col>
        <col width="13%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="8%"></col>
    </colgroup>
	</c:if>

    <thead>
    <c:if test="${statusVal == 'out'}">
        <tr>
            <th class="first">No</th>
            <th>아이디</th>
            <th>탈퇴사유</th>
            <th>탈퇴사유</th>
            <th>회원분류</th>
        </tr>
    </c:if>
	<c:if test="${statusVal != 'out'}">
        <tr>
            <th class="first">No</th>
            <th>아이디</th>
            <th>이름</th>
            <th>닉네임</th>
            <th>회원분류</th>
            <th>가입일</th>
            <th>최근접속일</th>
            <th>방문수</th>
        </tr>
	</c:if>
    </thead>

    <tbody>
        <c:forEach items="${accountListVO.accountList}" var="i" varStatus="iStatus">
        	<c:if test="${statusVal == 'out'}">
        	<tr align="center">
        		<td>${accountListVO.accountSearchVO.pageStartIndex + 1 - iStatus.count}</td>
        		<td>${i.mbrId}</td>
        		<td>${fn:substring(i.memo,0,fn:indexOf(i.memo,","))}</td>
        		<td>${fn:substring(i.memo,fn:indexOf(i.memo,",")+1,fn:length(i.memo))}</td>
        		<td>
                	${i.level=='10'?'일반회원':'' }
                    ${i.level=='30'?'메카닉회원(대기)':'' }
                    ${i.level=='40'?'메카닉회원(승인)':'' }
                    ${i.level=='90'?'관리자':'' }
                </td>
        	</tr>
        	</c:if>
        	<c:if test="${statusVal != 'out'}">
            <tr align="center">
                <td>${accountListVO.accountSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td><a href="/admin/account/${accountType}/${statusVal}detail.do?mbrId=${i.mbrId}">${i.mbrId}</a></td>
                <td>${i.firstName}</td>
                <td>${i.nickName}</td>
                <td>
                	${i.level=='10'?'일반회원':'' }
                    ${i.level=='30'?'메카닉회원(대기)':'' }
                    ${i.level=='40'?'메카닉회원(승인)':'' }
                    ${i.level=='90'?'관리자':'' }

<%--                     <c:choose> --%>
<%--                         <c:when test="${i.level == '99'}">슈퍼 관리자</c:when> --%>
<%--                         <c:otherwise> --%>
<%--                             <select name='level' onChange="statusProc('${i.mbrId}',this.value)" > --%>
<%--                                 <option value="10" ${i.level=='10'?'selected':'' }>일반회원</option> --%>
<%--                                 <option value="30" ${i.level=='30'?'selected':'' }>전문가</option> --%>
<%--                                 <option value="40" ${i.level=='40'?'selected':'' }>정보원</option> --%>
<%--                                 <option value="90" ${i.level=='90'?'selected':'' }>관리자</option> --%>
<!--                             </select> -->
<%--                         </c:otherwise> --%>
<%--                     </c:choose> --%>
                </td>
                <td>${i.registerDate}</td>
                <td>${i.loginDate}</td>
                <td>${i.loginCount}</td>
            </tr>
            </c:if>
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