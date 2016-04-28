<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>기업 회원가입</title>
<script type="text/javascript">
<!--
function chkcid() {
    var f = document.dataForm;
    if (f.mobile.value==""){
        alert( "휴대폰번호를 입력해주세요." );
        return false;
    }
    if (f.firstName.value==""){
        alert( "이름을 입력해주세요." );
        return false;
    }
    if (!f.check1.checked){
        alert( "약관을 읽고 동의해주세요." );
        return false;
    }
    if (!f.privacy.checked){
        alert( "개인정보취급방침을 읽고 동의해주세요." );
        return false;
    }
    f.action = "/mbr/accountAgencyJoin.do";
    f.submit();
}
//-->
</script>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">회원가입</h1>
            <p class="explain">휴대폰 번호로 인증 후 업체명을 입력하십시오.</p>
            <form id="dataForm" name="dataForm" method="post">
                <div class="member_join">
                    <fieldset class="phone_name">
                        <input type="text" id="mobile" name="mobile" placeholder="휴대폰번호 입력" title="휴대폰번호" data-from="text" class="fir_inp">
                        <button type="submit" class="type2" data-btn="text">인증번호 받기</button>
                        <input type="text" placeholder="인증번호 입력" title="인증번호입력" data-from="text" class="fir_inp">
                        <button type="submit" class="type5" data-btn="text">인증하기</button>
                        <input type="text" id="firstName" name="firstName" placeholder="업체명 입력(사업자등록증의 업체명)" title="업체명" data-from="text">
                    </fieldset>
                    <fieldset class="check">
                        <input type="checkbox" name="check1" id="check1" data-from="checkbox">
                        <label for="check1">이용약관 동의</label>
                        <dl class="form_agree">
                            <dt>제 1조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                            <dt>제 2조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                        </dl>
                    </fieldset>
                    <fieldset class="check">
                        <input type="checkbox" name="privacy" id="check2" data-from="checkbox">
                        <label for="check2">이용약관 동의</label>
                        <dl class="form_agree">
                            <dt>제 1조 (목적)</dt>
                            <dd>이 약관은 CARSEC 주식회사 ("회사" 또는 "CARSEC")가 제공하는 CARSEC 및 CARSEC 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.</dd>
                        </dl>
                    </fieldset>
                    <button type="submit" onClick="return chkcid();" class="next_button" data-btn="text">다음 단계로</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>