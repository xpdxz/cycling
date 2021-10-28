package com.cycling.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
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

    /**
     * token过期时间
     */
    private static final long EXPIRE_TIME = 60 * 60 * 24 * 7;

    /**
     * 刷新时间
     */
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 7 * 14;

    /**
     * 生成token
     *
     * @param map
     * @author RainGoal
     * @date 2021/9/29 12:04 下午
     * @return: java.lang.String
     */
    public static String getToken(Map<String, String> map,Long currentTime) {

        //设置Token的过期时间为五分钟
        Date token_expire_time=new Date(currentTime+EXPIRE_TIME);
        //用jwt创造token
        JWTCreator.Builder builder = JWT.create();
        //用map遍历传入token的数据
        map.forEach((k, v) -> {
            builder.withClaim(k,v);
        });
        String token=builder
                .withClaim("currentTime",currentTime)
                .withExpiresAt(token_expire_time)
                .sign(Algorithm.HMAC256(SIGN));
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
    public static boolean verify (String token) throws Exception{

        DecodedJWT v = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return true;

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
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
}
