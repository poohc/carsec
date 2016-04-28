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
<!-- 	<input type="hidden" name="statusType" value="2" /> -->

	<div class="title">${boardVO.title } ${messageVO!=null && messageVO.messageId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="200px" />
			<col width="300px" />
		</colgroup>

		<tbody>

			<tr>
				<th>제목</th>
				<td colspan="2"><input type="text" name="title" id="title" class="required" minlength="4" maxlength="100" value="${messageVO.title }" style="width: 590px;" /></td>
			</tr>

			<tr>
				<th>이벤트기간</th>
				<td>
				<input type=text id="startDate" name="startDate" value="${messageVO.startDate }"> ~ <input type=text id="endDate" name="endDate" value="${messageVO.endDate }">
				</td>
				<td>
					<select class="select" id="statusType" name="statusType">
					<option value="1"<c:if test="${messageVO.statusType eq '' || messageVO.statusType eq '1'}"> selected="selected"</c:if>>대기</option>
					<option value="2"<c:if test="${messageVO.statusType eq '2'}"> selected="selected"</c:if>>게시</option></select>
				</td>
			</tr>

			 <tr>
		        <th> 이벤트이미지 </th>
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
		        <th> 1번차량 </th>
		        <td>
			        <input type="file" name="showFile2" id="showFile2" width="120px" /> <br /><br />
		            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==2}">
							<div id="img_${i.fileName}"><img src="/media/${i.fileName}.image" width="200px"/> ${i.displayName} <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
						</c:if>
		            </c:forEach>
		        </td>
		        <td>
			        이름 : <input type="text" name="varFiled1" id="varFiled1" style="width: 300px;" value="${messageVO.varFiled1 }"  /> <br /><br />
			        제원 : <textarea name="varFiled2" id="varFiled2" style="width: 300px;height: 100px;"  >${messageVO.varFiled2 }</textarea> <br /><br />
			        성능 : <textarea name="varFiled3" id="varFiled3" style="width: 300px;height: 100px;"  >${messageVO.varFiled3 }</textarea> <br />
		        </td>
		    </tr>


 		    <tr>
		        <th> 2번차량 </th>
		        <td>
			        <input type="file" name="showFile3" id="showFile3" width="120px" /><br /><br />
		            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==3}">
							<div id="img_${i.fileName}"><img src="/media/${i.fileName}.image" width="200px"/> ${i.displayName} <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
						</c:if>
		            </c:forEach>
		        </td>
      			<td>
			        이름 : <input    name="varFiled5" type="text"  id="varFiled5" style="width: 300px;"  value="${messageVO.varFiled5 }"/> <br /><br />
			        제원 : <textarea name="varFiled6" id="varFiled5" style="width: 300px;height: 100px;"  >${messageVO.varFiled6 }</textarea> <br /><br />
			        성능 : <textarea name="varFiled7" id="varFiled6" style="width: 300px;height: 100px;"  >${messageVO.varFiled7 }</textarea> <br />
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