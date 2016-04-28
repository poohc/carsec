<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="/common/css/admin/style.css">
<link type="text/css" href="/common/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" />
<script type="text/javascript" src="/common/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(function(){

		// Datepicker
		$('#bannerStartDate').datepicker({
			inline: true,
			dateFormat: 'yy-mm-dd'
		});

		// Datepicker
		$('#bannerEndDate').datepicker({
			inline: true,
			dateFormat: 'yy-mm-dd'
		});
	});

function goPopupForm(){
	form = document.popupInfoForm;

	form.submit();
}
</script>
</head>

<div class="title">팝업관리/쓰기</div>
<br />
<form name="popupInfoForm" id="popupInfoForm"  method="post" action="popupInfoFormProc.do"  enctype="multipart/form-data">
<table class="contents" >
    <thead>
        <tr>

            <th>진행여부</th>
            <td class="first" >
            <input type="radio" name="statusType" value="1" id="allCheckBox" onclick="checkAll()" class="noborder" />대기
            <input type="radio" name="statusType" value="2" id="allCheckBox" onclick="checkAll()" class="noborder" />진행
            <input type="radio" name="statusType" value="3" id="allCheckBox" onclick="checkAll()" class="noborder" />종료
            </td>

        </tr>
 </thead>


</table>


</form>

 <br>

 <table width="400px">


    <thead>
        <tr>
            <th width="100px" ><font size="2" color="#ff0000">팝업노출설정</font></th>
            <th>팝업창의 노출기간과 위치, 대상을 선택할 수 있습니다.</th>
        </tr>
 </thead>


</table>
<br />

 <table class="contents">
    <colgroup>
        <col width="20%"></col>
        <col width="80%"></col>
    </colgroup>
    <thead>

    </thead>
    <tbody>
        <tr>
            <th>기간설정</th>
            <td>
               <INPUT type=text id="bannerStartDate" name="bannerStartDate" value="${bannerInfoVO.bannerStartDate }"> ~ <INPUT type=text id="bannerEndDate" name="bannerEndDate" value="${bannerInfoVO.bannerEndDate }">
			<div id="datepicker"></div>
            </td>
        </tr>

        <tr>
            <th>팝업노출위치</th>
            <td>
             화면위로부터 <input type="text" size='10'  /> 픽셀(pixel), &nbsp
             왼쪽에서 <input type="text" size='10' /> 픽셀(pixel)
            </td>
        </tr>
        <tr>
            <th>팝업노출될 페이지선택</th>
            <td>

            <%

            List<String> popupPlacces = new ArrayList<String>();
            popupPlacces.add("main:메인페이지");
            popupPlacces.add("six:SIX 소개");
            popupPlacces.add("funding:투자나침판");
            popupPlacces.add("exchange:정보거래소");
            popupPlacces.add("news:증권가정보");
            popupPlacces.add("stat:정보통계");
            popupPlacces.add("community:정보토론실");
            request.setAttribute("popupPlacces", popupPlacces);


            %>






                <select name='popupPlaceIds' >
                    <option value="main">메인페이지</option>
                    <option value="six">six란?</option>
                    <option value="3">공지사항</option>
                    <option value="">투자나침반</option>
                    <option value="">정보제공자 네임카드</option>
                    <option value="">증권거래소</option>
                    <option value="">정보통계</option>
                    <option value="">정보토론실</option>
                </select>
            </td>
        </tr>


    </tbody>
</table>

<br />

 <table>
      <tr>
           <th width="100px" ><font size="2" color="#ff0000">팝업창디자인</font></th>
     </tr>
</table>

<br />

<table class="contents">
    <colgroup>
        <col width="20%"></col>
        <col width="80%"></col>
    </colgroup>
    <thead>

    </thead>
    <tbody>
        <tr>
            <th>팝업종류</th>
             <td class="first" >
            <input type="radio" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />윈도우 팝업 &nbsp
            <input type="radio" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />레이어 팝업
            </td>
        </tr>

        <tr>
            <th>팝업크기</th>
            <td>
             가로 <input type="text" size='10'  /> 픽셀(pixel), &nbsp
             세로 <input type="text" size='10' />  픽셀(pixel)
            </td>
        </tr>
        <tr>
            <th>실행모드종류</th>
              <td class="first" >
            <input type="radio" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />오늘 하루 열지 않음 &nbsp
            <input type="radio" name="allCheckBox" id="allCheckBox" onclick="checkAll()" class="noborder" />다시 열지 않음
            </td>
        </tr>
         <tr>
            <th>팝업제목</th>
            <td>
               <input type="text" size='70' />
            </td>
        </tr>
         <tr>
            <th>첨부이미지</th>
            <td>
               <input type="file" name="file" id="file" />
             </td>
        </tr>
    </tbody>
</table>
<br />
<!-- 수정 및 등록을 위한폼 -->
<div class="btn">
	<ul>
		<li class="btnFl"><a href="javascript:goPopupForm();"><img src="/common/images/admin/btn/btn_write.gif" /></a></li>
		<li class="btnFl"><a href="popupInfoList.do"><img src="/common/images/admin/btn/btn_cancel.gif" /></a></li>

	</ul>
</div>
</form>
