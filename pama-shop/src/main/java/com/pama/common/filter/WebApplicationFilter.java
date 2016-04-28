package com.pama.common.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pama.common.Constants;
import com.pama.common.util.SessionUtil;
import com.pama.common.vo.SessionVO;

/**
 * 클래스 설명 (description about class)
 *
 */
public class WebApplicationFilter implements Filter {

	/* Log */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebApplicationFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("WebApplicationFilter init!!!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOGGER.info("WebApplicationFilter doFilter start !!!");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		SessionVO sessionVO = SessionUtil.getSession(Constants.ACCOUNT_FRONT_SESSION_NAME,  httpServletRequest);
		boolean isLogin = SessionUtil.isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME,  httpServletRequest);
		SessionVO adminSessionVO = SessionUtil.getSession(Constants.ACCOUNT_ADMIN_SESSION_NAME,  httpServletRequest);
		boolean adminIsLogin = SessionUtil.isLogin(Constants.ACCOUNT_ADMIN_SESSION_NAME,  httpServletRequest);
		httpServletRequest.setAttribute("isLogin", isLogin);
		httpServletRequest.setAttribute("sessionVO", sessionVO);
		httpServletRequest.setAttribute("adminSessionVO", adminSessionVO);
		httpServletRequest.setAttribute("adminIsLogin", adminIsLogin);
        String requestURL  = httpServletRequest.getRequestURL().toString();
        String requestURI  = httpServletRequest.getRequestURI().toString();
        String queryString = StringUtils.stripToEmpty(httpServletRequest.getQueryString());
        String currentURL = requestURL + (queryString.equals("")?"":"?"+queryString);
        String currentURI = requestURI + (queryString.equals("")?"":"?"+queryString);
        String loginFormReturnURL = "/login/loginForm.do?returnURL="+URLEncoder.encode(currentURI, "UTF-8");
        httpServletRequest.setAttribute("currentURL", currentURL);
        httpServletRequest.setAttribute("currentURI", currentURI);
        httpServletRequest.setAttribute("requestURI", requestURI);
        httpServletRequest.setAttribute("requestURL", requestURL);
        httpServletRequest.setAttribute("loginFormReturnURL", loginFormReturnURL);
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {
		LOGGER.debug("WebApplicationFilter destroy!!!");
	}

}
