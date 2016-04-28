
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
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<title>:::CarSec  ::: 검진</title>
</head>
<body>
<!-- header -->
    <div id="header">
        <div class="header_top">
            <div class="top_menu">
                <ul class="top_left">
                    <li class="self"><a href="/check/check1.do">내차SELF점검</a></li>
<!--                     <li class="coupon"><a href="/web/etc/coupon1.do">COUPON</a></li> -->
				</ul>
				<ul class="top_right">
					<li class="login"><a href="/login/loginForm.do">로그인</a></li>
					<li class="join"><a href="/mbr/accountAgreeAgency.do">메카닉회원 가입</a></li>
					<li class="join"><a href="/mbr/accountAgree.do">일반회원 가입</a></li>
				</ul>
			</div>
		</div>
		<div class="header_bottom_box">
			<div class="header_bottom">
				<h1><a href="/"><img src="/img/logo3.png" alt="carsec"></a></h1>
					<ul id="gnb"><!-- gnb -->
						<li class="gnb02"><a href="/check/check1.do">서비스</a></li>
						<li class="gnb01"><a href="/bbs/freeboard/messageList.do">정보도서관</a></li>
						<li class="gnb02"><a href="/bbs/recruit2/messageList.do">에이전트</a></li>
						<li class="gnb01"><a href="/bbs/newcar/messageList.do">메카닉</a></li>
						<li class="gnb01"><a href="/bbs/compareevent/messageList.do">이벤트</a></li>
						<li class="gnb01"><a href="#;" onclick="alert('메카닉 회원의 상품을 준비중입니다');">쿠폰쇼핑</a></li>
	<!--                <li class="gnb01"><a href="/prd/productList.do?sortTree=10">쿠폰쇼핑</a></li> -->

           		 	</ul><!-- //gnb -->
			</div>
		</div>
	</div>

<!-- //header -->



<script>
function randomNotice(arg1, arg2){
	location.href="/bbs/"+arg1+"/messageDetail.do?messageId="+arg2;
}

function aspectNotice(arg1, arg2){
	location.href="/bbs/"+arg1+"/messageDetail.do?messageId="+arg2;
}
</script>
<!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/check/check1.do">내차SELF 점검</a></li>
                <li class="on"><a href="/check/caritemmap.do">차량부품Map</a></li>
                <li class=""><a href="/bbs/caritemmap/messageList.do">차량부품목록</a></li>
                <li class=""><a href="/bbs/company3/messageList.do">협력정비업체</a></li>
            </ul>
            <div class="start_selfservice">
			<dl class="event">
                <dt>이벤트 공지</dt>
                	<dd onclick="randomNotice('notice4','114')">카색 서비스 오픈 공지</dd>
            </dl>
			<div class="part_map">
				<form action="check3.jsp">
					<div class="left_map">
						<ul>

                            <li class="input_tit">부품위치</li>



                            <li><input type="button" onclick="goCate('21','');" class="input_type3 on" value="윗 면" title="윗면"></li>

                            <li><input type="button" onclick="goCate('22','');" class="input_type3 " value="전 면" title="전면" ></li>

                            <li><input type="button" onclick="goCate('23','');" class="input_type3 " value="측 면" title="측면"></li>

                            <li><input type="button" onclick="goCate('24','');" class="input_type3 " value="하 부" title="하부"></li>

                            <li><input type="button" onclick="goCate('25','');" class="input_type3 " value="하 체1" title="하체1"></li>

                            <li><input type="button" onclick="goCate('26','');" class="input_type3 " value="하 체2" title="하체2"></li>

                            <li><input type="button" onclick="goCate('27','');" class="input_type3 " value="엔진룸" title="엔진룸"></li>

                            <li><input type="button" onclick="goCate('28','');" class="input_type3 " value="실 내" title="실내"></li>

                            <li><input type="button" onclick="goCate('29','');" class="input_type3 " value="도 어" title="도어"></li>

                        </ul>



                        <select multiple="multiple" name="front_part" class="part_list" onchange="goCate('21', this.value)">

                        	<option value="97"  >부품명2</option>

                        	<option value="96"  >부품명1</option>

                        	</select>

                    </div>

                    <div class="right_map">



                        <div class="img_box2">



                        		 <img src="/img/map_mimg_bg.png"/></div>

                        <div class="img_box">



                        		 <img src="/img/map_simg_bg.png"/></div>



                        <dl>

                            <dt></dt>

                            <dd>

                            </dd>

                        </dl>



                </form>

                </div>

            </div>







