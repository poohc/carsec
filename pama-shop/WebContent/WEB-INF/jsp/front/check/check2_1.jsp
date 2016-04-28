<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
   //치환 변수 선언
    pageContext.setAttribute("cr", "\r"); //Space
    pageContext.setAttribute("cn", "\n"); //Enter
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
<script>
function getAddr(param1, param2) {
	var sido = "";
	var gugun = "";
	var dong = "";
	param2 = param2 + "|||";
	if(param1=='gugun'){
		sido = param2.split("|")[0];
	}
	if(param1=='dong'){
		sido = param2.split("|")[0];
		gugun = param2.split("|")[1];
	}
	$.ajax({
		type : "POST",
		url : "/mbr/accountAddrSearch.do",
		data : {"searchType":param1,"sido":sido,"gugun":gugun,"dong":dong},
		dataType : "json",
		success : function(data){
			if(param1=='gugun'){
				$('#addr4').children().remove();
			}
			if(param1=='dong'){
				$('#addr5').children().remove();
			}

			$.each(data.zipcode, function(){
				if(param1=='sido'){
					$('#addr3')
			          .append($('<option>', { value : this.sido })
			          .text(this.sido));
				}
				if(param1=='gugun'){
					$('#addr4')
			          .append($('<option>', { value : this.sido+"|"+this.gugun })
			          .text(this.gugun));
				}
				if(param1=='dong'){
					$('#addr5')
			          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
			          .text(this.dong));
				}
			});
			if(param1=='sido'){
				if ($("#addr3 option").index($("#addr3 option:selected"))<0) {
					$("#addr3 option:eq(0)").attr("selected", "selected");
				}
				getAddr('gugun', $("#addr3 option:selected").val());
				getAddr('dong', $("#addr4 option:selected").val());
			}
			if(param1=='gugun'){
				if ($("#addr4 option").index($("#addr4 option:selected"))<0) {
					$("#addr4 option:eq(0)").attr("selected", "selected");
				}
				getAddr('dong', $("#addr4 option:selected").val());
			}
			if(param1=='dong'){
				if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
					$("#addr5 option:eq(0)").attr("selected", "selected");
				}
			}
		}
	});
}

function getAddr1(param1, param2) {
	var sido = "";
	var gugun = "";
	var dong = "";
	param2 = param2 + "|||";
	if(param1=='gugun'){
		sido = param2.split("|")[0];
	}
	if(param1=='dong'){
		sido = param2.split("|")[0];
		gugun = param2.split("|")[1];
	}
	var statusTypeChangeUrl = '/mbr/accountAddrSearch.do?searchType=' + param1 + '&sido=' + sido + '&gugun=' + gugun + '&dong=' + dong;
	$.getJSON(statusTypeChangeUrl, function(data) {
		if(param1=='gugun'){
			$('#addr4').children().remove();
		}
		if(param1=='dong'){
			$('#addr5').children().remove();
		}

		$.each(data.zipcode, function(){
			if(param1=='sido'){
				$('#addr3')
		          .append($('<option>', { value : this.sido })
		          .text(this.sido));
			}
			if(param1=='gugun'){
				$('#addr4')
		          .append($('<option>', { value : this.sido+"|"+this.gugun })
		          .text(this.gugun));
			}
			if(param1=='dong'){
				$('#addr5')
		          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
		          .text(this.dong));
			}
		});
		if(param1=='sido'){
			if ($("#addr3 option").index($("#addr3 option:selected"))<0) {
				$("#addr3 option:eq(0)").attr("selected", "selected");
			}
			getAddr('gugun', $("#addr3 option:selected").val());
			//getAddr('dong', $("#addr4 option:selected").val());
		}
		if(param1=='gugun'){
			if ($("#addr4 option").index($("#addr4 option:selected"))<0) {
				$("#addr4 option:eq(0)").attr("selected", "selected");
			}
			getAddr('dong', $("#addr4 option:selected").val());
		}
		if(param1=='dong'){
			if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
				$("#addr5 option:eq(0)").attr("selected", "selected");
			}
		}
	});
}

