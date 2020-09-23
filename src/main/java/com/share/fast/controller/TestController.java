package com.share.fast.controller;

import com.share.fast.common.ResponseResult;
import com.share.fast.common.User;
import com.share.fast.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @Author: chenghuan
 * @Date: 2020/9/21 21:35
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("/test2")
    public User test2(){
        final User user = new User();
        user.setName("123");
        user.setAge(10);
        return user;
    }

    @GetMapping("/test3")
    public boolean test3(){
        return true;
    }

    @GetMapping("/test4")
    public int test4(){
        return 10;
    }

    @GetMapping("/test5")
    public void test5(){
    }

    @GetMapping("/test6")
    public ResponseResult test6(){
       return ResponseResult.buildResponseResult(true, HttpStatus.OK.value(),"","111111");
    }

    @GetMapping("/test7")
    public Integer test7(){
        if(true){
            throw new BizException(100,"异常处理");
        }
        return 10;
    }

    @GetMapping("/test8")
    public Integer test8() {
        if(true){
            throw new RuntimeException("异常处理");
        }
        return 10;
    }
}
