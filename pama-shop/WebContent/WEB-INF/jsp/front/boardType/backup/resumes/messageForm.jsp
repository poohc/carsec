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
	<div class="recruit_box">
		<h1>구직 등록</h1>
		<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}" enctype="multipart/form-data">
			<input type="hidden" name="messageId" value="${messageVO.messageId }" /> <input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
			<table>
				<caption>구직등록 게시판</caption>
				<colgroup>
					<col style="width: 15%">
					<col style="width: 35%">
					<col style="width: 15%">
					<col style="width: 35%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><span class="enter_st"><input type="text" title="제목" name="title" class="title" value="${messageVO.title}"></span></td>
					</tr>
					<tr>
						<th>분야</th>
						<td><span class="selectbox type2"> <select id="number" title="분야" name="varFiled1" class="title" value="${messageVO.varFiled1}">
									<option value="자동차정비">자동차정비</option>
									<option value="자동차정비">자동차정비</option>
									<option value="자동차정비">자동차정비</option>
									<option value="자동차정비">자동차정비</option>
							</select>
						</span></td>
						<th class="t_c">경력</th>
						<td class="t_r"><span class="selectbox type2"> <select id="number" title="경력" name="varFiled2" class="title" value="${messageVO.varFiled2}">
									<option value="초급">초급</option>
									<option value="중급">중급</option>
									<option value="고급고급">고급</option>
									<option value="">고급</option>
							</select>
						</span></td>
					</tr>
					<tr>
						<th class="">희망지역</th>
						<td colspan="3"><span class="selectbox mt_5 type2"> <select id="number" title="희망지역" name="varFiled3" class="title" value="${messageVO.varFiled3}">
									<option value="">서울특별시</option>
									<option value="">경기도</option>
									<option value="">경기도</option>
									<option value="">경기도</option>
							</select>
						</span> <span class="selectbox type2"> <select id="number" title="희망지역" name="varFiled4" class="title" value="${messageVO.varFiled4}">
									<option value="서울특별시">서울특별시</option>
									<option value="경기도">경기도</option>
									<option value="경기도">경기도</option>
									<option value="경기도">경기도</option>
							</select>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file" title="파일이름" readonly="readonly"></span> <span class="btn_find_file"> <input type="file" name="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><span class="enter_st2"><input type="text" title="이름" name="registerName" class="title" value="${messageVO.registerName}"></span></td>
						<th colspan="">연락처</th>
						<td><span class="selectbox type5"> <select id="number" title="번도" name="varFiled5" class="title" value="${messageVO.varFiled5}">
									<option value="SK">010</option>
									<option value="KT">010</option>
									<option value="LGU+">010</option>
							</select>
						</span> <span class="enter enter_st3"><input type="text" title="제목" name="varFiled6" class="title" value="${messageVO.varFiled6}"></span> <span class="enter enter_st3"><input type="text" title="제목" name="varFiled7" class="title" value="${messageVO.varFiled7}"></span></td>
					</tr>
					<tr>
						<th colspan="4">구직글 입력</th>
					</tr>
					<tr>
						<th colspan="4"><textarea name="contents" id="contentsarea" cols="30" rows="10">${messageVO.contents}</textarea></th>
					</tr>
					<tr>
						<td colspan="3">
						</th>
						<td>
						</th>
					</tr>
					<tr>
						<th colspan="4" class="po_r"><input type="checkbox" id="check2" data-from="checkbox" class="agency_check"> <label for="check2">구직글 등록시 입력된 정보를 업체회원에 열람하는 것에 동의합니다.</label> <input type="submit" class="input_type6" value="등록" onclick="javascript:formSubmit();"></th>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="btn_right">
		<button type="button" class="button_type1" onclick="javascript:location.href='messageList.do'">목록</button>
	</div>
</body>
</html>