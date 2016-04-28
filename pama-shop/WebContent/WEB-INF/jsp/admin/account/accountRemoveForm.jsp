<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account");
%>
<html>
<head>
<title>회원 탈퇴</title>
<link rel="stylesheet" href="/css/admin/style.css" type="text/css" charset="UTF-8" media="all" />
<script src="/javascript/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
<!--

if('${accountFormVO.mode}'=='100'){  // 실패
    alert("회원 탈퇴 실패하였습니다. 시스템 관리자에게 문의 하세요. ");
}

//RemoveProc
function goAccountRemoveProc(){
    var form = document.accountRemoveForm;

    if (form.memo1.value == '') {
    	alert('탈퇴사유를 입력해 주세요.');
    	return false;
    }

    if(confirm('탈퇴처리 하시면 복구가 불가능 합니다. 신중히 선택해 주세요. 정말 탈퇴 처리하시겠습니까?')){
    	form.memo.value = "관리자등록," + form.memo1.value;
        form.action="./${statusVal}removeProc.do";
        form.method="post";
        form.submit();
    }

}
//-->
</script>
</head>
<body>
<div class="wrap">

    <div class="content">
        <div class="title">탈퇴 사유 입력</div>

        <form name="accountRemoveForm">
        <input type="hidden" name="mbrId" value="${accountFormVO.mbrId }">
        <input type="hidden" name="memo">
        <div>
            <textarea style="width:650px;height:50px;" id="memo1" name="memo1"></textarea>
        </div>
        <!-- btn -->
        <div class="right" style="margin:10px 10px 0 0; padding-bottom:5px;">
            <a href="#;" onclick="window.close();">[취소]</a>&nbsp;
            <a href="#;" onclick="goAccountRemoveProc();">[확인]</a>
        </div>
        </form>
    </div>
</div>
</body>

</html>