<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>

     <div class="event_area"><img src="/img/event_img.png" alt="self견적을 받고 견적 의뢰를 하면 추첨을 통하여 선물을 드립니다."></div>
     <div class="self_start">
     <a class="start_self" onclick="loginCheck();"><img src="/img/bt_self.png" alt="셀프진단시작"></a>
     </div>


<c:if test="${isLogin }">
<script>
function loginCheck() {
		location.href="check1_1.do";
}
</script>
</c:if>
<c:if test="${!isLogin }">
<script>
function loginCheck() {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}
</script>
</c:if>
</body>
</html>