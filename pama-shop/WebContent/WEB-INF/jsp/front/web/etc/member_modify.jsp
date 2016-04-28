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
         				   <h3 class="dep2_tit">회원정보 수정 - 메카닉회원</h3>
         					   <p class="joinFieldText">* 표시된 항목은 수정이 불가합니다. </p>
           						 <table width="100%" summary="" cellpadding="0" cellspacing="0">
            					  <colgroup>
           						   <col width="140" />
        					       <col width="850" />
              					  </colgroup>
              					  <tbody>
                <tr>
                  <th scope="row"> <label for="comp_name1">사업자명</label>
                    <span class="warning">*</span> </th>
                   
                  <td>송도카센터</td>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_num">사업자등록번호</label>
                    <span class="warning">*</span> </th>
                  <td>130-87-06820</span> </td>
                </tr>
                <tr>
                  <th scope="row"> <label for="comp_id">ID</label>
                    <span class="warning">*</span> </th>
                  <td>songdocar</td>
                </tr>
                <tr>
                  <tr>
                  <th scope="row"> <label for="comp_id">휴대폰번호</label>
                    <span class="warning">*</span> </th>
                  <td>010-0000-0000</td>
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
                <tr>
                  <th scope="row"> <label for="ceo_pw">대표자명</label>
                    <span class="warning">*</span> </th>
                  <td>홍길동</td>
                </tr>
                <tr class="email_bx">
                  <th scope="row"> <label for="ceo_email">이메일 주소 변경 </label></th>
                  <td>
                  	<p>현재 이메일주소 : abcdefg@abcdef.com</p>
                  	<input type="text" id="ceo_email" title="이메일 아이디를 작성하세요."/>@
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
                <tr class="phone">
                  <th scope="row" > <label for="comp_num1">사업장 전화번호</label>
                  <td>
                  	<p>현재 전화번호 : 032-324-8382</p>
                  	<span class="select_box" >선택하세요</span>
                    <select id="comp_num1" title="전화번호앞자리" class="select_dd">
                      <option value="02">02</option>
                      <option value="02">031</option>
                      <option value="02">032</option>
                      <option value="02">033</option>
                      <option value="02">041</option>
                      <option value="02">042</option>
                      <option value="02">043</option>
                      <option value="02">051</option>
                      <option value="02">052</option>
                      <option value="02">053</option>
                      <option value="02">054</option>
                      <option value="02">061</option>
                      <option value="02">062</option>
                      <option value="02">063</option>
                      <option value="02">064</option>
                    </select>
                    -
                    <input type="text" size="12" value="" title="전화번호 가운데자리를 입력하세요." />
                    -
                    <input type="text" size="12" value="" title="전화번호 뒷자리를 입력하세요."  /></td>
                </tr>
                <tr class="adress_bx">
                  <th scope="row"> <label for="comp_adress">사업장 주소</label>
                  </th>
                  <td><span class="select_box" >선택(특/광/도)</span>
                    <select id="comp_num1" title="전화번호앞자리" class="select_dd">
                      <option value="서울특별시">서울특별시</option>
                      <option value="부산광역시">부산광역시</option>
                      <option value="대구광역시">대구광역시</option>
                      <option value="광주광역시">광주광역시</option>
                      <option value="대전광역시">대전광역시</option>
                    </select>
                   <span class="select_box" >선택(시/구/군)</span>
                    <select id="comp_num1" title="전화번호앞자리" class="select_dd">
                      <option value="강남구">강남구</option>
                      <option value="강북구">강북구</option>
                      <option value="강서구">강서구</option>
                      <option value="강동구">강동구</option>
                    </select>
                    <span class="select_box" >선택(동/면/리)</span>
                    <select id="comp_num1" title="전화번호앞자리" class="select_dd">
                      <option value="신사동">신사동</option>
                      <option value="도곡동">도곡동</option>
                      <option value="역삼동">역삼동</option>
                      <option value="부평동">부평동</option>
                    </select>
                    <p><input type="text" name="adress" size="70" value="" title="주소를 입력하세요." alt="adress" /></p></td>
                </tr>
                <tr class="adress_bx">
                  <th scope="row"> <label for="comp_adress">사업자등록증 첨부</label>
                  </th>
                  <td>
                  <input type="file"  size="12"  />
                  <p /><br>
                  사업자등록증이 변경된 경우 고객센터로 문의 후 접수 바랍니다.
                  </td>
                </tr>
                <tr class="adress_bx">
                  <th scope="row"> <label for="comp_adress">사업장 사진첨부</label>
                  </th>
                  <td>
                  <input type="file"  size="12"  />
                  <p /><br>
                   사진이 없으면 기본사진으로 대체합니다.
                  </td>
                </tr>
                 <tr class="adress_bx">
                  <th scope="row"> <label for="comp_adress">정비 품목</label>
                  </th>
                  <td>
                   <span class="select_box" >타이어&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경</span> <!--현재 DB에 있는 정비품목-->
                    <select id="user_bank" title="선택하세요" class="select_dd">
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
                   <p /><br>
                   <span class="select_box" >블랙박스&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경</span><!--현재 DB에 있는 정비품목-->
                    <select id="user_bank" title="선택하세요" class="select_dd">
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
                   <p /><br>
                   <span class="select_box" >카오디오&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경</span><!--현재 DB에 있는 정비품목-->
                    <select id="user_bank" title="선택하세요" class="select_dd">
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
                   <p /><br>
                   <span class="select_box" >튜닝&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경</span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
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
                   <p /><br>
                   <span class="select_box" >썬팅&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경</span>
                    <select id="user_bank" title="선택하세요" class="select_dd">
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

    </div>
      <div class="bt"> <a href="/web/etc/member_modify_complete.do"><img src="/join_form_img/sub/bt_ok.png" alt="확인" /></a> <a href="/web/main.do"><img src="/join_form_img/sub/bt_no.png" alt="취소" /></a> </div>
      </div>
  </div>


</body>
</html>