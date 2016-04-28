<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
<script>
function getAddr(param1, param2, param3) {
	var sido = "";
	var gugun = "";
	var dong = "";
	param2 = param2 + "|||";
	if(param1=='gugun'){
		sido = param2.split("|")[0];
	}
	if(param1=='dong'){
		sido = param2.split("|")[0];
		gugun = param2.split("|")[1];
	}
	$.ajax({
		type : "POST",
		url : "/mbr/accountAddrSearch.do",
		data : {"searchType":param1,"sido":sido,"gugun":gugun,"dong":dong},
		dataType : "json",
		success : function(data){
			if(param1=='gugun'){
				$('#addr4').children().remove();
				$('#addr4')
		          .append($('<option>', { value : "" })
		          .text("선택(시/구/군)"));
			}
			if(param1=='dong' || param1=='gugun'){
				$('#addr5').children().remove();
				$('#addr5')
		          .append($('<option>', { value : "" })
		          .text("선택(동/면/리)"));
			}

			$.each(data.zipcode, function(){
				if(param1=='sido'){
					if (this.sido == param3) {
						selected=true;
					} else {
						selected=false;
					}
					$('#addr3')
			          .append($('<option>', { value : this.sido })
			          .attr('selected', selected)
			          .text(this.sido));
				}
				if(param1=='gugun'){
					if (this.gugun == param3) {
						selected=true;
					} else {
						selected=false;
					}
					$('#addr4')
			          .append($('<option>', { value : this.sido+"|"+this.gugun })
			          .attr('selected', selected)
			          .text(this.gugun));
				}
				if(param1=='dong'){
					if (this.dong == param3) {
						selected=true;
					} else {
						selected=false;
					}
					$('#addr5')
			          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
			          .attr('selected', selected)
			          .text(this.dong));
				}
			});
			if(param1=='sido'){
				if ($("#addr3 option").index($("#addr3 option:selected"))<0) {//대구-달서구-감삼동
					$("#addr3 option:eq(0)").attr("selected", "selected");
				}
				getAddr('gugun', $("#addr3 option:selected").val(), '${fn:split(messageVO.varFiled2,'-')[1]}');
			}
			if(param1=='gugun'){
				if ($("#addr4 option").index($("#addr4 option:selected"))<0) {//대구-달서구-감삼동
					$("#addr4 option:eq(0)").attr("selected", "selected");
				}
				getAddr('dong', $("#addr4 option:selected").val(), '${fn:split(messageVO.varFiled2,'-')[2]}');
			}
			if(param1=='dong'){
				if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
					$("#addr5 option:eq(0)").attr("selected", "selected");
				}
			}
		}


	});
}

function getzipcode(code) {
	var zipcode = code.split("|")[0];
	$("#zipcode").val(zipcode);
}


$( document ).ready( function() {
	getAddr('sido', '','${fn:split(messageVO.varFiled2,'-')[0]}');


})



