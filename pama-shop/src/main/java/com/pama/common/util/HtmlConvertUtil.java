package com.pama.common.util;

import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XmlSerializer;

public class HtmlConvertUtil {
	private TagNode node = null;

	public void clean(URL url) throws Exception {
		node = new HtmlCleaner().clean(new InputStreamReader(url.openStream(), "EUC-KR"));
	}

	public void clean(URL url, String charset) throws Exception {
		node = new HtmlCleaner().clean(new InputStreamReader(url.openStream(), charset));
	}

	public void clean(URL url, String charset, boolean omitComments, boolean omitDeprecatedTag, boolean omitUnknownTags) throws Exception {

		HtmlCleaner cleaner = new HtmlCleaner();
		CleanerProperties props = cleaner.getProperties();

		props.setOmitComments(omitComments);
		props.setOmitDeprecatedTags(omitDeprecatedTag);
		props.setOmitUnknownTags(omitUnknownTags);

		node = cleaner.clean(new InputStreamReader(url.openStream(), charset));

	}

	public void clean(InputStreamReader in) throws Exception {
		node = new HtmlCleaner().clean(in);
	}

	public void clean(String sNode) throws Exception {
		node = new HtmlCleaner().clean(sNode);
	}

	public void addAttribute(String eleName, String attrName, String attrValue) throws Exception {
		getElementByName(eleName).setAttribute(attrName, attrValue);
	}

	public void addChild(String eleName, String tagValue) throws Exception {
		getElementByName(eleName).addChild(createTag(tagValue));
	}

	public void removeAttribute(String eleName, String attrName) throws Exception {
		getElementByName(eleName).removeAttribute(attrName);
	}

	public void removeChild(String eleName, String attrName) throws Exception {
		getElementByName(eleName).removeChild(attrName);
	}

	public TagNode getElementByName(String eleName) throws Exception {
		return getElementByName(eleName, 0);
	}

	public TagNode getElementByName(String eleName, int pos) throws Exception {
		return node.getElementsByName(eleName, true)[pos];
	}

	public TagNode[] getElementsByName(String eleName) throws Exception {
		return node.getElementsByName(eleName, true);
	}

	public List<String> getElementsByNameListURL(URL url, String targetUrl) throws Exception {
		List<String> listUrl = new ArrayList<String>();

		TagNode[] nodeList = getElementsByName("a");
		for (int i=nodeList.length; i>0; i--) {
			String urlhref = nodeList[i-1].getAttributeByName("href");
			if (urlhref.indexOf(targetUrl)>=0) {
				if (urlhref.indexOf("/")==0){
					listUrl.add("http://"+url.getHost()+urlhref);
				} else {
					listUrl.add("http://"+url.getHost()+url.getPath().substring(0,url.getPath().lastIndexOf("/"))+"/"+urlhref);
				}
			}
		}
		return listUrl;
	}

	public List<?> getElementListByName(String eleName) throws Exception {
		return node.getElementListByName(eleName, true);
	}

	public TagNode[] getElementsByAttValue(String attName, String attValue) throws Exception {
		return node.getElementsByAttValue(attName, attValue, true, true);
	}

	public TagNode findElementByAttList(String attName, String attValue, int startPos) throws Exception {
		TagNode[] value = getElementsByAttValue(attName, attValue);
		if (value!=null) {
			return value[startPos];
		} else {
			return null;
		}
	}

	public TagNode findElementByAttValue(String attName, String attValue) throws Exception {
		return node.findElementByAttValue(attName, attValue, true, true);
	}

	public StringBuffer findElementByAttText(String attName, String attValue) throws Exception {
		TagNode value = findElementByAttValue(attName, attValue);
		if (value!=null) {
			System.out.println(value.toString());
			return value.getText();
		} else {
			return null;
		}
	}

	public StringBuffer findElementByAttHtml(String attName, String attValue) throws Exception {
		XmlSerializer xmlSerializer = new PrettyXmlSerializer(new HtmlCleaner().getProperties());
		TagNode value = null;
		StringWriter writer = new StringWriter();
		StringBuffer out = new StringBuffer();

		value = findElementByAttValue(attName, attValue);

		if (value!=null) {
			xmlSerializer.write(value, writer, "");
			out.append(writer.getBuffer());
			out.delete(0, 34);

			if ("td".equals(value.getName())) {
				out.insert(0,"<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr>");
				out.append("</tr></table>");
			}
			if ("tr".equals(value.getName())) {
				out.insert(0,"<table>");
				out.append("</table>");
			}

		}

		return out;
	}

	public StringBuffer findElementByHtml(String eleName) throws Exception {
		XmlSerializer xmlSerializer = new PrettyXmlSerializer(new HtmlCleaner().getProperties());
		TagNode value = null;
		StringWriter writer = new StringWriter();
		StringBuffer out = new StringBuffer();

		value = getElementByName(eleName);

		if (value!=null) {
			xmlSerializer.write(value, writer, "");
			out.append(writer.getBuffer());
			out.delete(0, 34);
		}

		return out;
	}

	public TagNode createTag(String node) throws Exception  {
		return new TagNode(node);
	}
}
