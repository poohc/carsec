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


<div class="coupon_popup" id="popup">
    <h1>쿠폰번호 : 000000000<br>
    [상품명]를  취소하시겠습니까?</h1>
    <dl>
        <dt>카드 취소 규정</dt>
        <dd>- 당월 취소 가능 / 결제대금에서 청구시 카드사로부터 환불</dd>
        <dt>휴대폰 결제 취소 규정</dt>
        <dd>- 당월 취소 가능 / 결제대금에서 청구시 카드사로부터 환불</dd>
        <dt>무통장 입금 취소 규정</dt>
        <dd>- 당월 취소 가능 / 결제대금에서 청구시 카드사로부터 환불</dd>
    </dl>
    <button class="btn_yes" data-btn="text" type="submit">예</button>
    <button class="btn_no" data-btn="text" type="submit">아니오</button>
    <a onclick="javascript:document.getElementById('popup').style.display = 'none'; return false;" id="closepopup" href="poupon_popup.jsp"><img src="/img/pop_close.gif" alt="닫기"></a>

</div>


</body>

</body>
</html>