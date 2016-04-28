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
                <li class=""><a href="/web/sub2/library1.do">자유게시판</a></li>
                <li class=""><a href="/web/sub2/library2.do">사고관련 게시판</a></li>
                <li class=""><a href="/web/sub2/library3.do">신차 뉴스</a></li>
                <li class=""><a href="/web/sub2/library4.do">리콜 소식</a></li>
                <li class=""><a href="/web/sub2/library5.do">자동차 검사</a></li>
                <li class=""><a href="/web/sub2/library6.do">교통법 및 벌금</a></li>
                <li class=""><a href="/web/sub2/library7.do">드라이브 코스</a></li>
                <li class=""><a href="/web/sub2/library8.do">자동차와 사람</a></li>
                <li class="on"><a href="/web/sub2/library9.do">이벤트</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/library9.jpg" alt="진행중인이벤트"></p>
                <dl class="event">
                    <dt>이벤트 공지</dt>
                    <dd>이벤트 공지 게시판의 글을 올립니다.</dd>
                </dl>
                <div class="event_layout2">
                    <h1>CARSEC 차량 비교 이벤트</h1>
                    <div class="compare vs1">
                        <img src="/img/event_car1.png" alt="현대자동차yf소나타이미지">
                        <p class="red_name">현대 자동차 YF소나타</p>
                        <dl class="spec">
                            <dt>제 원</dt>
                            <dd>제원</dd>
                        </dl>
                        <dl class="performance">
                            <dt>성 능</dt>
                            <dd>성능</dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                                <em class="best"><img src="/img/best.png" alt="best"></em>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                    </div>
                    <div class="compare vs2">
                        <img src="/img/event_car2.png" alt="현대자동차yf소나타이미지">
                        <p class="red_name">르노 삼성 자동차 SM5</p>
                        <dl class="spec">
                            <dt>제 원</dt>
                            <dd>제 원</dd>
                        </dl>
                        <dl class="performance">
                            <dt>성 능</dt>
                            <dd>성 능</dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                                <em class="best"><img src="/img/best.png" alt="best"></em>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                        <dl class="comment_view">
                            <dt>댓글쓴이
                                <p>추천 : <span>560</span></p>
                            </dt>
                            <dd>
                                YF 소나타가 최고지요~~
                                <input type="submit" class="refer" value="추천">
                            </dd>
                        </dl>
                    </div>
                </div>
                <form action="library9_view.jsp">
                    <fieldset class="event_comment">
                        <legend class="blind">댓글남기기</legend>
                        <label class="radio_type2" for="input_radio01"><input id="input_radio01" type="radio" name="input_radio01" checked="checked">YF 소나타</label>
                        <label for="input_radio02" class="radio_type2"><input type="radio" id="input_radio02" name="input_radio01">르노 삼성 SM5</label>
                        <p>댓글 남기기 <span>0</span>/200자</p>
                        <textarea class="first_comm" title="제목/내용" rows="3" cols="30" id="comment" name="comment"></textarea>
                        <button title="등록" class="btn_search" type="submit">응모</button>
                    </fieldset>
                </form>

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