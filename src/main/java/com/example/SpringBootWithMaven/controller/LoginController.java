package com.example.SpringBootWithMaven.controller;

import com.example.SpringBootWithMaven.model.LogIn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("login") //the beginning of the path

public class LoginController {

    @Value("${company.default.pw}")
    private String DEFAULT_PASSWORD;

    private boolean checkPassword(String userPassword){
        return userPassword.equals(DEFAULT_PASSWORD);
    }


    /**
     * Handles POST requests for user login.
     * - The endpoint "/v1/login" receives a password in the request body.
     * - If the password is correct (checked via the checkPassword method), it returns a success message ("you are logged in").
     * - If the password is incorrect, it returns an error message ("wrong password, please check again").
     */

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


    /**
     * Handles POST requests for user login with additional user information.
     * - The endpoint "/v2/login" receives user data (such as password and year of birth) in the request body.
     * - First, it checks if the user's year of birth indicates they are over 18. If not, it returns an age restriction message.
     * - If the user is old enough, it checks the password:
     * - If the password is correct, it returns a success message ("you are logged in").
     * - If the password is incorrect, it returns an error message ("wrong password, please check again").
     * - The key in JSON (Postman) must be equal to the variables in LogIn!!!!
     BODY IN POSTMAN:
     {
     "name": "Katerina",
     "ipAddress": "10.15.20.25",
     "yearOfBorn": 2018,
     "password": "Kth762*"
     }


     */

    @PostMapping("v2/login")
    public String isPossibleToLogInWithUserInfo (
            @RequestBody LogIn userData
            ){
        if(userData.getYearOfBirth() > 2009) {
            return "You are not logged in. You must be over 18 years old.";
        }

        if (checkPassword(userData.getPassword())){
            return "you are logged in";
        } else {
            return "wrong password, please check again";
        }

    }

    /**
     * Handles POST requests for user login without requiring a request body.
     * - The endpoint "/v3/login" optionally accepts user details in the request body.
     * - If no user details are provided (i.e., the body is null), it returns a message indicating "No information provided."
     * - If user details are provided, it returns a success message ("you are logged in").
     */

    @PostMapping("v3/login")
    public String logInWithoutBody (
            @RequestBody(required = false) LogIn userDetail
    ){
        if(userDetail == null){
            return "No information provided.";
        }
        return "you are logged in";
    }


    @PostMapping("v4/login")
    public String logInWithOrWithoutBodyInOptional(
            @RequestBody Optional<LogIn> userData

    ){
        if(userData.isEmpty()){
            return "you are not logged in, because no information is provided...";
        } else {
            return "you are logged in";
        }
    }



}
