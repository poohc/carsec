<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
request.setAttribute("webPath","/admin/account");
%>
<html>
<head>
<script type="text/javascript">
<!--

//goForm
function goAccountForm(id){
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action="./${statusVal}form.do";
    form.submit();
}

function goList() {
    var form = document.accountForm;
    var listReturnURL = form.listReturnURL.value;
    if (listReturnURL!="") {
        location.href = listReturnURL;
    } else {
        location.href = "./${statusVal}list.do";
    }
}

function accountSearchPwdProc(email) {
    if(confirm('비밀번호를 초기화시 해당 회원이 등록한 이메일로 임시 비밀번호가 발송 됩니다. 정말 비밀번호 초기화를 하시겠습니까?')){
        var url = '/admin/account/accountSearchPwd.do?email='+email;
        $.getJSON(url,
                function(data) {
                    if(data.result == 'success')
                        alert("회원 비밀번호를 변경 후 해당 회원이 등록한 이메일로 임시 비밀번호를 발송 하였습니다.");
                    else
                        alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
                });
        return false;
    }
}

function goAccountRemoveForm(id){
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action = "${statusVal}removeForm.do";
    form.submit();
}

function goOrderList(id) {
    var form = document.accountForm;
    form.mbrId.value = id;
    form.action = "/admin/account/order/orderList.do";
    form.submit();
}

function statusProc(mbrId, level) {
    var statusTypeChangeUrl = '/admin/account/modifyAccountLevel.do?mbrId='+mbrId+'&'+'level='+level;
    $.getJSON(statusTypeChangeUrl,
            function(data) {
                if(data.result == 'success'){
                	if(level==40){
                    	alert("승인되었습니다.");
                	}else if(level==30){
                		alert("대기상태로 변경하였습니다.");
                	}
                    var form = document.accountForm;
                    form.mbrId.value = '${accountVO.mbrId}';
                    form.action = "detail.do";
                    form.submit();

                }
                else{
                    alert("에러가 발생하였습니다. 시스템 관리자에게 문의하세요.");
                }
            });
    return false;
}

//-->
</script>
</head>

<div class="title">회원 상세 보기</div>

<form name="accountForm" method="get">
    <input type="hidden" name="mbrId" value="">
    <input type="hidden" name="listReturnURL" value="${REQUEST.currentURL}" />
</form>

<br/>
<br/>
<b>회원정보</b>
<br/>
<br/>
<br/>
<b>기본정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
    	<c:if test="${accountVO.level == '30' || accountVO.level == '40'}">
        <th>사업자명</th>
        </c:if>
        <c:if test="${accountVO.level == '10' || accountVO.level > '90'}">
        <th>성명</th>
        </c:if>
        <td>${accountVO.firstName}</td>
        <th>아이디</th>
        <td>${accountVO.mbrId}</td>
    </tr>
    <tr>
    	<c:if test="${accountVO.level == '10' || accountVO.level > '90'}">
        <th>닉네임</th>
        <td>${accountVO.nickName}</td>
        </c:if>
        <c:if test="${accountVO.level == '30' || accountVO.level == '40'}">
        <th>대표자명</th>
        <td>${accountVO.lastName}</td>
        </c:if>
        <th>휴대폰</th>
        <td>${accountVO.mobile}</td>
    </tr>
    <tr>
    	<c:if test="${accountVO.level == '10' || accountVO.level > '90'}">
        <th>생년월일</th>
        <td>${accountVO.birth}</td>
        </c:if>
        <c:if test="${accountVO.level == '30' || accountVO.level == '40'}">
        <th>대표장 전화번호</th>
        <td>${accountVO.tel}</td>
        </c:if>
        <th>이메일</th>
        <td>${accountVO.email}</td>
    </tr>
	<c:if test="${accountVO.level == '30' || accountVO.level == '40'}">
    <tr>
        <th>사업장 주소</th>
        <td colspan="3">${accountVO.addr1}</td>
    </tr>
	</c:if>
    <!--
    <tr>
        <th>임시 비밀번호 발급</th>
        <td><a href="#;" onclick="accountSearchPwdProc(accountVO.firstName,accountVO.lastName,accountVO.email,accountVO.mbrId);">임시 비밀번호 발급</a></td>
    </tr>
    -->
</table>
<!--
<div class="btn">
    <div class="btnFr">
        <a href="#;" onclick="accountSearchPwdProc('${accountVO.email}');">[비밀번호 초기화]</a>
    </div>
    <div style="clear: both"></div>
