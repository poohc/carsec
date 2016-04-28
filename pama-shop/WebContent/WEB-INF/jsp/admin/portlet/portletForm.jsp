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
function goPortletRemoveProc(){
    var form = document.portletForm;

    if(confirm('정말로 삭제하시겠습니까?')){
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
<form name="portletForm" id="portletForm" class="dataForm" method="post" action="portletFormProc.do">
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
			<option value="1"<c:if test="${portletManageVO.contentsType eq '1'}"> selected="selected"</c:if>>동영상게시판</option>
			<option value="2"<c:if test="${portletManageVO.contentsType eq '2'}"> selected="selected"</c:if>>일반게시판</option>
			</select>
        </td>
    </tr>

    <tr>
        <th>제목</th>
        <td>
        <input type="text" name="portletTitle" id="portletTitle" class="required" minlength="4" maxlength="100" value="${portletManageVO.portletTitle }" style="width:590px;" /></td>
    </tr>
    <tr>
        <th>종류</th>
        <td>
			<select class="select" id="portletType" name="portletType">
			<option value="1"<c:if test="${portletManageVO.portletType eq '1'}"> selected="selected"</c:if>>태그검색</option>
			<option value="2"<c:if test="${portletManageVO.portletType eq '2'}"> selected="selected"</c:if>>컨텐츠등록</option>
			</select>
        </td>
    </tr>
    <tr>
        <th>오픈여부</th>
        <td>
			<select class="select" id="portletOpen" name="portletOpen">
			<option value="0"<c:if test="${portletManageVO.portletOpen eq '0'}"> selected="selected"</c:if>>닫침</option>
			<option value="1"<c:if test="${portletManageVO.portletOpen eq '1'}"> selected="selected"</c:if>>펼침</option>
			</select>
        </td>
    </tr>
    <tr>
        <th>컨텐츠노출수</th>
        <td>
			<select class="select" id="contentsOpenCount" name="contentsOpenCount">
			<option value="1"<c:if test="${portletManageVO.contentsOpenCount eq '' || videoVO.statusType eq '1'}"> selected="selected"</c:if>>1</option>
			<option value="2"<c:if test="${portletManageVO.contentsOpenCount eq '2'}"> selected="selected"</c:if>>2</option>
			<option value="3"<c:if test="${portletManageVO.contentsOpenCount eq '3'}"> selected="selected"</c:if>>3</option>
			<option value="4"<c:if test="${portletManageVO.contentsOpenCount eq '4'}"> selected="selected"</c:if>>4</option>
			<option value="5"<c:if test="${portletManageVO.contentsOpenCount eq '5'}"> selected="selected"</c:if>>5</option>
			<option value="6"<c:if test="${portletManageVO.contentsOpenCount eq '6'}"> selected="selected"</c:if>>6</option>
			<option value="7"<c:if test="${portletManageVO.contentsOpenCount eq '7'}"> selected="selected"</c:if>>7</option>
			<option value="8"<c:if test="${portletManageVO.contentsOpenCount eq '8'}"> selected="selected"</c:if>>8</option>
			<option value="9"<c:if test="${portletManageVO.contentsOpenCount eq '9'}"> selected="selected"</c:if>>9</option>
			<option value="10"<c:if test="${portletManageVO.contentsOpenCount eq '10'}"> selected="selected"</c:if>>10</option>
			</select>
        </td>
    </tr>
    <tr>
        <th>게시물상태</th>
        <td>
			<select class="select" id="statusType" name="statusType">
			<option value="1"<c:if test="${portletManageVO.statusType eq '' || videoVO.statusType eq '1'}"> selected="selected"</c:if>>대기</option>
			<option value="2"<c:if test="${portletManageVO.statusType eq '2'}"> selected="selected"</c:if>>게재</option>
			</select>
        </td>
    </tr>
    </tbody>

</table>

<div class="btn">
	<ul>
		<c:if test="${portletManageVO!=null && portletManageVO.portletId != '' }">
	    <li class="btnFl"><a href="javascript:goPortletRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a></li>
		</c:if>
		<li class="btnFr">
			<a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
			<input type="image" src="/common/images/admin/btn/btn_save.gif" />
		</li>
	</ul>
</div>
</form>

</html>




