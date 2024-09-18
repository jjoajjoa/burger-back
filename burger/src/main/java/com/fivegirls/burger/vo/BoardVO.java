package com.fivegirls.burger.vo;

import java.util.Date;
import java.util.List;

public class BoardVO {
	public int boardPk;
	public int userPk;
	public String userName;
	public String boardTitle;
	public String boardBody;
	public Date boardRegDate;
	public int boardViewCount;

	// 댓글 리스트를 담을 필드 추가
	public List<BoardCommentVO> comments;

	// Getters and Setters
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	// 댓글 리스트의 getter와 setter 추가
	public List<BoardCommentVO> getComments() {
		return comments;
	}

	public void setComments(List<BoardCommentVO> comments) {
		this.comments = comments;
	}

	public String toString() {
		return "BoardVO [boardPk=" + boardPk + ", userPk=" + userPk + ", userName=" + userName + ", boardTitle="
				+ boardTitle + ", boardBody=" + boardBody + ", boardRegDate=" + boardRegDate + ", boardViewCount="
				+ boardViewCount + ", comments=" + comments + "]";
	}

}
