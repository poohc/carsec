<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
<script type="text/javascript">
function formSubmit(){
	form = document.messageForm;

	if(form.title.value == ''){
		alert("제목을 입력하세요!");
		form.title.focus();
		return;
	}

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

function goList(listReturnURL) {
	if(listReturnURL != ""){
		location.href=listReturnURL;
	} else{
		location.href="messageList.do";
	}

}
</script>
</head>
<body>
<c:set var="pointStr">${param.point==1000?'포인트 신청합니다.':'' }</c:set>
	<form name="messageForm" id="dataForm1" class="dataForm1" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
		<input type="hidden" name="messageId" value="${messageVO.messageId }" />
		<input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
		<input type="hidden" name="varFiled1" value="${empty messageVO.varFiled1?param.point:messageVO.varFiled1 }" />
		<div class="board_write3">
			<div class="board_write3" style="padding: 30px">
				<table>
					<caption>${boardVO.title }</caption>
					<colgroup>
						<col style="width: 10%">
						<col style="width: 25%">
						<col style="width: 10%">
						<col style="width: 45%">
					</colgroup>
					<thead>
                        <tr>
                            <th><label for="author">작성자</label></th>
                            <th class="t_l" colspan="3"><span class="enter_st enter_st3">${sessionVO.memberNm}</span></th>
                        </tr>

						<tr>
							<th><label for="title">제목</label></th>
							<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="title" class="title" title="제목" value="${empty messageVO.title?pointStr:messageVO.title}"></span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4">
							<textarea cols="80" id="contentsarea" name="contents">${messageVO.contents}</textarea>
							<script type="text/javascript">
// 							CKEDITOR.replace( 'contentsarea', {

// 								height: 280,

// 								stylesSet: [
// 									{ name: 'Narrow image', type: 'widget', widget: 'image', attributes: { 'class': 'image-narrow' } },
// 									{ name: 'Wide image', type: 'widget', widget: 'image', attributes: { 'class': 'image-wide' } }
// 								],

// 								contentsCss: [ CKEDITOR.basePath + 'contents.css', 'assets/css/widgetstyles.css' ],
// 								image2_alignClasses: [ 'image-align-left', 'image-align-center', 'image-align-right' ],
// 								image2_disableResizer: true


// 							} );

	CKEDITOR.replace( 'contentsarea', {
			height: 300,

			// Upload images to a CKFinder connector (note that the response type is set to JSON).

			// Configure your file manager integration. This example uses CKFinder 3 for PHP.

			// The following options are not necessary and are used here for presentation purposes only.
			// They configure the Styles drop-down list and widgets to use classes.

			stylesSet: [
				{ name: 'Narrow image', type: 'widget', widget: 'image', attributes: { 'class': 'image-narrow' } },
				{ name: 'Wide image', type: 'widget', widget: 'image', attributes: { 'class': 'image-wide' } }
			],

			// Load the default contents.css file plus customizations for this sample.
			contentsCss: [ CKEDITOR.basePath + 'contents.css', 'http://sdk.ckeditor.com/samples/assets/css/widgetstyles.css' ],

			// Configure the Enhanced Image plugin to use classes instead of styles and to disable the
			// resizer (because image size is controlled by widget styles or the image takes maximum
			// 100% of the editor width).
			image2_alignClasses: [ 'image-align-left', 'image-align-center', 'image-align-right' ],
			image2_disableResizer: true
		} );



							</script>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="btn_right">
			<button type="button" class="button_type1" onclick="javascript:goList('${ param.listReturnURL }');"'">목록</button>
			<button type="button" class="button_type1" onclick="javascript:formSubmit();">등록하기</button>
		</div>
	</form>

</body>
</html>