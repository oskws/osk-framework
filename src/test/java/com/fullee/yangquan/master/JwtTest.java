package com.fullee.yangquan.master;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;

public class JwtTest {

    @Test
    public void testJwt() {
        Algorithm algorithm = Algorithm.HMAC256("li");
        String jwt = JWT.create()
                .withKeyId("123")
                .withIssuer("liwenliang")
                .withClaim("name", "山东宏泰")
//                .withExpiresAt(new Date())
                .sign(algorithm);

        JWTVerifier jv = JWT.require(algorithm)
                .withIssuer("liwenlianx")
                .build();

        DecodedJWT decode = JWT.decode(jwt);
        DecodedJWT verify = jv.verify(decode);

        System.out.println(JSON.toJSONString(verify.getClaims()));

        System.out.println(jwt);
    }

    @Test
    public void testTime(){
        java.util.Date from = Date.from(LocalDateTime.now().plusDays(30).toInstant(ZoneOffset.ofHours(8)));
        System.out.println(from);
    }
}
