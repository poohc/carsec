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
            <h1 class="join_title">협력업체 가입완료</h1>
            <p class="explain">사업자 등록증 접수가 되지 않으면 회원가입 처리가 되지 않습니다.</p>
            <a href="#" class="button_type4 mb_40">팩스번호 안내</a>
            <c:choose>
            <c:when test="${isLogin}">
            <a href="/main/main.do" class="button_type4 mt_40">메인 바로가기</a>
            </c:when>
            <c:otherwise>
            <a href="/login/loginForm.do" class="button_type4 mt_40">로그인 바로가기</a>
            </c:otherwise>
            </c:choose>
        </div>
    </div>


</body>
</html>