package com.jwtexample.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean("rsaAlgorithm")
    public Algorithm rsaAlgorithm() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) kp.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
        Algorithm algorithmRS = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
        return algorithmRS;
    }

    @Bean("hmacAlgorithm")
    public Algorithm hmacAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("secret");
    }

    @Bean("hmacVerifier")
    public JWTVerifier getHmacVerifier() throws UnsupportedEncodingException {
        Algorithm hmacAlgorithm = hmacAlgorithm();
        return JWT.require(hmacAlgorithm).withClaim("something","someOtherthing").build();
    }
}
