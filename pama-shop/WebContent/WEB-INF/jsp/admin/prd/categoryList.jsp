<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pama.prd.vo.CategoryVO"%>
<%@page import="com.pama.common.util.SessionUtil"%>
<%@page import="com.pama.common.vo.SessionVO"%>
<%@page import="com.pama.common.Constants"%>
<%List<CategoryVO> category = (List<CategoryVO>)request.getAttribute("categoryListBox");%>
<%
	SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME, request);
	String userId = sessionVO.getMbrId();
%>
<%
request.setAttribute("webPath","/admin/prd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/admin/style.css">
<script type="text/javascript">
<!--
function goSubmit() {
    var form = document.categorySearchFrom;
    var bigCategory = form.selectBigCategory.value;
    var middleCategory = form.selectMiddleCategory.value;
    if(middleCategory != ""){
    	form.sortTree.value = middleCategory;
    }else if(bigCategory != ""){
    	form.sortTree.value = bigCategory;
    }
    form.action = "/admin/prd/categoryList.do";
    form.submit();
}

function statusTypeChange(statusType,cateId) {
	var statusTypeChangeUrl = '/admin/prd/categoryStatus.do?statusType='+statusType+'&'+'cateId='+cateId+'&'+'updateId='+'<%=userId%>';
    $.getJSON(statusTypeChangeUrl,
    	    function(data) {
                if(data.updateCount == '1'){
                	alert("상태 변경을 성공하였습니다.");
                }else{
                	alert("상태변경을 실패하였습니다.");
                }
		    });
    return false;
}
function middleCategoryChange(bigCategory) {
	var data = "";
    data += "<select name=\"selectMiddleCategory\" id=\"selectMiddleCategory\">";
    data += "<option value=\"\">- 중분류 -</option>";
<%

    if(category != null){
        for(int i = 0 ; i < category.size() ; i++){
        	CategoryVO categoryVO = (CategoryVO) category.get(i);

            String sortTree = categoryVO.getSortTree();
            String cateName = categoryVO.getCateName();
            if(sortTree.length() == 4){
            	String bigSortTree = categoryVO.getSortTree().substring(0,2);
%>
                if(bigCategory == '<%=bigSortTree%>'){
                	data += "<option value=\""+'<%=sortTree%>'+"\">"+'<%=cateName%>'+"</option>";
                }
<%
            }
        }
    }
%>
    data += "</select>";

    document.getElementById("middleCategory").innerHTML = data;
}

//-->
</script>
</head>
<body>
<div class="history"><a href="/admin/main/main.do">HOME</a> &gt; <a href="/admin/smp/sampleList.do">샘플</a> &gt;  Form</div>

<div class="title">카테고리 리스트</div>
<div class="btn">
    <div class="btnFl"><a href="/admin/prd/categoryForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
    <div style="clear: both"></div>
</div>
<form name="categorySearchFrom" method="get" autocomplete="off">
<input type="hidden" name="sortTree" value="" />
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="15%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
    </colgroup>
    <thead>
    </thead>
    <tbody>
        <tr>
            <th>대분류</th>
            <td>
                <span name="bigCategory" id="bigCategory">
	                <select name="selectBigCategory" id="selectBigCategory" onChange="javascript:middleCategoryChange(this.value);">
	                    <option value="">- 대분류 -</option>
	                    <c:forEach items="${categoryListBox}" var="bigCategoryList">
	                        <c:choose>
		                        <c:when test="${fn:length(bigCategoryList.sortTree) == '2'}">
	                                <option value="${bigCategoryList.sortTree}"<c:if test="${bigCategoryList.sortTree eq fn:substring(categoryVO.sortTree, 0, 2)}">selected</c:if>>${bigCategoryList.cateName}</option>
		                        </c:when>
	                        </c:choose>
	                    </c:forEach>
	                </select>
                </span>
            </td>
            <th>상태</th>
            <td>
                <select name="statusType" id="statusType">
                    <option value="">선택</option>
                    <option value="1"<c:if test="${categoryVO.statusType eq '1'}">selected</c:if>>대기</option>
                    <option value="2"<c:if test="${categoryVO.statusType eq '2'}">selected</c:if>>게시</option>
                </select>
            </td>
            <th>검색</th>
            <td><a href="javascript:goSubmit();"><img src="/common/images/admin/btn/btn_search.gif" /></a></td>
        </tr>
    </tbody>
</table>
</form>
<br />

<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="6%"></col>
        <col width="5%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width=""></col>
        <col width="8%"></col>
        <col width="6%"></col>
    </colgroup>
    <thead>
        <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>대분류</th>
            <th>중분류</th>
            <th>소분류</th>
            <th>카테고리 이미지</th>
            <th>무료버전 페이지</th>
            <th>등록 날짜</th>
            <th>상태</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categoryList}" var="categoryList" varStatus="categoryListCount">
            <tr>
                <td>${categoryListCount.count}</td>
                <td>${categoryList.sortTree}</td>
                <c:choose>
                    <c:when test="${fn:length(categoryList.sortTree) == '2'}">
                        <td><a href="/admin/prd/categoryForm.do?cateId=${categoryList.cateId}">${categoryList.cateName}</a></td>
                        <td></td>
                        <td></td>
                    </c:when>
                    <c:when test="${fn:length(categoryList.sortTree) == '4'}">
                        <td></td>
                        <td><a href="/admin/prd/categoryForm.do?cateId=${categoryList.cateId}">${categoryList.cateName}</a></td>
                        <td></td>
                    </c:when>
                    <c:when test="${fn:length(categoryList.sortTree) == '6'}">
                        <td></td>
                        <td></td>
                        <td><a href="/admin/prd/categoryForm.do?cateId=${categoryList.cateId}">${categoryList.cateName}</a></td>
                    </c:when>
                </c:choose>
                <td>${fn:split(categoryList.pageUrl,';')[0]}</td>
                <td>${fn:split(categoryList.pageUrl,';')[1]}</td>
                <td>${fn:substring(categoryList.registerDate, 0, 10)}</td>
                <td>
                    <select name="statusType" id="statusType" onChange="javascript:statusTypeChange(this.value,'${categoryList.cateId}');">
	                    <option value="1"<c:if test="${categoryList.statusType eq '1'}">selected</c:if>>대기</option>
	                    <option value="2"<c:if test="${categoryList.statusType eq '2'}">selected</c:if>>판매</option>
	                </select>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>