package com.grey.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.grey.app.member.MemberService;
import com.grey.app.member.MemberServiceImpl;
import com.grey.app.security.AddLogout;
import com.grey.app.security.AddLogoutHandler;
import com.grey.app.security.LoginFailHandler;
import com.grey.app.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private LoginFailHandler failHandler;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	// 정적자원에 대한 설정(front자원)
	@Bean
	WebSecurityCustomizer customizer() {
		return web -> {
			web.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/images/**","/img/**","/js/**","/vender/**")
				.requestMatchers("/files/**","/fileDown/**");
		};
	}

	// 인증과 인가에 대한 설정
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		security
			.cors(cors->{cors.disable();})
			.csrf(csrf->{csrf.disable();})
			.authorizeHttpRequests(auth->{
				auth
					.requestMatchers("/notice/create","/notice/update","/notice/delete").hasRole("ADMIN")
					.requestMatchers("/qna/create","/qna/update","/qna/delete","/qna/detail").hasRole("MEMBER")
					.requestMatchers("/goods/create","/goods/update","/goods/delete").hasAnyRole("ADMIN","MANAGER")
					.requestMatchers("/member/mypage","/member/logout","/member/update").authenticated()
					.requestMatchers("/member/*").permitAll()
					.anyRequest().permitAll()
//					.anyRequest().denyAll()
					;
					
			})
			// Login Form과 관련된 설정
			.formLogin(form->{
				form
					.loginPage("/member/login")
//					.usernameParameter("username") : parameter명이 다를 때
//					.passwordParameter("password") : parameter명이 다를 때
					.loginProcessingUrl("/member/login")
//					.defaultSuccessUrl("/")
					.successHandler(successHandler)
//					.failureUrl("/")
					.failureHandler(failHandler)
					;
			})
			
			.logout(logout->{
				logout
					.logoutUrl("/member/logout")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
//					.logoutSuccessUrl("/")
					.addLogoutHandler(new AddLogout())
					.logoutSuccessHandler(new AddLogoutHandler())
					;
			})
			
			.rememberMe(remember->{
				remember
					.rememberMeParameter("rememberMe")
					.key("rememberKey")
					.tokenValiditySeconds(60*60*24)
					.userDetailsService(memberService)
					.authenticationSuccessHandler(successHandler)
					.useSecureCookie(true)
					;
			})
			
			.sessionManagement(session->{
				session
					.maximumSessions(1)
					.maxSessionsPreventsLogin(true)
					.expiredUrl("/member/login")
					
					;
			})
			
			;

		
		
		
		return security.build();
	}
	
	
}
