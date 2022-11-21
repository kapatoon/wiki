package com.lin.wiki.service;

import com.lin.wiki.entity.Test;
import com.lin.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> getTest(){
        return testMapper.getTest();
    }
}
