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
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public CommonResp getAllCategorys( ) {
        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>();
        List<CategoryQueryResp> categoryList = categoryService.getAllCategorys();
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
