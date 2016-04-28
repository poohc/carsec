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
		<h1>중고차 매물 등록</h1>
		<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}" enctype="multipart/form-data">
			<input type="hidden" name="messageId" value="${messageVO.messageId }" />
			<table>
				<caption>중고차 매물등록 게시판</caption>
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
						<th>제조사</th>
						<td><span class="selectbox type2"> <select id="number" title="제조사" name="varFiled1" class="title" value="${messageVO.varFiled1}">
									<option value="현대">현대</option>
									<option value="대우">대우</option>
									<option value="대우">대우</option>
									<option value="대우">대우</option>
							</select>
						</span></td>
						<th class="t_c">모델명</th>
						<td class="t_r"><span class="selectbox type2"> <select id="number" title="모델명" name="varFiled2" class="title" value="${messageVO.varFiled2}">
									<option value="i30">i30</option>
									<option value="i30">i30</option>
									<option value="i30">i30</option>
									<option value="i30">i30</option>
							</select>
						</span></td>
					</tr>
					<tr>
						<th class="">연식</th>
						<td><span class="enter_st4"><input type="text" title="연식" name="varFiled3" class="title" value="${messageVO.varFiled3}"></span> 식</td>
						<th class="">주행거리</th>
						<td><span class="enter_st4"><input type="text" title="주행거리" name="varFiled4" class="title" value="${messageVO.varFiled4}"></span> km</td>
					</tr>
					<tr>
						<th class="">가격</th>
						<td><span class="enter_st4"><input type="text" title="가격" name="varFiled5" class="title" value="${messageVO.varFiled5}"></span> 원</td>
						<th class="">색상</th>
						<td><span class="enter_st4"><input type="text" title="색상" name="varFiled6" class="title" value="${messageVO.varFiled6}"></span></td>
					</tr>
					<tr>
						<th class="">사고여부</th>
						<td><label class="radio_type2 type3" for="input_radio01"><input id="input_radio01" type="radio" name="varFiled7" value="1" ${empty messageVO.varFiled7 || messageVO.varFiled7 eq '1' ? 'checked':''}>예</label> <label for="input_radio02" class="radio_type2 type3"><input type="radio" id="input_radio02" name="varFiled7" value="2" ${messageVO.varFiled7 eq '2' ? 'checked':''}>아니오</label></td>
					</tr>
					<tr>
						<th colspan="4" class="t_c">사진등록</th>
					</tr>
					<tr>
						<th class="">앞</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file1" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile1" onchange="javascript:document.getElementById('upload_file1').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th class="">좌측옆</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file2" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile2" onchange="javascript:document.getElementById('upload_file2').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th class="">우측옆</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file3" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile3" onchange="javascript:document.getElementById('upload_file3').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th class="">뒤</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file4" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile4" onchange="javascript:document.getElementById('upload_file4').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th class="">실내</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file5" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile5" onchange="javascript:document.getElementById('upload_file5').value=this.value">
							</span>
						</span></td>
						<td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG
						</td>
					</tr>
					<tr>
						<th>매마자</th>
						<td><span class="enter_st2"><input type="text" title="매매자" name="registerName" class="title" value="${messageVO.registerName}"></span></td>
						<th colspan="">연락처</th>
						<td><span class="selectbox type5"> <select id="number" title="번도" name="varFiled71" class="title" value="${messageVO.varFiled7}" />
								<option value="">010</option>
								<option value="">011</option>
								<option value="">019</option> </select>
						</span> <span class="enter enter_st3"><input type="text" title="제목" name="varFiled72" class="title" value="${messageVO.varFiled7}" /></span> <span class="enter enter_st3"><input type="text" name="varFiled73" value="${messageVO.varFiled7}" title="제목"></span>
						<input type="hidden" name="varFiled7" value="" /></td>
					</tr>
					<tr>
						<th colspan="4">상세설명</th>
					</tr>
					<tr>
						<th colspan="4"><textarea name="cont" id="cont" cols="30" rows="10">${messageVO.contents}</textarea></th>
					</tr>
					<tr>
						<td colspan="3">
						</th>
						<td>
						</th>
					</tr>
					<tr>
						<th colspan="4" class="po_r"><input type="checkbox" id="check2" data-from="checkbox"> <label for="check2">구직글 등록시 입력된 정보를 업체회원에 열람하는 것에 동의합니다.</label> <input type="submit" class="input_type6" value="등록" onclick="javascript:formSubmit();"></th>
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