<script>



function goCate(cateId, msgId){

	param="?messageCategoryId="+cateId;

	if(msgId != ""){

		param+="&messageId="+msgId;

	}

	location.href=param;

}

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



</div>

        </div>

        <div class="rnb">

            <!--<ul class="system_notice">-->

                <!--<li class="on"><a href="#">공지사항</a></li>-->

           		<!---->

            <!--</ul>-->



<div class="banner">

                <ul>

                    <li><a href="/check/caritemmap.do"><img src="/img/self_banner.jpg" alt="배너"></a></li>

                    <li><a href="/bbs/recruit2/messageList.do"><img src="/img/self_banner2.jpg" alt="배너"></a></li>

                    <li><a href="/check/check1.do"><img src="/img/self_banner3.jpg" alt="배너"></a></li>

                </ul>

            </div>

<div id="sidetab">

            <ul class="sidetab">

                <li><a href="/check/check1.do">카섹의<span>셀프점검</span></a></li>

                <li><a href="/check/caritemmap.do">자동차의<span>모든부품정보</span></a></li>

            </ul>

     </div>

<!--         <div id="sidetab2"> -->

<!--             <p class="point_title">워셔액포인트</p> -->

<!--             <p class="point_title2">99,000</p> -->

<!--             <p class="point_title3">게시판에 댓글을 남기면 <span>워셔액 포인트</span>를 드립니다.</p> -->

<!--         </div> -->









<div class="epilogue_banner"><a href="#"><i class="fa fa-pencil-square-o"></i>카색 정비채널</a></div>

            

            <!--<ul class="use_epilogue">-->

    			<!---->

            <!--</ul>-->

            <ul class="use_epilogue">

            	<li><iframe width=100% height=100% src="https://www.youtube.com/embed/AWq5AYW7UQI" frameborder="0" allowfullscreen></iframe></li>

            	<li><iframe width=100% height=100% src="https://www.youtube.com/embed/e2erNy2YPSU" frameborder="0" allowfullscreen></iframe></li>

            </ul>	

            <div class="epilogue_banner event_intro"><a href="#"><i class="fa fa-pencil-square-o"></i> 안내</a></div>

            <ul class="use_epilogue type2">

            	<li><a href="/bbs/notice4/messageDetail.do?messageId=114">카색 서비스 오픈 공지</a></li>

                <li><a href="/bbs/notice4/messageDetail.do?messageId=112">오픈기념 이벤트를 시작합니다.</a></li>

                </ul>



        </div>



        </div>









