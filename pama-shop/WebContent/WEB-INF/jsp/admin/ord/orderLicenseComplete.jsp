<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/ord");
%>
<html>
<head>
</head>

<table class="contents">
    <colgroup>
        <col width="10%"></col>
        <col width=""></col>
        <col width="20%"></col>
        <col width="25%"></col>
    </colgroup>
    <c:forEach items="${orderVO.productsVO}" var="i" varStatus="iStatus">
        <tr>
            <td align="center">${i.prdId}</td>
            <td><a href="/admin/prd/productDetail.do?prdId=${i.prdId}">${i.prdName}</a></td>
            <td>${i.qty}</td>
            <td>${i.salePrice * i.qty} 원</td>
        </tr>
		<c:choose>
			<c:when test="${i.cateId==1}">
			<iframe src="http://174.36.20.122/eyespeak/cfc/registerUserTOEIC.cfm?Email=${loginEmail}&Password=${loginPwd}&firstName=${loginName}&lastName=${loginName}&gender=${loginGender}&RegCode=${i.licenseCode}" width="0" height="0"></iframe>
			</c:when>
			<c:when test="${i.cateId==2}">
			<iframe src="http://174.36.20.122/eyespeak/cfc/registerUserExam.cfm?Email=${loginEmail}&Password=${loginPwd}&firstName=${loginName}&lastName=${loginName}&gender=${loginGender}&RegCode=${i.licenseCode}" width="0" height="0"></iframe>
			</c:when>
			<c:otherwise>
			<iframe src="http://174.36.20.122/eyespeak/cfc/registerUserP1.cfm?Email=${loginEmail}&Password=${loginPwd}&firstName=${loginName}&lastName=${loginName}&gender=${loginGender}&RegCode=${i.licenseCode}" width="0" height="0"></iframe>
			</c:otherwise>
		</c:choose>
    </c:forEach>
</table>

</html>