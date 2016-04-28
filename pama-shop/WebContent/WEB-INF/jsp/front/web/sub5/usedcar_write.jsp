<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 궁조차</title>
<script type="text/javascript" src="/common/js/common-ui.js"></script>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="content">
            <ul class="tablist check_part">
                <li class=""><a href="/web/sub5/recruit.do">정비소 구인</a></li>
                <li class=""><a href="/web/sub5/recruit_write.do">구직등록</a></li>
                <li class=""><a href="/web/sub5/usedcar.do">중고차 매매</a></li>
            </ul>
            <div class="layout_type1">
                <p class="way_introduce way_type1"><img src="/img/recruit.jpg" alt="구인구직정보"></p>
                <div class="recruit_box">
                    <h1>중고차 매물 등록</h1>
                    <form action="usedcar.do">
                        <table>
                            <caption>중고차 매물등록 게시판</caption>
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
                                    <th>제조사</th>
                                    <td><span class="selectbox type2">
                                            <select id="number" title="제조사">
                                                <option value="">현대</option>
                                                <option value="">대우</option>
                                                <option value="">대우</option>
                                                <option value="">대우</option>
                                            </select>
                                        </span>
                                    </td>
                                    <th class="t_c">모델명</th>
                                    <td class="t_r">
                                        <span class="selectbox type2">
                                            <select id="number" title="모델명">
                                                <option value="">i30</option>
                                                <option value="">i30</option>
                                                <option value="">i30</option>
                                                <option value="">i30</option>
                                            </select>
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="">연식</th>
                                    <td><span class="enter_st4"><input type="text" title="연식"></span> 식</td>
                                    <th class="">주행거리</th>
                                    <td><span class="enter_st4"><input type="text" title="주행거리"></span> km</td>
                                </tr>
                                <tr>
                                    <th class="">가격</th>
                                    <td><span class="enter_st4"><input type="text" title="가격"></span> 원</td>
                                    <th class="">색상</th>
                                    <td><span class="enter_st4"><input type="text" title="색상"></span></td>
                                </tr>
                                 <tr>
                                    <th class="">사고여부</th>
                                    <td>
                                        <label class="radio_type2 type3" for="input_radio01"><input id="input_radio01" type="radio" name="input_radio01" checked="checked">예</label>
                                        <label for="input_radio02" class="radio_type2 type3"><input type="radio" id="input_radio02" name="input_radio01">아니오</label>
                                    </td>
                                </tr>
                                <tr>
                                    <th colspan="4" class="t_c">사진등록</th>
                                </tr>
                                <tr>
                                    <th class="">앞</th>
                                    <td colspan="2">
                                        <span class="upload_file">
                                            <span class="enter_st enter_st2"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                                            <span class="btn_find_file">
                                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                                            </span>
                                        </span>
                                    </td>
                                    <td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG</td>
                                </tr>
                                <tr>
                                    <th class="">좌측옆</th>
                                    <td colspan="2">
                                        <span class="upload_file">
                                            <span class="enter_st enter_st2"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                                            <span class="btn_find_file">
                                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                                            </span>
                                        </span>
                                    </td>
                                    <td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG</td>
                                </tr>
                                <tr>
                                    <th class="">우측옆</th>
                                    <td colspan="2">
                                        <span class="upload_file">
                                            <span class="enter_st enter_st2"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                                            <span class="btn_find_file">
                                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                                            </span>
                                        </span>
                                    </td>
                                    <td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG</td>
                                </tr>
                                <tr>
                                    <th class="">뒤</th>
                                    <td colspan="2">
                                        <span class="upload_file">
                                            <span class="enter_st enter_st2"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                                            <span class="btn_find_file">
                                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                                            </span>
                                        </span>
                                    </td>
                                    <td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG</td>
                                </tr>
                                <tr>
                                    <th class="">실내</th>
                                    <td colspan="2">
                                        <span class="upload_file">
                                            <span class="enter_st enter_st2"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                                            <span class="btn_find_file">
                                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                                            </span>
                                        </span>
                                    </td>
                                    <td class="little_letter">100KB 이내의<br>JPEG,GIF,PNG</td>
                                </tr>
                                <tr>
                                    <th>매마자</th>
                                    <td><span class="enter_st2"><input type="text" title="제목"></span></td>
                                    <th colspan="">연락처</th>
                                    <td>
                                        <span class="selectbox type5">
                                            <select id="number" title="번도">
                                                <option value="">010</option>
                                                <option value="">011</option>
                                                <option value="">019</option>
                                            </select>
                                        </span>
                                        <span class="enter enter_st3"><input type="text" title="제목"></span>
                                        <span class="enter enter_st3"><input type="text" title="제목"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <th colspan="4">상세설명</th>
                                </tr>
                                <tr>
                                    <th colspan="4">
                                        <textarea name="cont" id="cont" cols="30" rows="10"></textarea>
                                    </th>
                                </tr>
                                <tr>
                                    <td colspan="3"></th>
                                    <td></th>
                                </tr>
                                <tr>
                                    <th colspan="4" class="po_r">
                                        <input type="checkbox" id="check2" data-from="checkbox">
                                        <label for="check2">구직글 등록시 입력된 정보를 업체회원에 열람하는 것에 동의합니다.</label>
                                        <input type="submit" class="input_type6" value="등록">
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
                    <p class="pri_type">일반회원</p>
                    <p class="names">홍길동 님</p>
                    <p class="car_name elipsis">람보르기니이탈리아</p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                    <a href="/web/sub1/check1.do" class="mycar a_style">내차</a>
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