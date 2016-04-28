<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>
	<img src="/img/bullet/bullet_recruit.png"/>
	<ul class="recuit_list">
		<li class="type1">${fn:substring(messageVO.registerDate, 0, 10)}</li>
		<li class="type1">${messageVO.varFiled1}</li>
		<li class="type1">${messageVO.varFiled2}</li>
		<li class="type1">${messageVO.varFiled3}</li>
		<li class="type1">${messageVO.varFiled4}</li>
		<li class="type1">${messageVO.varFiled8}</li>
	</ul>
	<div class="recruit_detail">${messageVO.contents}</div>


	<div class="center_box">
	<a href="#;" onclick="javascript:location.href='messageList.do'" class="btn_type1">목 록</a>

	<c:if test="${messageVO.registerId==sessionVO.mbrId }">
		<a href="#;" onclick="javascript:modifyMessage();" class="btn_type1">수 정</a>&nbsp;&nbsp;
		<a href="#;" onclick="javascript:removeMessage();" class="btn_type1">삭 제</a>
		<script type="text/javascript">
		function removeMessage(){
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href='./messageRemoveProc.do?messageId=${messageVO.messageId }';
			}
		}
		function modifyMessage(){
			location.href='./messageForm.do?messageId=${messageVO.messageId }';
		}
		</script>
	</c:if>
	</div>

</body>
</html>