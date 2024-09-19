package com.fivegirls.burger.vo;

public class TestTypeVO {
	// 기본값으로 0 설정
	public int burger = 0;
	public int jorengi = 0;
	public int coding = 0;
	public int teacher = 0;

	public int userPk; 
	public String userName;
	public String testTypeResult;
	public String testTypeDetails;
	
	public int sessionUserPk;
	
	public int getSessionUserPk() {
		return sessionUserPk;
	}
	
	public void setSessionUserPk(int sessionUserPk) {
		this.sessionUserPk = sessionUserPk;
	}

	public int getBurger() {
		return burger;
	}

	public void setBurger(int burger) {
		this.burger = burger;
	}

	public int getJorengi() {
		return jorengi;
	}

	public void setJorengi(int jorengi) {
		this.jorengi = jorengi;
	}

	public int getCoding() {
		return coding;
	}

	public void setCoding(int coding) {
		this.coding = coding;
	}

	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
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
	
	public String getTestTypeResult() {
		return testTypeResult;
	}

	public void setTestTypeResult(String testTypeResult) {
		this.testTypeResult = testTypeResult;
	}

	public String getTestTypeDetails() {
		return testTypeDetails;
	}

	public void setTestTypeDetails(String testTypeDetails) {
		this.testTypeDetails = testTypeDetails;
	}

	@Override
	public String toString() {
		return "TestTypeVO [burger=" + burger + ", jorengi=" + jorengi + ", coding=" + coding + ", teacher=" + teacher
				+ ", userPk=" + userPk + ", userName=" + userName + ", testTypeResult=" + testTypeResult
				+ ", testTypeDetails=" + testTypeDetails + "]";
	}

}
