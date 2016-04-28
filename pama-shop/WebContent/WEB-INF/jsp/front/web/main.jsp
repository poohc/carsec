<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  :::</title>
</head>
<body>
<!-- contain -->
    <div id="main_container">
        <div class="main_banner2"><!-- 메인 비주얼 -->
            <div class="banner_list_box">
                <div class="visual">
                    <div class="pic">
                        <ul>
                            <li>
                                <a href="/web/sub2/library9.do"><img src="/img/main_banner.png" alt="메인이미지"></a>
                            </li>
                            <li>
                                <a href="/web/sub2/library9.do"><img src="/img/main_banner.png" alt="메인이미지"></a>
                            </li>
                            <li>
                                <a href="/web/sub2/library9.do"><img src="/img/main_banner.png" alt="메인이미지"></a>
                            </li>
                        </ul>
                    </div>
                    <div class="btn"></div>
                    <div class="dir">
                        <div class="prev"><span>이전</span></div>
                        <div class="next"><span>다음</span></div>
                    </div>
                </div>
            </div>
            <div id="floating_menu">
               <div class="tablist_box">
                <ul class="tablist" id="tab">
                    <li class="on"><a href="#tab1">일반회원</a></li>
                    <li class=""><a href="#tab2">메카닉회원</a></li>
                </ul>
                <div id="tab1" class="tab_contents">
                    <form action="">
                        <fieldset class="inputfield">
                            <input type="text" tabindex="1" title="아이디" data-from="text" placeholder="아이디" name="login_id" class="type1">
                            <input type="password" tabindex="2" data-from="text" title="비밀번호" placeholder="비밀번호" name="login_pwd" class="type1">
                            <button tabindex="3" data-btn="text" type="submit" class="type1">로그인</button>
                        </fieldset>
                    </form>
                    <ul class="id_pass">
                        <li><a href="#">아이디</a></li>
                        <li><a href="#">비밀번호 찾기</a></li>
                    </ul>
                </div>
                </div>
                    <div class="notice">
                        <p class="titleof_board">공지사항</p>
                        <ul class="notice_list">
                            <li><a class="new" href="#none">Carsec 공지사항</a><span class="date">14.07.14</span></li>
                            <li><a class="new" href="#none">Carsec 공지사항</a><span class="date">14.07.14</span></li>
                            <li><a class="new" href="#none">Carsec 공지사항</a><span class="date">14.07.14</span></li>
                        </ul>
                        <a class="more" title="공지사항 더보기" href="#none">더보기 ></a>

                </div>
                <div class="tablist_box">
                	<ul class="tablist" id="tab">
                    <li class=""><a href="#tab1">일반회원</a></li>
                    <li class="on"><a href="#tab2">메카닉회원</a></li>
                </ul>
                <div id="tab2" class="tab_contents">
                    <form action="">
                        <fieldset class="inputfield">
                            <input type="text" tabindex="1" title="아이디" data-from="text" placeholder="아이디" name="login_id" class="type1">
                            <input type="password" tabindex="2" data-from="text" title="비밀번호" placeholder="비밀번호" name="login_pwd" class="type1">
                            <button tabindex="3" data-btn="text" type="submit" class="type1">로그인</button>
                        </fieldset>
                    </form>
                    <ul class="id_pass">
                        <li><a href="#">아이디</a></li>
                        <li><a href="#">비밀번호 찾기1</a></li>
                    </ul>
                     </div>
                    <div class="notice">
                        <p class="titleof_board">공지사항2</p>
                        <ul class="notice_list">
                            <li><a class="new" href="#none">Carsec 공지사항2</a><span class="date">14.07.14</span></li>
                            <li><a class="new" href="#none">Carsec 공지사항2</a><span class="date">14.07.14</span></li>
                            <li><a class="new" href="#none">Carsec 공지사항2</a><span class="date">14.07.14</span></li>
                        </ul>
                        <a class="more" title="공지사항 더보기" href="#none">더보기 ></a>
                    </div>
                </div>
                </div>
            </div>
                </form>
            </div>
        </div><!-- //메인 비주얼 -->
        <div class="contain">
            <div class="event_banner">
                <div class="top_banner">
                    <ul>
                        <li><a href="/web/sub1/check3.do"><img src="/img/banner_01.png" alt="배너"></a></li>
                        <li><a href="/web/sub5/recruit.do"><img src="/img/banner_02.png" alt="배너"></a></li>
                        <li><a href="/web/sub1/check1.do"><img src="/img/banner_03.png" alt="배너"></a></li>
                    </ul>
                </div>
                <div class="event_search">
                    <dl class="event">
                        <dt>이벤트 공지</dt>
                        <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                    </dl>
                    <div class="search">
                        <p class="sear_title"><i class="fa fa-heartbeat"></i> 정비소 검색</p>
                        <form action="index.jsp">
                            <ul class="select_list">
                                <li class="fir_sel">
                                    <select multiple="multiple" name="local" class="city loc">
                                        <option selected="selected">서울특별시</option>
                                        <option>부산광역시</option>
                                        <option>대구광역시</option>
                                        <option>광주광역시</option>
                                        <option>대전광역시</option>
                                        <option>울산광역시</option>
                                        <option>경기도</option>
                                        <option>강원도</option>
                                        <option>충청북도</option>
                                        <option>충청남도</option>
                                        <option>전라남도</option>
                                        <option>전라북도</option>
                                        <option>경상남도</option>
                                        <option>경상북도</option>
                                        <option>제주도</option>
                                    </select>
                                </li>
                                <li class="sec_sel">
                                    <select multiple="multiple" name="local" class="city loc">
                                        <option selected="selected">서울특별시</option>
                                        <option>부산광역시</option>
                                        <option>대구광역시</option>
                                        <option>광주광역시</option>
                                        <option>대전광역시</option>
                                        <option>울산광역시</option>
                                        <option>경기도</option>
                                        <option>강원도</option>
                                        <option>충청북도</option>
                                        <option>충청남도</option>
                                        <option>전라남도</option>
                                        <option>전라북도</option>
                                        <option>경상남도</option>
                                        <option>경상북도</option>
                                        <option>제주도</option>
                                    </select>
                                </li>
                                <li>
                                    <select multiple="multiple" name="local" class="city loc">
                                        <option selected="selected">서울특별시</option>
                                        <option>부산광역시</option>
                                        <option>대구광역시</option>
                                        <option>광주광역시</option>
                                        <option>대전광역시</option>
                                        <option>울산광역시</option>
                                        <option>경기도</option>
                                        <option>강원도</option>
                                        <option>충청북도</option>
                                        <option>충청남도</option>
                                        <option>전라남도</option>
                                        <option>전라북도</option>
                                        <option>경상남도</option>
                                        <option>경상북도</option>
                                        <option>제주도</option>
                                    </select>
                                </li>
                            </ul>
                            <input type="submit" value="검색" class="input_type1"> <!--검색 후 sub1/mechanic_search.do에서 결과 표시-->
                            <!--p class="bul_ty1"><img src="/img/bul_type1.gif" alt="다음"></p>
                            <p class="bul_ty2"><img src="/img/bul_type1.gif" alt="다음"></p-->
                        </form>
                    </div>
                </div>
                <div class="main_banner"><!-- 이벤트 팝업 -->
                    <div class="banner_list_box">
                        <div class="visualsd">
                            <div class="pic">
                                <ul>
                                    <li>
                                        <a class="in_box" href="/web/sub2/library9.do">
                                            <dl>
                                                <dt>이벤트 제목</dt>
                                                <dd>이벤트 내용이 들어가는 부분 입니다. 메인 페이지에 이벤트 내용이 들어가게 되는 부분 입니다.</dd>
                                            </dl>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="in_box" href="/web/sub2/library9.do">
                                            <dl>
                                                <dt>이벤트 제목2</dt>
                                                <dd>이벤트 내용이 들어가는 부분 입니다. 메인 페이지에 이벤트 내용이 들어가게 되는 부분 입니다.</dd>
                                            </dl>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="in_box" href="/web/sub2/library9.do">
                                            <dl>
                                                <dt>이벤트 제목3</dt>
                                                <dd>이벤트 내용이 들어가는 부분 입니다. 메인 페이지에 이벤트 내용이 들어가게 되는 부분 입니다.</dd>
                                            </dl>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="btn"></div>
                            <div class="dir">
                                <div class="prev"><span>이전</span></div>
                                <div class="next"><span>다음</span></div>
                                </div>
                        </div>
                    </div>
                </div><!-- //이벤트 팝업 -->
                <div class="event_search2">
                    <dl class="event">
                        <dt>이벤트 공지</dt>
                        <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                    </dl>
                </div>
            </div>
            <div class="main_board">
                <div class="left_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 자유게시판</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="/web/sub2/library1_view.do">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="center_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 사고관련</p>
                    <a href="/web/sub2/library1_view.do"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 신차뉴스</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="#none">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>

                <div class="left_board main_type1">
                    <p class="awe_title"><a href="#"><i class="fa fa-pencil-square-o"></i> 리콜소식</a></p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="#none">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="center_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 자동차검사</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="#none">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 교통법 및 벌금</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="#none">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="left_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 드라이브 코스</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="/web/sub2/library1_view.do">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="center_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 자동차와 사람</p>
                    <a href="/web/sub2/library1_view.do"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="/web/sub2/library1_view.do">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 질문</p>
                    <a href="#"><img src="/img/mainboard_car.jpg" alt="게시판이미지"></a>
                    <p class="mainbo_title"><a href="#">자유게시판의 제목을 표시</a></p>
                    <span class="writer">글쓴이</span>
                    <ul class="notice_list">
                        <li><a href="#none">자유게시판의 내용을 표시 합니다 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                        <li><a href="#none">자유게시판의 내용을 표시 합니다.</a><span class="date">글쓴이</span></li>
                    </ul>
                </div>
            </div>

            <div class="shoping">
                        <div class="channel">
                            <p class="chan_title"><i class="fa fa-pencil-square-o"></i>
                            쇼핑채널</p>
                            <ul class="shop">
                                <li class="fir"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">250,000<em class="won">원</em></i></a></li>
                                <li class="sec"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">250,000<em class="won">원</em></i></a></li>
                                <li class="thr"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명넣는 곳입니다.</em><i class="money">250,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">250,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">250,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/channel1.jpg" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">250,000<em class="won">원</em></i></a></li>
                            </ul>
                        </div>
            </div>
    </div>
    <!-- //contain -->

