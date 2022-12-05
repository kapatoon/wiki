package com.lin.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.wiki.entity.Ebook;
import com.lin.wiki.entity.EbookExample;
import com.lin.wiki.mapper.EbookMapper;
import com.lin.wiki.req.EbookQueryReq;
import com.lin.wiki.req.EbookSaveReq;
import com.lin.wiki.resp.EbookQueryResp;
import com.lin.wiki.resp.PageResp;
import com.lin.wiki.utils.CopyUtil;
import com.lin.wiki.utils.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> getEbookList(EbookQueryReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName()))
            criteria.andNameLike("%" + req.getName() + "%");

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);

        PageResp<EbookQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        List<EbookQueryResp> respList = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        pageResp.setList(respList);
        return pageResp;
    }

    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
//             新增
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }
}
