package com.fivegirls.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.UserVO;

@Component
public class MypageProfileDAO {

    @Autowired
    private SqlSession session;

    // 사용자 프로필 조회
    public UserVO getUserProfile(String userId) {
        return session.selectOne("getUserProfile", userId);
    }

    // 사용자 프로필 업데이트 : int로 반환하는 것은 성공 여부를 쉽게 확인할 수 있는 방법
    // - 예를 들어, 0이면 수정할 사용자가 없는 경우거나, 업데이트가 실패한 경우이기 때문에 이를 처리할 수 있음
    public int updateUserProfile(UserVO vo) {
    	System.out.println("Executing update query for UserVO: " + vo.toString());
        return session.update("updateUserProfile", vo);
    }
}