<div id="sidetab">사이드퀵메뉴</div>

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



/* * * * * * * * * * * * * * * * * * * * *
메인비주얼 슬라이드
* * * * * * * * * * * * * * * * * * * * */
    var pic_l = $(".visual .pic li").length;
    for(var i=0; i<pic_l; i++){
        $(".visual .btn").append("<div><span>"+(i+1)+"</span></div>");
    }
    $(".visual .btn").append("<a class='stop'></a>");

    var bi;
    var ran = Math.floor(Math.random() * pic_l);
    bi = ran;
    $(".visual .pic li").eq(bi).addClass("ch");
    $(".visual .btn div").eq(bi).addClass("ch");

    $(".visual .btn div").click(function(){
        if(!$(this).is(".ch")){
            bi = $(this).index();
            $(".visual .btn div").removeClass("ch");
            $(this).addClass("ch");
            $(".visual .pic li.ch").animate({"left":"-100%"}, 300).removeClass("ch");
            $(".visual .pic li").eq(bi).css("left","100%").animate({"left":"0"}, 300).addClass("ch");
        }
    });
    $(".visual .prev").click(function(){
        bi--;
        if(bi < 0){bi=pic_l-1;}
        $(".visual .btn div").eq(bi).click();
    });
    $(".visual .next").click(function(){
        bi++;
        if(bi >= pic_l){bi=0;}
        $(".visual .btn div").eq(bi).click();
    });

    var autoset;
    function autoRun(){
        autoset = setTimeout(function(){
            $(".visual .next").click();
            autoRun();
        }, 3000);
    }autoRun();
    var stg = 0;
    $(".visual .btn").on("click", ".stop", function(){
        $(this).removeClass().addClass("gogo");
        stg = 0;
        clearTimeout(autoset);
    });
    $(".visual .btn").on("click", ".gogo", function(){
        if(stg == 0){
            $(this).removeClass().addClass("stop");
            stg = 1;
            $(".visual .next").click();
            autoRun();
        }
    });
    $(".visual .dir span").click(function(){
        $(".visual .stop").click();
    });
    $(".visual .btn div span").click(function(){
        $(".visual .stop").click();
    });
