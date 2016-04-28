<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>일반회원가입</title>
<script src="/common/js/jquery-1.6.2.min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/common/js/jquery.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript" src="/common/js/jquery-1_5_5/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/join.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	var idchk = true;
	<c:if test="${empty accountFormVO}">
	var statusTypeChangeUrl = '/signup/accountIdChk.do';
	$.ajax({
		  dataType: "json",
		  url: statusTypeChangeUrl,
		  async: false,
		  data: 'mbrId='+f.mbrId.value,
		  success: function(data) {
		        if(data.mbrId != null){
		            alert("이미 등록된 아이디 입니다. 다른 아이디을 입력하세요.");
		            idchk = false;
		        }else{
		        	idchk = true;
		        }
		  }
	});
	</c:if>

	return idchk;

}

//-->
</script>
<script type="text/javascript">
<!--
function checkReset1(type){
    var form = document.accountForm;
    if(type == 'id'){
        form.idchkYn.value="";
        checkIdLabel.innerHTML="";
    }
}

function getIdChk() {
    var f = document.accountForm;
    var str = f.mbrId.value;
    var retVal = checkSpace( str );
    var isID = /^[a-z0-9_]{5,20}$/;

    if(f.mbrId.value=="") {
        alert("아이디를 입력하십시오.");
        f.mbrId.focus();
        return false;
    }

    if( retVal != "" ) {
        alert("아이디는 빈 공간 없이 연속된 영문 소문자와 숫자만 사용할 수 있습니다.");
        f.mbrId.focus();
    } else if( str.charAt(0) == '_') {
        alert("아이디의 첫문자는 '_'로 시작할수 없습니다.");
        f.mbrId.focus();
    } else if(f.mbrId.value.length < 5) {
        alert("아이디는 5자 이상입니다.");
        f.mbrId.focus();
    }else if(chkNonchar(f.mbrId.value)){
        alert("아이디에 특수문자는 입력할 수 없습니다.");
        f.mbrId.focus();
    }else if( !isID.test(str) ) {
        alert("아이디는 5~20자의 영문 소문자와 숫자,특수기호(_)만 사용할 수 있습니다.");
        f.mbrId.focus();
    }else {
        parm1 = f.mbrId.value;
        var statusTypeChangeUrl = '/signup/accountIdChk.do?mbrId='+parm1;
        $.getJSON(statusTypeChangeUrl,
         function(data) {
             if(data.mbrIdChk != null){
                 alert("이미 사용중인 아이디 입니다. 다른 아이디를 입력하세요.");
                 f.idchkYn.value = "";
             }else{
                 alert("사용 가능한 아이디 입니다.");
                 f.idchkYn.value = "Y";
             }
         });
     return true;
    }
}

function getNickNameChk() {
    var f = document.accountForm;

    if(f.nickname.value=="") {
        alert("별명을 입력하십시오.");
        f.nickname.focus();
        return false;
    }

    var statusTypeChangeUrl = '/signup/accountNickNameChk.do?nickname='+f.nickname.value;
    $.getJSON(statusTypeChangeUrl,
     function(data) {
        if(data.nickNameChk != null){
            alert("이미 등록된 별명 입니다. 다른 별명을 입력하세요.");
            f.nickNamechkYn.value = "";
        }else{
            alert("사용 가능한 별명 입니다.");
            f.nickNamechkYn.value = "Y";
        }
     });
    return true;
}

function getEmailChk() {
    var f = document.accountForm;

    if(f.email1.value=="") {
        alert("이메일을 입력하십시오.");
        f.email1.focus();
        return false;
    }

    if(f.email2.value=="") {
        alert("이메일을 입력하십시오.");
        f.email2.focus();
        return false;
    }

    f.email.value = f.email1.value + "@" + f.email2.value;

    var statusTypeChangeUrl = '/signup/accountEmailChk.do?email='+f.email.value;
    $.getJSON(statusTypeChangeUrl,
     function(data) {
        if(data.emailChk != null){
            alert("이미 등록된 이메일 입니다. 다른 이메일을 입력하세요.");
            f.emailchkYn.value = "";
        }else{
            alert("사용 가능한 이메일 입니다.");
            f.emailchkYn.value = "Y";
        }
     });
    return true;

}

function emailserv(value){
    var form = document.accountForm;

    form.email2.value = value;
    form.emailchkYn.value="";

}

function checkReset(type){
    var form = document.accountForm;
    if(type == 'id'){
        form.idchkYn.value="";
    }else if (type == 'email'){
        form.emailchkYn.value="";
    }else {
    	form.nickNamechkYn.value="";
    }
}
//-->
</script>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">아이디/비밀번호 설정</h1>
            <p class="explain">아이디와 숫자를 조합하여 8자리 이상 입력하여 주세요.</p>
            <form name="accountForm" id="accountForm" method="post" class="accountForm" action="accountJoinProc.do">
  				<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
  				<input type="hidden" name="idchkYn" id="idchkYn" class="idchkYn" value="${not empty accountFormVO?'Y':''}" class="required" />
  				<input type="hidden" name="nickNamechkYn" id="nickNamechkYn" class="nickNamechkYn" value="${not empty accountFormVO?'Y':''}" class="required" />
                <div class="member_join">
                    <fieldset class="phone_name">
                        <input type="hidden" id="mobile" name="mobile" value="${accountVO.mobile}" class="fir_inp m_t5" />
                        <input type="hidden" id="firstName" name="firstName" value="${accountVO.firstName}" class="fir_inp m_t5" />
                        <label for="mem_id">회원아이디</label>
                        <input type="text" id="mbrId" name="mbrId" placeholder="회원아이디" title="회원아이디" data-from="text" class="fir_inp m_t5" onChange="checkReset('id')" />
                        <button type="button" class="type2 top" data-btn="text" onClick="getIdChk();">중복조회</button>
                        <label for="nickname">별명</label>
                        <input type="text" id="nickname" name="nickname" placeholder="이름 입력 (2자이상)" class="m_t5" title="이름" data-from="text" onChange="checkReset('nickName')" />
                        <button type="button" class="type3" data-btn="text" onclick="getNickNameChk();">중복조회</button>
                        <label for="password">비밀번호 입력</label>
                        <input type="password" id="pwd" name="pwd" placeholder="영,숫자 조합 8자리 이상" class="m_t5" title="비밀번호 입력" data-from="text" />
                        <label for="password2">비밀번호 재입력</label>
                        <input type="password" id="pwdchk" name="pwdchk" placeholder="비밀번호 재입력" class="m_t5" title="비밀번호 재입력" data-from="text" />
                    </fieldset>
                    <button type="submit" class="next_button" data-btn="text">다음 단계로</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>