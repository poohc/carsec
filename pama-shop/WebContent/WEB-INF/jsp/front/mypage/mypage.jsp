<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/common/css/front/common1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/custom1.css" type="text/css" />
<link rel="stylesheet" href="/common/jquery-ui-1.11.4.custom/jquery-ui.css">
<script src="/common/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script src="/common/js/jquery.validate.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript" src="/common/js/join.js" charset="utf-8"></script>
<script>
<!--
$().ready(function() {

	$.validator.addMethod("alphanumeric", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
	});

    $("#submitButton").click(function(){
    	$("#accountForm").submit();
    });

	$("#accountForm").validate({
    	rules: {

    		firstName: {
    			required: true
    		},
    		birth:{
    			required:true
    		},
    		mbrId: {
    			required: true,
    			minlength: 5,
    			maxlength: 16,
    			alphanumeric:true
    		},
    		pwd: {
    			required: true,
    			minlength: 8,
    			maxlength: 10,
    			alphanumeric:true
    		},
    		pwdchk: {
    			required: true,
    			minlength: 8,
    			equalTo: "#pwd"
    		},
    		email1: {
    			required: true
    		},
    		email2: {
    			required: true
    		}

    	},
    	messages:{


    		firstName :{
    			required:"성명을 입력하세요."
    		},

    		mbrId :{
    			required: "아이디를 입력해주세요.",
    			alphanumeric: "영문과 숫자만 사용가능합니다."
    		},
    		pwd :{
    			required:"패스워드를 입력하세요.",
    			alphanumeric: "영문과 숫자만 사용가능합니다."
    		},
    		pwdchk :{
    			required:"패스워드확인을 입력하세요.",
    			equalTo: "비밀번호를 잘못 입력하셨습니다."
    		},
    		email1 :{
    			required:"이메일 아이디를 입력하세요."
    		},
    		email2 :{
    			required:" 이메일 계정을 입력하세요."
    		}

    	},
    	submitHandler: function(form) {

    		var isSubmit=true;
    		var email=$("#email1").val()+"@"+$("#email2").val();
    		$("#email").attr("value",email);

    		var modelSelected = $("#model").val().split("|")[1]+"("+$("#model").val().split("|")[2]+")";
    		$("#modelInfo").val(modelSelected);

    		var caryearSelected = $("#caryear").val();
    		var caryearSelectedinfo = caryearSelected.split("|")[1];
    		$("#carYearInfo").val(caryearSelectedinfo);


    		/*
    		if(caryearSelected == null || caryearSelected==""){
    			alert("차량 년식을 선택해주세요.");
    			isSubmit=false;
    			return;
    		}

    		*/

    		if ($("#mobile").val()!="") {
	    	    if ($("#mobileCertYn").val()=="" || $("#mobileCertYn").val()=="N") {
	    	    	alert("휴대폰번호를 인증해 주세요.");
	    			isSubmit=false;
	    			return;
	    	    }
    		}

    	    if(isSubmit){
    	    	form.submit();
    	    }

    	}
    });
/*----  Validate End */

	// Datepicker
	minYear=1936;
	maxYear=new Date().getFullYear();
	// Datepicker
	$('#birth').datepicker({
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		dateFormat: "yy-mm-dd",
		showMonthAfterYear: true,
		changeYear: true,
		changeMonth: true,
		yearRange:minYear+':'+maxYear
	});

});


