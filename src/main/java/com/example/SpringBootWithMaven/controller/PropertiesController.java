package com.example.SpringBootWithMaven.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("propertiesController")
public class PropertiesController {

    //This field is injected with the value of the 'company.name' property from the configuration file
    @Value("${company.name}")
    String companyName;

    @GetMapping("v1/try")
    public String getValue(){
        return companyName;
    }

}
