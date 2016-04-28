<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/ord");
%>
<html>
<head>
<script type="text/javascript">
<!--

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
                    alert("주문 상태를 변경하였습니다.");
                    location.reload();
                }else{
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
                }
            });
    return false;
}

function goList() {
    var form = document.orderForm;
    var listReturnURL = form.listReturnURL.value;
    if (listReturnURL!="") {
        location.href = listReturnURL;
    } else {
        location.href = "orderList.do";
    }
}

//RemoveProc
function goOrderRemoveProc(id){
    var form = document.orderForm;

    if(confirm('정말로 구매취소를 하시겠습니까?')){
        form.action="./orderRemoveProc.do";
        form.ordId.value = id;
        form.method="post";
        form.submit();
    }
}

//-->
</script>
</head>

<form name="orderForm" method="get">
    <input type="hidden" name="ordId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>
<!-- Loop -->

<div class="title">주문정보</div>
<table class="contents">
    <tr>
        <th>주문 ID</th>
        <td>${orderVO.ordId}</td>
    </tr>
    <tr>
        <th>상품명</th>
        <td>${orderVO.title}</td>
    </tr>
    <tr>
        <th>주문자ID</th>
        <td>${orderVO.registerId}</td>
    </tr>
<!--     <tr> -->
<!--         <th>total 가격</th> -->
<%--         <td>${orderVO.totalPrice} 원</td> --%>
<!--     </tr> -->
    <tr>
        <th>결제 가격</th>
        <td>${orderVO.settlePrice} 원</td>
    </tr>
    <tr>
        <th>결제 타입</th>
        <td>
            <c:choose>
                <c:when test="${orderVO.settleType == '0'}">무통장입금</c:when>
                <c:when test="${orderVO.settleType == '1'}">신용카드</c:when>
                <c:when test="${orderVO.settleType == '2'}">실시간 계좌이체</c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <th>결제 계좌 번호 </th>
        <td>${orderVO.settleAccountNo}</td>
    </tr>
    <tr>
        <th>결제 계좌 은행</th>
        <td>${orderVO.settleAccountBank}</td>
    </tr>
    <tr>
        <th>결제 계좌 예금주</th>
        <td>${orderVO.settleAccountNm}</td>
    </tr>
    <tr>
        <th>입금자</th>
        <td>${orderVO.depositNm}</td>
    </tr>
    <tr>
        <th>주문일</th>
        <td>${orderVO.registerDate}</td>
    </tr>

    <tr>
        <th>주문상태</th>
        <td>
                    <c:if test ="${orderVO.statusType <= 10}">
                		<a href="#" onclick="statusProc('${orderVO.statusType}', '${orderVO.ordId}', '11');">충전하기</a>
                	 </c:if>

					<c:if test ="${orderVO.statusType == 11}">
                	 	충전완료
					</c:if>

         </td>
    </tr>
</table>

<!-- <div style="height:20px"></div> -->
<!-- <div class="title">주문 상품 리스트</div> -->
<!-- <table class="contents"> -->
<!--     <colgroup> -->
<!--         <col width="10%"></col> -->
<!--         <col width=""></col> -->
<!--         <col width="20%"></col> -->
<!--     </colgroup> -->
<!--     <thead> -->
<!--         <tr> -->
<!--             <th class="first">상품 ID</th> -->
<!--             <th>상품 이름</th> -->
<!--             <th>가격</th> -->
<!--         </tr> -->
<!--     </thead> -->
<%--     <c:forEach items="${orderVO.productsVO}" var="i" varStatus="iStatus"> --%>
<!--         <tr> -->
<%--             <td align="center">${i.prdId}</td> --%>
<%--             <td><a href="/admin/prd/productDetail.do?prdId=${i.prdId}">${i.prdName}</a></td> --%>
<%--             <td>${i.salePrice * i.qty} 원</td> --%>
<!--         </tr> -->
<%--     </c:forEach> --%>
<!-- </table> -->


<div class="btn">
<%--     <div class="btnFl"><a href="javascript:goOrderRemoveProc('${orderVO.ordId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a></div> --%>
    <div class="btnFr">
        <a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a>
    </div>
    <div style="clear: both"></div>
</div>

</html>