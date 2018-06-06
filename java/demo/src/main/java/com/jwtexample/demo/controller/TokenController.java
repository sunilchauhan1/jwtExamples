package com.jwtexample.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @GetMapping("/token/encode/hmac256")
    public ResponseEntity<Map<String, String>> b() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, String> b = new HashMap<>();
        Algorithm algorithmHS = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("auth0")
                .withClaim("Somebody", "idontknow")
                .sign(algorithmHS);

        b.put("token", token);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
