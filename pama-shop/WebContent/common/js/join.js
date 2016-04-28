// 한글인지 체크
function isHangul(str)
{
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) != 32 && (str.charCodeAt(i) < 44032 || str.charCodeAt(i) > 55203)) {
            return false;
        }
    }
    return  true;
}

function asclen(s){
    var i, len=0;
    for(i=0;i < s.length; i++) (s.charCodeAt(i) > 255)? len+=2:len++;
    return len;
}

// 이름 체크
function NameInputCheck(obj)
{
    if(asclen(obj.value) <= 0) {
        alert("이름을 입력하세요.");
        return false;
    }
    else if(asclen(obj.value) > 20 )  {
        alert("이름을 20자 이내로 입력하세요. 한글 한글자는 2자로 인식됩니다.");
        return false;
    }

    if (obj.value != "Y"){
        if ( obj.value.indexOf(' ') >= 0  ) {
            alert("이름에는 공백을 허용하지 않습니다.");
            return false;
        }
        else if(!isHangul(obj.value)) {
            alert("한글 실명을 입력하여 주세요.");
            return false;
        }
        else if(asclen(obj.value) > 10 )  {
            alert("이름을 10자 이내로 입력하세요. 한글 한글자는 2자로 인식됩니다.");
            return false;
        }
    }
    return true;
}

function id_no_chk(obj1,obj2)
{
    // CheckSum 체크
    if (chksumID(obj1,obj2) == false)
        return false;

    // 생성기로 만든게 아닌가 생년월일과 남녀필드 체크
    if (ValidRegNo(obj1,obj2) == false)
        return false;

    // YYMMDD가 맞는지 확인한다.
    if (ValidRegNo2(obj1) == false)
        return false;
}

function ValidRegNo(obj1,obj2)
{
    strReg1 = obj1.value;
    strReg2 = obj2.value;
    sGender = strReg2.substring(0,1);
    sYear = strReg1.substring(0,2);

    // 두번째 단락 첫번째 숫자는 4보다 클 수 없다.
    if (sGender > 6) {
        return false;
    }


    // 2000년도 이전은 남자는 1, 여자는 2
    // 2000년도 이후는 남자는 3, 여자는 4
    /*
    if (sYear != '00') {
        if ((sGender != '1') && (sGender != '2')) {
            return false;
        }
    }
    */
    return true;
}

// YYMMDD가 맞는지 확인한다.
function ValidRegNo2(obj1)
{
    strReg1 = obj1.value;

    a = new String(strReg1);

    if(a == '') return false;
    if(a.length != 6 ) return false;

    intYear = parseInt(a.substring(0,2) , 10);
    intMonth = parseInt(a.substring(2,4) , 10);
    intDay = parseInt(a.substring(4,6) , 10);

    if(intMonth < 0 || intMonth > 12){
        return false;
    }

    switch(intMonth){
    case 2 :
        if (intYear %4 == 0)  {
            if(intDay < 0 || intDay > 29){
                return false;
                breake;
            }
        } else {
            if(intDay < 0 || intDay > 28){
                return false;
                breake;
            }
        }
    case 4 :
        if(intDay < 0 || intDay > 30){
            return false;
            breake;
        }
    case 6 :
        if(intDay < 0 || intDay > 30){
            return false;
            breake;
        }
    case 9 :
        if(intDay < 0 || intDay > 30){
            return false;
            breake;
        }
    case 11 :
        if(intDay < 0 || intDay > 30){
            return false;
            breake;
        }
    default :
        if(intDay < 0 || intDay > 31){
            return false;
            breake;
        }
    }

    return true;
}

