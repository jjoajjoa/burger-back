package com.fivegirls.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.UserVO;

@Component
public class BurgerSignupDAO {

	@Autowired
	SqlSession session;

	public int insertUser(UserVO user) {
		return session.insert("insertUser", user);
	}
	
	public boolean isUsernameAvailable(String userId) {
        int count = session.selectOne("isUsernameAvailable", userId);
        return count == 0;
    }

    public boolean isEmailAvailable(String userEmail) {
        int count = session.selectOne("isEmailAvailable", userEmail);
        return count == 0;
    }

    public boolean isPhoneAvailable(String userMobile) {
        int count = session.selectOne("isPhoneAvailable", userMobile);
        return count == 0;
    }

}
