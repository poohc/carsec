<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript">
<!--
	//goSearch
	function goMessageSearch() {
		var form = document.searchForm;
		form.pageNo.value = "1";
		form.action = "messageList.do"
		form.submit();
	}

	//goDetail
	function goMessageDetail(id) {
		var form = document.messageForm;
		form.messageId.value = id;
		form.action = "messageDetail.do";

		form.method = "GET";
		form.submit();
	}

	//goPage
	function goPage(pageNo) {
		var form = document.messageSearchForm;
		form.pageNo.value = pageNo;
		form.submit();
	}
//-->
</script>
</head>
<body>
	<img src="/img/bullet/event.png"/>
	<ul class="event_layout">
		<form name="messageSearchForm" method="get">
			<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		</form>
		<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
			<li class="second"><a href="javascript:goMessageDetail('${i.messageId}');"> <c:if test="${fn:length(i.showFile1) > 0}">
						<img src="/media/${i.showFile1}.image" width="355px" height="201px">
					</c:if>
					<p class="event_title">${i.title}</p> <span>진행중</span>
					<p class="term">${i.startDate }~ ${i.endDate }</p>
			</a></li>
		</c:forEach>
	</ul>
	<form name="messageForm">
		<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
	</form>
	<div class="paging">
		<!-- //Paging -->
		<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
			<jsp:param name="count" value="${messageList.messageSearchVO.totalCount}" />
			<jsp:param name="row" value="${messageList.messageSearchVO.row}" />
			<jsp:param name="page" value="${messageList.messageSearchVO.pageNo}" />
		</jsp:include>
		<!-- Paging// -->
	</div>


</body>
</html>