<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/board/category");
%>

<head>
<link rel="stylesheet" type="text/css" href="/css/admin/style.css">
<script type="text/javascript">
<!--
function formChecker() {
    var form = document.messageCategoryForm;

    form.action = "./messageCategoryFormProc.do";
    form.submit();

}

function goList() {
	var form = document.messageCategoryForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "messageCategoryList.do";
	}
}

//RemoveProc
function goMessageCategoryRemoveProc(){
    var form = document.messageCategoryForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./messageCategoryRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>

<div class="title">게시판 폼</div>

<form name="messageCategoryForm" method="post">
<input type="hidden" name="boardId" value="${messageCategoryVO==null? boardVO.boardId:messageCategoryVO.boardId}" />
<input type="hidden" name="messageCategoryId" value="${messageCategoryVO.messageCategoryId }">
<input type="hidden" name="sortTree" value="${messageCategoryVO.sortTree }" />
<input type="hidden" name="listReturnURL" value="" />

<table class="contents">
    <tr>
        <th>카테고리명</th>
        <td><input type="text" name="messageCategoryName" value="${messageCategoryVO.messageCategoryName }"/></td>
    </tr>

</table>
<div class="btn">
	<ul>
	    <li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
    	<li class="btnFr">
    		<a href="#;" onclick="formChecker();"><img src="/common/images/admin/btn/btn_save.gif" /></a>
    		<a href="#;" onclick="boardForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
			<c:if test="${messageCategoryVO!=null}">
			<a href="javascript:goMessageCategoryRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
			</c:if>
    	</li>
	</ul>
</div>
</form>

