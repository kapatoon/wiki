package com.lin.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.wiki.entity.Ebook;
import com.lin.wiki.entity.EbookExample;
import com.lin.wiki.mapper.EbookMapper;
import com.lin.wiki.req.EbookReq;
import com.lin.wiki.resp.EbookResp;
import com.lin.wiki.resp.PageResp;
import com.lin.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> getEbookList(EbookReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(ebookReq.getName()))
            criteria.andNameLike("%" + ebookReq.getName() + "%");

        PageHelper.startPage(ebookReq.getPage(), ebookReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        pageResp.setList(respList);
        return pageResp;
    }
}
