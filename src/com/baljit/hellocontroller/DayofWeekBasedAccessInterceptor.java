package com.baljit.hellocontroller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//public class DayofWeekBasedAccessInterceptor implements HandlerInterceptorAdaptor{
public class DayofWeekBasedAccessInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	Calendar cal = Calendar.getInstance();
		int dayofwek= cal.get(cal.DAY_OF_WEEK);																				//getting the day on which request is made
		if(dayofwek == 6) 																										// 1 meams Sunday, 2 meams Monday, ....
		{
			response.getWriter().write("The website is closed on Friday; please try access " + " on any other day!!"); 
			//return false;
			return true;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("HandlerInterceptor: Spring MVC called postHandle method for " + request.getRequestURI().toString());			//this method would be called after Spring MVC excutes reqest handler  method for the request
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
																																			//this method would be called after response abject is produced bt the view for the request
		System.out.println("HandlerInterceptor: Spring MVC called afterCompletion method for " + request.getRequestURI().toString());
	}


}
