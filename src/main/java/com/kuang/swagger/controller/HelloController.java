package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: swagger-demo
 * @description:
 * @author: 作者
 * @create: 2021-04-25 20:34
 */
//Operation接口

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String Hello() {
        return "hello";
    }

    @ApiOperation("helloController")
    //只要我们接口中，返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(String username) {
        return new User();
    }

    @PostMapping(value = "/user")
    public String user2(String username) {
        return username + "hrllo";
    }

}
