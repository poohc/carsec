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
function goList() {
    var form = document.accountForm;
    var listReturnURL = form.listReturnURL.value;
    if (listReturnURL!="") {
        location.href = listReturnURL;
    } else {
        location.href = "../accountList.do";
    }
}
//-->
</script>
</head>
<form name="accountForm" method="get">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>
<div class="title">
	주문  리스트
    (TOTAL:${orderListVO.orderSearchVO.totalCount})
</div>

<div>
	<ul>
		<li><a href="orderList.do?mbrId=${accountSearchVO.mbrId}"><img src="/common/images/admin/btn/btn_order_list.gif" /></a>  <a href="orderFinishList.do?mbrId=${accountSearchVO.mbrId}"><img src="/common/images/admin/btn/btn_order_finish.gif" /></a></li>
	</ul>
</div>

<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="5%"></col>
        <col width="15%"></col>
        <col width="auto"></col>
        <col width="10%"></col>
        <col width="16%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>라이센스코드</th>
            <th>상품명</th>
            <th>주문일자</th>
            <th>이용기간</th>
            <th>결제금액</th>
            <th>결제방법</th>
            <th>주문상태</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
            <tr>
                <td>${orderListVO.orderSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td>
                    ${i.licenseCode}
                </td>
                <td>[${i.cateName}]${i.prdName}</td>
                <td>${fn:substring(i.registerDate,0,10)}</td>
                <td>${i.startDate} ~ ${i.endDate}</td>
                <td>${i.settlePrice} 원</td>
                <td>
                    <c:choose>
                        <c:when test="${i.settleType == '0'}">무통장입금</c:when>
                        <c:when test="${i.settleType == '1'}">신용카드</c:when>
                        <c:when test="${i.settleType == '2'}">실시간 계좌이체</c:when>
                    </c:choose>
                </td>
                <td>
                	<c:if test="${i.statusType != '90'}">
                     ${i.statusType == '10'?'입금대기':'' }
                     ${i.statusType == '11'?'결제완료':'' }
                    </c:if>
                    <c:if test="${i.statusType == '90'}">주문취소</c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="btn">
    <div class="btnFr">
        <a href="/admin/account/accountDetail.do?mbrId=${accountSearchVO.mbrId}"><img src="/common/images/admin/btn/btn_account_info.gif" /></a>
        <a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a>
    </div>
    <div style="clear: both"></div>
</div>
<!-- Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${orderListVO.orderSearchVO.totalCount}" />
    <jsp:param name="row" value="${orderListVO.orderSearchVO.row}" />
    <jsp:param name="page" value="${orderListVO.orderSearchVO.pageNo}" />
</jsp:include>

</html>