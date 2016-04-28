<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 로그인</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="login_type">
            <h1 class="join_title">LOGIN <img src="/img/login.png" alt="로그인"></h1>
            <ul class="login_list">
                <li class="id"><img src="/img/login2.png" alt=""><input type="text" value="아이디" class="input_type2"></li>
                <li class="pass"><img src="/img/login3.png" alt=""><input type="text" value="비밀번호" class="input_type2"></li>
                <li class="btn"><button class="button_type4">로그인</button></li>
            </ul>
            <dl class="form_type1">
                <dt>회원가입을 하시면 보다 많은 서비스를 무료로 즐기실 수 있습니다.</dt>
                <dd><a href="/web/etc/join1.do" class="button_type4">업체회원가입</a></dd>
                <dt>아이디 패스워드를 분실한 경우, 가입시 등록한 휴대폰 번호로 알려드립니다.</dt>
                <dd><a href="/web/etc/join2.do" class="button_type4">ID/PW 찾기</a></dd>
            </dl>
            <img src="/img/board_img.jpg" class="login_banner" alt="">
        </div>
    </div>


</body>
</html>