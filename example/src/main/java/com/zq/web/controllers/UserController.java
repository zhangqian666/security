package com.zq.web.controllers;


import com.zq.web.beans.User;
import com.zq.core.restful.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/users")
    public ServerResponse getUser() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return ServerResponse.createBySuccess(users);

    }

    @GetMapping("/user")
    public ServerResponse createUser(User user) {

//        throw new UserNotExistException("服务器错误");
        return ServerResponse.createBySuccess(user);

    }

    @GetMapping("/device")
    public ServerResponse getDevice() {

        throw new RuntimeException("获取设备失败");
//        return ServerResponse.createBySuccess(user);

    }
}
