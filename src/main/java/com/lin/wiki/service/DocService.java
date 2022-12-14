package com.lin.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.wiki.entity.Content;
import com.lin.wiki.entity.Doc;
import com.lin.wiki.entity.DocExample;
import com.lin.wiki.mapper.ContentMapper;
import com.lin.wiki.mapper.DocMapper;
import com.lin.wiki.req.DocQueryReq;
import com.lin.wiki.req.DocSaveReq;
import com.lin.wiki.resp.DocQueryResp;
import com.lin.wiki.resp.PageResp;
import com.lin.wiki.utils.CopyUtil;
import com.lin.wiki.utils.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocService {

    @Resource
    private DocMapper docMapper;

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private SnowFlake snowFlake;

    public List<DocQueryResp> getAllDocs(){
        DocExample docExample = new DocExample();
        docExample.setOrderByClause("sort asc");
        List<Doc> docList = docMapper.selectByExample(docExample);

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);
        return list;
    }

    public PageResp<DocQueryResp> getDocList(DocQueryReq req){
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectByExample(docExample);
        PageInfo<Doc> pageInfo = new PageInfo<>(docList);

        PageResp<DocQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        List<DocQueryResp> respList = CopyUtil.copyList(docList, DocQueryResp.class);
        pageResp.setList(respList);
        return pageResp;
    }

    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            Long id = snowFlake.nextId();

            //新增
            doc.setId(id);
            docMapper.insert(doc);
            content.setId(id);
            contentMapper.insert(content);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
            if(contentMapper.updateByPrimaryKeyWithBLOBs(content) == 0)
                contentMapper.insert(content);
        }
    }

    public void delete(Long id) {
        docMapper.deleteByPrimaryKey(id);
    }

    public void delete(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        criteria.andIdIn(ids);
        docMapper.deleteByExample(docExample);
    }
}
