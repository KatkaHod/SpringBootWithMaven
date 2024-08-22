package com.example.SpringBootWithMaven.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("login") //the beginning of the path

public class LoginController {

    private final String DEFAULT_PASSWORD = "Kth762*";
    private boolean checkPassword(String userPassword){
        return userPassword.equals(DEFAULT_PASSWORD);
    }

    @PostMapping("v1/login")
    public String isPossibleToLogIn(
            @RequestBody String password
    ){
        if (checkPassword(password)) {
            return "you are logged in";
        } else {
            return  "wrong password, please check again";
        }
    }





}
