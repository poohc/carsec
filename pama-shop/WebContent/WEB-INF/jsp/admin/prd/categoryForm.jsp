<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pama.prd.vo.CategoryVO"%>
<%List<CategoryVO> category = (List<CategoryVO>)request.getAttribute("categoryListBox");%>
<%
request.setAttribute("webPath","/admin/prd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/admin/style.css">
<script type="text/javascript">
<!--
function goList(){
	history.back(-1);
}
function categoryFromAdd() {
    var form = document.categoryFrom;
    var cateId = form.cateId.value;
    var cateName = form.cateName.value;

    if(cateName == ""){
    	alert("카테고리 이름을 입력 해 주세요.");
    	form.cateName.focus();
    	return;
    }
	form.sortTree.value;
    form.action = "/admin/prd/categoryFormProc.do";
    form.submit();
}
function categoryFromRemove() {
	var form = document.categoryFrom;
    form.action = "/admin/prd/categoryRemove.do";
    form.submit();
}

function categoryFromModify() {

    var form = document.categoryFrom;
    var cateName = form.cateName.value;

    if(cateName == ""){
    	alert("카테고리 이름을 입력 해 주세요.");
    	form.cateName.focus();
    	return;
    }

    form.sortTree.value;

    form.action = "/admin/prd/categoryModify.do";
    form.submit();
}
function categoryValidation(categoryNumber){
	var form = document.categoryFrom;
	var bigCategory = form.selectBigCategory.value;
    var middleCategory = form.selectMiddleCategory.value;
    var bigCategoryLength = form.selectBigCategory.value.length;
    var middleCategoryLength = form.selectMiddleCategory.value.length;
	var categoryNumberLength = categoryNumber.length;
	var AllSortTree = "";

	if(categoryNumberLength != 2){
		alert("두자리 수 이상 입력하여 주세요.");
		return false;
	}

    if(middleCategoryLength != 0){
    	AllSortTree = middleCategory + categoryNumber;
    }else if(bigCategoryLength != 0){
    	AllSortTree = bigCategory + categoryNumber;
    }else{
    	AllSortTree = categoryNumber;
    }
    form.sortTree.value = AllSortTree;
    var statusTypeChangeUrl = '/admin/prd/categoryListCount.do?sortTree='+AllSortTree;
    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.categoryListCount == '1'){
                    alert("이미 존재하는 분류입니다.");
                    form.smallCategory.value = "";
                    form.smallCategory.focus();
                }
            });
    return false;
}

function numbersonly(e, decimal) {
    var key;
    var keychar;

    if (window.event) {
        key = window.event.keyCode;
    } else if (e) {
        key = e.which;
    } else {
        return true;
    }
    keychar = String.fromCharCode(key);

    if ((key == null) || (key == 0) || (key == 8) || (key == 9) || (key == 13)
            || (key == 27)) {
        return true;
    } else if ((("0123456789").indexOf(keychar) > -1)) {
        return true;
    } else if (decimal && (keychar == ".")) {
        return true;
    } else
        return false;
}

function statusTypeChange(statusType, cateId) {
    var statusTypeChangeUrl = '/admin/prd/categoryStatus.do?statusType='+statusType+'&'+'cateId='+cateId;
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
<c:if test="${not empty CategoryFormVO}">
    <div class="title">카테고리 수정</div>
</c:if>
<c:if test="${empty CategoryFormVO}">
    <div class="title">카테고리 등록</div>
</c:if>
<form name="categoryFrom" method="post" autocomplete="off">
<input type="hidden" name="cateId" value="${CategoryFormVO.cateId}" />
<input type="hidden" name="pageUrl" value="" />
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width=""></col>
        <col width="15%"></col>
        <col width=""></col>
    </colgroup>
    <thead>
    </thead>
    <tbody>
    	<tr>
    		<th>분류1</th>
    		<td>
    		<select name="sortTree" id="sortTree">
    			<option value="10"<c:if test="${CategoryFormVO.sortTree eq '10'}">selected</c:if>>병원</option>
    			<option value="20"<c:if test="${CategoryFormVO.sortTree eq '20'}">selected</c:if>>뷰티샵</option>
    			<option value="30"<c:if test="${CategoryFormVO.sortTree eq '30'}">selected</c:if>>culture</option>
    		</select>
    		</td>
        </tr>
            <th>카테고리 이름</th>
            <td>
            <input type="hidden" name="smallCategory" value="10"/>
            <input type="text" name="cateName" value="${CategoryFormVO.cateName}" maxlength="20" size="20" /></td>
        </tr>
        <tr>
            <th>상태</th>
            <td>
                <select name="statusType" id="statusType">
                    <option value="1"<c:if test="${CategoryFormVO.statusType eq '1'}">selected</c:if>>대기</option>
                    <option value="2"<c:if test="${CategoryFormVO.statusType eq '2'}">selected</c:if>>게시</option>
                </select>
            </td>
        </tr>
    </tbody>
</table>
<div class="btn">
    <c:if test="${not empty CategoryFormVO}">
       <a href="javascript:categoryFromModify();"><img src="/common/images/admin/btn/btn_modify.gif" /></a>
       <a href="javascript:categoryFromRemove();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
    </c:if>
    <c:if test="${empty CategoryFormVO}">
       <a href="javascript:categoryFromAdd();"><img src="/common/images/admin/btn/btn_save.gif" /></a>
       <a href="#;" onclick="categoryFrom.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
    </c:if>
    <a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
</div>
</form>
<br />
</body>
</html>