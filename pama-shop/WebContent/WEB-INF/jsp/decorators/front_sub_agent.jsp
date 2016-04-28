<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<script type="text/javascript" src="/common/js/jquery.selectbox.js"></script>
<script type="text/javascript" src="/common/js/common-ui.js"></script>
<title>:::CarSec  :::</title>
<decorator:head />
</head>
<body>



<page:applyDecorator page="/WEB-INF/jsp/decorators/front_header.jsp" name="panel" />

<c:if test="${isLogin && sessionVO.level==10}">
<script>
function resumesFrom(){
	location.href="/bbs/resumes/messageForm.do";
}
</script>
</c:if>
<c:if test="${isLogin && sessionVO.level==40}">
<script>
function resumesFrom(){
	alert("일반회원만 이용할수 있습니다.");
}
</script>
</c:if>

<c:if test="${!isLogin }">
<script>
function resumesFrom() {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}
</script>
</c:if>
<!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class="${boardVO.boardKey=='recruit2'?'on':'' }"><a href="/bbs/recruit2/messageList.do">정비소 구인 </a></li>
                <li class="${requestURI=='/bbs/resumes/messageList.do' || requestURI=='/bbs/resumes/messageDetail.do'?'on':'' }"><a href="/bbs/resumes/messageList.do">정비소 구직</a></li>

                <!--<li class="${requestURI=='/bbs/resumes/messageForm.do'?'on':'' }"><a href="#;" onclick="javascript:resumesFrom();">구직등록</a></li>-->

                <li class="${fn:startsWith(requestURI,'/bbs/usedcarmarket')?'on':'' }"><a href="/bbs/usedcarmarket/messageList.do">중고차 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"></p>
				<decorator:body />
            </div>
        </div>
        <div class="rnb">
            <jsp:include page="/WEB-INF/jsp/decorators/front_include_login.jsp" />
            <jsp:include page="/WEB-INF/jsp/decorators/front_include_sidebanner.jsp" />
        </div>
    </div>
<page:applyDecorator page="/WEB-INF/jsp/decorators/front_footer.jsp" name="panel" />
</body>
</body>
</html>