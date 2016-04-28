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
//isForms
function isForms(f) {
	return true;
}

function closeWin(irid) {
	parent.parent.oEditors.getById[irid].exec("SE_TOGGLE_IMAGEUPLOAD_LAYER");
	return false;
}

// 이미지삽입 함수 imgupload_pro.asp 에서 호출
function insertIMG(irid,fileame){
  var sHTML = "<img src='" + imagepath + "/" + fileame + "' border='0'>";
  oEditors.getById[irid].exec("PASTE_HTML", [sHTML]);
}

function goList() {
	var form = document.boardForm;
	var listReturnURL = form.listReturnURL.value;
	if (listReturnURL!="") {
		location.href = listReturnURL;
	} else {
		location.href = "boardList.do";
	}
}
//-->
</script>
</head>

<div class="title">게시판 관리 폼</div>

<form name="boardForm" id="boardForm" method="post" class="dataForm"
	action="${boardVO!=null && boardVO.boardId!=''?'./boardModify.do':'./boardRegister.do'}">
<input type="hidden" name="boardId" value="${boardVO.boardId }" />
<input type="hidden" name="listReturnURL" value="" />

<table class="contents">
    <tr>
        <th>게시판코드</th>
        <td><input type="text" name="boardKey" id="boardKey" class="required" value="${boardVO.boardKey}"/></td>
    </tr>
    <tr>
        <th>게시판명</th>
        <td><input type="text" name="title" id="title" class="required" value="${boardVO.title }"/></td>
    </tr>
    <tr>
        <th>게시판타입</th>
        <td>[개발중]
        	<select name="boardType">
        	<c:forEach items="${boardTypeList}" var="i" varStatus="iStatus">
        	<option value="${i}" ${boardVO.boardType eq i ?' checked':''}>${i}</option>
        	</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <th>설명</th>
        <td>
		<textarea name="description" id="description" style="width:400px; height:100px;">${boardVO.description }</textarea>
		</td>
    </tr>
    <tr>
        <th>리스트수</th>
        <td >
            <select name="listLines">
            	<option value="1"  ${boardVO.listLines==1 ? 'selected' : '' }>Contents독립</option>
	            <option value="5"  ${boardVO.listLines==5 ? 'selected' : '' }>5</option>
	            <option value="10" ${boardVO.listLines==10 ? 'selected' : '' }>10</option>
	            <option value="15" ${boardVO.listLines==15 ? 'selected' : '' }>15</option>
	            <option value="20" ${boardVO.listLines==20 ? 'selected' : '' }>20</option>
	            <option value="25" ${boardVO.listLines==25 ? 'selected' : '' }>25</option>
            </select> 라인.
        </td>
    </tr>

    <tr>
        <th>파일 사용구분</th>
        <td>
        	<input type="radio" name="attachmentFlag" value="0"${boardVO.attachmentFlag == null || boardVO.attachmentFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="attachmentFlag" value="1"${boardVO.attachmentFlag eq '1'?' checked':''}/>여러파일첨부
        	<input type="radio" name="attachmentFlag" value="2"${boardVO.attachmentFlag eq '2'?' checked':''}/>한개파일첨부
        </td>
    </tr>
    <tr>
        <th>말머리 사용여부</th>
        <td>
        	<input type="radio" name="messageCategoryFlag" value="0"${boardVO.messageCategoryFlag == null || boardVO.messageCategoryFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="messageCategoryFlag" value="1"${boardVO.messageCategoryFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>상담 사용여부</th>
        <td>
        	<input type="radio" name="consultFlag" value="0"${boardVO.consultFlag == null || boardVO.consultFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="consultFlag" value="1"${boardVO.consultFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>답변 사용여부</th>
        <td>
        	<input type="radio" name="replyFlag" value="0"${boardVO.replyFlag == null || boardVO.replyFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="replyFlag" value="1"${boardVO.replyFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>비밀글 사용여부</th>
        <td>
        	<input type="radio" name="secretFlag" value="0"${boardVO.secretFlag == null || boardVO.secretFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="secretFlag" value="1"${boardVO.secretFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>유효기간 사용여부</th>
        <td>
        	<input type="radio" name="expirationFlag" value="0"${boardVO.expirationFlag == null || boardVO.expirationFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="expirationFlag" value="1"${boardVO.expirationFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>덧글 사용여부</th>
        <td>
        	<input type="radio" name="commentFlag" value="0"${boardVO.commentFlag == null || boardVO.commentFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="commentFlag" value="1"${boardVO.commentFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>추천 사용여부</th>
        <td>
        	<input type="radio" name="recommendFlag" value="0"${boardVO.recommendFlag == null || boardVO.recommendFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="recommendFlag" value="1"${boardVO.recommendFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>썸네일 사용여부</th>
        <td>
        	<input type="radio" name="listImageFlag" value="0"${boardVO.listImageFlag == null || boardVO.listImageFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="listImageFlag" value="1"${boardVO.listImageFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>공지사항 사용여부</th>
        <td>
        	<input type="radio" name="topMessageFlag" value="0"${boardVO.topMessageFlag == null || boardVO.topMessageFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="topMessageFlag" value="1"${boardVO.topMessageFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>요약 사용여부</th>
        <td>
        	<input type="radio" name="summaryFlag" value="0"${boardVO.summaryFlag == null || boardVO.summaryFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="summaryFlag" value="1"${boardVO.summaryFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>내용사용여부</th>
        <td>
        	<input type="radio" name="contentsFlag" value="0"${boardVO.contentsFlag == null || boardVO.contentsFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="contentsFlag" value="1"${boardVO.contentsFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>태그 사용여부</th>
        <td>
        	<input type="radio" name="tagsFlag" value="0"${boardVO.tagsFlag == null || boardVO.tagsFlag eq '0'?' checked':''}/>미사용
        	<input type="radio" name="tagsFlag" value="1"${boardVO.tagsFlag eq '1'?' checked':''}/>사용
        </td>
    </tr>
    <tr>
        <th>접근권한</th>
        <td>
        	<select name="authAccess">
        		<option value="1" ${boardVO.authAccess == null || boardVO.authAccess eq '1'?' selected':''}>비회원</option>
        		<option value="2" ${boardVO.authAccess eq '2'?' selected':''}>회원</option>
        		<option value="9" ${boardVO.authAccess eq '9'?' selected':''}>관리자</option>
        	</select>
        </td>
    </tr>
    <tr>
        <th>리스트권한</th>
        <td>
        	<select name="authList">
        		<option value="1" ${boardVO.authList == null || boardVO.authList eq '1'?' selected':''}>비회원</option>
        		<option value="2" ${boardVO.authList eq '2'?' selected':''}>회원</option>
        		<option value="9" ${boardVO.authList eq '9'?' selected':''}>관리자</option>
        	</select>
        </td>
    </tr>
    <tr>
        <th>열람권한</th>
        <td>
        	<select name="authView">
        		<option value="1" ${boardVO.authView == null || boardVO.authView eq '1'?' selected':''}>비회원</option>
        		<option value="2" ${boardVO.authView eq '2'?' selected':''}>회원</option>
        		<option value="9" ${boardVO.authView eq '9'?' selected':''}>관리자</option>
        	</select>
        </td>
    </tr>
    <tr>
        <th>글작성권한</th>
        <td>
        	<select name="authWrite">
        		<option value="1" ${boardVO.authWrite == null || boardVO.authWrite eq '1'?' selected':''}>비회원</option>
        		<option value="2" ${boardVO.authWrite eq '2'?' selected':''}>회원</option>
        		<option value="9" ${boardVO.authWrite eq '9'?' selected':''}>관리자</option>
        	</select>
        </td>
    </tr>
    <tr>
        <th>관리권한</th>
        <td>
        	<select name="authManager">
        		<option value="1" ${boardVO.authManager == null || boardVO.authManager eq '1'?' selected':''}>비회원</option>
        		<option value="2" ${boardVO.authManager eq '2'?' selected':''}>회원</option>
        		<option value="9" ${boardVO.authManager eq '9'?' selected':''}>관리자</option>
        	</select>
        </td>
    </tr>
    <tr>
        <th>게시여부</th>
        <td>
            <input type="radio" name="statusType" value="2"${boardVO.statusType==2?'checked':'' }>게시
            <input type="radio" name="statusType" value="1"${boardVO.statusType == null || boardVO.statusType==1?'checked':'' }>대기
         </td>
    </tr>

</table>
<div class="btn">
<ul>
	<li class="btnFl"><a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
	<li class="btnFr">
    	<input type="image" src="/common/images/admin/btn/btn_save.gif" />
    	<a href="#;" onclick="boardForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
	</li>
</ul>
</div>
</form>

