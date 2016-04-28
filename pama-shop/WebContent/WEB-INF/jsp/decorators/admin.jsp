<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%
String currentURI = (String)request.getAttribute("currentURI");
String prefixBizCodePath = "/admin";
String bbsMessagePath = prefixBizCodePath+"/message";
String accountPath = prefixBizCodePath+"/account";

String bizCode="";
if(StringUtils.startsWith(currentURI, bbsMessagePath) ){ //BBS모듈시작시 다음의 키값을 업무로 정함

	String subfixStr = StringUtils.removeStart(currentURI, bbsMessagePath);
	bizCode = bbsMessagePath + StringUtils.mid(subfixStr, 0, StringUtils.indexOf(subfixStr, "/", 1));

} else if(StringUtils.startsWith(currentURI, accountPath) ){ //BBS모듈시작시 다음의 키값을 업무로 정함

	String subfixStr = StringUtils.removeStart(currentURI, accountPath);
	bizCode = accountPath + StringUtils.mid(subfixStr, 0, StringUtils.indexOf(subfixStr, "/", 1));

} else {

	String subfixStr = StringUtils.removeStart(currentURI, prefixBizCodePath);
	bizCode = prefixBizCodePath + StringUtils.mid(subfixStr, 0, StringUtils.indexOf(subfixStr, "/" , 1));

}


String splitStr = "^**^";
String currentGroup="menu_1";
String currentGroupMenuName="";


List<String> topMenuTemp = new ArrayList<String>();
topMenuTemp.add("menu_1^**^일반회원");
topMenuTemp.add("menu_2^**^메카닉회원");
topMenuTemp.add("menu_3^**^게시판관리");
topMenuTemp.add("menu_4^**^메카닉전용");
topMenuTemp.add("menu_6^**^쇼핑");
topMenuTemp.add("menu_9^**^이벤트관리");
topMenuTemp.add("menu_A^**^공지사항");
topMenuTemp.add("menu_B^**^부품맵");
topMenuTemp.add("menu_C^**^관리자설정");
topMenuTemp.add("menu_D^**^1:1문의");



List<String> leftMenuAll = new ArrayList<String>();
leftMenuAll.add("menu_101^**^전체리스트^**^/admin/account/individual/list.do");
leftMenuAll.add("menu_102^**^탈퇴회원^**^/admin/account/individual/outlist.do");

leftMenuAll.add("menu_201^**^전체리스트^**^/admin/account/business/list.do");
leftMenuAll.add("menu_202^**^탈퇴회원^**^/admin/account/business/outlist.do");

leftMenuAll.add("menu_301^**^자유게시판^**^/admin/message/freeboard/messageList.do");
leftMenuAll.add("menu_302^**^사고관련게시판^**^/admin/message/accident/messageList.do");
leftMenuAll.add("menu_303^**^신차뉴스^**^/admin/message/carnews/messageList.do");
leftMenuAll.add("menu_304^**^리콜소식^**^/admin/message/recallnews/messageList.do");
leftMenuAll.add("menu_305^**^차량관리상식^**^/admin/message/carcheck/messageList.do");
leftMenuAll.add("menu_306^**^D.I.Y^**^/admin/message/trafficlaw/messageList.do");
leftMenuAll.add("menu_307^**^드라이브코스^**^/admin/message/drivecourse/messageList.do");
leftMenuAll.add("menu_308^**^자동차와사람^**^/admin/message/carnpeople/messageList.do");

leftMenuAll.add("menu_401^**^국산차정비^**^/admin/message/newcar/messageList.do");
leftMenuAll.add("menu_402^**^수입차정비^**^/admin/message/newtech/messageList.do");
leftMenuAll.add("menu_403^**^정비사례^**^/admin/message/maintennace/messageList.do");
leftMenuAll.add("menu_404^**^하소연^**^/admin/message/complain/messageList.do");
leftMenuAll.add("menu_406^**^업체리스트^**^/admin/message/company1/messageList.do");
leftMenuAll.add("menu_407^**^정비외 업체리스트^**^/admin/message/company2/messageList.do");
leftMenuAll.add("menu_408^**^중고부품매매^**^/admin/message/partsmarket/messageList.do");
leftMenuAll.add("menu_409^**^지역별협력업체 검색^**^/admin/message/company3/messageList.do");

leftMenuAll.add("menu_601^**^상품리스트^**^/admin/prd/productList.do?sortTree=10");
leftMenuAll.add("menu_602_A^**^병원리스트^**^/admin/prd/productList.do?sortTree=10");
leftMenuAll.add("menu_603_A^**^뷰티샵리스트^**^/admin/prd/productList.do?sortTree=20");
leftMenuAll.add("menu_604_A^**^Culture리스트^**^/admin/prd/productList.do?sortTree=30");
leftMenuAll.add("menu_605^**^상품옵션리스트^**^/admin/prdoption/productOptionList.do");
//leftMenuAll.add("menu_606^**^상품분류리스트^**^/admin/prd/categoryList.do");
leftMenuAll.add("menu_607^**^주문리스트^**^/admin/ord/orderList.do");

