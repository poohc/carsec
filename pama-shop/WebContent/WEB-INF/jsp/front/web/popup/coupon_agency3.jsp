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
    <h1 class="agency_h1">쿠폰번호 : 0000000000 <br>사용처리 하시겠습니까?</h1>
    <button class="btn_yes btn_agency" data-btn="text" type="submit">예</button>
    <button class="btn_no btn_agency" data-btn="text" type="submit">아니오</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp" class="close_popup"><img src="/img/pop_close.gif" alt="닫기"></a>

</div>


</body>

</body>
</html>