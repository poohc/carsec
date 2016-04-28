<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/portlet");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[
//goForm
function goPortletForm(id){
    var form = document.portletForm;
    form.portletId.value = id;
    form.action="./portletForm.do";
    form.method="GET";
    form.submit();
}

//RemoveProc
function goPortletRemoveProc(id){
    var form = document.portletForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.portletId.value=id;
    	form.action="./portletRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}

//goList
function goList() {

<c:if test="${fn:length(param.listReturnURL)>0}">
	location.href="${param.listReturnURL}";
</c:if>

<c:if test="${fn:length(param.listReturnURL)==0}">
	location.href="./portletList.do?portletId=${portletManageVO.portletId}";
</c:if>
}
//]]>
</script>
</head>

<form name="portletForm" method="get" autocomplete="off">
    <input type="hidden" name="portletId" value="">
</form>

<div class="title">메인관리 폼</div>

<table class="contents">

    <colgroup>
        <col width="120px" />
        <col width="" />
    </colgroup>

    <tbody>

    <tr>
        <th>게시물 종류</th>
        <td>
			<c:if test="${portletManageVO.contentsType eq '1'}">동영상게시판</c:if>
			<c:if test="${portletManageVO.contentsType eq '2'}">일반게시판</c:if>
        </td>
    </tr>

    <tr>
        <th>제목</th>
        <td><c:out value="${portletManageVO.portletTitle}" /></td>
    </tr>
    <tr>
        <th>종류</th>
        <td>
        <c:out escapeXml="false" value="${portletManageVO.portletType=='1'?'태그검색':'컨텐츠등록'}" />
        </td>
    </tr>
    <tr>
        <th>오픈여부</th>
        <td>
        <c:out escapeXml="false" value="${portletManageVO.portletOpen=='0'?'닫침':'펼침'}" />
        </td>
    </tr>
    <tr>
        <th>컨텐츠 노출수</th>
        <td>
        <c:out escapeXml="false" value="${portletManageVO.contentsOpenCount}" />
        </td>
    </tr>
    <tr>
        <th>게시물상태</th>
        <td>
        <c:out escapeXml="false" value="${portletManageVO.statusType=='1'?'대기':'게재'}" />
        </td>
    </tr>
    </tbody>

</table>

<div class="btn">
	<ul>
	    <li class="btnFl"><a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	    <li class="btnFr">
	    <a href="javascript:goPortletForm('${portletManageVO.portletId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a>
	    <a href="javascript:goPortletForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a>
	    <a href="javascript:goPortletRemoveProc(${portletManageVO.portletId});"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
	    </li>
    </ul>
    <div style="clear: both"></div>
</div>
<br />
<br />
<div>
	메인 컨텐츠 리스트
</div>
<div class="btn">
	<ul>
	    <li class="btnFr">
	    <a href="./contentsForm.do?portletId=${portletManageVO.portletId}"><img src="/common/images/admin/btn/btn_write.gif" /></a>
	    </li>
    </ul>
    <div style="clear: both"></div>
</div>

<c:if test="${portletManageVO.portletType=='1'}">
<table class="contents">
    <colgroup>
        <col width="20"></col>
        <col></col>
        <col width="100"></col>
        <col width="100"></col>
        <col width="200"></col>
        <col width="100"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>태그</th>
            <th>순서</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${portletList.portletContentsList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${iStatus.index + 1}</td>
                <td align="center"><a href="contentsForm.do?portletConId=${i.portletConId}&portletId=${i.portletId}"><c:out value="${i.tags}"/></a></td>
                <td align="center">${i.orderNo}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>
<c:if test="${portletManageVO.portletType=='2'}">
<table class="contents">
    <colgroup>
        <col width="20"></col>
        <col></col>
        <col width="100"></col>
        <col width="100"></col>
        <col width="200"></col>
        <col width="100"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>제목</th>
            <th>순서</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${portletList.portletContentsList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${iStatus.index + 1}</td>
                <td><a href="contentsForm.do?portletConId=${i.portletConId}&portletId=${i.portletId}"><c:out value="${i.title}"/></a> </td>
                <td align="center">${i.orderNo}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>
</html>




