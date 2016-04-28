<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<head>

<script type="text/javascript"  charset="utf-8">
$().ready(function() {
	$("#dataForm").validate({
    	rules: {
    		title: {
    			required: true
    		}
    	},
    	messages:{
    		title :{
    			required:"제목을 입력하세요."
    		}

    	},
    	submitHandler: function(form) {

    		ckeditEmptyInstace="";
			for ( instance in CKEDITOR.instances ){
				CKEDITOR.instances[instance].updateElement();
				editValue=$("#"+instance).val();
				if(editValue==""){
					ckeditEmptyInstace=instance;
					break;
				}
			}

			if(ckeditEmptyInstace != ""){
				alert("내용을 입력하세요.");
				CKEDITOR.instances[ckeditEmptyInstace].focus();
			}else{
				form.submit();
			}
    	}
    });
});
</script>

<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/contentUpload.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/fileUpload.js" charset="utf-8"></script>
<script type="text/javascript" src="/common/js/tag.js" charset="utf-8"></script>

<script type="text/javascript" src="/common/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript">
//<![CDATA[
function toAddFile() {
    window.open('/media/bbsImageContentMapping/uploadForm.do','imgform','width=350,height=200');
}

//isForms
function isForms(f) {
	return true;
}

//RemoveProc
function goMessageRemoveProc(){
    var form = document.messageForm;

    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="./messageRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}

function isAttachment(imageId) {
	$.getJSON('/admin/message/${boardVO.boardKey}/messageAttachmentDelete.json?imageId=' + imageId, function(data) {
		if (data.msgCode=="100") {
			removeAttachment(imageId);
		}
	});
}

function goCommentsRemoveProc() {
	var checkedQuery="input[name=checkedIds]:checked";
	var params = $("#commentForm").serialize();
	$.getJSON('/admin/message/${boardVO.boardKey}/removeMmessageComment.json', params, function(data) {
		if(data.msgCode=="100") {
			$(checkedQuery).each(function(i){
				//$( "#comment_"+$(this).val() ).hide( "explode", { percent: 0 }, 1000);
				$(  "#comment_"+$(this).val()  ).remove();
			});
		}
	});
}

//전체체크
function checkAll(){
    if(document.getElementById("allCheckBox").checked==true){
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=true;
        }
    }else{
        for(var i=0;i<document.getElementsByName("checkedIds").length;i++){
            document.getElementsByName("checkedIds")[i].checked=false;
        }
    }
}

//goList
function goList() {

<c:if test="${fn:length(param.listReturnURL)>0}">
	location.href="${param.listReturnURL}";
</c:if>

<c:if test="${fn:length(param.listReturnURL)==0}">
	location.href="./messageList.do?messageId=${messageVO.messageId}";
</c:if>
}


function setImageContentMapping(option) {

	filesImage=option["fileUploadType"];
	filesImage+="|"+option["fileName"];
	filesImage+="|"+option["originalFilename"];
	filesImage+="|"+option["fileSize"];
	filesImage+="|"+option["contentType"];
	filesImage+="|"+option["imageWidth"];
	filesImage+="|"+option["imageHeight"];

	if (option["contentType"].indexOf("image")<0) {
		$("#preview_uploaded_1").html("");
	} else {
		$("#preview_uploaded_1").html("<img src='"+option["filePath"]+"' width='1000px' />");
	}
	sumfileSize = parseInt(sumfileSize) + parseInt(option["fileSize"]);
	$("#files").val(filesImage);

}

//]]>
</script>
<script type="text/javascript">
	$(function(){
		// Datepicker
		$('#registerDate').datepicker({
			inline: true,
			dateFormat: 'yy-mm-dd'
		});
	});
</script>
</head>

<form name="messageForm" id="dataForm" class="dataForm" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
<input type="hidden" name="boardId" value="${boardVO.boardId }">
<input type="hidden" name="messageId" value="${messageVO.messageId }">
<input type="hidden" name="sortTree" value="${messageVO.sortTree }">
<input type="hidden" name="licenseType" value="0"/>
<input type="hidden" name="contents"  value="${messageVO.contents }" />
<input type="hidden" name="thumbnailUrl" id="thumbnailUrl" value="${messageVO.thumbnailUrl}" />
<input type="hidden" name="files" id="files" value="" />
<input type="hidden" name="title" value="${messageVO.title }"  />
<input type="hidden" name="statusType" value="2"/>

<div class="title">${messageVO.title }</div>

<table class="contents">

    <colgroup>
        <col width="600px" />
    </colgroup>

    <tbody>

    <tr>
        <td width="600px">
        <button type="button" onclick="toAddFile();">이미지 컨텐츠 첨부</button>
        <button type="button" onclick="messageForm.submit()">저장</button>
        <br/><br/>
			<div id="preview_uploaded_1"   style="width: 1000px;background: rgb(153, 153, 153);  text-align: center;border: 1px solid black;"></div>
        </td>
    </tr>


<!--     <tr> -->
<!--         <th>게시물상태</th> -->
<!--         <td> -->
<!-- 			<select class="select" id="statusType" name="statusType"> -->
<%-- 			<option value="1"<c:if test="${messageVO.statusType eq '' || messageVO.statusType eq '1'}"> selected="selected"</c:if>>대기</option> --%>
<%-- 			<option value="2"<c:if test="${messageVO.statusType eq '2'}"> selected="selected"</c:if>>게재</option> --%>
<!-- 			</select> -->
<!--         </td> -->
<!--     </tr> -->
    </tbody>

</table>
</form>


<h3>Comments</h3>
<form name="commentForm" id="commentForm" >
<input type="hidden" name="returnUrl" value="${currentURL }" />
<input type="hidden" name="messageId" value="${messageVO.messageId }">
<button type="button" onclick="goCommentsRemoveProc();">삭제</button><br />
<table class="comments" >

    <colgroup>
        <col width="10%" />
        <col width=""></col>
        <col width="10%"></col>
        <col width="10%"></col>
    </colgroup>

    <thead>
        <tr>
            <th class="first"><input type="checkbox" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />All</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
        </tr>
    </thead>

    <tbody>

    	<c:forEach items="${messageCommentList.messageCommentList}" var="i" varStatus="iStatus">
            <tr id="comment_${i.commentId}">
                <td align="center"><input type="checkbox" name="checkedIds" value="${i.commentId}" /></td>
                <td>${i.title}</td>
                <td align="center">${i.registerName}</td>
                <td align="center">${fn:substring(i.registerDate, 0, 16)}</td>
            </tr>
    	</c:forEach>
    </tbody>
</table>
</form>

<c:set var="attachmentList" value="${messageVO.attachmentList}" />
<c:set var="lastAttachment" value="${messageVO.lastAttachment}" />
<c:set var="firstAttachment" value="${messageVO.firstAttachment}" />

<c:if test="${lastAttachment != null }" >
<script>
//<![CDATA[
setImageContentMapping(
		{
			'fileUploadType' : '',
	        'filePath' : '/media/${lastAttachment.fileName}${lastAttachment.fileType==2?".image":""}',
	        'originalFilename' : '${lastAttachment.displayName}',
	    	'fileSize' : '${lastAttachment.fileSize}',
	    	'fileName' : '${lastAttachment.fileName}',
	    	'contentType' : '${lastAttachment.contentType}',
	    	'imageHeight' : '${lastAttachment.imageHeight}',
	    	'imageWidth' : '${lastAttachment.imageWidth}'
		}
)
//]]>
</script>
</c:if>
</html>

