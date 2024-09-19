package com.fivegirls.burger.controller;

import com.fivegirls.burger.dao.TestTypeDAO;
import com.fivegirls.burger.vo.TestTypeVO;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestTypeRestController {

    @Autowired
    TestTypeDAO dao;
    
    @Autowired
    HttpSession session;

    // 결과 저장
    @PostMapping("/insertTest")
    public TestTypeVO insertTestType(@RequestBody TestTypeVO vo) {
       int sessionUserPk = (int) session.getAttribute("userPk");
       vo.setUserPk(sessionUserPk);
        dao.insertTestType(vo);
        return vo;
    }

    // 사용자 PK와 답변으로 결과 조회 (GET 방식)
    @GetMapping("/getTest")
    public TestTypeVO getTestTypeByUser(@RequestParam int userPk) {
       int sessionUserPk = (int) session.getAttribute("userPk");
       TestTypeVO test = dao.getTestTypeByUser(userPk);
       test.setSessionUserPk(sessionUserPk);
        return test;
    }
    
}