function chksumID(obj1,obj2)
{
    str1 = obj1.value;
    str2 = obj2.value;
    var li_lastid,li_mod,li_minus,li_last;
    var value0,value1,value2,value3,value4,value5,value6;
    var value7,value8,value9,value10,value11,value12;

    if (IsInteger(str1) &&  IsInteger(str2)) {
        li_lastid    = parseFloat(str2.substring(6,7));
        value0  = parseFloat(str1.substring(0,1))  * 2;
        value1  = parseFloat(str1.substring(1,2))  * 3;
        value2  = parseFloat(str1.substring(2,3))  * 4;
        value3  = parseFloat(str1.substring(3,4))  * 5;
        value4  = parseFloat(str1.substring(4,5))  * 6;
        value5  = parseFloat(str1.substring(5,6))  * 7;
        value6  = parseFloat(str2.substring(0,1))  * 8;
        value7  = parseFloat(str2.substring(1,2))  * 9;
        value8  = parseFloat(str2.substring(2,3))  * 2;
        value9  = parseFloat(str2.substring(3,4))  * 3;
        value10 = parseFloat(str2.substring(4,5))  * 4;
        value11 = parseFloat(str2.substring(5,6))  * 5;
        value12 = 0;

        value12 = value0+value1+value2+value3+value4+value5+value6+value7+value8+value9+value10+value11+value12 ;

        li_mod = value12 %11;
        li_minus = 11 - li_mod;
        li_last = li_minus % 10;
        if (li_last != li_lastid){
            obj2.select();
            obj2.focus();
            return false;
        } else
            return true;
 } else
    obj2.select();
    obj2.focus();
    return false;
}

function checkSpace( str )
{
     if(str.search(/\s/) != -1){
         return 1;
     }

     else {
         return "";
     }
}

// 주어진 문자열이 숫자로만 이루어져있는지 검사한다.
function IsInteger(st)
{
    if (!IsEmpty(st)) {
        for (j = 0; j < st.length; j++)
            if (((st.substring(j, j+1) < "0") || (st.substring(j, j+1) > "9")))
                return false;
    }
    else
        return false;

    return true;
}

// 주어진 문자열이 비어있는지 검사한다.
function IsEmpty(toCheck)
{
    var chkstr = toCheck + "";
    var is_Space = true;

    if (( chkstr == "") || (chkstr == null))
        return false;

    for (j = 0; is_Space && j < chkstr.length; j++) {
        if (chkstr.substring(j, j+1) != " ")
            is_Space = false ;
    }

    return is_Space;
}

function jsAuthoFocus(thisObj, nextObj) {

    if ( thisObj == form.cid_f && thisObj.value.length == 6 ) { nextObj.focus(); }
    else if ( thisObj == form.cid_r && thisObj.value.length == 7 ) { chkcid(); }
    else { return false;}

}

function chkNonchar(id_text){
    var nonchar = '~`!@#$%^&*()-_=+\|<>?,./;:"';

    var i ;
    for(i=0; i < id_text.length; i++){
        if(nonchar.indexOf(id_text.substring(i,i+1)) > 0){
            break ;
        }
    }

    if(i != id_text.length){
        return true ;
    }else {
        return false ;
    }
}

