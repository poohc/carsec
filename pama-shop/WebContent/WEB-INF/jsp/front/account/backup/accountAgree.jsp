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
    		nickName: {
    			required: true,
    			minlength: 2,
    			maxlength: 16
    		},
    		mobile: {
    			required: true
    		},
    		certification: {
    			required: true
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
    		nickName :{
    			required: "닉네임을 입력해주세요."

    		},
    		mobile :{
    			required:"휴대폰번호를 입력하세요."
    		},
    		certification :{
    			required:"인증번호를 입력하세요."
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
    		var caryearSelectedinfo = caryearSelected.split("|")[1]; //12|2015
    		$("#carYearInfo").val(caryearSelectedinfo);
/*
    		if(caryearSelected == null || caryearSelected==""){
    			alert("차량 년식을 선택해주세요.");
    			isSubmit=false;
    			return;
    		}

    		*/

    		if($("#idchkYn").val()==""){
    			alert("아이디중복체크를 해주세요.");
    			isSubmit=false;
    			return;
    		}
    		if($("#nickchkYn").val()==""){
    			alert("닉네임중복체크를 해주세요.");
    			isSubmit=false;
    			return;
    		}

    		if (!form.check1[0].checked){
    	        alert( "이용약관을 읽고 동의해주세요." );
    	        form.check1[0].focus();
    	        isSubmit=false;
    	        return;
    	    }
    	    if (!form.check2[0].checked){
    	        alert( "개인정보취급방침을 읽고 동의해주세요." );
    	        form.check2[0].focus();
    	        isSubmit=false;
    	        return;
    	    }
    	    if (!form.check3[0].checked){
    	        alert( "쿠폰 서비스 약관 읽고 동의해주세요." );
    	        form.check3[0].focus();
    	        isSubmit=false;
    	        return;
    	    }

    	    if ($("#mobileCertYn").val()=="" || $("#mobileCertYn").val()=="N") {
    	    	alert("휴대폰번호를 인증해 주세요.");
    			isSubmit=false;
    			return;
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

function getCarCode(code) {
	var carCode = code.split("|")[0];
	$("#carCode").val(carCode);
}

</script>
<script type="text/javascript">
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

/* 일반회워 nickName 체크 */
function getNickChk() {
		var f = document.accountForm;
		var str = f.nickName.value;
		var retVal = checkSpace(str);
		var isID = /^[a-z0-9_]{5,20}$/;

		if (f.nickName.value == "") {
			alert("닉네임을 입력하십시오.");
			f.nickName.focus();
			return false;
		}
		if (retVal != "") {
			alert("닉네임은 빈 공간 없이 연속된 영문 소문자와 숫자만 사용할 수 있습니다.");
			f.nickName.focus();
		}

		if (f.nickName.value.length < 2) {
				alert("닉네임은 2자 이상입니다.");
				f.nickName.focus();
		}

			parm1 = f.nickName.value;
			var statusTypeChangeUrl = '/signup/accountNickChk.do?nickName=' + parm1;
			$.getJSON(statusTypeChangeUrl, function(data) {
				if (data.mbrNickChk != null) {
					alert("이미 사용중인 닉네임 입니다. 다른 닉네임을 입력하세요.");
					f.nickchkYn.value = "";
				} else {
					alert("사용 가능한 닉네임 입니다.");
					f.nickchkYn.value = "Y";
				}
			});
			return true;
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

function fieldservId(){
	$("#idchkYn").val("");
}

function fieldservNickName(){
	$("#nickchkYn").val("");
}

function fieldservMobile(){
	$("#mobileCertYn").val("");
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
					$("#mobileCertYn").val("");
					alert("인증이 실패하였습니다.");
				} else if (data.result == 'success') {
					$("#mobileCertYn").val("Y");
					alert("인증이 성공하였습니다.");
				}
			}
		});
	}
}
</script>
</head>
<body>
	<!-- contain -->
	<form name="accountForm" id="accountForm" method="post" class="accountForm" action="accountAgreeProc.do">
		<div id="container">
			<div class="join_wrap">
				<div class="bbs">

					<!--가맹점 정보-->
					<div class="join_fied">
						<fieldset>
							<h3 class="dep2_tit">일반회원가입</h3>
							<p class="joinFieldText">* 표시된 항목은 반드시 입력/선택 해야합니다.</p>

							<input type="hidden" name="idchkYn" id="idchkYn" value="" />
							<input type="hidden" name="nickchkYn" id="nickchkYn" value="" />
							<input type="hidden" name="mobilechkYn" id="mobilechkYn" value="" />
							<input type="hidden" name="emailchkYn" id="emailchkYn" value="" />

							<input type="hidden" name="email" id="email" value="" />
							<input type="hidden" name="accountCarInfoVO.carCode" id="carCode" value="" />
							<input type="hidden" name="accountCarInfoVO.caryear" id="carYearInfo" value="" />
							<input type="hidden" name="accountCarInfoVO.model" id="modelInfo" value="" />
							<input type="hidden" name="mobileCertYn" id="mobileCertYn"  value="" />

							<table width="100%" summary="" cellpadding="0" cellspacing="0">
								<colgroup>
									<col width="140" />
									<col width="850" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="comp_name">이름</label> <span class="warning">*</span></th>

										<td><input type="text" id="firstName" name="firstName" placeholder="이름" class="inpText" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">생년월일</label> <span class="warning">*</span></th>
										<td><input type="text" name="birth" id="birth" placeholder="생년월일" value="" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_id">ID</label> <span class="warning">*</span></th>
										<td><input type="text" id="mbrId" name="mbrId" placeholder="회원아이디" class="inpText" class="required" onchange="fieldservId()"/> <a class="leftmag" onClick="getIdChk();"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="중복확인" /></a></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_id">닉네임</label> <span class="warning">*</span></th>
										<td><input type="text" id="nickName" name="nickName" placeholder="회원닉네임" class="inpText" class="required" onchange="fieldservNickName()"/> <a class="leftmag" onClick="getNickChk();"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="중복확인" /></a></td>
									</tr>

 									<tr>
 										<th scope="row"><label for="comp_id">휴대폰번호인증</label> <span class="warning">*</span></th>
 										<td><input type="text" id="mobile" name="mobile" class="inpText" placeholder="(-없이)입력" class="required" onChange="fieldserv('mobile');"/> <a class="leftmag" ><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증번호발송" onClick="getCert();"/></a></td>
 									</tr>
 									<tr>
 										<th scope="row"><label for="comp_id">인증번호입력</label> <span class="warning">*</span></th>
 										<td><input type="text" name="certification" id="certification" placeholder="인증번호입력" class="inpText" /> <a href="#" class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증하기" onClick="getCertResult()"/></a></td>
 									</tr>

									<tr>
										<th scope="row"><label for="comp_pw">패스워드</label> <span class="warning">*</span></th>
										<td><input type="password" id="pwd" name="pwd" placeholder="영,숫자 조합 8자리 이상" id="comp_pw" class="inpText" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_pw">패스워드확인</label> <span class="warning">*</span></th>
										<td><input type="password" id="pwdchk" name="pwdchk" class="inpText" /></td>
									</tr>

									<tr class="email_bx">
										<th scope="row"><label for="ceo_email">이메일 </label> <span class="warning">*</span></th>
										<td><input type="text" id="email1" name="email1" title="이메일 아이디를 작성하세요." /> @ <input type="text" id="email2" name="email2" title="이메일 계정을 작성하세요." /> <select title="이메일 계정을 선택하세요." id="email3" name="email3" onchange="emailserv(this.value);">
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
											<p>차량 정보를 정확히 입력하면 정확한 견적을 받을 수 있습니다.</p> <select id="brand" name="accountCarInfoVO.brand" title="선택하세요" onchange="getCar('model', this.value)">
												<option value="">제조사 선택</option>
										</select> <br> <select id="model" name="modelSelect" title="선택하세요" onchange="getCar('years', this.value)">
												<option value="">모델명 선택</option>
										</select> <br> <select id="caryear" name="caryearSelect" title="선택하세요" onchange="getCarCode(this.value)">
												<option value="">연식 선택</option>
										</select> <br> <select id="mission" name="accountCarInfoVO.mission" title="선택하세요">
												<option value="">색상 선택</option>
										</select> <br> <input type="text" id="carIdentNumber" name="accountCarInfoVO.carIdentNumber" class="inpText" placeholder="차대번호입력" /> <br> <input type="text" id="carNumber" name="accountCarInfoVO.carNumber" placeholder="차량번호입력" /> <br> <input type="text" id="distance" name="accountCarInfoVO.distance" class="inpText" placeholder="주행거리입력" />Km
										</td>
									</tr>

								</tbody>
							</table>
						</fieldset>
					</div>
					<!--//가맹점 정보-->
					<br /> <br />
					<div class="agree_wrap">

						<div class="agreement">
							<h3 class="dep2_tit">이용약관동의</h3>
							<div class="bx">
								<strong>제1장총칙</strong> (주)디에우로파의 PG서비스 홈페이지(이하 ‘홈페이지’라 함)는 (주)디에우로파에서 운영하는 인터넷 전자상거래 결제 전문 사이트입니다. 홈페이지에 회원으로 가입하시는 분들은 반드시 기업고객(법인/개인사업자) 회원이어야 하며, 가입하신 가맹점은 홈페이지에서 제공하는 정보 및 기능을 이용하실 수 있습니다. 약관에 동의함을 선택하시면 이 약관에 동의하는 것으로 간주하며 회원 가입을 하실 수 있게 됩니다. <strong>제2장회원의 종류</strong> 홈페이지의 회원은 가맹점 가입신청서를 작성한 법인/개인 사업자(이하 통칭 회원)로 구성됩니다. 가. 회원은 가맹점가입을 한 법인/개인 사업자로서 홈페이지의 서비스를 사용할 수 있습니다. 나. 가맹점가입을 한 법인/개인 사업자가 홈페이지에서 회원 가입을 한 후 (주)디에우로파의 승인 여부 절차에 따라 회원의 정식 자격을 취득할 수 있습니다. 다. 회원의 정식 자격을 취득한 경우,
								홈페이지에서 제공하는 기능을 사용 하실 수 있습니다. <strong>제3장회원 정보관리</strong> 회원 가입 시 작성되는 모든 회원 정보들은 홈페이지의 서비스 제공에 필요한 경우를 제외하고 다른 목적으로 사용되지 않습니다. 허위정보를 기재 하였을 경우 발생하는 불이익은 책임지지 않으며, 홈페이지의 서비스 제한 조치를 받을 수 있습니다. 또한, 회원 정보는 언제든지 수정이 가능하지 만, ID, 사업자 등록번호 등 고유의 정보는 변경이 불가능하므로 작성시 주의해야 합니다. <strong>제4장서비스</strong> 가. 홈페이지의 회원은 다양한 서비스를 이용할 수 있습니다. 나. 홈페이지의 서비스를 받기 위해서는 사용자 로그인을 해야 합니다. 다. 홈페이지의 서비스는 지속적으로 추가 제공될 것이며, 보다 나은 서비스를 위해 서비스의 내용을 변경 하거나 시스템의 문제로 인해 서비스가 중단 될 수 있습니다. 라. 서비스가 변경되거나 중단되는 경우 회원에게 홈페이지의
								공지를 통해 알려드리겠습니다. <strong>제5장이용거부</strong> (주)디에우로파는 다음 각 호에 해당하는 이용계약 신청에 대하여는 이를 승낙하지 아니합니다. 가. 다른 사람의 명의를 도용하여 신청하였을 때 나. 본인의 실명으로 신청하지 않았을 때 다. 이용 계약 신청서의 내용을 허위로 기재하였을 때 라. 사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청하였을 때 <strong>제6장ID와 비밀번호</strong> 가. ID와 비밀번호에 관한 모든 관리책임은 이용자에게 있습니다. 이용자에게 부여된 ID 및 비밀번호의 관리 소홀, 부정사용에 의하여 발생하는 모든 결과에 대한 책임은 이용자에게 있습니다. 자신의 ID가 부정하게 사용된 경우 이용자는 반드시 홈페이지의 담당자에게 전화(02-6257-3000)나 이메일(ktreesoftware@gmail.com)로 그 사실을 통보해야 합니다. 나. 비밀번호는 다음의 사항을 준수하여 신청하여야 합니다. 이를
								준수하여 신청하여야 회원가입을 하실 수 있습니다. - 5자 이상으로 설정하여야 하며, 반드시 특수문자 (예:!,@,#,$,%,^,&,*등)를 포함하지 말아야 합니다. - ID와 동일하지 않아야 합니다. <strong>제7장홈페이지의 사용관리</strong> 회원이 홈페이지의 기능을 부정적 목적으로 사용할 경우, (주)디에우로파 회원의 홈페이지 사용을 금지 할 수 있습니다. 가. 공공질서 및 미풍양속에 위반되는 내용인 경우나 범죄적 행위에 부합된다고 인정되는 내용인 경우 다. 타인의 명의 도용 등 기타 관계 법령이나 (주)디에우로파에서 정한 규정에 위배되는 내용인 경우 <strong>제8장약관의 수정</strong> (주)디에우로파는 본 약관을 변경할 수 있으며, 변경된 약관은 서비스 화면에 게재하거나 기타 다른 방법으로 이용자에게 공지함으로써 효력이 발생합니다. <strong>제9장약관 외 준칙</strong> 이 약관에 명시되지 않은 사항은 전자금융거래법,
								전기통신기본법, 전기통신사업법 및 기타 관련법령의 규정에 의합니다. 이 약관은 2013년 9월 1일 부터 시행합니다.
							</div>
							<div class="check">
								<input name="check1" type="radio" value="1" id="check1_1" class="input_radio" /> <label for="check1">동의합니다.</label> <input name="check1" type="radio" value="2" id="check1_2" class="input_radio" /> <label for="check1">동의하지 않습니다. </label>
							</div>
						</div>
						<!--//서비스이용약관-->

						<!--개인정보수집 및 이용에 대한 안내-->
						<div class="information">
							<h3 class="dep2_tit">개인정보 수집 및 이용안내</h3>
							<div class="bx">
								(주)디에우로파(이하 ‘회사’라 함)는 귀하의 온라인 결제와 관련된 아래의 신용정보를 취득함에 있어 다음과 같이 귀하의 동의를 구하고자 합니다. 아래 내용을 확인하신 후 동의 여부를 선택하여 주시기 바랍니다. 회사가 귀하로부터 취득한 아래 신용정보는 신용정보의 이용 및 보호에 관한 법률 제23조 및 정보통신망 이용촉진 및 정보보호 등에 관한 법률 제22조의 규정에 따라 동의를 얻어야 하는 정보입니다. <strong>1. 개인정보수집목적</strong> 회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다. 가. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산. 구매 및 요금 결제, 금융거래 본인 인증 및 금융 서비스 나. 회원제 서비스 이용 및 제한적 본인 확인제에 따른 본인확인, 개인식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입의사 확인, 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달 <strong>2.
									개인정보수집항목</strong> 회사는 회원가입, 상담, 서비스 신청 등을 위해 아래와 같은 개인정보를 수집하고 있습니다. 가. 수집항목 : 이름, 로그인ID, 비밀번호, 휴대전화번호, 이메일, 회사명, 부서, 회사전화번호, 회사주소, 사업자등록번호 나. 서비스 이용과정에서 다음과 같은 정보들이 자동으로 생성되어 수집될 수 있습니다. - IP Address, 서비스 이용 일시, 서비스 이용 기록, 불량 이용 기록 다. 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다. - 신용카드 : 가맹점명, 가맹점분류, 결제상품, 결제금액 등 라. 개인정보 수집방법 : 홈페이지(회원가입) 또는 회사의 홈페이지 서비스 이용 <strong>3. 개인정보 보유 및 기간</strong> 홈페이지의 서비스를 이용하는 개인정보 및 홈페이지 서비스를 이용하며 발생하는 정보는 회사가 보관한다. 단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한
								기간 동안 회원정보 및 홈페이지 서비스 이용 시 발생한 정보를 보관합니다. - 전자금융거래기록의 생성 및 보존 : 5년 (전자금융거래법) - 대금결제 및 재화 등의 공급에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률) - 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 (전자상거래등에서의 소비자보호에 관한 법률) - 계약 또는 청약철회 등에 관한 기록 : 5년 (전자상거래등에서의 소비자 보호에 관한 법률)<br /> 본인은 귀사가 본인에 관한 정보 제공하는데 동의합니다.
							</div>
							<div class="check">
								<input name="check2" type="radio" value="" id="check2" class="input_radio" /> <label for="check2">동의합니다.</label> <input name="check2" type="radio" value="" id="check2" class="input_radio" /> <label for="check2">동의하지 않습니다. </label>
							</div>
						</div>
						<div class="information">
							<h3 class="dep2_tit">쿠폰 서비스 약관</h3>
							<div class="bx">
								(주)디에우로파(이하 ‘회사’라 함)는 귀하의 온라인 결제와 관련된 아래의 신용정보를 취득함에 있어 다음과 같이 귀하의 동의를 구하고자 합니다. 아래 내용을 확인하신 후 동의 여부를 선택하여 주시기 바랍니다. 회사가 귀하로부터 취득한 아래 신용정보는 신용정보의 이용 및 보호에 관한 법률 제23조 및 정보통신망 이용촉진 및 정보보호 등에 관한 법률 제22조의 규정에 따라 동의를 얻어야 하는 정보입니다. <strong>1. 개인정보수집목적</strong> 회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다. 가. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산. 구매 및 요금 결제, 금융거래 본인 인증 및 금융 서비스 나. 회원제 서비스 이용 및 제한적 본인 확인제에 따른 본인확인, 개인식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입의사 확인, 분쟁 조정을 위한 기록보존, 불만처리 등 민원처리, 고지사항 전달 <strong>2.
									개인정보수집항목</strong> 회사는 회원가입, 상담, 서비스 신청 등을 위해 아래와 같은 개인정보를 수집하고 있습니다. 가. 수집항목 : 이름, 로그인ID, 비밀번호, 휴대전화번호, 이메일, 회사명, 부서, 회사전화번호, 회사주소, 사업자등록번호 나. 서비스 이용과정에서 다음과 같은 정보들이 자동으로 생성되어 수집될 수 있습니다. - IP Address, 서비스 이용 일시, 서비스 이용 기록, 불량 이용 기록 다. 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다. - 신용카드 : 가맹점명, 가맹점분류, 결제상품, 결제금액 등 라. 개인정보 수집방법 : 홈페이지(회원가입) 또는 회사의 홈페이지 서비스 이용 <strong>3. 개인정보 보유 및 기간</strong> 홈페이지의 서비스를 이용하는 개인정보 및 홈페이지 서비스를 이용하며 발생하는 정보는 회사가 보관한다. 단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한
								기간 동안 회원정보 및 홈페이지 서비스 이용 시 발생한 정보를 보관합니다. - 전자금융거래기록의 생성 및 보존 : 5년 (전자금융거래법) - 대금결제 및 재화 등의 공급에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률) - 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 (전자상거래등에서의 소비자보호에 관한 법률) - 계약 또는 청약철회 등에 관한 기록 : 5년 (전자상거래등에서의 소비자 보호에 관한 법률)<br /> 본인은 귀사가 본인에 관한 정보 제공하는데 동의합니다.
							</div>
							<div class="check">
								<input name="check3" type="radio" value="" id="check3" class="input_radio" /> <label for="check2">동의합니다.</label> <input name="check3" type="radio" value="" id="check3" class="input_radio" /> <label for="check2">동의하지 않습니다. </label>
							</div>
						</div>

						<div class="bt" style="height: 66px;">
							<img id="submitButton" src="/join_form_img/sub/bt_ok.png" alt="확인" /> <a href="/main/main.do"><img src="/join_form_img/sub/bt_no.png" alt="취소" /></a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>