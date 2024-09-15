package com.fivegirls.burger.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.BurgerGameVO;

@Component
public class BurgerGameDAO {
	
	@Autowired
	SqlSession session;
	
	public List<BurgerGameVO> selectBurgerList() throws Exception {
		return session.selectList("selectBurgerList");
	}
}
