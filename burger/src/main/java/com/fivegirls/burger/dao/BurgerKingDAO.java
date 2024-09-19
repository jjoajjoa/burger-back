package com.fivegirls.burger.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.BurgerKingVO;

@Component
public class BurgerKingDAO {
	
	@Autowired
	SqlSession session;
	
    // 버거킹
    public List<BurgerKingVO> getBurgerKingByBurgerType() throws Exception {
        return session.selectList("getBurgerKingByBurgerType");
    }

    // 버거지
    public List<BurgerKingVO> getBurgerPoorByBurgerType() throws Exception {
        return session.selectList("getBurgerPoorByBurgerType");
    }
	
}
