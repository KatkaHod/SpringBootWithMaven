package com.example.SpringBootWithMaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path")

public class PathController {

    String Katerina = "Katerina";
    String Lukas = "Lukas";

    private String findEmployeeById(Long idFromUser) {
        if(idFromUser == 1) {
            return Katerina;
        }if(idFromUser == 2) {
            return Lukas;
        } else {
            return "The employee is not available in the system";
        }
    }

    @GetMapping("v1/employee")
    public String getEmployeeName() {
        return findEmployeeById(1L);
    }


    //try with localhost:8080/path/v2/employee/1 or localhost:8080/path/v2/employee/2
    @GetMapping("v2/employee/{userId}")
    public String getEmployeeById(@PathVariable Long userId) {
        return findEmployeeById(userId);
    }

}
