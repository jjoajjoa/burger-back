package com.fivegirls.burger.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegirls.burger.dao.BurgerGameDAO;
import com.fivegirls.burger.vo.BurgerGameVO;
import com.fivegirls.burger.vo.IngrVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class BurgerGameRestController {

	@Autowired
	BurgerGameDAO dao;

	// 햄버거카테고리리스트 가지고 오기
	@RequestMapping("/burgerlist")
	public List<BurgerGameVO> burgerlist() throws Exception {
		List<BurgerGameVO> burgerlist = dao.selectBurgerList();
		return burgerlist;
	}

	// 페이지변경시 햄버거카테고리 id를 게임페이지에 저장하고, game 테이블생성하기
	@PostMapping("/burgerlistid")
	public void burgerlistid(@RequestBody BurgerGameVO vo, HttpSession session, HttpServletRequest request) {
	    session.removeAttribute("gamePk");
		System.out.println("햄버거리스트아이디: " + vo.getBurgerId());
		int burgerId = vo.getBurgerId();
		session.setAttribute("burgerId", burgerId);
		// session.getAttribute("userPk");
		session.setAttribute("userPk", 1);
		int userPk = (int) session.getAttribute("userPk");
		dao.createGame(burgerId, userPk);

		// 사용자id집어넣고 해당 game테이블 id가져오기
		int gamePk = dao.selectGameIdbyUserPk(userPk);
		session.setAttribute("gamePk", gamePk);
	}

	// 재료리스트 불러오기
	@RequestMapping("/IngrList")
	public List<IngrVO> IngrList() throws Exception {
		List<IngrVO> ingrList = dao.selectIngrList();
		return ingrList;
	}

	// 재료를 선택하면 해당id가 gamelog테이블에 들어가기
	@PostMapping("/IngrListId")
	public Map<String, Object> IngrListId(@RequestBody IngrVO vo, HttpSession session) {
		Map<String, Object> response = new HashMap<>();
		int ingrPk = vo.getIngrPk();
		int burgerId = (int) session.getAttribute("burgerId");
		int gamePk = (int) session.getAttribute("gamePk");
		
		//재료리스트가 8개 이상이면 프론트에서 모달띄우게 하고 재료리스트뽑아주지않기
		
		
		// 선택한 재료의 수량과 최대사용수량을 컨트롤러에서 계산하기
		// 선택한 재료를 파라미터로 넣어서 게임로그 안에 들어있는 해당 재료 수량을 가져오기
		Integer ingrQuantity = dao.compareQuantityIngr(ingrPk, gamePk);

		// 재료의 사용 수량이 null인 경우 (처음 선택된 경우)
		if (ingrQuantity == null) {
		    // 처음 선택된 재료이므로 createGameLog를 실행
		    dao.createGameLog(ingrPk, burgerId, gamePk);
		}
		// 재료가 이미 선택된 경우
		else {
		    // 재료의 사용 수량이 최대 수량을 초과하지 않은 경우 수량을 업데이트
		    dao.updateIngrQuantity(ingrPk, gamePk);
		}

		// 게임log생성
		System.out.println("재료리스트아이디: " + ingrPk + " 버거아이디" + burgerId);
		
		
		// 생성한 게임 log에서 게임id를 기반으로 재료리스트뽑기
		List<IngrVO> IngrListByGamePk = dao.selectIngrListByGamePk(gamePk);
		response.put("data", IngrListByGamePk);
		return response;
	}

	// 점수 계산해서 점수 가져오기
	@RequestMapping("/burgerScore")
	public int burgerScore(HttpSession session) {
		int burgerId = (int) session.getAttribute("burgerId");
		int gamePk = (int) session.getAttribute("gamePk");
		System.out.println("점수가 안나와 확인용" + burgerId);
		System.out.println("점수가 안나와 확인용" + gamePk);

		// 재료 점수와 사용한 재료수량을 더한값을 불러오기
		List<IngrVO> totalScore = dao.burgerScoreCal(gamePk);
		
		System.out.println("점수가 두배가됨 확인용" + totalScore);
		
		// 리스트에 있는걸 다 꺼내서 다 더하자
		int burgerScore = 0;
		for (IngrVO ingr : totalScore) {
			burgerScore += ingr.getTotalScore();
		}
		return burgerScore;
	}

	// 재료 삭제 버튼 누르면 리스트에서 삭제하기
	@PostMapping("/deleteIngr")
	public List<IngrVO> deleteIngr(@RequestBody IngrVO vo, HttpSession session) {
		System.out.println("삭제 재료 id" + vo.getIngrPk());
		int ingrPk = vo.getIngrPk();
		int burgerId = (int) session.getAttribute("burgerId");
		int gamePk = (int) session.getAttribute("gamePk");

		// 선택한 재료의 pk의 사용수량에서 -1하기
		dao.QuantityIngrDelete(ingrPk, gamePk);

		// 다시 리스트 보여주기
		List<IngrVO> updateList = dao.selectIngrListByGamePk(gamePk);
		System.out.println("삭제 리스트" + updateList);

		return updateList;
	}
	

}
