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
    <ul class="payment">
        <li class="li_1"><label class="radio_type2 type3" for="input_radio01"><input id="input_radio01" type="radio" name="input_radio01" checked="checked">신용카드</label></li>
        <li class="li_2"><label class="radio_type2 type3" for="input_radio02"><input id="input_radio02" type="radio" name="input_radio01" checked="">휴대폰 결제</label></li>
        <li class="li_3"><label class="radio_type2 type3" for="input_radio03"><input id="input_radio03" type="radio" name="input_radio01" checked="">무통장</label></li>
    </ul>
    <button class="btn_yes" data-btn="text" type="submit">결제페이지 이동</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp"><img src="/img/pop_close.gif" alt="닫기"></a>

</div>


</body>

</body>
</html>