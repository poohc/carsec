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
<title>:::CarSec <decorator:title /> ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub1/check1.do">내차SELF 점검</a></li>
                <li class="on"><a href="/web/sub1/check3.do">차량부품 Map</a></li>
                <li class=""><a href="/web/sub1/mechanic_search.do">협력정비업체</a></li>
            </ul>
            <div class="part_map">
               
                <form action="check3.jsp">
                    <div class="left_map">
                        <ul>
                             <li class="input_tit">부품위치</li>
                            <li><input type="submit" class="input_type3 on" value="윗 면" title="윗면"></li>
                            <li><input type="submit" class="input_type3" value="전 면" title="전면"></li>
                            <li><input type="submit" class="input_type3" value="측 면" title="측면"></li>
                            <li><input type="submit" class="input_type3" value="하 부" title="하부"></li>
                            <li><input type="submit" class="input_type3" value="하 체1" title="하체1"></li>
                            <li><input type="submit" class="input_type3" value="하 체2" title="하체2"></li>
                            <li><input type="submit" class="input_type3" value="엔진룸" title="엔진룸"></li>
                            <li><input type="submit" class="input_type3" value="실 내" title="실내"></li>
                            <li><input type="submit" class="input_type3" value="도 어" title="도어"></li>
                            <li class="mb_0"><input type="submit" class="input_type3" value="전 면" title="전면"></li>
                        </ul>
                        
                        <select multiple="multiple" name="front_part" class="part_list">
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                            <option>헤드램프</option>
                        </select>
                    </div>
                    <div class="right_map">
                        <div class="img_box2">
                            <img src="/img/map_mimg_bg.png" alt="헤드램프">
                        </div>
                        <div class="img_box">
                            <img src="/img/map_simg_bg.png" alt="헤드램프">
                        </div>
                        <dl>
                            <dt>헤드램프</dt>
                            <dd>- 교체주기</dd>
                            <dd>- 가격대</dd>
                        </dl>
                   
                </form>
                </div>
            </div>
            <div class="write_search">
                    <form action="">
                        <div class="right_area">
                            <input type="text" title="제목/내용">
                            <button type="submit" class="btn_search" title="검색">검색</button>
                        </div>
                    </form>
            </div>
            <div class="board_list"><!-- board_list -->
                <table>
                    <caption>자유게시판</caption>
                    <colgroup>
                        <col style="width:17%" />
                        <col style="width:17%" />
                        <col style="width:auto" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">부품명</th>
                            <th scope="col">영 문</th>
                            <th scope="col">장착위치</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                        <tr>
                            <td>헤드램프</td>
                            <td>head lamp</td>
                            <td class="">자동차 전면 헤드 램프</td>
                        </tr>
                    </tbody>
                </table>
            </div><!-- //board_list -->
            <div class="paging"><!-- paging -->
                <a href="#" class="prev">이전</a>
                <a href="#" class="on">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#" class="next">다음</a>
            </div>
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">개인회원</p>
                    <p class="names_box"><span class="names">홍길동 님</span><span class="car_name elipsis"></span></p>
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
            <div class="shopping_channel">
                <p class="cs_title">carsec 쇼핑채널</p>
                <ul>
                    <li class="pd1"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd2"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_1.jpg" alt="3m자동차 세척용품"></a></li>
                    <li class="pd3"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd4"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_2.jpg" alt="이중구조카페트"></a></li>
                    <li class="pd5"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
                    <li class="pd6"><a href="/web/sub3/shopping1_view.do"><img src="/img/sc_3.jpg" alt="타이어"></a></li>
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