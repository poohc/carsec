<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
<!--
function goList() {
	var form = document.bannerGroupForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "bannerGroupList.do";
	}
}
function goBannerGroupForm(id) {
    var form = document.bannerGroupForm;
    form.bannerGroupId.value = id;
    form.action="./bannerGroupForm.do";
    form.method="GET";
    form.submit();
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

<div class="title">배너그룹 상세</div>

<form name="bannerGroupForm" method="post" autocomplete="off">
<input type="hidden" name="bannerGroupId" value="${bannerGroupVO.bannerGroupId }" />
<input type="hidden" name="listReturnURL" value="" />
</form>

<table class="contents">
    <colgroup>
        <col width="180px"></col>
        <col></col>
    </colgroup>

    <tr>
        <th>회사/기관명</th>
        <td><c:out value="${bannerGroupVO.compyName}" /></td>
    </tr>

    <tr>
        <th>담당자명</th>
        <td><c:out value="${bannerGroupVO.personName}" /></td>
    </tr>

    <tr>
        <th>담당자 연락처</th>
        <td><c:out value="${bannerGroupVO.personTel}" /></td>
    </tr>

    <tr>
        <th>담당자 이메일</th>
        <td><c:out value="${bannerGroupVO.personEmail}" /></td>
    </tr>

    <tr>
        <th>게시여부</th>
        <td>
        	<c:choose>
        		<c:when test="${bannerGroupVO.statusType==2 || bannerGroupVO.statusType==0}">사용</c:when>
        		<c:when test="${bannerGroupVO.statusType==1}">미사용</c:when>
        	</c:choose>
         </td>
    </tr>

</table>
<div class="btn">
    <a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a>
    <a href="#;" onclick="goBannerGroupForm('${bannerGroupVO.bannerGroupId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a>
    <a href="#;" onclick="goBannerGroupRemove('${bannerGroupVO.bannerGroupId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
</div>

<br />
<br />
<div>
	배너 리스트
</div>
<br />
<table class="contents">
    <colgroup>
        <col width="20"></col>
        <col></col>
        <col width="200"></col>
        <col width="100"></col>
        <col width="100"></col>
        <col width="100"></col>
        <col width="100"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>배너위치</th>
            <th>배너게재기간</th>
            <th>오픈수</th>
            <th>클릭수</th>
            <th>등록일</th>
            <th>게재상태</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${bannerList.bannerInfoList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${iStatus.index + 1}</td>
                <td align="center"><a href="bannerForm.do?bannerId=${i.bannerId}"><c:out value="${i.bannerTitle}"/>(<c:out value="${i.bannerSize}" />)</a></td>
                <td align="center"><c:out value="${i.bannerStartDate}"/> ~ <c:out value="${i.bannerEndDate}"/></td>
                <td align="center"><c:out value="${i.openCount}"/></td>
                <td align="center"><c:out value="${i.clickCount}"/></td>
                <td align="center">${fn:substring(i.registerDate, 0, 10)}</td>
                <td align="center">${i.statusType==1?'대기':'게재' }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="btn">
	<ul>
	    <li class="btnFr">
	    <a href="./bannerForm.do?bannerGroupId=${bannerGroupVO.bannerGroupId}"><img src="/common/images/admin/btn/btn_write.gif" /></a>
	    </li>
    </ul>
    <div style="clear: both"></div>
</div>