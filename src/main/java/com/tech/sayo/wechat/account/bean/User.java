package com.tech.sayo.wechat.account.bean;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer userId;

    private String userWechatid = "";

    private String userMobile = "";

    private String userNickname = "";

    private String userHead = "";

    private Integer userSex = 1;

    private String userBirthday = "";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserWechatid() {
        return userWechatid;
    }

    public void setUserWechatid(String userWechatid) {
        this.userWechatid = userWechatid == null ? null : userWechatid.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead == null ? null : userHead.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }
    
    public static Map<String,String> orderBySql(){
    	Map<String,String> map = new HashMap<String, String>();
    	map.put("userMobile", "user_mobile");
    	map.put("userNickname", "user_nickname");
    	map.put("userSex", "user_sex");
    	map.put("userBirthday", "user_birthday");
    	map.put("userWechatid", "case when user_wechatid = '' then 0 else 1 end ");
    	return map;
    }
}