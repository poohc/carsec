<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쇼핑</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
       <div class="sub_notice">
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
       <div class="img_gallery2">
            <div class="pic">
                <img src="/img/hospital1.jpg" alt="">
                <img src="/img/hospital2.jpg" alt="">
                <img src="/img/hospital3.jpg" alt="">
            </div>
            <div class="thum">
                <img src="/img/sonax_banner.jpg" alt="">
                <img src="/img/sonax_banner.jpg" alt="">
                <img src="/img/sonax_banner.jpg" alt="">
            </div>
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
                    <li><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop3">엔진정비</a></li>
                    <li><a href="#shop4">브레이크오일</a></li>
                    <li><a href="#shop5">벨트관련</a></li>
                    <li><a href="#shop6">하체부품 관련</a></li>
                    <li><a href="#shop7">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>

                <c:if test="${productSearchVO.sortTree=='20'}">
                <div class="category_tit"><span>뷰티샵 카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop3">엔진정비</a></li>
                    <li><a href="#shop4">브레이크오일</a></li>
                    <li><a href="#shop5">벨트관련</a></li>
                    <li><a href="#shop6">하체부품 관련</a></li>
                    <li><a href="#shop7">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>

                <c:if test="${productSearchVO.sortTree=='30'}">
                <div class="category_tit"><span>Culture 카테고리</span><a href="#" class="alarm">쇼핑 알림 &gt; 쇼핑 쿠폰제도에 대하여 알려드립니다.</a></div>
                <div class="category_list">
                <ul class="hospital_list type1">
                    <li><a href="#shop1">엔진오일</a></li>
                    <li><a href="#shop2">미션오일</a></li>
                    <li><a href="#shop3">엔진정비</a></li>
                    <li><a href="#shop4">브레이크오일</a></li>
                    <li><a href="#shop5">벨트관련</a></li>
                    <li><a href="#shop6">하체부품 관련</a></li>
                    <li><a href="#shop7">타이밍벨트</a></li>
                </ul>
                </div>
                </c:if>
            </div>
        </div>

        <div class="content2">
        	<c:if test="${not empty productList1.productList}">
        	<img src="/img/h1_engine.jpg" id="shop1" alt="엔진오일" class="engine_h1">
        	<ul class="shop">
        	<c:forEach items="${productList1.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList2.productList}">
            <img src="/img/h1_mission.jpg" id="shop2" alt="미션오일" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList2.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList3.productList}">
            <img src="/img/h1_3.jpg" id="shop3" alt="엔진정비" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList3.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList4.productList}">
            <img src="/img/h1_4.jpg" id="shop4" alt="브레이크오일" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList4.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList5.productList}">
            <img src="/img/h1_5.jpg" id="shop5" alt="벨트관련" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList5.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList6.productList}">
            <img src="/img/h1_6.jpg" id="shop6" alt="하체부품관련" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList6.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
            <c:if test="${not empty productList7.productList}">
            <img src="/img/h1_7.jpg" id="shop7" alt="타이밍벨트" class="engine_h1">
            <ul class="shop">
        	<c:forEach items="${productList7.productList}" var="productList" varStatus="productListCount">
        		<li class="fir"><a href="/prd/productDetail.do?sortTree=${productSearchVO.sortTree}&prdId=${productList.prdId}">
        			<c:forEach items="${productList.productAttachementVO}" var="productAttachementList" varStatus="productAttachementListCount">
                	<c:choose>
	                    <c:when test="${productAttachementList.imageType == '1'}">
        			<img src="/media/${productAttachementList.fileName}.image" alt="상품1">
        				</c:when>
        			</c:choose>
        			</c:forEach>
        			<p class="pro_name">${productList.prdName}</p><span class="local">[협력업체지역]</span><em class="com_name">${productList.accountVO.firstName}</em><i class="money">${productList.price}<b>원</b></i></a>
        		</li>
            </c:forEach>
            </ul>
            </c:if>
        </div>
    </div>


<script>
$(".img_gallery2 .thum img").click(function(){
    var ti = $(this).index();
    $(".img_gallery2 .pic img").not(":eq("+ti+")").removeClass("ch").fadeOut(300);
    $(".img_gallery2 .pic img").eq(ti).addClass("ch").fadeIn(300);
    $(".img_gallery2 .thum img").not(":eq("+ti+")").removeClass("ch1");
    $(".img_gallery2 .thum img").eq(ti).addClass("ch1");
}).eq(0).click();
</script>

</body>
</html>