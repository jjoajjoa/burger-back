package com.fivegirls.burger.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fivegirls.burger.vo.BoardVO;

@Component
public class MypageBoardDAO {

    @Autowired
    private SqlSession session;

    // 사용자가 작성한 게시글 목록을 조회하는 메서드
    public List<BoardVO> getUserBoards(String userId) {
        return session.selectList("getUserBoards", userId);
    }
}