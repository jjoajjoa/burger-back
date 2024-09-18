package com.fivegirls.burger.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	public int boardPk;
	public int userPk;
	public String userName;
	public String boardTitle;
	public String boardBody;
	public Date boardRegDate;
	public int boardViewCount;
	public int commentPk;
	public String commentBody;
	public Date commentRegDate;
}
