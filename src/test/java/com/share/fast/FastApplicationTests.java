//package com.share.fast;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.Base64Codec;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Date;
//
//@SpringBootTest
//class FastApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void test1(){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        final String password = passwordEncoder.encode("123");
//        System.out.println("加密的密码："+password);
//        final boolean flag =  passwordEncoder.matches("123",password);
//        System.out.println(flag);
//    }
//
//    @Test
//    void test2(){
//        //为了方便测试，我们将过期时间设置为1分钟
//        long now = System.currentTimeMillis();
//        long exp = now + 1000*60;
//        final JwtBuilder builder = Jwts.builder()
//                //唯一id
//                .setId("888")
//                //接受的用户
//                .setSubject("小白")
//                //设置签发时间
//                .setIssuedAt(new Date())
//                //设置签名秘钥
//                .signWith(SignatureAlgorithm.HS256,"xxxxxx")
//              //  .setExpiration(new Date(exp))
//                .claim("name","小红")
//                .claim("logo","必胜");
//        final String token = builder.compact();
//        System.out.println(token);
//        System.out.println("================================");
//        final String[] split = token.split("\\.");
//        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
//    }
//
//    @Test
//    void test3(){
//        final String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE2MDE3OTM4NTQsIm5hbWUiOiLlsI_nuqIiLCJsb2dvIjoi5b-F6IOcIn0.jXl97X4B-uWz8-1DLikUubY9JEYEfR927gxH08UJ4h8";
//        Claims claims = Jwts.parser().setSigningKey("xxxxxx").parseClaimsJws(token).getBody();
//        System.out.println("id:" + claims.getId());
//        System.out.println("subject:" + claims.getSubject());
//        System.out.println("IssuedAt:" + claims.getIssuedAt());
//        System.out.println("exp:"+claims.getExpiration());
//        System.out.println("name:"+claims.get("name"));
//        System.out.println("logo:"+claims.get("logo"));
//    }
//}
