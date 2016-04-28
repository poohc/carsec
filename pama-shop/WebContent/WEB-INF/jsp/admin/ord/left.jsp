<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<dl id="leftMenu">
	<dt>주문관리</dt>
	<dd><a href="/admin/ord/orderList.do">주문전체</a></dd>
	<dd><a href="/admin/ord/orderList.do?statusType=10">입금대기</a></dd>
	<dd><a href="/admin/ord/orderList.do?statusType=11">결제완료</a></dd>
	<dd><a href="/admin/ord/orderList.do?statusType=90">주문취소</a></dd>
</dl>
