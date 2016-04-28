<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>
	<img src="/img/bullet/bullet_1.png"/>
	<div class="board_view">
		<!-- board_view -->
		<table>
			<caption>게시판 읽기</caption>
			<colgroup>
				<col style="width: 5%" />
				<col style="width: 10%" />
				<col style="width: auto%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col" colspan="3">
						<p class="t_title">${messageVO.title}</p>
					</th>
				<tr>
					<td colspan="3">
						<ul class="view_list">
							<li>${boardVO.title }</li>
							<li>${fn:substring(messageVO.registerDate, 0, 10)}</li>
						</ul>
					</td>
				</tr>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td colspan="3" class="author">${messageVO.registerNickname}</td>
				</tr>
				<tr>
					<td colspan="3" class="text">
						<p id="contentsarea" class="gall_text">${messageVO.contents}</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

			<!-- Comment -->
			<jsp:include page="/WEB-INF/jsp/front/boardType/_include/comment_include.jsp" />
			<!-- Comment -->


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
