<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part" id="tab">
                <li class="on"><a href="#tab1">자유게시판</a></li>
                <li class=""><a href="#tab2">사고관련 게시판</a></li>
                <li class=""><a href="#tab3">신차 뉴스</a></li>
                <li class=""><a href="#tab4">리콜 소식</a></li>
                <li class=""><a href="#tab5">자동차 검사</a></li>
                <li class=""><a href="#tab6">교통법 및 벌금</a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <p class="way_introduce way_type1"><a href="#"><img src="/img/board_img.jpg" alt="자동차관련 글 게시판입니다."></p>
                <dl class="event">
                    <dt>이벤트 공지</dt>
                    <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                </dl>
                <div class="board_view"><!-- board_view -->
                    <table>
                        <caption>게시판 읽기</caption>
                        <colgroup>
                            <col style="width:5%" />
                            <col style="width:10%" />
                            <col style="width:auto%" />
                        </colgroup>
                        <thead>
                        <tr>
                            <th scope="col" colspan="3">
                                <p class="t_title">CARSEC 검진 자유게시판 제목입니다. </p>
                            </th>
                            <tr>
                                <td class="bd_tp">자유게시판</td>
                                <td class="bd_tp2">2015.07.07</td>
                                <td></td>
                            </tr>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td colspan="3" class="author">글쓴이</td>
                        </tr>
                        <tr>
                            <td colspan="3" class="text">
                                <p class="gall_text">소스 보니까 걷는 모션을 하나 하나 나누어서 반복해서 쓰는데 저는 걷는 모션은 그냥 gif로 만들까 합니다.<br><br>근데 계속 걷기만 하면 쉽겠지만 그걸 원하는 게 아니라 특정페이지에 가면 얼굴이 달라지고, 그 상태로 걷다가<br><br>특정페이지 가면 다시 얼굴이 변해서 걸었으면 좋겠어요 원래 사이트도 그렇긴 하지만 변하는 속도가 더 느렸으면 해요<br><br>제가 가로스크롤 페이지에서 캐릭터 fixed로 고정시켜놓고 걷게 하려고 하거든요<br><br>스크롤 내리면 걷는 거구 페이지 이동되면 얼굴이 바뀌는 거죠 그런 시점 변화랑 속도를 컨트롤 할 수 있으려면<br><br>
                                    어떻게 해야 하는지 모르겠어요 ㅠㅜㅜ<br><br>요점은 페이지가 바뀌면 캐릭터도 바뀌고, 바뀐 상태로 걷는 모션은 계속했으면 좋겠다는 거예요 ㅠㅜ<br><br>저는인터넷에 있는 제이쿼리 가지고 CS 수정만 할 줄 알아서 아시는 분 계시면 자세히 부탁드리겠습니다<br><br>비용 지불하고라도 하고 싶은데 어디다 의뢰해야될지도 몰라서 에구.. 여기다가 여쭤봅니다!<br><br><br><br>[출처] 페이지별로 전환되는(?) 움직이는 이미지 만들기 (하드코딩하는사람들) |작성자 잠을자고싶은엄지</p>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div><!-- //board_view -->
                <div class="comment">
                    <a href="#" class="kakaotalk"><img src="/img/kakaotalk.jpg" alt="카카오톡"></a>
                    <a href="#" class="facebook"><img src="/img/facebook.jpg" alt="페이스북"></a>
                    <p class="p_comment">- 댓 글 -</p>
                    <form action="freeboard_view.jsp">
                        <ul class="comment_list">
                            <li class="need_login">
                                <textarea name="comment" placeholder="댓글 작성을 위해 로그인 해주세요." id="comment" cols="30" rows="10" title="제목/내용" value="댓글 작성을 위해 로그인 해주세요." class="first_comm"></textarea>
                                <button type="submit" class="btn_search" title="등록">등록</button>
                            </li>
                            <li class="opinion">
                                <p class="member_num">회원1 <span class="the_date">2015.07.07</span></p>
                                <p class="mem_cont">저도 궁금한 점이 있는데... 여기는 힌트기능 넣어주세요. </p>
                                <button type="submit" class="comm_btn">답글 <em>1</em><span></span></button>
                            </li>
                            <li class="need_opinion">
                                <p class="member_num">회원1 <span class="the_date">2015.07.07</span></p>
                                <p class="mem_cont">저도 궁금한 점이 있는데... 여기는 힌트기능 넣어주세요. </p>
                                <button type="submit" class="comm_btn">답글쓰기</button>
                                <textarea name="comment" id="comment" placeholder="댓글 작성을 위해 로그인 해주세요." cols="30" rows="10" title="제목/내용" class="first_comm"></textarea>
                                <button type="submit" class="btn_search" title="등록">등록</button>
                                <div class="paging"><!-- paging -->
                                    <a href="#" class="prev">이전</a>
                                    <a href="#" class="on">1</a>
                                    <a href="#">2</a>
                                    <a href="#">3</a>
                                    <a href="#">4</a>
                                    <a href="#">5</a>
                                    <a href="#" class="next">다음</a>
                                </div>
                            </li>
                        </ul>
                        <div class="center_box">
                            <a href="#" class="btn_type1">목 록</a>
                            <a href="#" class="btn_type1">수 정</a>
                        </div>

                    </form>
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
                    <p class="car_name elipsis">람보르기니이탈리아</p>
                    <ul class="estimate">
                        <li class="demand">요청견적 <em>2</em></li>
                        <li class="recieve">받은견적 <em>2</em></li>
                        <li class="couponbox">쿠폰함 <em>2</em></li>
                    </ul>
                    <button class="modify">수정</button>
                    <button class="mycar">내차</button>
                </div>
            </form>
            <div class="banner">
                <ul>
                    <li><a href="#"><img src="/img/self_banner.jpg" alt="배너"></a></li>
                    <li><a href="#"><img src="/img/self_banner2.jpg" alt="배너"></a></li>
                    <li><a href="#"><img src="/img/self_banner3.jpg" alt="배너"></a></li>
                </ul>
            </div>
            <div class="shopping_channel">
                <p class="cs_title">carsec 쇼핑채널</p>
                <ul>
                    <li class="pd1"><a href="#"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd2"><a href="#"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd3"><a href="#"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd4"><a href="#"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd5"><a href="#"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
                    <li class="pd6"><a href="#"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
                </ul>
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