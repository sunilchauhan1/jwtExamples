package com.jwtexample.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    public String encode(JSONObject jsonObject, Algorithm algorithm) throws JSONException {
        JSONArray names = jsonObject.names();
        JWTCreator.Builder builder = JWT.create();
        for (int i = 0; i < names.length(); i++) {
            String property = (String) names.get(i);
            builder.withClaim(property, (String) jsonObject.get(property));
        }
        return builder.sign(algorithm);
    }
}
