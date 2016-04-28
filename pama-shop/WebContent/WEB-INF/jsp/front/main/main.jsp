<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/_include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>:::CarSec  :::</title>
<script type="text/javascript">
<!--

function notice_getCookie( name ){
     var nameOfCookie = name + "=";
     var x = 0;
     while ( x <= document.cookie.length )
     {
             var y = (x+nameOfCookie.length);
             if ( document.cookie.substring( x, y ) == nameOfCookie ) {
                     if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
                             endOfCookie = document.cookie.length;
                     return unescape( document.cookie.substring( y, endOfCookie ) );
             }
             x = document.cookie.indexOf( " ", x ) + 1;
             if ( x == 0 )
                     break;
     }

     return "";
 }

var link="http://carsec.cafe24.com/pop.html";

if ( notice_getCookie( "Notice" ) != "done" )
 {
    window.open(link,"Window","width=400, height=400, menubar=no, status=no, location=no, toolbar=no, scrollbars=no");
 }


function send(f)
{
    if( f.loginId.value == "" )
    {
        alert("아이디를 입력하세요");
        f.loginId.focus();
        return false;
    }
    if( f.pwd.value == "" )
    {
        alert("비밀번호를 입력하세요");
        f.pwd.focus();
        return false;
    }

    f.action = "/login/loginProc.do";
    return true;
}

function getAddr(param1, param2) {
	var sido = "";
	var gugun = "";
	var dong = "";
	param2 = param2 + "|||";
	if(param1=='gugun'){
		sido = param2.split("|")[0];
	}
	if(param1=='dong'){
		sido = param2.split("|")[0];
		gugun = param2.split("|")[1];
	}
	$.ajax({
		type : "POST",
		url : "/mbr/accountAddrSearch.do",
		data : {"searchType":param1,"sido":sido,"gugun":gugun,"dong":dong},
		dataType : "json",
		success : function(data){
			if(param1=='gugun'){
				$('#addr4').children().remove();
			}
			if(param1=='dong'){
				$('#addr5').children().remove();
			}

			$.each(data.zipcode, function(){
				if(param1=='sido'){
					$('#addr3')
			          .append($('<option>', { value : this.sido })
			          .text(this.sido));
				}
				if(param1=='gugun'){
					$('#addr4')
			          .append($('<option>', { value : this.sido+"|"+this.gugun })
			          .text(this.gugun));
				}
				if(param1=='dong'){
					$('#addr5')
			          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
			          .text(this.dong));
				}
			});
			if(param1=='sido'){
				if ($("#addr3 option").index($("#addr3 option:selected"))<0) {
					$("#addr3 option:eq(0)").attr("selected", "selected");
				}
				getAddr('gugun', $("#addr3 option:selected").val());
				getAddr('dong', $("#addr4 option:selected").val());
			}
			if(param1=='gugun'){
				if ($("#addr4 option").index($("#addr4 option:selected"))<0) {
					$("#addr4 option:eq(0)").attr("selected", "selected");
				}
				getAddr('dong', $("#addr4 option:selected").val());
			}
			if(param1=='dong'){
				if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
					$("#addr5 option:eq(0)").attr("selected", "selected");
				}
			}
		}
	});
}

