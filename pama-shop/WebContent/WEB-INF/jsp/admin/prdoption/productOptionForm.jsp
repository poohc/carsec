<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ page import="java.util.List"%>
<%@page import="com.pama.common.util.SessionUtil"%>
<%@page import="com.pama.common.vo.SessionVO"%>
<%@page import="com.pama.common.Constants"%>
<%
	SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
    String userId = sessionVO.getMbrId();
    String updateIp = request.getRemoteAddr();
%>
<%
request.setAttribute("webPath","/admin/prdoption");
%>
<html>
<head>
<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	return true;
}

//RemoveProc
function goPrdOptionRemoveProc(){
    var form = document.productOptionFormRemove;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./productOptionStatus.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>
<body>

<c:if test="${not empty productOptionVO}">
	<div class="title">옵션 수정</div>
</c:if>
<c:if test="${empty productOptionVO}">
	<div class="title">옵션 등록</div>
</c:if>


<form name="productOptionFormRemove" method="post">
<input type="hidden" name="optId" value="${productOptionVO.optId}" />
</form>
<form name="productOptionForm" id="productOptionForm" method="post" class="productOptionForm" action="${empty productOptionVO ? 'productOptionFormProc.do':'productOptionModify.do'}">
<input type="hidden" name="listReturnURL" value="" />
<input type="hidden" name="optId" value="${productOptionVO.optId}" />
<table class="contents">
    <tr>
        <th>옵션명</th>
        <td><input type="text" name="optName" maxlength="50" size="20" value="${productOptionVO.optName}"/></td>
    </tr>
</table>

<div class="btn">
	<c:if test="${not empty productOptionVO}">
	   <input type="image" src="/common/images/admin/btn/btn_modify.gif" />
	   <a href="javascript:goPrdOptionRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
	</c:if>
	<c:if test="${empty productOptionVO}">
	   <input type="image" src="/common/images/admin/btn/btn_save.gif" />
	   <a href="#;" onclick="productForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</c:if>
    <a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
</div>
</form>
</body>
</html>