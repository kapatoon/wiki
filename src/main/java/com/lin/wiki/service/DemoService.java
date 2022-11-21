package com.lin.wiki.service;

import com.lin.wiki.entity.Demo;
import com.lin.wiki.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> getDemo(){
        return demoMapper.selectByExample(null);
    }
}
