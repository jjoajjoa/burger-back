package com.fivegirls.burger.dao;

import com.fivegirls.burger.vo.TestTypeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestTypeDAO {

    @Autowired
    SqlSession session;

    // 결과 저장
    public int insertTestType(TestTypeVO vo) {
    	return session.update("insertTestType", vo);
    }

    // 결과 조회 (PK와 답변에 따라
    public TestTypeVO getTestTypeByUser(int userPk) {
        return session.selectOne("getTestTypeByUser", userPk);
    }
}
