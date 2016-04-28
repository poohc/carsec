<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<html>
<head>
<title>${boardVO.title }</title>
</head>
<body>
	<div class="board_view">
		<table>
            <caption>게시판 읽기</caption>
            <colgroup>
                <col style="width:5%" />
                <col style="width:10%" />
                <col style="width:auto%" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col" colspan="3">
                    <p class="t_title">${messageVO.title}</p>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="3" class="text">
                ${messageVO.varFiled1}<br />
                ${fn:replace(messageVO.varFiled2,'-',' ')} ${messageVO.varFiled3}<br />
                전화번호 : ${messageVO.varFiled6}<br />
                ${messageVO.varFiled5}&nbsp;${messageVO.varFiled4}&nbsp;${messageVO.varFiled7}&nbsp;${messageVO.varFiled8}&nbsp;${messageVO.subTitle}<br />

			<table style="margin-top:20px; width: 100%;border: 1px solid black;text-align: center;" border="1";>
            <colgroup>
                <col style="width:15%" />
                <col style="width:10%" />
                <col style="width:15%" />
                <col style="width:10%" />
                <col style="width:15%" />
                <col style="width:10%" />
                <col style="width:15%" />
                <col style="width:10%" />
                <col style="width:10%" />
            </colgroup>
            <tr>
				<th>영업시간</th>
				<th colspan="3">${messageVO.messageVarFiledsVO.varFileds3}</th>
				<th>휴무일</th>
				<th colspan="3">${messageVO.messageVarFiledsVO.varFileds4}</th>
			</tr>
            <tr>
				<th>직원수</th>
				<th style="font-color:red";>${messageVO.messageVarFiledsVO.varFileds1}</th>
				<th>리프트수</th>
				<th>${messageVO.messageVarFiledsVO.varFileds2}</th>
				<th>수리중 대차</th>
				<th>${messageVO.messageVarFiledsVO.varFileds7=='Y'?'가능':'불가능'}</th>
				<th>보험수리</th>
				<th>${messageVO.messageVarFiledsVO.varFileds5=='Y'?'가능':'불가능'}</th>
			</tr>

			<tr>
				<th>부품지참정비</th>
				<th>${messageVO.messageVarFiledsVO.varFileds6=='Y'?'가능':'불가능'}</th>
				<th>출동서비스</th>
				<th>${messageVO.messageVarFiledsVO.varFileds8=='Y'?'가능':'불가능'}</th>
				<th>차량픽업</th>
				<th colspan="3">${messageVO.messageVarFiledsVO.varFileds9=='Y'?'가능':'불가능'}</th>
			</tr>
			<tr>
				<th>국산차 정비</th>
				<th>${messageVO.messageVarFiledsVO.varFileds10=='Y'?'가능':'불가능'}</th>
				<th>일본차 정비</th>
				<th>${messageVO.messageVarFiledsVO.varFileds11=='Y'?'가능':'불가능'}</th>
				<th>미국차 정비</th>
				<th> ${messageVO.messageVarFiledsVO.varFileds12=='Y'?'가능':'불가능'}</th>
				<th>유럽차 정비</th>
				<th>${messageVO.messageVarFiledsVO.varFileds13=='Y'?'가능':'불가능'}</th>
			</tr>
			<tr>
				<th>서비스 제공</th>
				<th colspan="7">${messageVO.messageVarFiledsVO.varFileds14} </th>
			</tr>
            </table>
                <br />


					<c:forEach items="${messageVO.attachmentList}" var="i" varStatus="iStatus">
		            	<c:if test="${i.showIndex==1}">
							<img src="/media/${i.fileName}.image" width="710"/>
						</c:if>
		            </c:forEach>


                    <p class="gall_text2">
                    ${messageVO.contents}
                    </p>
                </td>
            </tr>
            </tbody>
        </table>
	</div>

    <!-- Comment -->
	<jsp:include page="/WEB-INF/jsp/front/boardType/_include/comment_include.jsp" />
	<!-- Comment -->

	<div class="center_box">
		<a href="#;" onclick="javascript:location.href='messageList.do'" class="btn_type1">목 록</a>
	</div>

</body>
</html>
