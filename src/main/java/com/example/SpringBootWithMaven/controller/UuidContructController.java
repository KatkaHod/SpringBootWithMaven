package com.example.SpringBootWithMaven.controller;

import com.example.SpringBootWithMaven.service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("v2")
public class UuidContructController {

    //a safer way to use @Autowired
    UuidGenerator generate;

    public UuidContructController(
            @Autowired UuidGenerator uuidGenerator
    ){
        this.generate = uuidGenerator;
    }

    @GetMapping("uuid")
    public UUID generatedUuid(){
        return  generate.generateUuid();
    }
}
