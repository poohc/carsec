<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>회원가입</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">가입완료</h1>
            <p class="explain">일반회원으로 가입이 되었습니다.</p>
            <c:choose>
            	<c:when test="${isLogin}">
            	<a href="/main/main.do" class="button_type4">메인 바로가기</a>
            	</c:when>
            	<c:otherwise>
            	<a href="/login/loginForm.do" class="button_type4">로그인 바로가기</a>
            	</c:otherwise>
            </c:choose>
        </div>
    </div>


</body>
</html>