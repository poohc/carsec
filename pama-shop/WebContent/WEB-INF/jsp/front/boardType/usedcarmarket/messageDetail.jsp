<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript">
	$(document).ready(function(){

	});
</script>

</head>
<body>
	<img src="/img/bullet/bullet_used.png"/>
	<div class="usedcar_view">
		<h1>${messageVO.title}</h1>
		<p class="writed_date">
			등록일 : <span>${fn:substring(messageVO.registerDate, 0, 10)}</span>
		</p>
		<ul class="mb_20">
			<li>제조사 : ${messageVO.varFiled1}</li>
			<li>모델 : ${messageVO.varFiled2}</li>
			<li>연식 : ${messageVO.varFiled3}</li>
			<li>주행거리 : ${messageVO.varFiled4}</li>
			<li>가격 : ${messageVO.varFiled5}</li>
			<li>색상 : ${messageVO.varFiled6}</li>
			<li>사고여부 : ${messageVO.varFiled7=='Y'?'예':'아니오'}</li>
		</ul>
		<p class="detail_pic">상세사진</p>
		<div class="img_gallery">
			<div class="pic">

				<c:forEach items="${messageVO.attachmentList }" var="i" varStatus="iStatus">
					<img src="/media/${i.fileName }.image" alt="" width="598" height="398">
				</c:forEach>
			</div>
			<div class="thum">
				<c:forEach items="${messageVO.attachmentList }" var="i" varStatus="iStatus">
					<img src="/media/${i.fileName }.image" alt="" width="168" height="98">
				</c:forEach>

			</div>
		</div>
		<dl class="detail_info">
			<dt>상세설명</dt>
			<dd>${messageVO.summaryContents}</dd>
		</dl>
		<dl class="detail_info2">
			<dt>매매자 정보</dt>
			<dd>${messageVO.registerName}</dd>
			<dd>${messageVO.varFiled8}</dd>
		</dl>
	</div>
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

	<script>
$(".img_gallery .thum img").click(function(){
    var ti = $(this).index();
    $(".img_gallery .pic img").not(":eq("+ti+")").removeClass("ch").fadeOut(300);
    $(".img_gallery .pic img").eq(ti).addClass("ch").fadeIn(300);
    $(".img_gallery .thum img").not(":eq("+ti+")").removeClass("ch1");
    $(".img_gallery .thum img").eq(ti).addClass("ch1");
}).eq(0).click();
</script>
</body>
</html>