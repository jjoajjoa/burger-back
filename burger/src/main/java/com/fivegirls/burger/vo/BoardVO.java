package com.fivegirls.burger.vo;

import java.util.Date;

public class BoardVO {

	public int boardPk;
	public int userPk;
	public String boardTitle;
	public String boardBody;
	public Date boardRegDate;
	public int boardViewCount;

	public int getBoardPk() {
		return boardPk;
	}

	public void setBoardPk(int boardPk) {
		this.boardPk = boardPk;
	}

	public int getUserPk() {
		return userPk;
	}

	public void setUserPk(int userPk) {
		this.userPk = userPk;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardBody() {
		return boardBody;
	}

	public void setBoardBody(String boardBody) {
		this.boardBody = boardBody;
	}

	public Date getBoardRegDate() {
		return boardRegDate;
	}

	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

	public int getBoardViewCount() {
		return boardViewCount;
	}

	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}

	@Override
	public String toString() {
		return "BoardVO [boardPk=" + boardPk + ", userPk=" + userPk + ", boardTitle=" + boardTitle + ", boardBody="
				+ boardBody + ", boardRegDate=" + boardRegDate + ", boardViewCount=" + boardViewCount + "]";
	}

}
