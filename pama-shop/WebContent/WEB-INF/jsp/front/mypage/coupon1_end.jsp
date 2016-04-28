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
                <li><a href="/mbr/mypage/couponList.do"><span>사용가능 쿠폰</span></a></li>
                <li class="on"><a href="#"><span>사용완료/지난쿠폰</span></a></li>
                <li><a href="/mbr/mypage/couponReturnList.do"><span>환불내역</span></a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <ul class="coupon_list">
                	<c:forEach items="${orderListVO.orderList}" var="i" varStatus="iStatus">
                	<c:forEach items="${i.productsVO}" var="j" varStatus="jStatus">
                    <li>
                        <form action="coupon1.jsp">
                            <div class="coupon_ticket">
                                <p>COUPON</p>
                                <h1>${i.title}</h1>
                                <span>&nbsp;</span>
                                <em>
                                	<c:if test="${i.statusType==20}">
                                	<c:choose>
                                	<c:when test="${j.licenseCode!=''}">
                                	쿠폰번호 : ${j.licenseCode}
                                	</c:when>
                                	<c:otherwise>
                                	</c:otherwise>
                                	</c:choose>
                                	</c:if>
                                </em>
                            </div>
                            <ul class="coupon_inform">
                                <li class="loc">${j.addr1}</li>
                                <li class="loc_name">${j.firstName}</li>
                                <li class="numbe">${j.tel}</li>
                            </ul>
                        </form>
                    </li>
                    </c:forEach>
                    </c:forEach>
                </ul>
                <p class="coupon_introduce">
                    쿠폰 사용/ 환불 전 약관에 대한 설명<br>
                    제 1 조(목적)<br>
                    제 1 장  총칙<br>
                    제 1 조 (목적) 이 약관은 CARSEC의 www.carsec.co.kr을 이용하여<br>
                    가 쿠폰정보를 제공하는 카색쿠폰 서비스와 회원들의<br>
                    맞춤쿠폰메일 서비스(이하 '쿠폰서비스'라 함.) 신청으로 인한<br>
                    이용자(사용자)의 이용조건 및 절차와 기타 필요한 사항을 규정하는 것을 목적으로 합니다.<br>
                     제 2 조 (약관의 공지) 이 약관의 내용은 '쿠폰서비스' 내용 중 "회원약관" 란을 통하여<br>
                    게시하며 약관이 변경 또는 일부 수정될 경우  NHN㈜와 쿠폰투유는 지체없이<br>
                    서비스의 "공지사항"을 통해 공지합니다.(메일.문자발송을 통해 공지합니다.)<br>
                    1. 이 약관은 카색 웹사이트(www.carsec.co.kr)에서<br>
                    온라인으로 공시함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련법령에<br>
                    위배되지 않는 범위 안에서 개정될 수 있습니다.<br>
                    개정된 약관은 온라인에서 공지함으로써 효력을 발휘하며,<br>
                    이용자의 권리 또는 의무 등 중요한 규정의 개정은 사전에 공지합니다.<br><br>

                    2. 회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며,<br>
                    약관을 변경할 경우에는 지체 없이 이를 사전에 공시합니다.<br><br>

                    3. 이 약관에 동의하는 것은 정기적으로 웹을 방문하여<br>
                    약관의 변경사항을 확인하는 것에 동의함을 의미합니다.<br>
                    변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 회사에서 책임지지 않습니다.
                </p>
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