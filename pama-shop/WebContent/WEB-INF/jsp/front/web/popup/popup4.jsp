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
    <h1>[상품명]</h1>
    <p class="text_type2">가격 <span class="point">10,000</span>원</p>
    <p class="text_type2">구입하시겠습니까?</p>
    <button class="btn_yes type2" data-btn="text" type="submit">결제하기</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp"><img src="/img/pop_close.gif" alt="닫기"></a>
</div>


</body>

</body>
</html>