function getAddr1(param1, param2) {
	var sido = "";
	var gugun = "";
	var dong = "";
	param2 = param2 + "|||";
	if(param1=='gugun'){
		sido = param2.split("|")[0];
	}
	if(param1=='dong'){
		sido = param2.split("|")[0];
		gugun = param2.split("|")[1];
	}
	var statusTypeChangeUrl = '/mbr/accountAddrSearch.do?searchType=' + param1 + '&sido=' + sido + '&gugun=' + gugun + '&dong=' + dong;
	$.getJSON(statusTypeChangeUrl, function(data) {
		if(param1=='gugun'){
			$('#addr4').children().remove();
		}
		if(param1=='dong'){
			$('#addr5').children().remove();
		}

		$.each(data.zipcode, function(){
			if(param1=='sido'){
				$('#addr3')
		          .append($('<option>', { value : this.sido })
		          .text(this.sido));
			}
			if(param1=='gugun'){
				$('#addr4')
		          .append($('<option>', { value : this.sido+"|"+this.gugun })
		          .text(this.gugun));
			}
			if(param1=='dong'){
				$('#addr5')
		          .append($('<option>', { value : this.zipcode+"|"+this.sido+"|"+this.gugun+"|"+this.dong })
		          .text(this.dong));
			}
		});
		if(param1=='sido'){
			if ($("#addr3 option").index($("#addr3 option:selected"))<0) {
				$("#addr3 option:eq(0)").attr("selected", "selected");
			}
			getAddr('gugun', $("#addr3 option:selected").val());
			//getAddr('dong', $("#addr4 option:selected").val());
		}
		if(param1=='gugun'){
			if ($("#addr4 option").index($("#addr4 option:selected"))<0) {
				$("#addr4 option:eq(0)").attr("selected", "selected");
			}
			getAddr('dong', $("#addr4 option:selected").val());
		}
		if(param1=='dong'){
			if ($("#addr5 option").index($("#addr5 option:selected"))<0) {
				$("#addr5 option:eq(0)").attr("selected", "selected");
			}
		}
	});
}

