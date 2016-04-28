<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 이벤트</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub1/check1.do">내차SELF 점검</a></li>
                <li class=""><a href="/web/sub1/check3.do">차량부품 Map</a></li>
                <li class="on"><a href="/web/sub1/mechanic_search.do">협력정비업체</a></li>
            </ul>
            <div class="layout_type1">
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
                                <p class="t_title">메카닉회원의 슬로건</p>
                            </th>
                            <tr>
                                <td class="bd_tp">송도카센터</td>
                            </tr>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="3" class="text">
                                <img src="/img/mechanic_pic1.jpg" alt="송도카센터">
                                <p class="gall_text2">정비업체의 사진과 소개는 관리자에서 입력합니다. 포토게시판을 약간 수정한 타입이며, 메카닉회원의 DB에서 정보를 가져와 관리자에서 글을 쓰는 방식인데....논의하시죠... 가벼운 방법으로요..정비업체의 사진과 소개는 관리자에서 입력합니다. 포토게시판을 약간 수정한 타입이며, 메카닉회원의 DB에서 정보를 가져와 관리자에서 글을 쓰는 방식인데....논의하시죠... 가벼운 방법으로요..정비업체의 사진과 소개는 관리자에서 입력합니다. 포토게시판을 약간 수정한 타입이며, 메카닉회원의 DB에서 정보를 가져와 관리자에서 글을 쓰는 방식인데....논의하시죠... 가벼운 방법으로요..정비업체의 사진과 소개는 관리자에서 입력합니다. 포토게시판을 약간 수정한 타입이며, 메카닉회원의 DB에서 정보를 가져와 관리자에서 글을 쓰는 방식인데....논의하시죠... 가벼운 방법으로요..정비업체의 사진과 소개는 관리자에서 입력합니다. 포토게시판을 약간 수정한 타입이며, 메카닉회원의 DB에서 정보를 가져와 관리자에서 글을 쓰는 방식인데....논의하시죠... 가벼운 방법으로요..
                                </p>
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
                            <li class="need_login type2">
                                <textarea name="comment" placeholder="댓글 작성을 위해 로그인 해주세요." id="comment" cols="30" rows="10" title="제목/내용" value="댓글 작성을 위해 로그인 해주세요." class="first_comm"></textarea>
                                <button type="submit" class="btn_search" title="등록">등록</button>
                            </li>
                        </ul>
                        <div class="center_box">
                            <a href="/web/sub2/library3.do" class="btn_type1">목 록</a>
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