<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
	<input type="hidden" name="messageId" value="${messageVO.messageId }">
	<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
	<input type="hidden" name="topFlag" value="0" />
	<input type="hidden" name="statusType" value="2" />

	<div class="title">${boardVO.title } ${messageVO!=null && messageVO.messageId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="" />
		</colgroup>

		<tbody>

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
				<td><input type="text" name="title" id="title" class="required" minlength="4" maxlength="100" value="${messageVO.title }" style="width: 590px;" /></td>
			</tr>

			<tr>
				<th>내용</th>
				<td><textarea cols="80" id="contentsarea" name="contents" rows="10">${messageVO.contents }</textarea>
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
				<input type="image" src="/common/images/admin/btn/btn_save.gif" />
				<a href="#;" onclick="messageForm.reset();"><img src="/common/images/admin/btn/btn_reload.gif" /></a>
			</li>
		</ul>
	</div>
</form>
</html>