package com.zq.web.beans;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "用户userid")
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
