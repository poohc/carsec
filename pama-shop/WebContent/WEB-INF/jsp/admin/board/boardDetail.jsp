<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/board");
%>
<head>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">

<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>

<script type="text/javascript">
<!--
//goForm
function goBoardForm(id){
    var form = document.boardForm;
    form.boardId.value = id;
    form.action="./boardForm.do";
    form.method="GET";
    form.submit();
}

//RemoveProc
function goBoardRemoveProc(id){
    var form = document.boardForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.boardId.value=id;
    	form.action="./boardRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}

//goList
function goList() {
<c:if test="${fn:length(param.listReturnURL)>0}">
	location.href="${param.listReturnURL}";
</c:if>
<c:if test="${fn:length(param.listReturnURL)==0}">
	location.href="./boardList.do?boardId=${boardVO.boardId}";
</c:if>
}
//-->
</script>
</head>

<div class="title">게시판 관리 폼</div>

<form name="boardForm" id="boardForm" method="post" class="dataForm" action="${boardVO!=null && boardVO.boardId!=''?'./boardModify.do':'./boardRegister.do'}">
<input type="hidden" name="boardId" value="${boardVO.boardId }" />
<input type="hidden" name="listReturnURL" value="" />
</form>
<div id="menuTab">
<ul>
	<li class="on">기본게시판정보</li>
	<li class="ln"></li>
	<li class="off"><a href="/admin/board/category/messageCategoryList.do?boardId=${boardVO.boardId}">말머리관리</a></li>
</ul>
</div>
<table class="contents">
    <colgroup>
        <col width="300px"></col>
        <col></col>
    </colgroup>
    <tr>
        <th>게시판코드</th>
        <td>${boardVO.boardKey}</td>
    </tr>
    <tr>
        <th>게시판명</th>
        <td>${boardVO.title }</td>
    </tr>
    <tr>
        <th>게시판타입</th>
        <td>${boardVO.boardType}</td>
    </tr>
    <tr>
        <th>설명</th>
        <td>${boardVO.description }</td>
    </tr>
    <tr>
        <th>리스트수</th>
        <td>${boardVO.listLines } 라인.</td>
    </tr>
    <tr>
        <th>파일 사용여부</th>
        <td>
        	<c:if test="${boardVO.attachmentFlag == null || boardVO.attachmentFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.attachmentFlag eq '1'}">여러파일첨부</c:if>
        	<c:if test="${boardVO.attachmentFlag eq '2'}">한개파일첨부</c:if>
        </td>
    </tr>
    <tr>
        <th>말머리 사용여부</th>
        <td>
        	<c:if test="${boardVO.messageCategoryFlag == null || boardVO.messageCategoryFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.messageCategoryFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>상담 사용여부</th>
        <td>
        	<c:if test="${boardVO.consultFlag == null || boardVO.consultFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.consultFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>답변 사용여부</th>
        <td>
        	<c:if test="${boardVO.replyFlag == null || boardVO.replyFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.replyFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>비밀글 사용여부</th>
        <td>
        	<c:if test="${boardVO.secretFlag == null || boardVO.secretFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.secretFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>유효기간 사용여부</th>
        <td>
        	<c:if test="${boardVO.expirationFlag == null || boardVO.expirationFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.expirationFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>덧글 사용여부</th>
        <td>
        	<c:if test="${boardVO.commentFlag == null || boardVO.commentFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.commentFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>추천 사용여부</th>
        <td>
        	<c:if test="${boardVO.recommendFlag == null || boardVO.recommendFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.recommendFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>썸네일 사용여부</th>
        <td>
        	<c:if test="${boardVO.listImageFlag == null || boardVO.listImageFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.listImageFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>공지사항 사용여부</th>
        <td>
        	<c:if test="${boardVO.topMessageFlag == null || boardVO.topMessageFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.topMessageFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>요약 사용여부</th>
        <td>
        	<c:if test="${boardVO.summaryFlag == null || boardVO.summaryFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.summaryFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>내용사용여부</th>
        <td>
        	<c:if test="${boardVO.contentsFlag == null || boardVO.contentsFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.contentsFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>태그 사용여부</th>
        <td>
        	<c:if test="${boardVO.tagsFlag == null || boardVO.tagsFlag eq '0'}">미사용</c:if>
        	<c:if test="${boardVO.tagsFlag eq '1'}">사용</c:if>
        </td>
    </tr>
    <tr>
        <th>접근권한</th>
        <td>
        	<c:if test="${boardVO.authAccess == null || boardVO.authAccess eq '1'}">비회원</c:if>
        	<c:if test="${boardVO.authAccess eq '2'}">회원</c:if>
        	<c:if test="${boardVO.authAccess eq '9'}">관리자</c:if>
        </td>
    </tr>
    <tr>
        <th>리스트권한</th>
        <td>
        	<c:if test="${boardVO.authList == null || boardVO.authList eq '1'}">비회원</c:if>
        	<c:if test="${boardVO.authList eq '2'}">회원</c:if>
        	<c:if test="${boardVO.authList eq '9'}">관리자</c:if>
        </td>
    </tr>
    <tr>
        <th>열람권한</th>
        <td>
        	<c:if test="${boardVO.authView == null || boardVO.authView eq '1'}">비회원</c:if>
        	<c:if test="${boardVO.authView eq '2'}">회원</c:if>
        	<c:if test="${boardVO.authView eq '9'}">관리자</c:if>
        </td>
    </tr>
    <tr>
        <th>글작성권한</th>
        <td>
        	<c:if test="${boardVO.authWrite == null || boardVO.authWrite eq '1'}">비회원</c:if>
        	<c:if test="${boardVO.authWrite eq '2'}">회원</c:if>
        	<c:if test="${boardVO.authWrite eq '9'}">관리자</c:if>
        </td>
    </tr>
    <tr>
        <th>관리권한</th>
        <td>
        	<c:if test="${boardVO.authManager == null || boardVO.authManager eq '1'}">비회원</c:if>
        	<c:if test="${boardVO.authManager eq '2'}">회원</c:if>
        	<c:if test="${boardVO.authManager eq '9'}">관리자</c:if>
        </td>
    </tr>
    <tr>
        <th>게시여부</th>
        <td>
        	<c:if test="${boardVO.statusType == null || boardVO.statusType eq '1'}">대기</c:if>
        	<c:if test="${boardVO.statusType eq '2'}">게시</c:if>
         </td>
    </tr>

</table>
<div class="btn">
<ul>
	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	<li class="btnFr">
		<a href="javascript:goBoardForm('${boardVO.boardId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a>
	    <a href="javascript:goBoardForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a>
	    <a href="javascript:goBoardRemoveProc(${boardVO.boardId});"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
	</li>
</ul>
</div>

