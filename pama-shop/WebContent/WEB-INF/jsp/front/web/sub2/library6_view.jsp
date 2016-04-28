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
                <li class=""><a href="/web/sub2/library3.do">신차</a></li>
                <li class=""><a href="/web/sub2/library4.do">리콜</a></li>
                <li class=""><a href="/web/sub2/library5.do">자동차검사</a></li>
                <li class="on"><a href="/web/sub2/library6.do">교통법&벌금</a></li>
                <li class=""><a href="/web/sub2/library7.do">드라이브코스</a></li>
                <li class=""><a href="/web/sub2/library8.do">자동차와 사람</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/library9.jpg" alt="진행중인 이벤트"></p>
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
                                <p class="t_title">신차 소개 게시판 제목</p>
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
                                <img src="/img/gallery3.jpg" alt="bmw자동차이미지">
                                <p class="gall_text2"> 신형 K5는 올해 4분기 하이브리드, 내년 초 플러그인 하이브리드가 각각 추가되면 모두 7개의 파워트레인 라인업을 갖추게
                                된다.신형 K5에 새롭게 탑재되는 감마 1.6 터보 GDI 엔진과 U2 1.7 VGT 엔진은 7단 DCT가 함께 적용된다. 1.6 터보 모델
                                은 최고출력 180마력(ps), 최대토크 27.0kg·m, 복합연비 13.4km/ℓ를 발휘한다.
                                터보 GDI는 2.0 가솔린 모델이 최고출력 168마력(ps), 최대토크 20.5kg·m, 복합연비 12.6km/ℓ의 제원을 갖고 있어 뛰어난
                                동력성능과 연비로 인기를 끌 전망이다.1.7 디젤 모델도 7단 DCT를 탑재해 유로 6 기준을 충족시키는 동시에 복합연비
                                16.8km/ℓ로 경차를 뛰어넘는 동급 최고 수준의 연비를 달성했으며, 최고출력 141마력(ps), 최대토크 34.7kg·m로 수준 높은
                                동력성능을 구현했다. 안전성, 주행성능, 정숙성 등도 진일보했다. 초고장력 강판(AHSS) 적용 비율을 동급 최고 수준인 51%
                                로 확대해 차체강성을 높였고 7 에어백을 전 모델에 기본 적용했다.또 속도 감응형 전동식 파워스티어링 휠(MDPS)의 성능
                                개선을 통해 정교한 조향감을 구현했고 차체 하부에 언더커버를 대폭 확대 적용하는 등 다양한 N.V.H 대책 설계로 높은 정숙
                                성을 실현했다고 설명했다.이밖에도 휴대폰 무선충전 시스템, 동승석 위치 조절 장치, 긴급 제동 시스템(AEB)이 국산 중형차
                                최초로 적용됐고 스마트 트렁크, 어드밴스드 스마트 크루즈 컨트롤(ASCC), 차선이탈 경보 시스템(LDWS). 후측방 경보 시스
                                템(BSD) 등도 탑재된다.
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
                        <div class="paging"><!-- paging -->
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#" class="next">다음</a>
                        </div>
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