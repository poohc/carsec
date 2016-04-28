<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account");
%>
<head>
<script type="text/javascript" src="/common/js/common.js" charset="UTF-8"></script>
<script type="text/javascript" src="/common/js/jquery/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/join.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	f.tel.value = f.tel1.value + "-" + f.tel2.value + "-" + f.tel3.value;
	f.mobile.value = f.mobile1.value + "-" + f.mobile2.value + "-" + f.mobile3.value;
	return true;
}
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

    <c:choose>
        <c:when test="${empty accountFormVO}">
            if (!f.mailSelect.checked){
                f.email.value = f.email1.value + f.email2.value;
            }else{
                f.email.value = f.email.value;
            }
        </c:when>
        <c:otherwise>
            email = f.email.value;
        </c:otherwise>
    </c:choose>

    f.email.value = f.email1.value + f.email2.value;

    //var statusTypeChangeUrl = '/signup/accountEmailChk.do?email='+f.email.value;
    //$.getJSON(statusTypeChangeUrl,
     //function(data) {
        //if(data.emailChk != null){
            //alert("이미 등록된 이메일 입니다. 다른 이메일을 입력하세요.");
            //f.emailchkYn.value = "";
        //}else{
            //alert("사용 가능한 이메일 입니다.");
            //f.emailchkYn.value = "Y";
        //}
     //});
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

function emailserv(){
    var form = document.accountForm;
    var value = form.mailSelect.checked;
    if( value == true)  {
        document.getElementById("emailIn").style.display="none";
        document.getElementById("emailOut").style.display="";
    } else {
        document.getElementById("emailIn").style.display="";
        document.getElementById("emailOut").style.display="none";
    }
    return;
}

function emailChange(value){
    var form = document.accountForm;
    form.email.value = form.email1.value + value;
}
//-->
</script>
</head>

<div class="title">회원가입 폼</div>

