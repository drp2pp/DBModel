package com.multicampus.minishop.common.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LogonCheckInterceptor extends HandlerInterceptorAdapter {
	//Constructor
	public LogonCheckInterceptor(){
		System.out.println("[logonCheckInterceptor default Constructor........]");
	}
	//Method
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("[logonCheckInterceptor Start........]");
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")!=null){
			String uri=request.getRequestURI();
			if(	uri.indexOf("addUserView") != -1 || uri.indexOf("addUser") != -1 || 
				uri.indexOf("loginView") != -1 	||	uri.indexOf("login") != -1 	|| 
				uri.indexOf("checkDuplication") != -1 ){
				request.getRequestDispatcher("/minishop/user/loginView").forward(request, response);
				System.out.println("[로그인 상태.. 로그인 후 불필요한 요구]");
				System.out.println("[logonCheckInterceptor End.......]");
				return false;
			}
			System.out.println("[로그인 상태..]");
			System.out.println("[logonCheckInterceptor End.......]");
			return true;
		}else{
			String uri=request.getRequestURI();
			if(	uri.indexOf("addUserView") != -1 || uri.indexOf("addUser") != -1 || 
				uri.indexOf("loginView") != -1 	 ||	uri.indexOf("login") != -1 	|| 
				uri.indexOf("checkDuplication") != -1 || uri.indexOf("listProduct") != -1
				|| uri.indexOf("getProduct") != -1 || uri.indexOf("getHistory") != -1){
				System.out.println("[로그인 시도 상태.. ]");
				System.out.println("[logonCheckInterceptor End.......]");
				return true;
			}
			request.getRequestDispatcher("/minishop/user/loginView").forward(request, response);
			System.out.println("[로그인 이전..]");
			System.out.println("[logonCheckInterceptor End.......]");
			return false;
		}
	}
}
