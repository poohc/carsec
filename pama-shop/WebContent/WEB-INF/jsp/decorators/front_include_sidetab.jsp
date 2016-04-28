<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
     <div id="sidetab">
            <ul class="sidetab">
                <li><a href="/check/check1.do">카섹의<span>셀프점검</span></a></li>
                <li><a href="/check/caritemmap.do">자동차의<span>모든부품정보</span></a></li>
            </ul>
     </div>
     <c:if test="${isLogin && sessionVO.level==10 }">
        <div id="sidetab2">
            <p class="point_title">워셔액포인트</p>
            <p class="point_title2">${mbrDbVO.accPoint }</p>
            <p class="point_title3">게시판에 댓글을 남기면 <span>워셔액 포인트</span>를 드립니다.
            <c:if test="${mbrDbVO.accPoint>=1000 }">
            <br /><a href="/bbs/qna/messageForm.do?point=1000"><strong>[워셔액 받기]</strong></a>
            </c:if>
            <c:if test="${mbrDbVO.accPoint<1000 }">
            <br /><a href="#;" onclick="javascript:alert('1000포인트가 되셔야 이용가능합니다.');"><strong>[워셔액 받기]</strong></a>
            </c:if>
            </p>
        </div>
     </c:if>




