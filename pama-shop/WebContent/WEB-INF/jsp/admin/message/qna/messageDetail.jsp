<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript">
//<![CDATA[
//goForm
function goMessageForm(id){
    var form = document.messageForm;
    form.messageId.value = id;
    form.action="./messageForm.do";
    form.method="GET";
    form.submit();
}

//goReplyForm
function goMessageReplyForm(){
    var form = document.messageReplyForm;
    form.action="./messageReplyForm.do";
    form.submit();
}

//RemoveProc
function goMessageRemoveProc(id){
    var form = document.messageForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.messageId.value=id;
    	form.action="./messageRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}

function messageAttachmentDelete(attachmentId) {
    var form = document.messageAttachmentForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.attachmentId.value = attachmentId;
    	form.action="./messageRemoveProc.do";
    	form.method="post";
        form.submit();
    }
}

//goList
function goList() {
	location.href="${fn:length(param.listReturnURL)>0 ? param.listReturnURL:'messageList.do'}";
}
//]]>
</script>
</head>

<form name="messageForm" method="get" autocomplete="off">
	<input type="hidden" name="messageId" value="">
</form>

<form name="messageReplyForm" method="get">
	<input type="hidden" name="messageId" value="${messageVO.messageId}">
	<input type="hidden" name="sortTree" value="${messageVO.sortTree}">
	<input type="hidden" name="parentMessageId" value="${messageVO.parentMessageId}" />
</form>

<form name="messageAttachmentForm" method="post">
	<input type="hidden" name="messageId" value="${messageVO.messageId }"> <input type="hidden" name="attachmentId" value="">
</form>

<div class="title">${boardVO.title }</div>

<table class="detail">

	<colgroup>
		<col width="120px" />
		<col width="" />
	</colgroup>

	<tbody>

		<tr>
			<th>제목</th>
			<td class="cl"><c:out value="${messageVO.title}" /></td>
		</tr>

		<tr>
			<th>내용</th>
			<td class="cl"><c:out escapeXml="false" value="${messageVO.contents}" /></td>
		</tr>
	</tbody>

</table>

<div class="btn">
	<ul>
		<li class="btnFl"><a href="javascript:goList();"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
		<li class="btnFr">
			<a href="javascript:goMessageReplyForm();"><img src="/common/images/admin/btn/btn_answer.gif" /></a>
			<a href="javascript:goMessageForm('${messageVO.messageId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a>
			<a href="javascript:goMessageRemoveProc(${messageVO.messageId});"><img src="/common/images/admin/btn/btn_delete.gif" /></a>
		</li>
	</ul>
	<div style="clear: both"></div>
</div>

</html>




