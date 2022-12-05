package com.lin.wiki.controller;

import com.lin.wiki.req.EbookQueryReq;
import com.lin.wiki.req.EbookSaveReq;
import com.lin.wiki.resp.CommonResp;
import com.lin.wiki.resp.EbookQueryResp;
import com.lin.wiki.resp.PageResp;
import com.lin.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp getEbookList(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> ebookList = ebookService.getEbookList(req);
        resp.setContent(ebookList);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveEbook(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }
}
