package com.lin.wiki.controller;

import com.lin.wiki.req.EbookReq;
import com.lin.wiki.resp.CommonResp;
import com.lin.wiki.resp.EbookResp;
import com.lin.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp getEbookList(EbookReq ebookReq) {
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> ebookList = ebookService.getEbookList(ebookReq);
        resp.setContent(ebookList);
        return resp;
    }
}
