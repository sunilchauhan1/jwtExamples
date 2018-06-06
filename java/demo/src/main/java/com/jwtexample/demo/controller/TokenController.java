package com.jwtexample.demo.controller;

import com.auth0.jwt.algorithms.Algorithm;
import com.jwtexample.demo.service.JWTService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.auth0.jwt.impl.PublicClaims.ISSUER;

@RestController
public class TokenController {

    private JWTService jwtService;

    private Algorithm rsaAlgorithm;

    private Algorithm hmacAlgorithm;

    @Autowired
    public TokenController(JWTService jwtService, @Qualifier("rsaAlgorithm") Algorithm rsaAlgorithm, @Qualifier("hmacAlgorithm") Algorithm hmacAlgorithm) {
        this.jwtService = jwtService;
        this.rsaAlgorithm = rsaAlgorithm;
        this.hmacAlgorithm = hmacAlgorithm;
    }

    @GetMapping("/token/encode/hmac256")
    public ResponseEntity<Map<String, String>> encodehmac() throws JSONException {
        Map<String, String> b = new HashMap<>();
        String token = jwtService.encode(createSampleClaim(), hmacAlgorithm);
        b.put("token", token);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/token/encode/rsa256")
    public ResponseEntity<Map<String, String>> encodeRSA() throws JSONException {
        Map<String, String> b = new HashMap<>();
        String token = jwtService.encode(createSampleClaim(), rsaAlgorithm);
        b.put("token", token);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }


    private JSONObject createSampleClaim() throws JSONException {
        JSONObject claimPayload = new JSONObject();
        claimPayload.put(ISSUER, "auth0");
        claimPayload.put("something", "someOtherthing");
        return claimPayload;
    }
}