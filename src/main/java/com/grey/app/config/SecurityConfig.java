package com.grey.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
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
					.anyRequest().permitAll()
//					.anyRequest().denyAll()
					;
					
			})
			// Login Form과 관련된 설정
			.formLogin(form->{
				form
					.loginPage("/member/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.loginProcessingUrl("/member/login")
					.defaultSuccessUrl("/")
					.failureUrl("/")
					;
			})
			
			.logout(logout->{
				logout
					.logoutUrl("/member/logout")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/")
					;
			})
			
			;

		
		
		
		return security.build();
	}
	
	
}
