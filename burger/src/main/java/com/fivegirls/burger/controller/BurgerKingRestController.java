package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerKingDAO;
import com.fivegirls.burger.vo.BurgerKingVO;


@RestController
@RequestMapping("/api")
public class BurgerKingRestController {

	@Autowired
	BurgerKingDAO dao;

	// 버거킹
	@GetMapping("/burgergameking")
	public List<BurgerKingVO> getBurgerKing() throws Exception {
		List<BurgerKingVO> list = dao.getBurgerKingByBurgerType();
		return list;
	}

	// 버거지
	@GetMapping("/burgergamepoor")
	public List<BurgerKingVO> getBurgerPoor() throws Exception {
		return dao.getBurgerPoorByBurgerType();
	}
}
