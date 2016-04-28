/*************************************************************************************************
 *
 * 폼 스타일 정의
 *
 *************************************************************************************************/
function formStyle(){

  $('input[type="checkbox"]').each(function(){
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
 * $(document).ready
 *
 *************************************************************************************************/
$(document).ready(function(){

  formStyle();   // 폼 스타일 정의

});






