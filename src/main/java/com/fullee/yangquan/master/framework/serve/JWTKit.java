package com.fullee.yangquan.master.framework.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTKit {


    private static String issuer = "osk-framework";



    private static Algorithm algorithm = Algorithm.HMAC256(issuer);

    private static Integer max_expires = 30;

    public static String createJWT(Map<String, String> claims) {

        Date expires = Date.from(LocalDateTime.now().plusDays(max_expires).toInstant(ZoneOffset.ofHours(8)));

        JWTCreator.Builder builder = JWT.create().withIssuer(issuer)
                .withIssuedAt(new Date()) // 签发时间
                .withNotBefore(new Date()) // 生效时间
                .withExpiresAt(expires); // 过期时间

        for (String key : claims.keySet()) {
            builder.withClaim(key, claims.get(key));
        }

        return builder.sign(algorithm);
    }

    public static DecodedJWT verifierJWT(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();

        return verifier.verify(token);
    }

    public static void main(String[] args) {
        HashMap<String, String> maps = new HashMap<>();
        maps.put(KEY.AUTHORIZATION.getValue(), "liwen@163.com");
        maps.put("Login", "1");

        String jwt = JWTKit.createJWT(maps);
        System.out.println(jwt);
        DecodedJWT decodedJWT = JWTKit.verifierJWT(jwt);

        System.out.println(decodedJWT.getClaim("name").as(String.class));

        DecodedJWT decodedJWT1 = JWTKit.decodedJWT(jwt);
        System.out.println(decodedJWT1.getClaim("Login").asString());

    }

    public static DecodedJWT decodedJWT(String token) {
        return JWT.decode(token);
    }

    public enum KEY{
        ISS("issuer"),
        AUTHORIZATION("loginName");

        private String val;

        KEY(String val) {
            this.val = val;
        }

        public String getValue() {
            return val;
        }
    }
}
