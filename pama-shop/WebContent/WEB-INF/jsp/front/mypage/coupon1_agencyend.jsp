<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 쿠폰</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="layout_type1">
            <ul id="tab" class="tablist tablist4"><!-- 탭 -->
                <li><a href="/mbr/mypage/couponAgencyList.do"><span>쿠폰사용 등록</span></a></li>
                <li class="on"><a href="#tab2"><span>쿠폰사용 리스트</span></a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <div class="board_list3 mt_27"><!-- board_list -->
                    <table class="">
                        <caption>쿠폰입금대기 게시판</caption>
                        <colgroup>
                            <col style="width:14%" />
                            <col style="width:14%" />
                            <col style="width:14%" />
                            <col style="width:auto" />
                            <col style="width:17%" />
                            <col style="width:17%" />
                            <col style="width:auto" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">결제번호</th>
                                <th scope="col">결제일</th>
                                <th scope="col">쿠폰번호</th>
                                <th scope="col">쿠폰명</th>
                                <th scope="col">결제금액(공제후)</th>
                                <th scope="col">닉네임</th>
                                <th scope="col">상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
                			<c:forEach items="${i.productsVO}" var="j" varStatus="jStatus">
                            <tr class="">
                                <td>${i.ordId }</td>
                                <td>${i.registerDate}</td>
                                <td>${j.licenseCode}</td>
                                <td>${i.title}</td>
                                <td><fmt:formatNumber value="${j.price}" type="number" /><span>원</span></td>
                                <td>${j.firstName}</td>
                                <td>
                                	<c:if test="${i.statusType==10}">
                                	입금예정
                                	</c:if>
                                	<c:if test="${i.statusType==11}">
                                	결재완료
                                	</c:if>
                                	<c:if test="${i.statusType==20}">
                                	쿠폰사용완료
                                	</c:if>
                                </td>
                            </tr>
                            </c:forEach>
                            </c:forEach>
                        </tbody>
                    </table>
                </div><!-- //board_list -->
				<!-- //Paging -->
				<div class="paging">
				<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
					<jsp:param name="count" value="${orderListVO.orderSearchVO.totalCount}" />
					<jsp:param name="row" value="${orderListVO.orderSearchVO.row}" />
					<jsp:param name="page" value="${orderListVO.orderSearchVO.pageNo}" />
				</jsp:include>
				</div>
				<!-- Paging// -->                
                <div class="textbox_type1">
                    <p class="intitle">TIP!</p>
                    <p class="incont">입금완료시 텍스트 색상 변경</p>
                </div>
        </div>
    </div>

<script>
    /**********************************************************************************/
// 탭
/**********************************************************************************/
$(function(){
    $('.tab_contents:eq(0)').show();
});
</script>
</body>
</html>