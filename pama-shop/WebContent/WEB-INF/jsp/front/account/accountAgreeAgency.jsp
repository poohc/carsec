<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>검진</title>
<link rel="stylesheet" href="/common/css/front/common1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/custom1.css" type="text/css" />
<link rel="stylesheet" href="/common/jquery-ui-1.11.4.custom/jquery-ui.css">
<script src="/common/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script src="/common/js/jquery.validate.js"  type="text/javascript" charset="UTF-8"></script>
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
    		bizNumber: {
    			required: true
    		},
    		mbrId: {
    			required: true
    		},
    		mobile: {
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
    		lastName: {
    			required: true
    		},
    		email1: {
    			required: true
    		},
    		email2: {
    			required: true
    		},
    		tel2: {
    			required: true
    		},
    		tel3: {
    			required: true
    		},
    		addr2: {
    			required: true
    		}
    	},
    	messages:{


    		firstName :{
    			required:"사업자명을 입력하세요."
    		},
    		bizNumber :{
    			required:"사업자등록번호를 입력하세요."
    		},
    		mbrId :{
    			required: "아이디를 입력해주세요.",
    			alphanumeric: "영문과 숫자만 사용가능합니다."
    		},
    		mobile :{
    			required:"휴대폰번호를 입력하세요."
    		},
    		pwd :{
    			required:"패스워드를 입력하세요.",
    			alphanumeric: "영문과 숫자만 사용가능합니다."
    		},
    		pwdchk :{
    			required:"패스워드확인을 입력하세요.",
    			equalTo: "비밀번호를 잘못 입력하셨습니다."
    		},
    		lastName :{
    			required:"대표자명을 입력하세요."
    		},
    		email1 :{
    			required:"이메일 아이디를 입력하세요."
    		},
    		email2 :{
    			required:" 이메일 계정을 입력하세요."
    		},
    		tel2 :{
    			required:"사업장 전화번호를  입력하세요."
    		},
    		tel3 :{
    			required:"사업장 전화번호를  입력하세요."
    		},
    		addr2 :{
    			required:"사업장주소를  입력하세요."
    		}

    	},
    	submitHandler: function(form) {

    		var isSubmit=true;
    		var email=$("#email1").val()+"@"+$("#email2").val();
    		$("#email").attr("value",email);

    		var tel=$("#tel1").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val();
    		$("#tel").attr("value",tel);

    		var addr1=$("#addr3 option:selected").text()+"-"+$("#addr4 option:selected").text()+"-"+$("#addr5 option:selected").text();
    		$("#addr1").attr("value",addr1);

    		if($("#zipcode").val()==""){
    			alert("주소 선택해 해주세요.");
    			isSubmit=false;
    			return;
    		}

    		if($("#idchkYn").val()==""){
    			alert("아이디중복체크를 해주세요.");
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

    	    if(isSubmit){
    	    	form.submit();
    	    }
    	}
    });

});

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

function getAddr(param1, param2) {
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
					$('#addr3')
			          .append($('<option>', { value : this.sido })
			          .text(this.sido));
				}
				if(param1=='gugun'){
					$('#addr4')
			          .append($('<option>', { value : this.sido+"|"+this.gugun })
			          .text(this.gugun));
				}
				if(param1=='dong'){
					$('#addr5')
			          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
			          .text(this.dong));
				}
			});
		}
	});
}

function getAddr1(param1, param2) {
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
	var statusTypeChangeUrl = '/mbr/accountAddrSearch.do?searchType=' + param1 + '&sido=' + sido + '&gugun=' + gugun + '&dong=' + dong;
	$.getJSON(statusTypeChangeUrl, function(data) {
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
				$('#addr3')
		          .append($('<option>', { value : this.sido })
		          .text(this.sido));
			}
			if(param1=='gugun'){
				$('#addr4')
		          .append($('<option>', { value : this.sido+"|"+this.gugun })
		          .text(this.gugun));
			}
			if(param1=='dong'){
				$('#addr5')
		          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
		          .text(this.dong));
			}
		});
	});
}

function getzipcode(code) {
	var zipcode = code.split("|")[0];
	$("#zipcode").val(zipcode);
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
	if (el="mobile") $("#mobileCertYn").val("");
}

function fieldservMobile(){
	$("#mobileCertYn").val("");
}

