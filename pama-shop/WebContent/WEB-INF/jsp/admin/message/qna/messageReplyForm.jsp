<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="./messageRegister.do">
<input type="hidden" name="messageId" value="">
<input type="hidden" name="parentMessageId" value="${messageVO.parentMessageId == 0?messageVO.messageId:messageVO.parentMessageId}">
<input type="hidden" name="sortTree" value="${messageVO.sortTree }">

<div class="title">${boardVO.title } 답변</div>

<table class="detail">
    <colgroup>
        <col width="120px" />
        <col width="" />
    </colgroup>
    <tbody>

    <tr>
        <th colspan="2" align="center">질문</th>
    </tr>

    <tr>
        <th>제목</th>
        <td class="cl"><c:out value="${messageVO.title}" /></td>
    </tr>
    <tr>
        <th>내용</th>
        <td class="cl">
        <c:out escapeXml="false" value="${messageVO.contents}" />
        </td>
    </tr>

    <tr>
        <th colspan="2" align="center">답변</th>
    </tr>

    	<c:if test="${fn:length(messageCategoryList)>0}">
				<tr>
					<th scope="row">유형</th>
					<td><select name="messageCategoryId" required="required">
							<option value="">선택</option>
							<c:forEach items="${messageCategoryList}" var="i" varStatus="iStatus">
								<option value="${i.messageCategoryId}" ${messageVO.messageCategoryId==i.messageCategoryId?'selected':'' }>${i.messageCategoryName}</option>
							</c:forEach>
					</select></td>
				</tr>
			</c:if>

			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" class="required" minlength="4" maxlength="100" value="${messageVO.title }" style="width: 500px;" /></td>
			</tr>



			<tr>
				<th>내용</th>
				<td><textarea cols="80" id="contentsarea" name="contents" rows="10"></textarea>
				<script type="text/javascript">
                CKEDITOR.replace( 'contentsarea', {width:'100%',height: 400} );
            	</script>
            	</td>
			</tr>


    </tbody>

</table>

<div class="btn">
	<ul>
	    <li class="btnFl"><a href="javascript:goList('${ param.listReturnURL }');"><img src="/common/images/admin/btn/btn_list.gif" /></a></li>
		<li class="btnFr">
			<c:if test="${messageVO.varFiled1==1000}">
				${messageVO.varFiled1} 포인트차감체크 <input type="checkbox" name="pointInit" id="pointInit" value="${messageVO.varFiled1}" /></td>
			</c:if>
			<input type="image" src="/common/images/admin/btn/btn_answer.gif" />
			<a href="#;" onclick="messageForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
		</li>
	</ul>
</div>
</form>
</html>