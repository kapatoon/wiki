package com.lin.wiki.controller;

import com.lin.wiki.entity.Demo;
import com.lin.wiki.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/demo")
    public List<Demo> getDemo() {
        return demoService.getDemo();
    }
}
