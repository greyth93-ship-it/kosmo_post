package com.grey.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.grey.app.interceptors.LoginCheckInterceptor;

import com.grey.app.interceptors.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;
	
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		// 적용할 interceptor 등록
		
		// interceptor를 사용할 url 패턴 선언, addPathPatterns 여러번 호출 가능
				
		// interceptor를 사용할 url 패턴 선언, excludePathPatterns 여러번 호출 가능
				
		
		// member로 시작하는 모든 url, login, join
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/member/*","/qna/*","/goods/*")
				.excludePathPatterns("/member/login","/member/join","/qna/list","goods/list")
				;
		
		registry.addInterceptor(writerCheckInterceptor)
				.addPathPatterns("/notice/update","/qna/update")
				;
		
		
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**")
				;
	}

}
