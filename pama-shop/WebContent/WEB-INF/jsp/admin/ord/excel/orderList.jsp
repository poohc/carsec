<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
    response.setHeader("Content-Disposition", "attachment; filename=orderExcelList.xls");
    response.setHeader("Content-Description", "JSP Generated Data");
%>
<html>

<div class="title">
    <c:choose>
        <c:when test="${orderListVO.orderSearchVO.statusType == '10'}">주문 입금대기  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '11'}">주문 결제완료  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '20'}">주문 배송준비  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '21'}">주문 배송중  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '22'}">주문 배송완료  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '30'}">주문 구매확정  리스트</c:when>
        <c:when test="${orderListVO.orderSearchVO.statusType == '90'}">주문 구매취소  리스트</c:when>
        <c:otherwise>주문 전체  리스트</c:otherwise>
    </c:choose>
    (TOTAL:${orderListVO.orderSearchVO.totalCount})
</div>

<br/>

<!-- Loop -->
<table border="1">
    <thead>
        <tr>
            <th class="first">No</th>
            <th>주문번호/주문일자</th>
            <th>주문자</th>
            <th>상품명</th>
            <th>결제금액</th>
            <th>결제방법</th>
            <th>주문상태</th>
            <th>수령자 이름</th>
            <th>수령자 전화</th>
            <th>수령자 핸드폰</th>
            <th>배송지 주소</th>
            <th>메모</th>
            <th>주문상품 (수량 / 가격)</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
        <fmt:parseDate value="${i.registerDate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss.S"/>
            <tr>
                <td>${orderListVO.orderSearchVO.pageStartIndex + 1 - iStatus.count}</td>
                <td>
                    ${i.ordId} / <fmt:formatDate value="${dateFmt}" pattern="yyyy.MM.dd HH:mm"/>
                </td>
                <td>${i.ordererName}</td>
                <td>${i.title}</td>
                <td>${i.settlePrice} 원</td>
                <td>
                    <c:choose>
                        <c:when test="${i.settleType == '0'}">무통장입금</c:when>
                        <c:when test="${i.settleType == '1'}">신용카드</c:when>
                        <c:when test="${i.settleType == '2'}">실시간 계좌이체</c:when>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${i.statusType == '10'}">입금대기</c:when>
                        <c:when test="${i.statusType == '11'}">결제완료</c:when>
                        <c:when test="${i.statusType == '20'}">배송준비</c:when>
                        <c:when test="${i.statusType == '21'}">배송중</c:when>
                        <c:when test="${i.statusType == '22'}">배송완료</c:when>
                        <c:when test="${i.statusType == '30'}">구매확정</c:when>
                        <c:when test="${i.statusType == '90'}">구매취소</c:when>
                    </c:choose>
                </td>
                <td>${i.receiveNane}</td>
                <td>${i.receiveTel}</td>
                <td>${i.receiveMobile}</td>
                <td>[${i.receiveZipcode}] ${i.receiveAddr1} ${i.receiveAddr2}</td>
                <td>${i.memo}</td>
                <td>
                    <c:forEach items="${i.productsVO}" var="j" varStatus="jStatus">
                        [${j.prdId}]  ${j.prdName}  (${j.qty} / ${j.salePrice * j.qty} 원) <br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</html>