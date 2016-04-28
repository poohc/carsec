<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>회원탈퇴</title>
<script type="text/javascript">
<!--
function unregisterSend()
{
    var f = document.accountForm;
    if( f.memo2.value == "" )
    {
        alert("탈퇴사유를 입력하세요");
        f.memo2.focus();
        return false;
    }

    f.memo.value = f.memo1.value + "," + f.memo2.value;

    f.action = "/mbr/mypage/accountRemoveProc.do";
    f.submit();
}
</script>
</head>
<body>
    <div id="container">
        <div class="layout_type1">
            <div class="layout_box2">
                <form name="accountForm" id="accountForm" method="post" class="accountForm">
                    <div class="img_zone2"><img src="/img/password.png" alt=""></div>
                    <div class="text_zone">
                        <p class="text_type2">탈퇴 사유</p>
                    </div>
                    <div class="unregister_form">
                        <span class="selectbox type1">
                            <select id="memo1" name="memo1" title="탈퇴사유">
                                <option value="콘텐츠 부족">콘텐츠 부족</option>
                                <option value="개인정보가 걱정되서">개인정보가 걱정되서</option>
                                <option value="쇼핑 불만족">쇼핑 불만족</option>
                                <option value="협력업체 불만족">협력업체 불만족</option>
                                <option value="카색 불만족">카색 불만족</option>
                                <option value="기타">기타</option>
                            </select>
                        </span>
                        <textarea rows="10" cols="30" id="memo2" name="memo2"></textarea>
                        <input type="hidden" id="memo" name="memo" value="" />
                    </div>
                    <button data-btn="text" class="button_type1" type="button" onClick="unregisterSend();">탈퇴하기</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>