</div>
-->
<br/>
<br/>
<c:if test="${accountVO.level == '10'}">
<b>자동차 정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
        <th>차량제조사</th>
        <td>${accountCarVO.brand}</td>
        <th>차량모델</th>
        <td>${accountCarVO.model}</td>
    </tr>
    <tr>
        <th>차량색상</th>
        <td>${accountCarVO.mission}</td>
        <th>차량연식</th>
        <td>${accountCarVO.caryear}</td>
    </tr>
    <tr>
        <th>차대번호</th>
        <td>${accountCarVO.carIdentNumber}</td>
        <th>차량번호</th>
        <td>${accountCarVO.carNumber}</td>
    </tr>
    <tr>
        <th>주행거리</th>
        <td>${accountCarVO.distance}</td>
        <th> </th>
        <td> </td>
    </tr>
</table>
</c:if>
<c:if test="${accountVO.level == '30' || accountVO.level == '40'}">
<b>메카닉 정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
        <th>서비스품목 1</th>
        <td>${accountMechanicInfoVO.serviceItem1}</td>
        <th>서비스품목 2</th>
        <td>${accountMechanicInfoVO.serviceItem2}</td>
    </tr>
    <tr>
        <th>서비스품목 3</th>
        <td>${accountMechanicInfoVO.serviceItem3}</td>
        <th>서비스품목 4</th>
        <td>${accountMechanicInfoVO.serviceItem4}</td>
    </tr>
    <tr>
        <th>서비스품목 5</th>
        <td>${accountMechanicInfoVO.serviceItem5}</td>
        <th>사업자등록번호</th>
        <td>${accountMechanicInfoVO.bizNumber}</td>
    </tr>
    <tr>
        <th>사업장사진</th>
        <td><img src="/media/${accountMechanicInfoVO.bizPhoto}.image" width="180" /></td>
        <th>사업자등록증</th>
        <td>
        <img src="/media/${accountMechanicInfoVO.bizRegFile}.image" width="180" />
        </a>
        </td>
    </tr>
</table>
</c:if>
<br/>
<br/>
<!-- Loop -->
<b>사이트 이용 정보</b>
<table class="contents">
    <colgroup>
        <col width="15%"></col>
        <col width="35%"></col>
        <col width="15%"></col>
        <col width="35%"></col>
    </colgroup>
    <tr>
        <th>가입날짜</th>
        <td>${accountVO.registerDate}</td>
        <th>최근 접속일</th>
        <td>${accountVO.loginDate}</td>
    </tr>
    <tr>
        <th>회원레벨</th>
        <td>
            <c:choose>
                <c:when test="${accountVO.level=='10'}">일반회원</c:when>
                <c:when test="${accountVO.level=='30'}">메카닉회원(대기)
                <button onclick="statusProc('${accountVO.mbrId}','40')">승인</button>
                </c:when>
                <c:when test="${accountVO.level=='40'}">메카닉회원(승인)
                <button onclick="statusProc('${accountVO.mbrId}','30')">대기</button>
                </c:when>
                <c:when test="${accountVO.level=='90'}">관리자</c:when>
                <c:when test="${accountVO.level=='99'}">슈퍼관리자</c:when>
            </c:choose>
        </td>
        <th>회원상태</th>
        <td>
            <c:choose>
                <c:when test="${accountVO.statusType=='0'}">탈퇴</c:when>
                <c:when test="${accountVO.statusType=='1'}">대기</c:when>
                <c:when test="${accountVO.statusType=='2'}">일반</c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <th>포인트</th>
        <td>${accountVO.accPoint} 점</td>
        <th>로그인 횟수</th>
        <td>${accountVO.loginCount} 회</td>
    </tr>
    <tr>
        <th>가입IP</th>
        <td>${accountVO.registerIp}</td>
        <th>정보 수정일</th>
        <td>${accountVO.updateDate}</td>
    </tr>
    <!--
    <tr>
        <th>수정IP</th>
        <td>${accountVO.updateIp}</td>
    </tr>
    -->
</table>

<div class="btn">
    <div class="btnFl"><a href="javascript:goAccountRemoveForm('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_delete.gif" /></a></div>
    <div class="btnFr">
    	<!-- a href="javascript:goOrderList('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_orderList.gif" /></a -->
        <!-- a href="javascript:goAccountForm('${accountVO.mbrId}');"><img src="/common/images/admin/btn/btn_modify.gif" /></a -->
        <a href="#;" onclick="goList()"><img src="/common/images/admin/btn/btn_list.gif" /></a>
    </div>
    <div style="clear: both"></div>
</div>

</html>