<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>로그인</title>
<script type="text/javascript">
<!--
function send()
{
    var f = document.loginForm;
    if( f.loginId.value == "" )
    {
        alert("이메일 주소를 입력하세요.");
        f.loginId.focus();
        return false;
    }
    if( f.pwd.value == "" )
    {
        alert("비밀번호를 입력하세요");
        f.pwd.focus();
        return false;
    }

    f.action = "/login/loginProc.do";
    return true;
}

function enter(index)
{
    var f = document.loginForm;

    if( event.keyCode == 13 )
    {
        if( index == 1 )
        {
            f.pwd.focus();
        }
        else if( index == 2 )
        {
            send();
        }
    }
}

function init()
{
    document.loginForm.loginId.focus();
}

//isForms
function isForms(f) {
	return true;
}
//-->
</script>
</head>
<body>
    <!-- contain -->
    <div id="container">
	    <form name="loginForm" method="post" style="margin: 0px;" onsubmit="return send();">
	        <input type="hidden" name="returnURL" value="${loginFormVO.returnURL }" />
        <div class="login_type">
            <h1 class="join_title">
            ${param.mode=="500"?"회원가입이 완료되었습니다. 로그인 후 이용해 주세요.":"LOGIN " }

            <img src="/img/login.png" alt="로그인"></h1>
            <ul class="login_list">
                <li class="id"><img src="/img/login2.png" alt=""><input type="text" name="loginId" id="loginId" placeholder="아이디" class="input_type2"></li>
                <li class="pass"><img src="/img/login3.png" alt=""><input type="password" name="pwd" id="pwd" placeholder="비밀번호" class="input_type2" style="border: 1px solid;"></li>
                <li class="btn"><button type="submit" class="button_type4">로그인</button></li>
            <c:choose>
				<c:when test="${loginFormVO.mode=='102'}">
					<li class="errMag">로그인 아이디나 비밀번호를 잘못 입력하셨습니다.(${loginFormVO.mode})</li>
				</c:when>
				<c:when test="${loginFormVO.mode=='300'}">
					<li class="errMag">로그인 아이디나 비밀번호를 잘못 입력하셨습니다.(${loginFormVO.mode})</li>
				</c:when>
				<c:when test="${loginFormVO.mode=='30'}">
					<li class="errMag">승인대기 중입니다.(${loginFormVO.mode})</li>
				</c:when>
			</c:choose>
            </ul>
            <dl class="form_type1">
                <dt>카색정비포탈은 일반회원과 메카닉회원으로 구분되어 있습니다.</dt>
                <dd><a href="/mbr/accountAgree.do" class="button_type4">일반회원 가입</a></dd>
                <dt>회원가입 유형을 확인 후 회원가입 버튼을 클릭해 주세요.</dt>
                <dd><a href="/mbr/accountAgreeAgency.do" class="button_type4">메카닉회원 가입</a></dd>
            </dl>
            <dt style="text-align:center">아이디 | 비밀번호 찾기</dt>
        </div>
        </form>
    </div>
</body>
</html>
