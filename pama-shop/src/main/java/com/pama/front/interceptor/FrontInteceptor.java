package com.pama.front.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;

public class FrontInteceptor extends HandlerInterceptorAdapter {


    private List<String> byPassURIs;
    /**
     * @param byPassURIs the byPassURIs to set
     */
    public void setByPassURIs(List<String> byPassURIs) {
        this.byPassURIs = byPassURIs;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {

        if ( request.getProtocol().compareTo("HTTP/1.0") == 0 ) {
            response.setHeader("Pragma", "no-cache");
        } else if ( request.getProtocol().compareTo("HTTP/1.1") == 0 ) {
            response.setHeader("Cache-Control", "no-cache");
        }
        response.setDateHeader("Expires", 0);

        boolean isLogin = SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
        String servletPath = request.getServletPath();

        String requestURL  = request.getRequestURL().toString();
        String queryString = StringUtils.stripToEmpty(request.getQueryString());
        String currentURL = requestURL + (queryString.equals("")?"":"?"+queryString);
        //아이피관련부분
        String clientIp = request.getHeader("true-client-ip");
        if (clientIp == null || clientIp.equals("")) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.equals("")) {
            clientIp = request.getRemoteAddr();
        }
        request.getHeader("User-Agent");
        request.getHeader("referer");


        request.setAttribute("currentURL", currentURL);
        request.setAttribute("currentQuery",queryString);

        if(!isLogin){
            boolean isByPass = false;
            if(byPassURIs != null){
                for (String byPassURI : byPassURIs) {
                    if(servletPath.startsWith(byPassURI)){
                        isByPass=true;
                        break;
                    }
                }
            }

            if(!isByPass){
                response.sendRedirect(request.getContextPath() + Constants.ACCOUNT_FRONT_LOGIN_FORM + "?returnURL=" + URLEncoder.encode(currentURL, "UTF-8"));
                return false;
            }
        }

        return true;
    }

}
