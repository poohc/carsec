<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
      <p style="font-size:16px; font-weight:bold; letter-spacing:-1px; border-bottom:2px solid #ef3125; padding-bottom:10px;">회원님의 차량의 문제점을 선택하시면 셀프점검 페이지로 이동합니다.</p><br><br><br>
      <ul class="icon_go">
      <c:forEach items="${list }" var="i" varStatus="iStatus">
          <li><a href="check2.do?gcode=${i.gcode }&qcode=${i.qcode}&qcodeNextLength=${i.qcodeNextLength}"><img src="/img/icon_${fn:substring(i.gcode,2,4) }.png">${i.qcodeTitle }</a></li>
      </c:forEach>
      </ul>
</body>
</html>