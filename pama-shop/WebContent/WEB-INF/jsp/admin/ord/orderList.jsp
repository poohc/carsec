<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/ord");
%>
<html>
<head>
<link rel="stylesheet" href="/common/css/jquery/themes/base/jquery.ui.all.css">
<script src="/common/js/jquery/ui/jquery.ui.core.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.widget.js"></script>
<script src="/common/js/jquery/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript">

function getOrderExcelList(totalCount){
    var form = document.orderSearchForm;

    // 현재 검색되어있는 자료중 페이지 상관없이 모든 자료가 엑셀로 출력된다.
    form.row.disabled = false;
    form.pageNo.value = 1;
    form.row.value = totalCount;
    form.action = "/admin/ord/excel/orderList.do";
    form.submit();
}

function statusProc(oldStatusType, ordId, statusType) {

    var statusTypeChangeUrl = '/admin/ord/modifyOrderStatusType.json?ordId='+ordId+'&'+'statusType='+statusType;

    if(oldStatusType > statusType){
        alert('주문상태를 전단계로 변경할 수 없습니다. ');
        location.reload();
        return false;
    }

    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.result == 'success'){

                	//document.frames["licenseComplete"].location.href="/admin/ord/orderLicenseComplete.do?ordId="+ordId;
                    alert("주문 상태를 변경하였습니다.");
                    $("#order_"+ordId).remove();
                    //location.reload();
                }else{
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
                }
            });
    return false;
}

//goSearch
function goOrderSearch(){
    var form = document.orderSearchForm;
    form.pageNo.value = 1;  // 검색후 무조건 첫번째 페이지가 나오게 하려고
    form.row.disabled = true;
    form.action = "/admin/ord/orderList.do";
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.orderSearchForm;
    form.pageNo.value = pageNo;
    form.row.disabled = true;
    form.action = "/admin/ord/orderList.do";
    form.submit();
}

$(function() {
    $( "#startRegisterDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#endRegisterDate" ).datepicker( { dateFormat: 'yy-mm-dd' } );
});

function reLicenseComplete(ordId) {
	document.frames["licenseComplete"].location.href="/admin/ord/orderLicenseComplete.do?ordId="+ordId;
	alert('인증이 완료되었습니다.');
}

</script>
</head>

<div class="title">
    <c:choose>
        <c:when test="${orderListVO.orderSearchVO.statusType == '10'}">입금대기리스트</c:when>
        <c:otherwise>전체결재리스트</c:otherwise>
    </c:choose>
    (TOTAL:${orderListVO.orderSearchVO.totalCount})

</div>
<iframe id="licenseComplete" name="licenseComplete" width="0" height="0"></iframe>
<form name="orderSearchForm" method="get" autocomplete="off">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<input type="hidden" name="statusType" value="${orderListVO.orderSearchVO.statusType}"/>
<input type="hidden" name="row" id="row" disabled/>
<input type="hidden" name="pageNo" value="${orderListVO.orderSearchVO.pageNo}" />
<table class="contents">
    <colgroup>
        <col width="20%"></col>
        <col width="80%"></col>
    </colgroup>
    <thead>

    </thead>
    <tbody>
        <tr>
            <th>키워드 검색</th>
            <td>
                <select name="searchColumn" id="searchColumn" style="width:100px;">
                    <option value="ordId" ${orderListVO.orderSearchVO.searchColumn=='ordId'?'selected':'' }>주문번호</option>
                    <option value="ordererName" ${orderListVO.orderSearchVO.searchColumn=='ordererName'?'selected':'' }>주문자</option>
                    <option value="title" ${orderListVO.orderSearchVO.searchColumn=='title'?'selected':'' }>상품명</option>
                </select>
                <input type="text" name="searchValue" value="${orderListVO.orderSearchVO.searchValue}" />
            </td>
        </tr>
        <tr>
            <th>결제방법</th>
            <td>
                <select name='settleType'>
                    <option value="">선택</option>
                    <option value="0" ${orderListVO.orderSearchVO.settleType=='0'?'selected':'' }>무통장입금</option>
                    <option value="1" ${orderListVO.orderSearchVO.settleType=='1'?'selected':'' }>신용카드</option>
                    <option value="2" ${orderListVO.orderSearchVO.settleType=='2'?'selected':'' }>실시간 계좌이체</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>주문일</th>
            <td>
                <input id="startRegisterDate" type="text" name="startRegisterDate" value="${orderListVO.orderSearchVO.startRegisterDate}" /> -
                <input id="endRegisterDate" type="text" name="endRegisterDate" value="${orderListVO.orderSearchVO.endRegisterDate}" />
                <a href="#;" onclick="getCalculatedDate(document.orderSearchForm.startRegisterDate,document.orderSearchForm.endRegisterDate,0,0,0);">[오늘]</a>
                <a href="#;" onclick="getCalculatedDate(document.orderSearchForm.startRegisterDate,document.orderSearchForm.endRegisterDate,0,0,-7);">[일주일]</a>
                <a href="#;" onclick="getCalculatedDate(document.orderSearchForm.startRegisterDate,document.orderSearchForm.endRegisterDate,0,0,-15);">[15일]</a>
                <a href="#;" onclick="getCalculatedDate(document.orderSearchForm.startRegisterDate,document.orderSearchForm.endRegisterDate,0,-1,0);">[한달]</a>
                <a href="#;" onclick="getCalculatedDate(document.orderSearchForm.startRegisterDate,document.orderSearchForm.endRegisterDate,0,-2,0);">[2달]</a>
            </td>
        </tr>
    </tbody>
</table>
</form>
<div class="btn">
    <div class="btnFr">
<%--     	<a href="#;" onclick="getOrderExcelList('${orderListVO.orderSearchVO.totalCount}');"><img src="/common/images/admin/btn/btn_excel.gif" /></a> --%>
        <a href="#;" onclick="goOrderSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
    </div>
    <div style="clear: both"></div>
</div>
<br/>

<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="5%"></col>
        <col width="25%"></col>
        <col width="10%"></col>
        <col width="auto"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="15%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>주문번호/주문일자</th>
            <th>주문자</th>
            <th>상품명</th>
            <th>결제금액</th>
            <th>결제방법</th>
            <th>주문상태</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
            <tr id="order_${i.ordId}">
                <td>${orderListVO.orderSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td>
                    <a href="/admin/ord/orderDetail.do?ordId=${i.ordId}">${i.ordId}</a><br/>
                    ${i.registerDate}
                </td>
                <td>${i.registerId}(${i.ordererName})</td>
                <td>${i.title}</td>
                <td>${i.settlePrice} 원</td>
                <td>
                    <c:choose>
                        <c:when test="${i.settleType == '0'}">무통장입금</c:when>
                        <c:when test="${i.settleType == '1'}">신용카드</c:when>
                        <c:when test="${i.settleType == '2'}">실시간 계좌이체</c:when>
                    </c:choose>
                </td>
                <td align="center">
               	 	<c:if test ="${i.statusType <= 10}">
                		<a href="#" onclick="statusProc('${i.statusType}', '${i.ordId}', '11');">쿠폰발급</a>
                	 </c:if>

					<c:if test ="${i.statusType == 11}">
                	 	쿠폰발급완료
					</c:if>


                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${orderListVO.orderSearchVO.totalCount}" />
    <jsp:param name="row" value="${orderListVO.orderSearchVO.row}" />
    <jsp:param name="page" value="${orderListVO.orderSearchVO.pageNo}" />
</jsp:include>

</html>