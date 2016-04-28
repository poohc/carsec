<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>회원정보</title>
<script src="/common/js/jquery-1.6.2.min.js" type="text/javascript" charset="UTF-8"></script>
<script src="/common/js/jquery.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript" src="/common/js/jquery-1_5_5/jquery.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/form.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/join.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//isForms
function isForms(f) {
	return true;
}

//-->
</script>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class=""><a href="/mbr/mypage/mypage.do">회원정보 변경</a></li>
                <li class="on"><a href="/mbr/mypage/mypageChangePwd.do">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1">
                <form name="accountForm" id="accountForm" method="post" class="accountForm" action="mypageModifyPwdProc.do">
                    <div class="img_zone2"><img src="/img/change_password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">지속적인 비밀번호 변경으로 <br>개인정보를 지키세요.</p>
                    </div>
                    <c:choose>
                    <c:when test="${mode=='-1'}">
					<div class="errMag">비밀번호를 잘못 입력하셨습니다.</div>
					</c:when>
					</c:choose>
                    <dl class="form_type1">
                        <dt><label for="password">현재 비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="password" id="pwd" name="pwd" title="제목"></span></dd>
                        <dt><label for="number">새 비밀번호</label></dt>
                        <dd><span class="enter_st2"><input type="password" id="modifyPwd" name="modifyPwd" title="제목" value=""></span></dd>
                        <dt><label for="confirm">새 비밀번호 확인</label></dt>
                        <dd><span class="enter_st2"><input type="password" id="modifyPwdChk" name="modifyPwdChk" title="제목" value=""></span></dd>
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