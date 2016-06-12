package com.tech.sayo.background.sys.bean;

public class User {
    private Integer userId;

    private String userAccountname;

    private String userPassword;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccountname() {
        return userAccountname;
    }

    public void setUserAccountname(String userAccountname) {
        this.userAccountname = userAccountname == null ? null : userAccountname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}