function getCar(param1, param2, param3, param4) {
	var maker = "";
	var modelName = "";
	var method = "";
	var mission = ["White","Yellow","Brown","Black","Gray","Blue","Green","Puple","투톤"];
	param2 = param2 + "|||";
	if(param1=='mission') {
		for (var i=0; i<mission.length;i++) {
			if (mission[i] == param3) {
				selected=true;
			} else {
				selected=false;
			}
			$('#mission')
	          .append($('<option>', { value : mission[i] })
	          .attr('selected', selected)
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
						if (this.maker == param3) {
							selected=true;
						} else {
							selected=false;
						}
						$('#brand')
				          .append($('<option>', { value : this.maker })
				          .attr('selected', selected)
				          .text(this.maker));
					}
					if(param1=='model'){
						if ((this.modelName+"("+this.method+")") == param3) {
							selected=true;
						} else {
							selected=false;
						}
						$('#model')
				          .append($('<option>', { value : this.maker+"|"+this.modelName+"|"+this.method })
				          .attr('selected', selected)
				          .text(this.modelName+"("+this.method+")"));
					}
					if(param1=='years'){
						for (var i=this.endYear; i>=this.startYear; i--) {
							if (i == param3) {
								selected=true;
							} else {
								selected=false;
							}
							$('#caryear')
					          .append($('<option>', { value : this.carId +"|"+i })
					          .attr('selected', selected)
					          .text(i));
						}
					}
				});
				if(param1=='maker'){
					if ($("#brand option").index($("#brand option:selected"))<0) {
						$("#brand option:eq(0)").attr("selected", "selected");
					}
					getCar('model', $("#brand option:selected").val(), '${accountFormVO.accountCarInfoVO.model}', param4);
				}
				if(param1=='model'){
					if ($("#model option").index($("#model option:selected"))<0) {
						$("#model option:eq(0)").attr("selected", "selected");
					}
					getCar('years', $("#model option:selected").val(), '${accountFormVO.accountCarInfoVO.caryear}', param4);
				}
				if(param1=='years'){
					if ($("#caryear option").index($("#caryear option:selected"))<0) {
						$("#caryear option:eq(0)").attr("selected", "selected");
					}
					if ($("#caryear option").length > 1){
						getCar('mission', '', param4, '');
					}
				}
			}
		});
	}
}

$( document ).ready( function() {

	/* 생년월일 표기
	var dateRead1 = $("#date1").val();
	var date2 = dateRead1.replace("-", "년 ");
	var date3 = date2.replace("-", "월 ");
	$("#dd").append(date3+ "일");
	 */


	/* 핸드폰번호 표기 -삽입
	var mo = $("#mobileWrite").val();
	if(10 < mo.length ){
	var moo = mo.length;
	var moo1 = mo.slice(0,3);
	var moo2 = mo.slice(3,7);
	var moo3 = mo.slice(7,11);
	$("#cc").append(moo1+"-"+moo2+"-"+moo3);
	}else{
		var moo1 = mo.slice(0,3);
		var moo2 = mo.slice(3,6);
		var moo3 = mo.slice(6,10);
		$("#cc").append(moo1+"-"+moo2+"-"+moo3);
	}
	*/


	getCar('maker', '', '${accountFormVO.accountCarInfoVO.brand}', '${accountFormVO.accountCarInfoVO.mission}');
})
//-->
</script>
<script type="text/javascript">
<!--
/* 일반회워 ID 체크 */
function getIdChk() {
		var f = document.accountForm;
		var str = f.mbrId.value;
		var retVal = checkSpace(str);
		var isID = /^[a-z0-9_]{5,20}$/;

		if (f.mbrId.value == "") {
			alert("아이디를 입력하십시오.");
			f.mbrId.focus();
			return false;
		}

		if (retVal != "") {
			alert("아이디는 빈 공간 없이 연속된 영문 소문자와 숫자만 사용할 수 있습니다.");
			f.mbrId.focus();
		} else if (str.charAt(0) == '_') {
			alert("아이디의 첫문자는 '_'로 시작할수 없습니다.");
			f.mbrId.focus();
		} else if (f.mbrId.value.length < 5) {
			alert("아이디는 5자 이상입니다.");
			f.mbrId.focus();
		} else if (chkNonchar(f.mbrId.value)) {
			alert("아이디에 특수문자는 입력할 수 없습니다.");
			f.mbrId.focus();
		} else if (!isID.test(str)) {
			alert("아이디는 5~20자의 영문 소문자와 숫자,특수기호(_)만 사용할 수 있습니다.");
			f.mbrId.focus();
		} else {
			parm1 = f.mbrId.value;
			var statusTypeChangeUrl = '/signup/accountIdChk.do?mbrId=' + parm1;
			$.getJSON(statusTypeChangeUrl, function(data) {
				if (data.mbrIdChk != null) {
					alert("이미 사용중인 아이디 입니다. 다른 아이디를 입력하세요.");
					f.idchkYn.value = "";
				} else {
					alert("사용 가능한 아이디 입니다.");
					f.idchkYn.value = "Y";
				}
			});
			return true;
		}
	}

