package com.fullee.yangquan.master.framework.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class JWTKit {

    private static Algorithm algorithm = Algorithm.HMAC256("li");

    private static String issuer = "osk-framework";

    public static String createJWT() {

        Date expires = Date.from(LocalDateTime.now().plusDays(30).toInstant(ZoneOffset.ofHours(8)));

        return JWT.create().withIssuer(issuer)
                .withIssuedAt(new Date()) // 签发时间
                .withNotBefore(new Date()) // 生效时间
                .withExpiresAt(expires) // 过期时间
                .withClaim("loginName", "用户登录名")
                .sign(algorithm);

    }

    public static DecodedJWT verifierJWT(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();

        return verifier.verify(token);
    }

    public static void main(String[] args) {
        String jwt = createJWT();
        DecodedJWT decodedJWT = verifierJWT(jwt);

        System.out.println(decodedJWT.getClaim("loginName").asString());

    }

    public static DecodedJWT decodedJWT(String token) {
        return JWT.decode(token);
    }
}
