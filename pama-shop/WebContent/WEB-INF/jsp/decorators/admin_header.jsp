<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<div id="linkbox">
<ul >
	<li>${menuDebug }<a href="/admin/smp/form.do">.</a></li>
</ul>
	<ul class="c1">
		<li class="menu"><a href="/" target="_BLANK">HOME</a></li>
		<li class="bar">|</li>
		<li class="menu"><a href="/admin/login/logout.do" target="_top">로그아웃</a></li>
		<li class="bar">|</li>
	</ul>
</div>


<div id="topmenubox">
	<ul class="topnav">
		<li class="logo">
		<a href="/admin/main/main.do"><img src="/common/images/admin/logo/logo_admin.png" width="170px" height="30px" /></a></li>
		<c:forEach items="${topMenu}" var="i">
			<li><a href="${fn:split(i,splitStr)[2]}" class="${currentGroup==fn:split(i,splitStr)[0]?'current':''}"> ${fn:split(i,splitStr)[1] }</a></li>
		</c:forEach>
	</ul>
</div>

