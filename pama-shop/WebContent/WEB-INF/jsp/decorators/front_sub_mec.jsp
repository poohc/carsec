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
                <li class="${boardVO.boardKey=='newcar'?'on':'' }"><a href="/bbs/newcar/messageList.do">국산차정비</a></li>
                <li class="${boardVO.boardKey=='newtech'?'on':'' }"><a href="/bbs/newtech/messageList.do">수입차정비</a></li>
                <li class="${boardVO.boardKey=='maintennace'?'on':'' }"><a href="/bbs/maintennace/messageList.do">정비사례</a></li>
<%--                 <li class="${boardVO.boardKey=='shopmarket'?'on':'' }"><a href="/bbs/shopmarket/messageList.do">게시판 </a></li> --%>
                <li class="${boardVO.boardKey=='complain'?'on':'' }"><a href="/bbs/complain/messageList.do">하소연</a></li>
                <li class="${boardVO.boardKey=='company1'?'on':'' }"><a href="/bbs/company1/messageList.do">업체리스트</a></li>
                <li class="${boardVO.boardKey=='company2'?'on':'' }"><a href="/bbs/company2/messageList.do">정비외 업체리스트</a></li>
                <li class="${boardVO.boardKey=='partsmarket'?'on':'' }"><a href="/bbs/partsmarket/messageList.do">중고부품 매매</a></li>

            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"></p>
                <dl class="event">
                    <dt>안내</dt>
                    <dd>카색은 자동차정비소와 고객을 하나로 연결하는 네트워크입니다.</dd>
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