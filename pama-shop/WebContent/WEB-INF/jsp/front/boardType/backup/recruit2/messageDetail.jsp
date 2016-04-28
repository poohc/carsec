<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>
	<ul class="recuit_list">
		<li class="type1">${messageVO.varFiled1}</li>
		<li class="type2">${messageVO.varFiled4}</li>
		<li class="type3">${messageVO.varFiled3}</li>
		<li class="type4">${messageVO.varFiled2}</li>
		<li class="type5">${fn:substring(messageVO.registerDate, 0, 10)}</li>
	</ul>
	<div class="recruit_detail">
		${messageVO.contents}
	</div>
	<a href="#;" onclick="javascript:location.href='messageList.do'" class="input_type6 align_center w_57">목 록</a>
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

</body>
</html>