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

<c:if test="${isLogin && sessionVO.level==40}">
<script>
function goMessageForm(){
	form=document.messageForm;
	form.action="messageForm.do";
	form.submit();
}
</script>
</c:if>
<c:if test="${isLogin && sessionVO.level==10}">
<script>
function goMessageForm(){
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
</script>
</c:if>

</head>
<body>
	<img src="/img/bullet/bullet_recruit.png"/>
	<div class="write_search">
		<form name="messageSearchForm" method="get">
			<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> <input type="hidden" name="searchColumn" value="title_contents" />


			<div class="left_area">
				<a href="#" onclick="javascript:goMessageForm();" class="btn_search type3" title="글쓰기">글쓰기</a>
			</div>


			<div class="right_area">
				<input type="text" title="제목/내용" value="${messageList.messageSearchVO.searchValue}" />
				<button type="submit" class="btn_search" title="검색">검색</button>
			</div>
		</form>
		<form name="messageForm">
			<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>
	</div>

	<div class="board_list">
		<!-- board_list -->
		<table>
			<caption>구인구직정보</caption>
			<colgroup>
				<col style="width: 16%" />
				<col style="width: 16%" />
				<col style="width: 16%" />
				<col style="width: auto" />
				<col style="width: 15%" />
				<col style="width: 15%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">작성일</th>
					<th scope="col">지역</th>
					<th scope="col">업체명</th>
					<th scope="col">구인내역</th>
					<th scope="col">서비스품목</th>
					<th scope="col">전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr onclick="javascript:goMessageDetail('${i.messageId}');">
						<td>${fn:substring(i.registerDate, 0, 10)}</td>
						<td>${i.varFiled1}</td>
						<td>${i.varFiled2}</td>
						<td><a href="javascript:goMessageDetail('${i.messageId}');">${i.varFiled3 }</a></td>
						<td>${i.varFiled4}</td>
						<td>${i.varFiled8}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- //board_list -->
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