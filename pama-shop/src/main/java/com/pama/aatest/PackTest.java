package com.pama.aatest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class PackTest {

	public static void main(String[] args) {


		String currentURI = "/admin/account/admin/list.do";
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
		topMenuTemp.add("menu_5^**^배너관리");
		topMenuTemp.add("menu_6^**^쇼핑");
		topMenuTemp.add("menu_7^**^쿠폰관리");
		topMenuTemp.add("menu_8^**^SELF점검");
		topMenuTemp.add("menu_9^**^이벤트관리");
		topMenuTemp.add("menu_A^**^관리자설정");


		List<String> leftMenuAll = new ArrayList<String>();

		leftMenuAll.add("menu_101^**^전체리스트^**^/admin/account/individual/list.do");
		leftMenuAll.add("menu_102^**^탈퇴회원^**^/admin/account/individual/outlist.do");

		leftMenuAll.add("menu_201^**^전체리스트^**^/admin/account/business/list.do");
		leftMenuAll.add("menu_202^**^탈퇴회원^**^/admin/account/business/outlist.do");

		leftMenuAll.add("menu_301^**^자유게시판^**^/admin/message/freeboard/messageList.do");
		leftMenuAll.add("menu_302^**^사고관련게시판^**^/admin/message/accident/messageList.do");
		leftMenuAll.add("menu_303^**^신차뉴스^**^/admin/message/carnews/messageList.do");
		leftMenuAll.add("menu_304^**^리콜소식^**^/admin/message/recallnews/messageList.do");

		leftMenuAll.add("menu_A01^**^관리자정보^**^/admin/account/admin/list.do");
		leftMenuAll.add("menu_A02^**^온라인문의^**^/admin/message/inquiryonline/messageList.do");
		leftMenuAll.add("menu_A03^**^관리자에게 문의하기^**^/admin/message/inquiryadmin/messageList.do");
		leftMenuAll.add("menu_A04^**^디버그^**^/admin/message/debug/messageList.do");


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

//		if(StringUtils.startsWith(leftMenuUrl, bizCode) ){
//			leftMenu.add(leftMenuStr);
//		}

System.out.println(currentGroup);
		for (String string : topMenu) {

//			System.out.println(string);

		}


		for (String string : leftMenu) {

			System.out.println(string);

		}



	}



	private void getTest(){

		System.out.println( this.getClass().getName() );
	}

}
