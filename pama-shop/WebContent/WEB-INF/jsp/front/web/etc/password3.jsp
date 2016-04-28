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
                <li class=""><a href="/web/etc/password.do">회원정보 변경</a></li>
                <li class="on"><a href="#">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1">
                <form action="password.jsp">
                    <div class="img_zone2"><img src="/img/change_password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">지속적인 비밀번호 변경으로 <br>개인정보를 지키세요.</p>
                    </div>
                    <dl class="form_type1">
                        <dt><label for="password">현재 비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="password" title="제목"></span></dd>
                        <dt><label for="number">새 비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="number" title="제목" value=""></span></dd>
                        <dt><label for="confirm">새 비밀번호 확인</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="confirm" title="제목" value=""></span></dd>
                    </dl>
                    <button data-btn="text" class="button_type2" type="submit">변경하기</button>
                </form>
                <ul class="list_type1">
                    <li>비밀번호는 8~32자의 영문 대/소문자, 숫자, 특수문자를 조합하여 사용하실 수 있어요!</li>
                    <li>쉬운 비밀번호나 자주 쓰는 사이트의 비밀번호가 같을 경우, 도용되기 쉬워 주기적으로 변경하여 사용하는 것이 좋습니다.</li>
                    <li>비밀번호에 특수문자를 추가하여 사용하시면 기억하기도 쉽고, 비밀번호 안전도가 높아져 도용의 위험이 줄어듭니다.</li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>