</script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}" enctype="multipart/form-data">

	<input type="hidden" name="messageId" value="${messageVO.messageId }">
	<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
	<input type="hidden" name="topFlag" value="0" />
	<input type="hidden" name="statusType" value="2" />

	<div class="title">${boardVO.title } ${messageVO!=null && messageVO.messageId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="200px" />
			<col width="120px" />
			<col width="" />
		</colgroup>



		<tbody>

			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="title" id="title" class="required" minlength="4" maxlength="100" value="${messageVO.title }" style="width: 590px;" /></td>
			</tr>


			<tr>
				<th>업체명</th>
				<td colspan="3">
				<input type="text" name="varFiled1" id="varFiled1" class="required" minlength="2" maxlength="40" size="40"  value="${messageVO.varFiled1 }" />
				</td>

			</tr>

			<tr>
				<th>주소<br />상세주소</th>
				<td colspan="3">

				<select id="addr3" name="addr3" title="" onchange="getAddr('gugun',this.value)">
					<option value="">선택(특/광/도)</option>
				</select> <select id="addr4" name="addr4" title="" onchange="getAddr('dong',this.value)">
					<option value="">선택(시/구/군)</option>
				</select> <select id="addr5" name="addr5" title="" onchange="getzipcode(this.value)">
					<option value="">선택(동/면/리)</option>
				</select>

				<input type="hidden" name="varFiled2" id="messageAddr1" value="${messageVO.varFiled2 }" /><br />
				 <input type="text" name="varFiled3" id="varFiled3" value="${messageVO.varFiled3 }" size="60" maxlength="100" />

				</td>

			</tr>
			<tr>
				<th>서비스품목</th>
				<td colspan="3">

				 <select id="varFiled5" name="varFiled5" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${messageVO.varFiled5=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${messageVO.varFiled5=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${messageVO.varFiled5=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${messageVO.varFiled5=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${messageVO.varFiled5=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${messageVO.varFiled5=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${messageVO.varFiled5=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${messageVO.varFiled5=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${messageVO.varFiled5=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${messageVO.varFiled5=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${messageVO.varFiled5=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${messageVO.varFiled5=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${messageVO.varFiled5=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${messageVO.varFiled5=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>

				 <select id="varFiled4" name="varFiled4" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${messageVO.varFiled4=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${messageVO.varFiled4=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${messageVO.varFiled4=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${messageVO.varFiled4=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${messageVO.varFiled4=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${messageVO.varFiled4=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${messageVO.varFiled4=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${messageVO.varFiled4=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${messageVO.varFiled4=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${messageVO.varFiled4=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${messageVO.varFiled4=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${messageVO.varFiled4=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${messageVO.varFiled4=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${messageVO.varFiled4=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>

				 <select id="varFiled7" name="varFiled7" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${messageVO.varFiled7=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${messageVO.varFiled7=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${messageVO.varFiled7=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${messageVO.varFiled7=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${messageVO.varFiled7=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${messageVO.varFiled7=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${messageVO.varFiled7=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${messageVO.varFiled7=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${messageVO.varFiled7=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${messageVO.varFiled7=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${messageVO.varFiled7=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${messageVO.varFiled7=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${messageVO.varFiled7=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${messageVO.varFiled7=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>

				 <select id="varFiled8" name="varFiled8" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${messageVO.varFiled8=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${messageVO.varFiled8=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${messageVO.varFiled8=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${messageVO.varFiled8=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${messageVO.varFiled8=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${messageVO.varFiled8=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${messageVO.varFiled8=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${messageVO.varFiled8=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${messageVO.varFiled8=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${messageVO.varFiled8=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${messageVO.varFiled8=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${messageVO.varFiled8=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${messageVO.varFiled8=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${messageVO.varFiled8=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>

				 <select id="subTitle" name="subTitle" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${messageVO.subTitle=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${messageVO.subTitle=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${messageVO.subTitle=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${messageVO.subTitle=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${messageVO.subTitle=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${messageVO.subTitle=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${messageVO.subTitle=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${messageVO.subTitle=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${messageVO.subTitle=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${messageVO.subTitle=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${messageVO.subTitle=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${messageVO.subTitle=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${messageVO.subTitle=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${messageVO.subTitle=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>

				</td>

			</tr>
			<tr>
				<th>전화번호</th>
				<td colspan="3">
				<input type="text" name="varFiled6" id="varFiled6" class="required" minlength="2" maxlength="40" size="40"  value="${messageVO.varFiled6 }" />
				</td>

			</tr>

			<tr>
		        <th>이미지 </th>
		        <td colspan="3">
			        <input type="file" name="showFile1" id="showFile1" width="120px" /> <br /><br />
		            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==1}">
							<div id="img_${i.fileName}"><img src="/media/${i.fileName}.image" width="200px"/> ${i.displayName} <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
						</c:if>
		            </c:forEach>
		        </td>
		    </tr>

		     <tr>
				<th>직원수</th>
				<td><input type="text" name="varFileds1" id="varFileds1" maxlength="40" size="10"  value="${messageVO.messageVarFiledsVO.varFileds1}" /></td>
				<th>리프트수</th>
				<td><input type="text" name="varFileds2" id="varFileds2" maxlength="40" size="10"  value="${messageVO.messageVarFiledsVO.varFileds2}" /></td>
			</tr>
			<tr>
				<th>영업시간</th>
				<td><input type="text" name="varFileds3" id="varFileds3" maxlength="40" size="10"  value="${messageVO.messageVarFiledsVO.varFileds3}" /></td>
				<th>휴무일</th>
				<td><input type="text" name="varFileds4" id="varFileds4" maxlength="40" size="10"  value="${messageVO.messageVarFiledsVO.varFileds4}" /></td>
			</tr>


			<tr>
				<th>보험수리</th>
				<td><input type="checkbox" name="varFileds5" id="varFileds5" value="Y" ${messageVO.messageVarFiledsVO.varFileds5=='Y'?'checked':''} /></td>
				<th>부품지침정비</th>
				<td><input type="checkbox" name="varFileds6" id="varFileds6" value="Y" ${messageVO.messageVarFiledsVO.varFileds6=='Y'?'checked':''}/></td>
			</tr>

			<tr>
				<th>수리중 대차</th>
				<td><input type="checkbox" name="varFileds7" id="varFileds7" value="Y" ${messageVO.messageVarFiledsVO.varFileds7=='Y'?'checked':''}/></td>
				<th>출동서비스</th>
				<td><input type="checkbox" name="varFileds8" id="varFileds8" value="Y" ${messageVO.messageVarFiledsVO.varFileds8=='Y'?'checked':''}/></td>
			</tr>
			<tr>
				<th>차량픽업</th>
				<td><input type="checkbox" name="varFileds9" id="varFileds9" value="Y" ${messageVO.messageVarFiledsVO.varFileds9=='Y'?'checked':''}/></td>
				<th>국산차 정비</th>
				<td><input type="checkbox" name="varFileds10" id="varFileds10" value="Y" ${messageVO.messageVarFiledsVO.varFileds10=='Y'?'checked':''}/></td>
			</tr>
			<tr>
				<th>일본차 정비</th>
				<td><input type="checkbox" name="varFileds11" id="varFileds11" value="Y" ${messageVO.messageVarFiledsVO.varFileds11=='Y'?'checked':''}/></td>
				<th>미국차 정비</th>
				<td><input type="checkbox" name="varFileds12" id="varFileds12" value="Y" ${messageVO.messageVarFiledsVO.varFileds12=='Y'?'checked':''}/></td>
			</tr>
			<tr>
				<th>유럽차 정비</th>
				<td colspan="3"><input type="checkbox" name="varFileds13" id="varFileds13" value="Y" ${messageVO.messageVarFiledsVO.varFileds13=='Y'?'checked':''}/></td>
			</tr>
			<tr>
				<th>서비스 제공</th>
				<td colspan="3"><input type="text" name="varFileds14" id="varFileds14" maxlength="40" size="60"  value="${messageVO.messageVarFiledsVO.varFileds14}" /></td>
			</tr>


			<tr>
				<th>내용</th>
				<td colspan="3"><textarea cols="80" id="contentsarea" name="contents" rows="10">${messageVO.contents }</textarea>
				<script type="text/javascript">
                CKEDITOR.replace( 'contentsarea', {width:'100%',height: 400} );
            	</script>
            	</td>
			</tr>


		</tbody>

	</table>

	<div class="btn">
		<ul>
			<li class="btnFl"><a href="javascript:goList('${ param.listReturnURL }');"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
			<li class="btnFr">
				<input type="image" src="/common/images/admin/btn/btn_save.gif" />
				<a href="#;" onclick="messageForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
			</li>
		</ul>
	</div>
</form>
</html>