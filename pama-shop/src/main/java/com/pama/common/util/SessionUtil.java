package com.pama.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pama.common.Constants;
import com.pama.common.vo.SessionVO;

public class SessionUtil {

    /**
     * 로그인 정보 세션 만들기
     * @param request
     * @param isAdmin
     */
    public static void createSession(String sessionName, SessionVO sessionVO, HttpServletRequest request){
       request.getSession().setAttribute(sessionName, sessionVO);
    }

    /**
     * 로그인 정보 세션
     * @param request
     * @param isAdmin
     * @return accountSession
     */
    public static SessionVO getFrontSession(){

    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        //sessionName 설정
        SessionVO sessionVO = getSession(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
        return sessionVO;
    }


    /**
     * 로그인 정보 세션
     * @param request
     * @param isAdmin
     * @return accountSession
     */
    public static SessionVO getSession(String sessionName, HttpServletRequest request){

        //sessionName 설정
        SessionVO sessionVO = null;  //로그인 정보를 담을 vo
        if(request.getSession().getAttribute(sessionName) != null){ // 로그인 세션 정보가 있으면
            sessionVO = (SessionVO) request.getSession().getAttribute(sessionName);
        }
        return sessionVO;
    }

    /**
     * 로그인 정보 세션 제거
     * @param request
     * @param isAdmin
     */
    public static void removeSession(String sessionName, HttpServletRequest request){
        if(request.getSession().getAttribute(sessionName) != null){  // 로그인 세션 정보가 있으면
            request.getSession().removeAttribute(sessionName);   // 세션을 지운다.
        }
    }

    /**
     * 로그인 여부 판단
     * @param request
     * @param response
     * @param isAdmin
     * @return boolean
     */
    public static boolean isLogin(String sessionName, HttpServletRequest request){
        if((getSession(sessionName, request) != null)){
            return true; // 로그인 상태
        }else{
            return false; // 로그아웃 상태
        }
    }

    /**
     *  로그인 Front 여부 판단
     * @param request
     * @param isAdmin
     * @return accountSession
     */
    public static boolean isFrontLogin(){

    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        return isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
    }

    public static boolean isFrontNotLogin(){

    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

    	return !isLogin(Constants.ACCOUNT_FRONT_SESSION_NAME, request);
    }
}
