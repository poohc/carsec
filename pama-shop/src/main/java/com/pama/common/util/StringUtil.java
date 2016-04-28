package com.pama.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringUtil extends StringUtils {

	/**
	 * @param str
	 * @return 문자열를 받아 null이면 공백으로 반환한다.
	 */
	public static String getSpaceNVL(String str) {
		if (str == null) {
			return "";
		} else if (str.equals("null")) {
			return "";
		}

		return str;
	}

    public static String removeTag(String regex) {
        String patern = "\\<(\\/?)(\\w+)*([^<>]*)>";

        Pattern p = Pattern.compile(patern);

        Matcher m = p.matcher(regex);

        return m.replaceAll("");
    }

    public static String removeTag(String regex, String patern) {
        Pattern p = Pattern.compile(patern);

        Matcher m = p.matcher(regex);

        return m.replaceAll("");
    }

    /**
     * 태그중에서 이미지(img) 태그를 가져온다.
     * @param regex  문자열
     * @return
     * @throws Exception
     */
    public static String searchImgTag(String regex) throws Exception {
        String patern = "((src)|(SRC))=([\\s'\"])([^<>\\s]*)(['\"])";
        Pattern p = Pattern.compile(patern);
        Matcher m = p.matcher(regex);
        boolean found = m.find();
        String mStr = "";
        if (found) mStr = m.group();
        if (mStr != "") {
            mStr = mStr.replace("src","");
            mStr = mStr.replace("SRC","");
            mStr = mStr.replace("=","");
            mStr = mStr.replace("'","");
            mStr = mStr.replace("\"","");
            mStr = mStr.replace(" ", "");
        }
        return mStr;
    }

    public static List<String> searchImgTagList(String regex) throws Exception {
    	List<String> imgList = new ArrayList<String>();

        String patern = "\\<img(\\w+)*([^<>]*).*\\/>";
        Pattern p = Pattern.compile(patern);
        Matcher m = p.matcher(regex);
        while(m.find()) {
        	String mStr = m.group();
            imgList.add(mStr);
        }

        return imgList;
    }

    public static String searchImgUrl(String mStr) {
        if (mStr != "") {
            mStr = mStr.replace("src","");
            mStr = mStr.replace("SRC","");
            mStr = mStr.replace("=","");
            mStr = mStr.replace("'","");
            mStr = mStr.replace("\"","");
            mStr = mStr.replace(" ", "");
        }
        return mStr;
    }

	public static List<String> getImgSrc(String str) {

		Pattern nonValidPattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");


		List<String> result = new ArrayList<String>();

		Matcher matcher = nonValidPattern.matcher(str);

		while (matcher.find()) {

			result.add(matcher.group(1));

		}

		return result;

	}

}
