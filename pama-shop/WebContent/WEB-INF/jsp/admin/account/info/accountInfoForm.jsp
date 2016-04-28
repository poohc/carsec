<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account/info");
%>
<head>
<script type="text/javascript" src="/common/js/common.js" charset="UTF-8"></script>
<script src="/common/js/jquery/jquery-1.6.2.min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/common/js/jquery/jquery.js" type="text/javascript" charset="UTF-8"></script>
<link type="text/css" href="/common/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" />
<script type="text/javascript" src="/common/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/join.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	return true;
}

$(function(){

	// Datepicker
	$('#infoContractSdate').datepicker({
		inline: true,
		dateFormat: 'yy-mm-dd'
	});

	// Datepicker
	$('#infoContractEdate').datepicker({
		inline: true,
		dateFormat: 'yy-mm-dd'
	});
});

//-->
</script>
<script type="text/javascript">
<!--
function checkReset(type){
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
    var isID = /^[a-z0-9_]{4,20}$/;

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
    } else if(f.mbrId.value.length < 4) {
        alert("아이디는 4자 이상입니다.");
        f.mbrId.focus();
    }else if(chkNonchar(f.mbrId.value)){
        alert("아이디에 특수문자는 입력할 수 없습니다.");
        f.mbrId.focus();
    }else if( !isID.test(str) ) {
        alert("아이디는 4~20자의 영문 소문자와 숫자,특수기호(_)만 사용할 수 있습니다.");
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

function goList() {
    var form = document.accountForm;
    var listReturnURL = form.listReturnURL.value;
    if (listReturnURL!="") {
        location.href = listReturnURL;
    } else {
        location.href = "accountList.do";
    }
}

function openZipCode(){
    zipWindow = window.open("/common/zip/zipcodeList.do", "zipcode","height=480,width=469, menubar=no,directories=no,resizable=no,status=no,scrollbars=yes");
    zipWindow.focus();
}

function zipCodeValue(zip, addr1){
    var form = document.accountForm;
    form.zipcode.value = zip;
    form.addr1.value = addr1;
    form.addr2.focus();
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
    }else {
        form.emailchkYn.value="";
    }
}

function goList(){
	location.href="/admin/account/info/accountAllInfoList.do";
}
//-->
</script>
</head>

<div class="title">회원가입 폼</div>

<form name="accountInfoForm" id="accountInfoForm" method="post" class="accountInfoForm" action="/admin/account/info/accountInfoFormProc.do" enctype="multipart/form-data">
	<input type="hidden" name="mbrId" id="mbrId" value="${accountFormVO.mbrId}" />
	<input type="hidden" name="mbrInfoId" id="mbrInfoId" value="${accountFormVO.accountInfoVO.mbrInfoId}" />

	<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
	<table class="contents">
		<tr>
			<th>아이디</th>
			<td>${accountFormVO.mbrId}</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${accountFormVO.nickname}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${accountFormVO.email}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${accountFormVO.firstName}</td>
		</tr>
		<tr>
			<th>정산은행</th>
			<td><input type="text" name="infoBank" id="infoBank" value="${accountFormVO.accountInfoVO.infoBank}" style="width:400px"/></td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td><input type="text" name="infoAccNumber" id="infoAccNumber" value="${accountFormVO.accountInfoVO.infoAccNumber}" style="width:400px"/></td>
		</tr>
		<tr>
			<th>예금주</th>
			<td><input type="text" name="infoAccHolder" id="infoAccHolder" value="${accountFormVO.accountInfoVO.infoAccHolder}" style="width:400px"/></td>
		</tr>
		<tr>
			<th>정산율</th>
			<td><input type="text" name="infoSettlRates" id="infoSettlRates" value="${accountFormVO.accountInfoVO.infoSettlRates}" />
			 계약일 <input type="text" name="infoContractSdate" id="infoContractSdate" value="${accountFormVO.accountInfoVO.infoContractSdate}" />
			 ~ <input type="text" name="infoContractEdate" id="infoContractEdate" value="${accountFormVO.accountInfoVO.infoContractEdate}" />
			</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
			<img src="/media/${accountFormVO.accountInfoVO.mbrImage }.image" width="100"/><br /><br />
			<input type="file" name="file" id="file" style="width:300px"/></td>
		</tr>
		<tr>
			<th>통장사본</th>
			<td>
			<img src="/media/${accountFormVO.accountInfoVO.infoBankBookImage }.image" width="100"/><br /><br />
			<input type="file" name="file1" id="file1" style="width:300px"/></td>
		</tr>

		<tr>
			<th>소개</th>
			<td><textarea name="career" id="career" style="width: 400px;height: 100px;">${accountFormVO.career}</textarea>
			</td>
		</tr>

		<tr>
			<th>한줄소개</th>
			<td><input type="text" name="memo" id="memo" value="${accountFormVO.memo}" style="width:400px"/></td>
		</tr>

		<tr>
			<th>순서</th>
			<td><input type="text" name="orderNum" id="orderNum" value="${accountFormVO.accountInfoVO.orderNum}" style="width:50px"/></td>
		</tr>

		<tr>
			<th>회원 레벨</th>
			<td><c:choose>
					<c:when test="${accountFormVO.level == '99'}">슈퍼 관리자</c:when>
					<c:otherwise>
						<select name="level" style="width: 60;">
							<option value="30" ${accountFormVO.level == '30'?'selected':''}>전문가</option>
							<option value="40" ${accountFormVO.level == '40'?'selected':''}>정보원</option>
						</select>
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<th>승인여부</th>
			<td><select name="infoApproval" style="width: 60;">
	                <option value="0" ${accountFormVO.accountInfoVO.infoApproval == '0'?'selected':''}>활동정지</option>
					<option value="2" ${accountFormVO.accountInfoVO.infoApproval == '2'?'selected':''}>승인</option>
			</select></td>
		</tr>
	</table>
	<div id="datepicker"></div>
	<div class="btn">
		<div class="btnFl">
			<a href="#;" onclick="accountForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
		</div>
		<div class="btnFr">
			<c:if test="${not empty accountFormVO}">
				<input type="image" src="/common/images/admin/btn/btn_modify.gif" />
			</c:if>
			<c:if test="${empty accountFormVO}">
				<input type="image" src="/common/images/admin/btn/btn_save.gif" />
			</c:if>
			<a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a>
		</div>
		<div style="clear: both"></div>
	</div>
</form>

<script type="text/javascript">
var month = "${fn:split(accountFormVO.birth,'-')[1]}";
changeYear();
changeMon(month);
accountForm.month.value = month;
accountForm.day.value="${fn:split(accountFormVO.birth,'-')[2]}";
</script>
