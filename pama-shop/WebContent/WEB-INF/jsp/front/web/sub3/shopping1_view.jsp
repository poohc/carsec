<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 쇼핑</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="sub_notice margin0">
            <ul class="system_notice">
                <li class="on"><a href="#">공지사항</a></li>
                <li class=""><a href="#">시스템 작업 공지</a></li>
            </ul>
            <!--form action="check1.html">
                <div class="private_info">
                    <p class="pri_type">일반회원</p>
                     <p class="names_box"><span class="names">홍길동님</span><span class="car_name elipsis"></span></p>
                    <ul class="estimate">
                        <li class="demand"><a href="/web/etc/estimate1.do">요청견적<em>2</em></a></li>
                        <li class="recieve"><a href="/web/etc/estimate2.do">받은견적<em>2</em></a></li>
                        <li class="couponbox"><a href="/web/etc/coupon1.do">쿠폰함 <em>2</em></a></li>
                    </ul>
                    <a href="/web/etc/password.do" class="modify a_style">수정</a>
                </div>
            </form-->
        </div>
        <div class="content0">
            <ul class="tablist check_part">
                <li class="on"><a href="/web/sub3/shopping1.do">병원</a></li>
                <li class=""><a href="/web/sub3/shopping2.do">뷰티샵</a></li>
                <li class=""><a href="/web/sub3/shopping3.do">Culture</a></li>
            </ul>
            <div class="category">
                <div class="category_tit"><span>병원카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li class="on"><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop1">엔진정비</a></li>
                    <li><a href="#shop1">브레이크오일</a></li>
                    <li><a href="#shop1">벨트관련</a></li>
                    <li><a href="#shop1">하체부품 관련</a></li>
                    <li><a href="#shop1">타이밍벨트</a></li>
                </ul>
                <ul class="hospital_list type2">
                    <li><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop1">엔진정비</a></li>
                    <li><a href="#shop1">브레이크오일</a></li>
                    <li><a href="#shop1">벨트관련</a></li>
                    <li><a href="#shop1">하체부품 관련</a></li>
                    <li><a href="#shop1">타이밍벨트</a></li>
                </ul>
                </div>
            </div>
        </div>
        
        <div class="content3">
            <img src="/img/coupon/engine_thum.jpg" alt="엔진오일" class="product_view1">
            <div class="buy_box">
                <p class="buy_num">상품번호 : 20142233</p>
                <h1>Castrol EDGE 합성유 5W-30</h1>
                <p><span>판매가</span><em>79,000 <b>원</b></em></p>
                <p><span>판매방법</span><b>온라인쿠폰</b></p>
                
                
                <div class="selectbox_area"><!-- 검색박스 -->
                    <form>
                        <fieldset class="num">
                            <label for="number">상품옵션</label>
                            <span class="selectbox">
                                <select id="number" title="상품옵션">
                                    <option value="">1</option>
                                    <option value="">2</option>
                                    <option value="">3</option>
                                    <option value="">4</option>
                                    <option value="">5</option>
                                    <option value="">6</option>
                                    <option value="">7</option>
                                    <option value="">8</option>
                                    <option value="">9</option>
                                    <option value="">10</option>
                                </select>
                            </span>
                        </fieldset>
                        <fieldset class="kind">
                            <label for="kind">상품옵션</label>
                            <span class="selectbox">
                                <select id="kind" title="상품옵션">
                                    <option value="">경차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                    <option value="">소형차</option>
                                </select>
                            </span>
                        </fieldset>
                    </form>
                </div>
                <a href="/web/sub3/order.do"><input type="submit" value="주문하기" class="input_type4">
            </div>
        </div>
        <div class="container2">
            <div class="content2">
                <img src="/img/h1_productview.jpg" alt="상품상세" class="h1_productview">
                <div class="img_zone"><img src="/img/coupon/engine_detail.jpg" alt="상품상세이미지"></div>
                <dl class="dl_type2">
                    <dt>협력업체 소개</dt>
                    <dd>업체명 : 송도카센터<br><br>사업자등록번호 : 100-00-0000<br><br>정비서비스 : 엔진오일 미션오일 교환<br><br>대표자 : 홍길동<br><br>전화번호 : 032-333-3333<br><br>주소 : 인천광역시 연수구 송도동 7-50 갯벌타워 311호</dd>
                </dl>
                <dl class="dl_type2">
                    <dt>판매조건</dt>
                    <dd>쿠폰 판매에 대하여 관리자에서 상품 등록시 등록.. </dd>
                </dl>
                <dl class="dl_type2">
                    <dt>쿠폰서비스 이용안내</dt>
                    <dd>정비 쿠폰을 구입을 하면 고객님의 휴대폰으로 문자 메시지가 전송됩니다. <br>받은 문자 메시지의 쿠폰 번호를 보여주시고 인증하시면 결제가 완료 됩니다. <br> 쿠폰은 구입 후 OO안에 취소가 가능하며, 이용 만기일이 지난 쿠폰은 일정 수수료를 공제 후 현금으로 환불 해 드립니다. <br>쿠폰 결제/사용/취소 문의는 고객센터로 연락 주시기 바랍니다.</dd>
                </dl>
            </div>
            <!--div class="rnb2">
                <div class="banner2">
                    <ul>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
                        <li><a href="#"><img src="/img/application.jpg" alt="배너"></a></li>
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
            </div-->
        </div>
    </div>


<script>

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
</script>

</body>
</html>