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

<page:applyDecorator page="/WEB-INF/jsp/decorators/front_headeretc.jsp" name="panel" />
    <c:if test="${isLogin }">
    <div class="header_etc">

        <div class="wrap_header2">
            <p class="welcome_member"><i class="fa fa-heartbeat"></i> <span>${sessionVO.memberNm} 회원</span>님 반갑습니다!</p>
            <ul class="information_list">
                <li class="on"><a href="/mbr/mypage/mypage.do">회원정보 수정</a></li>
                <li><a href="/estimate/estimate.do">견적</a></li>
                <c:if test="${sessionVO.level=='10'}">
                <li><a href="/mbr/mypage/couponList.do">쿠폰</a></li>
                </c:if>
                <c:if test="${sessionVO.level=='40'}">
                <li><a href="/mbr/mypage/couponAgencyList.do">쿠폰</a></li>
                </c:if>
                <li><a href="/bbs/qna/messageList.do">1:1문의</a></li>
                <li class=""><a href="/mbr/mypage/unregister.do">회원탈퇴</a></li>
            </ul>

        </div>
    </div>
</c:if>
<div style="width: 1020px;margin: auto;">
<decorator:body />
</div>
<page:applyDecorator page="/WEB-INF/jsp/decorators/front_footeretc.jsp" name="panel" />

</body>

</body>
</html>