<form name="accountForm" id="accountForm" method="post" class="accountForm" action="/admin/account/accountFormProc.do">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<c:if test="${empty accountFormVO}">
<input type="hidden" name="idchkYn" value="">
</c:if>
<table class="contents">
    <c:if test="${empty accountFormVO}">
        <tr>
            <th>아이디</th>
            <td class="mbrId">
                <input type="text" name="mbrId" id="mbrId" value="${accountFormVO.mbrId}" onkeyup="checkReset('id');"/>
                <a href="#" onclick="getIdChk()"> [ID중복체크]</a>
                <span id="checkIdLabel"></span>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" " name="pwd" id="pwd"/></td>
        </tr>
        <tr>
            <th>비밀번호 확인</th>
            <td><input type="password" " name="pwdchk" id="pwdchk"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="firstName" id="firstName" value="${accountFormVO.firstName}"/></td>
        </tr>
    </c:if>
    <c:if test="${not empty accountFormVO}">
        <tr>
            <th>아이디</th>
            <td> ${accountFormVO.email}</td>
        </tr>
        <tr>
            <th> 이름</th>
            <td>${accountFormVO.firstName}${accountFormVO.lastName}</td>
        </tr>
         <input type="hidden" name="mbrId" id="mbrId" value="${accountFormVO.mbrId}"/>
    </c:if>
    <tr>
        <th> email</th>
        <td>
            <c:choose>
                <c:when test="${empty accountFormVO}">
                    <span id="emailIn" style="display:">
                    <input type="text" name="email1" style="width:120;" onkeyup="getEmailChk();">&nbsp;@
                    <select name="email2" onChange="emailChange(this.value);">
                        <option value="" selected>선택해 주세요</option>
                        <option value="@hanmail.net">hanmail.net</option>
                        <option value="@naver.com">naver.com</option>
                        <option value="@gmail.com">gmail.com</option>
                        <option value="@nate.com">nate.com</option>
                        <option value="@hotmail.com">hotmail.com</option>
                        <option value="@yahoo.co.kr">yahoo.co.kr</option>
                        <option value="@dreamwiz.com">dreamwiz.com</option>
                        <option value="@korea.com">korea.com</option>
                        <option value="@empal.com">empal.com</option>
                        <option value="@paran.com">paran.com</option>
                        <option value="@hanafos.com">hanafos.com</option>
                        <option value="@freechal.com">freechal.com</option>
                    </select>
                    </span>
                    <span id="emailOut" style="display:none">
                        <input type="text" name="email" id="email" value=""/> (직접입력)
                    </span>
                    <input type="checkbox" name="mailSelect" onclick="emailserv();">직접입력
                </c:when>
                <c:otherwise>
                    <input type="text" name="email" id="email" value="${accountFormVO.email}" onkeyup="checkReset('email');"/>
                </c:otherwise>
            </c:choose>
            <span id="checkEmailLabel"></span>
        </td>
    </tr>
    <tr>
        <th> 전화</th>
        <td>
            <select name="tel1"  style="width:60;">
                <option value='02'${fn:split(accountFormVO.tel,'-')[0]=='02'?' selected':''}>02</option>
                <option value='031'${fn:split(accountFormVO.tel,'-')[0]=='031'?' selected':''}>031</option>
                <option value='032'${fn:split(accountFormVO.tel,'-')[0]=='032'?' selected':''}>032</option>
                <option value='033'${fn:split(accountFormVO.tel,'-')[0]=='033'?' selected':''}>033</option>
                <option value='041'${fn:split(accountFormVO.tel,'-')[0]=='041'?' selected':''}>041</option>
                <option value='042'${fn:split(accountFormVO.tel,'-')[0]=='042'?' selected':''}>042</option>
                <option value='043'${fn:split(accountFormVO.tel,'-')[0]=='043'?' selected':''}>043</option>
                <option value='051'${fn:split(accountFormVO.tel,'-')[0]=='051'?' selected':''}>051</option>
                <option value='052'${fn:split(accountFormVO.tel,'-')[0]=='052'?' selected':''}>052</option>
                <option value='053'${fn:split(accountFormVO.tel,'-')[0]=='053'?' selected':''}>053</option>
                <option value='054'${fn:split(accountFormVO.tel,'-')[0]=='054'?' selected':''}>054</option>
                <option value='055'${fn:split(accountFormVO.tel,'-')[0]=='055'?' selected':''}>055</option>
                <option value='061'${fn:split(accountFormVO.tel,'-')[0]=='061'?' selected':''}>061</option>
                <option value='062'${fn:split(accountFormVO.tel,'-')[0]=='062'?' selected':''}>062</option>
                <option value='063'${fn:split(accountFormVO.tel,'-')[0]=='063'?' selected':''}>063</option>
                <option value='064'${fn:split(accountFormVO.tel,'-')[0]=='064'?' selected':''}>064</option>
                <option value='070'${fn:split(accountFormVO.tel,'-')[0]=='070'?' selected':''}>070</option>
                <option value='0130'${fn:split(accountFormVO.tel,'-')[0]=='0130'?' selected':''}>0130</option>
                <option value='0303'${fn:split(accountFormVO.tel,'-')[0]=='0303'?' selected':''}>0303</option>
                <option value='0502'${fn:split(accountFormVO.tel,'-')[0]=='0502'?' selected':''}>0502</option>
                <option value='0504'${fn:split(accountFormVO.tel,'-')[0]=='0504'?' selected':''}>0504</option>
                <option value='0505'${fn:split(accountFormVO.tel,'-')[0]=='0505'?' selected':''}>0505</option>
                <option value='0506'${fn:split(accountFormVO.tel,'-')[0]=='0506'?' selected':''}>0506</option>
            </select>
            <input type="text" name="tel2" id="tel2" value="${fn:split(accountFormVO.tel,'-')[1]}" style="width:40px;"/> -
            <input type="text" name="tel3" id="tel3" value="${fn:split(accountFormVO.tel,'-')[2]}" style="width:40px;"/>
        	<input type="hidden" name="tel" value="${accountFormVO.tel}">
        </td>
    </tr>
    <tr>
        <th> 핸드폰</th>
        <td>
            <select name="mobile1"  style="width:60;">
                <option value='010'${fn:split(accountFormVO.mobile,'-')[0]=='010'?' selected':''}>010</option>
                <option value='011'${fn:split(accountFormVO.mobile,'-')[0]=='011'?' selected':''}>011</option>
                <option value='016'${fn:split(accountFormVO.mobile,'-')[0]=='016'?' selected':''}>016</option>
                <option value='017'${fn:split(accountFormVO.mobile,'-')[0]=='017'?' selected':''}>017</option>
                <option value='018'${fn:split(accountFormVO.mobile,'-')[0]=='018'?' selected':''}>018</option>
                <option value='019'${fn:split(accountFormVO.mobile,'-')[0]=='019'?' selected':''}>019</option>
                <option value='070'${fn:split(accountFormVO.mobile,'-')[0]=='070'?' selected':''}>070</option>
                <option value='0130'${fn:split(accountFormVO.mobile,'-')[0]=='0130'?' selected':''}>0130</option>
                <option value='0303'${fn:split(accountFormVO.mobile,'-')[0]=='0303'?' selected':''}>0303</option>
                <option value='0502'${fn:split(accountFormVO.mobile,'-')[0]=='0502'?' selected':''}>0502</option>
                <option value='0504'${fn:split(accountFormVO.mobile,'-')[0]=='0504'?' selected':''}>0504</option>
                <option value='0505'${fn:split(accountFormVO.mobile,'-')[0]=='0505'?' selected':''}>0505</option>
                <option value='0506'${fn:split(accountFormVO.mobile,'-')[0]=='0506'?' selected':''}>0506</option>
            </select>
            -
            <input type="text" name="mobile2" id="mobile2" value="${fn:split(accountFormVO.mobile,'-')[1]}" style="width:40px;"/> -
            <input type="text" name="mobile3" id="mobile3" value="${fn:split(accountFormVO.mobile,'-')[2]}" style="width:40px;"/>
        	<input type="hidden" name="mobile" value="${accountFormVO.mobile}">
        </td>
    </tr>
    <tr>
        <th> 우편번호</th>
        <td><input type="text" name="zipcode" id="zipcode" value="${accountFormVO.zipcode}" readOnly onclick="openZipCode();"/> <a href="#;" onclick="openZipCode();">[우편번호찾기]</a></td>
    </tr>
    <tr>
        <th> 주소</th>
        <td><input type="text" name="addr1" id="addr1" value="${accountFormVO.addr1}" style="width:425px;"/></td>
    </tr>
    <tr>
        <th> 상세주소</th>
        <td><input type="text" name="addr2" id="addr2" value="${accountFormVO.addr2}" style="width:425px;"/></td>
    </tr>
    <tr>
        <th> 회원 레벨</th>
        <td>
            <c:choose>
                <c:when test="${accountFormVO.level == '99'}">슈퍼 관리자</c:when>
                <c:otherwise>
                    <select name="level"  style="width:60;">
                        <option value="" ${accountFormVO.level == null?'selected':''}>레벨선택</option>
                        <option value="10" ${accountFormVO.level == '10'?'selected':''}>일반회원</option>
<!--                         <option value="20" ${accountFormVO.level == '20'?'selected':''}>기업회원</option> -->
                        <option value="90" ${accountFormVO.level == '90'?'selected':''}>관리자</option>
                    </select>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    <tr>
        <th> 상태</th>
        <td>
            <select name="statusType"  style="width:60;">
                <option value="" ${accountFormVO.statusType == null?'selected':''}>상태선택</option>
                <!-- <option value="0" ${accountFormVO.statusType == '0'?'selected':''}>탈퇴</option> -->
                <option value="1" ${accountFormVO.statusType == '1'?'selected':''}>대기</option>
                <option value="2" ${accountFormVO.statusType == '2'?'selected':''}>일반</option>
            </select>
        </td>
    </tr>
</table>

<div class="btn">
    <div class="btnFl"><a href="#;" onclick="accountForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a></div>
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
