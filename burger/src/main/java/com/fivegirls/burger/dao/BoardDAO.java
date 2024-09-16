package com.fivegirls.burger.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.BoardVO;

@Component
public class BoardDAO {
	
	@Autowired
	SqlSession session;
	
	// 리스트 불러오기
	public List<BoardVO> getBoardList() throws Exception {
		return session.selectList("getBoardList");
	}
	
	
	// 삭제
	public void deleteBoard(int boardPk) {
		session.delete("deleteBoard", boardPk);
	}
	
	
	// 추가
	public void createBoard(BoardVO vo) {
		session.insert("createBoard", vo);
	}
	
	
	
	// 수정
	public int edit(BoardVO vo) {
		return session.update("edit", vo);
	}
}
