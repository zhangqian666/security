package com.zq.example.beans;

public class User {

    private String username;
    private String password;
    private String userid;

    public User() {
        this.username = "123";
        this.password = "123456";
        this.userid = "1";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
