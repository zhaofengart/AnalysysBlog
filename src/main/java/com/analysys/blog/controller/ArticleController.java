package com.analysys.blog.controller;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticleParam;
import com.analysys.blog.pojo.WangEditor;
import com.analysys.blog.service.ArticleService;
import com.analysys.blog.util.FileHandleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

@CrossOrigin
@RestController
@RequestMapping("/api/blog")
public class ArticleController extends BaseController {


    @Autowired
    private ArticleService articleService;


    // 获取最新文章
    @RequestMapping("/")
    public JsonResult getNewestArticle() {
        return articleService.getNewestArticle();
    }


    // 根据文章id获取文章
    @RequestMapping("/getArticle")
    public JsonResult getArticleByArticleId(Integer tagId, Integer categoryId, Integer articleId){
        return articleService.getArticle(tagId, categoryId, articleId);
    }


    // 不带标签的最新文章翻页
    @RequestMapping("/page/{pageNo}")
    public JsonResult getNewestArticleByPageNo(@PathVariable("pageNo") Integer pageNo){
        return articleService.getNewestArticleByPageNo(pageNo);
    }


    // 富文本上传
    @RequestMapping("/uploadMultiPartFile")
    public WangEditor uploadMultiPartFile(@RequestParam("myFile") MultipartFile multipartFile,
                                          HttpServletRequest request) throws IOException {
        return FileHandleUtil.upload(multipartFile,request);
    }



    @PostMapping("/publishArticle")
    public JsonResult publishArticle(@RequestBody ArticleParam articleParam){
        return articleService.publishArticle(articleParam);
    }


    @PostMapping("/getPopularArticle")
    public JsonResult getPopularArticle(){
        return articleService.getPopularArticle();
    }


    @RequestMapping("/getRelatedRecommendationArticles")
    public JsonResult getRelatedRecommendationArticles(Integer articleId) {
        return articleService.getRelatedRecommendationArticles(articleId);
    }


    @PostMapping("/updateArticle")
    public JsonResult updateArticle(Article article){
        return  articleService.update(article);
    }


    @RequestMapping("/getTotalNumOfArticle")
    public JsonResult getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId) {
        System.out.println(categoryId);
        System.out.println(tagId);
        return articleService.getTotalNumOfArticleByCategoryIdOrTagId(categoryId, tagId);
    }
}
