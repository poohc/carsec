<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
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
	var form = document.bannerGroupForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "bannerGroupList.do";
	}
}
//RemoveProc
function goBannerGroupRemove(id){
    var form = document.bannerGroupForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.bannerGroupId.value=id;
    	form.action="./bannerGroupRemove.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>

<div class="title">배너그룹 관리 폼</div>

<form name="bannerGroupForm" method="post" class="dataForm" action="${bannerGroupVO!=null && bannerGroupVO.bannerGroupId!=''?'./bannerGroupModify.do':'./bannerGroupRegister.do'}">
<input type="hidden" name="bannerGroupId" value="${bannerGroupVO.bannerGroupId }" />
<input type="hidden" name="listReturnURL" value="" />

<table class="contents">
    <colgroup>
        <col width="180px"></col>
        <col></col>
    </colgroup>
    <tr>
        <th>회사명</th>
        <td><input type="text" name="compyName" value="${bannerGroupVO.compyName }" style="width:300px;"/></td>
    </tr>
    <tr>
        <th>담당자명</th>
        <td><input type="text" name="personName" value="${bannerGroupVO.personName }" style="width:300px;"/></td>
    </tr>
    <tr>
        <th>담당자 연락처</th>
        <td><input type="text" name="personTel" value="${bannerGroupVO.personTel }" style="width:300px;"/></td>
    </tr>
    <tr>
        <th>담당자 이메일</th>
        <td><input type="text" name="personEmail" value="${bannerGroupVO.personEmail }" style="width:400px;"/></td>
    </tr>
    <tr>
        <th>사용여부</th>
        <td>
            <input type="radio" name="statusType" value="2"${bannerGroupVO.statusType==2?'checked':'' }>사용
            <input type="radio" name="statusType" value="1"${bannerGroupVO.statusType == null || bannerGroupVO.statusType==1?'checked':'' }>미사용
         </td>
    </tr>

</table>
<div class="btn">
<ul>
	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	<li class="btnFr">
		<c:if test="${bannerGroupVO!=null && bannerGroupVO.bannerGroupId!=''}">
		<a href="#;" onclick="goBannerGroupRemove('${bannerGroupVO.bannerGroupId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
		</c:if>
    	<input type="image" src="/common/images/admin/btn/btn_save.gif" />
    	<a href="#;" onclick="bannerGroupForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</li>
</ul>
</div>
</form>

