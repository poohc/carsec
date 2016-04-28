<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<c:choose>
	<c:when test="${fn:startsWith(requestURI,'/web/sub1') }">


	</c:when>
	<c:otherwise>


	</c:otherwise>
</c:choose>




