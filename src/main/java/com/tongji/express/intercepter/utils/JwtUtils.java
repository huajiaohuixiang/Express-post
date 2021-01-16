package com.tongji.express.intercepter.utils;

import com.tongji.express.entity.inputVo.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    private static final String SUBJECT = "express";

    //过期时间为72 hours
    private static final long EXPIRE = 1000 * 60 * 60 * 24;

    private static final String APP_SECRET = "tongjiExpress";

    public static String genJsonWebToken(Account user) {
        if (user == null || user.getUserID() == null || user.getName() == null || user.getSex() == null) {
            System.out.println("----------sex:----------"+user.getName());
            return null;
        }
        String role="user";
        if(user.getUserID().length()<10)
            role="worker";
        return Jwts.builder().setSubject(SUBJECT)
                // 下面4行设置token中间字段，携带用户的信息
                .claim("userID", user.getUserID())
                .claim("name", user.getName())
                .claim("sex", user.getSex())
                .claim("role",role)
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }


    public static Claims checkJWT(String token) {
        try {
            return Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // 篡改token会导致校验失败，走到异常分支，这里返回null
            return null;
        }
    }

    public static boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }

    public static Date getExpirationDateFromToken(String token) {
        return checkJWT(token).getExpiration();
    }
}
