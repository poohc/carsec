<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<script type="text/javascript" src="/common/js/common-ui.js"></script>
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">회원가입</h1>
            <p class="explain">휴대폰 번호로 인증 후 성함을 입력하십시오.</p>
            <form action="join1.jsp">
                <div class="member_join">
                    <fieldset class="phone_name">
                        <input type="text" placeholder="휴대폰번호 입력" title="휴대폰번호" data-from="text" class="fir_inp">
                        <button type="submit" class="type2" data-btn="text">인증번호 받기</button>
                        <input type="text" placeholder="이름 입력 (2자이상)" title="이름" data-from="text">
                    </fieldset>
                    <fieldset class="check">
                        <input type="checkbox" id="check1" data-from="checkbox">
                        <label for="check1">이용약관 동의</label>
                        <dl class="form_agree">
                            <dt>제 1조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                            <dt>제 2조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                        </dl>
                    </fieldset>
                    <fieldset class="check">
                        <input type="checkbox" id="check2" data-from="checkbox">
                        <label for="check2">이용약관 동의</label>
                        <dl class="form_agree">
                            <dt>제 1조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                        </dl>
                    </fieldset>
                    <button type="submit" class="next_button" data-btn="text">다음 단계로</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>