package com.jwtexample.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/abc")
    public ResponseEntity<Map<String,String>> a(){
        Map<String,String> b = new HashMap<>();
        b.put("test","asdsda");
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
