<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${boardVO.title }</title>
</head>
<body>
	<ul class="gallery_layout2">
		<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
			<li class="on">
			<a href="/web/sub2/library3_view.do">
			<img src="/media/${i.showFile1}.image" width="228px" height="142px">

					<div class="gallery_introbox">
						<h1 class="elipsis">${i.title}</h1>
						<p><c:out value="${fn:replace(i.summaryContents,'&nbsp;',' ') }" /></p>


						<span><c:out value="${i.registerName }" /></span> <span>${fn:substring(i.registerDate,0,10) }</span> <span>조회수 ${i.viewCount }</span>
					</div>
			</a></li>
		</c:forEach>
	</ul>
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