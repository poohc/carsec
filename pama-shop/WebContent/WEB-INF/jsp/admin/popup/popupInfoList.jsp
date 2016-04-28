<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>



	<div class="title">팝업관리</div>
	<br>

	<table class="contents">
	   
	    <thead>
	        <tr>
	            <th class="first"><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" /></th>
	            <th>번호</th>
	            <th>제목</th>
	            <th>진행여부</th>
	            <th>팝업기간</th>
	            <th>등록일</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${list.popupInfoVOs}" var="i" varStatus="iStatus">
	            <tr>
	                <td class="first"><input type="checkbox" /></td>
	                <td>${i.popupId}</td>
	                <td>${i.popupTitle}</td>
	                <td>${i.statusType}</td>
	                <td>${i.popupStartDate}~${i.popupEndDate}</td>
	                <td>${i.registerDate}</td>
	             </tr>
	        </c:forEach>
	    </tbody>
	</table>

	<!-- Paging -->
	

	<br>
	
	<div class="btn">
	<ul>
		<li class="btnFl"><a href="popupInfoForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
	   
	</ul>
</div>
	
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
	    <jsp:param name="count" value="${list.popupSearchVO.totalCount}" />
	    <jsp:param name="row" value="${list.popupSearchVO.row}" />
	    <jsp:param name="page" value="${list.popupSearchVO.pageNo}" />
</jsp:include>
	
	
	
	
	
	
	