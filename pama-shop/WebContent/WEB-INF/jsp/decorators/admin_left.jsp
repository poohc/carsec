<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<!-- jquery tree -->


<dl id="leftMenu">
		<dt>${currentGroupMenuName }</dt>
		<c:forEach items="${leftMenu}" var="j">
			<dd><c:if test="${fn:indexOf(fn:split(j,splitStr)[0], '_A')>=0}">&nbsp;&nbsp;&nbsp;&nbsp;-</c:if><a href="${fn:split(j,splitStr)[2]}"> ${fn:split(j,splitStr)[1] }</a></dd>
		</c:forEach>
</dl>