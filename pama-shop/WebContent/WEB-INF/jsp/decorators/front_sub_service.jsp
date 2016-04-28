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
                <li class="${fn:startsWith(currentURI, '/check/check')?'on':'' }"><a href="/check/check1.do">내차SELF 점검</a></li>
                <li class="${fn:startsWith(currentURI, '/check/caritemmap')?'on':'' }"><a href="/check/caritemmap.do">차량부품Map</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/caritemmap')?'on':'' }"><a href="/bbs/caritemmap/messageList.do">차량부품목록</a></li>
                <li class="${fn:startsWith(currentURI, '/bbs/company3')?'on':'' }"><a href="/bbs/company3/messageList.do">지역별 업체검색</a></li>
            </ul>
            <div class="start_selfservice">

			<c:if test="${fn:startsWith(requestURI,'/check/check') == false}">
               <dl class="event">
                    <dt>이벤트 공지</dt>
                 <c:forEach items="${randomNotice }" var="i" varStatus="iStatus" begin="0" end="0">
                 	<dd onclick="randomNotice('${i.boardKey}','${i.messageId}')">${i.title}</dd>
                 </c:forEach>
                </dl>
			</c:if>

            	<decorator:body />
            </div>
        </div>
        <div class="rnb">
            <jsp:include page="/WEB-INF/jsp/decorators/front_include_login.jsp" />


            <div class="epilogue_banner"><a href="#"><i class="fa fa-pencil-square-o"></i>카색 정비채널</a></div>

            <!--<ul class="use_epilogue">-->
    			<!--<c:forEach items="${aspectusereviews }" var="i" varStatus="iStatus">-->
                   <!--<li><a href="/bbs/${i.boardKey }/messageDetail.do?messageId=${i.messageId }">${i.title }</a></li>-->
                <!--</c:forEach>-->
            <!--</ul>-->
            <ul class="use_epilogue">
            	<li><iframe width=100% height=100% src="https://www.youtube.com/embed/AWq5AYW7UQI" frameborder="0" allowfullscreen></iframe></li>
            	<li><iframe width=100% height=100% src="https://www.youtube.com/embed/e2erNy2YPSU" frameborder="0" allowfullscreen></iframe></li>
            </ul>
            <div class="epilogue_banner event_intro"><a href="#"><i class="fa fa-pencil-square-o"></i> 안내</a></div>
            <ul class="use_epilogue type2">
            	<c:forEach items="${aspectnotice4 }" var="i" varStatus="iStatus">
                   <li><a href="/bbs/${i.boardKey }/messageDetail.do?messageId=${i.messageId }">${i.title }</a></li>
                </c:forEach>
            </ul>

        </div>

        <c:if test="${fn:startsWith(requestURI,'/check/check')}">


		<c:if test="${!isLogin }">
					<br />
					<br />
					<br />
		</c:if>


        <div class="event_search2">
            <dl class="event">
                <dt>이벤트 공지</dt>
				<c:forEach items="${randomNotice }" var="i" varStatus="iStatus" begin="0" end="0">
                 	<dd onclick="randomNotice('${i.boardKey}','${i.messageId}')">${i.title}</dd>
                 </c:forEach>
            </dl>
        </div>
        </c:if>
    </div>

<page:applyDecorator page="/WEB-INF/jsp/decorators/front_footer.jsp" name="panel" />

</body>

</body>
</html>
