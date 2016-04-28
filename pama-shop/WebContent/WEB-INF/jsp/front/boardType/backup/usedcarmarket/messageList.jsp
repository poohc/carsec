<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
	<h1 class="h1_type1">중고차 매매 정보</h1>
	<div class="board_list2">
		<table>
			<caption>중고차 매매정보</caption>
			<colgroup>
				<col style="width: 20%">
				<col style="width: auto">
				<col style="width: 11%">
				<col style="width: 11%">
				<col style="width: 8%">
			</colgroup>
			<thead>
				<tr>
					<th colspan="2" scope="col">차량정보</th>
					<th scope="col">가격</th>
					<th scope="col">등록일</th>
					<th scope="col">지역</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td class="img"><a href="javascript:goMessageDetail('${i.messageId}');"><img src="/img/usedcar.jpg" alt="중고차사진1"></a></td>
						<td class="t_left"><a href="javascript:goMessageDetail('${i.messageId}');">
								<p class="used_p">${i.title }</p>
								<ul class="list_type5">
									<li>${i.registerName}</li>
									<li>${i.varFiled7}</li>
								</ul>
								<ul class="list_type5">
									<li>${i.varFiled3}</li>
									<li>${i.varFiled2}</li>
									<li>${i.varFiled4}km</li>
								</ul>
						</a></td>
						<td><strong>${i.varFiled5}</strong> 만원</td>
						<td>${fn:substring(i.registerDate, 0, 10)}</td>
						<td>미지역</td>
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

	<form name="messageSearchForm" method="get">
		<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> <input type="hidden" name="searchColumn" value="title_contents" />
		<div class="left_area">
			<a href="messageForm.do" class="btn_search type3" title="글쓰기">글쓰기</a>
		</div>
	</form>
</body>
</html>