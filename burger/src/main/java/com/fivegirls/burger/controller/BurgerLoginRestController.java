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
    
    
    //HttpSession을 사용하는 이유 : 로그인 상태를 유지하기 위해서
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
}
