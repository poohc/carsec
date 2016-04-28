
/*************************************************************************************************
 *
 * Navigation
 *
 *************************************************************************************************/
function mainNav(){
      var mainNav = [
            {'depth1':'채용공고', 'depth1_u':'javascript:;',"depth2": [
                  {"name": "업종별", "url": "recruit_type1.html"},
                  {"name": "직종별", "url": "recruit_type1.html"},
                  {"name": "지역별", "url": "recruit_type2.html"},
                  {"name": "매출액별", "url": "good_c1.html"},
                  {"name": "우수추천기업", "url": "good_c1.html"},
                  {"name": "IBK명예의전당 & 최고경영자클럽가입", "url": "good_c1.html"},
                  {"name": "대기업 협력사 채용관", "url": "good_c1.html"},
                  {"name": "제대군인/특성화고/시니어", "url": "good_c1.html"}
            ]},
            {'depth1':'취업자료실', 'depth1_u':'javascript:;',"depth2": [
                  {"name": "알짜기업 집중탐방", "url": "data_type1.html"},
                  {"name": "잡월드 행사후기", "url": "data_type2.html"},
                  {"name": "이력서 샘플", "url": "data_type3.html"},
                  {"name": "자기소개서 샘플", "url": "data_type4.html"},
                  {"name": "FAQ", "url": "data_type5.html"}
            ]},
            {'depth1':'공지/이벤트', 'depth1_u':'javascript:;',"depth2": [
                  {"name": "공지사항", "url": "notice_list.html"},
                  {"name": "행사/이벤트", "url": "event_list.html"},
                  {"name": "당첨자 발표", "url": "event_end_list.html"}
            ]},
            {'depth1':'취업박람회/특강', 'depth1_u':'javascript:;',"depth2": [
                  {"name": "취업박람회", "url": "sub04_01.html"},
                  {"name": "취업특강", "url": "sub04_02.html"}
            ]},
            {'depth1':'일자리 서포터즈', 'depth1_u':'javascript:;',"depth2": [
                  {"name": "제7기 서포터즈", "url": "support_list.html"}
            ]}
      ];

      $('#gnb').empty();


	// 로그인전
    var memMenu = '<div class="side_top">';
        memMenu += '<p class="side_title"><span>홍길동</span> 회원님</p>';
	    memMenu += '<ul class="btn_member">';
		memMenu += '<li><span>1</span></li>';
        memMenu += '<li><span>1</span></li>';
        memMenu += '<li><span>1</span></li>';
		memMenu += '<li></li>';
        memMenu += '</ul>';
	    memMenu += '</div>';


	// 로그인후
	var loginMenu = '<div class="side_detail">';
        loginMenu += '<img src="common/img/mycar.png" alt="" />';
        loginMenu += '<p class="nameing">람보르기니 무르시엘라고</p>';
		loginMenu += '<span class="howold"><em>2014</em>년식</span> ';
		loginMenu += '<p class="meter"><span>125,000</span> Km</p>';
	loginMenu += '</div>';

	// 마이페이지
	var mypageMenu = '<ul class="side_list">';
		mypageMenu += '<li><a href="#">마이페이지</a></li>';
		mypageMenu += '<li><a href="#">쿠폰함 바로가기</a></li>';
		mypageMenu += '<li><a href="#">정비 쇼핑</a></li>';
        mypageMenu += '<li><a href="#">1:1 문의</a></li>';
        mypageMenu += '<li><a href="#">SELF진단 바로가기</a></li>';
		mypageMenu += '<li><a href="#">로그아웃</a></li>';
	mypageMenu += '</ul>';

    var ulRoof = '<div class="last_foot">';
         ulRoof += '<p class="foot_info">CARSEC 자동차 정비 토탈 솔루션 <br />사업자등록번호  130-87-06820 <br />통신판매신고 <br />경기도 성남시 분당구 분당로 222 <br />개인정보보호 책임자 구자현 </p>';
        ulRoof += '<p class="side_last"><span>고객센터</span> 031-731-9333</p>';
        ulRoof += '</div>';



	$('#gnb').append(memMenu);
	$('#gnb').append(loginMenu);
	$('#gnb').append(mypageMenu);
	$('#gnb').append(ulRoof);

	// 메뉴 영역 클릭시 토글
	$('#gnb .mainNavi dt').find('a').bind({
		'click':function(e){
			  if($(this).hasClass('open')){
					$('#gnb').find('dd').slideUp();
					$('#gnb dt').find('a').attr('class','open');
					$(this).attr('class','close');
					$(this).parent().next().slideDown();
			  } else{
					$(this).attr('class','open');
					$(this).parent().next().slideUp();
			  }
		}
	});
}