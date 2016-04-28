package com.pama.aatest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PackTest2 {

	public static void main(String[] args) {


		String str = "<p><img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" />"
				+ "<img alt=\"\" src=\"/media/bbs_20150831_fa41cad8-994b-4f05-a4d9-1ac21b4f8071.image\" style=\"height:768px; width:1024px\" /></p>";


		List<String> list =  getImgStyleWidth(str);
		for (String string : list) {
			System.out.println( string );
		}

//		System.out.println(
//
//
//				str.replaceAll("style=[\"']?([^>\"']+)\"", "")
//
//
//				);
//


	}


	public static List<String> getImgSrc(String str) {
		Pattern nonValidPattern = Pattern
				.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");

		List<String> result = new ArrayList<String>();
		Matcher matcher = nonValidPattern.matcher(str);
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}
	public static List<String> getImgStyle(String str) {
		Pattern nonValidPattern = Pattern.compile("<img[^>]*style=[\"']?([^>\"']+)[\"']?[^>]*>");
		List<String> result = new ArrayList<String>();
		Matcher matcher = nonValidPattern.matcher(str);
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}

	public static List<String> getImgStyleWidth(String str) {
		Pattern nonValidPattern = Pattern.compile("<img[^>]*width:[\"']?([^>\"']+)[\"']?[^>]*>");
		List<String> result = new ArrayList<String>();
		Matcher matcher = nonValidPattern.matcher(str);
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}

}
