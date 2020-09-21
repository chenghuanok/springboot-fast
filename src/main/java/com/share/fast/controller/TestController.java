package com.share.fast.controller;

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
}
