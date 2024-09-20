package com.fivegirls.burger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fivegirls.burger.interceptor.LoginInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터를 등록하고 특정 경로는 제외
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**") // 모든 경로에 대해 인터셉터 적용
				.excludePathPatterns("/api/login", "/api/logout/**", "/api/signup/**", "/api/findaccount/**",
						"/api/findId/**", "/api/findPassword/**", "/css/**", "/js/**", "/images/**"); // 로그인, 회원가입, 정적
																										// 리소스 제외
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		System.out.println("Requested URI: " + requestURI);

		HttpSession session = request.getSession();
		String userPk = (String) session.getAttribute("userPk");
		if (userPk == null || userPk.length() == 0) {
			System.out.println("No userId found in session. Redirecting to /login.");
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
}
