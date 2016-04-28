<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/banner");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">

<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>

<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	return true;
}
function goList() {
	var form = document.bannerPlaceForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "bannerPlaceList.do";
	}
}
//RemoveProc
function goBannerPlaceRemove(id){
    var form = document.bannerPlaceForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.bannerPlaceId.value=id;
    	form.action="./bannerPlaceRemove.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>

<div class="title">배너위치 관리 폼</div>

<form name="bannerPlaceForm" method="post" class="dataForm" action="${bannerPlaceVO!=null && bannerPlaceVO.bannerPlaceId!=''?'./bannerPlaceModify.do':'./bannerPlaceRegister.do'}">
<input type="hidden" name="bannerPlaceId" value="${bannerPlaceVO.bannerPlaceId }" />
<input type="hidden" name="listReturnURL" value="" />

<table class="contents">
    <colgroup>
        <col width="180px"></col>
        <col></col>
    </colgroup>
    <tr>
        <th>배너위치명</th>
        <td><input type="text" name="bannerTitle" id="bannerTitle" class="required" value="${bannerPlaceVO.bannerTitle }" style="width:400px"/></td>
    </tr>
    <tr>
        <th>배너사이즈</th>
        <td><input type="text" name="bannerSize" id="bannerTitle" class="required" value="${bannerPlaceVO.bannerSize }" style="width:400px"/></td>
    </tr>
    <tr>
        <th>배너위치 설명</th>
        <td><textarea name="bannerMemo" style="width:500px; height:200px;">${bannerPlaceVO.bannerMemo }</textarea></td>
    </tr>
    <tr>
        <th>사용여부</th>
        <td>
            <input type="radio" name="statusType" value="2"${bannerPlaceVO.statusType==2?'checked':'' }>사용
            <input type="radio" name="statusType" value="1"${bannerPlaceVO.statusType == null || bannerPlaceVO.statusType==1?'checked':'' }>미사용
         </td>
    </tr>

</table>
<div class="btn">
<ul>
	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	<li class="btnFr">
		<c:if test="${bannerPlaceVO!=null && bannerPlaceVO.bannerPlaceId!=''}">
		<a href="#;" onclick="goBannerPlaceRemove('${bannerPlaceVO.bannerPlaceId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
		</c:if>
    	<input type="image" src="/common/images/admin/btn/btn_save.gif" />
    	<a href="#;" onclick="bannerPlaceForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</li>
</ul>
</div>
</form>

