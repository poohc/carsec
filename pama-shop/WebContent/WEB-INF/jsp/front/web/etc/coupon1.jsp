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
            <p class="welcome_member"><span>홍길동</span>&nbsp;&nbsp;회원님 반갑습니다!</p>
            <ul class="information_list">
                <li><a href="/web/etc/password.do">회원정보 수정</a></li>
                <li><a href="/web/etc/estimate1.do">견적</a></li>
                <li class="on"><a href="/web/etc/coupon1.do">쿠폰</a></li>
                <li><a href="/web/etc/qna.do">1:1문의</a></li>
                <li class=""><a href="/web/etc/unregister.do">회원탈퇴</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="layout_type1">

            <ul id="tab" class="tablist tablist4"><!-- 탭 -->
                <li class="on"><a href="#tab1"><span>사용가능 쿠폰</span></a></li>
                <li><a href="#tab2"><span>사용완료/지난쿠폰</span></a></li>
                <li><a href="#tab3"><span>환불내역</span></a></li>
            </ul>
            <div id="tab1" class="tab_contents">
                <ul class="coupon_list">
                    <li>
                        <form action="coupon1.jsp">
                            <div class="coupon_ticket">
                                <p>COUPON</p>
                                <h1>유리코팅 시공권</h1>
                                <span>아우디 A5 2014년식</span>
                                <em>쿠폰번호 : 0000000000000</em>
                            </div>
                            <ul class="coupon_inform">
                                <li class="loc">지역명</li>
                                <li class="loc_name">지점명</li>
                                <li class="numbe">전화번호</li>
                            </ul>
                            <button class="btn_cancel" data-btn="text" type="submit">취소하기</button>
                            <button class="btn_resubmit" data-btn="text" type="submit">코드재발송</button>
                        </form>
                    </li>
                    <li>
                        <form action="coupon1.jsp">
                            <div class="coupon_ticket">
                                <p>COUPON</p>
                                <h1>유리코팅 시공권</h1>
                                <span>아우디 A5 2014년식</span>
                                <em>쿠폰번호 : 0000000000000</em>
                            </div>
                            <ul class="coupon_inform">
                                <li class="loc">지역명</li>
                                <li class="loc_name">지점명</li>
                                <li class="numbe">전화번호</li>
                            </ul>
                            <button class="btn_cancel" data-btn="text" type="submit">취소하기</button>
                            <button class="btn_resubmit" data-btn="text" type="submit">코드재발송</button>
                        </form>
                    </li>
                </ul>
                <p class="coupon_introduce">
                    쿠폰 사용/ 환불 전 약관에 대한 설명<br>
                    제 1 조(목적)<br>
                    제 1 장  총칙<br>
                    제 1 조 (목적) 이 약관은 CARSEC의 www.carsec.co.kr을 이용하여<br>
                    가 쿠폰정보를 제공하는 카색쿠폰 서비스와 회원들의<br>
                    맞춤쿠폰메일 서비스(이하 '쿠폰서비스'라 함.) 신청으로 인한<br>
                    이용자(사용자)의 이용조건 및 절차와 기타 필요한 사항을 규정하는 것을 목적으로 합니다.<br>
                     제 2 조 (약관의 공지) 이 약관의 내용은 '쿠폰서비스' 내용 중 "회원약관" 란을 통하여<br>
                    게시하며 약관이 변경 또는 일부 수정될 경우  NHN㈜와 쿠폰투유는 지체없이<br>
                    서비스의 "공지사항"을 통해 공지합니다.(메일.문자발송을 통해 공지합니다.)<br>
                    1. 이 약관은 카색 웹사이트(www.carsec.co.kr)에서<br>
                    온라인으로 공시함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련법령에<br>
                    위배되지 않는 범위 안에서 개정될 수 있습니다.<br>
                    개정된 약관은 온라인에서 공지함으로써 효력을 발휘하며,<br>
                    이용자의 권리 또는 의무 등 중요한 규정의 개정은 사전에 공지합니다.<br><br>

                    2. 회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며,<br>
                    약관을 변경할 경우에는 지체 없이 이를 사전에 공시합니다.<br><br>

                    3. 이 약관에 동의하는 것은 정기적으로 웹을 방문하여<br>
                    약관의 변경사항을 확인하는 것에 동의함을 의미합니다.<br>
                    변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 회사에서 책임지지 않습니다.
                </p>
            </div>
            <div id="tab2" class="tab_contents">
                <ul class="coupon_list">
                    <li>
                        <form action="coupon1.jsp">
                            <div class="coupon_ticket">
                                <p>COUPON</p>
                                <h1>유리코팅 시공권</h1>
                                <span>아우디 A5 2014년식</span>
                                <em>쿠폰번호 : 0000000000000</em>
                            </div>
                            <ul class="coupon_inform">
                                <li class="loc">지역명</li>
                                <li class="loc_name">지점명</li>
                                <li class="numbe">전화번호</li>
                            </ul>
                        </form>
                    </li>
                </ul>
                <p class="text_type3 mb_5">한줄후기</p>
                <input type="text" class="oneline_comment mb_5"><button type="submit" class="button_type1 mb_5 h_28">등록하기</button>
                <p class="coupon_introduce">
                    쿠폰 사용/ 환불 전 약관에 대한 설명<br>
                    제 1 조(목적)<br>
                    제 1 장  총칙<br>
                    제 1 조 (목적) 이 약관은 CARSEC의 www.carsec.co.kr을 이용하여<br>
                    가 쿠폰정보를 제공하는 카색쿠폰 서비스와 회원들의<br>
                    맞춤쿠폰메일 서비스(이하 '쿠폰서비스'라 함.) 신청으로 인한<br>
                    이용자(사용자)의 이용조건 및 절차와 기타 필요한 사항을 규정하는 것을 목적으로 합니다.<br>
                     제 2 조 (약관의 공지) 이 약관의 내용은 '쿠폰서비스' 내용 중 "회원약관" 란을 통하여<br>
                    게시하며 약관이 변경 또는 일부 수정될 경우  NHN㈜와 쿠폰투유는 지체없이<br>
                    서비스의 "공지사항"을 통해 공지합니다.(메일.문자발송을 통해 공지합니다.)<br>
                    1. 이 약관은 카색 웹사이트(www.carsec.co.kr)에서<br>
                    온라인으로 공시함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련법령에<br>
                    위배되지 않는 범위 안에서 개정될 수 있습니다.<br>
                    개정된 약관은 온라인에서 공지함으로써 효력을 발휘하며,<br>
                    이용자의 권리 또는 의무 등 중요한 규정의 개정은 사전에 공지합니다.<br><br>

                    2. 회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며,<br>
                    약관을 변경할 경우에는 지체 없이 이를 사전에 공시합니다.<br><br>

                    3. 이 약관에 동의하는 것은 정기적으로 웹을 방문하여<br>
                    약관의 변경사항을 확인하는 것에 동의함을 의미합니다.<br>
                    변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 회사에서 책임지지 않습니다.
                </p>
            </div>
            <div id="tab3" class="tab_contents">
                <ul class="coupon_list">
                    <li>
                        <form action="coupon1.jsp">
                            <div class="coupon_ticket">
                                <p>COUPON</p>
                                <h1>유리코팅 시공권</h1>
                                <span>아우디 A5 2014년식</span>
                                <em>쿠폰번호 : 0000000000000</em>
                            </div>
                            <ul class="coupon_inform">
                                <li class="loc">지역명</li>
                                <li class="loc_name">지점명</li>
                                <li class="numbe">전화번호</li>
                            </ul>
                        </form>
                    </li>
                </ul>
                <p class="text_type3 mb_5">환불 정보</p>
                <dl class="form_type3">
                    <dt><label for="bank">은행</label></dt>
                    <dd class="mr_30"><span class="selectbox type1">
                            <select id="bank" title="은행">
                                <option value="">하나은행</option>
                                <option value="">국민은행</option>
                                <option value="">농협</option>
                                <option value="">농협</option>
                            </select>
                        </span>
                    </dd>
                    <dt><label for="banknumber">계좌번호</label></dt>
                    <dd class="mr_100"><input type="text" class="input_type2"></dd>
                    <dt><label for="banknumber">예금주</label></dt>
                    <dd><input type="text" class="input_type2" placeholder="회원 본인 예금주"></dd>
                    <dd class="ml_50"><button class="button_type1">환불신청</button></dd>
                </dl>
                <p class="text_type3 mb_15">- 미사용 쿠폰 환불은 10% 공제 후 현금으로 전송한 계좌로 7일이내 환불하여 드립니다. <span class="span_type1">00,000 원</span></p>
                <p class="coupon_introduce">
                    쿠폰 사용/ 환불 전 약관에 대한 설명<br>
                    제 1 조(목적)<br>
                    제 1 장  총칙<br>
                    제 1 조 (목적) 이 약관은 CARSEC의 www.carsec.co.kr을 이용하여<br>
                    가 쿠폰정보를 제공하는 카색쿠폰 서비스와 회원들의<br>
                    맞춤쿠폰메일 서비스(이하 '쿠폰서비스'라 함.) 신청으로 인한<br>
                    이용자(사용자)의 이용조건 및 절차와 기타 필요한 사항을 규정하는 것을 목적으로 합니다.<br>
                     제 2 조 (약관의 공지) 이 약관의 내용은 '쿠폰서비스' 내용 중 "회원약관" 란을 통하여<br>
                    게시하며 약관이 변경 또는 일부 수정될 경우  NHN㈜와 쿠폰투유는 지체없이<br>
                    서비스의 "공지사항"을 통해 공지합니다.(메일.문자발송을 통해 공지합니다.)<br>
                    1. 이 약관은 카색 웹사이트(www.carsec.co.kr)에서<br>
                    온라인으로 공시함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련법령에<br>
                    위배되지 않는 범위 안에서 개정될 수 있습니다.<br>
                    개정된 약관은 온라인에서 공지함으로써 효력을 발휘하며,<br>
                    이용자의 권리 또는 의무 등 중요한 규정의 개정은 사전에 공지합니다.<br><br>

                    2. 회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며,<br>
                    약관을 변경할 경우에는 지체 없이 이를 사전에 공시합니다.<br><br>

                    3. 이 약관에 동의하는 것은 정기적으로 웹을 방문하여<br>
                    약관의 변경사항을 확인하는 것에 동의함을 의미합니다.<br>
                    변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 회사에서 책임지지 않습니다.
                </p>
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