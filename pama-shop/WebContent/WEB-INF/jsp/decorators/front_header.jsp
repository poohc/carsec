<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<!-- header -->
    <div id="header">
        <div class="header_top">
            <div class="top_menu">
                <ul class="top_left">
                    <li class="self"><a href="/check/check1.do">내차SELF점검</a></li>
<!--                     <li class="coupon"><a href="/web/etc/coupon1.do">COUPON</a></li> -->
                </ul>
                <ul class="top_right">
                <c:choose>
            		<c:when test="${isLogin}">
            		<li class="login"><a href="/login/logout.do">로그아웃</a></li>
                    <li class="join"><a href="/mbr/mypage/mypage.do">마이${sessionVO.level==40?'&nbsp;':''}페이지</a></li>
            		</c:when>
            		<c:otherwise>
            		<li class="login"><a href="/login/loginForm.do">로그인</a></li>
					<li class="join"><a href="/mbr/accountAgreeAgency.do">메카닉회원 가입</a></li>
                    <li class="join"><a href="/mbr/accountAgree.do">일반회원 가입</a></li>
            		</c:otherwise>
				</c:choose>

                </ul>
            </div>

        </div>
        <div class="header_bottom_box">
        <div class="header_bottom">
            <h1><a href="/"><img src="/img/logo3.png" alt="carsec"></a></h1>
            <ul id="gnb"><!-- gnb -->
            	<li class="gnb02"><a href="/check/check1.do">서비스</a></li>
                <li class="gnb01"><a href="/bbs/freeboard/messageList.do">정보도서관</a></li>
                <li class="gnb02"><a href="/bbs/recruit2/messageList.do">에이전트</a></li>
                <li class="gnb01"><a href="/bbs/newcar/messageList.do">메카닉</a></li>
                <li class="gnb01"><a href="/bbs/compareevent/messageList.do">이벤트</a></li>
<!--                 <li class="gnb01"><a href="#;" onclick="alert('메카닉 회원의 상품을 준비중입니다');">쿠폰쇼핑</a></li> -->
                <li class="gnb01"><a href="/prd/productList.do?sortTree=10">쿠폰쇼핑</a></li>
            </ul><!-- //gnb -->
        </div>
        </div>
    </div>
<!-- //header -->

<script>
function randomNotice(arg1, arg2){
	location.href="/bbs/"+arg1+"/messageDetail.do?messageId="+arg2;
}
function aspectNotice(arg1, arg2){
	location.href="/bbs/"+arg1+"/messageDetail.do?messageId="+arg2;
}

</script>
