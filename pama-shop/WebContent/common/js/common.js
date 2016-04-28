



/**********************************************************************************/
// SUB LNB 메뉴
/**********************************************************************************/
$(function(){
  $('#lnb .open').bind('click', function(){
    if(! $(this).attr('class') == ''){
      if($(this).parent().next('dd').css('display') == 'block'){
        $(this).parent().next('dd').hide();
        $(this).attr('class','open');
      }else{
        $('#lnb dd').hide();
        $('#lnb .close').attr('class','open');
        $(this).parent().next('dd').show();
        $(this).attr('class','close');
      }
    }
  });
  var $table = $(".selectbox").children("select");
$table.css({ position: "absolute", visibility: "hidden", display: "block" });
var tableWidth = $table.outerWidth();
$table.css({ position: "", visibility: "", display: "" });
});

/**********************************************************************************/
// 셀렉트 메뉴
/**********************************************************************************/
$(document).ready(function(){

  // 셀렉트박스
  $(function(){
    $('.selectbox').jqTransform();
  });
});
$(function(){
var $selectbox = $("#selectbox");
$selectbox.css({ position: "absolute", visibility: "hidden", display: "block" });
var selectboxWidth = $selectbox.outerWidth();
$selectbox.css({ position: "", visibility: "", display: "" });
});


$(document).ready(function(){

  // 셀렉트박스
  $(function(){
    $('.selectbox2').jqTransform();
  });
});
$(function(){
var $selectbox = $("#selectbox2");
$selectbox.css({ position: "absolute", visibility: "hidden", display: "block" });
var selectboxWidth = $selectbox.outerWidth();
$selectbox.css({ position: "", visibility: "", display: "" });
});



/*************************************************************************************************
 *
 * INITIALIZE
 *
 *************************************************************************************************/
$(document).ready(function(){
  // 1. 브라우저 사이즈 체크
  windowResize();

  /* 체크박스 */
  $('.check_type1 input').bind({
    'click keyup':function(){
      var my = $(this);
      var mom = my.parent('label');
      if(my.is(':checked')){
        mom.addClass('checked');
      }else{
        mom.removeClass('checked');
      }
    }
  });

  $('input[type="radio"]').each(function(){

    var my = $(this).attr('name');
    var mom = $('input[name="' + my + '"]').parent('label');

    if($(this).is(':checked')){
      mom.removeClass('checked');
      $(this).addClass('checked');
      if($(this).attr('checked') == 'checked'){
        $(this).parent('label').addClass('checked');
      }
    }
  });

  $('input[type="radio"]').each(function(){

    var my = $(this).attr('name');
    var mom = $('input[name="' + my + '"]').parent('label');
    if($(this).is(':checked')){
      mom.removeClass('checked');
      $(this).addClass('checked');
      if($(this).attr('checked') == 'checked'){
        $(this).parent('label').addClass('checked');
      }
    }
  });

  /* 라디오 */
  $('input[type="radio"]').bind({
    'click keyup':function(){
      var my = $(this).attr('name');
      var mom = $('input[name="' + my + '"]').parent('label');
      mom.removeClass('checked');
      $(this).parent('label').addClass('checked');
    }
  });


  $('*[data-btn="icon"].back').bind({
    'click':function(){
      parent.history.back();
      return false;
    }
  });

});




/*************************************************************************************************
 *
 * INITIALIZE
 *
 *************************************************************************************************/
$(document).ready(function(e){
    try{
          // 1. 브라우저 체크
          var version = getBrowserType();
          $('body').attr('id',version);

          // 2. 브라우저 사이즈 체크
          windowResize();

          // 3. 팝업
          window.openWindow=function(url, name, width, height, scroll){_common.open_window.apply(_common, arguments);};

          // 4. ZOOM
          window.zoomIn=function(){_common.zoom(1);};
          window.zoomOut=function(){_common.zoom(-1);};

          // 5. Viewport
          if($('body').hasClass('mobile')){
                $('meta[charset="utf-8"]').after('<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">');
          }

          // 6. Mobile
          $('.show_btn').bind('click', function(e){
                if($(this).hasClass('on')){
                      $(this).next().hide();
                      $(this).removeClass('on');
                }else{
                      $(this).next().show();
                      $(this).addClass('on');
                }
          });

    }catch(e){};
});


// 브라우저 리사이즈
$(window).resize(function(){
      windowResize();
});


// 브라우전 버전 체크
function getBrowserType(){
    var _ua = navigator.userAgent;
    /* IE7,8,9,10,11 */
    if (navigator.appName == 'Microsoft Internet Explorer') {
        var rv = -1;
        var trident = _ua.match(/Trident\/(\d.\d)/i);
        //ie11에서는 MSIE토큰이 제거되고 rv:11 토큰으로 수정됨 (Trident표기는 유지)
        if(trident != null && trident[1]  == "7.0") return rv = "IE" + 11;
        if(trident != null && trident[1]  == "6.0") return rv = "IE" + 10;
        if(trident != null && trident[1]  == "5.0") return rv = "IE" + 9;
        if(trident != null && trident[1]  == "4.0") return rv = "IE" + 8;
        if(trident == null) return rv = "IE" + 7;
        var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(_ua) != null) rv = parseFloat(RegExp.$1);
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


// 브라우저 사이즈 체크
function windowResize(){
      var contentAreaWidth = $(window).width();
      if (contentAreaWidth > 1020) {
            // PC 버전
            $('body').removeAttr('class');
            $('body').attr('class','pc');
            $('body').css('font-size','12px');
            $('meta[name="viewport"]').remove();
      } else {
            // Mobile 버전
            $('body').attr('class','mobile');

            if($('meta[name="viewport"]').length < 1){
                  $('meta[charset="utf-8"]').after('<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">');
            }

            if (contentAreaWidth < 640) {
                  if (contentAreaWidth < 320) {
                        // Mobile iPhone 구버전
                        $('body').css('font-size','12px');
                  } else {
                        $('body').css('font-size','12px');
                  }
            } else{
                  // Tablet 버전
                  $('body').attr('class','tablet');
                  $('body').css('font-size','12px');
                  $('meta[name="viewport"]').remove();
            }
      }
}

/*************************************************************************************************
 *
 * Navigation
 *
 *************************************************************************************************/
$(document).ready(function(){
  $('#header').find('.open').bind({
    'click':function(){
      $.ajax({
        url: "menu.html",
        context: document.body,
        success: function(data){
          $('#container').prepend(data);
          $('#container').addClass('open').css('overflow','hidden');
          /*$('#header').css('left','80%');*/
          $('#wrap').on('touchmove',function(e){
            e.preventDefault();
          });
        }
      });
    }
  });
});


