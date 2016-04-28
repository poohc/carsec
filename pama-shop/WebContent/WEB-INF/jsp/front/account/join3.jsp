<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>회원가입</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">차량 정보 입력</h1>
            <p class="explain">회원님의 차량 정보를 입력하여 주세요. <br>없으면 건너뛰기 버튼을 클릭해 주세요.</p>
            <form method="post" action="accountCarInfoProc.do">
                <div class="member_join">
                    <fieldset class="phone_name type2">
                        <label for="brand">제조사</label>
                        <span class="selectbox">
                            <select id="brand" name="brand" title="제조사">
                                <option value="현대자동차">현대자동차</option>
                                <option value="기아자동차">기아자동차</option>
                                <option value="쉐보레">쉐보레</option>
                                <option value="르노삼성자동차">르노삼성자동차</option>
                                <option value="BMW">BMW</option>
                                <option value="벤츠">벤츠</option>
                                <option value="아우디">아우디</option>
                                <option value="폭스바겐">폭스바겐</option>
                                <option value="혼다">혼다</option>
                                <option value="닛산">닛산</option>
                            </select>
                        </span>
                        <label for="car">차종</label>
                        <span class="selectbox">
                            <select id="model" name="model" title="차종">
                                <option value="소나타">소나타</option>
                                <option value="아반떼">아반떼</option>
                                <option value="I30">I30</option>
                                <option value="I40">I40</option>
                            </select>
                        </span>
                        <label for="car">년식</label>
                        <span class="selectbox">
                            <select id="caryear" name="caryear" title="년식">
                                <c:forEach var="i" begin="0" end="20" step="1">
                    			<option value="${2016-i}"${fn:split(accountFormVO.birth,'-')[0]==i?' selected':''}>${2016-i}</option>
                    			</c:forEach>
                            </select>
                        </span>
                        <label for="mission">칼라</label>
                        <span class="selectbox">
                            <select id="mission" name="mission" title="칼라">
                                <option value="빨강">빨강</option>
                                <option value="주황">주항</option>
                                <option value="노랑">노랑</option>
                                <option value="초록">초록</option>
                                <option value="파랑">파랑</option>
                                <option value="남색">남색</option>
                                <option value="검정">검정</option>
                                <option value="보라">보라</option>
                            </select>
                        </span>
                        <label for="distance">주행거리</label>
                        <input type="text" id="distance" name="distance" placeholder="km를 제외하고 숫자만 입력" class="m_t5" data-from="text">
                    </fieldset>
                    <button type="button" class="next_button2 ml_76" data-btn="text" onClick="location.href='accountInfoEnd.do'">건너뛰기</button>
                    <button type="submit" class="next_button2" data-btn="text">다음</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>