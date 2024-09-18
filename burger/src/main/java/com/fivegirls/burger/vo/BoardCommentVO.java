package com.fivegirls.burger.vo;

import java.util.Date;

public class BoardCommentVO {
	public int commentPk;
	public int boardPk;
	public int userPk;
	public String userName;
	public String commentBody;
	public Date commentRegDate;

    // Getters and Setters
    public int getCommentPk() {
        return commentPk;
    }
    public void setCommentPk(int commentPk) {
        this.commentPk = commentPk;
    }
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
    public String getCommentBody() {
        return commentBody;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public Date getCommentRegDate() {
        return commentRegDate;
    }
    public void setCommentRegDate(Date commentRegDate) {
        this.commentRegDate = commentRegDate;
    }
}
