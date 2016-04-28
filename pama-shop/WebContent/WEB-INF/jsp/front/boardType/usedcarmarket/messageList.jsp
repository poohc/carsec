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
<img src="/img/bullet/bullet_used.png"/>

   <div class="write_search">

		<form name="messageForm">
			<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>
		<div class="left_area">
				<a href="/bbs/usedcarmarket/messageForm.do" class="btn_search type3" title="글쓰기">중고차 매물 등록</a>
		</div>
	</div>

	<div class="board_list2">
		<table>
			<caption>중고차 매매정보</caption>

			<colgroup>
				<col style="width: 25%">
				<col style="width: 25%">
				<col style="width: 10%">
				<col style="width: 20%">
				<col style="width: 10%">
			</colgroup>
			<thead>
				<tr>
					<th colspan="2" scope="col">차량정보</th>
					<th scope="col">가격</th>
					<th scope="col">등록일</th>
					<th scope="col">주행거리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td class="img"><a href="javascript:goMessageDetail('${i.messageId}');"><img src="/media/${i.showFile1}.image" width="173px" height="107px"></a></td>
						<td class="t_left"><a href="javascript:goMessageDetail('${i.messageId}');">
								<p class="used_p">${i.title }</p>
								<ul class="list_type5">
									<li>${i.registerName}</li>
									<li>${i.varFiled8}</li>
								</ul>
								<ul class="list_type5">
									<li>${i.varFiled3}식</li>
									<li>${i.varFiled1}</li>
									<li>${i.varFiled2}</li>
								</ul>
						</a></td>
						<td><strong>${i.varFiled5}</strong> 만원</td>
						<td>${fn:substring(i.registerDate, 0, 10)}</td>
						<td>${i.varFiled4}</td>
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