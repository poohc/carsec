<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
    response.setHeader("Content-Disposition", "attachment; filename=licenseExcelList.xls");
    response.setHeader("Content-Description", "JSP Generated Data");
%>
<head>
</head>

<body>
<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="3%"></col>
        <col width="3%"></col>
        <col width="18%"></col>
        <col width=""></col>
        <col width="15%"></col>
        <col width="13%"></col>
        <col width="13%"></col>
        <col width="6%"></col>
    </colgroup>
    <thead>
        <tr>
            <th>번호</th>
            <th>대분류</th>
            <th>상품명</th>
            <th>라이센스코드</th>
            <th>발행일</th>
            <th>등록일</th>
            <th>상태</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productLicenseList.productLicenseList}" var="i" varStatus="listCount">
            <tr>
                <td>${productLicenseList.productLicenseSearchVO.pageStartIndex - listCount.index}</td>
                <td>${i.cateName}</td>
                <td><a href="javascript:goProductLicenseDetail(${i.prdLicenseId});">${i.prdName}</a></td>
                <td>${i.licenseCode}</td>
                <td>${fn:substring(i.publishDate, 0, 10)}</td>
                <td>${fn:substring(i.registerDate, 0, 10)}</td>
                <td>
	                 <c:if test="${i.licensePublishType eq '1'}">미사용</c:if>
	                 <c:if test="${i.licensePublishType eq '2'}">사용중</c:if>
	                 <c:if test="${i.licensePublishType eq '3'}">만기종료</c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>