package com.fivegirls.burger.service;

import java.util.List;
import com.fivegirls.burger.vo.BoardCommentVO;
import com.fivegirls.burger.vo.BoardVO;

public interface BoardService {
    List<BoardVO> getBoardList() throws Exception;
    BoardVO getBoardById(int boardPk);
    void createBoard(BoardVO vo);
    void increaseViewCount(int boardPk);
    BoardVO getBoardWithComments(int boardPk);
    List<BoardCommentVO> getCommentsByBoardId(int boardPk);
    void createComment(BoardCommentVO vo);
    void deleteComment(int commentPk);
}
