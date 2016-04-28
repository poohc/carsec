<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원탈퇴</title>
</head>
<body>
    <!-- contain -->
    <div class="header_etc">
        <div class="wrap_header2">
            <p class="welcome_member"><i class="fa fa-heartbeat"></i> <span>카색 회원</span>님 반갑습니다!</p>
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
            <div class="layout_box2">
                <form action="password.jsp">
                    <div class="img_zone2"><img src="/img/password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">탈퇴 사유</p>
                    </div>
                    <div class="unregister_form">
                        <span class="selectbox type1">
                            <select id="bank" title="탈퇴사유">
                                <option value="">콘텐츠 부족</option>
                                <option value="">개인정보가 걱정되서</option>
                                <option value="">쇼핑 불만족</option>
                                <option value="">협력업체 불만족</option>
                                <option value="">카색 불만족</option>
                                <option value="">기타</option>
                            </select>
                        </span>
                        <textarea rows="10" cols="30" id="cont" name="cont"></textarea>
                    </div>
                    <button data-btn="text" class="button_type1" type="submit">탈퇴하기</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>