$( document ).ready( function() {
	getAddr('sido', '');
})


function addEstimate() {
	var form = document.addEstimateFrm;

	var addr1=$("#addr3 option:selected").text();
    if($("#addr4 option:selected").val() != ""){
    	addr1+="-"+$("#addr4 option:selected").text();
    }

    if($("#addr5 option:selected").val() != ""){
    	addr1+="-"+$("#addr5 option:selected").text();
    }

	form.companyAddr.value=addr1;

	form.action="addEstimate.do"
	form.submit();
}

</script>
</head>
<body>


            <div id="tab1" class="tab_contents">
                <p class="way_introduce"><a href="#"><i class="fa fa-heartbeat"></i> 셀프진단 사용방법 안내</a></p>
                <div id="tab1_01" class="tab_contents_s">
                    <div class="step_cont st_type9">
                        <h1><i class="fa fa-heartbeat"></i> 완료</h1>
                        <p class="cen_par">귀하 차량의 진단결과</p>

                        <p class="cen_par2" style="text-align: left;margin-left: 120px;">
                        <span>${fn:replace(check.carCheckVO.qcodeTitle,crcn,br)}</span>
                        </p>

                        <div class="search">
                         <form name="addEstimateFrm"  method="post">
                         	<input type="hidden" name="companyAddr" id="companyAddr" value="" />
                         	<input type="hidden" name="qcodeTitle" id="qcodeTitle" value="${check.carCheckVO.qcodeTitle } " />
                         	<input type="hidden" name="gcodeQcode" id="gcodeQcode" value="${check.carCheckVO.gcode}-${check.carCheckVO.qcode}" />
                            <ul class="select_list">
                                <li class="fir_sel">
                                    <select multiple="multiple" id="addr3" name="addr3" class="city loc" onchange="getAddr('gugun',this.value)">
                                    </select>
                                </li>
                                <li class="sec_sel">
                                    <select multiple="multiple" id="addr4" name="addr4" name="local" class="city loc" onchange="getAddr('dong',this.value)">
                                    </select>
                                </li>
                                <li>
                                    <select multiple="multiple" id="addr5" name="addr5" name="local" class="city loc">
                                    </select>
                                </li>
                            </ul>
                            	<c:choose>

	                                <c:when test="${sessionVO.level==10 }">
		                                <a href="#;" onclick="javascript:addEstimate();" class="input_type1 add_btn">견적요청하기</a>
	                                </c:when>
	                                <c:otherwise>
	                                    <img src="/img/partmap_banner.png"><a href="/web/sub1/check3.do" class="input_type1 add_btn">부품맵</a>
	                                </c:otherwise>
                                </c:choose>

                       	 </form>
                    	</div>
                    </div>
                    <br /><br /><br /><br />
                    <a href="/check/caritemmap.do"><img src="/img/partmap_banner.png"></a>
                </div>
            </div>

<script>
/**********************************************************************************/
// 탭
/**********************************************************************************/
$(function(){
    $('.tab_contents:eq(0)').show();
    $('#tab li a').click(function(){
        $('#tab li').removeClass('on');
        $(this).parent().addClass('on');
        $('.tab_contents').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });
});

// 탭2
$(function(){
    $('.tab_contents').find('.tab_contents_s:eq(0)').show()
    $('.tab_st2 li a').click(function(){
        $('.tab_st2 li').removeClass('on');
        $(this).parent().addClass('on');

        var chk=$(this).parent().parent().parent().attr('id');
        $('#'+chk ).find('.tab_contents_s').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });

    $('#tab li a').click(function(){
        $('.tab_contents .tab_st2 li').removeClass('on');
        $('.tab_contents .tab_st2 li:first-child').addClass('on');
        var showtab=$('.tab_contents .tab_st2 li:first-child a').attr('href');

        $(showtab).show();

        return false;
    })
});

</script>
</script>

</body>
</html>