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
	<div class="recruit_search">
		<div class="selectbox_area">
			<!-- 검색박스 -->
			<form>
				<label for="number">지역별</label> <span class="selectbox type1"> <select id="number" title="지역">
						<option value="">서울특별시</option>
						<option value="">경기도</option>
						<option value="">강원도</option>
				</select>
				</span> <span class="selectbox type2"> <select id="number" title="지역">
						<option value="">강남구</option>
						<option value="">노원구</option>
						<option value="">관악구</option>
				</select>
				</span> <label for="kind">월세별</label> <span class="selectbox type3"> <select id="kind" title="월세별">
						<option value="">500</option>
						<option value="">1000</option>
						<option value="">1000</option>
						<option value="">1000</option>
						<option value="">1000</option>
						<option value="">1000</option>
				</select>
				</span> <label for="kind">경력별</label> <span class="selectbox type4"> <select id="kind" title="현업종">
						<option value="">정비</option>
						<option value="">정비</option>
						<option value="">정비</option>
						<option value="">정비</option>
						<option value="">정비</option>
						<option value="">정비</option>
						<option value="">정비</option>
				</select>
				</span> <input type="submit" value="검색하기" class="input_type6">
			</form>
		</div>
	</div>
	<form name="messageForm">
			<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>
	<div class="board_list">
		<!-- board_list -->
		<table>
			<caption>매장매매정보</caption>
			<colgroup>
				<col style="width: 15%" />
				<col style="width: 13%" />
				<col style="width: 8%" />
				<col style="width: 8%" />
				<col style="width: 8%" />
				<col style="width: 8%" />
				<col style="width: auto" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">등록일</th>
					<th scope="col">지역</th>
					<th scope="col">보증금</th>
					<th scope="col">월세</th>
					<th scope="col">권리금</th>
					<th scope="col">현업종</th>
					<th scope="col">제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td>${fn:substring(i.registerDate, 0, 10)}</td>
						<td>${i.varFiled1}</td>
						<td>${i.varFiled2}</td>
						<td>${i.varFiled3}</td>
						<td>${i.varFiled4}</td>
						<td>${i.varFiled5}</td>
						<td class="left"><a href="javascript:goMessageDetail('${i.messageId}');">${i.title }</a></td>
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