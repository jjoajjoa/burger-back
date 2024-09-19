package com.fivegirls.burger.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fivegirls.burger.dao.MypageBoardDAO;
import com.fivegirls.burger.vo.BoardVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class MypageBoardController {

	@Autowired
	MypageBoardDAO dao;

	@Autowired
	private HttpSession session;

	// 사용자가 작성한 게시글 목록 조회
	@GetMapping("/myboard")
	public List<BoardVO> getUserBoards() {
		String userId = (String) session.getAttribute("userId"); // 세션에서 userId 가져옴
		return dao.getUserBoards(userId);
	}

}
