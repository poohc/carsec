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


<div class="coupon_popup" id="popup">
    <h1>고객님의 휴대폰으로 쿠폰코드를 재발송합니다</h1>
    <p class="text_type3">쿠폰 구입시 휴대폰번호와 일치해야 합니다.</p>
    <label for="phonenumber">휴대폰번호</label>
    <span class="selectbox">
        <select id="phonenumber" title="번호">
            <option value="">010</option>
            <option value="">011</option>
            <option value="">019</option>
        </select>
    </span>
    <input type="text" title="제목" class="input_type2">
    <input type="text" title="제목" class="input_type2">
    <button class="btn_yes" data-btn="text" type="submit">재발송</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp" class="close_popup"><img src="/img/pop_close.gif" alt="닫기"></a>

</div>


</body>

</body>
</html>