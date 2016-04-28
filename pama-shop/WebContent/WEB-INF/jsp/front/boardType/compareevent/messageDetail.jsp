<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>
	<div class="event_layout2">
		<h1>${messageVO.title} </h1>
		<div class="compare vs1">
			<c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
				<c:if test="${i.showIndex==2}">
					<img src="/media/${i.fileName}.image" width="232px" />
				</c:if>
			</c:forEach>

			<p class="red_name">${messageVO.varFiled1 }</p>
			<dl class="spec">
				<dt>제 원</dt>
				<dd>${messageVO.varFiled2 }</dd>
			</dl>
			<dl class="performance">
				<dt>성 능</dt>
				<dd>${messageVO.varFiled3 }</dd>
			</dl>

			<c:forEach items="${messageCommentListEventAA.messageCommentList }" var="i" varStatus="iStatus"  begin="0" end="4">
			<dl class="comment_view">
				<dt>
					${i.registerName }
					<p>
						추천 : <span>${i.recommendCount }</span>
					</p>
					<c:if test="${iStatus.first }"><em class="best"><img src="/img/best.png" alt="best"></em></c:if>
				</dt>
				<dd>
					<c:out value="${i.comments }" escapeXml="false"/>
					<input type="button" class="refer" value="추천" onclick="javascript:messageCommentRecommend('${i.commentId }');" />
				</dd>
			</dl>
		</c:forEach>

		</div>


		<div class="compare vs2">

			<c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
				<c:if test="${i.showIndex==3}">
					<img src="/media/${i.fileName}.image" width="257px" />
				</c:if>
			</c:forEach>

			<p class="red_name">${messageVO.varFiled5 }</p>
			<dl class="spec">
				<dt>제원</dt>
				<dd>${messageVO.varFiled6 }</dd>
			</dl>
			<dl class="performance">
				<dt>성 능</dt>
				<dd>${messageVO.varFiled7 }</dd>
			</dl>

		<c:forEach items="${messageCommentListEventBB.messageCommentList }" var="i" varStatus="iStatus" begin="0" end="4">
			<dl class="comment_view">
				<dt>
					${i.registerName }
					<p>
						추천 : <span>${i.recommendCount }</span>
					</p>
					<c:if test="${iStatus.index==0 }"><em class="best"><img src="/img/best.png" alt="best"></em></c:if>
				</dt>
				<dd>
					<c:out value="${i.comments }" escapeXml="false"/>
					<input type="button" class="refer" value="추천" onclick="javascript:messageCommentRecommend('${i.commentId }');" />
				</dd>
			</dl>
		</c:forEach>


		</div>
	</div>

<c:if test="${isLogin }">


<c:choose>
<c:when test="${sessionVO.level != 10}">
<script>
function messageCommentRegister(form) {
	alert("일반회원만 참여가능합니다.");
	return;
}
</script>
</c:when>

<c:when test="${messageCommentRegisterIdCount>0}">
<script>
function messageCommentRegister(form) {
	alert("이미 참여하셨습니다.");
	return;
}
</script>
</c:when>

<c:otherwise>
<script>
function messageCommentRegister(form) {
	if(!$("input[name=title]").is(':checked')){
		alert("차량을 선택하세요.");
		return;
	}


	if(form.comments.value==""){
		alert("댓글을 입력하세요!");
		form.comments.focus();
		return;
	}
	form.submit();
}
</script>
</c:otherwise>
</c:choose>

<c:choose>
<c:when test = "${recommendYN=='Y' }">
<script>
function messageCommentRecommend(commentId) {
	alert("이미 추천 하였습니다.");
}
</script>
</c:when>
<c:otherwise>
<script>
function messageCommentRecommend(commentId) {
	form = document.messageCommentRecommendForm;
	form.commentId.value=commentId;
	form.submit();
}
</script>
</c:otherwise>
</c:choose>

</c:if>
<c:if test="${!isLogin }">
<script>
function messageCommentRegister(form) {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}
function messageCommentRecommend(commentId) {
	if(confirm("로그인후 이용하세요.\n로그인페이지로 이동하시겠습니까?")){
		location.href="${loginFormReturnURL}";
	}
}
</script>
</c:if>
	<form name="messageCommentRecommendForm" method="post" action="messageCommentRecommend.do">
		<input type="hidden" name="messageId" value="${messageVO.messageId }">
		<input type="hidden" name="commentId" value="">
		<input type="hidden" name="returnUrl" value="${currentURL }" />
	</form>

	<form name="messageCommentForm" method="post" action="messageCommentRegister.do">
		<input type="hidden" name="messageId" value="${messageVO.messageId }">
		<input type="hidden" name="returnUrl" value="${currentURL }" />

		<fieldset class="event_comment">
			<legend class="blind">댓글남기기</legend>
			<label class="radio_type2" for="input_radio01"><input id="input_radio01" type="radio" name="title" value="AA" >${messageVO.varFiled1 }</label>
		    <label class="radio_type2" for="input_radio02"><input id="input_radio02" type="radio" name="title" value="BB" >${messageVO.varFiled5 }</label>
			<p>
				댓글 남기기 200자  <!-- <span>0</span>/ -->
			</p>
			<textarea class="first_comm" title="제목/내용" rows="3" cols="30" maxlength="200" id="comment" name="comments"></textarea>
			<button type="button" title="등록" class="btn_search" onclick="messageCommentRegister(this.form);">응모</button>
		</fieldset>
	</form>


	<div class="center_box">
		<a href="#;" onclick="javascript:location.href='messageList.do'" class="btn_type1">목 록</a>
	</div>
</body>
</html>