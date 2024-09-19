package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BoardDAO;
import com.fivegirls.burger.service.BoardService;
import com.fivegirls.burger.vo.BoardCommentVO;
import com.fivegirls.burger.vo.BoardVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	@Autowired
	BoardDAO dao;

	@Autowired
	BoardService service;

	@Autowired
	HttpSession session;
	
	// 게시글 리스트 불러오기
	@GetMapping("/boardlist")
	public List<BoardVO> boardlist() throws Exception {
		return dao.getBoardList();
	}
	
	
	// 게시글 작성
	@PostMapping("/create")
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


	@GetMapping("/detail/{boardPk}")
	public BoardVO getBoardDetail(@PathVariable("id") int boardPk) {
		System.out.println("지금 누른 게시판 아이디: " + boardPk);
		service.increaseViewCount(boardPk);
		return service.getBoardById(boardPk);
	}

	
	// 게시글 수정
	@PutMapping("/board/{boardPk}/edit")
	public void editBoard(@PathVariable int boardPk, @RequestBody BoardVO vo, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk");
		vo.setUserPk(userPk); // 세션에서 가져온 userId를 UserVO에 설정
		if (userPk == null) {
			throw new RuntimeException("로그인이 필요합니다.");
		}

		vo.setBoardPk(boardPk);
		vo.setUserPk(userPk);
		
		// 게시글 수정 실행
	    int updatedRows = dao.edit(vo);
	    if (updatedRows == 0) {
	        throw new RuntimeException("게시글 수정에 실패했습니다.");
	    }
	}

	// 게시글 삭제
	@DeleteMapping("/board/{boardPk}/delete")
	public void deleteBoard(@PathVariable int boardPk, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk");
		if (userPk == null) {
			throw new RuntimeException("로그인이 필요합니다.");
		}
		
		// 실제 게시글 삭제 실행
	    dao.deleteBoard(boardPk);
	}

	// 게시글 정보와 댓글 가져오기
	@GetMapping("/board/{boardPk}")
	public BoardVO getBoardWithComments(@PathVariable int boardPk, HttpSession session) {
		int sessionUserPk = (int) session.getAttribute("userPk");
		System.out.println("session userPk= " + sessionUserPk);
		// 게시글 정보 가져오기
		BoardVO board = service.getBoardById(boardPk);
		// 댓글 목록 가져오기
		List<BoardCommentVO> comments = service.getCommentsByBoardId(boardPk);
		// 조회수 증가
		service.increaseViewCount(boardPk);
		board.setComments(comments);
		board.setSessionUserPk(sessionUserPk);
		System.out.println("/board/pk=" + board);
		return board;
	}

	// 댓글 작성
	@PostMapping("/board/{boardPk}/comment")
	public void createComment(@PathVariable int boardPk, @RequestBody BoardCommentVO vo, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk"); // 세션에서 userPk 가져오기
		if (userPk != null) {
			vo.setUserPk(userPk); // BoarCommentVO에 userPk 설정
			vo.setBoardPk(boardPk); // URL에서 받은 boardPk 설정
			dao.createComment(vo); // 댓글 생성
		} else {
			throw new RuntimeException("로그인이 필요합니다.");
		}
	}

	// 댓글 삭제
	@DeleteMapping("/board/{boardPk}/comment/{commentPk}")
	public void deleteComment(@PathVariable int boardPk, @PathVariable int commentPk, HttpSession session) {
		Integer userPk = (Integer) session.getAttribute("userPk"); // 세션에서 userPk 가져오기
		if (userPk == null) {
			throw new RuntimeException("로그인이 필요합니다.");
		}
		// 댓글 삭제
		dao.deleteComment(commentPk);
	}

}
