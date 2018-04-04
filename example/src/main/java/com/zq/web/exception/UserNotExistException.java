package com.zq.web.exception;

import java.rmi.server.UID;

public class UserNotExistException extends RuntimeException{

    private String userid;


    public UserNotExistException(String userid) {
        super("user not exist");
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
