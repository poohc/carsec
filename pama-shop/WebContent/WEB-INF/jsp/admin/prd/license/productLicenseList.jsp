<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
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
<head>
<script type="text/javascript">
<!--
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
	});

}

function goProductLicenseDetail(id){
    var form = document.productLicenseForm;
    form.prdLicenseId.value = id;
    form.action="./productLicenseForm.do";
    form.method="GET";
    form.submit();
}

//goSearch
function gocategorySearch(){
    var form = document.categorySearchFrom;
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.categorySearchFrom;
    form.pageNo.value = pageNo;
    form.submit();
}

function getLicenseExcelList(totalCount){
    var form = document.categorySearchFrom;

    // 현재 검색되어있는 자료중 페이지 상관없이 모든 자료가 엑셀로 출력된다.
    form.row.disabled = false;
    form.pageNo.value = 1;
    form.row.value = totalCount;
    form.action = "/admin/prd/license/excel/productLicenseList.do";
    form.submit();
}

//RemoveProc
function goLicenseRemoveProc(){
    var form = document.licenseListForm;

    var checkedCnt = 0;
    for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
        if(document.getElementsByName("checkedIds")[i].checked==true){
            checkedCnt++;
        }
    }
    if(checkedCnt==0){
        alert('삭제할 게시물을 선택하세요!');
        return;
    }

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./licenseRemoveSelectProc.do";
    	form.method="POST";
        form.submit();
    }
}

//전체체크
function checkAll(){
    if(document.getElementById("allCheckBox").checked==true){
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=true;
        }
    }else{
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=false;
        }
    }
}

//-->
</script>
</head>

<body>
<div class="history"><a href="/admin/main/main.do">HOME</a> &gt; <a href="/admin/smp/sampleList.do">라이센스관리</a> &gt;  라이센스리스트</div>

<div class="title">라이센스리스트</div>
<div class="btn">
	<div class="btnFl"><a href="javascript:goLicenseRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a></div>
    <div class="btnFl"><a href="/admin/prd/license/productLicenseForm.do"><img src="/common/images/admin/btn/btn_write.gif" /></a></div>
    <div style="clear: both"></div>
</div>
<form name="productLicenseForm" method="get">
    <input type="hidden" name="prdLicenseId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>
<form name="categorySearchFrom" method="get" autocomplete="off">
<input type="hidden" name="pageNo" value="${productLicenseList.productLicenseSearchVO.pageNo}"/>
<input type="hidden" name="row" id="row" disabled/>
<table class="contents">
    <colgroup>
        <col width="10%"></col>
        <col width="15%"></col>
        <col width="10%"></col>
        <col width="15%"></col>
        <col width="10%"></col>
        <col ></col>
        <col width="10%"></col>
        <col width="20%"></col>
    </colgroup>
    <thead>
    </thead>
    <tbody>
        <tr>
            <th>대분류</th>
            <td>
                <span id="bigCategory">
	                <select name="cateId" id="cateId" onChange="middleCategoryChange(this.value, '');">
	                    <option value="">- 대분류 -</option>
	                    <c:forEach items="${categoryListBox}" var="bigCategoryList">
	                        <c:choose>
		                        <c:when test="${fn:length(bigCategoryList.sortTree) == '2'}">
	                                <option value="${bigCategoryList.cateId}"<c:if test="${bigCategoryList.cateId eq productLicenseList.productLicenseSearchVO.cateId}">selected</c:if>>${bigCategoryList.cateName}</option>
		                        </c:when>
	                        </c:choose>
	                    </c:forEach>
	                </select>
                </span>
            </td>
            <th>상품명</th>
            <td>
                <span id="middleCategory">
	                <select name="prdId" id="prdId">
	                    <option value="">- 상품선택 -</option>
	                </select>
	            </span>
            </td>
            <th>라이센스명</th>
            <td>
                <input type="text" name="licenseCode" maxlength="20" size="20" value="${productLicenseList.productLicenseSearchVO.licenseCode}"/>
            </td>
            <th>검색</th>
            <td>
            <a href="javascript:gocategorySearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
            <a href="javascript:getLicenseExcelList('${productLicenseList.productLicenseSearchVO.totalCount}');"><img src="/common/images/admin/btn/btn_excel.gif" /></a>
            </td>
        </tr>
    </tbody>
</table>
</form>
<br />

<form name="licenseListForm">
<!-- Loop -->
<table class="contents">
    <colgroup>
        <col width="3%"></col>
        <col width="3%"></col>
        <col width="18%"></col>
        <col width=""></col>
        <col width="15%"></col>
        <col width="13%"></col>
        <col width="13%"></col>
        <col width="6%"></col>
    </colgroup>
    <thead>
        <tr>
            <th><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" /></th>
            <th>번호</th>
            <th>대분류</th>
            <th>상품명</th>
            <th>라이센스코드</th>
            <th>발행일</th>
            <th>등록일</th>
            <th>상태</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${productLicenseList.productLicenseList}" var="i" varStatus="listCount">
            <tr>
            	<td><input type="checkbox" name="checkedIds" value="${i.prdLicenseId}" /></td>
                <td>${productLicenseList.productLicenseSearchVO.pageStartIndex - listCount.index}</td>
                <td>${i.cateName}</td>
                <td><a href="javascript:goProductLicenseDetail(${i.prdLicenseId});">${i.prdName}</a></td>
                <td>${i.licenseCode}</td>
                <td>${fn:substring(i.publishDate, 0, 10)}</td>
                <td>${fn:substring(i.registerDate, 0, 10)}</td>
                <td>
                    <select name="licensePublishType" id="licensePublishType" onChange="javascript:statusTypeChange(this.value,'${i.cateId}');">
	                    <option value="1"<c:if test="${i.licensePublishType eq '1'}">selected</c:if>>미사용</option>
	                    <option value="2"<c:if test="${i.licensePublishType eq '2'}">selected</c:if>>사용중</option>
	                    <option value="3"<c:if test="${i.licensePublishType eq '3'}">selected</c:if>>만기종료</option>
	                </select>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</form>
<!-- Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${productLicenseList.productLicenseSearchVO.totalCount}" />
    <jsp:param name="row" value="${productLicenseList.productLicenseSearchVO.row}" />
    <jsp:param name="page" value="${productLicenseList.productLicenseSearchVO.pageNo}" />
</jsp:include>

<script type="text/javascript">
<!--
	middleCategoryChange('${productLicenseList.productLicenseSearchVO.cateId}','${productLicenseList.productLicenseSearchVO.prdId}');
//-->
</script>
</body>