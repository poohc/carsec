//RemoveProc
function goMessageRemoveProc(form ){
    if(confirm('정말로 삭제하시겠습니까?')){
    	form.action="messageRemoveProc.do";
    	form.method="post";
        form.submit();
    }

}

//goList
function goList(listReturnURL) {
	if(listReturnURL != ""){
		location.href=listReturnURL;
	} else{
		location.href="messageList.do";
	}

}


function toAddFile() {
    window.open('/media/bbs/uploadForm.do','imgform','width=350,height=250');
}


//파일삭제
function removeAttachment(imageId) {

	if(!confirm("파일을 삭제하겠습니까?")){
		return ;
	}

	$.getJSON('messageAttachmentDelete.json?imageId=' + imageId, function(data) {
		if (data.msgCode=="100") {
			removeAttachmentResult(imageId);
		}
	});
}

//삭제결과
function removeAttachmentResult(imageId){
	$("#img_"+imageId).remove();
	$("#fileModifyDesc").remove();
	$("#showFile1").attr("required",true);
}

$(function(){

	// Datepicker
	$('#startDate').datepicker({
		inline: true,
		dateFormat: 'yy-mm-dd'
	});

	// Datepicker
	$('#endDate').datepicker({
		inline: true,
		dateFormat: 'yy-mm-dd'
	});
});
