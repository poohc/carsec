<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>

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
							<li>${messageVO.registerNickname}</li>
							<li>${fn:substring(messageVO.registerDate, 0, 10)}</li>
						</ul>
					</td>
				</tr>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="3" class="text">
						<p class="gall_text">${messageVO.contents}</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- //board_view -->
			<!-- Comment -->
			<jsp:include page="/WEB-INF/jsp/front/boardType/_include/comment_include.jsp" />
			<!-- Comment -->
			<div class="center_box">
				<a href="#;" onclick="javascript:location.href='messageList.do'" class="btn_type1">목 록</a>
			</div>

		</form>

</body>
</html>