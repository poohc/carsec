<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
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
						<p class="gall_text">${messageVO.contents}</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- //board_view -->
	<div class="comment">
		<a href="#" class="kakaotalk"><img src="/img/kakaotalk.jpg" alt="카카오톡"></a> <a href="#" class="facebook"><img src="/img/facebook.jpg" alt="페이스북"></a>
		<p class="p_comment">- 댓 글 -</p>
		<form action="library1.do">
			<ul class="comment_list">
				<li class="need_login"><textarea name="comment" placeholder="댓글 작성을 위해 로그인 해주세요." id="comment" cols="30" rows="10" title="제목/내용" value="댓글 작성을 위해 로그인 해주세요." class="first_comm"></textarea>
					<button type="submit" class="btn_search" title="등록">등록</button></li>
				<li class="opinion">
					<p class="member_num">
						회원1 <span class="the_date">2015.07.07</span>
					</p>
					<p class="mem_cont">저도 궁금한 점이 있는데... 여기는 힌트기능 넣어주세요.</p>
					<button type="submit" class="comm_btn">
						답글 <em>1</em><span></span>
					</button>
				</li>
				<li class="need_opinion">
					<p class="member_num">
						회원1 <span class="the_date">2015.07.07</span>
					</p>
					<p class="mem_cont">저도 궁금한 점이 있는데... 여기는 힌트기능 넣어주세요.</p>
					<button type="submit" class="comm_btn">답글쓰기</button> <textarea name="comment" id="comment" placeholder="댓글 작성을 위해 로그인 해주세요." cols="30" rows="10" title="제목/내용" class="first_comm"></textarea>
					<button type="submit" class="btn_search" title="등록">등록</button>
					<div class="paging">
						<!-- paging -->
						<a href="#" class="prev">이전</a> <a href="#" class="on">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#" class="next">다음</a>
					</div>
				</li>
			</ul>
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

		</form>
	</div>

</body>
</html>