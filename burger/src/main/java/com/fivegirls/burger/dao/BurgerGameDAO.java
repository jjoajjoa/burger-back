package com.fivegirls.burger.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fivegirls.burger.vo.BurgerGameVO;
import com.fivegirls.burger.vo.IngrVO;

@Component
public class BurgerGameDAO {
	
	@Autowired
	SqlSession session;
	
	//버거 카테고리리스트 가져오기
	public List<BurgerGameVO> selectBurgerList() throws Exception {
		return session.selectList("selectBurgerList");
	}
	
	//game테이블 생성하기(사용자id, burgerid필요)
	public void createGame(int burgerId, int userPk) {
		Map<String, Integer> params = new HashMap<>(); 
	    params.put("userPk", userPk);
	    params.put("burgerId", burgerId);
		session.insert("createGame",params);
	}
	
	//사용자 id를 기반으로 생성한 gameid가져오기
	public int selectGameIdbyUserPk(int userPk) {
		return session.selectOne("selectGameIdbyUserPk",userPk);
	}
	
	//재료리스트 가져오기
	public List<IngrVO> selectIngrList() {
		return session.selectList("selectIngrList");
	}
	
	//선택한 재료의 갯수가 몇개인지 가져오기
	public Integer compareQuantityIngr(int ingrPk, int gamePk) {
		Map<String, Integer> params = new HashMap<>(); 
	    params.put("ingrPk", ingrPk);
	    params.put("gamePk", gamePk);
		return session.selectOne("compareQuantityIngr",params);
	}
	
	//선택한 재료의 최대 사용수량 가져오기
	public int ingrMaxQuantity(int ingrPk) {
		return session.selectOne("ingrMaxQuantity",ingrPk);
	}
	
	//재료가 있는데 최대사용수량보다 작을경우 추가해주기
	public void updateIngrQuantity(int ingrPk, int gamePk) {
		Map<String, Integer> params = new HashMap<>(); 
	    params.put("ingrPk", ingrPk);
	    params.put("gamePk", gamePk);
		session.update("updateIngrQuantity",params);
	}
	
	//gamelog테이블 생성 (선택한 재료와 session에 있는 burgerid를 파라미터로)
	public void createGameLog(int ingrPk, int burgerId, int gamePk) {
		Map<String, Integer> params = new HashMap<>(); 
	    params.put("ingrPk", ingrPk);
	    params.put("burgerId", burgerId);
	    params.put("gamePk", gamePk);
	    session.insert("mapper-game.createGameLog",params);
	}
	
	public List<IngrVO> selectIngrListByGamePk(int gamePk) {
		return session.selectList("selectIngrListByGamePk", gamePk);
	}
	
	public List<IngrVO> burgerScoreCal(int gamePk) {
		return session.selectList("burgerScoreCal", gamePk);
	}
	
	public void QuantityIngrDelete(int ingrPk, int gamePk) {
		Map<String, Integer> params = new HashMap<>(); 
	    params.put("ingrPk", ingrPk);
	    params.put("gamePk", gamePk);
	    session.update("QuantityIngrDelete",params);
	}
	
	
}
