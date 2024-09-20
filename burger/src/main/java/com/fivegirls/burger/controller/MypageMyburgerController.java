package com.fivegirls.burger.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fivegirls.burger.dao.MypageBoardDAO;
import com.fivegirls.burger.dao.MypageMyburgerDAO;
import com.fivegirls.burger.vo.BoardVO;
import com.fivegirls.burger.vo.IngrVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class MypageMyburgerController {

	@Autowired
	MypageMyburgerDAO dao;


	// 사용자가 작성한 게시글 목록 조회
	@PostMapping("/getIngrListbyUserPk")
	public List<IngrVO> getIngrListbyUserPk(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		List<IngrVO> getIngrList = dao.getIngrListbyUserPk(userId);
		System.out.println("햄버거리스트아이디: " + getIngrList);
		return getIngrList;
		
	}

}

