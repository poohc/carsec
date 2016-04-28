<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 구인구직</title>
<script type="text/javascript" src="/common/js/common-ui.js"></script>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub4/mechanic1.do">신차</a></li>
                <li class=""><a href="/web/sub4/mechanic2.do">신기술</a></li>
                <li class=""><a href="/web/sub4/mechanic3.do">정비사례</a></li>
                <li class="on"><a href="/web/sub4/mechanic5.do">매장매매</a></li>
                <li class=""><a href="/web/sub4/mechanic6.do">업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">정비외 업체리스트</a></li>
                <li class=""><a href="/web/sub4/mechanic7.do">중고부품 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <div class="recruit_box type_agent">
                    <form action="recruit_write.jsp">
                        <table>
                            <caption>CARSEC에이전트 (매장매매) 게시판</caption>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:35%">
                                <col style="width:15%">
                                <col style="width:35%">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>제목</th>
                                    <td colspan="3"><span class="enter_st"><input type="text" title="제목"></span></td>
                                </tr>
                                <tr>
                                    <th>분류</th>
                                    <td colspan="3"><span class="selectbox">
                                            <select id="number" title="분야">
                                                <option value="">자동차정비</option>
                                                <option value="">세차</option>
                                                <option value="">광택</option>
                                                <option value="">판금</option>
                                            </select>
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="">m2(평)</th>
                                    <td class="" colspan="3"><span class="enter_st enter_st3"><input type="text" title="제목"></span> 평</td>
                                </tr>
                                <tr>
                                    <th class="">희망지역</th>
                                    <td colspan="3">
                                        <span class="selectbox mt_5 type2">
                                            <select id="number" title="희망지역">
                                                <option value="">서울특별시</option>
                                                <option value="">경기도</option>
                                                <option value="">경기도</option>
                                                <option value="">경기도</option>
                                            </select>
                                        </span>
                                        <span class="selectbox type3">
                                            <select id="number" title="희망지역">
                                                <option value="">강남구</option>
                                                <option value="">강동구</option>
                                                <option value="">강동구</option>
                                                <option value="">강동구</option>
                                            </select>
                                        </span>
                                        <span class="selectbox type3">
                                            <select id="number" title="희망지역">
                                                <option value="">수서동</option>
                                                <option value="">압구정동</option>
                                                <option value="">압구정동</option>
                                                <option value="">압구정동</option>
                                            </select>
                                        </span>
                                        <span class="enter_st enter_st5"><input type="text" title="제목" placeholder="나머지 주소"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="">보증금</th>
                                    <td colspan="">
                                        <span class="enter_st enter_st6"><input type="text" title="제목"></span> 만원
                                    </td>
                                    <th class="t_c">월세</th>
                                    <td colspan="" class="t_l">
                                        <span class="enter_st enter_st6"><input type="text" title="제목"></span> 만원
                                    </td>
                                </tr>
                                <tr>
                                    <th>권리금</th>
                                    <td colspan="3"><span class="enter_st2"><input type="text" title="제목"></span> 만원</td>
                                </tr>
                                <tr>
                                    <th colspan="">연락처</th>
                                    <td colspan="3">
                                        <span class="selectbox type5">
                                            <select id="number" title="번도">
                                                <option value="">010</option>
                                                <option value="">011</option>
                                                <option value="">016</option>
                                                <option value="">019</option>
                                            </select>
                                        </span>
                                        <span class="enter enter_st3"><input type="text" title="제목"></span>
                                        <span class="enter enter_st3"><input type="text" title="제목"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <th colspan="4">매장 정보 입력</th>
                                </tr>
                                <tr>
                                    <th colspan="4">
                                        <textarea name="cont" id="cont" cols="30" rows="10"></textarea>
                                    </th>
                                </tr>
                                <tr>
                                    <th colspan="4" class="po_r">
                                        <input type="checkbox" id="check2" data-from="checkbox">
                                        <label for="check2">구직글 등록시 입력된 정보를 업체회원에 열람하는 것에 동의합니다.</label>
                                        <a href="/web/sub4/mechanic5.do"><input type="submit" class="input_type6" value="등록하기">
                                    </th>
                                </tr>
                            </tbody>
                        </table>
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