package com.share.fast.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security配置类
 * @Author: chenghuan
 * @Date: 2020/9/27 15:33
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 权限
     * @param
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                /*自定义请求参数名称
                .usernameParameter("userName")
                .passwordParameter("password")*/
                //自定义登录页
                .loginPage("/login.html")
                //必须和表单提交的接口一样，会去执行自定义登录逻辑
                .loginProcessingUrl("/test/login");
        //授权
        http.authorizeRequests()
                //放行，不需要认证
                .antMatchers("/login.html").permitAll()
                //剩下所有请求都必须认证才能访问，必须登录
                .anyRequest().authenticated();
        //关闭csrf
        http.csrf().disable();
    }

    /**
     * 密码加密
     * @return PasswordEncoder
    */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

