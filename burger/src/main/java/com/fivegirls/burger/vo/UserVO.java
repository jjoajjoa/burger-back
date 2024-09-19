package com.fivegirls.burger.vo;

public class UserVO {
    private int userPk;         // 회원 PK
    private int testTypePk;      // 테스트 유형 PK
    private String userId;       // 회원 아이디
    private String userPw;       // 회원 비밀번호
    private String userName;     // 회원 이름
    private String userBirth;    // 회원 생년월일
    private String userMobile;   // 회원 전화번호
    private String userEmail;    // 회원 이메일

    // Getter and Setter methods
    public int getUserPk() {
        return userPk;
    }

    public void setUserPk(int userPk) {
        this.userPk = userPk;
    }

    public int getTestTypePk() {
        return testTypePk;
    }

    public void setTestTypePk(int testTypePk) {
        this.testTypePk = testTypePk;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UserVO [userPk=" + userPk + ", testTypePk=" + testTypePk + ", userId=" + userId +
               ", userPw=" + userPw + ", userName=" + userName + ", userBirth=" + userBirth +
               ", userMobile=" + userMobile + ", userEmail=" + userEmail + "]";
    }
}
