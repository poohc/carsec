<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
<script type="text/javascript" src="/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
$(document).ready(function(){
	 
	var editor_object = [];
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "contentsarea",
        sSkinURI: "/smarteditor/SmartEditor2Skin.html", 
        htParams : {
        	// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : false,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,
            fOnBeforeUnload : function(){},
        },	    
	    //boolean
	    fOnAppLoad : function(){
	    	
	    	if('<c:out value="${param.messageId}" />' != ''){
	    		var contents = '<c:out value="${messageVO.contents}" escapeXml="false" />';
	    		editor_object.getById["contentsarea"].exec("PASTE_HTML", [contents]); //로딩이 끝나면 contents를 txtContent에 넣습니다.
	    	}
	    }    
    });
    
    
    $("#regBtn").click(function(){
    	form = document.messageForm;
    	
    	if($('#title').val() == ''){
    		alert('제목을 입력해 주세요');
    		return false;
    	}
    	
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["contentsarea"].exec("UPDATE_CONTENTS_FIELD", []);
        // 이부분에 에디터 validation 검증
        
        form.submit();	
    });
    
});

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
	<img src="/img/bullet/bullet_1.png"/>
	<form name="messageForm" id="dataForm1" class="dataForm1" method="post" action="${messageVO!=null && messageVO.messageId!=''?'./messageModify.do':'./messageRegister.do'}">
		<input type="hidden" name="messageId" value="${messageVO.messageId }" />
		<input type="hidden" name="sortTree" value="${messageVO.sortTree }" />
		<div class="board_write3">
			<div class="board_write3">
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
                            <th><label for="author">닉네임</label></th>
                            <th class="t_l" colspan="3"><span class="enter_st enter_st3">${sessionVO.nickNm}</span></th>
                        </tr>

						<tr>
							<th><label for="title">제목</label></th>
							<th colspan="3" class="t_l"><span class="enter_st enter_st1"><input type="text" name="title" class="title" title="제목" value="${messageVO.title}"></span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4">
							<textarea cols="80" id="contentsarea" name="contents"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="btn_right">
			<button type="button" class="button_type1" onclick="javascript:goList('${ param.listReturnURL }');"'">목록</button>
			<button type="button" class="button_type1" id="regBtn" onclick="javascript:formSubmit();">${empty param.messageId?'등록':'수정' }하기</button>
		</div>
	</form>

</body>
</html>