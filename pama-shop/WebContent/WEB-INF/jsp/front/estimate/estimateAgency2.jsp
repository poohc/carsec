<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  ::: 견적</title>
</head>
<body>
    <div class="header_etc2">
        <div class="wrap_header2">
            <ul class="information_list">
                <li class=""><a href="/estimate/estimate.do?progressStatus=1">요청받은 견적</a></li>
                <li class="on"><a href="/estimate/estimate.do?progressStatus=2">요청한 견적</a></li>
                <li class=""><a href="/estimate/estimate.do?progressStatus=3">받은 예약</a></li>
            </ul>
        </div>
    </div>
    <div id="container">
        <div class="board_list3"><!-- board_list -->
            <table class="acodian">
                <caption>견적 게시판</caption>
                <colgroup>
                    <col style="width:10%" />
                    <col style="width:16%" />
                    <col style="width:8%" />
                    <col style="width:8%" />
                    <col style="width:auto" />
                    <col style="width:auto" />
                    <col style="width:12%" />
                    <col style="width:12%" />
                    <col style="width:15%" />
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">요청일자</th>
                        <th scope="col">차종</th>
                        <th scope="col">연식</th>
                        <th scope="col">증상</th>
                        <th scope="col">예상정비내역</th>
                        <th scope="col">예상견적</th>
                        <th scope="col">닉네임</th>
                        <th scope="col">연락처</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${carEstimateListVO.list}" var="i" varStatus="iStatus">
                    <tr class="item">
                        <td>${fn:substring(i.estimateDate,0,10) }</td>
                        <td>${i.model }</td>
                        <td>${i.carYear}</td>
                        <td>${i.carCheckTitle }</td>
                        <td>${i.repairInfo }</td>
                        <td>${i.estimatePrice  }</td>
                        <td>${i.requestNickname}</td>
                        <td>${i.requestTel}</td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="paging">
		<!-- //Paging -->
		<jsp:include page="/WEB-INF/jsp/_include/front_paging.jsp" flush="true">
			<jsp:param name="count" value="${carEstimateListVO.carEstimateSearchVO.totalCount}" />
			<jsp:param name="row" value="${carEstimateListVO.carEstimateSearchVO.row}" />
			<jsp:param name="page" value="${carEstimateListVO.carEstimateSearchVO.pageNo}" />
		</jsp:include>
		<!-- Paging// -->
		</div>
        <div class="textbox_type1">
            <p class="intitle">TIP!</p>
            <p class="incont"></p>
        </div>

    </div>

</body>
</html>