$( document ).ready( function() {
	getAddr('sido', '');
})
//-->
</script>
</head>
<body>
<!-- contain -->
    <div id="main_container">
        <div class="main_banner2"><!-- 메인 비주얼 -->
            <div class="banner_list_box">
                <div class="visual">
                    <div class="pic">
                        <ul>
                            <li>
                                <a href="#"><img src="/img/main_banner2.png" alt="메인이미지"></a>
                            </li>
                            <li>
                                <a href="#"><img src="/img/main_banner.png" alt="메인이미지"></a>
                            </li>
                        </ul>
                    </div>
                    <div class="btn"></div>
                    <div class="dir">
                        <div class="prev"><span>이전</span></div>
                        <div class="next"><span>다음</span></div>
                    </div>
                </div>
            </div>
            <c:if test="${!isLogin }">
            <div id="floating_menu">
               <div class="tablist_box">
                    <ul class="tablist" id="tab">
                        <li class="on"><a href="#tab1">일반회원</a></li>
                        <li class=""><a href="#tab2">메카닉회원</a></li>
                    </ul>
                    <div id="tab1" class="tab_contents">
                        <form name="loginForm" method="post" style="margin: 0px;" onsubmit="return send(document.loginForm);">
                            <fieldset class="inputfield">
                                <input type="text" tabindex="1" title="아이디" data-from="text" placeholder="아이디" id="loginId" name="loginId" class="type1">
                                <input type="password" tabindex="2" data-from="text" title="비밀번호" placeholder="비밀번호" id="pwd" name="pwd" class="type1">
                                <button tabindex="3" data-btn="text" type="submit" class="type1">로그인</button>
                            </fieldset>
                        </form>
                        <ul class="id_pass">
                            <li><a href="#">아이디</a></li>
                            <li><a href="#">비밀번호 찾기</a></li>
                        </ul>
                        <div class="notice">
                            <p class="titleof_board">공지사항</p>
                            <ul class="notice_list">
                             <c:forEach items="${notice1 }" var="i" varStatus="iStatus">
                                <li><a class="new" href="/bbs/${i.boardKey }/messageDetail.do?messageId=${i.messageId }">${i.title }</a><span class="date">${fn:replace(fn:substring(i.registerDate,2,10),'-','.') }</span></li>
                             </c:forEach>
                            </ul>
                            <a class="more" title="공지사항 더보기" href="/bbs/notice1/messageList.do">더보기 ></a>
                        </div>
                    </div>
                    <div id="tab2" class="tab_contents">
                            <form name="loginForm1" method="post" style="margin: 0px;" onsubmit="return send(document.loginForm1);">
                            <fieldset class="inputfield">
                                <input type="text" tabindex="10" title="아이디" data-from="text" placeholder="아이디" id="loginId" name="loginId" class="type1">
                                <input type="password" tabindex="20" data-from="text" title="비밀번호" placeholder="비밀번호" id="pwd" name="pwd" class="type1">
                                <button tabindex="3" data-btn="text" type="submit" class="type1">로그인</button>
                            </fieldset>
                            </form>
                        <ul class="id_pass">
                            <li><a href="#">아이디</a></li>
                            <li><a href="#">비밀번호 찾기</a></li>
                        </ul>
                        <div class="notice">
                            <p class="titleof_board">공지사항2</p>
                            <ul class="notice_list">
                             <c:forEach items="${notice2 }" var="i" varStatus="iStatus">
                                <li><a class="new" href="/bbs/${i.boardKey }/messageDetail.do?messageId=${i.messageId }">${i.title }</a><span class="date">${fn:replace(fn:substring(i.registerDate,2,10),'-','.') }</span></li>
                             </c:forEach>
                            </ul>
                            <a class="more" title="공지사항 더보기" href="/bbs/notice2/messageList.do">더보기 ></a>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>
			<c:if test="${isLogin }">
           <div id="floating_menu" class="float_type2">

           <c:if test="${sessionVO.level==10}">
                    <div class="left_cont">${sessionVO.level==10?'개인':'메카닉' }회원</div>
                    <div class="right_cont"><button type="button" class="modify" onclick="location.href='/mbr/mypage/mypage.do'">수정</button></div>
                    <div style="clear: both;float:inherit;">
	                     <ul>
	                            <li><strong>${sessionVO.memberNm }</strong> 님</li>
	                            <li>${mbrDbVO.accountCarInfoVO.brand} ${fn:split(mbrDbVO.accountCarInfoVO.model,'(')[0]}</li>
	                            <li>${mbrDbVO.accountCarInfoVO.caryear}년식</li>
	                            <li>${mbrDbVO.accountCarInfoVO.mission}계열</span></li>
	                            <li>주행거리 ${mbrDbVO.accountCarInfoVO.distance}km</span></li>
	                    </ul>
                    </div>
                    <br />
                    <div style="float:inherit;">
                    	<table style="width: 100%">
                    		<tr>
                    			<th>요청한견적</th>
                    			<th>받은견적</th>
                    			<th>예약리스트</th>
                    		</tr>
                    		<tr>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=1">${not empty carEstimate.r1Count?carEstimate.r1Count:'0' }</a></td>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=2">${not empty carEstimate.r2Count?carEstimate.r2Count:'0' }</a></td>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=3">${not empty carEstimate.r3Count?carEstimate.r3Count:'0' }</a></td>
                    		</tr>

                    	</table>
                    </div>
            </c:if>
           <c:if test="${sessionVO.level==30 or sessionVO.level==40}">
                   <div class="left_cont">${sessionVO.level==10?'개인':'메카닉' }회원</div>
                    <div class="right_cont"><button type="button" class="modify" onclick="location.href='/mbr/mypage/mypage.do'">수정</button></div>
                    <div style="clear: both;float:inherit;">
	                     <ul>
	                            <li><strong>${sessionVO.memberNm }</strong> 님</li>
	                            <li>${mbrDbVO.accountMechanicInfoVO.serviceItem1}</li>
	                            <li>${mbrDbVO.accountMechanicInfoVO.serviceItem2}</li>
	                            <li>${mbrDbVO.accountMechanicInfoVO.serviceItem3}</li>
	                            <li>${mbrDbVO.accountMechanicInfoVO.serviceItem4}</li>
	                            <li>${mbrDbVO.accountMechanicInfoVO.serviceItem5}</li>
	                    </ul>
                    </div>
                    <br />
                    <div style="float:inherit;">
                    	<table style="width: 100%">
                    		<tr>
                    			<th>요청받은견적</th>
                    			<th>요청한견적</th>
                    			<th>받은 예약</th>
                    		</tr>
                    		<tr>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=1">${carEstimate.r1Count }</a></td>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=2">${carEstimate.r2Count }</a></td>
                    			<td align="center"><a href="/estimate/estimate.do?progressStatus=3">${carEstimate.r3Count }</a></td>
                    		</tr>

                    	</table>
                    </div>
            </c:if>
            </div>
        </c:if>
        </div><!-- //메인 비주얼 -->
        <div class="contain">
            <div class="event_banner">
                <div class="top_banner">
                    <ul>
                        <li><a href="/check/caritemmap.do"><img src="/img/banner/banner_01.jpg" alt="배너"></a></li>
                        <li><a href="/bbs/recruit2/messageList.do"><img src="/img/banner/banner_02.png" alt="배너"></a></li>
                        <li><a href="/check/check1.do"><img src="/img/banner/banner_03.png" alt="배너"></a></li>
                    </ul>
                </div>
                <div class="event_search">
                    <dl class="event">
                        <dt>공지</dt>

                        <c:forEach items="${randomNotice }" var="i" varStatus="iStatus" begin="0" end="0">
                        	<dd onclick="randomNotice('${i.boardKey}','${i.messageId}')">${i.title}</dd>
                        </c:forEach>


                    </dl>
                    <div class="search">
                        <p class="sear_title"><i class="fa fa-heartbeat"></i> 정비소 검색</p>
                        <form name="messageSearchForm"  method="post">
                            <ul class="select_list">
                                <li class="fir_sel">
                                    <select multiple="multiple" id="addr3" name="addr3" class="city loc" onchange="getAddr('gugun',this.value)">
                                    </select>
                                </li>
                                <li class="sec_sel">
                                    <select multiple="multiple" id="addr4" name="addr4" name="local" class="city loc" onchange="getAddr('dong',this.value)">
                                    </select>
                                </li>
                                <li>
                                    <select multiple="multiple" id="addr5" name="addr5" name="local" class="city loc">
                                    </select>
                                </li>
                            </ul>
                            <input type="hidden" name="varFiled2" id="varFiled2" value="" />
                            <input type="button" onclick="javascript:goMessageSearch();" value="검색" class="input_type1"> <!--검색 후 sub1/mechanic_search.do에서 결과 표시-->
                            <!--p class="bul_ty1"><img src="/img/bul_type1.gif" alt="다음"></p>
                            <p class="bul_ty2"><img src="/img/bul_type1.gif" alt="다음"></p-->
                        </form>

                        <script>

                        function goMessageSearch() {
                    		var form = document.messageSearchForm;

                    		var addr1=$("#addr3 option:selected").text();
                    	    if($("#addr4 option:selected").val() != ""){
                    	    	addr1+="-"+$("#addr4 option:selected").text();
                    	    }

                    	    if($("#addr5 option:selected").val() != ""){
                    	    	addr1+="-"+$("#addr5 option:selected").text();
                    	    }

                    		form.varFiled2.value=addr1;


                    		form.action="/bbs/company3/messageList.do?pageNo=1"
                    		form.submit();
                    	}

                        </script>
                    </div>
                </div>
                <div class="main_banner"><!-- 이벤트 팝업 -->
                    <div class="banner_list_box">
                        <div class="visualsd">
                            <div class="pic">
                                <ul>
                                    <li>
                                        <a class="in_box" href="/bbs/compareevent/messageList.do">
                                            <dl>
                                                <dt>차량비교 이벤트</dt>
                                                <dd>두 차량의 성능을 비교하시고 베스트 댓글에 도전하세요</dd>
                                            </dl>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="in_box" href="/bbs/compareevent/messageList.do">
                                            <dl>
                                                <dt>워셔액 쿠폰</dt>
                                                <dd>댓글을 남기고 1000 포인트가 되면 워셔액 쿠폰을 드립니다.</dd>
                                            </dl>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="btn"></div>
                            <div class="dir">
                                <div class="prev"><span>이전</span></div>
                                <div class="next"><span>다음</span></div>
                                </div>
                        </div>
                    </div>
                </div><!-- //이벤트 팝업 -->
                <div class="event_search2">
                    <dl class="event">
                        <dt>이벤트 안내</dt>
                         <c:forEach items="${randomNotice }" var="i" varStatus="iStatus" begin="1" end="1">
                        	<dd onclick="randomNotice('${i.boardKey}','${i.messageId}')">${i.title}</dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
            <div class="main_board">
                <div class="left_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 신차뉴스</p>
                    <c:forEach items="${carnews}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${carnews}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>

                <div class="center_board main_type1">
                    <p class="awe_title"><a href="#"><i class="fa fa-pencil-square-o"></i> 리콜소식</a></p>
                    <c:forEach items="${recallnews}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${recallnews}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 차량관리 상식</p>
                    <c:forEach items="${carcheck}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${carcheck}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>
                <div class="left_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> D.I.Y</p>
                    <c:forEach items="${trafficlaw}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${trafficlaw}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>
                <div class="center_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 드라이브 코스</p>
                    <c:forEach items="${drivecourse}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${drivecourse}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 자동차와 사람</p>
                    <c:forEach items="${carnpeople}" var="i" varStatus="iStatus" begin="0" end="0">
                    <a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}"><img src="/media/${i.showFile1}.image" width="119px" height="78px"></a>
                    <p class="mainbo_title"><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a></p>
                    <span class="writer">${i.registerName }</span>
                    </c:forEach>
                    <ul class="notice_list">
                        <c:forEach items="${carnpeople}" var="i" varStatus="iStatus" begin="1" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
						</c:forEach>
                    </ul>
                </div>
                <div class="left_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 정비업체 구인</p>
                   <ul class="notice_list">
                    <c:forEach items="${recruit2}" var="i" varStatus="iStatus" begin="0" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.varFiled4} &nbsp;&nbsp;${i.varFiled3}</a><span class="date">${i.registerName }</span></li>
					</c:forEach>
                    </ul>
                </div>
                <div class="center_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 사고관련</p>
                    <ul class="notice_list">
                    <c:forEach items="${accident}" var="i" varStatus="iStatus" begin="0" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
					</c:forEach>
                    </ul>
                </div>
                <div class="right_board main_type1">
                    <p class="awe_title"><i class="fa fa-pencil-square-o"></i> 자유게시판</p>
                    <ul class="notice_list">
                    <c:forEach items="${freeboard}" var="i" varStatus="iStatus" begin="0" end="5">
                        <li><a href="/bbs/${i.boardKey}/messageDetail.do?messageId=${i.messageId}">${i.title}</a><span class="date">${i.registerName }</span></li>
					</c:forEach>
                    </ul>
                </div>
            </div>

            <div class="shoping">
                        <div class="channel">
                            <p class="chan_title"><i class="fa fa-pencil-square-o"></i>
                            쇼핑채널</p>
                            <ul class="shop">
                                <li class="fir"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/engine_thum.jpg" alt="상품1"><p class="pro_name">캐스트롤 EDGE</p><span class="local">[분당]</span><em class="com_name">H모빌러스</em><i class="money">79,000<em class="won">원</em></i></a></li>
                                <li class="sec"><a href="/web/sub3/shopping2_view.do"><img src="/img/coupon/thum2.png" alt="상품1"><p class="pro_name">캐스트롤 미션오일</p><span class="local">[분당]</span><em class="com_name">H모빌러스</em><i class="money">149,000<em class="won">원</em></i></a></li>
                                <li class="thr"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum3.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명넣는 곳입니다.</em><i class="money">320,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum4.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">56,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum5.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">45,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum6.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">99,000<em class="won">원</em></i></a></li>
                            </ul>
                            <ul class="shop">
                                <li class="fir"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/engine_thum.jpg" alt="상품1"><p class="pro_name">캐스트롤 EDGE</p><span class="local">[분당]</span><em class="com_name">H모빌러스</em><i class="money">79,000<em class="won">원</em></i></a></li>
                                <li class="sec"><a href="/web/sub3/shopping2_view.do"><img src="/img/coupon/thum6.png" alt="상품1"><p class="pro_name">캐스트롤 미션오일</p><span class="local">[분당]</span><em class="com_name">H모빌러스</em><i class="money">149,000<em class="won">원</em></i></a></li>
                                <li class="thr"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum5.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명넣는 곳입니다.</em><i class="money">320,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum2.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">56,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum3.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">45,000<em class="won">원</em></i></a></li>
                                <li class="fou"><a href="/web/sub3/shopping1_view.do"><img src="/img/coupon/thum4.png" alt="상품1"><p class="pro_name">상품이름</p><span class="local">[지역명]</span><em class="com_name">업체명</em><i class="money">99,000<em class="won">원</em></i></a></li>
                            </ul>
                        </div>
            </div>
    </div>
    <!-- //contain -->

