<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<title>${boardVO.title }</title>
<script type="text/javascript">
function formSubmit(){
	form = document.messageForm;

	if(form.title.value == ''){
		alert("제목을 입력하세요!");
		form.title.focus();
		return;
	}

// 	if(CKEDITOR.instances.content.getData() == ''){
// 		alert("내용을 입력하세요!");
// 		CKEDITOR.instances.content.focus();//TODO
// 		return;
// 	}

	form.submit();
}
</script>
</head>
<body>

	<form name="messageForm" id="dataForm1" class="dataForm1" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
		<input type="hidden" name="messageId" value="${messageVO.messageId }" />
		<input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
		<div class="board_write3">
			<div class="board_write3">
				<table>
					<caption>${boardVO.title }</caption>
					<colgroup>
						<col style="width: 10%">
						<col style="width: 25%">
						<col style="width: 10%">
						<col style="width: 45%">
					</colgroup>
					<thead>
                        <tr>
                            <th><label for="author">작성자</label></th>
                            <th class="t_l" colspan="3"><span class="enter_st enter_st3">${sessionVO.memberNm}</span></th>
                        </tr>

						<tr>
							<th><label for="title">제목</label></th>
							<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="title" class="title" title="제목" value="${messageVO.title}"></span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4">
							<textarea cols="80" id="contentsarea" name="contents">${messageVO.contents}</textarea>
							<script type="text/javascript">
							CKEDITOR.replace( 'contentsarea', {height: 280} );
							</script>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="btn_right">
			<button type="button" class="button_type1" onclick="javascript:location.href='messageList.do'">목록</button>
			<button type="button" class="button_type1" onclick="javascript:formSubmit();">등록하기</button>
		</div>
	</form>

</body>
</html>