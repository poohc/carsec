<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쇼핑</title>
<script type="text/javascript">
<!--
function prdOptionRemove(obj) {
	$(obj).parent().remove();
}

function newOption(obj) {
	if (obj.value=="") return;
	option = obj.value.split("|");
	var chkInput = true;
	var optionInput = $("#optId");
	$('input[name="optId"]').each(function() {
    	if($(this).val()==option[0]) {
    		chkInput = false;
    	}
	});

	if (chkInput) {
		$("#optInfobox").after(" " +
	        	"<div><label for='kind'>&nbsp;</label>" +
	        	"&nbsp;<input type=\"hidden\" name=\"oldOptId\" id=\"oldOptId\" value=\"\"/>" +
	        	"<input type=\"hidden\" name=\"optId\" id=\"optId\" value=\""+option[0]+"\"/>" +
	        	"<input type=\"hidden\" name=\"optName\" id=\"optName\" value=\""+option[1]+"\" readOnly/>" +
	        	"<input type=\"hidden\" name=\"optPrice\" id=\"optPrice\" maxlength=\"50\" size=\"13\" value=\""+option[2]+"\" readOnly/> - " +
	        	 option[1] +"&nbsp;" + option[2] +
	        	"&nbsp;<input type=\"button\" value=\"삭 제\" onClick=\"prdOptionRemove(this);\"/>" +
	        	"</div>" +
				"");
	}
}
//-->
</script>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="sub_notice margin0" style="">
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
                <li<c:if test="${productSearchVO.sortTree=='10'}"> class="on"</c:if>><a href="/prd/productList.do?sortTree=10">병원</a></li>
                <li<c:if test="${productSearchVO.sortTree=='20'}"> class="on"</c:if>><a href="/prd/productList.do?sortTree=20">뷰티샵</a></li>
                <li<c:if test="${productSearchVO.sortTree=='30'}"> class="on"</c:if>><a href="/prd/productList.do?sortTree=30">Culture</a></li>
            </ul>
            <div class="category">
            	<c:if test="${productSearchVO.sortTree=='10'}">
                <div class="category_tit"><span>병원 카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li class="on"><a href="#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">타이밍벨트</a></li>
                </ul>
                <ul class="hospital_list type2">
                    <li><a href="/prd/productList.do?sortTree=10#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=10#shop1">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>

            	<c:if test="${productSearchVO.sortTree=='20'}">
                <div class="category_tit"><span>뷰티샵 카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li class="on"><a href="#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">타이밍벨트</a></li>
                </ul>
                <ul class="hospital_list type2">
                    <li><a href="/prd/productList.do?sortTree=20#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=20#shop1">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>

            	<c:if test="${productSearchVO.sortTree=='30'}">
                <div class="category_tit"><span>Culture 카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li class="on"><a href="#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">타이밍벨트</a></li>
                </ul>
                <ul class="hospital_list type2">
                    <li><a href="/prd/productList.do?sortTree=30#shop1">엔진오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop2">미션오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">엔진정비</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">브레이크오일</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">벨트관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">하체부품 관련</a></li>
                    <li><a href="/prd/productList.do?sortTree=30#shop1">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>
            </div>
        </div>

        <div class="content3">
        	<c:forEach items="${productVO.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
               	<c:choose>
                    <c:when test="${productAttachementList.imageType == '1'}">
       			<img src="/media/${productAttachementList.fileName}.image" alt="엔진오일" class="product_view1">
       				</c:when>
       			</c:choose>
        	</c:forEach>
            <div class="buy_box">
                <h1>${productVO.prdName}</h1>
                <p>[협력업체지역] <span>${productVO.accountVO.firstName}</span></p>
                <em>${productVO.price} <b>원</b></em>
                <img src="/img/option.gif" alt="옵션" class="option">
                <form method="POST" action="/ord/orderForm.do">
                <input type="hidden" name="prdId" id="prdId" value="${productVO.prdId}" />
                <div class="selectbox_area"><!-- 검색박스 -->
	                <fieldset class="num">
	                    <label for="number">수량</label>
	                    <span class="selectbox">
	                        <select name="qty" id="number" title="수량 선택">
	                            <option value="1">1</option>
	                            <option value="2">2</option>
	                            <option value="3">3</option>
	                            <option value="4">4</option>
	                            <option value="5">5</option>
	                            <option value="6">6</option>
	                            <option value="7">7</option>
	                            <option value="8">8</option>
	                            <option value="9">9</option>
	                            <option value="10">10</option>
	                        </select>
	                    </span>
	                </fieldset>
	                <fieldset class="kind">
	                    <label for="kind">옵션</label>
	                    <span class="selectbox">
	                        <select name="optInfoId" id="kind" title="옵션 선택" onChange="newOption(this);">
	                        	<option value="">선택</option>
	                            <c:forEach items="${productVO.productOptVO}" var="productOptList" varStatus="productOptListCount">
	                            <option value="${productOptList.optId}|${productOptList.optName}|${productOptList.optPrice}">${productOptList.optName}(+${productOptList.optPrice}원)</option>
	                            </c:forEach>
	                        </select>
	                    </span>
	                </fieldset>
	                <fieldset class="kind" id="optInfobox">
	                </fieldset>
                </div>
                <input type="submit" value="쿠폰 구매하기" class="input_type4">
                </form>
            </div>
        </div>
        <div class="container2">
         <div class="content2">
                <img src="/img/h1_productview.jpg" alt="상품상세" class="h1_productview">
                <div class="img_zone">
                <c:forEach items="${productVO.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '2'}">
        			 <img src="/media/${productAttachementList.fileName}.image" alt="상품상세" />
        				</c:when>
        			</c:choose>
        		</c:forEach>
                </div>
                <dl class="dl_type2">
                    <dt>협력업체 소개</dt>
                    <dd>업체명 : ${productVO.accountVO.firstName}<br><br>사업자등록번호 : ${productVO.accountVO.accountMechanicInfoVO.bizNumber}<br><br>정비서비스 : 엔진오일 미션오일 교환<br><br>대표자 : ${productVO.accountVO.lastName}<br><br>전화번호 : ${productVO.accountVO.tel}<br><br>주소 : ${productVO.accountVO.addr1}</dd>
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