/* * * * * * * * * * * * * * * * * * * * *
이벤트 슬라이드
* * * * * * * * * * * * * * * * * * * * */
var pic_ls = $(".visualsd .pic li").length;
for(var i=0; i<pic_ls; i++){
    $(".visualsd .btn").append("<div><span>"+(i+1)+"</span></div>");
}
$(".visualsd .btn").append("<a class='stop'></a>");

var bisd;
var ransd = Math.floor(Math.random() * pic_ls);
bisd = ransd;
$(".visualsd .pic li").eq(bisd).addClass("ch");
$(".visualsd .btn div").eq(bisd).addClass("ch");

$(".visualsd .btn div").click(function(){
    if(!$(this).is(".ch")){
        bisd = $(this).index();
        $(".visualsd .btn div").removeClass("ch");
        $(this).addClass("ch");
        $(".visualsd .pic li.ch").animate({"left":"-100%"}, 300).removeClass("ch");
        $(".visualsd .pic li").eq(bisd).css("left","100%").animate({"left":"0"}, 300).addClass("ch");
    }
});
$(".visualsd .prev").click(function(){
    bisd--;
    if(bisd < 0){bisd=pic_ls-1;}
    $(".visualsd .btn div").eq(bisd).click();
});
$(".visualsd .next").click(function(){
    bisd++;
    if(bisd >= pic_ls){bisd=0;}
    $(".visualsd .btn div").eq(bisd).click();
});

var autosetsd;
function autoRunsd(){
    autosetsd = setTimeout(function(){
        $(".visualsd .next").click();
        autoRunsd();
    }, 3500);
}autoRunsd();

var stgsd = 0;
$(".visualsd .btn").on("click", ".stop", function(){
    $(this).removeClass().addClass("gogo");
    stgsd = 0;
    clearTimeout(autosetsd);
});
$(".visualsd .btn").on("click", ".gogo", function(){
    if(stgsd == 0){
        $(this).removeClass().addClass("stop");
        stgsd = 1;
        $(".visualsd .next").click();
        autoRunsd();
    }
});
$(".visualsd .dir span").click(function(){
    $(".visualsd .stop").click();
});
$(".visualsd .btn div span").click(function(){
    $(".visualsd .stop").click();
});

</script>

</body>
</html>