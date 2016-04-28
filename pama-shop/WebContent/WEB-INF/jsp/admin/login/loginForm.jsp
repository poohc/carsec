<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>관리자</title>
<script type="text/javascript">
<!--
function send()
{
    var f = document.loginForm;
    if( f.loginId.value == "" )
    {
        alert("아이디를 입력하세요");
        f.loginId.focus();
        return false;
    }
    if( f.pwd.value == "" )
    {
        alert("비밀번호를 입력하세요");
        f.pwd.focus();
        return false;
    }

    f.action = "/admin/login/loginProc.do";
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
<body onload="init();">

<div id="loginBox">
  <h1>Administrator Login</h1>
  <form name="loginForm" method="post" style="margin: 0px;" onsubmit="return send();">
  <input type="hidden" name="returnURL" value="${param.returnURL }" />
  <ul>
  	<li class="loginTop">
		<c:choose>
		<c:when test="${loginFormVO.mode=='300'}">
		<div class="errMag">로그인 아이디나 비밀번호를 잘못 입력하셨습니다.</div>
		</c:when>
		</c:choose>
  	</li>
  	<li class="loginLine"></li>
  </ul>
  <ul>
	<li class="loginBody">
		<div class="loginAction">
			<ul>
				<li class="loginLogo"></li>
				<li class="loginInput">
					<div class="inputBox">
						<ul>
							<li class="idBox">
								<input type="text" name="loginId" id="loginId" value="admin" maxlength="12" style="width: 120px; height:20px;" />
							</li>
							<li class="pwdBox">
								<input type="password" name="pwd" id="pwd" value="qwer1234" maxlength="12" style="width: 120px; height:20px;" />
							</li>
						</ul>
					</div>
					<div class="buttonBox"><input type="image" src="/common/images/admin/btn/login_btn.gif" tabindex="3" style="border:none;" /></div>
				</li>
			</ul>
		</div>
	</li>
  </ul>
  <ul>
  	<li class="loginLine"></li>
  </ul>
  </form>
</div>

</body>
</html>