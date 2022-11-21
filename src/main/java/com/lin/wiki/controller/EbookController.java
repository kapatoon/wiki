package com.lin.wiki.controller;

import com.lin.wiki.entity.Ebook;
import com.lin.wiki.service.EbookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EbookController {

    @Resource
    private EbookService ebookService;

    @RequestMapping("/ebook")
    public List<Ebook> getEbookList() {
        return ebookService.getEbookList();
    }
}
