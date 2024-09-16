package com.fivegirls.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.UserVO;

@Component
public class BurgerLoginDAO {
    
    @Autowired
    SqlSession session;
    
    // 로그인 확인을 위한 메서드
    public UserVO selectUserLogin(UserVO userVO) {
        return session.selectOne("selectUserLogin", userVO);
    }
}
