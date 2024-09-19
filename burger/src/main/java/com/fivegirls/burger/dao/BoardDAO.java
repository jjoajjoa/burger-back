package com.fivegirls.burger.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.BoardCommentVO;
import com.fivegirls.burger.vo.BoardVO;

@Component
public class BoardDAO {

	@Autowired
	SqlSession session;
  
	// 리스트 불러오기
	public List<BoardVO> getBoardList() throws Exception {
		return session.selectList("getBoardList");
	}

	// 게시글 정보 가져오기
	public BoardVO getBoardById(int boardPk) {
		return session.selectOne("getBoardById", boardPk);
	}
	
	// 게시글 추가
	public void createBoard(BoardVO vo) {
		session.insert("createBoard", vo);
	}
	
	// 게시글 수정
	public int edit(BoardVO vo) {
		return session.update("edit", vo);
	}

	// 게시글 삭제
	public void deleteBoard(int boardPk) {
		session.delete("deleteBoard", boardPk);
	}
	
	// 게시글 조회수 증가
	public void increaseViewCount(int boardPk) {
		session.update("increaseViewCount", boardPk);
	}
	
	// 댓글 목록 가져오기
	public List<BoardCommentVO> getCommentsByBoardId(int boardPk) {
		return session.selectList("getCommentsByBoardId", boardPk);
	}

	// 댓글 작성
	public void createComment(BoardCommentVO vo) {
		session.insert("createComment", vo);
	}

	// 댓글 삭제
	public void deleteComment(int commentPk) {
		session.delete("deleteComment", commentPk);
	}

}
