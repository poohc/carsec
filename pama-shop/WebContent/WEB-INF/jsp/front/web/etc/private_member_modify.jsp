<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/common1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub1.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/custom1.css" type="text/css" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_wrap">
    <div class="bbs">
   
      <div class="join_fied">
        <form action="#" method="post">
          <fieldset>
            <h3 class="dep2_tit">일반회원가입</h3>
            <p class="joinFieldText">* 표시된 항목은 수정이 불가합니다. </p>
            <table width="100%" summary="" cellpadding="0" cellspacing="0">
              <colgroup>
              <col width="140" />
              <col width="850" />
              </colgroup>
              <tbody>
                <tr>
                  <th scope="row"> <label for="comp_name">이름</label>
                    <span class="warning">*</span> </th>    
                  <td>홍길동</td>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_num">생년월일</label>
                    <span class="warning">*</span> </th>
                    <td>1997년 11월 10일</td>
                  </tr>
                <tr>
                  <th scope="row"> <label for="comp_id">ID</label>
                    <span class="warning">*</span> </th>
                    <td>iconmedialab</td>
                  </tr>
                <tr>
                  <th scope="row"> <label for="comp_id">닉네임</label>
                    <span class="warning">*</span> </th>
                    <td>대한민국</td> 
                  </tr>
                <tr>
                  <th scope="row"> <label for="comp_id">휴대폰 번호</label>
                    <td>010-3333-3333</td> 
                  </tr>
                <tr>
                  <th scope="row" rowspan="3"> <label for="comp_id">휴대폰번호 변경</label>
                  </th>
              	  <tr>
                    <td><input type="text" id="comp_id" class="inpText" value="새로운 휴대폰번호" />
                  	  <a href="#" class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증하기" /></a>
                    </td>
                    </tr>
                    <tr>
                    <td><input type="text" id="comp_id" class="inpText" value="인증번호입력" />
                  	  <a href="#" class="leftmag"><img src="/join_form_img/sub/bt_overlap.png" align="absmiddle" alt="인증하기" /></a>
                    </td>
                   </tr>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_pw">현재 비밀번호</label>
                  <td><input type="password" id="comp_pw" class="inpText" /></td>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_pw">새 비밀번호</label>
                  <td><input type="password" id="comp_pw" class="inpText" /></td>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_pw">새 비밀번호 재입력</label>
                  <td><input type="password" id="comp_pw" class="inpText" /></td>
                </tr>
               
                <tr class="email_bx">
                  <th scope="row"> <label for="ceo_email">이메일 주소 변경</label>
                   </th>
                  <td>
                  <p>현재 이메일 주소 : dasdsa@dads.net</p>
                  <input type="text" id="ceo_email" title="이메일 아이디를 작성하세요."  />
                    @
                    <input type="text" title="이메일 계정을 작성하세요."  />
                    <span class="select_box" >직접입력</span>
                    <select class="select_dd" title="이메일 계정을 선택하세요.">
                      <option value="">직접입력</option>
                      <option value="naver.com">네이버</option>
                      <option value="hanmail.net">다음</option>
                      <option value="nate.com">네이트</option>
                      <option value="nate.com">구글</option>
                    </select></td>
                </tr>
               
                 <tr class="adress_bx">
                  <th scope="row"> <label for="comp_adress">차량정보 변경</label>
                  </th>
                  <td>
                   <p>차량 정보를 정확히 입력하면 정확한 견적을 받을 수 있습니다.</p>
                   <span class="select_box" >현대자동차</span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
                    <option value="">현대자동차</option>
                    <option value="">기아자동차</option>
                    <option value="">르노삼성자동차</option>
                    <option value="">쉐보레</option>
                  </select>
                   <p /><br>
                   <span class="select_box" >그랜져HG 240 디젤 </span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
                    <option value=""></option>
                    
                  </select>
                   <p /><br>
                   <span class="select_box" >2013년식</span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
                    <option value="">2014</option>
                    <option value="">2014</option>
                    <option value="">2014</option>
                    <option value="">2014</option>                  
                  </select>
                   <p /><br>
                   <span class="select_box" >White계열</span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
                    <option value="">White 계열</option>
                    <option value="">Yellow 계열</option>
                    <option value="">Brown 계열</option>
                    <option value="">Black 계열</option>
                    <option value="">Gray 계열</option>
                    <option value="">Blue 계열</option>
                    <option value="">Green 계열</option>
                    <option value="">Puple 계열</option>
                    <option value="">투톤 계열</option>
                  </select>
                   
                   <p /><br>
                   <span class="select_box" >OXSSDSADSDAADAS</span>
                   <input type="text" id="ceo_pw" class="inpText" value="차대번호입력" />
                    <p /><br>
                   <span class="select_box" >39러 2222</span>
                   <input type="text" id="ceo_pw" class="inpText" value="차량번호입력" />
                    <p /><br>
                   <span class="select_box" >45,000 Km</span> 
                   <input type="text" id="ceo_pw" class="inpText" value="주행거리입력" />Km
                  </select>             
                  </td>           
                </tr>
                
              </tbody>
            </table>
          </fieldset>
        </form>
      </div>
      <!--//가맹점 정보-->
      <p /></br>
      <p /></br>
      <div class="bt"> <a href="/web/etc/member_modify_complete.do"><img src="/join_form_img/sub/bt_ok.png" alt="확인" /></a> <a href="#"><img src="/join_form_img/sub/bt_no.png" alt="취소" /></a> </div>
    </div>
  </div>
  </div>
    </div>


</body>
</html>