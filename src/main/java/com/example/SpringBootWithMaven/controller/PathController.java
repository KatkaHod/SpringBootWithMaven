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


    /**
     * Handles GET requests to retrieve the name of a default employee.
     * - The endpoint "/v1/employee" returns employee details for a hardcoded user ID (1).
     * - Always returns the information for the employee with ID 1.
     */

    @GetMapping("v1/employee")
    public String getEmployeeName() {
        return findEmployeeById(1L);
    }

    /**
     * Handles GET requests to retrieve employee information by user ID.
     * - The endpoint "/v2/employee/{userId}" takes "userId" as a path variable.
     * - Returns employee details for the given user ID.
     * - Example URLs: "localhost:8080/path/v2/employee/1" or "localhost:8080/path/v2/employee/2".
     * - localhost:8080/path/v2/employee/1 or localhost:8080/path/v2/employee/2
     */

    @GetMapping("v2/employee/{userId}")
    public String getEmployeeById(@PathVariable Long userId) {
        return findEmployeeById(userId);
    }

    @GetMapping("v3/employee/{id}")
    public String getEmployeeByIdWithName(@PathVariable("id") String thisIsTheIdFromUser
    ){
        return findEmployeeById(Long.parseLong(thisIsTheIdFromUser));
    }

    /**
     * Handles GET requests to retrieve employee information based on ID and country.
     * - The endpoint "/v5/employee/{id}/{country}" takes "id" and "country" as path variables.
     * - Retrieves the employee details using the provided ID and country.
     * - Returns a concatenated string with the employee information and the country.
     */

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


    /**
     * Handles GET requests for retrieving employee information based on ID and country.
     * - The endpoint "/v6/employee/{id}/{country}" maps both "id" and "country" as path variables.
     * - Path variables are stored in a Map, allowing dynamic access to their values.
     * - Retrieves the employee ID and country from the Map and uses these values to find and return
     *   employee information combined with the corresponding country.
     *
     *   localhost:8080/path/v6/employee/2/DE
     */

    @GetMapping("v6/employee/{id}/{country}")
    public String getEmployeeInMap(
            @PathVariable Map<String,String> pathVariables
    ) {
        //Getting values from the map:
        String id = pathVariables.get("id");
        String country = pathVariables.get("country");

        return findEmployeeById(Long.parseLong(pathVariables.get("id")))
                .concat(" ")
                .concat(findCountry(pathVariables.get("country")));
    }

    /**
     * Handles GET requests for retrieving an employee ID.
     * - Supports two endpoints: "/v7/employee" and "/v7/employee/{id}".
     * - If the ID is not provided in the URL, returns a message indicating that the ID is not provided.
     * - If the ID is provided, returns the given ID.
     */

    @GetMapping(value = {
            "v7/employee",
            "v7/employee/{id}"
            }
            )
    public String getEmployeeIdNotRequired(
            @PathVariable(value = "id", required = false) String employeeId
    ){
        if (employeeId == null || employeeId.isEmpty()) {
            return "The ID is not provided";
        }
        return employeeId;

    }


}
