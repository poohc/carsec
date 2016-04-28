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
            <h1 class="join_title">사업자 정보 입력</h1>
            <p class="explain">협력업체 등록에 필요한 정비 품목과 사업자등록증을 등록하여 주십시요.</p>
            <form action="join4_agency.do">
                <div class="member_join">
                    <fieldset class="phone_name type2">
                        <label for="brand">주요 정비 품목1</label>
                        <span class="selectbox">
                            <select id="brand" title="주요정비품목1">
                                <option value="">엔진정비</option>
                                <option value="">미션정비</option>
                                <option value="">타이어</option>
                                <option value="">세차</option>
                                <option value="">광택</option>
                                <option value="">카오디오</option>
                                <option value="">네비게이션</option>
                                <option value="">타이밍벨트</option>
                            </select>
                        </span>
                        <label for="car">주요 정비 품목2</label>
                        <span class="selectbox">
                            <select id="brand" title="주요정비품목1">
                                <option value="">엔진정비</option>
                                <option value="">미션정비</option>
                                <option value="">타이어</option>
                                <option value="">세차</option>
                                <option value="">광택</option>
                                <option value="">카오디오</option>
                                <option value="">네비게이션</option>
                                <option value="">타이밍벨트</option>
                            </select>
                        </span>
                        <label for="car">주요 정비 품목3</label>
                        <span class="selectbox">
                            <select id="brand" title="주요정비품목1">
                                <option value="">엔진정비</option>
                                <option value="">미션정비</option>
                                <option value="">타이어</option>
                                <option value="">세차</option>
                                <option value="">광택</option>
                                <option value="">카오디오</option>
                                <option value="">네비게이션</option>
                                <option value="">타이밍벨트</option>
                            </select>
                        </span>
                        <label for="mission">사업자 등록증 첨부</label>
                        <span class="upload_file">
                            <span class="enter_st enter_st7"><input type="text" id="upload_file" readonly="readonly" title="파일이름"></span>
                            <span class="btn_find_file">
                                <input type="file" onchange="javascript:document.getElementById('upload_file').value=this.value">
                            </span>
                        </span>
                        <input type="checkbox" id="check2" class="check_agency" data-from="checkbox">
                        <label for="check2" class="check_label">팩스로 보내기 (사업자등록증 파일이 없을 경우 체크하세요.)</label>
                    </fieldset>
                    <button type="submit" class="next_button2 ml_140" data-btn="text">다음</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>