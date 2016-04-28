<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/prd");
%>
<html>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	return true;
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

function productFromRemove() {
	var form = document.productFormRemove;
    form.action = "/admin/prd/productRemove.do";
    form.submit();
}

function goList() {
	var form = document.productForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "productList.do";
	}
}
//var oEditors = [];
//window.onload = function() {

//    nhn.husky.EZCreator.createInIFrame({
//        oAppRef: oEditors,
//        elPlaceHolder: "contents",
//        sSkinURI: "/common/SmartEditorBasic/SEditorSkin.html",
//        fCreator: "createSEditorInIFrame"
//    });
//}

function prdOptionStatus(obj, optId) {
	var f = document.productForm;
	var statusTypeChangeUrl = 'productOptStatus.do';

	$.ajax({
		  dataType: "json",
		  url: statusTypeChangeUrl,
		  async: false,
		  data: 'prdId='+f.prdId.value+'&optId='+optId,
		  success: function(data) {
		        if (data.updateCede=='1') {
		        	$(obj).parent().remove();
		        }
		  }
	});
}

function prdOptionRemove(obj) {
	$(obj).parent().remove();
}

function newOption(obj) {
	if (obj.value=="") return;
	option = obj.value.split("|");
	var chkInput = true;
	var optionInput = $("#optId");
	$('input[name="optId"]').each(function() {
    	if($(this).val()==option[0]) {
    		chkInput = false;
    	}
	});

	if (chkInput) {
		$("#optInfobox").after(" " +
	        	"<div>" +
	        	"<input type=\"hidden\" name=\"oldOptId\" id=\"oldOptId\" value=\"\"/>" +
	        	"<input type=\"hidden\" name=\"optId\" id=\"optId\" value=\""+option[0]+"\"/>" +
	        	"<input type=\"text\" name=\"optName\" id=\"optName\" value=\""+option[1]+"\" readOnly/>" +
	        	"<input type=\"text\" name=\"optPrice\" id=\"optPrice\" maxlength=\"50\" size=\"20\" value=\"0\"/>" +
	        	"<input type=\"button\" value=\"삭제\" onClick=\"prdOptionRemove(this);\"/>" +
	        	"</div>" +
				"");
	}
}
//-->
</script>
</head>
<body>

<c:if test="${not empty productFormVO}">
	<div class="title">
		상품 수정 -
		<c:if test="${productSearchVO.sortTree==10}">병원</c:if>
		<c:if test="${productSearchVO.sortTree==20}">뷰티샵</c:if>
		<c:if test="${productSearchVO.sortTree==30}">Culture</c:if>		
	</div>
</c:if>
<c:if test="${empty productFormVO}">
	<div class="title">
		상품 등록 -
		<c:if test="${productSearchVO.sortTree==10}">병원</c:if>
		<c:if test="${productSearchVO.sortTree==20}">뷰티샵</c:if>
		<c:if test="${productSearchVO.sortTree==30}">Culture</c:if>
	</div>
</c:if>

<form name="productFormRemove" method="post">
<input type="hidden" name="prdId" value="${productFormVO.prdId}" />
</form>

