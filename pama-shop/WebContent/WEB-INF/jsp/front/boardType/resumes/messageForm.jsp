<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>

<c:if test="${!isLogin }">
<script type="text/javascript">
function formSubmit(){

	alert("로그인후 이용하세요.");


}
</script>
</c:if>
<c:if test="${isLogin }">
<script type="text/javascript">
function formSubmit(){
	form = document.messageForm;

	if(form.title.value == ''){
		alert("제목을 입력하세요!");
		form.title.focus();
		return;
	}

	if(form.contents.value == ""){
		alert("내용을 입력하세요.");
		form.contents.focus();
		return;
	}

	if(form.check2.checked==false){
		alert("열람동의 체크를 해주세요.");
		form.check2.focus();
		return;
	}else{
		form.submit();
	}

}
</script>
</c:if>

</head>
<body>
	<img src="/img/bullet/bullet_recruit2.png"/>
	<div class="recruit_box">
		<h1>구직 등록</h1>
		<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}" enctype="multipart/form-data">
			<input type="hidden" name="messageId" value="${messageVO.messageId }" /> <input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
			<table>
				<caption>구직등록 게시판</caption>
				<colgroup>
					<col style="width: 20%">
					<col style="width: 25%">
					<col style="width: 15%">
					<col style="width: 35%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><span class="enter_st"><input type="text" title="제목" name="title" class="title" value="${messageVO.title}"></span></td>
					</tr>

					<tr>
						<th class="">이력서 등록</th>
						<td colspan="3"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file" title="파일이름" readonly="readonly"></span> <span class="btn_find_file"> <input type="file" name=showFile1 onchange="javascript:document.getElementById('upload_file').value=this.value">
							</span>
						</span></td>
					</tr>
					<th colspan="4">구직글 입력</th>
					</tr>
					<tr>
						<th colspan="4"><textarea name="contents" id="contentsarea" cols="30" rows="10" >${messageVO.contents}</textarea></th>
					</tr>
					<tr>
						<td colspan="3">
						</th>
						<td>
						</th>
					</tr>
					<tr>
						<th colspan="4" class="po_r"><input type="checkbox" id="check2" data-from="checkbox"> <label for="check2">구직글 등록시 입력된 정보를 업체회원에 열람하는 것에 동의합니다.</label>

						<input type="button" class="input_type6" value="등록" onclick="javascript:formSubmit();">

						</th>

					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="center_box">
		<a href="#;" onclick="javascript:location.href='messageList.do'" class="btn_type1">목 록</a>
	</div>
</body>
</html>