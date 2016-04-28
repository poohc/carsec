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

	var mobile = form.mobile1.value + "-" + form.mobile2.value + "-" + form.mobile3.value;
	form.varFiled8.value=mobile;

}

function getCar(param1, param2) {
	var maker = "";
	var modelName = "";
	var method = "";
	var mission = ["White","Yellow","Brown","Black","Gray","Blue","Green","Puple","투톤"];
	param2 = param2 + "|||";
	if(param1=='mission') {
		for (var i=0; i<mission.length;i++) {
			$('#mission')
	          .append($('<option>', { value : mission[i] })
	          .text(mission[i]));
		}
	} else {
		if(param1=='model'){
			maker = param2.split("|")[0];
		}
		if(param1=='years'){
			maker = param2.split("|")[0];
			modelName = param2.split("|")[1];
			method = param2.split("|")[2];
		}
		if(param1=='maker' || param1=='mission' || param1=='caryear' || param1=='model' ){
			$('#mission').children().remove();
			$('#mission')
	          .append($('<option>', { value : "" })
	          .text("색상 선택"));
		}
		$.ajax({
			type : "POST",
			url : "/mbr/accountCarSearch.do",
			data : {"searchType":param1,"maker":maker,"modelName":modelName,"method":method},
			dataType : "json",
			success : function(data){
				if(param1=='model'){
					$('#model').children().remove();
					$('#model')
			          .append($('<option>', { value : "" })
			          .text("모델명 선택"));
				}
				if(param1=='years' || param1=='model'){
					$('#caryear').children().remove();
					$('#caryear')
			          .append($('<option>', { value : "" })
			          .text("연식 선택"));
				}
				$.each(data.carcode, function(){
					if(param1=='maker'){
						$('#brand')
				          .append($('<option>', { value : this.maker })
				          .text(this.maker));
					}
					if(param1=='model'){
						$('#model')
				          .append($('<option>', { value : this.maker+"|"+this.modelName+"|"+this.method })
				          .text(this.modelName+"("+this.method+")"));
					}
					if(param1=='years'){
						for (var i=this.endYear; i>=this.startYear; i--) {
							$('#caryear')
					          .append($('<option>', { value : this.carId +"|"+i })
					          .text(i));
						}

					}
				});
				if(param1=='maker'){
					if ($("#brand option").index($("#brand option:selected"))<0) {
						$("#brand option:eq(0)").attr("selected", "selected");
					}
					getCar('model', $("#brand option:selected").val());
				}
				if(param1=='model'){
					if ($("#model option").index($("#model option:selected"))<0) {
						$("#model option:eq(0)").attr("selected", "selected");
					}
					getCar('years', $("#model option:selected").val());
				}
				if(param1=='years'){
					if ($("#caryear option").index($("#caryear option:selected"))<0) {
						$("#caryear option:eq(0)").attr("selected", "selected");
					}
					if ($("#caryear option").length > 1){
						getCar('mission', '');
					}
				}
			}
		});
	}
}

$( document ).ready( function() {
	getCar('maker', '');
})

</script>
</c:if>

