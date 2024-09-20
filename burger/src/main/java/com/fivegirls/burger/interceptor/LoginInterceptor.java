package com.fivegirls.burger.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.preHandler() uri=" + request.getRequestURI());

		HttpSession session = request.getSession();

		// userPk가 없으면 로그인 페이지로 리다이렉트
		if (session == null) {
			System.out.println("No userPk found in session. Redirecting to /login.");
			response.sendRedirect("/login");
			return false; // 요청 중단
		} else {
			// 세션에서 userPk 가져오기
			Integer userPk = (Integer) session.getAttribute("userPk");

			// userPk가 있으면 요청을 계속 처리
			System.out.println("User is logged in with userPk: " + userPk);
		}

		return true; // 요청 통과
	}
}
