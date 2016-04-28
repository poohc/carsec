<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 쿠폰</title>
</head>
<body>
    <!-- contain -->
    <div class="header_etc">
        <div class="wrap_header2">
            <p class="welcome_member">송도카센터</p>
            <ul class="information_list">
                <li class=""><a href="/web/etc/estimate1_agency.do">견적</a></li>
                <li class="on"><a href="/web/etc/coupon1_agency.do">쿠폰 사용처리</a></li>
                <li><a href="/web/etc/qna_agency.do">1:1문의</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">
            <ul id="tab" class="tablist tablist4"><!-- 탭 -->
                <li class="on"><a href="#tab1"><span>쿠폰사용 등록</span></a></li>
                <li><a href="#tab2"><span>쿠폰사용 리스트</span></a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <form action="coupon1.jsp">
                    <ul class="coupon_list">
                        <li>
                            <div class="coupon_ticket">
                                <h1>유리코팅 시공권</h1>
                                <p>상품의 옵션명</p>
                                <span>아우디 A5 2014년식</span>
                                <em>회원 닉네임</em>
                            </div>
                            <div>
                            	<ul>
                            		<li>
                            			<h2>쿠폰 판매가</h2>
                            			<h2>990,0000<span>원</span></h2>
                            		</li>
                            		<li>
                            			<label for="coupon_number" class="coupon_label">쿠폰번호입력</label>
                          				<input type="text" id="coupon_number" class="input_type2">
                                        <button class="button_type1 poa_type1" data-btn="text" type="submit">쿠폰결제</button>
                            		</li>
                            	</ul>
                            </div>           
                        </li>
                        <li>
                            <div class="coupon_ticket">
                                <h1>유리코팅 시공권</h1>
                                <p>상품의 옵션명</p>
                                <span>아우디 A5 2014년식</span>
                                <em>회원 닉네임</em>
                            </div>
                            <div>
                            	<ul>
                            		<li>
                            			<h2>쿠폰 판매가</h2>
                            			<h2>990,0000<span>원</span></h2>
                            		</li>
                            		<li>
                            			<label for="coupon_number" class="coupon_label">쿠폰번호입력</label>
                          				<input type="text" id="coupon_number" class="input_type2">
                                        <button class="button_type1 poa_type1" data-btn="text" type="submit">쿠폰결제</button>
                            		</li>
                            	</ul>
                            </div>           
                        </li>
                </form>
                <div class="textbox_type1">
                    <p class="intitle">TIP!</p>
                    <p class="incont">쿠폰번호를 입력 후 결제가 완료되면 바로옆의 탭으로 정보가 이동...</p>
                </div>
            </div>
            <div id="tab2" class="tab_contents">
                <div class="board_list3 mt_27"><!-- board_list -->
                    <table class="">
                        <caption>쿠폰입금대기 게시판</caption>
                        <colgroup>
                            <col style="width:14%" />
                            <col style="width:14%" />
                            <col style="width:14%" />
                            <col style="width:auto" />
                            <col style="width:17%" />
                            <col style="width:17%" />
                            <col style="width:auto" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col">결제번호</th>
                                <th scope="col">결제일</th>
                                <th scope="col">쿠폰번호</th>
                                <th scope="col">쿠폰명</th>
                                <th scope="col">결제금액(공제후)</th>
                                <th scope="col">닉네임</th>
                                <th scope="col">상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="">
                                <td>20150818003</td>
                                <td>2015-08-18</td>
                                <td>0000000</td>
                                <td>엔진 오일 교환권 A</td>
                                <td>47,5000<span>원</span></td>
                                <td>아이콘미디어랩</td>
                                <td>입금예정</td>
                            </tr>
                            <tr class="">
                                <td>20150818002</td>
                                <td>2015-08-18</td>
                                <td>0000000</td>
                                <td>엔진 오일 교환권 A</td>
                                <td>47,5000<span>원</span></td>
                                <td>아이콘미디어랩</td>
                                <td>입금예정</td>
                            </tr>
                            <tr class="">
                                <td>20150818001</td>
                                <td>2015-08-18</td>
                                <td>0000000</td>
                                <td>엔진 오일 교환권 A</td>
                                <td>47,5000<span>원</span></td>
                                <td>아이콘미디어랩</td>
                                <td>입금완료</td>
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
                <div class="textbox_type1">
                    <p class="intitle">TIP!</p>
                    <p class="incont">입금완료시 텍스트 색상 변경</p>
                </div>
        </div>
    </div>

<script>
    /**********************************************************************************/
// 탭
/**********************************************************************************/
$(function(){
    $('.tab_contents:eq(0)').show();
    $('#tab li a').click(function(){
        $('#tab li').removeClass('on');
        $(this).parent().addClass('on');
        $('.tab_contents').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });
});

// 탭2
$(function(){
    $('.tab_contents').find('.tab_contents_s:eq(0)').show()
    $('.tab_st2 li a').click(function(){
        $('.tab_st2 li').removeClass('on');
        $(this).parent().addClass('on');

        var chk=$(this).parent().parent().parent().attr('id');
        $('#'+chk ).find('.tab_contents_s').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });

    $('#tab li a').click(function(){
        $('.tab_contents .tab_st2 li').removeClass('on');
        $('.tab_contents .tab_st2 li:first-child').addClass('on');
        var showtab=$('.tab_contents .tab_st2 li:first-child a').attr('href');

        $(showtab).show();

        return false;
    })
});

</script>
</body>
</html>