<script>
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



/* * * * * * * * * * * * * * * * * * * * *
메인비주얼 슬라이드
* * * * * * * * * * * * * * * * * * * * */
    var pic_l = $(".visual .pic li").length;
    for(var i=0; i<pic_l; i++){
        $(".visual .btn").append("<div><span>"+(i+1)+"</span></div>");
    }
    $(".visual .btn").append("<a class='stop'></a>");

    var bi;
    var ran = Math.floor(Math.random() * pic_l);
    bi = ran;
    $(".visual .pic li").eq(bi).addClass("ch");
    $(".visual .btn div").eq(bi).addClass("ch");

    $(".visual .btn div").click(function(){
        if(!$(this).is(".ch")){
            bi = $(this).index();
            $(".visual .btn div").removeClass("ch");
            $(this).addClass("ch");
            $(".visual .pic li.ch").animate({"left":"-100%"}, 300).removeClass("ch");
            $(".visual .pic li").eq(bi).css("left","100%").animate({"left":"0"}, 300).addClass("ch");
        }
    });
    $(".visual .prev").click(function(){
        bi--;
        if(bi < 0){bi=pic_l-1;}
        $(".visual .btn div").eq(bi).click();
    });
    $(".visual .next").click(function(){
        bi++;
        if(bi >= pic_l){bi=0;}
        $(".visual .btn div").eq(bi).click();
    });

    var autoset;
    function autoRun(){
        autoset = setTimeout(function(){
            $(".visual .next").click();
            autoRun();
        }, 3000);
    }autoRun();
    var stg = 0;
    $(".visual .btn").on("click", ".stop", function(){
        $(this).removeClass().addClass("gogo");
        stg = 0;
        clearTimeout(autoset);
    });
    $(".visual .btn").on("click", ".gogo", function(){
        if(stg == 0){
            $(this).removeClass().addClass("stop");
            stg = 1;
            $(".visual .next").click();
            autoRun();
        }
    });
    $(".visual .dir span").click(function(){
        $(".visual .stop").click();
    });
    $(".visual .btn div span").click(function(){
        $(".visual .stop").click();
    });
