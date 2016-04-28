
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>jQuery validation plug-in - main demo</title>
	<script type="text/javascript" src="/common/ckeditor/ckeditor.js" charset="utf-8"></script>
	<script>

	$().ready(function() {
		$("#dataForm").validate({

// 			rules: {
// 				title: "required"

// 			},
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
</head>
<body>
<form name="messageForm" id="dataForm" class="dataForm" method="post" action=""  enctype="multipart/form-data">

<input type="text" name="title" value="" required/>

<textarea cols="80" id="ckeditor1" name="contents" rows="10">${messageVO.contents }</textarea>


<script type="text/javascript">
     CKEDITOR.replace( 'ckeditor1', {//해당 이름으로 된 textarea에 에디터를 적용
     	            width:'100%',
     	            height:'400px'
     	        });
</script>


<input type="image" src="/common/images/admin/btn/btn_save.gif" />
</form>



</div>
</body>
</html>
