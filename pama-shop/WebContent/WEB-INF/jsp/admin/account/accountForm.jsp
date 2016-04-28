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
	setMobile();
	var mailchk = true;
	if(f.email1.value!="" && f.email2.value!="") {
		f.email.value = f.email1.value + "@" + f.email2.value;
	}
	<c:if test="${empty accountFormVO}">
	var statusTypeChangeUrl = '/signup/accountEmailChk.do';
	$.ajax({
		  dataType: "json",
		  url: statusTypeChangeUrl,
		  async: false,
		  data: 'email='+f.email.value,
		  success: function(data) {
		        if(data.emailChk != null){
		            alert("이미 등록된 이메일 입니다. 다른 이메일을 입력하세요.");
		            mailchk = false;
		        }else{
		        	mailchk = true;
		        }
		  }
	});
	</c:if>
	<c:if test="${not empty accountFormVO}">
	if(f.email.value!=f.emailOld.value) {
		var statusTypeChangeUrl = '/signup/accountEmailChk.do';
		$.ajax({
			  dataType: "json",
			  url: statusTypeChangeUrl,
			  async: false,
			  data: 'email='+f.email.value,
			  success: function(data) {
			        if(data.emailChk != null){
			            alert("이미 등록된 이메일 입니다. 다른 이메일을 입력하세요.");
			            mailchk = false;
			        }else{
			        	mailchk = true;
			        }
			  }
		});

	}
	</c:if>
	return mailchk;
}

