<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:choose>
    <c:when test="${memberSession.login==true}"><META HTTP-EQUIV="refresh" CONTENT="0; URL=/admin/main/main.do"></c:when>
    <c:otherwise><META HTTP-EQUIV="refresh" CONTENT="0; URL=/admin/login/loginForm.do"></c:otherwise>
</c:choose>