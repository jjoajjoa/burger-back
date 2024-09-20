package com.fivegirls.burger.vo;

public class BurgerKingVO {
	public int gamePk;
	public int userPk;
	public String userName;
	public int burgerPk;
	public String burgerName;
	public int gameScore;

	public int getGamePk() {
		return gamePk;
	}

	public void setGamePk(int gamePk) {
		this.gamePk = gamePk;
	}

	public int getUserPk() {
		return userPk;
	}

	public void setUserPk(int userPk) {
		this.userPk = userPk;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBurgerPk() {
		return burgerPk;
	}

	public void setBurgerPk(int burgerPk) {
		this.burgerPk = burgerPk;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	@Override
	public String toString() {
		return "BurgerKingVO [gamePk=" + gamePk + ", userPk=" + userPk + ", userName=" + userName + ", burgerPk="
				+ burgerPk + ", burgerName=" + burgerName + ", gameScore=" + gameScore + "]";
	}

}