<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account/info");
%>
<html>
<head>
<script type="text/javascript">
<!--

//goForm
function goAccountForm(id){
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action="./accountInfoForm.do";
    form.submit();
}

function goList() {
    var form = document.accountForm;
    var listReturnURL = form.listReturnURL.value;
    if (listReturnURL!="") {
        location.href = listReturnURL;
    } else {
        location.href = "accountInfoList.do";
    }
}

function goAccountRemoveForm(id){
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action = "/admin/account/accountRemoveForm.do";
    form.submit();
}

function goOrderList(id) {
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action = "/admin/account/order/orderList.do";
    form.submit();
}
//-->
</script>
</head>

<div class="title">정보원 상세 보기</div>

<form name="accountForm" method="get">
    <input type="hidden" name="mbrId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>

<br/>
<br/>
<b>기본정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
        <th>이름</th>
        <td>${accountVO.firstName}</td>
        <th>아이디</th>
        <td>${accountVO.mbrId}</td>
    </tr>
    <tr>
        <th>닉네임</th>
        <td>${accountVO.nickname}</td>
        <th>생년월일</th>
        <td>${accountVO.birth}</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${accountVO.email}</td>
        <th>성별</th>
        <td>${accountVO.mobile=='m'?'남자':'여자'}</td>
    </tr>
    <tr>
        <th>핸드폰</th>
        <td>${accountVO.mobile}</td>
        <th> </th>
        <td> </td>
    </tr>
</table>
<br/>
<br/>

<b>정보원 신청 정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>

    <tr>
        <th>사진</th>
        <td colspan="3"><img src="/media/${accountVO.accountInfoVO.mbrImage}.image" width="180" /></td>
    </tr>
    <tr>
        <th>정산은행</th>
        <td>${accountVO.accountInfoVO.infoBank}</td>
        <th>계좌번호</th>
        <td>${accountVO.accountInfoVO.infoAccNumber}</td>
    </tr>
    <tr>
        <th>예금주</th>
        <td>${accountVO.accountInfoVO.infoAccHolder}</td>
        <th>정산율</th>
        <td>${accountVO.accountInfoVO.infoSettlRates}</td>
    </tr>
    <tr>
        <th>통장사본</th>
        <td colspan="3"><img src="/media/${accountVO.accountInfoVO.infoBankBookImage}.image" width="180" /></td>
    </tr>
    <tr>
        <th>계약시작일</th>
        <td>${accountVO.accountInfoVO.infoContractSdate}</td>
        <th>계약종료일</th>
        <td>${accountVO.accountInfoVO.infoContractEdate}</td>
    </tr>
</table>
<br/>
<br/>
<!-- Loop -->
<b>사이트 이용 정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
        <th>가입날짜</th>
        <td>${accountVO.registerDate}</td>
        <th>최근 접속일</th>
        <td>${accountVO.loginDate}</td>
    </tr>
    <tr>
        <th>회원레벨</th>
        <td>
            <c:choose>
                <c:when test="${accountVO.level=='10'}">일반회원</c:when>
                <c:when test="${accountVO.level=='30'}">전문가</c:when>
                <c:when test="${accountVO.level=='40'}">정보원</c:when>
                <c:when test="${accountVO.level=='90'}">관리자</c:when>
                <c:when test="${accountVO.level=='99'}">슈퍼관리자</c:when>
            </c:choose>
        </td>
        <th>회원상태</th>
        <td>
            <c:choose>
                <c:when test="${accountVO.statusType=='0'}">탈퇴</c:when>
                <c:when test="${accountVO.statusType=='1'}">대기</c:when>
                <c:when test="${accountVO.statusType=='2'}">활동</c:when>
            </c:choose>
        </td>
    </tr>
</table>

<div class="btn">
    <!-- div class="btnFl"><a href="javascript:goAccountRemoveForm('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a></div-->
    <div class="btnFr">
    	<!-- a href="javascript:goOrderList('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_orderList.gif" /></a -->
		<%-- <a href="javascript:goAccountForm('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a> --%>


        <a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a>
    </div>
    <div style="clear: both"></div>
</div>

</html>