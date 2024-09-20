package com.fivegirls.burger.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.IngrVO;

@Component
public class MypageMyburgerDAO {
	
	@Autowired
	SqlSession session;
	
	//내가 만든 버거 가져오기
	public List<IngrVO> getIngrListbyUserPk(String userId) {
		return session.selectList("getIngrListbyUserPk", userId);
	}
	
}
