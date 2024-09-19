package com.fivegirls.burger.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BurgerKingVO {
    public int gamePk;
    public int userPk;
    public String userName;
    public int burgerPk;
    public String burgerName;
    public int gameScore;
}