package com.fivegirls.burger.controller;

import com.fivegirls.burger.dao.TestTypeDAO;
import com.fivegirls.burger.vo.TestTypeVO;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestTypeController {

    @Autowired
    TestTypeDAO dao;
    
    @Autowired
    HttpSession session;

    // 결과 저장
    @PostMapping("/insertTest")
    public void insertTestType(@RequestBody TestTypeVO vo) {
    	int sessionUserPk = (int) session.getAttribute("userPk");
    	System.out.println("sessionUserPk >>>>" + sessionUserPk);
        dao.insertTestType(vo);
        System.out.println("/api/insertTest" + vo);
        vo.toString();
    }

    // 사용자 PK와 답변으로 결과 조회 (GET 방식)
    @GetMapping("/getTest")
    public TestTypeVO getTestTypeByUser() {
    	int sessionUserPk = (int) session.getAttribute("userPk");
    	System.out.println("sessionUserPk >>>>" + sessionUserPk);
    	TestTypeVO test = dao.getTestTypeByUser(sessionUserPk);
    	test.setSessionUserPk(sessionUserPk);
    	System.out.println("/api/getTest" + test);
        return test;
    }
    
}
