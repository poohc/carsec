<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript">
<!--
	//goSearch
	function goMessageSearch() {
		var form = document.messageSearchForm;
		form.pageNo.value = "1";

		var addr1=$("#addr3 option:selected").text();
	    if($("#addr4 option:selected").val() != ""){
	    	addr1+="-"+$("#addr4 option:selected").text();
	    }

	    if($("#addr5 option:selected").val() != ""){
	    	addr1+="-"+$("#addr5 option:selected").text();
	    }

		form.varFiled3.value=addr1;


		form.action = "messageList.do"
		form.submit();
	}



	//goPage
	function goPage(pageNo) {
		var form = document.messageSearchForm;
		form.pageNo.value = pageNo;
		form.submit();
	}


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
					if ($("#addr3 option").index($("#addr3 option:selected"))<0) {//서울|강동구
						$("#addr3 option:eq(0)").attr("selected", "selected");
					}
					getAddr('gugun', $("#addr3 option:selected").val(), '${fn:split(param.addr4,'|')[1]}');
				}
				if(param1=='gugun'){
					if ($("#addr4 option").index($("#addr4 option:selected"))<0) {//134-082|서울|강동구|고덕2동
						$("#addr4 option:eq(0)").attr("selected", "selected");
					}
					getAddr('dong', $("#addr4 option:selected").val(), '${fn:split(param.addr5,'|')[3]}');
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
		getAddr('sido', '', '${param.addr3}');
	})

//-->
</script>

<c:if test="${fn:contains('newcar,newtech,maintennace,shopmarket,company1,company2,partsmarket',boardVO.boardKey) }">
<c:if test="${isLogin && sessionVO.level==40}">
<script>
function goMessageForm(){
	form=document.messageForm;
	form.action="messageForm.do";
	form.submit();
}
function goMessageDetail(id) {
	var form = document.messageForm;
	form.messageId.value = id;
	form.action = "messageDetail.do";

	form.method = "GET";
	form.submit();
}
</script>
</c:if>

<c:if test="${isLogin && sessionVO.level==10}">
<script>
function goMessageForm(){
	alert("메카닉회원만 이용할수 있습니다.");
}
function goMessageDetail(id) {
	alert("메카닉회원만 이용할수 있습니다.");
}
</script>
</c:if>

<c:if test="${!isLogin }">
<script>
function goMessageForm() {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}

function goMessageDetail(id) {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}

</script>
</c:if>
</c:if>

</head>
<body>
	<img src="/img/bullet/bullet_company1.png"/>
	<div class="recruit_search">
		<div class="selectbox_area">
			<!-- 검색박스 -->
			<form name="messageSearchForm" method="post">
				<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> <select id="addr3" name="addr3" title="" onchange="getAddr('gugun',this.value)">
					<option value="">선택(특/광/도)</option>
				</select> <select id="addr4" name="addr4" title="" onchange="getAddr('dong',this.value)">
					<option value="">선택(시/구/군)</option>
				</select> <select id="addr5" name="addr5" title="" onchange="getzipcode(this.value)">
					<option value="">선택(동/면/리)</option>
				</select>

				<input type="hidden" name="zipcode" id="zipcode" value="${param.varFiled2 }" />
				<input type="hidden" name="varFiled3" id="varFiled3" value="${param.varFiled3 }" />

				<select id="varFiled5" name="varFiled5" title="선택하세요">
					<option value="">서비스 품목</option>
					<option value="1급공업사" <c:if test="${param.varFiled5=='1급공업사'}"> selected</c:if>>1급공업사</option>
					<option value="2급공업사" <c:if test="${param.varFiled5=='2급공업사'}"> selected</c:if>>2급공업사</option>
					<option value="기본 경정비" <c:if test="${param.varFiled5=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
					<option value="판금" <c:if test="${param.varFiled5=='판금'}"> selected</c:if>>판금</option>
					<option value="도장" <c:if test="${param.varFiled5=='도장'}"> selected</c:if>>도장</option>
					<option value="덴트" <c:if test="${param.varFiled5=='덴트'}"> selected</c:if>>덴트</option>
					<option value="썬팅" <c:if test="${param.varFiled5=='썬팅'}"> selected</c:if>>썬팅</option>
					<option value="세차" <c:if test="${param.varFiled5=='세차'}"> selected</c:if>>세차</option>
					<option value="타이어" <c:if test="${param.varFiled5=='타이어'}"> selected</c:if>>타이어</option>
					<option value="카오디오" <c:if test="${param.varFiled5=='카오디오'}"> selected</c:if>>카오디오</option>
					<option value="블랙박스" <c:if test="${param.varFiled5=='블랙박스'}"> selected</c:if>>블랙박스</option>
					<option value="네비게이션" <c:if test="${param.varFiled5=='네비게이션'}"> selected</c:if>>네비게이션</option>
					<option value="씨트 인테리어" <c:if test="${param.varFiled5=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
					<option value="튜닝" <c:if test="${param.varFiled5=='튜닝'}"> selected</c:if>>튜닝</option>
				</select>
				<button type="button" class="input_type6" title="검색" onclick="javascript:goMessageSearch();">검색</button>

			</form>
		</div>

		<form name="messageForm">
			<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>
	</div>
	<div class="board_list">
		<!-- board_list -->
		<table>
			<caption>${boardVO.title }</caption>
			  <colgroup>
                  <col style="width:15%" />
                  <col style="width:30%" />
                  <col style="width:15%" />
                  <col style="width:auto" />
                  <col style="width:15%" />
              </colgroup>
              <thead>
                  <tr>
                      <th scope="col">업체명</th>
                      <th scope="col">주소</th>
                      <th scope="col">기술</th>
                      <th scope="col">서비스 품목</th>
                      <th scope="col">전화번호</th>
                  </tr>
              </thead>
			<tbody>
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<tr>
						<td>${i.varFiled1}</td>
						<td>${fn:replace(i.varFiled3,'-',' ')}</td>
						<td>${i.varFiled4}</td>
						<td>${i.varFiled5}</td>
						<td>${i.varFiled6}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="paging">
		<!-- //Paging -->
		<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
			<jsp:param name="count" value="${messageList.messageSearchVO.totalCount}" />
			<jsp:param name="row" value="${messageList.messageSearchVO.row}" />
			<jsp:param name="page" value="${messageList.messageSearchVO.pageNo}" />
		</jsp:include>
		<!-- Paging// -->
	</div>


</body>
</html>