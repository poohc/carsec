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
<script type="text/javascript">
<!--
function getNickNameChk() {
    var f = document.accountForm;

    if(f.nickname.value=="") {
        alert("별명을 입력하십시오.");
        f.nickname.focus();
        return false;
    }

    var statusTypeChangeUrl = '/signup/accountNickNameChk.do?nickname='+f.nickname.value;
    $.getJSON(statusTypeChangeUrl,
     function(data) {
        if(data.nickNameChk != null){
            alert("이미 등록된 별명 입니다. 다른 별명을 입력하세요.");
            f.nickNamechkYn.value = "";
        }else{
            alert("사용 가능한 별명 입니다.");
            f.nickNamechkYn.value = "Y";
        }
     });
    return true;
}

function checkReset(type){
    var form = document.accountForm;
    if(type == 'id'){
    }else if (type == 'email'){
    }else {
    	form.nickNamechkYn.value="";
    }
}
//-->
</script>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class="on"><a href="/mbr/mypage/mypage.do">회원정보 변경</a></li>
                <li><a href="/mbr/mypage/mypageChangePwd.do">비밀번호 변경</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box1">
                <form name="accountForm" id="accountForm" method="post" class="accountForm" action="mypageModifyFormProc.do">
                    <input type="hidden" name="nickNamechkYn" id="nickNamechkYn" class="nickNamechkYn" value="${not empty accountFormVO?'Y':''}" class="required" />
                    <div class="img_zone2"><img src="/img/nickname.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">닉네임/연락처 변경</p>
                        <p class="text_type3">닉네임/연락처를 수정합니다.</p>
                    </div>
                    <dl class="form_type2 type2">
                        <dt><label for="nickname">현재 닉네임</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="nickname" name="nickname" title="현재 닉네임" value="${accountFormVO.nickname}" onChange="checkReset('nickName')"></span></dd>
                        <dd><button data-btn="text" class="button_type3" type="submit" onclick="getNickNameChk();">중복검사</button></dd>
                        <dt><label for="number">현재 연락처</label></dt>
                        <dd><span class="enter_st2"><input type="text" id="mobile" name="mobile" title="현재 연락처" value="${accountFormVO.mobile}"></span></dd>
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