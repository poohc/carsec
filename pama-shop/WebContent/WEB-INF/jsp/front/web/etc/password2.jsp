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
    <div class="header_etc mb_0">
        <div class="wrap_header2">
            <p class="welcome_member"><i class="fa fa-heartbeat"></i> <span>카색 회원</span>님 반갑습니다!</p>
            <ul class="information_list">
                <li class="on"><a href="/web/etc/password.do">회원정보 수정</a></li>
                <li><a href="/web/etc/estimate1.do">견적</a></li>
                <li><a href="/web/etc/coupon1.do">쿠폰</a></li>
                <li><a href="/web/etc/qna.do">1:1문의</a></li>
                <li class=""><a href="/web/etc/unregister.do">회원탈퇴</a></li>
            </ul>
        </div>
    </div>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class="on"><a href="/web/etc/password2.do">회원정보 변경</a></li>
                <li><a href="/web/etc/password3.do">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1">
                <form action="password.jsp">
                    <div class="img_zone2"><img src="/img/nickname.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">닉네임/연락처 변경</p>
                        <p class="text_type3">닉네임/연락처를 수정합니다.</p>
                    </div>
                    <dl class="form_type2 type2">
                        <dt><label for="nickname">현재 닉네임</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="nickname" title="제목" value="새로운 닉네임"></span></dd>
                        <dd><button data-btn="text" class="button_type3" type="submit">중복검사</button></dd>
                        <dt><label for="number">현재 연락처</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="number" title="제목" value="새로운 연락처"></span></dd>
                        <dd><button data-btn="text" class="button_type3" type="submit">인증번호 발송</button></dd>
                        <dt><label for="confirm">인증번호</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="confirm" title="제목" value="인증번호 입력"></span></dd>
                        <dd><button data-btn="text" class="button_type3" type="submit">인증번호 입력</button></dd>
                    </dl>
                    <button data-btn="text" class="button_type2" type="submit">변경하기</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>