<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%-- ##################### CommentStart ################### --%>
<c:if test="${isLogin }">
<script>
function messageCommentRegister(form) {
	if(form.comments.value==""){
		alert("댓글을 입력하세요!");
		form.comments.focus();
		return;
	}
	form.submit();
}
</script>
</c:if>
<c:if test="${!isLogin }">
<script>
function messageCommentRegister(form) {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";//+encodeURIComponent("&#"+form.name)
	}
}
</script>
</c:if>

<c:if test="${isLogin }">
<script>
$().ready(function(){
	$("button#commentReplyButton").click(function(){
		buttonOBJ = $(this);
		commentId = buttonOBJ.attr("value");
		$("#commentReply_"+commentId).toggle();
	});

});
</script>
</c:if>

<c:if test="${!isLogin }">
<script>
$().ready(function(){

	$("button#commentReplyButton").click(function(){
		if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
			location.href="${loginFormReturnURL}";//+encodeURIComponent("&#commentReplyLoation"+$(this).attr("value"));
		}
	});

});

</script>
</c:if>
	<!-- //board_view -->
	<div class="comment">
	    <a href="#" class="kakaotalk"><img src="/img/facebook.jpg" alt="페이스북"></a>
<!-- 		<a href="#" class="kakaotalk"><img src="/img/kakaotalk.jpg" alt="카카오톡"></a> -->
		<p class="p_comment" id="messageCommentForm">- 댓 글 -</p>

			<ul class="comment_list">
				<form  name="messageCommentForm" id="dataForm" class="dataForm" method="post" action="messageCommentRegister.do">
				<li class="need_login">
				<input type="hidden" name="messageId" value="${messageVO.messageId }" />
				<input type="hidden" name="returnUrl" value="${currentURL }" />
				<textarea name="comments" <c:if test="${!isLogin }">placeholder="댓글 작성을 위해 로그인 해주세요."</c:if> <c:if test="${isLogin }">placeholder="댓글 작성해주세요."</c:if> id="comment" cols="30" rows="10" title="제목/내용"  class="first_comm" required="required"></textarea>
				<button type="button" class="btn_search" title="등록" onclick="javascript:messageCommentRegister(this.form);">등록</button></li>
				</form>

			<c:forEach items="${messageCommentList.messageCommentList }" var="i" varStatus="iStatus">
				<li class="${(fn:length(i.sortTree)-1)/5>1?'need_opinion':'opinion' }" id="commentReplyLoation${i.commentId }">
					<p class="member_num">
						${i.registerName }  <span class="the_date">&nbsp;${fn:substring(i.registerDate,0,10)}</span>
					</p>
					<p class="mem_cont"><c:out value="${i.comments }" escapeXml="false"/></p>
					<button id="commentReplyButton" type="submit" class="comm_btn" value="${i.commentId }">답글</button>
					<div id="commentReply_${i.commentId }" style="width: 100%; text-align: right; display: none;"><br/>
					<form name="messageCommentReplayForm_${i.commentId }" class="dataForm" method="post" action="messageCommentRegister.do">
						<input type="hidden" name="commentId" value="${i.commentId }" />
						<input type="hidden" name="messageId" value="${messageVO.messageId }" />
						<input type="hidden" name="sortTree" value="${i.sortTree }" />
						<input type="hidden" name="returnUrl" value="${currentURL }" />
						<textarea name="comments" id="comment" placeholder="댓글 작성해주세요." cols="30" rows="10" title="제목/내용" class="first_comm" style="width: 500px"></textarea>
						<button type="button" class="btn_search" title="등록" onclick="javascript:messageCommentRegister(this.form);">등록</button>
					</form>
					</div>
				</li>
			</c:forEach>
<%--
<!-- 				<li > -->
<!-- 					<div class="paging"> -->
<!-- 						<a href="#" class="prev">이전</a> <a href="#" class="on">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#" class="next">다음</a> -->
<!-- 					</div> -->
<!-- 				</li> -->
 --%>
			</ul>
	</div>
<%-- ##################### CommentStart ################### --%>