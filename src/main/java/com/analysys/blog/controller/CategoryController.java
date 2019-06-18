package com.analysys.blog.controller;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.repository.CategoryMapper;
import com.analysys.blog.service.ArticleService;
import com.analysys.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaofeng
 * @date 2019/5/25
 */

@RestController
@RequestMapping("/api/blog/category")
public class CategoryController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    // 根据类别id获取文章
    @RequestMapping("/")
    public JsonResult getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo){
        return articleService.getArticleByCategoryIdAndPageNo(categoryId, pageNo);
    }

    @RequestMapping("/getAllCategory")
    public JsonResult getAllCategory() {
        return categoryService.getAllCategory();
    }

}
