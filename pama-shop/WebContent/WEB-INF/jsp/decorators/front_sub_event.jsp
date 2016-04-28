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

 <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">

                <li class="${boardVO.boardKey=='compareevent'?'on':'' }"><a href="/bbs/compareevent/messageList.do">이벤트</a></li>
                <li class="${boardVO.boardKey=='compareeventwin'?'on':'' }"><a href="/bbs/compareeventwin/messageList.do">당첨자 공지</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"></p>
                <dl class="event">
                    <dt>공지</dt>
					<c:forEach items="${randomNotice }" var="i" varStatus="iStatus" begin="0" end="0">
	                 	<dd onclick="randomNotice('${i.boardKey}','${i.messageId}')">${i.title}</dd>
	                 </c:forEach>
                </dl>
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