<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/board/category");
%>
<html>

<head>
<link rel="stylesheet" type="text/css" href="/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goForm
function goMessageCategoryForm(id){
    var form = document.messageCategoryForm;
    form.messageCategoryId.value = id;
    form.action="./messageCategoryForm.do";
    form.method="GET";
    form.submit();
}

//goSearch
function goMessageCategorySearch(){
    var form = document.messageSearchForm;
    form.submit();
}

//RemoveProc
function goMessageCategoryRemoveProc(){
    var form = document.messageListForm;

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
    	form.action="./messageCategoryRemoveSelectProc.do";
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

function goList() {
	var form = document.messageCategoryForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "../boardList.do";
	}
}
//]]>
</script>
</head>
<body>
<form name="messageCategoryForm">
	<input type="hidden" name="boardId" value="${boardVO.boardId}" />
	<input type="hidden" name="messageCategoryId" value="" />
	<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>

<div class="title">게시판 리스트</div>
<div class="btn">
	<ul>
    	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
    	<li class="btnFr"><a href="javascript:goMessageCategoryForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
    </ul>
</div>

<table class="contents">
    <colgroup>
        <col width="5%"></col>
        <col width=""></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first">No</th>
            <th>카테고리명</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${messageCategoryList.messageCategoryList}" var="i" varStatus="iStatus">
            <tr>
                <td class="first">${messageCategoryList.messageCategorySearchVO.pageStartIndex - iStatus.index}</td>
                <td><a href="javascript:goMessageCategoryForm('${i.messageCategoryId}');"><c:out value="${i.messageCategoryName}"/></a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="btn">
	<ul>
    	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
    	<li class="btnFr"><a href="javascript:goMessageCategoryForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
    </ul>
</div>
</body>
</html>