$( document ).ready( function() {
	getAddr('sido', '');
})

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
	<form name="accountForm" id="accountForm" method="post" class="accountForm" action="accountAgreeAgencyProc.do" enctype="multipart/form-data">
		<div id="container">
			<div class="join_wrap">
				<div class="bbs">
					<div class="join_fied">
						<fieldset>
							<h3 class="dep2_tit">메카닉 회원가입</h3>
							<p class="joinFieldText">* 표시된 항목은 반드시 입력/선택 해야합니다.</p>
							<input type="hidden" name="idchkYn" id="idchkYn" class="idchkYn" value=""  />
							<input type="hidden" name="mobilechkYn" id="mobilechkYn" class="mobilechkYn" value=""/>
							<input type="hidden" name="emailchkYn" id="emailchkYn" class="emailchkYn" value="" />
							<input type="hidden" name="mobileCertYn" id="mobileCertYn"  value="" />
							<table width="100%" summary="" cellpadding="0" cellspacing="0">
								<colgroup>
									<col width="140" />
									<col width="850" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="comp_name">사업자명</label> <span class="warning">*</span></th>

										<td><input type="text" id="firstName" name="firstName" class="inpText" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">사업자등록번호</label> <span class="warning">*</span></th>
										<td><input type="text" id="bizNumber" name="bizNumber" class="inpText" placeholder="(-없이)입력" class="required"  /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_id">ID</label> <span class="warning">*</span></th>
										<td><input type="text" id="mbrId" name="mbrId" class="inpText" class="required" onChange="fieldservId()"/> <a href="#" class="leftmag" onClick="getIdChk();" ><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="중복확인" /></a></td>
									</tr>

 									<tr>
 										<th scope="row"><label for="comp_id">휴대폰번호</label> <span class="warning">*</span></th>
 										<td><input type="text" id="mobile" name="mobile" class="inpText" placeholder="(-없이)입력" class="required" onChange="fieldserv('mobile')" /></td>
 									</tr>

									<tr>
										<th scope="row"><label for="comp_pw">패스워드</label> <span class="warning">*</span></th>
										<td><input type="password" id="pwd" name="pwd" class="inpText" class="required"  /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_pw">패스워드확인</label> <span class="warning">*</span></th>
										<td><input type="password" id="pwdchk" name="pwdchk" class="inpText" class="required"  /></td>
									</tr>
									<tr>
										<th scope="row"><label for="ceo_pw">대표자명</label> <span class="warning">*</span></th>
										<td><input type="text" id="lastName" name="lastName" class="inpText" class="required" /></td>
									</tr>
									<tr class="email_bx">
										<th scope="row"><label for="ceo_email">대표 이메일 </label> <span class="warning">*</span></th>
										<td><input type="hidden" name="email" id="email"  value="" />
										 <input type="text" id="email1" name="email1" title="이메일 아이디를 작성하세요." /> @
										 <input type="text" id="email2" name="email2" title="이메일 계정을 작성하세요." />
										<select title="이메일 계정을 선택하세요." id="email3" name="email3" onchange="emailserv(this.value);">
												<option value="">직접입력</option>
												<option value="naver.com">네이버</option>
												<option value="hanmail.net">다음</option>
												<option value="nate.com">네이트</option>
												<option value="gmail.com">구글</option>
										</select></td>
									</tr>
									<tr class="phone">
										<th scope="row"><label for="comp_num1">사업장 전화번호</label> <span class="warning">*</span></th>
										<td><input type="hidden" name="tel" id="tel"  value="" />
										<select id="tel1" name="tel1" title="전화번호앞자리">
												<option value="">선택하세요</option>
												 <option value="02">02</option>
							                     <option value="031">031</option>
							                     <option value="032">032</option>
							                     <option value="033">033</option>
							                     <option value="041">041</option>
							                     <option value="042">042</option>
							                     <option value="043">043</option>
							                     <option value="051">051</option>
							                     <option value="052">052</option>
							                     <option value="053">053</option>
							                     <option value="054">054</option>
							                     <option value="061">061</option>
							                     <option value="062">062</option>
							                     <option value="063">063</option>
							                     <option value="064">064</option>
										</select> - <input type="text" size="12" id="tel2" name="tel2"  value="" title="전화번호 가운데자리를 입력하세요." /> - <input type="text" size="12" id="tel3" name="tel3"  value="" title="전화번호 뒷자리를 입력하세요." /></td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업장 주소</label> <span class="warning">*</span></th>
										<td><select id="addr3" name="addr3" title="전화번호앞자리" onchange="getAddr('gugun',this.value)">
												<option value="">선택(특/광/도)</option>
										</select><select id="addr4" name="addr4" title="전화번호앞자리" onchange="getAddr('dong',this.value)">
												<option value="">선택(시/구/군)</option>
										</select><select id="addr5" name="addr5" title="전화번호앞자리" onchange="getzipcode(this.value)">
												<option value="">선택(동/면/리)</option>
										</select><input type="hidden" name="addr1" id="addr1"  value="" /><input type="hidden" name="zipcode" id="zipcode" />
											<p>
												<input type="text" name="addr2" id="addr2" size="70" value="" title="주소를 입력하세요." alt="adress" />
											</p></td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업자등록증 첨부</label></th>
										<td><input type="file" name="file1" id="bizRegFile"  size="12" />
											<p />
											<br> 이미지가 없을 경우 FAX : 031 - 777 -7777로 보내주시면 승인해 드립니다.</td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업장 사진첨부</label></th>
										<td><input type="file" name="file2" id="bizPhoto" size="12" />
											<p />
											<br> 사진이 없으면 기본사진으로 대체합니다.</td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">서비스품목</label></th>
										<td><select id="varFiled1" name="accountMechanicInfoVO.serviceItem1" title="선택하세요">
												<option value="">서비스 품목 1</option>
												<option value="1급공업사">1급공업사</option>
												<option value="2급공업사">2급공업사</option>
												<option value="기본 경정비">기본 경정비</option>
												<option value="판금">판금</option>
												<option value="도장">도장</option>
												<option value="덴트">덴트</option>
												<option value="썬팅">썬팅</option>
												<option value="세차">세차</option>
												<option value="타이어">타이어</option>
												<option value="카오디오">카오디오</option>
												<option value="블랙박스">블랙박스</option>
												<option value="네비게이션">네비게이션</option>
												<option value="씨트 인테리어">씨트 인테리어</option>
												<option value="튜닝">튜닝</option>
										</select>
											<p />
											<br><select id="varFiled2" name="accountMechanicInfoVO.serviceItem2" title="선택하세요">
												<option value="">서비스 품목 2</option>
												<option value="1급공업사">1급공업사</option>
												<option value="2급공업사">2급공업사</option>
												<option value="기본 경정비">기본 경정비</option>
												<option value="판금">판금</option>
												<option value="도장">도장</option>
												<option value="덴트">덴트</option>
												<option value="썬팅">썬팅</option>
												<option value="세차">세차</option>
												<option value="타이어">타이어</option>
												<option value="카오디오">카오디오</option>
												<option value="블랙박스">블랙박스</option>
												<option value="네비게이션">네비게이션</option>
												<option value="씨트 인테리어">씨트 인테리어</option>
												<option value="튜닝">튜닝</option>

										</select>
											<p />
											<br><select id="varFiled3" name="accountMechanicInfoVO.serviceItem3" title="선택하세요">
												<option value="">서비스 품목 3</option>
												<option value="1급공업사">1급공업사</option>
												<option value="2급공업사">2급공업사</option>
												<option value="기본 경정비">기본 경정비</option>
												<option value="판금">판금</option>
												<option value="도장">도장</option>
												<option value="덴트">덴트</option>
												<option value="썬팅">썬팅</option>
												<option value="세차">세차</option>
												<option value="타이어">타이어</option>
												<option value="카오디오">카오디오</option>
												<option value="블랙박스">블랙박스</option>
												<option value="네비게이션">네비게이션</option>
												<option value="씨트 인테리어">씨트 인테리어</option>
												<option value="튜닝">튜닝</option>

										</select>
											<p />
											<br><select id="varFiled4" name="accountMechanicInfoVO.serviceItem4" title="선택하세요">
												<option value="">서비스 품목 4</option>
												<option value="1급공업사">1급공업사</option>
												<option value="2급공업사">2급공업사</option>
												<option value="기본 경정비">기본 경정비</option>
												<option value="판금">판금</option>
												<option value="도장">도장</option>
												<option value="덴트">덴트</option>
												<option value="썬팅">썬팅</option>
												<option value="세차">세차</option>
												<option value="타이어">타이어</option>
												<option value="카오디오">카오디오</option>
												<option value="블랙박스">블랙박스</option>
												<option value="네비게이션">네비게이션</option>
												<option value="씨트 인테리어">씨트 인테리어</option>
												<option value="튜닝">튜닝</option>

										</select>
											<p />
											<br><select id="varFiled5" name="accountMechanicInfoVO.serviceItem5" title="선택하세요">
												<option value="">서비스 품목 5</option>
												<option value="1급공업사">1급공업사</option>
												<option value="2급공업사">2급공업사</option>
												<option value="기본 경정비">기본 경정비</option>
												<option value="판금">판금</option>
												<option value="도장">도장</option>
												<option value="덴트">덴트</option>
												<option value="썬팅">썬팅</option>
												<option value="세차">세차</option>
												<option value="타이어">타이어</option>
												<option value="카오디오">카오디오</option>
												<option value="블랙박스">블랙박스</option>
												<option value="네비게이션">네비게이션</option>
												<option value="씨트 인테리어">씨트 인테리어</option>
												<option value="튜닝">튜닝</option>

										</select></td>
									</tr>

								</tbody>
							</table>
						</fieldset>
					</div>
					<!--//가맹점 정보-->
					<p />
					</br>
					<p />
					</br>

					<div class="agree_wrap">
						<!--서비스이용약관-->
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
								<input name="check1" id="check1" type="radio" value="0" class="input_radio" /> <label for="check1">동의합니다.</label> <input name="check1" id="check1" type="radio" value="1" class="input_radio" /> <label for="check1">동의하지 않습니다. </label>
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
								<input name="check2" id="check2" type="radio" value="0" class="input_radio" /> <label for="check2">동의합니다.</label> <input name="check2" id="check2" type="radio" value="1" class="input_radio" /> <label for="check2">동의하지 않습니다. </label>
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
								<input name="check3" id="check3" type="radio" value="0" class="input_radio" /> <label for="check2">동의합니다.</label> <input name="check3" id="check3" type="radio" value="1" class="input_radio" /> <label for="check2">동의하지 않습니다. </label>
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