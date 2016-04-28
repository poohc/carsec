<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원정보</title>
</head>
<body>
    <!-- contain -->
    <div class="header_etc">
        <div class="wrap_header2">
            <p class="welcome_member"><span>홍길동</span>&nbsp;&nbsp;회원님 반갑습니다!</p>
            <ul class="information_list">
                <li><a href="/web/etc/password.do">회원정보 수정</a></li>
                <li><a href="/web/etc/estimate1.do">견적</a></li>
                <li><a href="/web/etc/coupon1.do">쿠폰</a></li>
                <li><a href="/web/etc/qna.do">1:1문의</a></li>
                <li class="on"><a href="/web/etc/unregister.do">회원탈퇴</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1 type3">
                <form action="unregister2.do">
                    <div class="img_zone2"><img src="/img/password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">비밀번호 재확인</p>
                        <p class="text_type3">본인확인을 위해 한번 더 비밀번호를 입력해 주세요. <br>비밀번호는 타인에게 노출되지 않도록 주의해 주세요.</p>
                    </div>
                    <dl class="form_type1">
                        <dt>CARSEC 아이디</dt>
                        <dd><span>CARSEC</span></dd>
                        <dt><label for="password">비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="password" title="제목"></span></dd>
                    </dl>
                    <button data-btn="text" class="button_type2" type="submit">확인</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>