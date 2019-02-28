package com.fullee.yangquan.master.framework.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTKit {

    private static Algorithm algorithm = Algorithm.HMAC256("li");

    public static String createJWT(){

        return JWT.create().withIssuer("签发者")
                .withIssuedAt(new Date()) // 签发时间
                .withNotBefore(new Date()) // 生效时间
                .withExpiresAt(new Date()) // 过期时间
                .withClaim("loginName","用户登录名")
                .sign(algorithm);

    }

    public static DecodedJWT decodedJWT(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("签发者")
                .build();

        return verifier.verify(token);
    }
}
