<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>



            <!--<ul class="system_notice">-->
                <!--<li class="on"><a href="#">공지사항</a></li>-->
           		<!--<c:forEach items="${aspectnotice3 }" var="i" varStatus="iStatus" begin="0" end="0">-->
					<!--<li class="" onclick="aspectNotice('${i.boardKey}','${i.messageId}')" style="cursor: pointer;"><a>${i.title}</a></li>-->
                <!--</c:forEach>-->
            <!--</ul>-->

<c:if test="${isLogin }">
                <div class="private_info">
                    <p class="pri_type">${sessionVO.level==10?'개인':'메카닉' }회원</p>
                     <p class="names_box"><span class="names">${sessionVO.memberNm } 님</span><span class="car_name elipsis"></span></p>

                    <c:if test="${sessionVO.level==10}">
                    <ul class="estimate">
                        <li class="demand"><a href="/estimate/estimate.do?progressStatus=1">요청한견적<em><a href="/estimate/estimate.do?progressStatus=1">${not empty carEstimate.r1Count?carEstimate.r1Count:'0' }</a></em></a></li>
                        <li class="recieve"><a href="/estimate/estimate.do?progressStatus=2">받은견적<em><a href="/estimate/estimate.do?progressStatus=2">${not empty carEstimate.r2Count?carEstimate.r2Count:'0' }</a></em></a></li>
                        <li class="recieve"><a href="/estimate/estimate.do?progressStatus=3">예약리스트<em><a href="/estimate/estimate.do?progressStatus=3">${not empty carEstimate.r3Count?carEstimate.r3Count:'0' }</a></em></a></li>
<!--                         <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>0</em></a></li> -->
                    </ul>
                    </c:if>
                    <c:if test="${sessionVO.level==30 or sessionVO.level==40}">
                     <ul class="estimate">
                        <li class="demand"><a href="/estimate/estimate.do?progressStatus=1">요청받은견적<em><a href="/estimate/estimate.do?progressStatus=1">${not empty carEstimate.r1Count?carEstimate.r1Count:'0' }</a></em></a></li>
                        <li class="recieve"><a href="/estimate/estimate.do?progressStatus=2">요청한견적<em><a href="/estimate/estimate.do?progressStatus=2">${not empty carEstimate.r2Count?carEstimate.r2Count:'0' }</a></em></a></li>
                        <li class="recieve"><a href="/estimate/estimate.do?progressStatus=3">받은 예약<em><a href="/estimate/estimate.do?progressStatus=3">${not empty carEstimate.r3Count?carEstimate.r3Count:'0' }</a></em></a></li>
<!--                         <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰판매 <em>0</em></a></li> -->
                    </ul>
                    </c:if>

                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                </div>
</c:if>

   			<div class="banner">
                <ul>
                    <li><a href="/check/caritemmap.do"><img src="/img/self_banner.jpg" alt="배너"></a></li>
                    <li><a href="/bbs/recruit2/messageList.do"><img src="/img/self_banner2.jpg" alt="배너"></a></li>
                    <li><a href="/check/check1.do"><img src="/img/self_banner3.jpg" alt="배너"></a></li>
                </ul>
            </div>
<jsp:include page="/WEB-INF/jsp/decorators/front_include_sidetab.jsp" />




