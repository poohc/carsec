<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goForm
function goMessageForm(id){
    var form = document.messageForm;
    form.messageId.value = id;
    form.action="./messageForm.do";
    form.method="GET";
    form.submit();
}

//goSearch
function goMessageSearch(){
    var form = document.messageSearchForm;
    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.messageSearchForm;
    form.pageNo.value = pageNo;
    form.submit();
}

//RemoveProc
function goMessageRemoveProc(){
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
    	form.action="./messageRemoveSelectProc.do";
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

//]]>
</script>
</head>

<!-- 수정 및 등록을 위한폼 -->
<form name="messageForm">
	<input type="hidden" name="messageId" value="" />
	<input type="hidden" name="listReturnURL" value="${currentURI}" />
</form>

<div class="title">${boardVO.title} 목록(TOTAL:${messageList.messageSearchVO.totalCount})</div>

<div class="btn">
	<ul>
		<li class="btnFl"><a href="javascript:goMessageRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a></li>
		<li class="btnFl"><a href="javascript:goMessageForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
	    <li class="btnFr">
		    <form name="messageSearchForm" method="get">
		    <div class="searchinput">
			    <input type="hidden" name="pageNo" value="${messageList.messageSearchVO.pageNo}"/>
			    <select name="searchColumn">
			    	<option value=""${messageList.messageSearchVO.searchColumn==null || messageList.messageSearchVO.searchColumn==''?' selected':''}>선택</option>
			    	<option value="title"${messageList.messageSearchVO.searchColumn=='title'?' selected':''}>제목</option>
			    	<option value="contents"${messageList.messageSearchVO.searchColumn=='contents'?' selected':''}>내용</option>
			    </select>
			    <input type="text" name="searchValue" value="${messageList.messageSearchVO.searchValue}" />
			</div>
			<div class="searchbtn">
	    		<a href="javascript:goMessageSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
	    	</div>
	    	</form>
	    </li>
	</ul>
</div>
<div style="clear: both"></div>

<form name="messageListForm">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />

<table class="contents">
    <colgroup>
        <col width="10%" />
        <col width="5%"></col>
        <col width=""></col>
        <col width="10%"></col>
        <col width="10%"></col>
        <col width="10%"></col>
    </colgroup>


    <thead>
        <tr>
            <th class="first"><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />All</th>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
        </tr>
    </thead>

    <tbody>
    	<c:forEach items="${messageList.messageTopList}" var="i" varStatus="iStatus">
            <tr>
                <td align="center"><input type="checkbox" name="checkedIds" value="${i.messageId}" /></td>
                <td align="center"><img src="/common/images/admin/ico/ico_notice.gif" alt="공지" /></td>
                <td>
                	<a href="javascript:goMessageForm('${i.messageId}');">${i.title}</a>
                </td>

                <td align="center">${i.registerName}</td>
                <td align="center">${fn:substring(i.registerDate, 0, 10)}</td>
                <td align="center">${i.viewCount}</td>
            </tr>
    	</c:forEach>
    <!-- //Loop -->
        <c:forEach items="${messageList.messageList}" var="i" varStatus="iStatus">
            <tr>
                <td align="center"><input type="checkbox" name="checkedIds" value="${i.messageId}" /></td>
                <td align="center">${messageList.messageSearchVO.pageStartIndex - iStatus.index}</td>
                <td>
                	<c:if test="${messageVO.replyFlag == '1' }">
                	<c:forEach begin="2" end="${i.messageLevel}" step="1" var="j">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
                	</c:if>
                	<c:if test="${messageVO.replyFlag != '1' && (i.thumbnailUrl != null && i.thumbnailUrl != '')}">
                	<img src="${i.thumbnailUrl}" width="30px" height="30px">
                	</c:if>
                	<a href="javascript:goMessageForm('${i.messageId}');">${i.title}</a>
                </td>
                <td align="center">${i.registerName}</td>
                <td align="center">${fn:substring(i.registerDate, 0, 10)}</td>
                <td align="center">${i.viewCount}</td>
            </tr>
        </c:forEach>
	<!-- Loop// -->
    </tbody>
</table>
</form>

<!-- //Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${messageList.messageSearchVO.totalCount}" />
    <jsp:param name="row" value="${messageList.messageSearchVO.row}" />
    <jsp:param name="page" value="${messageList.messageSearchVO.pageNo}" />
</jsp:include>
<!-- Paging// -->

