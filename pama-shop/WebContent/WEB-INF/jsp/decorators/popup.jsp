<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><decorator:title default="SIX"></decorator:title></title>
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" charset="UTF-8" media="all" />

<script src="/common/js/jquery/jquery.js"   type="text/javascript" charset="UTF-8"></script>
<decorator:head />
</head>

<body onload="<decorator:getProperty property="body.onload" />" onFocus="<decorator:getProperty property="body.onFocus" />">

<div id="wrapper">
	<decorator:body/>
</div>

</body>
</html>