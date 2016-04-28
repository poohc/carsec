<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<script type="text/javascript">
//<![CDATA[

//goForm
function goMessageForm(id){
    var form = document.messageForm;
    form.messageId.value = id;
    form.action="./messageForm.do";
    form.method="GET";
    form.submit();
}

//goSearch
function goMessageSearch(){
    var form = document.messageSearchForm;

    var addr1=$("#addr3 option:selected").text();
    if($("#addr4 option:selected").val() != ""){
    	addr1+="-"+$("#addr4 option:selected").text();
    }

    if($("#addr5 option:selected").val() != ""){
    	addr1+="-"+$("#addr5 option:selected").text();
    }

	form.varFiled3.value=addr1;

    form.submit();
}

//goPage
function goPage(pageNo){
    var form = document.messageSearchForm;
    form.pageNo.value = pageNo;
    form.submit();
}

//RemoveProc
function goMessageRemoveProc(){
    var form = document.messageListForm;

    var checkedCnt = 0;
    for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
        if(document.getElementsByName("checkedIds")[i].checked==true){
            checkedCnt++;
        }
    }
    if(checkedCnt==0){
        alert('삭제할 게시물을 선택하세요!');
        return;
    }

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./messageRemoveSelectProc.do";
    	form.method="POST";
        form.submit();
    }
}

//전체체크
function checkAll(){
    if(document.getElementById("allCheckBox").checked==true){
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=true;
        }
    }else{
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=false;
        }
    }
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

//]]>
</script>
</head>

<!-- 수정 및 등록을 위한폼 -->
<form name="messageForm">
	<input type="hidden" name="messageId" value="" />
	<input type="hidden" name="listReturnURL" value="${currentURI}" />
</form>

<div class="title">${boardVO.title} 목록(TOTAL:${messageList.messageSearchVO.totalCount})</div>

<div class="btn">
	<ul>
		<li class="btnFl"><a href="javascript:goMessageRemoveProc();"><img src="/common/images/admin/btn/btn_delete.gif" /></a></li>
		<li class="btnFl"><a href="javascript:goMessageForm('');"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
	    <li class="btnFr">


		    <form name="messageSearchForm" method="post">
		    <div class="searchinput">
			    <input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
			    <select id="addr3" name="addr3" title="" onchange="getAddr('gugun',this.value)">
					<option value="">선택(특/광/도)</option>
				</select> <select id="addr4" name="addr4" title="" onchange="getAddr('dong',this.value)">
					<option value="">선택(시/구/군)</option>
				</select> <select id="addr5" name="addr5" title="" onchange="getzipcode(this.value)">
					<option value="">선택(동/면/리)</option>
				</select>
				<input type="hidden" name="varFiled3" id="varFiled3" value="${param.varFiled3 }" />

				<input type="hidden" name="zipcode" id="zipcode" value="${param.varFiled2 }" />

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
			</div>
			<div class="searchbtn">
	    		<a href="javascript:goMessageSearch();"><img src="/common/images/admin/btn/btn_search.gif" /></a>
	    	</div>
	    	</form>
	    </li>
	</ul>
</div>
<div style="clear: both"></div>

<form name="messageListForm">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />

<table class="contents">
    <colgroup>
        <col width="10%" />
        <col width="5%"></col>
        <col width="20%"></col>
        <col width="20%"></col>
        <col width="20%"></col>
        <col width="10%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first"><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />All</th>
            <th>번호</th>
            <th>업체명</th>
            <th>주소</th>
            <th>기술</th>
            <th>서비스 품목</th>
            <th>전화번호</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${messageList.messageList}" var="i" varStatus="iStatus">
            <tr>
                <td align="center"><input type="checkbox" name="checkedIds" value="${i.messageId}" /></td>
                <td align="center">${messageList.messageSearchVO.pageStartIndex - iStatus.index}</td>
                  <td>
                	<a href="javascript:goMessageForm('${i.messageId}');">${i.varFiled1}</a>
                </td>
                <td align="center">${fn:replace(i.varFiled3,'-',' ')}</td>
                <td align="center">${i.varFiled4}</td>
                <td align="center">${i.varFiled5}</td>
                <td align="center">${i.varFiled6}</td>
            </tr>
        </c:forEach>
	<!-- Loop// -->
    </tbody>
</table>
</form>

<!-- //Paging -->
<jsp:include page="/WEB-INF/jsp/_include/paging.jsp" flush="true">
    <jsp:param name="count" value="${messageList.messageSearchVO.totalCount}" />
    <jsp:param name="row" value="${messageList.messageSearchVO.row}" />
    <jsp:param name="page" value="${messageList.messageSearchVO.pageNo}" />
</jsp:include>
<!-- Paging// -->

