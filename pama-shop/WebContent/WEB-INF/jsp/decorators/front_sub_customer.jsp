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
<link rel="stylesheet" href="/common/css/front/sub1.css" type="text/css" />
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
  <!-- contain -->
    <div class="header_etc">
        <div class="wrap_header2">
            <p class="welcome_member">고객센터</p>

            <ul class="information_list">
                <li class="${fn:startsWith(currentURI, '/web/customer/private_agree')?'on':'' }" ><a href="/web/customer/private_agree.do">개인정보취급 방침</a></li>
                <li class="${fn:startsWith(currentURI, '/web/customer/coupon_agree')?'on':'' }"><a href="/web/customer/coupon_agree.do">쇼핑몰 쿠폰 이용 약관</a></li>
                <li class="${fn:startsWith(currentURI, '/web/customer/agree')?'on':'' }"> <a href="/web/customer/agree.do">CARSEC 이용 약관</a></li>
                <li class="${fn:startsWith(currentURI, '/web/customer/faq')?'on':'' }"><a href="/web/customer/faq.do">FAQ</a></li>
                <li class="${fn:startsWith(currentURI, '/web/customer/faq')?'on':'' }"><a href="/web/customer/customer.do">회사소개</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/notice1')?'on':'' }"><a href="/bbs/notice1/messageList.do">일반회원 공지사항</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/notice2')?'on':'' }"><a href="/bbs/notice2/messageList.do">메카닉회원 공지사항</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/notice3')?'on':'' }"><a href="/bbs/notice3/messageList.do">작업공지</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/notice4')?'on':'' }"><a href="/bbs/notice4/messageList.do">이벤트공지</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/usereviews')?'on':'' }"><a href="/bbs/usereviews/messageList.do">셀프진단 이용후기</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
	<decorator:body />
	</div>
<page:applyDecorator page="/WEB-INF/jsp/decorators/front_footeretc.jsp" name="panel" />

</body>

</body>
</html>