function setTel() {
	var f = document.accountForm;
	f.tel.value = "";
	if (f.tel1[f.tel1.selectedIndex].value != '' && f.tel2.value != '' && f.tel3.value != '') {
		f.tel.value = f.tel1[f.tel1.selectedIndex].value + "-" + f.tel2.value + "-" + f.tel3.value;
	}
}
function setMobile() {
	var f = document.accountForm;
	f.mobile.value = "";
	if (f.mobile1[f.mobile1.selectedIndex].value != '' && f.mobile2.value != '' && f.mobile3.value != '') {
		f.mobile.value = f.mobile1[f.mobile1.selectedIndex].value + "-" + f.mobile2.value + "-" + f.mobile3.value;
	}
}
function setBirth() {
	var f = document.accountForm;
	f.birth.value = "";
	if (f.birth1[f.birth1.selectedIndex].value != '' && f.birth2[f.birth2.selectedIndex].value != '' && f.birth3[f.birth3.selectedIndex].value != '') {
		f.birth.value = f.birth1[f.birth1.selectedIndex].value + "-" + f.birth2[f.birth2.selectedIndex].value + "-" + f.birth3[f.birth3.selectedIndex].value;
	}
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
        location.href = "${statusVal}list.do";
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
//-->
</script>
</head>

<div class="title">회원가입 폼</div>

<form name="accountForm" id="accountForm" method="post" class="accountForm" action="/admin/account/${accountType}/${statusVal}formProc.do">
<input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
<input type="hidden" name="idchkYn" id="idchkYn" class="idchkYn" value="${not empty accountFormVO?'Y':''}" class="required" />
<table class="contents">
    <c:if test="${empty accountFormVO}">
        <tr>
            <th>아이디</th>
            <td><input type="text" " name="mbrId" id="mbrId"/><a href="#" onclick="getIdChk()"><img src="/images/front/member/btn_id_check.gif" alt="아이디중복확인" /></a></td>
        </tr>
        <tr>
            <th>닉네임</th>
            <td><input type="text" " name="nickname" id="nickname"/></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td class="mbrId">
	            <input type="text" name="email1" id="email1" style="width:70px;" class="required" onkeyup="checkReset('email');">&nbsp;@
	            <input type="text" name="email2" id="email2" style="width:80px;" class="required" value="" onkeyup="checkReset('email');"/>
	            <select name="email3" onChange="emailserv(this.value);">
	                <option value="" selected>선택해 주세요</option>
	                <option value="hanmail.net">hanmail.net</option>
	                <option value="naver.com">naver.com</option>
	                <option value="gmail.com">gmail.com</option>
	                <option value="nate.com">nate.com</option>
	                <option value="hotmail.com">hotmail.com</option>
	                <option value="yahoo.co.kr">yahoo.co.kr</option>
	                <option value="dreamwiz.com">dreamwiz.com</option>
	                <option value="korea.com">korea.com</option>
	                <option value="empal.com">empal.com</option>
	                <option value="paran.com">paran.com</option>
	                <option value="hanafos.com">hanafos.com</option>
	                <option value="freechal.com">freechal.com</option>
	            </select>
	            <input type="hidden" name="email" value="">
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
            <td>${accountFormVO.mbrId}</td>
        </tr>
        <c:if test="${accountFormVO.level == 10}">
        <tr>
            <th>닉네임</th>
            <td>${accountFormVO.nickname}</td>
        </tr>
        </c:if>
        <c:if test="${accountFormVO.level == 0}">
        <tr>
            <th>이메일</th>
            <td>${accountFormVO.email}


<%-- 	            <input type="text" name="email1" id="email1" style="width:70px;" class="required" value="${fn:split(accountFormVO.email,'@')[0]}" onkeyup="checkReset('email');">&nbsp;@ --%>
<%-- 	            <input type="text" name="email2" id="email2" style="width:80px;" class="required" value="${fn:split(accountFormVO.email,'@')[1]}" onkeyup="checkReset('email');"/> --%>
<!-- 	            <select name="email3" onChange="emailserv(this.value);"> -->
<!-- 	                <option value="" selected>선택해 주세요</option> -->
<!-- 	                <option value="hanmail.net">hanmail.net</option> -->
<!-- 	                <option value="naver.com">naver.com</option> -->
<!-- 	                <option value="gmail.com">gmail.com</option> -->
<!-- 	                <option value="nate.com">nate.com</option> -->
<!-- 	                <option value="hotmail.com">hotmail.com</option> -->
<!-- 	                <option value="yahoo.co.kr">yahoo.co.kr</option> -->
<!-- 	                <option value="dreamwiz.com">dreamwiz.com</option> -->
<!-- 	                <option value="korea.com">korea.com</option> -->
<!-- 	                <option value="empal.com">empal.com</option> -->
<!-- 	                <option value="paran.com">paran.com</option> -->
<!-- 	                <option value="hanafos.com">hanafos.com</option> -->
<!-- 	                <option value="freechal.com">freechal.com</option> -->
<!-- 	            </select> -->
<%--             	<input type="hidden" name="email" value="${accountFormVO.email}" /><input type="hidden" name="emailOld" value="${accountFormVO.email}" /> --%>

            	</td>
        </tr>
        </c:if>
        <tr>
            <th> 이름</th>
            <td>

<%--             <input type="text" name="firstName" id="firstName" value="${accountFormVO.firstName}"/> --%>
            ${accountFormVO.firstName}
            </td>
        </tr>
         <input type="hidden" name="mbrId" id="mbrId" value="${accountFormVO.mbrId}"/>
    </c:if>
    <c:if test="${accountFormVO.level == 0}">
    <tr>
        <th scope="row">생년월일시</th>
        <td><select name="birth1" id="birth1" title="출생년도를 선택하세요" class="select_box" onChange="setBirth()" >
                    <option value="">출생년도</option>
                    <c:forEach var="i" begin="1910" end="2015">
                    <option value="${i}"${fn:split(accountFormVO.birth,'-')[0]==i?' selected':''}>${i}</option>
                    </c:forEach>
                  </select>
                  년
                  <select name="birth2" id="birth2" title="출생월을 선택하세요" class="select_box" onChange="setBirth()" >
                    <option value="">출생월</option>
                    <c:forEach var="i" begin="1" end="12">
                    <option value="${i<10?'0':''}${i}"${fn:split(accountFormVO.birth,'-')[1]==i?' selected':''}>${i}</option>
					</c:forEach>
                  </select>
                  월
                  <select name="birth3" id="birth3" title="출생일을 선택하세요" class="select_box" onChange="setBirth()" >
                    <option value="">출생일</option>
                    <c:forEach var="i" begin="1" end="31">
                    <option value="${i<10?'0':''}${i}"${fn:split(accountFormVO.birth,'-')[2]==i?' selected':''}>${i}</option>
					</c:forEach>
                  </select>
                  일 <input type="hidden" name="birth" value="${accountFormVO.birth}" />
        </td>
    </tr>
    <tr>
    	<th> 성별</th>
    	<td>
    		남성 <input type="radio" name="gender" id="gender" value="m"${accountFormVO==null||accountFormVO.gender=='m'?' checked':''} /> 여성 <input type="radio" name="gender" id="gender" value="f"${accountFormVO.gender=='f'?' checked':''} />
    	</td>
    </tr>
    </c:if>
    <tr>
        <th> 핸드폰</th>
        <td>
            <select name="mobile1"  style="width:60;" onChange="setMobile()">
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
            <input type="text" name="mobile2" id="mobile2" value="${fn:split(accountFormVO.mobile,'-')[1]}" style="width:40px;" onChange="setMobile()"/> -
            <input type="text" name="mobile3" id="mobile3" value="${fn:split(accountFormVO.mobile,'-')[2]}" style="width:40px;" onChange="setMobile()"/>
        	<input type="hidden" name="mobile" value="${accountFormVO.mobile}">
        </td>
    </tr>
    <c:if test="${accountFormVO.level == 0}">
    <tr>
        <th> 추천인</th>
        <td><input type="text" name="recommender" id="recommender" value="${accountFormVO.recommender}"/></td>
	</tr>
	</c:if>
    <tr>
        <th> 회원 레벨</th>
        <td>
		<c:if test="${accountFormVO.level != 30 && accountFormVO.level != 40}">
            <c:choose>
                <c:when test="${accountFormVO.level >= 90}">관리자</c:when>
                <c:when test="${accountFormVO.level == 40}">메카닉회원(승인)</c:when>
                <c:when test="${accountFormVO.level == 30}">메카닉회원(대기)</c:when>
                <c:when test="${accountFormVO.level == 10}">일반회원</c:when>
            </c:choose>
		</c:if>
		<c:if test="${accountFormVO.level == 30 || accountFormVO.level == 40}">
            <c:choose>
                 <c:when test="${accountFormVO.level == '99'}">슈퍼 관리자</c:when>
                 <c:otherwise>
                     <select name="level"  style="width:60;">
                         <option value="30" ${accountFormVO.level == '30'?'selected':''}>메카닉회원 대기</option> 
                         <option value="40" ${accountFormVO.level == '40'?'selected':''}>메카닉회원 승인</option>
                     </select>
                 </c:otherwise>
             </c:choose>
		</c:if>
        </td>
    </tr>
<!--     <tr> -->
<!--         <th> 상태</th> -->
<!--         <td> -->
<!--             <select name="statusType"  style="width:60;"> -->
<%--                 <option value="" ${accountFormVO.statusType == null?'selected':''}>상태선택</option> --%>
<!--                 <option value="0" ${accountFormVO.statusType == '0'?'selected':''}>탈퇴</option> -->
<%--                 <option value="1" ${accountFormVO.statusType == '1'?'selected':''}>대기</option> --%>
<%--                 <option value="2" ${accountFormVO.statusType == '2'?'selected':''}>일반</option> --%>
<!--             </select> -->
<!--         </td> -->
<!--     </tr> -->
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
