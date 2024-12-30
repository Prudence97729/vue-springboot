package com.zsq;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen(){//测试生成token方法
        Map<String ,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60 *12) )//添加过期时间（访问网站一段时间需要再次登录）
                .sign(Algorithm.HMAC256("zsq"));//指定算法，配置秘钥
        System.out.println(token);
    }
    @Test
    public void TestParse(){//测试验证token方法
        //定义字符串，模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MzU1MDMwNjV9." +
                "wopdsXxJHyoIGBYa8yPt-YD6Mxqv4rf1rG0EJKmQaoE";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("zsq")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
