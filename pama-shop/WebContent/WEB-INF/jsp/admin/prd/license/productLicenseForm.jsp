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
request.setAttribute("webPath","/admin/prd/license");
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

function middleCategoryChange(cateId, selectId) {
	if (cateId=='') return;
	$.getJSON('/admin/prd/productCategoryList.json?cateId=' + cateId, function(data) {
	    var option = "";
	    option += "<select name=\"prdId\" id=\"prdId\" class=\"prdId\">";
	    option += "<option value=\"\">- 상품선택 -</option>";
		$.each(data.productList.productList, function(index, entry){
			option += "<option value=\""+entry["prdId"]+"\">"+entry["prdName"]+"</option>";
		});
		option += "</select>";
		$("#middleCategory").html(option);
		$(".prdId > option[value="+selectId+"]").attr("selected", "true");
		//alert($(".prdId option:selected").val());
		//alert($(".prdId > option[value=2]").text());
	});

}

//RemoveProc
function goPrdLicenseRemoveProc(){
    var form = document.productFormRemove;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./productLicenseStatus.do";
    	form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>
<body>

<c:if test="${not empty productLicenseVO}">
	<div class="title">라이센스 수정</div>
</c:if>
<c:if test="${empty productLicenseVO}">
	<div class="title">라이센스 등록</div>
</c:if>


<form name="productFormRemove" method="post">
<input type="hidden" name="prdLicenseId" value="${productLicenseVO.prdLicenseId}" />
</form>
<form name="productForm" id="productForm" method="post" class="productForm" action="${empty productLicenseVO ? 'productLicenseFormProc.do':'productLicenseModify.do'}">
<input type="hidden" name="listReturnURL" value="" />
<input type="hidden" name="prdLicenseId" value="${productLicenseVO.prdLicenseId}" />
<input type="hidden" name="licensePublishType" value="1" />
<table class="contents">
    <tr>
        <th>상품분류</th>
        <td>
        <c:if test="${empty productLicenseVO}">
        	<span name="bigCategory" id="bigCategory">
	            <select name="cateId" id="cateId" onChange="middleCategoryChange(this.value, '');">
	                <option value="">- 상품분류 -</option>
	                <c:forEach items="${categoryListBox}" var="bigCategoryList">
	                	<option value="${bigCategoryList.cateId}"<c:if test="${bigCategoryList.cateId eq productLicenseVO.cateId}">selected</c:if>>${bigCategoryList.cateName}</option>
	                </c:forEach>
	            </select>
			</span>
		</c:if>
		<c:if test="${not empty productLicenseVO}">
			<c:out value="${productLicenseVO.cateName}" />
		</c:if>
        </td>
    </tr>
    <tr>
        <th>상품</th>
        <td>
        	<span id="middleCategory">
	            <select name="prdId" id="prdId" class="prdId" onChange="smallCategoryChange(this.value);">
	                <option value="">- 상품선택 -</option>
	            </select>
	        </span>
        </td>
    </tr>
    <tr>
        <th>라이센스코드</th>
        <td><input type="text" name="licenseCode" maxlength="50" size="20" value="${productLicenseVO.licenseCode}"/></td>
    </tr>
</table>

<div class="btn">
	<c:if test="${not empty productLicenseVO}">
	   <input type="image" src="/common/images/admin/btn/btn_modify.gif" />
	   <a href="javascript:goPrdLicenseRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
	</c:if>
	<c:if test="${empty productLicenseVO}">
	   <input type="image" src="/common/images/admin/btn/btn_save.gif" />
	   <a href="#;" onclick="productForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</c:if>
    <a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
</div>
</form>
<script type="text/javascript">
<!--
	middleCategoryChange('${productLicenseVO.cateId}','${productLicenseVO.prdId}');
//-->
</script>
</body>
</html>