<!-- footer -->

    <div id="footer">

        <p class="footer_title">CARSEC 전체보기</p>

        <ul class="all_menu">

            <li>검진&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>

            <li>정보도서관&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>

            <li>에이전트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>

            <li>이벤트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>

            <li>메카닉&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>

            <li>쇼핑(준비중)</li>

        </ul>

        <ul class="all_menu2">

            <li>

                <ul class="all_menu3">

                    <li><a href="/check/check1.do">내차SELF 점검</a></li>

                    <li><a href="/check/check3.do">부품맵</a></li>

                    <li><a href="/bbs/company3/messageList.do">협력정비업체</a></li>

                </ul>

            </li>

            <li>

                <ul class="all_menu3">

                    <li><a href="/bbs/freeboard/messageList.do">자유게시판</a></li>

                    <li><a href="/bbs/accident/messageList.do">사고관련 게시판</a></li>

                    <li><a href="/bbs/carnews/messageList.do">신차뉴스</a></li>

                    <li><a href="/bbs/recallnews/messageList.do">리콜소식</a></li>

                    <li><a href="/bbs/carcheck/messageList.do">자동차검사</a></li>

                    <li><a href="/bbs/trafficlaw/messageList.do">교통법 및 벌금</a></li>

                    <li><a href="/bbs/drivecourse/messageList.do">드라이브 코스</a></li>

                    <li><a href="/bbs/carnpeople/messageList.do">자동차와 사람</a></li>

                </ul>

            </li>

            <li>

            	<ul class="all_menu3">

                    <li><a href="/bbs/recruit2/messageList.do">정비소 구인</a></li>

                    <li><a href="/bbs/resumes/messageList.do">정비소 구직</a></li>

                    <li><a href="/bbs/resumes/messageForm.do">정비소 구인등록</a></li>

                    <li><a href="/bbs/usedcarmarket/messageList.do">정비소 구직등록</a></li>

                    <li><a href="/bbs/usedcarmarket/messageForm.do">중고차 매매 게시판</a></li>

                </ul>

            </li>

            <li>

                <ul class="all_menu3">

                    <li><a href="/bbs/compareevent/messageList.do">이벤트</a></li>

                    <li><a href="/bbs/compareeventwin/messageList.do">당첨자 공지</a></li>

                </ul>

            </li>

            <li>

                <ul class="all_menu3">

                    <li><a href="/bbs/newcar/messageList.do">신차소개</a></li>

                    <li><a href="/bbs/newtech/messageList.do">신기술</a></li>

                    <li><a href="/bbs/maintennace/messageList.do">정비사례</a></li>

                    <li><a href="/bbs/shopmarket/messageList.do">매장매매</a></li>

                    <li><a href="/bbs/company1/messageList.do">업체리스트</a></li>

                    <li><a href="/bbs/company2/messageList.do">정비외 협력업체</a></li>

                    <li><a href="/bbs/partsmarket/messageList.do">중고부품매매</a></li>

                </ul>

            </li>

            <li>

                 <ul class="all_menu3">

                    <!--<li><a href="/prd/productList.do?sortTree=10">병원</a></li>

                    <li><a href="/prd/productList.do?sortTree=20">뷰티샵</a></li>

                    <li><a href="/prd/productList.do?sortTree=30">CULTURE</a></li>-->

                </ul>

            </li>

            <li><img src="/img/fi.jpg" alt=""></li>

        </ul>

        <ul class="all_menu4">

            <li class="next_bul">링크</li>

            <li><a href="http://www.car.go.kr"><img src="/img/easypay.jpg" alt=""></a>&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp</li>

            <li><a href="http://www.car.go.kr"><img src="/img/link_img1.png" alt="">&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp</a></li>

            <li><a href="http://www.carten.kr"><img src="/img/link_img2.png" alt="">&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp</a></li>

        </ul>

        </div>

        <div class="allmenu_wrap">

            <ul class="all_menu5">

                <li>

                    <ul class="all_menu6">

                        <li class="on">카섹 정비포탈 서비스</li>

                        <li class="on">고객센터</li>

                        <li class="">주소 : 경기도 성남시 분당구 서현로210번길 2, 6층 607호</li>

                        <li class="">전화번호 : 031-700-8888</li>

                        <li class="">팩스번호 : 031-701-9888</li>

                        <li class="">업무시간 : 평일 09:00 - 18:00 (공휴일, 토, 일 휴무)</li>

                    </ul>

                </li>

                <li>

                    <ul class="all_menu6">

                        <li class="on">주식회사 디에우로파</li>

                        <li class="">사업자등록번호 : 317-81-47052</li>

                        <li class="">통신판매업신고 : 성남00</li>

                        <li class="">대표자 : 김인학</li>

                        <li class="">사업영역 : 자동차부품및 관련용품판매, 전자상거래, 소프트웨어 개발 및 공급</li>

                        <li class="">주소 : 경기도 성남시 분당구 서현로 210번길 2, 6층 607호 </li>

                    </ul>

                </li>

            </ul>

        </div>

        <ul class="all_menu7">

            <li>

                <ul class="all_menu8">

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#;">이용약관</a></li>

                            <li><a href="#;">쿠폰이용약관</a></li>

                            <li><a href="#;">개인정보취급방침</a></li>

                            <li><a href="mailto:kj103kj@gmail.com">개인정보관리자:구자현</a></li>

                        </ul>

                    </li>

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#;">협력업체등록</a></li>

                            <li><a href="#;">회사소개</a></li>

                            <li><a href="#;">FAQ</a></li>

                            <li><a href="#;">SELF점검</a></li>

                        </ul>

                    </li>

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#;">쿠폰</a></li>

                            <li><a href="#;">이벤트</a></li>

                            <li><a href="#;">견적내역</a></li>

                            <li><a href="#;">1:1문의</a></li>

                        </ul>

                    </li>

                </ul>

            </li>

            <li>

                <ul class="all_menu8">

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                        </ul>

                    </li>

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                        </ul>

                    </li>

                    <li>

                        <ul class="all_menu9">

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                            <li><a href="#">협력업체링크</a></li>

                        </ul>

                    </li>

                </ul>

            </li>

        </ul>

        <div class="allmenu_wrap2">

         <p class="copyright">Copyright © <span>THE EUROPA</span> Co., Ltd. All rights reserved.</p>

        </div>

    </div>

<!-- //footer --></body>



</body>

</html>

