<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/portlet");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css"/>

<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>

<script type="text/javascript">
//<![CDATA[
//isForms
function isForms(f) {
	return true;
}

//RemoveProc
function goContentsRemoveProc(){
    var form = document.contentsForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./contentsRemoveProc.do";
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
	location.href="./portletDetail.do?portletId=${portletContentsVO.portletId}";
</c:if>
}
//]]>
</script>
</head>
<form name="contentsForm" id="contentsForm" class="dataForm" method="post" action="contentsFormProc.do"${portletManageVO.portletType=='2'?' enctype="multipart/form-data"':''}>
<input type="hidden" name="portletConId" value="${portletContentsVO.portletConId }">
<input type="hidden" name="portletId" value="${portletManageVO.portletId }">

<div class="title">${uccVO.title } 폼</div>

<table class="contents">

    <colgroup>
        <col width="120px" />
        <col width="" />
    </colgroup>

    <tbody>

    <tr>
        <th>게시물 종류</th>
        <td>
			<select class="select" id="contentsType" name="contentsType">
			<option value="1"<c:if test="${portletContentsVO.contentsType eq '1'}"> selected="selected"</c:if>>동영상게시판</option>
			<option value="2"<c:if test="${portletContentsVO.contentsType eq '2'}"> selected="selected"</c:if>>일반게시판</option>
			</select>
        </td>
    </tr>

    <c:if test="${portletManageVO.portletType=='2'}">
    <tr>
        <th>제목</th>
        <td>
        <input type="text" name="title" id="title" minlength="4" maxlength="100" value="${portletContentsVO.title }" style="width:590px;" />
        </td>
    </tr>
    <tr>
        <th>이미지</th>
        <td>
			<c:if test="${portletContentsVO != null && portletContentsVO.thumbnailUrl != ''}"><img src="${portletContentsVO.thumbnailUrl}" width="40px" height="30px"></c:if>
			<input type="file" name="file" id="file" />
        </td>
    </tr>
    <tr>
        <th>요약내용</th>
        <td>
			<textarea name="summaryContents" id="summaryContents" style="width:590px; height: 50px;">${portletContentsVO.summaryContents }</textarea>
        </td>
    </tr>
    </c:if>
    <c:if test="${portletManageVO.portletType=='1'}">
    <tr>
        <th>태그</th>
        <td>
			<input type="text" name="tags" id="tags" value="${portletContentsVO.tags }" style="width:490px;" />
        </td>
    </tr>
    </c:if>
    <tr>
        <th>링크주소</th>
        <td>
			<input type="text" name="targetLinkUrl" id="targetLinkUrl" value="${portletContentsVO.targetLinkUrl }" style="width:490px;" />
        </td>
    </tr>
    <tr>
        <th>순서</th>
        <td>
			<input type="text" name="orderNo" id="orderNo" value="${portletContentsVO.orderNo }" style="width:50px;" />
        </td>
    </tr>
    </tbody>

</table>

<div class="btn">
	<ul>
	    <li class="btnFl">
	    	<a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
	    </li>
		<li class="btnFr">
			<c:if test="${portletContentsVO!=null && portletContentsVO.portletConId != '' }">
			<a href="javascript:goContentsRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
			</c:if>
			<input type="image" src="/common/images/admin/btn/btn_save.gif" />
		</li>
	</ul>
</div>
</form>

</html>




