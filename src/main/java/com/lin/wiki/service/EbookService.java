package com.lin.wiki.service;

import com.github.pagehelper.PageHelper;
import com.lin.wiki.entity.Ebook;
import com.lin.wiki.entity.EbookExample;
import com.lin.wiki.mapper.EbookMapper;
import com.lin.wiki.req.EbookReq;
import com.lin.wiki.resp.EbookResp;
import com.lin.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> getEbookList(EbookReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(ebookReq.getName()))
            criteria.andNameLike("%" + ebookReq.getName() + "%");

        PageHelper.startPage(1, 3);
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }
}
