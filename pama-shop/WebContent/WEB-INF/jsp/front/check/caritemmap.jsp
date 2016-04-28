<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%
   //치환 변수 선언
    pageContext.setAttribute("cr", "\r"); //Space
    pageContext.setAttribute("cn", "\n"); //Enter
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/common/css/front/common.css" type="text/css" />
<link rel="stylesheet" href="/common/css/front/sub.css" type="text/css" />
<script type="text/javascript" src="/common/js/jquery-1_11_1_min.js"></script>
<script type="text/javascript" src="/common/js/html5.js"></script>
<script type="text/javascript" src="/common/js/common.js"></script>
<title>:::CarSec ::: 검진</title>
</head>
<body>
	<div class="part_map">
		<div style="font-size:10px"><a href="/main/main.do">HOME </a> >> <a href="/check/check1.do"> 내차 SEF점검 </a></div>
		<div class="left_map">
			<ul>
				<li class="input_tit">부품위치</li>
				<li><input type="button" onclick="goCate('21','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='21'?'on':'' }" value="윗 면" title="윗면"></li>
				<li><input type="button" onclick="goCate('22','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='22'?'on':'' }" value="전 면" title="전면"></li>
				<li><input type="button" onclick="goCate('23','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='23'?'on':'' }" value="측 면" title="측면"></li>
				<li><input type="button" onclick="goCate('24','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='24'?'on':'' }" value="하 부" title="하부"></li>
				<li><input type="button" onclick="goCate('25','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='25'?'on':'' }" value="하 체1" title="하체1"></li>
				<li><input type="button" onclick="goCate('26','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='26'?'on':'' }" value="하 체2" title="하체2"></li>
				<li><input type="button" onclick="goCate('27','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='27'?'on':'' }" value="엔진룸" title="엔진룸"></li>
				<li><input type="button" onclick="goCate('28','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='28'?'on':'' }" value="실 내" title="실내"></li>
				<li><input type="button" onclick="goCate('29','');" class="input_type3 ${messageList.messageSearchVO.messageCategoryId=='29'?'on':'' }" value="도 어" title="도어"></li>
			</ul>

			<select multiple="multiple" name="front_part" class="part_list" onchange="goCate('${messageList.messageSearchVO.messageCategoryId}', this.value)">
				<c:forEach items="${messageList.messageList }" var="i" varStatus="iStatus">
					<option value="${i.messageId}" ${param.messageId==i.messageId?'selected':''}>${i.title}</option>
				</c:forEach>
			</select>
		</div>
		<div class="right_map">

			<div class="img_box2" style="height: 320px">

				<c:set var="carfile1" value="N" />
				<c:forEach items="${message.attachmentList}" var="i" varStatus="iStatus">
					<c:if test="${i.showIndex==1}">
						<c:set var="carfile1" value="Y" />
						<img src="/media/${i.fileName}.image" width="426px" height="320px" alt="${message.title}" />
					</c:if>
				</c:forEach>
				<c:if test="${carfile1=='N'}">
					<img src="/img/map_mimg_bg.png" />
				</c:if>

			</div>
			<div style="padding: 10px; height:124px;overflow-y: scroll;">
				<p>${message.title}</p>
				<p>${fn:replace(message.summaryContents,crcn,br)}</p>
		    </div>

		</div>
	</div>



	<script>

function goCate(cateId, msgId){
	param="?messageCategoryId="+cateId;
	if(msgId != ""){
		param+="&messageId="+msgId;
	}
	location.href=param;
}
/**********************************************************************************/
// 탭
/**********************************************************************************/
$(function(){
    $('.tab_contents:eq(0)').show();
    $('#tab li a').click(function(){
        $('#tab li').removeClass('on');
        $(this).parent().addClass('on');
        $('.tab_contents').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });
});

// 탭2
$(function(){
    $('.tab_contents').find('.tab_contents_s:eq(0)').show()
    $('.tab_st2 li a').click(function(){
        $('.tab_st2 li').removeClass('on');
        $(this).parent().addClass('on');

        var chk=$(this).parent().parent().parent().attr('id');
        $('#'+chk ).find('.tab_contents_s').hide();
        var activeTab = $(this).attr('href');
        $(activeTab).show();
        return false;
    });

    $('#tab li a').click(function(){
        $('.tab_contents .tab_st2 li').removeClass('on');
        $('.tab_contents .tab_st2 li:first-child').addClass('on');
        var showtab=$('.tab_contents .tab_st2 li:first-child a').attr('href');

        $(showtab).show();

        return false;
    })
});

	</script>

</body>
</html>