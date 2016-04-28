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
				getAddr('gugun', $("#addr3 option:selected").val(), '${fn:split(messageVO.varFiled3,'-')[1]}');
			}
			if(param1=='gugun'){
				if ($("#addr4 option").index($("#addr4 option:selected"))<0) {//대구-달서구-감삼동
					$("#addr4 option:eq(0)").attr("selected", "selected");
				}
				getAddr('dong', $("#addr4 option:selected").val(), '${fn:split(messageVO.varFiled3,'-')[2]}');
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
	getAddr('sido', '','${fn:split(messageVO.varFiled3,'-')[0]}');
})



</script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
	<input type="hidden" name="messageId" value="${messageVO.messageId }">
	<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
	<input type="hidden" name="topFlag" value="0" />
	<input type="hidden" name="statusType" value="2" />
	<input type="hidden" name="title" value="Company" />
	<input type="hidden" name="contents" value="Company" />

	<div class="title">${boardVO.title } ${messageVO!=null && messageVO.messageId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="" />
		</colgroup>



		<tbody>


			<tr>
				<th>업체명</th>
				<td>
				<input type="text" name="varFiled1" id="varFiled1" class="required" minlength="2" maxlength="40" size="40"  value="${messageVO.varFiled1 }" />
				</td>

			</tr>

			<tr>
				<th>주소</th>
				<td>

				<select id="addr3" name="addr3" title="" onchange="getAddr('gugun',this.value)">
					<option value="">선택(특/광/도)</option>
				</select> <select id="addr4" name="addr4" title="" onchange="getAddr('dong',this.value)">
					<option value="">선택(시/구/군)</option>
				</select> <select id="addr5" name="addr5" title="" onchange="getzipcode(this.value)">
					<option value="">선택(동/면/리)</option>
				</select>


				<input type="hidden" name="varFiled2" id="zipcode" value="${messageVO.varFiled2 }" />
				<input type="hidden" name="varFiled3" id="messageAddr1" value="${messageVO.varFiled3 }" />

				</td>

			</tr>
			<tr>
				<th>기술</th>
				<td>
				<input type="text" name="varFiled4" id="varFiled4" class="required" minlength="2" maxlength="40" size="40"  value="${messageVO.varFiled4 }" />
				</td>

			</tr>
			<tr>
				<th>서비스품목</th>
				<td>


				<select id="varFiled5" name="varFiled5" title="선택하세요">
					<option value="">서비스 품목</option>
					 <option value="폐차서비스" <c:if test="${messageVO.varFiled5=='폐차서비스'}"> selected</c:if>>폐차서비스</option>
                     <option value="중고부품 매매" <c:if test="${messageVO.varFiled5=='중고부품 매매'}"> selected</c:if>>중고부품 매매</option>
                     <option value="중고차매입" <c:if test="${messageVO.varFiled5=='중고차매입'}"> selected</c:if>>중고차매입</option>
                     <option value="자동차악세사리" <c:if test="${messageVO.varFiled5=='자동차악세사리'}"> selected</c:if>>자동차악세사리</option>
                     <option value="재생타이어" <c:if test="${messageVO.varFiled5=='재생타이어'}"> selected</c:if>>재생타이어</option>
                     <option value="재생부품업체" <c:if test="${messageVO.varFiled5=='재생부품업체'}"> selected</c:if>>재생부품업체</option>
                     <option value="보험관련업체" <c:if test="${messageVO.varFiled5=='보험관련업체'}"> selected</c:if>>보험관련업체</option>
				</select>
				</td>

			</tr>
			<tr>
				<th>전화번호</th>
				<td>
				<input type="text" name="varFiled6" id="varFiled6" class="required" minlength="2" maxlength="40" size="40"  value="${messageVO.varFiled6 }" />
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