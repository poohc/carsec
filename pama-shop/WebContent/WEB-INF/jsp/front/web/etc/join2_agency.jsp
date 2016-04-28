<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 검진</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">아이디/비밀번호 설정</h1>
            <p class="explain">아이디와 숫자를 조합하여 8자리 이상 입력하여 주세요.</p>
            <form action="join3_agency.do">
                <div class="member_join">
                    <fieldset class="phone_name">
                        <label for="mem_id">회원아이디</label>
                        <input type="text" id="mem_id" placeholder="회원아이디" title="회원아이디" data-from="text" class="fir_inp m_t5">
                        <button type="submit" class="type2 top" data-btn="text">중복조회</button>
                        <button type="submit" class="type3" data-btn="text">중복조회</button>
                        <label for="password">비밀번호 입력</label>
                        <input type="text" id="password" placeholder="영,숫자 조합 8자리 이상" class="m_t5" title="비밀번호 입력" data-from="text">
                        <label for="password2">비밀번호 재입력</label>
                        <input type="text" id="password2" placeholder="비밀번호 재입력" class="m_t5" title="비밀번호 재입력" data-from="text">
                    </fieldset>
                    <button type="submit" class="next_button" data-btn="text">다음 단계로</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>