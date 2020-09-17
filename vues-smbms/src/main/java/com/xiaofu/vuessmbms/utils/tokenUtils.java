package com.xiaofu.vuessmbms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xiaofu.vuessmbms.pojo.SmbmsUser;

import java.sql.Statement;
import java.util.Date;

public class tokenUtils {

    public static String createToken(SmbmsUser user){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 5 * 60 *1000;
        Date end = new Date(currentTime);

        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).withIssuedAt(start)
                .withExpiresAt(end).sign(Algorithm.HMAC256(user.getUserpassword()));
        return token;
    }

}
