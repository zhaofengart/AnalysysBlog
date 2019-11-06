package com.analysys.blog.controller;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.service.ArticleService;
import com.analysys.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */
@CrossOrigin
@RestController
@RequestMapping("/api/blog/tag")
public class TagController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    // 根据标签id显示最新文章
    @PostMapping("/")
    public JsonResult getNewestArticleByTagId(Integer tagId){
        return articleService.getNewestArticleByTagId(tagId);
    }

    // 带标签最新文章翻页
    @RequestMapping("/{tagId}/page/{pageNo}")
    public JsonResult getNewestArticleByTagIdAndPageNo(@PathVariable("tagId") Integer tagId,
                                                       @PathVariable("pageNo") Integer pageNo){
        return articleService.getNewestArticleByTagIdAndPageNo(tagId, pageNo);
    }


    @PostMapping("/getTagByTagId")
    public JsonResult getTagByTagId(Integer tagId){
        return tagService.getTagByTagId(tagId);
    }

    @RequestMapping("/getPopularTag")
    public JsonResult getPopularTag() {
        return tagService.getPopularTag();
    }

    @RequestMapping("/getAllTag")
    public JsonResult getAllTag() {
        return tagService.getAllTag();
    }

    @PostMapping("/addTag")
    public JsonResult addTag(String tagName){
        return tagService.addTag(tagName);
    }

}
