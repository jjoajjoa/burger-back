package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BoardDAO;
import com.fivegirls.burger.vo.BoardVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	
	@Autowired
	BoardDAO dao;
	
	@RequestMapping("/boardlist")
	public List<BoardVO> boardlist() throws Exception {
		List<BoardVO> boardlist = dao.getBoardList();
		return boardlist;
	}
	

}
