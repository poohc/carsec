<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<div class="winning_box">
    <img src="/img/winning.jpg" alt="">
    <div class="winning_list">
    	<img src="/img/bullet/event.png"/>
        <p>당첨자 리스트</p>
        <ul>
            <li>${messageVO.contents }</li>
        </ul>
    </div>
</div>