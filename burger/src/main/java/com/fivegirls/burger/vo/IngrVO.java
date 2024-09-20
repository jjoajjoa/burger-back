package com.fivegirls.burger.vo;

public class IngrVO {
	public int gamePk;
	public int ingrPk;
	public String ingrName;
	public String ingrUrl;
	public int ingrUsageQuantity;
	public int totalScore;
	public String ingrSideUrl;
	
	public int getGamePk() {
		return gamePk;
	}
	
	public void setGamePk(int gamePk) {
		this.gamePk = gamePk;
	}

	public String getIngrSideUrl() {
		return ingrSideUrl;
	}

	public void setIngrSideUrl(String ingrSideUrl) {
		this.ingrSideUrl = ingrSideUrl;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getIngrPk() {
		return ingrPk;
	}

	public int getIngrUsageQuantity() {
		return ingrUsageQuantity;
	}

	public void setIngrUsageQuantity(int ingrUsageQuantity) {
		this.ingrUsageQuantity = ingrUsageQuantity;
	}

	public void setIngrPk(int ingrPk) {
		this.ingrPk = ingrPk;
	}

	public String getIngrName() {
		return ingrName;
	}

	public void setIngrName(String ingrName) {
		this.ingrName = ingrName;
	}

	public String getIngrUrl() {
		return ingrUrl;
	}

	public void setIngrUrl(String ingrUrl) {
		this.ingrUrl = ingrUrl;
	}

	@Override
	public String toString() {
		return "IngrVO [gamePk=" + gamePk + ", ingrPk=" + ingrPk + ", ingrName=" + ingrName + ", ingrUrl=" + ingrUrl
				+ ", ingrUsageQuantity=" + ingrUsageQuantity + ", totalScore=" + totalScore + ", ingrSideUrl="
				+ ingrSideUrl + "]";
	}

}
