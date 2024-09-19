package com.fivegirls.burger.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fivegirls.burger.dao.BoardDAO;
import com.fivegirls.burger.vo.BoardCommentVO;
import com.fivegirls.burger.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO dao;

    @Override
    public List<BoardVO> getBoardList() throws Exception {
        return dao.getBoardList();
    }

    @Override
    public BoardVO getBoardById(int boardPk) {
        return dao.getBoardById(boardPk);
    }

    @Override
    public void createBoard(BoardVO vo) {
        dao.createBoard(vo);
    }

    @Override
    @Transactional
    public void increaseViewCount(int boardPk) {
        dao.increaseViewCount(boardPk);
    }

    @Override
    @Transactional
    public BoardVO getBoardWithComments(int boardPk) {
        BoardVO board = dao.getBoardById(boardPk);
        List<BoardCommentVO> comments = dao.getCommentsByBoardId(boardPk);
        board.setComments(comments);
        return board;
    }

    @Override
    @Transactional
    public void createComment(BoardCommentVO vo) {
        dao.createComment(vo);
    }

    @Override
    @Transactional
    public void deleteComment(int commentPk) {
        dao.deleteComment(commentPk);
    }

	@Override
	public List<BoardCommentVO> getCommentsByBoardId(int boardPk) {
		return dao.getCommentsByBoardId(boardPk);
	}
}
