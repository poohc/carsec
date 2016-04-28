<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 메카닉</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub4/mechanic1.do">신차</a></li>
                <li class=""><a href="/web/sub4/mechanic2.do">신기술</a></li>
                <li class=""><a href="/web/sub4/mechanic3.do">정비사례</a></li>
                <li class=""><a href="/web/sub4/mechanic5.do">매장매매</a></li>
                <li class="on"><a href="/web/sub4/mechanic6.do">업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">정비외 업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">중고부품 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <div class="recruit_search">
                    <div class="selectbox_area"><!-- 검색박스 -->
                        <form>
                            <label for="number">지역별</label>
                            <span class="selectbox type2">
                                <select id="number" title="지역">
                                    <option value="">서울특별시</option>
                                    <option value="">경기도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                    <option value="">강원도</option>
                                </select>
                            </span>
                            <span class="selectbox type2">
                                <select id="number" title="지역">
                                    <option value="">강남구</option>
                                    <option value="">노원구</option>
                                    <option value="">관악구</option>
                                    <option value="">관악구</option>
                                    <option value="">관악구</option>
                                    <option value="">관악구</option>
                                </select>
                            </span>
                            <label for="kind">서비스품목</label>
                            <span class="selectbox type2">
                                <select id="kind" title="서비스품목">
                                    <option value="">1급공업사</option>
                                    <option value="">2급공업사</option>
                                    <option value="">기본 경정비</option>
                                    <option value="">판금</option>
                                    <option value="">도장</option>
                                    <option value="">덴트</option>
                                    <option value="">썬팅</option>
                                    <option value="">세차</option>
                                    <option value="">타이어</option>
                                    <option value="">카오디오</option>
                                    <option value="">블랙박스</option>
                                    <option value="">네비게이션</option>
                                    <option value="">씨트 인테리어</option>
                                    <option value="">튜닝</option>
                                </select>
                            </span>
                            <!--<input type="submit" value="검색하기" class="input_type6">-->
                        </form>
                    </div>
                </div>
                <div class="board_list"><!-- board_list -->
                    <table>
                        <caption>업체리스트</caption>
                        <colgroup>
                            <col style="width:15%" />
                            <col style="width:30%" />
                            <col style="width:15%" />
                            <col style="width:auto" />
                            <col style="width:15%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">업체명</th>
                                <th scope="col">주소</th>
                                <th scope="col">기술</th>
                                <th scope="col">서비스 품목</th>
                                <th scope="col">전화번호</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
                            </tr>
                            <tr>
                                <td>송도카센터</td>
                                <td>인천시 연수구</td>
                                <td>엔진정비</td>
                                <td>엔진오일</td>
                                <td>032-333-2222</td>
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
                    <p class="pri_type">메카닉회원</p>
                    <p class="names">송도카센터</p>
                    <p class="car_name elipsis"></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1_agency.do">견적요청<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2_agency.do">예약건<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/coupon1_agency.do">쿠폰업무<em>1</em></a></li>
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