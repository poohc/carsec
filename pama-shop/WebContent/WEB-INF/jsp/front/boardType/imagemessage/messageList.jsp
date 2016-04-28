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

<c:if test="${isLogin }">
<script>
function goMessageForm(){
	form=document.messageForm;
	form.action="messageForm.do";
	form.submit();
}
</script>
</c:if>
<c:if test="${!isLogin }">
<script>
function goMessageForm() {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}
</script>
</c:if>

<c:if test="${fn:contains('newcar,newtech,maintennace,shopmarket,company1,company2,partsmarket',boardVO.boardKey) }">
<c:if test="${isLogin && sessionVO.level==40}">
<script>
function goMessageForm(){
	form=document.messageForm;
	form.action="messageForm.do";
	form.submit();
}
function goMessageDetail(id) {
	var form = document.messageForm;
	form.messageId.value = id;
	form.action = "messageDetail.do";

	form.method = "GET";
	form.submit();
}
</script>
</c:if>

<c:if test="${isLogin && sessionVO.level==10}">
<script>
function goMessageForm(){
	alert("메카닉회원만 이용할수 있습니다.");
}
function goMessageDetail(id) {
	alert("메카닉회원만 이용할수 있습니다.");
}
</script>
</c:if>

<c:if test="${!isLogin }">
<script>
function goMessageForm() {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}

function goMessageDetail(id) {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}

</script>
</c:if>
</c:if>

</head>
<body>
		<img src="/img/bullet/bullet_${boardVO.boardKey}.png"/>
		<form name="messageForm">
			<input type="hidden" name="messageId" value="" />
			<input type="hidden" name="listReturnURL" value="${currentURI}" />
		</form>
<c:if test="${boardVO.boardKey=='trafficlaw' }">
    <div class="write_search">

		<form name="messageSearchForm" method="get">
			<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
			<input type="hidden" name="searchColumn" value="title_contents" />
			<div class="left_area">
				<a href="#;" onclick="javascript:goMessageForm();" class="btn_search type3" title="글쓰기">글쓰기</a>
			</div>
		</form>
	</div>
</c:if>

		<ul class="gallery_layout2">
			<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
				<li class="on"><a href="javascript:goMessageDetail('${i.messageId}');"> <img src="/media/${i.showFile1}.image" width="228px" height="142px">

						<div class="gallery_introbox">
							<h1 class="elipsis">${i.title}</h1>
							<p>
								<c:out value="${fn:replace(i.summaryContents,'&nbsp;',' ') }" />
							</p>


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