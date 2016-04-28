<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<title>:::CarSec  :::</title>
</head>
<body>
<div class="coupon_popup2" id="popup">
    <div class="img_layout">
        <img src="/img/popup_img1.png" alt="">
        <div class="p_box">
            <p class="partner_name elipsis">협력업체 지역명<span>협력업체명</span></p>
            <p class="onproduct">상품명</p>
            <p class="optional elipsis">옵션:블라블라블라<span>수량:10</span></p>
        </div>
    </div>
    <p class="change_phone">결제가 완료되면 010-0000-0000으로 쿠폰이 발송합니다. 번호가 변경되었으면 회원정보에서 휴대폰 번호를 변경해 주시기 바랍니다.</p>
    <p class="change_phone2">결제하시겠습니까?</p>
    <button class="btn_yes" data-btn="text" type="submit">예</button>
    <button class="btn_no" data-btn="text" type="submit">아니오</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp"><img src="/img/pop_close.gif" alt="닫기"></a>

</div>


</body>

</body>
</html>