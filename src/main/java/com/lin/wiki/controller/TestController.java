package com.lin.wiki.controller;

import com.lin.wiki.entity.Test;
import com.lin.wiki.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping("/test")
    public List<Test> getTest() {
        return testService.getTest();
    }
}
