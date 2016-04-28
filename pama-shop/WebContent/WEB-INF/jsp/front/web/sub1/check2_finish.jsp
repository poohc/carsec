<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class="on"><a href="/web/sub1/check1.do"><i class="fa fa-heartbeat"></i> 내차 SELF 점검</a></li>
                <li class=""><a href="/web/sub1/check3.do">차량 부품 Map</a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <p class="way_introduce"><a href="#"><i class="fa fa-heartbeat"></i> 셀프진단 사용방법 안내</a></p>
                <ul class="tab_st2">
                    <li class=""><a href="#tab1_01"><i class="fa fa-pencil-square-o"></i> Step 1</a></li>
                    <li class=""><a href="#tab1_02"><i class="fa fa-pencil-square-o"></i> Step 2</a></li>
                    <li class=""><a href="#tab1_03"><i class="fa fa-pencil-square-o"></i> Step 3</a></li>
                    <li class=""><a href="#tab1_04"><i class="fa fa-pencil-square-o"></i> Step 4</a></li>
                    <li class=""><a href="#tab1_05"><i class="fa fa-pencil-square-o"></i> Step 5</a></li>
                    <li class=""><a href="#tab1_06"><i class="fa fa-pencil-square-o"></i> Step 6</a></li>
                    <li class=""><a href="#tab1_07"><i class="fa fa-pencil-square-o"></i> Step 7</a></li>
                    <li class=""><a href="#tab1_08"><i class="fa fa-pencil-square-o"></i> Step 8</a></li>
                    <li class="on"><a href="#tab1_09"><i class="fa fa-pencil-square-o"></i> 완 료</a></li>
                </ul>
                <!-- Tab 9 -->
                <div id="tab1_09" class="tab_contents_s">
                    <div class="step_cont st_type10">
                        <img src="/img/event_img.jpg" alt="self진단관련이미지">
                        <p class="cen_par">서울 특별시 강남구 도곡동 지역의 점화플러그 수리 가능 업소로 연결되었습니다. <span>감사합니다.</span></p>
                        <a href="" class="btn_type1">이용후기</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                    <p class="names">홍길동 님</p>
                    <p class="car_name elipsis"></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                </div>
            </form>
            <div class="epilogue_banner"><a href="#"><i class="fa fa-pencil-square-o"></i> 셀프진단 정비후기</a></div>
            <ul class="use_epilogue">
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
                <li><a href="#">이용후기 제목을 올려드립니다. 이용후기 제목을</a></li>
            </ul>
            <div class="epilogue_banner event_intro"><a href="#"><i class="fa fa-pencil-square-o"></i> 이벤트안내</a></div>
            <ul class="use_epilogue type2">
                <li><a href="#">[EVENT]워셔액 증정 이벤트</a></li>
                <li><a href="#">[EVENT]워셔액 증정 이벤트</a></li>
            </ul>
            <div class="banner">
                <ul>
                    <li><a href="/web/sub1/check3.do"><img src="/img/self_banner.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub5/recruit.do"><img src="/img/self_banner2.jpg" alt="배너"></a></li>
                    <li><a href="/web/sub1/check1.do"><img src="/img/self_banner3.jpg" alt="배너"></a></li>
                </ul>
            </div>

        </div>
        <div class="event_search2">
            <dl class="event">
                <dt>이벤트 공지</dt>
                <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
            </dl>
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