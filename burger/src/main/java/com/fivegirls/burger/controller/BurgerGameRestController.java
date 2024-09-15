package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerGameDAO;
import com.fivegirls.burger.vo.BurgerGameVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class BurgerGameRestController {
	
	@Autowired
	BurgerGameDAO dao;
	
	@RequestMapping("/burgerlist")
	public List<BurgerGameVO> burgerlist() throws Exception {
		List<BurgerGameVO> burgerlist = dao.selectBurgerList();
		return burgerlist;
	}
	
	@PostMapping("/burgerlistid")
	public void burgerlistid(@RequestBody BurgerGameVO vo, HttpSession session) {
	    System.out.println("햄버거리스트아이디: " + vo.getBurgerId());
	    int burgerId = vo.getBurgerId();
	    session.setAttribute("burgerId", burgerId);
	}

}
