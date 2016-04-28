<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="/common/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script>
  $(function() {
    $( "#accordion" ).accordion();
  });
</script>
</head>
<body>

	<div class="terms_layout">
		<p class="terms_title">자주묻는 질문</p>
		<div class="terms_detail">
			<div id="accordion">
				<h3>SELF점검은 무었입니까?</h3>
				<div>
					<p>카색의 운영자는 자동차 명장으로 20년간의 정비 노하우로 회원들이 쉽게 자신의 자동차 고장을 진단 할 수 있도록 고안해서 개발한 알고리듬입니다.</p>
				</div>
				<h3>쇼핑몰이 배송 서비스가 아닌 쿠폰이라고 하는데요.</h3>
				<div>
					<p>카색의 쇼핑몰은 메카닉회원들의 상품을 등록하고 쿠폰을 발급받아 쿠폰 번호만 알려주고 결제하는 신개념의 정비서비스입니다.</p>
				</div>
				<h3>이용료는 무료인가요?</h3>
				<div>
					<p>셀프점검, 부품맵등의 이용료는 전혀 없습니다.</p>
				</div>
				<h3>고객센터 운영시간은 어떻게 됩니까?</h3>
				<div>
					<p>고객센터는 매주 토,일을 제외한 09:00~18:00까지 운영하며, 이메일로 문의를 주시면 빠른 답변이 가능합니다.</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>