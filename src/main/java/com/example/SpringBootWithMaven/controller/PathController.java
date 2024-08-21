package com.example.SpringBootWithMaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

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

    private String findCountry(String country) {
        return switch (country) {
            case "CZ" -> "Czech Republic";
            case "DE" -> "Germany";
            case "SK" -> "Slovakia";
            case "PL" -> "Poland";
            default -> "The country is not available";
        };
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

    @GetMapping("v3/employee/{id}")
    public String getEmployeeByIdWithName(@PathVariable("id") String thisIsTheIdFromUser
    ){
        return findEmployeeById(Long.parseLong(thisIsTheIdFromUser));
    }

    //two input parameters
    @GetMapping ("v5/employee/{id}/{country}")
    public String getEmployeeByIdAndCountry (
            @PathVariable(value = "id") Long userId,
            @PathVariable(value = "country") String country
    ){
        String answerId = findEmployeeById(userId);
        String answerCountry = findCountry(country);

        //return answerId + " " + answerCountry;
        return answerId.concat(" ").concat(answerCountry);
    }

    @GetMapping("v6/employee/{id}/{country}")
    public String getEmployeeInMap(
            @PathVariable Map<String,String> pathVariables
    ) {
        String id = pathVariables.get("id");
        String country = pathVariables.get("country");

        return findEmployeeById(Long.parseLong(pathVariables.get("id")))
                .concat(" ")
                .concat(findCountry(pathVariables.get("country")));
    }







}
