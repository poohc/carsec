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
				if ($("#addr3 option").index($("#addr3 option:selected"))<0) {
					$("#addr3 option:eq(0)").attr("selected", "selected");
				}
				getAddr('gugun', $("#addr3 option:selected").val(), '${fn:split(accountFormVO.addr1,'-')[1]}');
				//getAddr('dong', $("#addr4 option:selected").val(), '${fn:split(accountFormVO.addr1,'-')[2]}');
			}
			if(param1=='gugun'){
				if ($("#addr4 option").index($("#addr4 option:selected"))<0) {
					$("#addr4 option:eq(0)").attr("selected", "selected");
				}
				getAddr('dong', $("#addr4 option:selected").val(), '${fn:split(accountFormVO.addr1,'-')[2]}');
			}
			if(param1=='dong'){
				if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
					$("#addr5 option:eq(0)").attr("selected", "selected");
				}
			}
		}
	});
}

function getAddr1(param1, param2, param3) {
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

$( document ).ready( function() {

	/* 핸드폰번호 표기 -삽입 */
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

	getAddr('sido', '', '${fn:split(accountFormVO.addr1,'-')[0]}');
})

function mobileserv(){
    $("#mobileCertYn").attr("value", "");
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
</script>
</head>
<body>

    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class=""><a href="/mbr/mypage/mypage.do">회원정보 변경</a></li>
                <li class="on"><a href="/mbr/mypage/mypageChangePwd.do">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
	<!-- contain -->
	<form name="accountForm" id="accountForm" method="post" class="accountForm" action="mypageModifyFormProc.do" enctype="multipart/form-data">
		<div id="container">
			<div class="join_wrap">
				<div class="bbs">
					<div class="join_fied">
						<fieldset>
							<h3 class="dep2_tit">회원정보 수정 - 메카닉회원</h3>
							<p class="joinFieldText">* 표시된 항목은 반드시 입력/선택 해야합니다.</p>
							<input type="hidden" name="mbrId" id="mbrId"  value="${accountFormVO.mbrId}" />
							<input type="hidden" name="idchkYn" id="idchkYn" class="idchkYn" value=""  />
							<input type="hidden" name="mobilechkYn" id="mobilechkYn" class="mobilechkYn" value=""/>
							<input type="hidden" name="emailchkYn" id="emailchkYn" class="emailchkYn" value="" />
							<input type="hidden" name="accountMechanicInfoVO.mechanicId" id="mechanicId" value="${accountFormVO.accountMechanicInfoVO.mechanicId}" />
							<input type="hidden" name="mobileCertYn" id="mobileCertYn"  value="" />
							<input type="hidden" name="mobileWrite" id="mobileWrite" value="${accountFormVO.mobile}" />
							<table width="100%" summary="" cellpadding="0" cellspacing="0">
								<colgroup>
									<col width="140" />
									<col width="850" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="comp_name">사업자명</label> <span class="warning">*</span></th>

										<td>${accountFormVO.firstName}</td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">사업자등록번호</label> <span class="warning">*</span></th>
										<td><input type="text" id="bizNumber" name="bizNumber" value="${accountFormVO.accountMechanicInfoVO.bizNumber}" class="inpText" placeholder="(-없이)입력" class="required"  /></td>
									</tr>
									<tr>
										<th scope="row"><label for="comp_num">ID</label> <span class="warning"></span></th>
										<td>${accountFormVO.mbrId}</td>
									</tr>

 									<tr>
 										<th scope="row"><label for="comp_num">휴대폰 번호</label> <span class="warning">*</span></th>
 										<td><p id="cc"></p></td>
 									</tr>
 									<tr>
 										<th scope="row"><label for="comp_id">휴대폰번호인증</label> <span class="warning">*</span></th>
 										<td><input type="text" id="mobile" name="mobile" class="inpText" placeholder="새로운휴대폰번호" class="required" onChange="mobileserv()"/> <a class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증번호발송" onClick="getCert();"/></a></td>
 									</tr>

 									<tr>
 										<th scope="row"><label for="comp_id">인증번호입력</label> <span class="warning">*</span></th>
 										<td><input type="text" name="certification" id="certification" placeholder="인증번호입력" class="inpText" /> <a href="#" class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증하기" onClick="getCertResult()"/></a></td>
 									</tr>

<!-- 									<tr> -->
<!-- 										<th scope="row"><label for="comp_num">휴대폰번호</label> <span class="warning">*</span></th> -->
<!-- 										<td><p id="cc"></p></td> -->
<!-- 									</tr> -->
									<tr>
										<th scope="row"><label for="ceo_pw">대표자명</label> <span class="warning">*</span></th>
										<td><input type="text" id="lastName" name="lastName" class="inpText" class="required" value="${accountFormVO.lastName}"/></td>
									</tr>
									<tr class="email_bx">
										<th scope="row"><label for="ceo_email">대표 이메일 주소 변경 </label> <span class="warning">*</span></th>
										<td>
<%-- 										<p>현재 이메일 주소 :${accountFormVO.email}</p> --%>
										<input type="hidden" name="email" id="email"  value="" />
										 <input type="text" id="email1" name="email1" title="이메일 아이디를 작성하세요." value="${fn:split(accountFormVO.email,'@')[0]}" /> @
										 <input type="text" id="email2" name="email2" title="이메일 계정을 작성하세요." value="${fn:split(accountFormVO.email,'@')[1]}" />
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
										<td>

<%-- 										<p>현재 전화번호 :${accountFormVO.tel}</p> --%>

										<input type="hidden" name="tel" id="tel"  value="" />
										<select id="tel1" name="tel1" title="전화번호앞자리">
												<option value="">선택하세요</option>
												<option value="02" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='02'}"> selected</c:if> >02</option>
							                     <option value="031" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='031'}"> selected</c:if>>031</option>
							                     <option value="032" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='032'}"> selected</c:if>>032</option>
							                     <option value="033" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='033'}"> selected</c:if>>033</option>
							                     <option value="041" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='041'}"> selected</c:if>>041</option>
							                     <option value="042" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='042'}"> selected</c:if>>042</option>
							                     <option value="043" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='043'}"> selected</c:if>>043</option>
							                     <option value="051" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='051'}"> selected</c:if>>051</option>
							                     <option value="052" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='052'}"> selected</c:if>>052</option>
							                     <option value="053" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='053'}"> selected</c:if>>053</option>
							                     <option value="054" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='054'}"> selected</c:if>>054</option>
							                     <option value="061" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='061'}"> selected</c:if>>061</option>
							                     <option value="062" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='062'}"> selected</c:if>>062</option>
							                     <option value="063" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='063'}"> selected</c:if>>063</option>
							                     <option value="064" <c:if test="${fn:split(accountFormVO.tel,'-')[0]=='064'}"> selected</c:if>>064</option>

										</select> - <input type="text" size="12" id="tel2" name="tel2"  value="${fn:split(accountFormVO.tel,'-')[1]}" title="전화번호 가운데자리를 입력하세요." /> - <input type="text" size="12" id="tel3" name="tel3"  value="${fn:split(accountFormVO.tel,'-')[2]}" title="전화번호 뒷자리를 입력하세요." /></td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업장 주소</label> <span class="warning">*</span></th>
										<td><select id="addr3" name="addr3" title="특/광/도" onchange="getAddr('gugun', this.value, '')">
												<option value="">선택(특/광/도)</option>
										</select><select id="addr4" name="addr4" title="시/구/군" onchange="getAddr('dong', this.value, '')">
												<option value="">선택(시/구/군)</option>
										</select><select id="addr5" name="addr5" title="동/면/리" onchange="getzipcode(this.value)">
												<option value="">선택(동/면/리)</option>
										</select><input type="hidden" name="addr1" id="addr1"  value="" /><input type="hidden" name="zipcode" id="zipcode" />
											<p>
												<input type="text" name="addr2" id="addr2" size="70" value="${accountFormVO.addr2}" title="주소를 입력하세요." alt="adress" />
											</p></td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업자등록증 첨부</label></th>
										<td>
										<c:if test="${not empty accountFormVO.accountMechanicInfoVO.bizRegFile}">
										<img src="/media/${accountFormVO.accountMechanicInfoVO.bizRegFile}.image" width="180" />
										<br /><br />
										</c:if>
										<input type="file" name="file1" id="bizRegFile"  size="12" />
											<p />
											<br> 이미지가 없을 경우 FAX : 031 - 777 -7777로 보내주시면 승인해 드립니다.</td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">사업장 사진첨부</label></th>
										<td>
										<c:if test="${not empty accountFormVO.accountMechanicInfoVO.bizPhoto}">
										<img src="/media/${accountFormVO.accountMechanicInfoVO.bizPhoto}.image" width="180" />
										<br /><br />
										</c:if>
										<input type="file" name="file2" id="bizPhoto" size="12" /><br />
											<p />
											<br> 사진이 없으면 기본사진으로 대체합니다.</td>
									</tr>
									<tr class="adress_bx">
										<th scope="row"><label for="comp_adress">서비스품목</label></th>
										<td><select id="varFiled1" name="accountMechanicInfoVO.serviceItem1" title="선택하세요">
												<option value="">서비스 품목 1</option>
												<option value="1급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='1급공업사'}"> selected</c:if>>1급공업사</option>
												<option value="2급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='2급공업사'}"> selected</c:if>>2급공업사</option>
												<option value="기본 경정비"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
												<option value="판금"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='판금'}"> selected</c:if>>판금</option>
												<option value="도장"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='도장'}"> selected</c:if>>도장</option>
												<option value="덴트"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='덴트'}"> selected</c:if>>덴트</option>
												<option value="썬팅"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='썬팅'}"> selected</c:if>>썬팅</option>
												<option value="세차"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='세차'}"> selected</c:if>>세차</option>
												<option value="타이어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='타이어'}"> selected</c:if>>타이어</option>
												<option value="카오디오"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='카오디오'}"> selected</c:if>>카오디오</option>
												<option value="블랙박스"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='블랙박스'}"> selected</c:if>>블랙박스</option>
												<option value="네비게이션"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='네비게이션'}"> selected</c:if>>네비게이션</option>
												<option value="씨트 인테리어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
												<option value="튜닝"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem1=='튜닝'}"> selected</c:if>>튜닝</option>
										</select>
											<p />
											<br><select id="varFiled2" name="accountMechanicInfoVO.serviceItem2" title="선택하세요">
												<option value="">서비스 품목 2</option>
												<option value="1급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='1급공업사'}"> selected</c:if>>1급공업사</option>
												<option value="2급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='2급공업사'}"> selected</c:if>>2급공업사</option>
												<option value="기본 경정비"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
												<option value="판금"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='판금'}"> selected</c:if>>판금</option>
												<option value="도장"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='도장'}"> selected</c:if>>도장</option>
												<option value="덴트"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='덴트'}"> selected</c:if>>덴트</option>
												<option value="썬팅"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='썬팅'}"> selected</c:if>>썬팅</option>
												<option value="세차"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='세차'}"> selected</c:if>>세차</option>
												<option value="타이어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='타이어'}"> selected</c:if>>타이어</option>
												<option value="카오디오"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='카오디오'}"> selected</c:if>>카오디오</option>
												<option value="블랙박스"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='블랙박스'}"> selected</c:if>>블랙박스</option>
												<option value="네비게이션"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='네비게이션'}"> selected</c:if>>네비게이션</option>
												<option value="씨트 인테리어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
												<option value="튜닝"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem2=='튜닝'}"> selected</c:if>>튜닝</option>
										</select>
											<p />
											<br><select id="varFiled3" name="accountMechanicInfoVO.serviceItem3" title="선택하세요">
												<option value="">서비스 품목 3</option>
												<option value="1급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='1급공업사'}"> selected</c:if>>1급공업사</option>
												<option value="2급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='2급공업사'}"> selected</c:if>>2급공업사</option>
												<option value="기본 경정비"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
												<option value="판금"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='판금'}"> selected</c:if>>판금</option>
												<option value="도장"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='도장'}"> selected</c:if>>도장</option>
												<option value="덴트"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='덴트'}"> selected</c:if>>덴트</option>
												<option value="썬팅"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='썬팅'}"> selected</c:if>>썬팅</option>
												<option value="세차"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='세차'}"> selected</c:if>>세차</option>
												<option value="타이어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='타이어'}"> selected</c:if>>타이어</option>
												<option value="카오디오"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='카오디오'}"> selected</c:if>>카오디오</option>
												<option value="블랙박스"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='블랙박스'}"> selected</c:if>>블랙박스</option>
												<option value="네비게이션"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='네비게이션'}"> selected</c:if>>네비게이션</option>
												<option value="씨트 인테리어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
												<option value="튜닝"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem3=='튜닝'}"> selected</c:if>>튜닝</option>
										</select>
											<p />
											<br><select id="varFiled4" name="accountMechanicInfoVO.serviceItem4" title="선택하세요">
												<option value="">서비스 품목 4</option>
												<option value="1급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='1급공업사'}"> selected</c:if>>1급공업사</option>
												<option value="2급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='2급공업사'}"> selected</c:if>>2급공업사</option>
												<option value="기본 경정비"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
												<option value="판금"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='판금'}"> selected</c:if>>판금</option>
												<option value="도장"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='도장'}"> selected</c:if>>도장</option>
												<option value="덴트"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='덴트'}"> selected</c:if>>덴트</option>
												<option value="썬팅"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='썬팅'}"> selected</c:if>>썬팅</option>
												<option value="세차"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='세차'}"> selected</c:if>>세차</option>
												<option value="타이어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='타이어'}"> selected</c:if>>타이어</option>
												<option value="카오디오"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='카오디오'}"> selected</c:if>>카오디오</option>
												<option value="블랙박스"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='블랙박스'}"> selected</c:if>>블랙박스</option>
												<option value="네비게이션"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='네비게이션'}"> selected</c:if>>네비게이션</option>
												<option value="씨트 인테리어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
												<option value="튜닝"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem4=='튜닝'}"> selected</c:if>>튜닝</option>
										</select>
											<p />
											<br><select id="varFiled5" name="accountMechanicInfoVO.serviceItem5" title="선택하세요">
												<option value="">서비스 품목 5</option>
												<option value="1급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='1급공업사'}"> selected</c:if>>1급공업사</option>
												<option value="2급공업사"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='2급공업사'}"> selected</c:if>>2급공업사</option>
												<option value="기본 경정비"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='기본 경정비'}"> selected</c:if>>기본 경정비</option>
												<option value="판금"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='판금'}"> selected</c:if>>판금</option>
												<option value="도장"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='도장'}"> selected</c:if>>도장</option>
												<option value="덴트"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='덴트'}"> selected</c:if>>덴트</option>
												<option value="썬팅"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='썬팅'}"> selected</c:if>>썬팅</option>
												<option value="세차"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='세차'}"> selected</c:if>>세차</option>
												<option value="타이어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='타이어'}"> selected</c:if>>타이어</option>
												<option value="카오디오"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='카오디오'}"> selected</c:if>>카오디오</option>
												<option value="블랙박스"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='블랙박스'}"> selected</c:if>>블랙박스</option>
												<option value="네비게이션"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='네비게이션'}"> selected</c:if>>네비게이션</option>
												<option value="씨트 인테리어"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='씨트 인테리어'}"> selected</c:if>>씨트 인테리어</option>
												<option value="튜닝"<c:if test="${accountFormVO.accountMechanicInfoVO.serviceItem5=='튜닝'}"> selected</c:if>>튜닝</option>
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