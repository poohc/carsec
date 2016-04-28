<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<link type="text/css" href="/common/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" />
<script type="text/javascript" src="/common/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">
<!--
function formChecker() {
    var form = document.bannerInfoForm;

    form.action = "${bannerInfoVO!=null && bannerInfoVO.bannerId!=''?'./bannerModify.do':'./bannerRegister.do'}";
    form.submit();

}

function goList() {
	var form = document.bannerInfoForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "bannerList.do";
	}
}
//RemoveProc
function goBannerRemove(id){
    var form = document.bannerInfoForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.bannerId.value=id;
    	form.action="./bannerRemove.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
<script type="text/javascript">
	$(function(){

		// Datepicker
		$('#bannerStartDate').datepicker({
			inline: true,
			dateFormat: 'yy-mm-dd'
		});

		// Datepicker
		$('#bannerEndDate').datepicker({
			inline: true,
			dateFormat: 'yy-mm-dd'
		});
	});
</script>
</head>

<div class="title">배너그룹 관리 폼</div>

<form name="bannerInfoForm" method="post" enctype="multipart/form-data">
<input type="hidden" name="bannerGroupId" value="4" />
<%-- ${bannerInfoVO.bannerGroupId!=null?bannerInfoVO.bannerGroupId:bannerSearchVO.bannerGroupId} --%>
<input type="hidden" name="bannerId" value="${bannerInfoVO.bannerId }" />
<input type="hidden" name="bannerOpenTags" value="${bannerInfoVO.bannerOpenTags }" style="width:300px;"/>
<input type="hidden" name="listReturnURL" value="${param.listReturnURL }" />



<table class="contents">
    <colgroup>
        <col width="180px"></col>
        <col></col>
    </colgroup>
    <tr>
        <th>배너위치</th>
        <td>
			<select class="select" id="bannerPlaceId" name="bannerPlaceId">
			<c:forEach items="${bannerList.bannerPlaceList}" var="i" varStatus="iStatus">
			<option value="${i.bannerPlaceId}"<c:if test="${bannerSearchVO.bannerPlaceId eq i.bannerPlaceId}"> selected="selected"</c:if>>[${i.bannerPlaceId}] ${i.bannerTitle}(${i.bannerSize})</option>
			</c:forEach>
			</select>
        </td>
    </tr>
    <tr>
        <th>배너게재일</th>
        <td>
			<INPUT type=text id="bannerStartDate" name="bannerStartDate" value="${bannerInfoVO.bannerStartDate }"> ~ <INPUT type=text id="bannerEndDate" name="bannerEndDate" value="${bannerInfoVO.bannerEndDate }">
			<div id="datepicker"></div>
        </td>
    </tr>
    <tr>
        <th>배너파일</th>
        <td><input type="file" name="file" id="file" />

        <c:if test="${bannerInfoVO.fileName!=null}">
        <br />
        <br />
        <br />
        <img src="/media/${bannerInfoVO.fileName}.image" width="400px"></c:if></td>
    </tr>
    <tr>
        <th>배너이동위치</th>
        <td>
            <input type="radio" name="bannerTargetType" value="2"${bannerInfoVO.bannerTargetType==2?'checked':'' }>새창
            <input type="radio" name="bannerTargetType" value="1"${bannerInfoVO.bannerTargetType == null || bannerInfoVO.bannerTargetType==1?'checked':'' }>현재창
         </td>
    </tr>
    <tr>
        <th>배너링크노출</th>
        <td>
            <input type="radio" name="bannerTargetOpen" value="2"${bannerInfoVO.bannerTargetOpen==2?'checked':'' }>오픈
            <input type="radio" name="bannerTargetOpen" value="1"${bannerInfoVO.bannerTargetOpen == null || bannerInfoVO.bannerTargetOpen==1?'checked':'' }>미오픈
         </td>
    </tr>
    <tr>
        <th>배너이동URL</th>
        <td><input type="text" name="bannerTargetUrl" value="${bannerInfoVO.bannerTargetUrl }" style="width:300px;"/></td>
    </tr>
    <tr>
        <th>게재여부</th>
        <td>
            <input type="radio" name="statusType" value="2"${bannerInfoVO.statusType==2?'checked':'' }>게재
            <input type="radio" name="statusType" value="1"${bannerInfoVO.statusType == null || bannerInfoVO.statusType==1?'checked':'' }>대기
         </td>
    </tr>

</table>
<div class="btn">
<ul>
	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	<li class="btnFr">
		<c:if test="${bannerInfoVO!=null && bannerInfoVO.bannerId!=''}">
		<a href="#;" onclick="goBannerRemove('${bannerInfoVO.bannerId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
		</c:if>
    	<a href="#;" onclick="formChecker();"><img src="/common/images/admin/btn/btn_save.gif" /></a>
    	<a href="#;" onclick="bannerGroupForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</li>
</ul>
</div>
</form>

