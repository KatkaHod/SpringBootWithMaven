package com.example.SpringBootWithMaven.controller;

import com.example.SpringBootWithMaven.service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@RequestMapping("uuid")

public class UuidController {
    @Autowired
    private UuidGenerator generate;

    @GetMapping("uuid")
    public UUID generatedUuid(){
        return  generate.generateUuid();
    }


}
