package com.zq.example.controllers;


import com.zq.example.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/user")
    public List<User> getUser() {

        List<User> users  = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;

    }
}
