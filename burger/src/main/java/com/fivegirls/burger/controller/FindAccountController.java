package com.fivegirls.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.FindAccountDAO;
import com.fivegirls.burger.vo.UserVO;

@RestController
@RequestMapping("/api")
public class FindAccountController {

	@Autowired
	FindAccountDAO findAccountDAO;

	@PostMapping("/findId")
	public UserVO findId(@RequestBody UserVO vo) {
		return findAccountDAO.findIdByNameAndEmail(vo);
	}

	@PostMapping("/findPassword")
	public UserVO findPassword(@RequestBody UserVO vo) {
		return findAccountDAO.findPwByIdAndEmailAndPhone(vo);
	}
	
}
