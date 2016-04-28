<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/portlet");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
</head>

	<form name="uccForm" method="get">
	    <input type="hidden" name="uccId" value="">
	    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
	</form>

	<div class="title">메인 관리</div>
	<div class="btn">
	    <div class="btnFr"><a href="./portletForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
	    <div style="clear: right;"></div>
	</div>

	<table class="contents">
	    <colgroup>
	        <col width="20"></col>
	        <col></col>
	        <col width="100"></col>
	        <col width="100"></col>
	        <col width="200"></col>
	        <col width="100"></col>
	    </colgroup>

	    <thead>
	        <tr>
	            <th class="first">No</th>
	            <th>제목</th>
	            <th>종류</th>
	            <th>등록일</th>
	            <th>상태</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${portletList.portletManageList}" var="i" varStatus="iStatus">
	            <tr>
	                <td class="first">${portletList.portletSearchVO.pageStartIndex - iStatus.index}</td>
	                <td><a href="portletDetail.do?portletId=${i.portletId}"><c:out value="${i.portletTitle}"/></a> </td>
	                <td align="center"><c:out value="${i.portletType=='1'?'태그검색':'컨텐츠등록'}" /></td>
	                <td align="center"><c:out value="${fn:substring(i.registerDate, 0, 10)}"/></td>
	                <td align="center">${i.statusType==1?'대기':'게시' }</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

	<div class="btn">
	    <div class="btnFr"><a href="./portletForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
	    <div style="clear: right;"></div>
	</div>

	<!-- Paging -->
	<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
	    <jsp:param name="count" value="${portletList.portletSearchVO.totalCount}" />
	    <jsp:param name="row" value="${portletList.portletSearchVO.row}" />
	    <jsp:param name="page" value="${portletList.portletSearchVO.pageNo}" />
	</jsp:include>

