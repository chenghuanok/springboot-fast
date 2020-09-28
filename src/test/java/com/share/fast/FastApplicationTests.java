package com.share.fast;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class FastApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String password = passwordEncoder.encode("123");
        System.out.println("加密的密码："+password);
        final boolean flag =  passwordEncoder.matches("123",password);
        System.out.println(flag);
    }

}
