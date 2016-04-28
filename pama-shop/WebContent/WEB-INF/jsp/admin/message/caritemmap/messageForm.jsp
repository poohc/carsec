<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}" enctype="multipart/form-data">
	<input type="hidden" name="messageId" value="${messageVO.messageId }">
	<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
	<input type="hidden" name="topFlag" value="0" />
	<input type="hidden" name="statusType" value="2" />
	<input type="hidden" name="contents" value="-" />

	<div class="title">${boardVO.title } ${messageVO!=null && messageVO.messageId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="" />
		</colgroup>

		<tbody>

			<tr>
				<th>부품명</th>
				<td><input type="text" name="title" id="title" class="required" minlength="1" maxlength="80" value="${messageVO.title }" style="width: 200px;" /></td>
			</tr>

			<tr>
				<th>부품명(영문)</th>
				<td><input type="text" name="subTitle" id="subTitle" maxlength="80" value="${messageVO.subTitle }" style="width: 200px;" /></td>
			</tr>


			<c:if test="${fn:length(messageCategoryList)>0}">
				<tr>
					<th scope="row">부품위치</th>
					<td><select name="messageCategoryId" required="required">
							<option value="">선택</option>
							<c:forEach items="${messageCategoryList}" var="i" varStatus="iStatus">
								<option value="${i.messageCategoryId}" ${messageVO.messageCategoryId==i.messageCategoryId?'selected':'' }>${i.messageCategoryName}</option>
							</c:forEach>
					</select></td>
				</tr>
			</c:if>

			<tr>
				<th>부품설명</th>
				<td><textarea name="summaryContents" id="summaryContents" class="required" minlength="4" maxlength="300"  style="width: 590px;height: 60px;">${messageVO.summaryContents }</textarea></td>
			</tr>

			<tr>
				<th>장착위치</th>
				<td><input type="text" name="varFiled1" id="varFiled1" class="required" minlength="4" maxlength="100" value="${messageVO.varFiled1 }" style="width: 590px;" /></td>
			</tr>

			 <tr>
		        <th>차량사진</th>
		        <td colspan="2">
			        <input type="file" name="showFile1" id="showFile1" width="120px" /> <br /><br />
		            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==1}">
							<div id="img_${i.fileName}"><img src="/media/${i.fileName}.image" width="200px"/> ${i.displayName} <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
						</c:if>
		            </c:forEach>
		        </td>
 		    </tr>

 		    <tr>
		        <th>부품사진</th>
		        <td colspan="2">
			        <input type="file" name="showFile2" id="showFile2" width="120px" /> <br /><br />
		            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==2}">
							<div id="img_${i.fileName}"><img src="/media/${i.fileName}.image" width="200px"/> ${i.displayName} <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
						</c:if>
		            </c:forEach>
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