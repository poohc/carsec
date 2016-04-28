/*************************************************************************************************
 *
 * 사이드 메뉴
 *
 *************************************************************************************************/
$(window).load(function(){
      $("[data-toggle]").click(function() {
        var toggle_el = $(this).data("toggle");
        $(toggle_el).toggleClass("open-sidebar");
      });
    });//]]>

/**********************************************************************************/
// 아코디언
/**********************************************************************************/
$(window).load(function(){
    $('.black').bind('click', function(){
        var target = $(this).find('span');
        if(target.attr('class') == 'open'){
            target.attr('class','close').text('닫기');
            $(this).next('.text3').show();
        }else{
            target.attr('class','open').text('열기');
            $(this).next('.text3').hide();
        }
    });
});
/*************************************************************************************************
 *
 * 폼 스타일 정의
 *
 *************************************************************************************************/
function formStyle(){

	$('input[type="checkbox"],input[type="radio"]').each(function(){
		var my = $(this);
		var myType = my.attr('type');
		var myClass = my.attr('class');

		if(!my.hasClass('default')){
			var form =$(document.createElement('span'))
				.attr('data-from', myType)
				.addClass(myClass)
				.insertBefore(my)
				.append(my);
			if(my.attr('checked') == 'checked'){
				my.parent('span').addClass('checked');
			}
		}
	});


	// FORM 설정
	$('input').bind({
		'focusin':function(){
			var my = $(this);
			my.parent('span').addClass('focus');
		},
		'focusout':function(){
			var my = $(this);
			my.parent('span').removeClass('focus');
		},
		'click keyup':function(){
			var my = $(this);
			var mom = my.parent('span');
			if(mom.attr('data-from') == 'textbox'){
				if(!my.val() == ""){
					mom.addClass('none');
					mom.find('.delete').show();
				} else {
					mom.removeClass('none');
				}
			} else if(mom.attr('data-from') == 'checkbox') {
				if(my.is(':checked')){
					var myName = my.attr('name');
					my.parent('span').addClass('checked');
				}else{
					my.parent('span').removeClass('checked');
				}
			} else {
				if(my.is(':checked')){
					var myName = my.attr('name');
					$('*[name="'+myName+'"]').parent('span').removeClass('checked');
					my.parent('span').addClass('checked');
				}else{
					my.parent('span').removeClass('checked');
				}
			}
		}
	});
}

function window_close() {
    window.close();
}

function window_back() {
    history.back();
}


/*************************************************************************************************
 *
 * tabType1
 *
 *************************************************************************************************/
function tabType1(){
	$('*[data-btn="tab"]').bind('click', function(){
		$(this).parents('dl').find('dd').hide();
		$(this).parents('dl').find('dt a').removeClass('on');
		$(this).addClass('on');
		$(this).parent('dt').next('dd').show();
	});
}



/*************************************************************************************************
 *
 * toggleType1
 *
 *************************************************************************************************/
function toggleType1(){
	$('*[data-btn="toggle"]').bind('click', function(){
		if(! $(this).hasClass('none')){
			var t_target = $(this).parent('dt').next('dd');
			var btn_w = $(window).outerWidth();
			if(t_target.is(':visible')){
				t_target.hide();
				$(this).removeClass('open');
			} else {
				t_target.show();
				$(this).addClass('open');
			}
		}
	});
}





/*************************************************************************************************
 *
 *  탭박스
 *
 *************************************************************************************************/
function productList1(){
	$('*[ data-tab="type1"]').find('a').bind('click', function(){
		var target = $(this).attr('data-tab');
		$('*[ data-tab="view1"]').hide();
		$(this).parents('ul').find('li a').removeClass('on');
		$(this).addClass('on');
		$('#' + target).show();
	});
	$('*[ data-tab="type2"]').find('a').bind('click', function(){
		var target = $(this).attr('data-tab');
		$('*[ data-tab="view2"]').hide();
		$(this).parents('ul').find('li a').removeClass('on');
		$(this).addClass('on');
		$('#' + target).show();
	});
}


/*************************************************************************************************
 *
 * 브라우저 체크
 *
 *************************************************************************************************/
function getBrowserType(){
    var _ua = navigator.userAgent;
    /* IE7,8,9,10,11 */
    if (navigator.appName == 'Microsoft Internet Explorer') {
        var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(_ua) != null){
			var ieVersion = parseFloat(RegExp.$1);
			if (ieVersion =='6') return 'ie6';
			if (ieVersion =='7') return 'ie7';
			if (ieVersion =='8') return 'ie8';
			if (ieVersion =='9') return 'ie9';
			if (ieVersion =='10') return 'ie10';
			if (ieVersion =='11') return 'ie11';
		}
    }
    /* etc */
    var agt = _ua.toLowerCase();
    if (agt.indexOf("chrome") != -1) return 'Chrome';
    if (agt.indexOf("opera") != -1) return 'Opera';
    if (agt.indexOf("staroffice") != -1) return 'Star Office';
    if (agt.indexOf("webtv") != -1) return 'WebTV';
    if (agt.indexOf("beonex") != -1) return 'Beonex';
    if (agt.indexOf("chimera") != -1) return 'Chimera';
    if (agt.indexOf("netpositive") != -1) return 'NetPositive';
    if (agt.indexOf("phoenix") != -1) return 'Phoenix';
    if (agt.indexOf("firefox") != -1) return 'Firefox';
    if (agt.indexOf("safari") != -1) return 'Safari';
    if (agt.indexOf("skipstone") != -1) return 'SkipStone';
    if (agt.indexOf("netscape") != -1) return 'Netscape';
    if (agt.indexOf("mozilla/5.0") != -1) return 'Mozilla';
}



/*************************************************************************************************
 *
 * 브라우저 크기 체크
 *
 *************************************************************************************************/
function windowResize(){
      var contentAreaWidth = $(document).width();
		//alert(contentAreaWidth);
      if (contentAreaWidth > 639) {
		  $('body').attr('class','tablet');
		  $('html,body,input,button,label,option,textarea,select').css('font-size','24px');
      } else {
            // Mobile 버전
		  $('body').attr('class','mobile');
		  $('html,body,input,button,label,option,textarea,select').css('font-size','12px');
      }
}


/*************************************************************************************************
 *
 * $(document).ready
 *
 *************************************************************************************************/
$(document).ready(function(){

	formStyle();	 // 폼 스타일 정의

	tabType1();	 // tabType1

	toggleType1();	 // toggleType1

	productList1(); // 보장내용 아이콘 토글

	getBrowserType()

    windowResize()




});