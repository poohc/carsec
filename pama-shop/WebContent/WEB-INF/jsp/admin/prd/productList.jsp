<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function goPage(pageNo){
    var form = document.productSearchFrom;
    form.pageNo.value = pageNo;
    form.submit();
}
</script>
</head>
<body>
<div class="title">
	상품리스트 - 
	<c:if test="${productListVO.productSearchVO.sortTree==10}">병원</c:if>
	<c:if test="${productListVO.productSearchVO.sortTree==20}">뷰티샵</c:if>
	<c:if test="${productListVO.productSearchVO.sortTree==30}">Culture</c:if>
</div>
<div class="btn">
    <div class="btnFl"><a href="./productForm.do?sortTree=${productListVO.productSearchVO.sortTree}"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
    <div style="clear: both"></div>
</div>
<form name="productSearchFrom" method="post" autocomplete="off">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<input type="hidden" name="pageNo" value="${productListVO.productSearchVO.pageNo}"/>
<input type="hidden" name="sortTree" value="" />
<br />
<table class="contents">
    <thead>
        <tr>
            <th>번호</th>
            <th colspan="2">상품명</th>
            <th>가격</th>
            <th>등록일</th>
            <th>상태</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productListVO.productList}" var="productList" varStatus="productListCount">
            <tr>
                <td>${productListVO.productSearchVO.pageStartIndex - productListCount.index}</td>
                <c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
	                    	<td width="10%"><a href="/admin/prd/productForm.do?sortTree=${productListVO.productSearchVO.sortTree}&prdId=${productList.prdId}"><img src="/media/${productAttachementList.fileName}.image" width="100"/></a></td>
	                    </c:when>
                    </c:choose>
                </c:forEach>
                <td><a href="/admin/prd/productForm.do?sortTree=${productListVO.productSearchVO.sortTree}&prdId=${productList.prdId}">${productList.prdName}</a></td>
                <td>${productList.price}</td>
                <td>${fn:substring(productList.registerDate, 0, 10)}</td>
                <td>
                   <c:if test="${productList.statusType eq '1'}">대기</c:if>
                   <c:if test="${productList.statusType eq '2'}">판매</c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br />
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${productListVO.productSearchVO.totalCount}" />
    <jsp:param name="row" value="${productListVO.productSearchVO.row}" />
    <jsp:param name="page" value="${productListVO.productSearchVO.pageNo}" />
</jsp:include>
</form>
</body>
</html>