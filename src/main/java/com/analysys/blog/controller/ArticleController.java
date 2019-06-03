package com.analysys.blog.controller;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticleParam;
import com.analysys.blog.pojo.WangEditor;
import com.analysys.blog.service.ArticleService;
import com.analysys.blog.util.FileHandleUtil;
import com.analysys.blog.util.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class ArticleController extends BaseController {


    @Autowired
    private ArticleService articleService;


    // 获取最新文章
    @RequestMapping("/")
    public ReturnData getNewestArticle() {
        return articleService.getNewestArticle();
    }


    // 根据文章id获取文章
    @RequestMapping("/getArticle")
    public ReturnData getArticleByArticleId(Integer tagId, Integer categoryId, Integer articleId){
        return articleService.getArticle(tagId, categoryId, articleId);
    }


    // 不带标签的最新文章翻页
    @RequestMapping("/page/{pageNo}")
    public ReturnData getNewestArticleByPageNo(@PathVariable("pageNo") Integer pageNo){
        return articleService.getNewestArticleByPageNo(pageNo);
    }


    // 富文本上传
    @RequestMapping("/uploadMutilPartFile")
    public WangEditor uploadMutilPartFile(@RequestParam("myFile") MultipartFile multipartFile,
                                          HttpServletRequest request) throws IOException {
        return FileHandleUtil.upload(multipartFile,request);
    }



    @PostMapping("/publishArticle")
    public ReturnData publishArticle(@RequestBody ArticleParam articleParam){
        return articleService.publishArticle(articleParam);
    }

    // 测试文章内容
    @RequestMapping("/publishArticleContent")
    public ReturnData publishArticleContent(String content){
        System.out.println(content);
        return null;
    }


    @PostMapping("/getPopularArticle")
    public ReturnData getPopularArticle(){
        return articleService.getPopularArticle();
    }


    @PostMapping("/updateArticle")
    public ReturnData updateArticle(Article article){
        return  articleService.update(article);
    }


    @RequestMapping("/getTotalNumOfArticle")
    public ReturnData getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId) {
        return articleService.getTotalNumOfArticleByCategoryIdOrTagId(categoryId, tagId);
    }


}
