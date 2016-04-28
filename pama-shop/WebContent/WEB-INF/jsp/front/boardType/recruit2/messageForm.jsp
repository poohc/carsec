<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript">
function formSubmit(){
	form = document.messageForm;

	if(form.varFiled3.value == ''){
		alert("구인내역을 입력하세요!");
		form.varFiled3.focus();
		return;
	}

	if(form.title.value == ''){
		alert("제목을 입력하세요!");
		form.title.focus();
		return;
	}

	ckeditEmptyInstace="";
	for ( instance in CKEDITOR.instances ){
		CKEDITOR.instances[instance].updateElement();
		editValue=$("#"+instance).val();
		if(editValue==""){
			ckeditEmptyInstace=instance;
			break;
		}
	}

	if(ckeditEmptyInstace != ""){
		alert("내용을 입력하세요.");
		CKEDITOR.instances[ckeditEmptyInstace].focus();
	}else{
		form.submit();
	}

}
</script>
</head>
<body>
	<img src="/img/bullet/bullet_recruit.png"/>
	<form name="messageForm" id="dataForm1" class="dataForm1" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
		<input type="hidden" name="messageId" value="${messageVO.messageId }" />
		<input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
		<div class="board_write3">
			<table>
				<caption>${boardVO.title }</caption>
				<colgroup>
					<col style="width: 15%">
					<col style="width: 20%">
					<col style="width: 10%">
					<col style="width: 45%">
				</colgroup>
				<thead>
                       <tr>
                           <th>작성자</th>
                           <th class="t_l" colspan="3"><span class="enter_st enter_st3">${sessionVO.memberNm}</span></th>
                       </tr>
                       <tr>
						<th>지역</th>
						<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="varFiled1" class="title" title="제목" value="${messageVO.varFiled1}"></span></th>
					</tr>
					 <tr>
						<th>업체명</th>
						<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="varFiled2" class="title" title="제목" value="${messageVO.varFiled2}"></span></th>
					</tr>
					 <tr>
						<th>구인내역</th>
						<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="varFiled3" class="title" title="제목" value="${messageVO.varFiled3}"></span></th>
					</tr>
					 <tr>
						<th>서비스품목</th>
						<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="varFiled4" class="title" title="제목" value="${messageVO.varFiled4}"></span></th>
					</tr>
					<tr>
						<th>전화번호</th>
						<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="varFiled8" class="title" title="제목" value="${messageVO.varFiled8}"></span></th>
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
		<div class="btn_right">
			<button type="button" class="button_type1" onclick="javascript:location.href='messageList.do'">목록</button>
			<button type="button" class="button_type1" onclick="javascript:formSubmit();">등록하기</button>
		</div>
	</form>

</body>
</html>