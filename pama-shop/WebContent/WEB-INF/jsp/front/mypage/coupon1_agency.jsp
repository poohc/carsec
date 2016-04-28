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
                <li class="on"><a href="#tab1"><span>쿠폰사용 등록</span></a></li>
                <li><a href="/mbr/mypage/couponAgencyEndList.do"><span>쿠폰사용 리스트</span></a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
                	<c:forEach items="${i.productsVO}" var="j" varStatus="jStatus">
                    <ul class="coupon_list">
                        <li>
                            <div class="coupon_ticket">
                                <h1>${i.title}</h1>
                                <p>
                                <c:forEach items="${j.productsOptVO}" var="k" varStatus="kStatus">
                                ${k.optName}<br />
                                </c:forEach>
                                </p>
                                <span>&nbsp;</span>
                                <em>${i.firstName}</em>
                            </div>
                            <div>
                            	<ul>
                            		<li>
                            			<h2>쿠폰 판매가</h2>
                            			<h2><fmt:formatNumber value="${j.price}" type="number" /><span>원</span></h2>
                            		</li>
                            		<li>
                            			<label for="coupon_number" class="coupon_label">쿠폰번호 : ${j.licenseCode}</label>
                            			<br />
                            			<br />
                            			<form method="POST" action="/mbr/mypage/couponUseProc.do">
                            			<input type="hidden" id="ordId" name="ordId" value="${i.ordId}" />
                          				<input type="hidden" id="licenseCode" name="licenseCode" class="input_type2" value="${j.licenseCode}">
                                        <button class="button_type1 poa_type1" data-btn="text" type="submit">쿠폰결제</button>
                                        </form>
                            		</li>
                            	</ul>
                            </div>           
                        </li>
                	</ul>
                </c:forEach>
                </c:forEach>
                <div class="textbox_type1">
                    <p class="intitle">TIP!</p>
                    <p class="incont">쿠폰번호를 입력 후 결제가 완료되면 바로옆의 탭으로 정보가 이동...</p>
                </div>
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