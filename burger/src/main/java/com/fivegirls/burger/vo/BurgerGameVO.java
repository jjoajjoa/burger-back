package com.fivegirls.burger.vo;

public class BurgerGameVO {
	public int burgerId;
	public String burgerName;
	
	public int getBurgerId() {
		return burgerId;
	}
	
	public void setBurgerId(int burgerId) {
		this.burgerId = burgerId;
	}
	
	public String getBurgerName() {
		return burgerName;
	}
	
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	
	@Override
	public String toString() {
		return "BurgerVO [burgerId=" + burgerId + ", burgerName=" + burgerName + "]";
	}
	
}
