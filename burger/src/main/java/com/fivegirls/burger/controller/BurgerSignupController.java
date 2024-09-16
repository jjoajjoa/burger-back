package com.fivegirls.burger.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerSignupDAO;
import com.fivegirls.burger.vo.UserVO;

import jakarta.servlet.http.HttpSession;

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
    public ResponseEntity<Boolean> checkUsername(@RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        boolean isAvailable = dao.isUsernameAvailable(userId);
        if (isAvailable) {
            return ResponseEntity.ok(true);  // 사용 가능
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);  // 사용 중
        }
    }

    // 이메일 중복 확인 API
    @PostMapping("/checkEmail")
    public ResponseEntity<Boolean> checkEmail(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        boolean isAvailable = dao.isEmailAvailable(email);
        if (isAvailable) {
            return ResponseEntity.ok(true);  // 사용 가능
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);  // 사용 중
        }
    }

    // 전화번호 중복 확인 API
    @PostMapping("/checkPhone")
    public ResponseEntity<Boolean> checkPhone(@RequestBody Map<String, String> request) {
        String phone = request.get("phone");
        boolean isAvailable = dao.isPhoneAvailable(phone);
        if (isAvailable) {
            return ResponseEntity.ok(true);  // 사용 가능
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);  // 사용 중
        }
    }

}
