package com.lin.wiki.controller;

import com.lin.wiki.req.CategoryQueryReq;
import com.lin.wiki.req.CategorySaveReq;
import com.lin.wiki.resp.CommonResp;
import com.lin.wiki.resp.CategoryQueryResp;
import com.lin.wiki.resp.PageResp;
import com.lin.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp getCategoryList(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> categoryList = categoryService.getCategoryList(req);
        resp.setContent(categoryList);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp saveCategory(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);
        return resp;
    }
}
