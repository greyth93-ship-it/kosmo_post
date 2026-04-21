package com.grey.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.grey.app.filter.TestFilter;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfig implements WebMvcConfigurer{

	@Bean
	FilterRegistrationBean<Filter> filterRegistrationBean() {
		
		FilterRegistrationBean<Filter> f = new FilterRegistrationBean<>();
		
		f.setFilter(new TestFilter());
		f.addUrlPatterns("/qna/detail","/qna/create","/qna/update","/qna/delete");
		f.addUrlPatterns("/member/mypage","/member/logout");
		// filter 중에 순서 설정하는 문법
		f.setOrder(0);
		
		return f;
		
	}
	
}