function emailserv(value){
    var form = document.accountForm;
	if(value != ''){
		$("#email2").attr("readonly",true);
	}else{
		$("#email2").attr("readonly",false);
	}

    form.email2.value = value;
    form.emailchkYn.value="";

}

function mobileserv(){
    $("#mobileCertYn").attr("value", "");
}

function getCarCode(code) {
	var carCode = code.split("|")[0];
	$("#carCode").val(carCode);
}

function getCert() {
	var moblie = $("#mobile").val();
	$.ajax({
		type : "POST",
		url : "/signup/accountCert.do",
		data : {"number":moblie},
		dataType : "json",
		success : function(data){
			if (data.result == 'error') {
				alert("인증번호 발송하는데 실패하였습니다. 다시 발생해주세요.");
			} else if (data.result == 'success') {
				alert("인증번호를 발송하였습니다..");
			}
		}
	});
}

function getCertResult() {
	var moblie = $("#mobile").val();
	var certKey = $("#certification").val();
	if ($("#mobileCertYn").val()!="Y") {
		$.ajax({
			type : "POST",
			url : "/signup/accountCertChk.do",
			data : {"mobile":moblie,"certKey":certKey},
			dataType : "json",
			success : function(data){
				if (data.result == 'error') {
					$("#mobileCertYn").attr("value", "");
					alert("인증이 실패하였습니다.");
				} else if (data.result == 'success') {
					$("#mobileCertYn").attr("value", "Y");
					alert("인증이 성공하였습니다.");
				}
			}
		});
	}
}
//-->
</script>
</head>
<body>
	<!-- contain -->
	<div class="header_etc2">
		<div class="wrap_header2">
			<ul class="information_list">
				<li class=""><a href="/mbr/mypage/mypage.do">회원정보 변경</a></li>
				<li class="on"><a href="/mbr/mypage/mypageChangePwd.do">비밀번호 변경</a></li>
			</ul>
		</div>
	</div>
	<div id="container">
		<div class="join_wrap">
			<div class="bbs">
				<form name="accountForm" id="accountForm" method="post" class="accountForm" action="mypageModifyFormProc.do">
					<!--가맹점 정보-->
					<div class="join_fied">
						<fieldset>
							<h3 class="dep2_tit">회원정보 수정 - 일반회원</h3>
							<p class="joinFieldText">* 표시된 항목은 반드시 입력/선택 해야합니다.</p>
							<input type="hidden" name="mbrId" id="mbrId"  value="${accountFormVO.mbrId}" />
							<input type="hidden" name="emailchkYn" id="emailchkYn" class="emailchkYn" value="" />
							<input type="hidden" name="email" id="email" value="" />
							<input type="hidden" name="accountCarInfoVO.carId" id="carId" value="${accountFormVO.accountCarInfoVO.carId}" />
							<input type="hidden" name="accountCarInfoVO.carCode" id="carCode" value="${accountFormVO.accountCarInfoVO.carCode}" />
							<input type="hidden" name="accountCarInfoVO.caryear" id="carYearInfo"
								value="${accountFormVO.accountCarInfoVO.caryear}" />
							<input type="hidden" name="accountCarInfoVO.model" id="modelInfo" value="${accountFormVO.accountCarInfoVO.model}" />
							<input type="hidden" name="mobileCertYn" id="mobileCertYn"  value="" />
							<input type="hidden" name="date1" id="date1" value="${accountFormVO.birth}" />
							<input type="hidden" name="mobileWrite" id="mobileWrite" value="${accountFormVO.mobile}" />

							<table width="100%" summary="" cellpadding="0" cellspacing="0">
								<colgroup>
									<col width="140" />
									<col width="850" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="comp_name">이름</label> <span class="warning">*</span></th>

										<td>${accountFormVO.firstName}</td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">생년월일</label> <span class="warning">*</span></th>
										<td><input type="text" name="birth" id="birth" placeholder="생년월일" value="${accountFormVO.birth}" readonly="readonly"></td>
									</tr>

