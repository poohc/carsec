<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>회원정보</title>
<script type="text/javascript">
<!--
function send()
{
    var f = document.loginForm;
    if( f.pwd.value == "" )
    {
        alert("비밀번호를 입력하세요");
        f.pwd.focus();
        return false;
    }

    f.action = "/mbr/mypage/unregisterInfo.do";
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
    document.loginForm.pwd.focus();
}

//isForms
function isForms(f) {
	return true;
}

//-->
</script></head>
<body>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1 type3">
                <form name="loginForm" method="post" style="margin: 0px;" onsubmit="return send();">
                    <div class="img_zone2"><img src="/img/password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">비밀번호 재확인</p>
                        <p class="text_type3">본인확인을 위해 한번 더 비밀번호를 입력해 주세요. <br>비밀번호는 타인에게 노출되지 않도록 주의해 주세요.</p>
                    </div>
		            <c:choose>
					<c:when test="${mode=='300'}">
					<div class="errMag">비밀번호를 잘못 입력하셨습니다.</div>
					</c:when>
					</c:choose>
                    <dl class="form_type1">
                        <dt>CARSEC 아이디</dt>
                        <dd><span>${sessionVO.mbrId}</span></dd>
                        <dt><label for="password">비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="pwd" name="pwd" title="제목"></span></dd>
                    </dl>
                    <button data-btn="text" class="button_type2" type="submit">확인</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>