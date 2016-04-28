<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
            <div id="tab1" class="tab_contents">
                <p class="way_introduce"><a href="#"><i class="fa fa-heartbeat"></i> 셀프진단 사용방법 안내</a></p>
                <!-- Tab 9 -->
                <div id="tab1_09" class="tab_contents_s">
                    <div class="step_cont st_type10">
                        <img src="/img/event_img.jpg" alt="self진단관련이미지">
                        <p class="cen_par">${fn:replace(accountVO.addr1,'-','&nbsp; ') } 지역의 ${carEstimateVO.carCheckTitle } 수리 가능 업소로 연결되었습니다. <span>감사합니다.</span></p><br/>
                        <a href="/bbs/usereviews/messageList.do" class="btn_type1">이용후기</a>
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