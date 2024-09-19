package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BoardDAO;
import com.fivegirls.burger.vo.BoardCommentVO;
import com.fivegirls.burger.vo.BoardVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	@Autowired
	BoardDAO dao;
	HttpSession session;

	@GetMapping("/boardlist")
	public List<BoardVO> boardlist() throws Exception {
		return dao.getBoardList();
	}

	@GetMapping("/detail/{id}")
	public BoardVO getBoardDetail(@PathVariable("id") int boardPk) {
		System.out.println("지금 누른 게시판 아이디: " + boardPk);
		return dao.getBoardById(boardPk);
	}

	@PostMapping("/add") // 경로 맞추기
	public void createBoard(@RequestBody BoardVO vo, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk"); // 세션에서 userPk 가져오기
		if (userPk != null) {
			vo.setUserPk(userPk); // BoardVO에 userPk 설정
			vo.setBoardViewCount(0); // 게시글 생성 시 조회수 0으로 설정
			dao.createBoard(vo); // 게시글 생성
		} else {
			throw new RuntimeException("로그인이 필요합니다.");
		}
	}

	// 게시글 정보와 댓글 가져오기
	@GetMapping("/board/{boardPk}")
	public BoardVO getBoardWithComments(@PathVariable int boardPk) {
		// 게시글 정보 가져오기
		BoardVO board = dao.getBoardById(boardPk);
		// 댓글 목록 가져오기
		List<BoardCommentVO> comments = dao.getCommentsByBoardId(boardPk);
		board.setComments(comments);
		return board;
	}

	// 댓글 작성
	@PostMapping("/board/{boardPk}/comment")
	public void createComment(@PathVariable int boardPk, @RequestBody BoardCommentVO vo) {
		vo.setBoardPk(boardPk);
		dao.createComment(vo);
	}

	// 댓글 삭제
	@DeleteMapping("/comment/{commentPk}")
	public void deleteComment(@PathVariable int commentPk, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk"); // 세션에서 userPk 가져오기
		if (userPk == null) {
			throw new RuntimeException("로그인이 필요합니다.");
		}
		// 댓글 삭제
		dao.deleteComment(commentPk);
	}

}
