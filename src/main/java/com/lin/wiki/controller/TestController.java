package com.lin.wiki.controller;

import com.lin.wiki.entity.Test;
import com.lin.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.string}")
    private String testString;

    @Resource
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!" + testString;
    }

    @RequestMapping("/test")
    public List<Test> getTest() {
        return testService.getTest();
    }
}