// 메일 체크
function checkEmail(strEmail)
{
    var arrMatch = strEmail.match(/^(\".*\"|[A-Za-z0-9_-]([A-Za-z0-9_-]|[\+\.])*)@(\[\d{1,3}(\.\d{1,3}){3}]|[A-Za-z0-9][A-Za-z0-9_-]*(\.[A-Za-z0-9][A-Za-z0-9_-]*)+)$/);
    if( arrMatch == null )
    {
        return false;
    }

    var arrIP = arrMatch[2].match(/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/);
    if( arrIP != null )
    {
        for( var i = 1 ; i <= 4 ; i++ )
        {
            if( arrIP[i] > 255 )
            {
                return false;
            }
        }
    }
    return true;
}

function mail_check(email) {
    var mail = email;
    var mail_array = mail.split("@");
    if(mail_array[1] == 'hanmail.net' || mail_array[1] == 'daum.net') {
        return false;
    }
    return true;
}

function isVaildMail(email)
{
     var result = false;

     if( email.indexOf("@") != -1 )
     {
          result = true;

          if( email.indexOf(".") != -1 )
          {
               result = true;
          }
          else
          {
               result = false;
          }
     }
     return result;
}

function isEmptyMsg(field, error_msg)
{
    // error_msg가 ""이면 alert와 focusing을 하지 않는다
    if(error_msg == "") {
        if(!CheckValid(field.value, false)) 	{
            return true;
        } else {
            return false;
        }
    } else {
        if(!CheckValid(field.value, false)) {
            alert(error_msg);
            field.focus() ;
            return true;
        } else {
            return false;
        }
    }
}

function CheckValid(String, space)
{

   var retvalue = false;

   for (var i=0; i<String.length; i++)
   {		//String이 0("" 이나 null)이면 무조건 false
      if (space == true)
      {
         if (String.charAt(i) == ' ')
         {			//String이 0이 아닐때 space가 있어야만 true(valid)
            retvalue = true;
            break;
         }
      } else {
         if (String.charAt(i) != ' ')
         {			//string이 0이 아닐때 space가 아닌 글자가 있어야만 true(valid)
            retvalue = true;
            break;
         }
      }
   }

   return retvalue;
}

function chkEmail(semail, eemail) {
    // 이메일체크
    if(isEmptyMsg(semail, "이메일을 입력해 주세요!")) return false;
    kiss = new Array("~","`","!","#","$","%","^","&","*","(",")","/","\,","\\","?","<",">","+","=","|",":",";"," ","'","}","{","[","]");
    for (i = 0; i < semail.value.length ; i++) {
      for ( j = 0 ; j < 28; j++){
            if( kiss[j] == semail.value.charAt(i)){
                alert("이메일 주소에 특수문자 및 빈공백은 입력이 불가능 합니다.");
                semail.focus();
                return false
            }
        }
    }

    if(!isVaildMail(semail.value+eemail.value)) {
        window.alert("이메일을 정확하게 입력해 주세요!");
        return false;
    }

    if(semail.value.substring(semail.value.lastIndexOf("@"))){
        if (semail.value.substring(semail.value.lastIndexOf("@")).search("@") != -1){
         alert("이메일 주소에 '@'빼고 입력해 주세요!");
         return false;
        }
    }
    return true;
}

function isNoSpace( str ) {
    if ( str.search(/\s/) == -1 ) {
        return true;
    } else {
        return false;
    }
}

function isKorean(s) {
    var len;
    len = s.length;
    for (var i=0; i<len; i++)  {
        if (s.charCodeAt(i) != 32 && (s.charCodeAt(i) < 44032 || s.charCodeAt(i) > 55203))
            return false;
    }
    return true;
}

function isValidId( str ) {
    if ( str=="") {
        alert("아이디를 입력하세요.");
        return false;
    } else if ( !isNoSpace(str) ) {
        alert("아이디는 빈 공간 없이 연속된 영문 소문자와 숫자만 사용할 수 있습니다.");
        return false;
    } else if ( str.charAt(0) == '_') {
        alert("아이디의 첫문자는 '_'로 시작할수 없습니다.");
         return false;
    }

    /* checkFormat  */
    var isID = /^[a-z0-9_]{3,12}$/;
    if ( !isID.test(str) ) {
        alert("아이디는 3~12자의 영문 소문자와 숫자,특수기호(_)만 사용할 수 있습니다.");
        return false;
    }

    //var numlen = id_str.match(/[0-9]+/g).join("").length;
    var numlen=0;
    for ( i=0 ; i<str.length ; i++ ) {
        if ( str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
            numlen++;
        }
    }
    if ( numlen > 7 ) {
        alert("숫자는 최대 7자까지만 사용할 수 있습니다.");
        return false;
    }
    return true;
}

function isValidPwd( str ) {
    var cnt=0;
    if ( str=="" ){
        alert("비밀번호를 입력하세요.");
        return false;
    } else if ( !isNoSpace(str) ) {
        alert("비밀번호는 빈공간 없이 연속된 영문 소문자와 숫자만 사용할 수 있습니다.");
        return false;
    }
    for( var i=0; i<str.length; ++i) {
        if( str.charAt(0) == str.substring( i, i+1 ) ) ++cnt;
    }
    if ( cnt == str.length ) {
        alert("보안상의 이유로 한 문자로 연속된 비밀번호는 허용하지 않습니다.");
        return false;
    }

    //var isPW = /^[a-z0-9_~`!@\\#\$%\^&\*()-\+=\|\[\]\{\};:'"<,>.?/]{6,12}$/;
    var isPW = /^[a-z0-9]{6,12}$/;
    if ( !isPW.test(str) ) {
        alert("비밀번호는 6~12자의 영문 소문자와 숫자만 사용할 수 있습니다.");
        return false;
    }
    return true;
}

function calBytes(str)
{
  var tcount = 0;

  var tmpStr = new String(str);
  var temp = tmpStr.length;

  var onechar;
  for ( k=0; k<temp; k++ )
  {
    onechar = tmpStr.charAt(k);
    if (escape(onechar).length > 4)
    {
      tcount += 2;
    }
    else
    {
      tcount += 1;
    }
  }

  return tcount;
}