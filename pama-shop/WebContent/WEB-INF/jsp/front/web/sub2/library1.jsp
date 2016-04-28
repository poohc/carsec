<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 자유게시판</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class="on"><a href="/web/sub2/library1.do">자유게시판</a></li>
                <li class=""><a href="/web/sub2/library2.do">사고관련 게시판</a></li>
                <li class=""><a href="/web/sub2/library3.do">신차</a></li>
                <li class=""><a href="/web/sub2/library4.do">리콜</a></li>
                <li class=""><a href="/web/sub2/library5.do">자동차검사</a></li>
                <li class=""><a href="/web/sub2/library6.do">교통법&벌금</a></li>
                <li class=""><a href="/web/sub2/library7.do">드라이브코스</a></li>
                <li class=""><a href="/web/sub2/library8.do">자동차와 사람</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/board_img.jpg" alt="자동차관련 글 게시판입니다."></p>
                <dl class="event">
                    <dt>이벤트 공지</dt>
                    <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                </dl>
                <div class="write_search">
                    <form action="">
                        <div class="left_area">
                            <a href="/web/sub2/library1_write.do" class="btn_search type3" title="글쓰기">글쓰기</a>
                        </div>
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
                            <col style="width:15%" />
                            <col style="width:15%" />
                            <col style="width:auto" />
                            <col style="width:15%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">게시일</th>
                                <th scope="col">닉네임</th>
                                <th scope="col">제 목</th>
                                <th scope="col">추천수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="#">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2015-06-10</td>
                                <td>마스터</td>
                                <td class="left"><a href="/web/sub2/library1_view.do">내차 셀프 점검 자유게시판 제목을 게시합니다.</a></td>
                                <td>4</td>
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
        </div>
        <div class="rnb">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                    <p class="names_box"><span class="names">홍길동 님</span><span class="car_name elipsis"></span></p>
                    
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>     
                </div>
            </form>
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


</body>
</html>