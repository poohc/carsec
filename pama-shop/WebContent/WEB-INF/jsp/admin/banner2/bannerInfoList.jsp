<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goPage
function goPage(pageNo){
    var form = document.bannerForm;
    form.pageNo.value = pageNo;
    form.submit();
}
function goPlace(id){
	location.href="?bannerPlaceId="+id;

}
//goPage
function goForm(bannerId){

	var listReturnURL=encodeURIComponent("${currentURI}");
	location.href="bannerForm.do?bannerId="+bannerId+"&bannerPlaceId=${param.bannerPlaceId}&listReturnURL="+listReturnURL;
}


//]]>
</script>
</head>

	<form name="bannerForm" method="get">
	    <input type="hidden" name="pageNo" value="${bannerList.bannerSearchVO.pageNo}">
	    <input type="hidden" name="listReturnURL" value="${currentURL}" />
	</form>


		<div class="title">배너 위치 관리</div>
		<div class="btn">
				<select class="select" id="bannerPlaceId" name="bannerPlaceId" onchange="goPlace(this.value);">
				<option value="0" <c:if test="${param.bannerPlaceId eq '0'}"> selected="selected"</c:if>>ALL</option>
				<c:forEach items="${bannerList.bannerPlaceList}" var="i" varStatus="iStatus">
				<option value="${i.bannerPlaceId}" <c:if test="${param.bannerPlaceId eq i.bannerPlaceId}"> selected="selected"</c:if>>[${i.bannerPlaceId }] ${i.bannerTitle}(${i.bannerSize})</option>
				</c:forEach>
				</select>
		    <div class="btnFr"><a href="bannerForm.do?bannerPlaceId=${param.bannerPlaceId}"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
		    <div style="clear: right;"></div>
		</div>
	</form>

	<table class="contents">
	    <colgroup>
	        <col width="10px"></col>
	        <col width="200"></col>
	        <col width=""></col>
	        <col width="200"></col>
	        <col width="70"></col>
	        <col width="70"></col>
	        <col width="100"></col>
	        <col width="100"></col>
	    </colgroup>

	    <thead>
	        <tr>
	            <th class="first">No</th>
	            <th>배너위치명</th>
	            <th>배너이미지</th>

	            <th>배너게재기간</th>
	            <th>조회수</th>
	            <th>등록일</th>
	            <th>상태</th>
	        </tr>
	    </thead>
	    <tbody>

	        <c:forEach items="${bannerList.bannerInfoList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${bannerList.bannerSearchVO.pageStartIndex - iStatus.index}</td>
                <td align="center"><c:out value="${i.bannerTitle}" />(<c:out value="${i.bannerSize}" />)[${i.bannerPlaceId }]</td>
                <td><a href="javascript:goForm('${i.bannerId}');"><img src="/media/${i.fileName}.image" width="120"  /></a></td>
                <td align="center"><c:out value="${i.bannerStartDate}"/> ~ <c:out value="${i.bannerEndDate}"/></td>
                <td align="center"><c:out value="${i.openCount}"/></td>
                <td align="center">${fn:substring(i.registerDate, 0, 10)}</td>
                <td align="center">${i.statusType==1?'대기':'게재' }</td>
            </tr>
	        </c:forEach>
	    </tbody>
	</table>

	<!-- Paging -->
	<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
	    <jsp:param name="count" value="${bannerList.bannerSearchVO.totalCount}" />
	    <jsp:param name="row" value="${bannerList.bannerSearchVO.row}" />
	    <jsp:param name="page" value="${bannerList.bannerSearchVO.pageNo}" />
	</jsp:include>
