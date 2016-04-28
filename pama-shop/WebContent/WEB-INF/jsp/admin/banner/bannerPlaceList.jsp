<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goPage
function goPage(pageNo){
    var form = document.bannerForm;
    form.pageNo.value = pageNo;
    form.submit();
}

//]]>
</script>
</head>

	<form name="bannerForm" method="get">
	    <input type="hidden" name="pageNo" value="${bannerList.bannerSearchVO.pageNo}">
	    <input type="hidden" name="listReturnURL" value="${currentURL}" />
	</form>

	<div class="title">배너 위치 관리</div>
	<div class="btn">
	    <div class="btnFr"><a href="./bannerPlaceForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
	    <div style="clear: right;"></div>
	</div>

	<table class="contents">
	    <colgroup>
	        <col width="20"></col>
	        <col></col>
	        <col width="200"></col>
	        <col width="100"></col>
	    </colgroup>

	    <thead>
	        <tr>
	            <th class="first">위치번호</th>
	            <th>게시판위치명</th>
	            <th>등록일</th>
	            <th>상태</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${bannerList.bannerPlaceList}" var="i" varStatus="iStatus">
	            <tr>
	                <td class="first">${i.bannerPlaceId}</td>
	                <td><a href="bannerPlaceForm.do?bannerPlaceId=${i.bannerPlaceId}"><c:out value="${i.bannerTitle}"/>[${i.bannerSize}   ]</a> </td>
	                <td align="center">${fn:substring(i.registerDate, 0, 10)}</td>
	                <td align="center">${i.statusType==1?'미사용':'사용' }</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

	<!-- Paging -->
	<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
	    <jsp:param name="count" value="${bannerList.bannerSearchVO.totalCount}" />
	    <jsp:param name="row" value="${bannerList.bannerSearchVO.row}" />
	    <jsp:param name="page" value="${bannerList.bannerSearchVO.pageNo}" />
	</jsp:include>

