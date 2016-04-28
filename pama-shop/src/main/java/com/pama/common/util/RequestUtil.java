package com.pama.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.pama.common.Constants;

public class RequestUtil {

    public static String getCurrentURL(HttpServletRequest request, String enc){

        String requestURL  = request.getRequestURL().toString();
        String queryString = StringUtils.stripToEmpty(request.getQueryString());
        String currentURL = requestURL + (queryString.equals("")?"":"?"+queryString);

        try {
            return URLEncoder.encode(currentURL, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return currentURL;
    }

    public static String getCurrentURI(HttpServletRequest request, String enc){

        String requestURI  = request.getRequestURI();
        String queryString = StringUtils.stripToEmpty(request.getQueryString());
        String currentURI = requestURI + (queryString.equals("")?"":"?"+queryString);

        try {
            return URLEncoder.encode(currentURI, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return currentURI;
    }

    public static String getLoginFormURL(HttpServletRequest request){
        String returnURL = getCurrentURL(request, "UTF-8");
        if(StringUtils.isNotEmpty(returnURL)){
            returnURL = "?returnURL=" + returnURL;
        }

        return request.getContextPath() + Constants.ACCOUNT_FRONT_LOGIN_FORM + returnURL;
    }

    public static String getAgent(HttpServletRequest request) {
    	String agent = "";

    	if (request.getHeader("user-agent").toLowerCase().indexOf(Constants.USER_AGENT_IPAD.toLowerCase())>=0) {
    		agent = Constants.USER_AGENT_TYPE_FRONT;
    	} else if (request.getHeader("user-agent").toLowerCase().indexOf(Constants.USER_AGENT_IPHONE.toLowerCase())>=0) {
    		agent = Constants.USER_AGENT_TYPE_MOBILE;
    	} else if (request.getHeader("user-agent").toLowerCase().indexOf(Constants.USER_AGENT_ANDROID.toLowerCase())>=0) {
    		agent = Constants.USER_AGENT_TYPE_MOBILE;
    	} else {
    		agent = Constants.USER_AGENT_TYPE_FRONT;
    	}

    	return agent;
    }

    public static String getContextRealPath(HttpServletRequest request) {

    	return request.getSession().getServletContext().getRealPath("/");
    }


}
