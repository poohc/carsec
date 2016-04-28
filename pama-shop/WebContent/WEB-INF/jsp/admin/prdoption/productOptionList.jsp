<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@page import="com.pama.common.util.SessionUtil"%>
<%@page import="com.pama.common.vo.SessionVO"%>
<%@page import="com.pama.common.Constants"%>
<%
	SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
    String userId = sessionVO.getMbrId();
    String updateIp = request.getRemoteAddr();
%>
<%
request.setAttribute("webPath","/admin/prd/license");
%>
<head>
<script type="text/javascript">
<!--
function goProductOptionDetail(id){
    var form = document.productOptionForm;
    form.optId.value = id;
    form.action="./productOptionForm.do";
    form.method="GET";
    form.submit();
}

//goSearch
function goProductOptionSearch(){
    var form = document.productOptionSearchFrom;
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.productOptionSearchFrom;
    form.pageNo.value = pageNo;
    form.submit();
}
//-->
</script>
</head>

<body>
<div class="history"><a href="/admin/main/main.do">HOME</a> &gt; 쇼핑 &gt; 상품옵션 리스트</div>

<div class="title">옵션 리스트</div>
<div class="btn">
    <div class="btnFl"><a href="/admin/prdoption/productOptionForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
    <div style="clear: both"></div>
</div>
<form name="productOptionForm" method="get">
    <input type="hidden" name="optId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>
<form name="productOptionSearchFrom" method="get" autocomplete="off">
<input type="hidden" name="pageNo" value="${productOptionList.productOptionSearchVO.pageNo}"/>
<input type="hidden" name="row" id="row" disabled/>
<table class="contents">
    <colgroup>
        <col width="20%"></col>
        <col ></col>
        <col width="20%"></col>
        <col width="30%"></col>
    </colgroup>
    <thead>
    </thead>
    <tbody>
        <tr>
            <th>옵션명</th>
            <td>
                <input type="text" name="optName" maxlength="20" size="20" value="${productOptionList.productOptionSearchVO.optName}"/>
            </td>
            <th>검색</th>
            <td>
            <a href="javascript:goProductOptionSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
            </td>
        </tr>
    </tbody>
</table>
</form>
<br />

<form name="optionListForm">
<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="18%"></col>
        <col width=""></col>
        <col width="15%"></col>
    </colgroup>
    <thead>
        <tr>
            <th>번호</th>
            <th>옵션명</th>
            <th>등록일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productOptionList.productOptionList}" var="i" varStatus="listCount">
            <tr>
                <td>${productOptionList.productOptionSearchVO.pageStartIndex - listCount.index}</td>
                <td><a href="javascript:goProductOptionDetail(${i.optId});">${i.optName}</a></td>
                <td>${fn:substring(i.registerDate, 0, 10)}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</form>
<!-- Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${productOptionList.productOptionSearchVO.totalCount}" />
    <jsp:param name="row" value="${productOptionList.productOptionSearchVO.row}" />
    <jsp:param name="page" value="${productOptionList.productOptionSearchVO.pageNo}" />
</jsp:include>
</body>