package com.fivegirls.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.MypageProfileDAO;
import com.fivegirls.burger.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class MypageProfileController {

    @Autowired
    MypageProfileDAO dao;
    
    @Autowired
    private HttpSession session;

    // 사용자 프로필 가져오기
    @GetMapping("/profile")
    public UserVO getUserProfile() {
    	String userId = (String) session.getAttribute("userId"); // 세션에서 userId 가져옴
        if (userId == null) {
            throw new RuntimeException("로그인이 필요합니다."); // 로그인이 안 되어있을 경우 예외 처리
        }
        return dao.getUserProfile(userId);      
    }
    

    // 사용자 프로필 업데이트
    @Transactional
    @PostMapping("/updateUser")
    public UserVO updateUserProfile(@RequestBody UserVO vo) {
    	//System.out.println("Received UserVO: " + vo.toString());
    	
    	String userId = (String) session.getAttribute("userId"); // 세션에서 userId 가져옴
    	vo.setUserId(userId); // 세션에서 가져온 userId를 UserVO에 설정
    	dao.updateUserProfile(vo); // 사용자 정보 업데이트 수행
        return dao.getUserProfile(userId); // 업데이트 후 최신 사용자 정보 반환
    }
}
