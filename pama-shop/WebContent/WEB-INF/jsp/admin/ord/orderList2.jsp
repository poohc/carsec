<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/ord");
%>
<html>
<head>
<script type="text/javascript">
<!--

function statusProc(ordId,statusType) {
    var statusTypeChangeUrl = '/admin/ord/modifyOrderStatusType.do?ordId='+ordId+'&'+'statusType='+statusType;
    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.result == 'success')
                    alert("주문 상태를 변경하였습니다.");
                else
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
            });
    return false;
}

//goSearch
function goOrderSearch(){
    var form = document.orderSearchForm;
    form.submit();
}

//goDetail
function goOrderDetail(id){
    var form = document.orderForm;
    form.ordId.value = id;
    form.action="./orderDetail.do";
    form.method="GET";
    form.submit();
}


//-->
</script>
</head>
<form name="orderForm" method="get">
    <input type="hidden" name="ordId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>

<div class="title">주문 리스트(TOTAL:${orderListVO.orderSearchVO.totalCount})</div>

<div class="btn">
    <div class="btnFl"></div>
    <div class="btnFr">
    <form name="orderSearchForm" method="get">
    <input type="hidden" name="pageNo" value="${orderListVO.orderSearchVO.pageNo}"/>
    <select name="searchColumn" id="searchColumn" style="width:100px;">
        <option value="ordId" ${orderListVO.orderSearchVO.searchColumn=='ordId'?'selected':'' }>주문ID</option>
    </select>
    <input type="text" name="searchValue" value="${orderListVO.orderSearchVO.searchValue}" />
    <a href="javascript:goOrderSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
    </form>
    </div>
    <div style="clear: both"></div>
</div>

<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="5%"></col>
        <col width=""></col>
        <col width="10%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>주문서</th>
            <th>주문 상태</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
            <tr>
                <td>${orderListVO.orderSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td>
                    <table class="ord_table">
                        <tr>
                            <td colspan="2"><b>주문정보</b></td>
                        </tr>
                        <tr>
                            <td><b>ID : </b><a href="#;" onclick="goOrderDetail('${i.ordId}')">${i.ordId}</a></td>
                            <td><b>title : </b>${i.title}</td>
                        </tr>
                        <tr>
                            <td><b>total 가격 : </b>${i.totalPrice} 원</td>
                            <td><b>결제 가격 : </b>${i.settlePrice} 원</td>
                        </tr>
                        <tr>
                            <td>
                                <b>결제 타입 : </b>
                                <c:choose>
                                    <c:when test="${i.settleType == '0'}">무통장</c:when>
                                    <c:when test="${i.settleType == '1'}">카드</c:when>
                                    <c:when test="${i.settleType == '2'}">실시간 계좌이체</c:when>
                                </c:choose>
                            </td>
                            <td><b>결제 계좌 번호 : </b>${i.settleAccountNo}</td>
                        </tr>
                        <tr>
                            <td><b>결제 계좌 은행 : </b>${i.settleAccountBank}</td>
                            <td><b>결제 계좌 예금주 : </b>${i.settleAccountNm}</td>
                        </tr>
                        <tr>
                            <td><b> 입금자 : </b>${i.depositNm}</td>
                            <td>
                                <b>배송 타입 : </b>
                                <c:choose>
                                    <c:when test="${i.deliveryType == '0'}">무료</c:when>
                                    <c:when test="${i.deliveryType == '1'}">선불</c:when>
                                    <c:when test="${i.deliveryType == '2'}">착불</c:when>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td><b>배송비 : </b>${i.deliveryPrice} 원</td>
                            <td><b>세금 계산서 발행 여부 : </b>${i.orderTexyn}</td>
                        </tr>
                        <tr>
                            <td><b>주문일 : </b>${i.registerDate}</td>
                            <td></td>
                        </tr>

                        <tr><td colspan="2"></td></tr>
                        <tr>
                            <td colspan="2"><b>배송정보 (주문자 및 배송수령자)</b></td>
                        </tr>
                        <tr>
                            <td><b>주문자 이름 (회원ID) : </b>${i.ordererName} (${i.registerId==null || i.registerId==''?'비회원':i.registerId})</td>
                            <td><b>주문자 이메일 : </b>${i.ordererEmail}</td>
                        </tr>
                        <tr>
                            <td><b>주문자 전화 : </b>${i.ordererTel}</td>
                            <td><b>주문자 핸드폰 : </b>${i.ordererMobile}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><b>주문자 주소 : </b>(${i.ordererZipcode}) ${i.ordererAddr1} ${i.ordererAddr2}</td>
                        </tr>
                        <tr><td colspan="2"></td></tr>
                        <tr>
                            <td><b>수령자 이름 : </b>${i.receiveNane}</td>
                            <td><b>수령자 이메일 : </b>${i.receiveEmail}</td>
                        </tr>
                        <tr>
                            <td><b>수령자 전화 : </b>${i.receiveTel}</td>
                            <td><b>수령자 핸드폰 : </b>${i.receiveMobile}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><b>수령자 주소 : </b>(${i.receiveZipcode}) ${i.receiveAddr1} ${i.receiveAddr2}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><b>메모 : </b>${i.memo}</td>
                        </tr>

                        <tr><td colspan="2"></td></tr>
                        <tr>
                            <td colspan="2"><b>주문 상품 리스트</b></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table class="ord_table">
                                    <colgroup>
                                        <col width="10%"></col>
                                        <col width=""></col>
                                        <col width="20%"></col>
                                        <col width="25%"></col>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th class="first">상품 ID</th>
                                            <th>상품 이름</th>
                                            <th>주문수량</th>
                                            <th>판매가격(1개당)</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${i.productsVO}" var="j" varStatus="jStatus">
                                        <tr>
                                            <td align="cneter">${j.prdId}</td>
                                            <td><a href="/admin/prd/productDetail.do?prdId=${j.prdId}">${j.prdName}</a></td>
                                            <td>${j.qty}</td>
                                            <td>${j.salePrice} 원</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <select name='statusType' onChange="statusProc('${i.ordId}',this.value)">
                        <option value="10" ${i.statusType == '10'?'selected':'' }>주문중</option>
                        <option value="20" ${i.statusType == '20'?'selected':'' }>배송중</option>
                        <option value="30" ${i.statusType == '30'?'selected':'' }>완료</option>
                    </select>
                    <!--  <br><a href="#">주문서출력</a> -->
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