package com.adu.learn.mybatis.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
public class JwtHelper {
    private static final long TOKEN_EXPIRE = 6 * 60 * 60 * 1000;
    private static final String TOKEN_SIGN_KEY = "12@#$%3456";

    public static String createToken(String userName) {
        Date date = new Date();

        String token = Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + TOKEN_EXPIRE))
                .signWith(SignatureAlgorithm.HS256, TOKEN_SIGN_KEY)
                .compact();
        log.error("token:{}",token);
        return token;
    }

    public static String parseToken(String token) {
        if(StringUtils.isEmpty(token)) return null;

        try {
            Claims body = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token).getBody();
            String subject = body.getSubject();
            log.error("subject:{}",subject);
            if (StringUtils.isEmpty(subject)){
                return null;
            }
            return subject;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken("dulv");
        JwtHelper.parseToken(token);

    }
}
