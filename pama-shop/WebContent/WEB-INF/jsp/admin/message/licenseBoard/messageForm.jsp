<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
</head>

<form name="messageAttachmentForm" method="post">
<input type="hidden" name="boardId" value="${boardVO.boardId}">
<input type="hidden" name="messageId" value="${messageVO.messageId}">
<input type="hidden" name="attachmentId" value="">
</form>
<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}"  enctype="multipart/form-data">
<input type="hidden" name="boardId" value="${boardVO.boardId }">
<input type="hidden" name="messageId" value="${messageVO.messageId }">
<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
<input type="hidden" name="topFlag" value="0" />
<input type="hidden" name="licenseType" value="${fn:endsWith(boardVO.boardKey,'license')?'1':'0' }" />


<div class="title">${boardVO.title }</div>

<table class="contents">

    <colgroup>
        <col width="120px" />
        <col width="" />
    </colgroup>

    <tbody>


	<c:if test="${fn:length(messageCategoryList)>0}">
		    <tr>
		        <th scope="row">분류</th>
		        <td>
		            <select name="messageCategoryId">
		               <option value="">선택</option>
		               <c:forEach items="${messageCategoryList}" var="i" varStatus="iStatus">
		               <option value="${i.messageCategoryId}" ${messageVO.messageCategoryId==i.messageCategoryId?'selected':'' }>${i.messageCategoryName}</option>
		               </c:forEach>
		            </select>
		        </td>
		    </tr>
	</c:if>

    <tr>
        <th>부제목</th>
        <td>
			<input type="text" name="subTitle" id="subTitle"  class="required" value="${messageVO.subTitle}" disabled="disabled"/>
						<input type="checkbox" name="subTitleSW" id="subTitleSW" onclick="subTitleSWF()" />
						<script type="text/javascript">
						function subTitleSWF(){
							$('#subTitle').attr("disabled", !$("#subTitleSW").is(':checked') );
						}
						</script>
			<c:if test="${fn:endsWith(boardVO.boardKey,'license')}">
			유료포인트 <input type="text" name="licensePoint" class="required" value="${messageVO.licensePoint}"  />
			</c:if>
        </td>
    </tr>

    <tr>
        <th>제목</th>
        <td>
        <input type="text" name="title" id="title" class="required" minlength="4" maxlength="100" value="${messageVO.title }" style="width:590px;" /></td>
    </tr>

  <tr>
        <th>첨부</th>
        <td>
	        <input type="file" name="showFile1" id="showFile1" width="120px" ${messageVO.attachmentList ==null?'required':''}/> <span id="fileModifyDesc">${messageVO.attachmentList !=null?'*수정하시려면 파일을 선택하시면 됩니다.<br /><br />':''}</span>
            <c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
            	<div id="img_${i.fileName}"> <a href="/admin/message/${boardVO.boardKey}/${messageVO.messageId}/download.do?fileName=${i.fileName}">${i.displayName}</a> <button type="button" onclick="javascript:removeAttachment('${i.fileName}');">삭제</button></div>
            </c:forEach>
        </td>
    </tr>

	<tr>
		<th>내용</th>
		<td><textarea cols="80" id="contentsarea" name="contents" rows="10">${messageVO.contents }</textarea>
		<script type="text/javascript">
              CKEDITOR.replace( 'contentsarea', {width:'100%',height: 400} );
        </script>
        </td>
	</tr>

    <tr>
        <th>활성여부</th>
        <td>
			<input type="radio" id="statusType" name="statusType" value="1"  ${empty messageVO.statusType || messageVO.statusType eq '1' ? 'checked':''}> 비활성
			<input type="radio" id="statusType" name="statusType" value="2"  ${messageVO.statusType eq '2' ? 'checked':''}> 활성
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