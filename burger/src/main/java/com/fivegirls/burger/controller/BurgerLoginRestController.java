package com.fivegirls.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerLoginDAO;
import com.fivegirls.burger.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class BurgerLoginRestController {

	@Autowired
	BurgerLoginDAO dao;

	// HttpSession을 사용하는 이유 : 로그인 상태를 유지하기 위해서
	@PostMapping("/login")
	public UserVO login(@RequestBody UserVO vo, HttpSession session) {
		UserVO user = dao.selectUserLogin(vo);
		if (user != null) {
			session.setAttribute("userPk", user.getUserPk());
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
			return user;
		} else {
			return null; // 로그인 실패 시 null 반환
		}
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		// 세션 무효화 전에 세션 정보 출력
		System.out.println("Session before invalidation: " + session.getAttribute("userPk"));

		// 세션 무효화
		session.invalidate();

		// 세션 무효화 후 확인 로그 출력
		System.out.println("Session invalidated.");
		return "로그아웃 성공"; // 필요한 경우 JSON이나 메시지를 반환
	}

}