// leftMenuAll.add("menu_802^**^내차SELF점검^**^#;");


leftMenuAll.add("menu_901^**^이벤트^**^/admin/message/compareevent/messageList.do");
leftMenuAll.add("menu_902^**^당첨자^**^/admin/message/compareeventwin/messageList.do");

leftMenuAll.add("menu_A01^**^일반회원 공지사항^**^/admin/message/notice1/messageList.do");
leftMenuAll.add("menu_A02^**^메카닉회원 공지사항^**^/admin/message/notice2/messageList.do");
leftMenuAll.add("menu_A03^**^작업공지^**^/admin/message/notice3/messageList.do");
leftMenuAll.add("menu_A04^**^이벤트공지^**^/admin/message/notice4/messageList.do");

leftMenuAll.add("menu_B01^**^부품맵^**^/admin/message/caritemmap/messageList.do");

leftMenuAll.add("menu_C01^**^관리자정보^**^/admin/account/admin/list.do");
// leftMenuAll.add("menu_B02^**^SiteContents^**^/admin/sitecontents/messageList.do");
// leftMenuAll.add("menu_B03^**^관리자에게 문의하기^**^/admin/message/inquiryadmin/messageList.do");
leftMenuAll.add("menu_C04^**^디버그^**^/admin/message/debug/messageList.do");

leftMenuAll.add("menu_D01^**^1:1문의^**^/admin/message/qna/messageList.do");






List<String> topMenu = new ArrayList<String>();
List<String> leftMenu = new ArrayList<String>();
for (String topMenuStr : topMenuTemp) {

	String[] topMenuArray = StringUtils.split(topMenuStr, splitStr);

	String topMenuCode = topMenuArray[0]; //현재 포커스용
	String topMenuName = topMenuArray[1]; //이름 출력용
	String topMenuUrl = ""; // 링크용


	for (String leftMenuStr : leftMenuAll) {
		String[] leftMenuArray = StringUtils.split(leftMenuStr, splitStr);

		String leftMenuCode = leftMenuArray[0];
		String leftMenuCodeTop = StringUtils.left(leftMenuArray[0],6);
		String leftMenuCodesubfixNum = StringUtils.mid(leftMenuArray[0],7,8);
		String leftMenuName = leftMenuArray[1];
		String leftMenuUrl = leftMenuArray[2];

		if(StringUtils.startsWith(leftMenuUrl, bizCode) ){//URL비교하여 현재 속한 메뉴찾기
			currentGroup=leftMenuCodeTop;
		}

		if(StringUtils.equals(leftMenuCodeTop, topMenuCode)){//URL 만들어 내는곳
			if(StringUtils.equals(leftMenuCodesubfixNum, "1")){
				topMenuUrl=leftMenuUrl;
			}

		}
	}
	if(StringUtils.equals(topMenuCode, currentGroup )){
		currentGroupMenuName=topMenuName;
	}


	topMenu.add(topMenuStr+splitStr+topMenuUrl);

}

for (String leftMenuStr : leftMenuAll) {
	String[] leftMenuArray = StringUtils.split(leftMenuStr, splitStr);

	String leftMenuCode = leftMenuArray[0];
	String leftMenuCodeTop = StringUtils.left(leftMenuArray[0],6);
	String leftMenuCodesubfixNum = StringUtils.mid(leftMenuArray[0],7,8);
	String leftMenuName = leftMenuArray[1];
	String leftMenuUrl = leftMenuArray[2];
	if(StringUtils.equals(leftMenuCodeTop, currentGroup)){//왼쪽메뉴
		leftMenu.add(leftMenuStr);
	}
}

request.setAttribute("currentGroup", currentGroup);
request.setAttribute("currentGroupMenuName", currentGroupMenuName);
request.setAttribute("splitStr", splitStr);
request.setAttribute("bizCode", bizCode);
request.setAttribute("topMenu", topMenu);
request.setAttribute("leftMenu", leftMenu);

%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>Administrator ::  </title>

<link rel="stylesheet" href="/common/css/admin/style.css" type="text/css" charset="UTF-8" media="all" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/common/js/jquery.validate.js"  type="text/javascript" charset="UTF-8"></script>

<decorator:head />
</head>

<body>

	<page:applyDecorator page="/WEB-INF/jsp/decorators/admin_header.jsp" name="panel" />
	<div class="wrapper">

		<div class="content_lnb">
			<page:applyDecorator page="/WEB-INF/jsp/decorators/admin_left.jsp" name="panel" />
		</div>

		<div class="content">
			<decorator:body />
			<page:applyDecorator page="/WEB-INF/jsp/decorators/admin_footer.jsp" name="panel" />
		</div>

		<div style="clear: left;"></div>
	</div>

</body>
</html>
