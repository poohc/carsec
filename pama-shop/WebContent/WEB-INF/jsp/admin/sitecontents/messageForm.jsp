<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.validate.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/pama.message.action.js" charset="utf-8"></script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${siteContentVO!=null && siteContentListVO.contentId!=''?'./messageModify.do':'./messageRegister.do'}">
	<input type="hidden" name="contentId" value="${siteContentVO.contentId }">

	<div class="title">SiteContents ${siteContentVO!=null && siteContentVO.contentId!=''?'수정':'입력'}</div>

	<table class="contents">

		<colgroup>
			<col width="120px" />
			<col width="" />
		</colgroup>

		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="contentKey" id="title" class="required" minlength="4" maxlength="100" value="${siteContentVO.contentKey }" style="width: 590px;" /></td>
			</tr>

			<tr>
				<th>내용</th>
				<td><textarea cols="80" id="contentsarea" name="contents" rows="10">${siteContentVO.contents }</textarea>
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