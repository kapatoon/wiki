package com.lin.wiki.service;

import com.lin.wiki.entity.Ebook;
import com.lin.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> getEbookList(){
        return ebookMapper.selectByExample(null);
    }
}