<!-- 									<tr> -->
<!-- 										<th scope="row"><label for="comp_num">생년월일</label> <span class="warning">*</span></th> -->
<!-- 										<td><p id="dd"></p></td> -->
<!-- 									</tr> -->
									<tr>
										<th scope="row"><label for="comp_num">ID</label> <span class="warning">*</span></th>
										<td>${accountFormVO.mbrId}</td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">닉네임</label> <span class="warning"></span></th>
										<td>${accountFormVO.nickName}</td>
									</tr>

 									<tr>
 										<th scope="row"><label for="comp_num">휴대폰 번호</label> <span class="warning">*</span></th>
 										<td><p id="cc">${accountFormVO.mobile}</p></td>
 									</tr>
 									<tr>
 										<th scope="row"><label for="comp_id">휴대폰번호인증</label> <span class="warning">*</span></th>
 										<td><input type="text" id="mobile" name="mobile" class="inpText" placeholder="새로운휴대폰번호" class="required" onChange="mobileserv()"/> <a class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증번호발송" onClick="getCert();"/></a></td>
 									</tr>

 									<tr>
 										<th scope="row"><label for="comp_id">인증번호입력</label> <span class="warning">*</span></th>
 										<td><input type="text" name="certification" id="certification" placeholder="인증번호입력" class="inpText" /> <a href="#" class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증하기" onClick="getCertResult()"/></a></td>
 									</tr>

									<tr class="email_bx">
										<th scope="row"><label for="ceo_email">이메일 주소 변경 </label> <span class="warning">*</span></th>
										<td>
<%-- 										<p>현재 이메일 주소 :${accountFormVO.email}</p> --%>

										<input type="text" id="email1" name="email1" title="이메일 아이디를 작성하세요." value="${fn:split(accountFormVO.email,'@')[0]}" /> @ <input type="text" id="email2" name="email2" value="${fn:split(accountFormVO.email,'@')[1]}" title="이메일 계정을 작성하세요." /> <select title="이메일 계정을 선택하세요." id="email3" name="email3" onchange="emailserv(this.value);">
												<option value="">직접입력</option>
												<option value="naver.com">네이버</option>
												<option value="hanmail.net">다음</option>
												<option value="nate.com">네이트</option>
												<option value="gmail.com">구글</option>
										</select></td>
									</tr>

									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">차량정보입력</label></th>
										<td>
											<p>차량 정보를 정확히 입력하면 정확한 견적을 받을 수 있습니다.</p> <select id="brand" name="accountCarInfoVO.brand" title="선택하세요" onchange="getCar('model', this.value, '', '')">
												<option value="">제조사 선택</option>
										</select> <br> <select id="model" name="modelSelect" title="선택하세요" onchange="getCar('years', this.value, '', '')">
												<option value="">모델명 선택</option>
										</select> <br> <select id="caryear" name="caryearSelect" title="선택하세요" onchange="getCarCode(this.value)">
												<option value="">연식 선택</option>
										</select> <br> <select id="mission" name="accountCarInfoVO.mission" title="선택하세요">
												<option value="">색상 선택</option>
										</select> <br> <input type="text" id="carIdentNumber" name="accountCarInfoVO.carIdentNumber" class="inpText" placeholder="차대번호입력" value="${accountFormVO.accountCarInfoVO.carIdentNumber}" /> <br> <input type="text" id="carNumber" name="accountCarInfoVO.carNumber" placeholder="차량번호입력" value="${accountFormVO.accountCarInfoVO.carNumber}" /> <br> <input type="text" id="distance" name="accountCarInfoVO.distance" class="inpText" placeholder="주행거리입력"
											value="${accountFormVO.accountCarInfoVO.distance}" />Km
										</td>
									</tr>

								</tbody>
							</table>
						</fieldset>
					</div>
				</form>
				<!--//가맹점 정보-->
				<br /> <br />
				<div class="agree_wrap">

					<div class="bt" style="height: 66px;">
						<img id="submitButton" src="/join_form_img/sub/bt_ok.png" alt="확인" style="cursor: pointer; "/> <a href="/main/main.do"><img src="/join_form_img/sub/bt_no.png" alt="취소" /></a>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>