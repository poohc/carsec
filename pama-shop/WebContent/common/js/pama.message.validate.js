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


	    		var addr1=$("#addr3 option:selected").text()+"-"+$("#addr4 option:selected").text()+"-"+$("#addr5 option:selected").text();
	    		$("#messageAddr1").attr("value",addr1);


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