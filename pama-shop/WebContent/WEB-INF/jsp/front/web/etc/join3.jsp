<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 회원가입</title>
</head>
<body>
    <!-- contain -->
    <div id="container">
        <div class="join_type1">
            <h1 class="join_title">차량 정보 입력</h1>
            <p class="explain">회원님의 차량 정보를 입력하여 주세요. <br>없으면 건너뛰기 버튼을 클릭해 주세요.</p>
            <form action="join4.do">
                <div class="member_join">
                    <fieldset class="phone_name type2">
                        <label for="brand">제조사</label>
                        <span class="selectbox">
                            <select id="brand" title="제조사">
                                <option value="">현대자동차</option>
                                <option value="">기아자동차</option>
                                <option value="">쉐보레</option>
                                <option value="">르노삼성자동차</option>
                                <option value="">BMW</option>
                                <option value="">벤츠</option>
                                <option value="">아우디</option>
                                <option value="">폭스바겐</option>
                                <option value="">혼다</option>
                                <option value="">닛산</option>
                            </select>
                        </span>
                        <label for="car">차종</label>
                        <span class="selectbox">
                            <select id="car" title="차종">
                                <option value="">소나타</option>
                                <option value="">아반떼</option>
                                <option value="">I30</option>
                                <option value="">I40</option>
                            </select>
                        </span>
                        <label for="car">년식</label>
                        <span class="selectbox">
                            <select id="car" title="년식">
                                <option value="">2016</option>
                                <option value="">2015</option>
                                <option value="">2014</option>
                                <option value="">2013</option>
                                <option value="">2012</option>
                                <option value="">2011</option>
                                <option value="">2010</option>
                                <option value="">2009</option>
                                <option value="">2008</option>
                                <option value="">2007</option>
                                <option value="">2006</option>
                                <option value="">2005</option>
                                <option value="">2004</option>
                                <option value="">2003</option>
                                <option value="">2002</option>
                                <option value="">2001</option>
                                <option value="">2000</option>
                                <option value="">1999</option>
                                <option value="">1998</option>
                                <option value="">1997</option>
                                <option value="">1996</option>
                            </select>
                        </span>
                        <label for="mission">미션</label>
                        <span class="selectbox">
                            <select id="mission" title="미션">
                                <option value="">오토</option>
                                <option value="">수동</option>
                                <option value="">CVT</option>
                            </select>
                        </span>
                        <label for="distance">주행거리</label>
                        <input type="text" id="distance" placeholder="km를 제외하고 숫자만 입력" class="m_t5" data-from="text">
                    </fieldset>
                    <button type="submit" class="next_button2 ml_76" data-btn="text">건너뛰기</button>
                    <button type="submit" class="next_button2" data-btn="text">다음</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>