</head>
<body>
	<img src="/img/bullet/bullet_used.png"/>
	<div class="recruit_box recruit_type2">
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
						<td colspan="3"><span class="enter_st4"><select id="brand" name="accountCarInfoVO.brand" title="선택하세요" onchange="getCar('model', this.value)" value="${i.varFiled1}">
						<option value="">제조사 선택</option></span></td>
						</select>
					</tr>
					<tr>
						<th class="t_c">모델명</th>
						<td colspan="3"><select id="model" name="modelSelect" title="선택하세요" onchange="getCar('years', this.value)" value="${i.varFiled2}">
							<option value="">모델명 선택</option>
						</select>
					<tr>
						<th class="">연식</th>
						<td colspan="3"><span class="enter_st4"><select id="caryear" name="caryearSelect" title="선택하세요" onchange="getCarCode(this.value)" value="${i.varFiled3}">
							<option value="">연식 선택</option>
					    </select>
					<tr>
					<tr>
						<th class="">색상</th>
						<td colspan="3"><span class="enter_st4"><select id="mission" name="accountCarInfoVO.mission" title="선택하세요">
							<option value="">색상 선택</option>
					<tr>
						<th class="">주행거리</th>
						<td colspan="3"><span class="enter_st4"><input type="text" title="주행거리" name="varFiled4" class="title" value="${messageVO.varFiled4}"></span> km</td>
					</tr>
					<tr>
						<th class="">가격</th>
						<td colspan="3"><span class="enter_st4"><input type="text" title="가격" name="varFiled5" class="title" value="${messageVO.varFiled5}"></span> 만원</td>
					</tr>
					<tr>
						<th class="">사고여부</th>
						<td><label class="radio_type2 type3" for="input_radio01">
						<input id="input_radio01" type="radio" name="varFiled7" value="Y" ${empty messageVO.varFiled7 || messageVO.varFiled7 eq 'Y' ? 'checked':''}>예</label> <label for="input_radio02" class="radio_type2 type3"><input type="radio" id="input_radio02" name="varFiled7" value="N" ${messageVO.varFiled7 eq 'N' ? 'checked':''}>아니오</label></td>
					</tr>
					<tr>
						<th>매매자</th>
						<td colspan="3"><span class="enter_st2"><input type="text" title="매매자" name="registerName" class="title" value="${messageVO.registerName}"></span></td>
					</tr>
					<tr>
						<th colspan="">연락처</th>
						<td colspan="3">
						<span  class="enter enter_st3"><input type="text" title="제목" name="mobile1" class="title" value="${fn:split(messageVO.varFiled8,'-')[0]}" /></span>
						<span class="enter enter_st3"><input type="text" title="제목" name="mobile2" class="title" value="${fn:split(messageVO.varFiled8,'-')[1]}" /></span>
						<span class="enter enter_st3"><input type="text" name="mobile3" value="${fn:split(messageVO.varFiled8,'-')[2]}" title="제목"></span>
						<input type="hidden" name="varFiled8" value="" /></td>
					</tr>
					<tr>
						<th colspan="4" class="t_c"></th>
					</tr>
					<tr>
						<th class="">사진등록-앞부분</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file1" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile1" onchange="javascript:document.getElementById('upload_file1').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-좌측옆</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file2" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile2" onchange="javascript:document.getElementById('upload_file2').value=this.value">
							</span>
						</span></td>

					</tr>
					<tr>
						<th class="">사진등록-우측옆</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file3" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile3" onchange="javascript:document.getElementById('upload_file3').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-뒷부분</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file4" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile4" onchange="javascript:document.getElementById('upload_file4').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-실내</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file5" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile5" onchange="javascript:document.getElementById('upload_file5').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-기타1</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file6" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile6" onchange="javascript:document.getElementById('upload_file6').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-기타2</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file7" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile7" onchange="javascript:document.getElementById('upload_file7').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th class="">사진등록-기타3</th>
						<td colspan="2"><span class="upload_file"> <span class="enter_st enter_st2"><input type="text" id="upload_file8" readonly="readonly" title="파일이름"></span> <span class="btn_find_file"> <input type="file" name="showFile8" onchange="javascript:document.getElementById('upload_file8').value=this.value">
							</span>
						</span></td>
					</tr>
					<tr>
						<th colspan="4">상세설명</th>
					</tr>
					<tr>
						<th colspan="4"><textarea name="contents" id="cont" cols="30" rows="10">${messageVO.contents}</textarea></th>
					</tr>
					<tr>
						<td colspan="3">
						</th>
						<td>
						</th>
					</tr>
					<tr>
						<th colspan="4" class="po_r"><input type="checkbox" id="check2" data-from="checkbox"> <label for="check2">중고차 매물 등록시 입력된 정보열람 동의합니다.</label>
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