package com.lin.wiki.controller;

import com.lin.wiki.req.DocSaveReq;
import com.lin.wiki.resp.DocQueryResp;
import com.lin.wiki.resp.CommonResp;
import com.lin.wiki.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Resource
    private DocService docService;

    @GetMapping("/all")
    public CommonResp getAllDocs( ) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> docList = docService.getAllDocs();
        resp.setContent(docList);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveDoc(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        docService.delete(id);
        return resp;
    }
}