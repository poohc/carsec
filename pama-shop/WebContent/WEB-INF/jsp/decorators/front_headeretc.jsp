<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<!-- header -->
    <div class="header2">
        <div class="header_top2">
            <a href="/web/main.do" class="logo2"><img src="/img/logo2.png" alt="carsec로고"></a>
            <ul>
            	<c:choose>
            		<c:when test="${isLogin}">
                <li><a href="/login/logout.do">로그아웃</a></li>
                	</c:when>
                	<c:otherwise>
                <li><a href="/login/loginForm.do">로그인</a></li>
                	</c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
<!-- //header -->
