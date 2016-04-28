<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.pama.prd.vo.ProductSearchVO"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/prd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
<!--

//-->
</script>
</head>
<body>

Product Info${REQUEST.currentURL}
<table class="contents">
    <thead>
        <tr>
            <th>Product ID</th>
            <th>Category ID</th>
            <th>Product Name</th>
            <th>Unit</th>
            <th>price</th>
            <th>salePrice</th>
            <th>comp</th>
            <th>country</th>
            <th>registerDate</th>
            <th>registerId</th>
            <th>registerIp</th>
            <th>updateDate</th>
            <th>updateId</th>
            <th>updateIp</th>
            <th>statusType</th>
        </tr>
    </thead>
    <tbody>
            <tr>
                <td>${productVO.prdId}</td>
                <td>${productVO.cateId}</td>
                <td>${productVO.prdName}</td>
                <td>${productVO.unit}</td>
                <td>${productVO.price}</td>
                <td>${productVO.salePrice}</td>
                <td>${productVO.comp}</td>
                <td>${productVO.country}</td>
                <td>${productVO.registerDate}</td>
                <td>${productVO.registerId}</td>
                <td>${productVO.registerIp}</td>
                <td>${productVO.updateDate}</td>
                <td>${productVO.updateId}</td>
                <td>${productVO.updateIp}</td>
                <td>${productVO.statusType}</td>
            </tr>
    </tbody>
</table>
<br />


Product Contents

<table>
    <thead>
        <tr>
            <th>Product ID</th>
            <th>Product Contents ID</th>
            <th>Contents</th>
            <th>registerDate</th>
            <th>updateDate</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productVO.productContentsVO}" var="productContentsList" varStatus="productContentsListCount">
            <tr>
                <td>${productContentsList.prdId}</td>
                <td>${productContentsList.prdConId}</td>
                <td>${productContentsList.contents}</td>
                <td>${productContentsList.registerDate}</td>
                <td>${productContentsList.updateDate}</td>
            </tr>
         </c:forEach>
    </tbody>
</table>
<br />

Product Attchement

<table>
    <thead>
        <tr>
            <th>prdId</th>
            <th>prdAttaId</th>
            <th>imageType</th>
            <th>fileType</th>
            <th>fileName</th>
            <th>displayName</th>
            <th>filePath</th>
            <th>fileSize</th>
            <th>downLoadCount</th>
            <th>registerDate</th>
            <th>updateDate</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productVO.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
            <tr>
                <td>${productAttachementList.prdId}</td>
                <td>${productAttachementList.prdAttaId}</td>
                <td>${productAttachementList.imageType}</td>
                <td>${productAttachementList.fileType}</td>
                <td>${productAttachementList.fileName}</td>
                <td>${productAttachementList.displayName}</td>
                <td>${productAttachementList.filePath}</td>
                <td>${productAttachementList.fileSize}</td>
                <td>${productAttachementList.downLoadCount}</td>
                <td>${productAttachementList.registerDate}</td>
                <td>${productAttachementList.updateDate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>