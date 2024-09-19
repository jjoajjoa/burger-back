package com.fivegirls.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.UserVO;

@Component
public class FindAccountDAO {

	@Autowired
	SqlSession sqlSession;

	// 이름과 이메일로 아이디 찾기
	public UserVO findIdByNameAndEmail(UserVO vo) {
		return sqlSession.selectOne("findIdByNameAndEmail", vo);
	}

	// 아이디, 이메일, 전화번호로 비밀번호 찾기
	public UserVO findPwByIdAndEmailAndPhone(UserVO vo) {
		return sqlSession.selectOne("findPwByIdAndEmailAndPhone", vo);
	}

}