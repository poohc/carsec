<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<script type="text/javascript" src="/common/js/jquery.selectbox.js"></script>
<script type="text/javascript" src="/common/js/common-ui.js"></script>
<title>:::CarSec  :::</title>
</head>
<body>
<div class="popup2" id="popup">
    <h1>결제가 완료 되었습니다.</h1>
    <p class="text_type2">유효기간 ~ 2015-08-10 까지입니다.</p>
    <button class="btn_yes type2" data-btn="text" type="submit">쿠폰번호 SMS 발송</button>
    <p class="text_type2">쿠폰번호는 내 정보 - 쿠폰에서도 확인이 가능합니다.</p>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp"><img src="/img/pop_close.gif" alt="닫기"></a>
</div>


</body>

</body>
</html>