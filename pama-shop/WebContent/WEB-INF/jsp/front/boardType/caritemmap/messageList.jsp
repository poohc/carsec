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
			<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
			<input type="hidden" name="searchColumn" value="title" />
			<div class="left_area">
			</div>
			<div class="right_area">
				<input type="text" name="searchValue" title="제목/내용" value="${messageList.messageSearchVO.searchValue}" />
				<button type="submit" class="btn_search" title="검색">검색</button>
			</div>
		</form>

		<form name="messageForm">
			<input type="hidden" name="messageId" value="" />
			<input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>
	</div>

	<div class="board_list">
		<!-- board_list -->
		<table>
			<caption>${boardVO.title }</caption>
    		<colgroup>
                <col style="width:17%" />
                <col style="width:35%" />
                <col style="width:auto" />
            </colgroup>
            <thead>
                <tr>
                    <th scope="col">부품명</th>
                    <th scope="col">영문명</th>
                    <th scope="col">장착위치</th>
                </tr>
            </thead>
            <tbody>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td>${i.title}</td>
						<td>${i.subTitle}</td>
						<td>${i.varFiled1}</td>
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