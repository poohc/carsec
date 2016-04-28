<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>

	<div class="usedcar_view">
		<h1>
			<p class="t_title">${messageVO.title}</p>
		</h1>
		<p class="writed_date">
			등록일 : <span>${fn:substring(messageVO.registerDate, 0, 10)}</span>
		</p>
		<ul class="mb_20">
			<li>지역: ${messageVO.varFiled1}</li>
			<li>현업종 : ${messageVO.varFiled5}</li>
			<li>보증금 : ${messageVO.varFiled2}</li>
			<li>월세 : ${messageVO.varFiled3}</li>
			<li>권리금 : ${messageVO.varFiled4}</li>
		</ul>
		<p class="text_type1">${messageVO.summaryContents}</p>
	</div>
	<a href="#;" onclick="javascript:location.href='messageList.do'" class="input_type6 align_center w_100">목 록</a>
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