package com.cycling.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @ClassName: JwtUtils
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/9/29 11:40 上午
 */
public class JWTUtils {

    /**
     * 定义token签名sign密匙
     */
    private static final String SIGN = "@!off&*i</c)i+-a$l&%GYR%99jo32j$#:][";

    private static final long EXPIRE_TIME = 5*60*1000;
    /**
     * 生成token
     *
     * @param map
     * @author RainGoal
     * @date 2021/9/29 12:04 下午
     * @return: java.lang.String
     */
    public static String getToken(Map<String, String> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 99999);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    /**
     * 验证token合法性
     *
     * @param token
     * @author RainGoal
     * @date 2021/9/29 11:57 上午
     * @return: void
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    /**
     * 拿到token用户信息
     *
     * @param token
     * @author RainGoal
     * @date 2021/9/29 12:06 下午
     * @return: com.auth0.jwt.interfaces.DecodedJWT
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
}