/* * * * * * * * * * * * * * * * * * * * *
이벤트 슬라이드
* * * * * * * * * * * * * * * * * * * * */
var pic_ls = $(".visualsd .pic li").length;
for(var i=0; i<pic_ls; i++){
    $(".visualsd .btn").append("<div><span>"+(i+1)+"</span></div>");
}
$(".visualsd .btn").append("<a class='stop'></a>");

var bisd;
var ransd = Math.floor(Math.random() * pic_ls);
bisd = ransd;
$(".visualsd .pic li").eq(bisd).addClass("ch");
$(".visualsd .btn div").eq(bisd).addClass("ch");

$(".visualsd .btn div").click(function(){
    if(!$(this).is(".ch")){
        bisd = $(this).index();
        $(".visualsd .btn div").removeClass("ch");
        $(this).addClass("ch");
        $(".visualsd .pic li.ch").animate({"left":"-100%"}, 300).removeClass("ch");
        $(".visualsd .pic li").eq(bisd).css("left","100%").animate({"left":"0"}, 300).addClass("ch");
    }
});
$(".visualsd .prev").click(function(){
    bisd--;
    if(bisd < 0){bisd=pic_ls-1;}
    $(".visualsd .btn div").eq(bisd).click();
});
$(".visualsd .next").click(function(){
    bisd++;
    if(bisd >= pic_ls){bisd=0;}
    $(".visualsd .btn div").eq(bisd).click();
});

var autosetsd;
function autoRunsd(){
    autosetsd = setTimeout(function(){
        $(".visualsd .next").click();
        autoRunsd();
    }, 3500);
}autoRunsd();

var stgsd = 0;
$(".visualsd .btn").on("click", ".stop", function(){
    $(this).removeClass().addClass("gogo");
    stgsd = 0;
    clearTimeout(autosetsd);
});
$(".visualsd .btn").on("click", ".gogo", function(){
    if(stgsd == 0){
        $(this).removeClass().addClass("stop");
        stgsd = 1;
        $(".visualsd .next").click();
        autoRunsd();
    }
});
$(".visualsd .dir span").click(function(){
    $(".visualsd .stop").click();
});
$(".visualsd .btn div span").click(function(){
    $(".visualsd .stop").click();
});

</script>

</body>
</html>