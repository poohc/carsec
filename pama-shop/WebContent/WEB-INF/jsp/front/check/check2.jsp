<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
<script>

function goNextQuestion(gcode, qcode, qcodeNextLength){

	location.href='check2.do?gcode='+gcode+'&qcode='+qcode+'&qcodeNextLength='+qcodeNextLength;
}
</script>
</head>
<body>

            <div id="tab1" class="tab_contents">
                <p class="way_introduce"><a href="#"><i class="fa fa-heartbeat"></i> 셀프진단 사용방법 안내</a></p>
                <div id="tab1_01" class="tab_contents_s">
                    <div class="step_cont st_type1">
                         <h1><i class="fa fa-heartbeat"></i> Step. ${check.carCheckVO.qtypeLength}  <span class="cen_par">${check.carCheckVO.qcodeTitle }</span></h1>

<%--                          ${check.carCheckVO.qcodeLength} --%>

                            <fieldset class="choice_radio">
                                <legend class="blind">

                                </legend>

                                <c:forEach items="${check.list }" var="i" varStatus="iStatus">
                                	<label for="input_radio${iStatus.index }" class="radio_type1 }" ><input id="input_radio${iStatus.index }" type="radio" name="answer" onclick="goNextQuestion('${i.gcode}','${i.qcode}','${i.qcodeNextLength}');">${i.qcodeTitle }
<%--                                 	${i.qcodeFinalYN } --%>
                                	</label>
                                </c:forEach>



                            </fieldset>
                    </div>
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