<form name="productForm" method="post" id="productForm" enctype="multipart/form-data" class="productForm" action="${productFormVO!=null&&productFormVO.prdId!=''?'/admin/prd/productModify.do':'/admin/prd/productFormProc.do'}">
<input type="hidden" name="listReturnURL" value="" />
<input type="hidden" name="prdId" value="${productFormVO.prdId}" />
<input type="hidden" name="sortTree" value="${productSearchVO.sortTree}" />
<table class="contents">
    <tr>
    	<th>분류</th>
        <td colspan="3">
            <select name="cateId" id="cateId">
                <c:forEach items="${categoryListBox}" var="bigCategoryList">
                    <c:choose>
                        <c:when test="${fn:length(bigCategoryList.sortTree) == '2'}">
                            <option value="${bigCategoryList.cateId}"<c:if test="${bigCategoryList.cateId eq productFormVO.cateId}">selected</c:if>>${bigCategoryList.cateName}</option>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
    	<th>상품명</th>
        <td><input type="text" name="prdName" id="prdName" maxlength="50" size="20" value="${productFormVO.prdName}"/></td>
        <th>가격</th>
        <td><input type="text" name="price" id="price" maxlength="8" size="20" value="${productFormVO.price}" style="ime-mode:disabled;" onKeyPress="return numbersonly(event, false)"/></td>
    </tr>
    <tr>
    	<th>회사명</th>
        <td colspan="3">
            <select name="comp" id="comp">
                <c:forEach items="${companyListBox}" var="companyList">
                	<option value="${companyList.mbrId}" <c:if test="${companyList.mbrId eq productFormVO.comp}">selected</c:if>>${companyList.firstName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
    	<th>옵션</th>
        <td colspan="3">
        	<div id="optInfobox">
            <select name="optInfoId" id="optInfoId" onChange="newOption(this);">
            	<option value="">::선택::</option>
                <c:forEach items="${optionInfoListBox}" var="optionInfoList">
                	<option value="${optionInfoList.optId}|${optionInfoList.optName}">${optionInfoList.optName}</option>
                </c:forEach>
            </select>
            </div>
            <c:forEach items="${optionListBox}" var="optionList">
        	<div id="${optionList.optId}">
        	<input type="hidden" name="oldOptId" id="oldOptId" value="${optionList.optId}"/>
        	<input type="hidden" name="optId" id="optId" value="${optionList.optId}"/>
        	<input type="text" name="optName" id="optName" value="${optionList.optName}" readOnly/>
        	<input type="text" name="optPrice" id="optPrice" maxlength="50" size="20" value="${optionList.optPrice}"/>
        	<input type="button" value="삭제" onClick="prdOptionStatus(this, '${optionList.optId}');"/>
        	</div>
        	</c:forEach>
        	<div>
        	<input type="hidden" name="oldOptId" id="oldOptId" value=""/>
        	<input type="hidden" name="optId" id="optId" value=""/>
        	<input type="hidden" name="optName" id="optName" value=""/>
        	<input type="hidden" name="optPrice" id="optPrice" value=""/>
        	</div>
        </td>
    </tr>
    <tr>
    	<th>상품 내용 이미지</th>
    	<td colspan="3">
        	<input type="hidden" name="prdAttaId1" id="prdAttaId1" value="${productFormVO.prdAttaId1}"/>
    	    <input type="file" name="uplodeFile1" id="uplodeFile1" />
    	    <c:if test="${productFormVO.fileName1 != null && productFormVO.fileName1 != ''}">
    	    <div>
    	    <img src="/media/${productFormVO.fileName1}.image" />
    	    </div>
    	    </c:if>    	    
    	</td>
    </tr>    	    
    <tr>
    	<th>상품 내용 이미지</th>
    	<td colspan="3">
    		<input type="hidden" name="prdAttaId2" id="prdAttaId2" value="${productFormVO.prdAttaId2}"/>
    	    <input type="file" name="uplodeFile2" id="uplodeFile2" />
    	    <c:if test="${productFormVO.fileName2 != null && productFormVO.fileName2 != ''}">
    	    <div>
    	    <img src="/media/${productFormVO.fileName2}.image" />
    	    </div>
    	    </c:if>
    	</td>
    </tr>
    <tr>
        <th>상태</th>
        <td colspan="3">
        	<select name="statusType" id="statusType">
                   <option value="1"<c:if test="${productFormVO.statusType eq '1'}">selected</c:if>>대기</option>
                   <option value="2"<c:if test="${productFormVO.statusType eq '2'}">selected</c:if>>판매</option>
            </select>
        </td>
    </tr>
</table>

<div class="btn">
	<c:if test="${not empty productFormVO}">
	   <input type="image" src="/common/images/admin/btn/btn_modify.gif" />
	   <a href="javascript:productFromRemove();"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
	</c:if>
	<c:if test="${empty productFormVO}">
	   <input type="image" src="/common/images/admin/btn/btn_save.gif" />
	   <a href="#;" onclick="productForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</c:if>
    <a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
</div>
</form>
</body>
</html>