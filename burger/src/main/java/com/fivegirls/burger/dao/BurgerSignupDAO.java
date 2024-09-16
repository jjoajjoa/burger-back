package com.fivegirls.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.UserVO;

@Component
public class BurgerSignupDAO {

	@Autowired
	SqlSession session;

	private static final String NAMESPACE = "mapper.signup";

	public int insertUser(UserVO user) {
		return session.insert(NAMESPACE + ".insertUser", user);
	}
	
	public boolean isUsernameAvailable(String userId) {
        int count = session.selectOne("isUsernameAvailable", userId);
        return count == 0;
    }

    public boolean isEmailAvailable(String email) {
        int count = session.selectOne("isEmailAvailable", email);
        return count == 0;
    }

    public boolean isPhoneAvailable(String phone) {
        int count = session.selectOne("isPhoneAvailable", phone);
        return count == 0;
    }

}
