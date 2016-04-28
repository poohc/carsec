<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/board");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[
//goDetail
function goBoardDetail(id){
    var form = document.boardForm;
    form.boardId.value = id;
    form.action="./boardDetail.do";
    form.method="GET";
    form.submit();
}

//goSearch
function goBoardSearch(){
    var form = document.boardSearchForm;
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.boardSearchForm;
    form.pageNo.value = pageNo;
    form.submit();
}
//]]>
</script>
</head>

	<form name="boardForm" method="get">
	    <input type="hidden" name="boardId" value="">
	    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
	</form>

	<div class="title">게시판 관리</div>
	<div class="btn">
		<ul>
	    	<li class="btnFl"><a href="./boardForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
		    <li class="btnFr">
			    <form name="boardSearchForm" method="get">
			    <div class="searchinput">
				    <input type="hidden" name="pageNo" value="${boardList.boardSearchVO.pageNo}"/>
				    <select name="searchColumn">
				    	<option value=""${boardList.boardSearchVO.searchColumn==null || boardList.boardSearchVO.searchColumn==''?' selected':''}>선택</option>
				    	<option value="title"${boardList.boardSearchVO.searchColumn=='title'?' selected':''}>게시판명</option>
				    </select>
				    <input type="text" name="searchValue" value="${boardList.boardSearchVO.searchValue}" />
				</div>
				<div class="searchbtn">
		    		<a href="javascript:goBoardSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
		    	</div>
		    	</form>
		    </li>
	    </ul>
	</div>

	<table class="contents">
	    <colgroup>
	        <col width="15"></col>
	        <col></col>
	        <col width="100"></col>
	        <col width="100"></col>
	        <col width="200"></col>
	        <col width="100"></col>
	    </colgroup>

	    <thead>
	        <tr>
	            <th class="first">게시아이디 [Key]</th>
	            <th>게시판명</th>
	            <th>게시판타입</th>
	            <th>리스트수</th>
	            <th>카테고리관리</th>
	            <th>상태</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${boardList.boardList}" var="i" varStatus="iStatus">
	            <tr>
	                <td class="first">${i.boardId} [${i.boardKey}]</td>
	                <td><a href="javascript:goBoardDetail('${i.boardId}');"><c:out value="${i.title}"/></a> </td>
	                <td align="center">defautls</td>
	                <td align="center">${i.listLines} </td>
	                <td align="center"><a href="/admin/board/boardForm.do?boardId=${i.boardId}">[Modify]</a></td>
	                <td align="center">${i.statusType==1?'대기':'게시' }</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

	<div class="btn">
		<ul>
	    	<li class="btnFl"><a href="./boardForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
	    	<li class="btnFr"><a href="/admin/message/batchMessageSort.do"><img src="/common/images/admin/btn/btn_order_batch.gif" /></a></li>
		</ul>
	</div>

	<!-- Paging -->
	<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
	    <jsp:param name="count" value="${boardList.boardSearchVO.totalCount}" />
	    <jsp:param name="row" value="${boardList.boardSearchVO.row}" />
	    <jsp:param name="page" value="${boardList.boardSearchVO.pageNo}" />
	</jsp:include>

