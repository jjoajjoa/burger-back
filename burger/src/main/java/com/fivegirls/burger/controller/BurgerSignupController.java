package com.fivegirls.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerSignupDAO;
import com.fivegirls.burger.vo.UserVO;

@RestController
@RequestMapping("/api")
public class BurgerSignupController {

	@Autowired
	BurgerSignupDAO dao;

	@PostMapping("/signup")
	public String signUp(@RequestBody UserVO user) {
		int result = dao.insertUser(user);
		if (result > 0) {
			return "회원가입 성공";
		} else {
			return "회원가입 실패";
		}
	}

	// 아이디 중복 확인 API
	@PostMapping("/checkUsername")
	public boolean checkUsername(@RequestBody UserVO vo) {
		return dao.isUsernameAvailable(vo.getUserId()); // 사용 가능 여부 반환 (true/false)
	}

	// 이메일 중복 확인 API
	@PostMapping("/checkEmail")
	public boolean checkEmail(@RequestBody UserVO vo) {
		return dao.isEmailAvailable(vo.getUserEmail()); // 사용 가능 여부 반환 (true/false)
	}

	// 전화번호 중복 확인 API
	@PostMapping("/checkPhone")
	public boolean checkPhone(@RequestBody UserVO vo) {
		return dao.isPhoneAvailable(vo.getUserMobile()); // 사용 가능 여부 반환 (true/false)
	}

}
