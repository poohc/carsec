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
	<div class="write_search">
		<form name="messageSearchForm" method="get">
			<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> <input type="hidden" name="searchColumn" value="title_contents" />
			<div class="left_area">
				<a href="messageForm.do" class="btn_search type3" title="글쓰기">글쓰기</a>
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
			<caption>${boardVO.title }</caption>
			<colgroup>
				<col style="width: 15%" />
				<col style="width: 15%" />
				<col style="width: auto" />
				<col style="width: 15%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">게시일</th>
					<th scope="col">닉네임</th>
					<th scope="col">제 목</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td>${fn:substring(i.registerDate, 0, 10)}</td>
						<td>${i.registerNickname}</td>
						<td class="left"><a href="javascript:goMessageDetail('${i.messageId}');">${i.title }</a></td>
						<td>${i.viewCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
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