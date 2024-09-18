package com.fivegirls.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BoardDAO;
import com.fivegirls.burger.vo.BoardVO;
import com.fivegirls.burger.vo.BurgerGameVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/boards")
public class BoardRestController {
	
	@Autowired
	BoardDAO dao;
	
	/* 게시글 */
	@RequestMapping("/list")
	public List<BoardVO> boardlist() throws Exception {
		List<BoardVO> boardlist = dao.getBoardList();
		return boardlist;
	}
	
	@RequestMapping("/detail/{id}")
	public BoardVO getBoardDetail(@PathVariable("id") int boardPk) {
	    System.out.println("지금 누른 게시판 아이디: " + boardPk);
	    return dao.getBoardById(boardPk);
	}
	
	/* 댓글 */
	@RequestMapping("/comments/{id}")
    public List<BoardVO> getComments(@PathVariable("id") int boardPk) {
	    System.out.println("지금 누른 게시판 아이디(댓글용): " + boardPk);
        return dao.getCommentsByBoardId(boardPk);
    }
	
}
