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

		form.varFiled2.value=addr1;


		form.action = "messageList.do"
		form.submit();
	}



	//goDetail
	function goMessageDetail(id) {
		var form = document.messageForm;
		form.messageId.value = id;
		form.action = "messageDetail.do";

		form.method = "GET";
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
</head>
<body>

	<div class="layout_type1">
		<div class="write_search" style="text-align: right;">
			<!-- 검색박스 -->
			<form name="messageSearchForm" method="post">
				<input type="hidden" name="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> <select id="addr3" name="addr3" title="" onchange="getAddr('gugun',this.value)">
					<option value="">선택(특/광/도)</option>
				</select> <select id="addr4" name="addr4" title="" onchange="getAddr('dong',this.value)">
					<option value="">선택(시/구/군)</option>
				</select> <select id="addr5" name="addr5" title="" onchange="getzipcode(this.value)">
					<option value="">선택(동/면/리)</option>
				</select>

				<input type="hidden" name="zipcode" id="zipcode" value="${param.varFiled3 }" />
				<input type="hidden" name="varFiled2" id="varFiled2" value="${param.varFiled2 }" />

				<select id="varFiled5" name="varFiled5" title="선택하세요">
					 <option value="">서비스 품목</option>
					 <option value="폐차서비스" <c:if test="${param.varFiled5=='폐차서비스'}"> selected</c:if>>폐차서비스</option>
                     <option value="중고부품 매매" <c:if test="${param.varFiled5=='중고부품 매매'}"> selected</c:if>>중고부품 매매</option>
                     <option value="중고차매입" <c:if test="${param.varFiled5=='중고차매입'}"> selected</c:if>>중고차매입</option>
                     <option value="자동차악세사리" <c:if test="${param.varFiled5=='자동차악세사리'}"> selected</c:if>>자동차악세사리</option>
                     <option value="재생타이어" <c:if test="${param.varFiled5=='재생타이어'}"> selected</c:if>>재생타이어</option>
                     <option value="재생부품업체" <c:if test="${param.varFiled5=='재생부품업체'}"> selected</c:if>>재생부품업체</option>
                     <option value="보험관련업체" <c:if test="${param.varFiled5=='보험관련업체'}"> selected</c:if>>보험관련업체</option>
				</select>
				<button type="button" class="input_type6" title="검색" onclick="javascript:goMessageSearch();">검색</button>

			</form>
		</div>

		<form name="messageForm">
			<input type="hidden" name="messageId" value="" /> <input type="hidden" name="listReturnURL" value="${currentQuery}" />
		</form>


		<ul class="gallery_layout2">
		 <c:forEach items="${messageList.messageList}" var="i" varStatus="iStatus">

		 			<li>
		 			 <a href="javascript:goMessageDetail('${i.messageId}');">
                            <c:if test="${fn:length(i.showFile1) > 0}">
		                	<img src="/media/${i.showFile1}.image" width="228px" height="142px">
		                	</c:if>
                            <div class="gallery_introbox">
                            	<h1 class="elipsis">${i.title}</h1>
                                <p>${i.varFiled1}</p>
                                <p>${fn:replace(i.varFiled2,'-',' ')} ${i.varFiled3}<p>
                                <span>
                                [${i.varFiled5}&nbsp;${i.varFiled4}&nbsp;${i.varFiled7}&nbsp;${i.varFiled8}&nbsp;${i.subTitle}]</span>



                                <span>${i.varFiled6}</span>
                            </div>
                        </a>
                    </li>
		  </c:forEach>
        </ul>


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